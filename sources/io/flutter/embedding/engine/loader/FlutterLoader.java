package io.flutter.embedding.engine.loader;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.WindowManager;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.util.PathUtils;
import io.flutter.view.VsyncWaiter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FlutterLoader {
    static final String AOT_SHARED_LIBRARY_NAME = "aot-shared-library-name";
    private static final String DEFAULT_KERNEL_BLOB = "kernel_blob.bin";
    private static final String DEFAULT_LIBRARY = "libflutter.so";
    static final String FLUTTER_ASSETS_DIR_KEY = "flutter-assets-dir";
    static final String ISOLATE_SNAPSHOT_DATA_KEY = "isolate-snapshot-data";
    static final String SNAPSHOT_ASSET_PATH_KEY = "snapshot-asset-path";
    private static final String TAG = "FlutterLoader";
    static final String VM_SNAPSHOT_DATA_KEY = "vm-snapshot-data";
    private static FlutterLoader instance;
    private FlutterApplicationInfo flutterApplicationInfo;
    Future<InitResult> initResultFuture;
    private long initStartTimestampMillis;
    private boolean initialized = false;
    private Settings settings;

    @Deprecated
    public static FlutterLoader getInstance() {
        if (instance == null) {
            instance = new FlutterLoader();
        }
        return instance;
    }

    private static class InitResult {
        final String appStoragePath;
        final String dataDirPath;
        final String engineCachesPath;

        private InitResult(String appStoragePath2, String engineCachesPath2, String dataDirPath2) {
            this.appStoragePath = appStoragePath2;
            this.engineCachesPath = engineCachesPath2;
            this.dataDirPath = dataDirPath2;
        }
    }

    public void startInitialization(Context applicationContext) {
        startInitialization(applicationContext, new Settings());
    }

    public void startInitialization(Context applicationContext, Settings settings2) {
        if (this.settings == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                final Context appContext = applicationContext.getApplicationContext();
                this.settings = settings2;
                this.initStartTimestampMillis = SystemClock.uptimeMillis();
                this.flutterApplicationInfo = ApplicationInfoLoader.load(appContext);
                VsyncWaiter.getInstance((WindowManager) appContext.getSystemService("window")).init();
                this.initResultFuture = Executors.newSingleThreadExecutor().submit(new Callable<InitResult>() {
                    public InitResult call() {
                        ResourceExtractor resourceExtractor = FlutterLoader.this.initResources(appContext);
                        if (FlutterInjector.instance().shouldLoadNative()) {
                            System.loadLibrary("flutter");
                        }
                        Executors.newSingleThreadExecutor().execute(new Runnable() {
                            public void run() {
                                FlutterJNI.nativePrefetchDefaultFontManager();
                            }
                        });
                        if (resourceExtractor != null) {
                            resourceExtractor.waitForCompletion();
                        }
                        return new InitResult(PathUtils.getFilesDir(appContext), PathUtils.getCacheDirectory(appContext), PathUtils.getDataDirectory(appContext));
                    }
                });
                return;
            }
            throw new IllegalStateException("startInitialization must be called on the main thread");
        }
    }

    public void ensureInitializationComplete(Context applicationContext, String[] args) {
        if (!this.initialized) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
            } else if (this.settings != null) {
                try {
                    InitResult result = this.initResultFuture.get();
                    List<String> shellArgs = new ArrayList<>();
                    shellArgs.add("--icu-symbol-prefix=_binary_icudtl_dat");
                    shellArgs.add("--icu-native-lib-path=" + this.flutterApplicationInfo.nativeLibraryDir + File.separator + DEFAULT_LIBRARY);
                    if (args != null) {
                        Collections.addAll(shellArgs, args);
                    }
                    String snapshotAssetPath = result.dataDirPath + File.separator + this.flutterApplicationInfo.flutterAssetsDir;
                    String kernelPath = snapshotAssetPath + File.separator + DEFAULT_KERNEL_BLOB;
                    shellArgs.add("--snapshot-asset-path=" + snapshotAssetPath);
                    shellArgs.add("--vm-snapshot-data=" + this.flutterApplicationInfo.vmSnapshotData);
                    shellArgs.add("--isolate-snapshot-data=" + this.flutterApplicationInfo.isolateSnapshotData);
                    shellArgs.add("--cache-dir-path=" + result.engineCachesPath);
                    if (!this.flutterApplicationInfo.clearTextPermitted) {
                        shellArgs.add("--disallow-insecure-connections");
                    }
                    if (this.flutterApplicationInfo.domainNetworkPolicy != null) {
                        shellArgs.add("--domain-network-policy=" + this.flutterApplicationInfo.domainNetworkPolicy);
                    }
                    if (this.settings.getLogTag() != null) {
                        shellArgs.add("--log-tag=" + this.settings.getLogTag());
                    }
                    long initTimeMillis = SystemClock.uptimeMillis() - this.initStartTimestampMillis;
                    if (FlutterInjector.instance().shouldLoadNative()) {
                        FlutterJNI.nativeInit(applicationContext, (String[]) shellArgs.toArray(new String[0]), kernelPath, result.appStoragePath, result.engineCachesPath, initTimeMillis);
                    }
                    this.initialized = true;
                } catch (Exception e) {
                    Log.e(TAG, "Flutter initialization failed.", e);
                    throw new RuntimeException(e);
                }
            } else {
                throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
            }
        }
    }

    public void ensureInitializationCompleteAsync(Context applicationContext, String[] args, Handler callbackHandler, Runnable callback) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
        } else if (this.settings == null) {
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
        } else if (this.initialized) {
            callbackHandler.post(callback);
        } else {
            final Context context = applicationContext;
            final String[] strArr = args;
            final Handler handler = callbackHandler;
            final Runnable runnable = callback;
            Executors.newSingleThreadExecutor().execute(new Runnable() {
                public void run() {
                    try {
                        InitResult initResult = FlutterLoader.this.initResultFuture.get();
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                FlutterLoader.this.ensureInitializationComplete(context.getApplicationContext(), strArr);
                                handler.post(runnable);
                            }
                        });
                    } catch (Exception e) {
                        Log.e(FlutterLoader.TAG, "Flutter initialization failed.", e);
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }

    public boolean initialized() {
        return this.initialized;
    }

    /* access modifiers changed from: private */
    public ResourceExtractor initResources(Context applicationContext) {
        ResourceExtractor resourceExtractor = new ResourceExtractor(PathUtils.getDataDirectory(applicationContext), applicationContext.getPackageName(), applicationContext.getPackageManager(), applicationContext.getResources().getAssets());
        resourceExtractor.addResource(fullAssetPathFrom(this.flutterApplicationInfo.vmSnapshotData)).addResource(fullAssetPathFrom(this.flutterApplicationInfo.isolateSnapshotData)).addResource(fullAssetPathFrom(DEFAULT_KERNEL_BLOB));
        resourceExtractor.start();
        return resourceExtractor;
    }

    public String findAppBundlePath() {
        return this.flutterApplicationInfo.flutterAssetsDir;
    }

    public String getLookupKeyForAsset(String asset) {
        return fullAssetPathFrom(asset);
    }

    public String getLookupKeyForAsset(String asset, String packageName) {
        return getLookupKeyForAsset("packages" + File.separator + packageName + File.separator + asset);
    }

    private String fullAssetPathFrom(String filePath) {
        return this.flutterApplicationInfo.flutterAssetsDir + File.separator + filePath;
    }

    public static class Settings {
        private String logTag;

        public String getLogTag() {
            return this.logTag;
        }

        public void setLogTag(String tag) {
            this.logTag = tag;
        }
    }
}
