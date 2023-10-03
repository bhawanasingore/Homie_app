package com.mr.flutter.plugin.filepicker;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.DocumentsContract;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.ActivityCompat;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class FilePickerDelegate implements PluginRegistry.ActivityResultListener, PluginRegistry.RequestPermissionsResultListener {
    private static final int REQUEST_CODE = ((FilePickerPlugin.class.hashCode() + 43) & 65535);
    private static final String TAG = "FilePickerDelegate";
    /* access modifiers changed from: private */
    public final Activity activity;
    private String[] allowedExtensions;
    /* access modifiers changed from: private */
    public EventChannel.EventSink eventSink;
    private boolean isMultipleSelection;
    /* access modifiers changed from: private */
    public boolean loadDataToMemory;
    private MethodChannel.Result pendingResult;
    private final PermissionManager permissionManager;
    /* access modifiers changed from: private */
    public String type;

    interface PermissionManager {
        void askForPermission(String str, int i);

        boolean isPermissionGranted(String str);
    }

    public FilePickerDelegate(final Activity activity2) {
        this(activity2, (MethodChannel.Result) null, new PermissionManager() {
            public boolean isPermissionGranted(String permissionName) {
                return ActivityCompat.checkSelfPermission(activity2, permissionName) == 0;
            }

            public void askForPermission(String permissionName, int requestCode) {
                ActivityCompat.requestPermissions(activity2, new String[]{permissionName}, requestCode);
            }
        });
    }

    public void setEventHandler(EventChannel.EventSink eventSink2) {
        this.eventSink = eventSink2;
    }

    @VisibleForTesting
    FilePickerDelegate(Activity activity2, MethodChannel.Result result, PermissionManager permissionManager2) {
        this.isMultipleSelection = false;
        this.loadDataToMemory = false;
        this.activity = activity2;
        this.pendingResult = result;
        this.permissionManager = permissionManager2;
    }

    public boolean onActivityResult(int requestCode, int resultCode, final Intent data) {
        if (this.type == null) {
            return false;
        }
        if (requestCode == REQUEST_CODE && resultCode == -1) {
            EventChannel.EventSink eventSink2 = this.eventSink;
            if (eventSink2 != null) {
                eventSink2.success(true);
            }
            new Thread(new Runnable() {
                public void run() {
                    if (data != null) {
                        ArrayList<FileInfo> files = new ArrayList<>();
                        if (data.getClipData() != null) {
                            int count = data.getClipData().getItemCount();
                            for (int currentItem = 0; currentItem < count; currentItem++) {
                                Uri currentUri = data.getClipData().getItemAt(currentItem).getUri();
                                FileInfo file = FileUtils.openFileStream(FilePickerDelegate.this.activity, currentUri, FilePickerDelegate.this.loadDataToMemory);
                                if (file != null) {
                                    files.add(file);
                                    Log.d(FilePickerDelegate.TAG, "[MultiFilePick] File #" + currentItem + " - URI: " + currentUri.getPath());
                                }
                            }
                            FilePickerDelegate.this.finishWithSuccess(files);
                        } else if (data.getData() != null) {
                            Uri uri = data.getData();
                            if (!FilePickerDelegate.this.type.equals("dir") || Build.VERSION.SDK_INT < 21) {
                                FileInfo file2 = FileUtils.openFileStream(FilePickerDelegate.this.activity, uri, FilePickerDelegate.this.loadDataToMemory);
                                if (file2 != null) {
                                    files.add(file2);
                                }
                                if (!files.isEmpty()) {
                                    Log.d(FilePickerDelegate.TAG, "File path:" + files.toString());
                                    FilePickerDelegate.this.finishWithSuccess(files);
                                    return;
                                }
                                FilePickerDelegate.this.finishWithError("unknown_path", "Failed to retrieve path.");
                                return;
                            }
                            Uri uri2 = DocumentsContract.buildDocumentUriUsingTree(uri, DocumentsContract.getTreeDocumentId(uri));
                            Log.d(FilePickerDelegate.TAG, "[SingleFilePick] File URI:" + uri2.toString());
                            String dirPath = FileUtils.getFullPathFromTreeUri(uri2, FilePickerDelegate.this.activity);
                            if (dirPath != null) {
                                FilePickerDelegate.this.finishWithSuccess(dirPath);
                            } else {
                                FilePickerDelegate.this.finishWithError("unknown_path", "Failed to retrieve directory path.");
                            }
                        } else {
                            FilePickerDelegate.this.finishWithError("unknown_activity", "Unknown activity error, please fill an issue.");
                        }
                    } else {
                        FilePickerDelegate.this.finishWithError("unknown_activity", "Unknown activity error, please fill an issue.");
                    }
                }
            }).start();
            return true;
        } else if (requestCode == REQUEST_CODE && resultCode == 0) {
            Log.i(TAG, "User cancelled the picker request");
            finishWithSuccess((Object) null);
            return true;
        } else {
            if (requestCode == REQUEST_CODE) {
                finishWithError("unknown_activity", "Unknown activity error, please fill an issue.");
            }
            return false;
        }
    }

    public boolean onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        boolean permissionGranted = false;
        if (REQUEST_CODE != requestCode) {
            return false;
        }
        if (grantResults.length > 0 && grantResults[0] == 0) {
            permissionGranted = true;
        }
        if (permissionGranted) {
            startFileExplorer();
        } else {
            finishWithError("read_external_storage_denied", "User did not allowed reading external storage");
        }
        return true;
    }

    private boolean setPendingMethodCallAndResult(MethodChannel.Result result) {
        if (this.pendingResult != null) {
            return false;
        }
        this.pendingResult = result;
        return true;
    }

    private static void finishWithAlreadyActiveError(MethodChannel.Result result) {
        result.error("already_active", "File picker is already active", (Object) null);
    }

    private void startFileExplorer() {
        Intent intent;
        String str = this.type;
        if (str != null) {
            if (str.equals("dir")) {
                intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            } else {
                intent = new Intent("android.intent.action.GET_CONTENT");
                Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath() + File.separator);
                Log.d(TAG, "Selected type " + this.type);
                intent.setDataAndType(uri, this.type);
                intent.setType(this.type);
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", this.isMultipleSelection);
                intent.addCategory("android.intent.category.OPENABLE");
                if (this.type.contains(",")) {
                    this.allowedExtensions = this.type.split(",");
                }
                String[] strArr = this.allowedExtensions;
                if (strArr != null) {
                    intent.putExtra("android.intent.extra.MIME_TYPES", strArr);
                }
            }
            if (intent.resolveActivity(this.activity.getPackageManager()) != null) {
                this.activity.startActivityForResult(intent, REQUEST_CODE);
                return;
            }
            Log.e(TAG, "Can't find a valid activity to handle the request. Make sure you've a file explorer installed.");
            finishWithError("invalid_format_type", "Can't handle the provided file type.");
        }
    }

    public void startFileExplorer(String type2, boolean isMultipleSelection2, boolean withData, String[] allowedExtensions2, MethodChannel.Result result) {
        if (!setPendingMethodCallAndResult(result)) {
            finishWithAlreadyActiveError(result);
            return;
        }
        this.type = type2;
        this.isMultipleSelection = isMultipleSelection2;
        this.loadDataToMemory = withData;
        this.allowedExtensions = allowedExtensions2;
        if (!this.permissionManager.isPermissionGranted("android.permission.READ_EXTERNAL_STORAGE")) {
            this.permissionManager.askForPermission("android.permission.READ_EXTERNAL_STORAGE", REQUEST_CODE);
        } else {
            startFileExplorer();
        }
    }

    /* access modifiers changed from: private */
    public void finishWithSuccess(Object data) {
        if (this.eventSink != null) {
            dispatchEventStatus(false);
        }
        if (this.pendingResult != null) {
            if (data != null && !(data instanceof String)) {
                ArrayList<HashMap<String, Object>> files = new ArrayList<>();
                Iterator it = ((ArrayList) data).iterator();
                while (it.hasNext()) {
                    files.add(((FileInfo) it.next()).toMap());
                }
                data = files;
            }
            this.pendingResult.success(data);
            clearPendingResult();
        }
    }

    /* access modifiers changed from: private */
    public void finishWithError(String errorCode, String errorMessage) {
        if (this.pendingResult != null) {
            if (this.eventSink != null) {
                dispatchEventStatus(false);
            }
            this.pendingResult.error(errorCode, errorMessage, (Object) null);
            clearPendingResult();
        }
    }

    private void dispatchEventStatus(final boolean status) {
        new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                FilePickerDelegate.this.eventSink.success(Boolean.valueOf(status));
            }
        }.obtainMessage().sendToTarget();
    }

    private void clearPendingResult() {
        this.pendingResult = null;
    }
}
