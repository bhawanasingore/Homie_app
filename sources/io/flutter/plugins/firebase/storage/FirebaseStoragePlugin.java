package io.flutter.plugins.firebase.storage;

import android.content.Context;
import android.net.Uri;
import android.util.SparseArray;
import android.webkit.MimeTypeMap;
import androidx.annotation.NonNull;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnPausedListener;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageException;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.firebase.auth.Constants;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FirebaseStoragePlugin implements MethodChannel.MethodCallHandler, FlutterPlugin {
    private FirebaseStorage firebaseStorage;
    private MethodChannel methodChannel;
    private int nextUploadHandle = 0;
    /* access modifiers changed from: private */
    public final SparseArray<UploadTask> uploadTasks = new SparseArray<>();

    private enum StorageTaskEventType {
        resume,
        progress,
        pause,
        success,
        failure
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new FirebaseStoragePlugin().onAttachedToEngine(registrar.context(), registrar.messenger());
    }

    private void onAttachedToEngine(Context applicationContext, BinaryMessenger binaryMessenger) {
        MethodChannel methodChannel2 = new MethodChannel(binaryMessenger, "plugins.flutter.io/firebase_storage");
        this.methodChannel = methodChannel2;
        methodChannel2.setMethodCallHandler(this);
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        onAttachedToEngine(binding.getApplicationContext(), binding.getBinaryMessenger());
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        this.firebaseStorage = null;
        this.methodChannel = null;
    }

    public void onMethodCall(@NonNull MethodCall call, @NonNull MethodChannel.Result result) {
        String app = (String) call.argument("app");
        String storageBucket = (String) call.argument("bucket");
        if (app == null && storageBucket == null) {
            this.firebaseStorage = FirebaseStorage.getInstance();
        } else if (storageBucket == null) {
            this.firebaseStorage = FirebaseStorage.getInstance(FirebaseApp.getInstance(app));
        } else if (app == null) {
            this.firebaseStorage = FirebaseStorage.getInstance(storageBucket);
        } else {
            this.firebaseStorage = FirebaseStorage.getInstance(FirebaseApp.getInstance(app), storageBucket);
        }
        String str = call.method;
        char c = 65535;
        switch (str.hashCode()) {
            case -2024102084:
                if (str.equals("FirebaseStorage#setMaxDownloadRetryTime")) {
                    c = 3;
                    break;
                }
                break;
            case -1728797875:
                if (str.equals("StorageReference#getBucket")) {
                    c = 11;
                    break;
                }
                break;
            case -1547456930:
                if (str.equals("StorageReference#delete")) {
                    c = 10;
                    break;
                }
                break;
            case -1130756917:
                if (str.equals("StorageReference#updateMetadata")) {
                    c = 16;
                    break;
                }
                break;
            case -80766367:
                if (str.equals("FirebaseStorage#getReferenceFromUrl")) {
                    c = 6;
                    break;
                }
                break;
            case 195789399:
                if (str.equals("UploadTask#cancel")) {
                    c = 20;
                    break;
                }
                break;
            case 218593328:
                if (str.equals("FirebaseStorage#getMaxDownloadRetryTime")) {
                    c = 0;
                    break;
                }
                break;
            case 354124195:
                if (str.equals("FirebaseStorage#setMaxUploadRetryTime")) {
                    c = 4;
                    break;
                }
                break;
            case 629087242:
                if (str.equals("UploadTask#resume")) {
                    c = 19;
                    break;
                }
                break;
            case 892625988:
                if (str.equals("StorageReference#getDownloadUrl")) {
                    c = 14;
                    break;
                }
                break;
            case 1243221119:
                if (str.equals("FirebaseStorage#setMaxOperationRetryTime")) {
                    c = 5;
                    break;
                }
                break;
            case 1542349433:
                if (str.equals("UploadTask#pause")) {
                    c = 18;
                    break;
                }
                break;
            case 1737929347:
                if (str.equals("StorageReference#writeToFile")) {
                    c = 17;
                    break;
                }
                break;
            case 1798038790:
                if (str.equals("StorageReference#putData")) {
                    c = 8;
                    break;
                }
                break;
            case 1798105816:
                if (str.equals("StorageReference#putFile")) {
                    c = 7;
                    break;
                }
                break;
            case 1930889170:
                if (str.equals("StorageReference#getMetadata")) {
                    c = 15;
                    break;
                }
                break;
            case 1942373837:
                if (str.equals("StorageReference#getData")) {
                    c = 9;
                    break;
                }
                break;
            case 1942671534:
                if (str.equals("StorageReference#getName")) {
                    c = 12;
                    break;
                }
                break;
            case 1942731336:
                if (str.equals("StorageReference#getPath")) {
                    c = 13;
                    break;
                }
                break;
            case 2047302155:
                if (str.equals("FirebaseStorage#getMaxOperationRetryTime")) {
                    c = 2;
                    break;
                }
                break;
            case 2112880535:
                if (str.equals("FirebaseStorage#getMaxUploadRetryTime")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                result.success(Long.valueOf(this.firebaseStorage.getMaxDownloadRetryTimeMillis()));
                return;
            case 1:
                result.success(Long.valueOf(this.firebaseStorage.getMaxUploadRetryTimeMillis()));
                return;
            case 2:
                result.success(Long.valueOf(this.firebaseStorage.getMaxOperationRetryTimeMillis()));
                return;
            case 3:
                setMaxDownloadRetryTimeMillis(call, result);
                return;
            case 4:
                setMaxUploadRetryTimeMillis(call, result);
                return;
            case 5:
                setMaxOperationTimeMillis(call, result);
                return;
            case 6:
                getReferenceFromUrl(call, result);
                return;
            case 7:
                putFile(call, result);
                return;
            case 8:
                putData(call, result);
                return;
            case 9:
                getData(call, result);
                return;
            case 10:
                delete(call, result);
                return;
            case 11:
                getBucket(call, result);
                return;
            case 12:
                getName(call, result);
                return;
            case 13:
                getPath(call, result);
                return;
            case 14:
                getDownloadUrl(call, result);
                return;
            case 15:
                getMetadata(call, result);
                return;
            case 16:
                updateMetadata(call, result);
                return;
            case 17:
                writeToFile(call, result);
                return;
            case 18:
                pauseUploadTask(call, result);
                return;
            case 19:
                resumeUploadTask(call, result);
                return;
            case 20:
                cancelUploadTask(call, result);
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    private void setMaxDownloadRetryTimeMillis(MethodCall call, MethodChannel.Result result) {
        this.firebaseStorage.setMaxDownloadRetryTimeMillis(((Number) call.argument("time")).longValue());
        result.success((Object) null);
    }

    private void setMaxUploadRetryTimeMillis(MethodCall call, MethodChannel.Result result) {
        this.firebaseStorage.setMaxUploadRetryTimeMillis(((Number) call.argument("time")).longValue());
        result.success((Object) null);
    }

    private void setMaxOperationTimeMillis(MethodCall call, MethodChannel.Result result) {
        this.firebaseStorage.setMaxOperationRetryTimeMillis(((Number) call.argument("time")).longValue());
        result.success((Object) null);
    }

    private void getReferenceFromUrl(MethodCall call, MethodChannel.Result result) {
        StorageReference ref = this.firebaseStorage.getReferenceFromUrl((String) call.argument("fullUrl"));
        result.success(ref != null ? ref.getPath() : null);
    }

    private void getMetadata(MethodCall call, final MethodChannel.Result result) {
        StorageReference ref = this.firebaseStorage.getReference();
        String path = (String) call.argument("path");
        if (!path.isEmpty()) {
            ref = ref.child(path);
        }
        ref.getMetadata().addOnSuccessListener(new OnSuccessListener<StorageMetadata>() {
            public void onSuccess(StorageMetadata storageMetadata) {
                result.success(FirebaseStoragePlugin.this.buildMapFromMetadata(storageMetadata));
            }
        }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(@NonNull Exception e) {
                result.error("metadata_error", e.getMessage(), (Object) null);
            }
        });
    }

    private void updateMetadata(MethodCall call, final MethodChannel.Result result) {
        StorageReference ref = this.firebaseStorage.getReference();
        String path = (String) call.argument("path");
        if (!path.isEmpty()) {
            ref = ref.child(path);
        }
        ref.updateMetadata(buildMetadataFromMap((Map) call.argument(Constants.METADATA))).addOnSuccessListener(new OnSuccessListener<StorageMetadata>() {
            public void onSuccess(StorageMetadata storageMetadata) {
                result.success(FirebaseStoragePlugin.this.buildMapFromMetadata(storageMetadata));
            }
        }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(@NonNull Exception e) {
                result.error("metadata_error", e.getMessage(), (Object) null);
            }
        });
    }

    private void getBucket(MethodCall call, MethodChannel.Result result) {
        StorageReference ref = this.firebaseStorage.getReference();
        String path = (String) call.argument("path");
        if (!path.isEmpty()) {
            ref = ref.child(path);
        }
        result.success(ref.getBucket());
    }

    private void getName(MethodCall call, MethodChannel.Result result) {
        result.success(this.firebaseStorage.getReference().child((String) call.argument("path")).getName());
    }

    private void getPath(MethodCall call, MethodChannel.Result result) {
        result.success(this.firebaseStorage.getReference().child((String) call.argument("path")).getPath());
    }

    private void getDownloadUrl(MethodCall call, final MethodChannel.Result result) {
        this.firebaseStorage.getReference().child((String) call.argument("path")).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            public void onSuccess(Uri uri) {
                result.success(uri.toString());
            }
        }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(@NonNull Exception e) {
                result.error("download_error", e.getMessage(), (Object) null);
            }
        });
    }

    private void delete(MethodCall call, final MethodChannel.Result result) {
        Task<Void> deleteTask = this.firebaseStorage.getReference().child((String) call.argument("path")).delete();
        deleteTask.addOnSuccessListener(new OnSuccessListener<Void>() {
            public void onSuccess(Void aVoid) {
                result.success((Object) null);
            }
        });
        deleteTask.addOnFailureListener(new OnFailureListener() {
            public void onFailure(@NonNull Exception e) {
                result.error("deletion_error", e.getMessage(), (Object) null);
            }
        });
    }

    private void putFile(MethodCall call, MethodChannel.Result result) {
        Uri fileUri = Uri.fromFile(new File((String) call.argument("filename")));
        Map<String, Object> metadata = ensureMimeType((Map) call.argument(Constants.METADATA), fileUri);
        result.success(Integer.valueOf(addUploadListeners(this.firebaseStorage.getReference().child((String) call.argument("path")).putFile(fileUri, buildMetadataFromMap(metadata)))));
    }

    private void putData(MethodCall call, MethodChannel.Result result) {
        UploadTask uploadTask;
        byte[] bytes = (byte[]) call.argument("data");
        Map<String, Object> metadata = (Map) call.argument(Constants.METADATA);
        StorageReference ref = this.firebaseStorage.getReference().child((String) call.argument("path"));
        if (metadata == null) {
            uploadTask = ref.putBytes(bytes);
        } else {
            uploadTask = ref.putBytes(bytes, buildMetadataFromMap(metadata));
        }
        result.success(Integer.valueOf(addUploadListeners(uploadTask)));
    }

    private StorageMetadata buildMetadataFromMap(Map<String, Object> map) {
        StorageMetadata.Builder builder = new StorageMetadata.Builder();
        builder.setCacheControl((String) map.get("cacheControl"));
        builder.setContentEncoding((String) map.get("contentEncoding"));
        builder.setContentDisposition((String) map.get("contentDisposition"));
        builder.setContentLanguage((String) map.get("contentLanguage"));
        builder.setContentType((String) map.get("contentType"));
        Map<String, String> customMetadata = (Map) map.get("customMetadata");
        if (customMetadata != null) {
            for (String key : customMetadata.keySet()) {
                builder.setCustomMetadata(key, customMetadata.get(key));
            }
        }
        return builder.build();
    }

    /* access modifiers changed from: private */
    public Map<String, Object> buildMapFromMetadata(StorageMetadata storageMetadata) {
        Map<String, Object> map = new HashMap<>();
        map.put(AppMeasurementSdk.ConditionalUserProperty.NAME, storageMetadata.getName());
        map.put("bucket", storageMetadata.getBucket());
        map.put("generation", storageMetadata.getGeneration());
        map.put("metadataGeneration", storageMetadata.getMetadataGeneration());
        map.put("path", storageMetadata.getPath());
        map.put("sizeBytes", Long.valueOf(storageMetadata.getSizeBytes()));
        map.put("creationTimeMillis", Long.valueOf(storageMetadata.getCreationTimeMillis()));
        map.put("updatedTimeMillis", Long.valueOf(storageMetadata.getUpdatedTimeMillis()));
        map.put("md5Hash", storageMetadata.getMd5Hash());
        map.put("cacheControl", storageMetadata.getCacheControl());
        map.put("contentDisposition", storageMetadata.getContentDisposition());
        map.put("contentEncoding", storageMetadata.getContentEncoding());
        map.put("contentLanguage", storageMetadata.getContentLanguage());
        map.put("contentType", storageMetadata.getContentType());
        Map<String, String> customMetadata = new HashMap<>();
        for (String key : storageMetadata.getCustomMetadataKeys()) {
            customMetadata.put(key, storageMetadata.getCustomMetadata(key));
        }
        map.put("customMetadata", customMetadata);
        return map;
    }

    private void getData(MethodCall call, final MethodChannel.Result result) {
        Task<byte[]> downloadTask = this.firebaseStorage.getReference().child((String) call.argument("path")).getBytes((long) ((Integer) call.argument("maxSize")).intValue());
        downloadTask.addOnSuccessListener(new OnSuccessListener<byte[]>() {
            public void onSuccess(byte[] bytes) {
                result.success(bytes);
            }
        });
        downloadTask.addOnFailureListener(new OnFailureListener() {
            public void onFailure(@NonNull Exception e) {
                result.error("download_error", e.getMessage(), (Object) null);
            }
        });
    }

    private void writeToFile(MethodCall call, final MethodChannel.Result result) {
        FileDownloadTask downloadTask = this.firebaseStorage.getReference().child((String) call.argument("path")).getFile(new File((String) call.argument("filePath")));
        downloadTask.addOnSuccessListener((OnSuccessListener) new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                result.success(Long.valueOf(taskSnapshot.getTotalByteCount()));
            }
        });
        downloadTask.addOnFailureListener((OnFailureListener) new OnFailureListener() {
            public void onFailure(@NonNull Exception e) {
                result.error("download_error", e.getMessage(), (Object) null);
            }
        });
    }

    private void pauseUploadTask(MethodCall call, MethodChannel.Result result) {
        UploadTask task = this.uploadTasks.get(((Integer) call.argument(Constants.HANDLE)).intValue());
        if (task != null) {
            task.pause();
            result.success((Object) null);
            return;
        }
        result.error("pause_error", "task == null", (Object) null);
    }

    private void cancelUploadTask(MethodCall call, MethodChannel.Result result) {
        UploadTask task = this.uploadTasks.get(((Integer) call.argument(Constants.HANDLE)).intValue());
        if (task != null) {
            task.cancel();
            result.success((Object) null);
            return;
        }
        result.error("cancel_error", "task == null", (Object) null);
    }

    private void resumeUploadTask(MethodCall call, @NonNull MethodChannel.Result result) {
        UploadTask task = this.uploadTasks.get(((Integer) call.argument(Constants.HANDLE)).intValue());
        if (task != null) {
            task.resume();
            result.success((Object) null);
            return;
        }
        result.error("resume_error", "task == null", (Object) null);
    }

    private int addUploadListeners(final UploadTask uploadTask) {
        final int handle = this.nextUploadHandle + 1;
        this.nextUploadHandle = handle;
        uploadTask.addOnProgressListener((OnProgressListener) new OnProgressListener<UploadTask.TaskSnapshot>() {
            public void onProgress(UploadTask.TaskSnapshot snapshot) {
                FirebaseStoragePlugin.this.invokeStorageTaskEvent(handle, StorageTaskEventType.progress, snapshot, (StorageException) null);
            }
        }).addOnPausedListener((OnPausedListener) new OnPausedListener<UploadTask.TaskSnapshot>() {
            public void onPaused(UploadTask.TaskSnapshot snapshot) {
                FirebaseStoragePlugin.this.invokeStorageTaskEvent(handle, StorageTaskEventType.pause, snapshot, (StorageException) null);
            }
        }).addOnCompleteListener((OnCompleteListener) new OnCompleteListener<UploadTask.TaskSnapshot>() {
            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                if (!task.isSuccessful()) {
                    FirebaseStoragePlugin.this.invokeStorageTaskEvent(handle, StorageTaskEventType.failure, (UploadTask.TaskSnapshot) uploadTask.getSnapshot(), (StorageException) task.getException());
                } else {
                    FirebaseStoragePlugin.this.invokeStorageTaskEvent(handle, StorageTaskEventType.success, task.getResult(), (StorageException) null);
                }
                FirebaseStoragePlugin.this.uploadTasks.remove(handle);
            }
        });
        this.uploadTasks.put(handle, uploadTask);
        return handle;
    }

    /* access modifiers changed from: private */
    public void invokeStorageTaskEvent(int handle, StorageTaskEventType type, UploadTask.TaskSnapshot snapshot, StorageException error) {
        this.methodChannel.invokeMethod("StorageTaskEvent", buildMapFromTaskEvent(handle, type, snapshot, error));
    }

    private Map<String, Object> buildMapFromTaskEvent(int handle, StorageTaskEventType type, UploadTask.TaskSnapshot snapshot, StorageException error) {
        Map<String, Object> map = new HashMap<>();
        map.put(Constants.HANDLE, Integer.valueOf(handle));
        map.put("type", Integer.valueOf(type.ordinal()));
        map.put("snapshot", buildMapFromTaskSnapshot(snapshot, error));
        return map;
    }

    private Map<String, Object> buildMapFromTaskSnapshot(UploadTask.TaskSnapshot snapshot, StorageException error) {
        Map<String, Object> map = new HashMap<>();
        map.put("bytesTransferred", Long.valueOf(snapshot.getBytesTransferred()));
        map.put("totalByteCount", Long.valueOf(snapshot.getTotalByteCount()));
        if (snapshot.getUploadSessionUri() != null) {
            map.put("uploadSessionUri", snapshot.getUploadSessionUri().toString());
        }
        if (error != null) {
            map.put("error", Integer.valueOf(error.getErrorCode()));
        }
        if (snapshot.getMetadata() != null) {
            map.put("storageMetadata", buildMapFromMetadata(snapshot.getMetadata()));
        }
        return map;
    }

    private Map<String, Object> ensureMimeType(Map<String, Object> metadata, Uri file) {
        if (metadata == null) {
            metadata = new HashMap<>();
        }
        if (metadata.get("contentType") == null) {
            metadata.put("contentType", getMimeType(file));
        }
        return metadata;
    }

    private static String getMimeType(Uri file) {
        String extension = MimeTypeMap.getFileExtensionFromUrl(file.toString());
        if (extension != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
        }
        return null;
    }
}
