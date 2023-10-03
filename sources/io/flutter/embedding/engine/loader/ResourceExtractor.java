package io.flutter.embedding.engine.loader;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

class ResourceExtractor {
    private static final String[] SUPPORTED_ABIS = getSupportedAbis();
    private static final String TAG = "ResourceExtractor";
    private static final String TIMESTAMP_PREFIX = "res_timestamp-";
    private final AssetManager mAssetManager;
    private final String mDataDirPath;
    private ExtractTask mExtractTask;
    private final PackageManager mPackageManager;
    private final String mPackageName;
    private final HashSet<String> mResources = new HashSet<>();

    static long getVersionCode(PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return packageInfo.getLongVersionCode();
        }
        return (long) packageInfo.versionCode;
    }

    private static class ExtractTask extends AsyncTask<Void, Void, Void> {
        private final AssetManager mAssetManager;
        private final String mDataDirPath;
        private final PackageManager mPackageManager;
        private final String mPackageName;
        private final HashSet<String> mResources;

        ExtractTask(String dataDirPath, HashSet<String> resources, String packageName, PackageManager packageManager, AssetManager assetManager) {
            this.mDataDirPath = dataDirPath;
            this.mResources = resources;
            this.mAssetManager = assetManager;
            this.mPackageName = packageName;
            this.mPackageManager = packageManager;
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... unused) {
            File dataDir = new File(this.mDataDirPath);
            String timestamp = ResourceExtractor.checkTimestamp(dataDir, this.mPackageManager, this.mPackageName);
            if (timestamp == null) {
                return null;
            }
            ResourceExtractor.deleteFiles(this.mDataDirPath, this.mResources);
            if (extractAPK(dataDir) && timestamp != null) {
                try {
                    new File(dataDir, timestamp).createNewFile();
                } catch (IOException e) {
                    Log.w(ResourceExtractor.TAG, "Failed to write resource timestamp");
                }
            }
            return null;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x006d, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            r6.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0072, code lost:
            r9 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            r7.addSuppressed(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0076, code lost:
            throw r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0079, code lost:
            r7 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x007a, code lost:
            if (r5 != null) goto L_0x007c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
            r5.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0084, code lost:
            throw r7;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean extractAPK(java.io.File r11) {
            /*
                r10 = this;
                java.lang.String r0 = "ResourceExtractor"
                java.util.HashSet<java.lang.String> r1 = r10.mResources
                java.util.Iterator r1 = r1.iterator()
            L_0x0008:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x00aa
                java.lang.Object r2 = r1.next()
                java.lang.String r2 = (java.lang.String) r2
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00a7, IOException -> 0x0085 }
                r3.<init>()     // Catch:{ FileNotFoundException -> 0x00a7, IOException -> 0x0085 }
                java.lang.String r4 = "assets/"
                r3.append(r4)     // Catch:{ FileNotFoundException -> 0x00a7, IOException -> 0x0085 }
                r3.append(r2)     // Catch:{ FileNotFoundException -> 0x00a7, IOException -> 0x0085 }
                java.lang.String r3 = r3.toString()     // Catch:{ FileNotFoundException -> 0x00a7, IOException -> 0x0085 }
                java.io.File r4 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00a7, IOException -> 0x0085 }
                r4.<init>(r11, r2)     // Catch:{ FileNotFoundException -> 0x00a7, IOException -> 0x0085 }
                boolean r5 = r4.exists()     // Catch:{ FileNotFoundException -> 0x00a7, IOException -> 0x0085 }
                if (r5 == 0) goto L_0x0031
                goto L_0x0008
            L_0x0031:
                java.io.File r5 = r4.getParentFile()     // Catch:{ FileNotFoundException -> 0x00a7, IOException -> 0x0085 }
                if (r5 == 0) goto L_0x003e
                java.io.File r5 = r4.getParentFile()     // Catch:{ FileNotFoundException -> 0x00a7, IOException -> 0x0085 }
                r5.mkdirs()     // Catch:{ FileNotFoundException -> 0x00a7, IOException -> 0x0085 }
            L_0x003e:
                android.content.res.AssetManager r5 = r10.mAssetManager     // Catch:{ FileNotFoundException -> 0x00a7, IOException -> 0x0085 }
                java.io.InputStream r5 = r5.open(r2)     // Catch:{ FileNotFoundException -> 0x00a7, IOException -> 0x0085 }
                java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ all -> 0x0077 }
                r6.<init>(r4)     // Catch:{ all -> 0x0077 }
                io.flutter.embedding.engine.loader.ResourceExtractor.copy(r5, r6)     // Catch:{ all -> 0x006b }
                r6.close()     // Catch:{ all -> 0x0077 }
                if (r5 == 0) goto L_0x0055
                r5.close()     // Catch:{ FileNotFoundException -> 0x00a7, IOException -> 0x0085 }
            L_0x0055:
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00a7, IOException -> 0x0085 }
                r5.<init>()     // Catch:{ FileNotFoundException -> 0x00a7, IOException -> 0x0085 }
                java.lang.String r6 = "Extracted baseline resource "
                r5.append(r6)     // Catch:{ FileNotFoundException -> 0x00a7, IOException -> 0x0085 }
                r5.append(r3)     // Catch:{ FileNotFoundException -> 0x00a7, IOException -> 0x0085 }
                java.lang.String r5 = r5.toString()     // Catch:{ FileNotFoundException -> 0x00a7, IOException -> 0x0085 }
                android.util.Log.i(r0, r5)     // Catch:{ FileNotFoundException -> 0x00a7, IOException -> 0x0085 }
                goto L_0x0008
            L_0x006b:
                r7 = move-exception
                throw r7     // Catch:{ all -> 0x006d }
            L_0x006d:
                r8 = move-exception
                r6.close()     // Catch:{ all -> 0x0072 }
                goto L_0x0076
            L_0x0072:
                r9 = move-exception
                r7.addSuppressed(r9)     // Catch:{ all -> 0x0077 }
            L_0x0076:
                throw r8     // Catch:{ all -> 0x0077 }
            L_0x0077:
                r6 = move-exception
                throw r6     // Catch:{ all -> 0x0079 }
            L_0x0079:
                r7 = move-exception
                if (r5 == 0) goto L_0x0084
                r5.close()     // Catch:{ all -> 0x0080 }
                goto L_0x0084
            L_0x0080:
                r8 = move-exception
                r6.addSuppressed(r8)     // Catch:{ FileNotFoundException -> 0x00a7, IOException -> 0x0085 }
            L_0x0084:
                throw r7     // Catch:{ FileNotFoundException -> 0x00a7, IOException -> 0x0085 }
            L_0x0085:
                r1 = move-exception
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Exception unpacking resources: "
                r3.append(r4)
                java.lang.String r4 = r1.getMessage()
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                android.util.Log.w(r0, r3)
                java.lang.String r0 = r10.mDataDirPath
                java.util.HashSet<java.lang.String> r3 = r10.mResources
                io.flutter.embedding.engine.loader.ResourceExtractor.deleteFiles(r0, r3)
                r0 = 0
                return r0
            L_0x00a7:
                r3 = move-exception
                goto L_0x0008
            L_0x00aa:
                r0 = 1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.loader.ResourceExtractor.ExtractTask.extractAPK(java.io.File):boolean");
        }
    }

    ResourceExtractor(String dataDirPath, String packageName, PackageManager packageManager, AssetManager assetManager) {
        this.mDataDirPath = dataDirPath;
        this.mPackageName = packageName;
        this.mPackageManager = packageManager;
        this.mAssetManager = assetManager;
    }

    /* access modifiers changed from: package-private */
    public ResourceExtractor addResource(String resource) {
        this.mResources.add(resource);
        return this;
    }

    /* access modifiers changed from: package-private */
    public ResourceExtractor addResources(Collection<String> resources) {
        this.mResources.addAll(resources);
        return this;
    }

    /* access modifiers changed from: package-private */
    public ResourceExtractor start() {
        if (this.mExtractTask != null) {
            Log.e(TAG, "Attempted to start resource extraction while another extraction was in progress.");
        }
        ExtractTask extractTask = new ExtractTask(this.mDataDirPath, this.mResources, this.mPackageName, this.mPackageManager, this.mAssetManager);
        this.mExtractTask = extractTask;
        extractTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void waitForCompletion() {
        ExtractTask extractTask = this.mExtractTask;
        if (extractTask != null) {
            try {
                extractTask.get();
            } catch (InterruptedException | CancellationException | ExecutionException e) {
                deleteFiles(this.mDataDirPath, this.mResources);
            }
        }
    }

    private static String[] getExistingTimestamps(File dataDir) {
        return dataDir.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.startsWith(ResourceExtractor.TIMESTAMP_PREFIX);
            }
        });
    }

    /* access modifiers changed from: private */
    public static void deleteFiles(String dataDirPath, HashSet<String> resources) {
        File dataDir = new File(dataDirPath);
        Iterator<String> it = resources.iterator();
        while (it.hasNext()) {
            File file = new File(dataDir, it.next());
            if (file.exists()) {
                file.delete();
            }
        }
        String[] existingTimestamps = getExistingTimestamps(dataDir);
        if (existingTimestamps != null) {
            for (String timestamp : existingTimestamps) {
                new File(dataDir, timestamp).delete();
            }
        }
    }

    /* access modifiers changed from: private */
    public static String checkTimestamp(File dataDir, PackageManager packageManager, String packageName) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            if (packageInfo == null) {
                return TIMESTAMP_PREFIX;
            }
            String expectedTimestamp = TIMESTAMP_PREFIX + getVersionCode(packageInfo) + "-" + packageInfo.lastUpdateTime;
            String[] existingTimestamps = getExistingTimestamps(dataDir);
            if (existingTimestamps == null) {
                Log.i(TAG, "No extracted resources found");
                return expectedTimestamp;
            }
            if (existingTimestamps.length == 1) {
                Log.i(TAG, "Found extracted resources " + existingTimestamps[0]);
            }
            if (existingTimestamps.length == 1 && expectedTimestamp.equals(existingTimestamps[0])) {
                return null;
            }
            Log.i(TAG, "Resource version mismatch " + expectedTimestamp);
            return expectedTimestamp;
        } catch (PackageManager.NameNotFoundException e) {
            return TIMESTAMP_PREFIX;
        }
    }

    /* access modifiers changed from: private */
    public static void copy(InputStream in, OutputStream out) throws IOException {
        byte[] buf = new byte[16384];
        while (true) {
            int read = in.read(buf);
            int i = read;
            if (read >= 0) {
                out.write(buf, 0, i);
            } else {
                return;
            }
        }
    }

    private static String[] getSupportedAbis() {
        if (Build.VERSION.SDK_INT >= 21) {
            return Build.SUPPORTED_ABIS;
        }
        ArrayList<String> cpuAbis = new ArrayList<>(Arrays.asList(new String[]{Build.CPU_ABI, Build.CPU_ABI2}));
        cpuAbis.removeAll(Arrays.asList(new String[]{null, ""}));
        return (String[]) cpuAbis.toArray(new String[0]);
    }
}
