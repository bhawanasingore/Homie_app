package io.flutter.plugins.imagepicker;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

public class ImagePickerDelegate implements PluginRegistry.ActivityResultListener, PluginRegistry.RequestPermissionsResultListener {
    @VisibleForTesting
    static final int REQUEST_CAMERA_IMAGE_PERMISSION = 2345;
    @VisibleForTesting
    static final int REQUEST_CAMERA_VIDEO_PERMISSION = 2355;
    @VisibleForTesting
    static final int REQUEST_CODE_CHOOSE_IMAGE_FROM_GALLERY = 2342;
    @VisibleForTesting
    static final int REQUEST_CODE_CHOOSE_VIDEO_FROM_GALLERY = 2352;
    @VisibleForTesting
    static final int REQUEST_CODE_TAKE_IMAGE_WITH_CAMERA = 2343;
    @VisibleForTesting
    static final int REQUEST_CODE_TAKE_VIDEO_WITH_CAMERA = 2353;
    @VisibleForTesting
    static final int REQUEST_EXTERNAL_IMAGE_STORAGE_PERMISSION = 2344;
    @VisibleForTesting
    static final int REQUEST_EXTERNAL_VIDEO_STORAGE_PERMISSION = 2354;
    private final Activity activity;
    private final ImagePickerCache cache;
    private CameraDevice cameraDevice;
    private final File externalFilesDirectory;
    @VisibleForTesting
    final String fileProviderName;
    private final FileUriResolver fileUriResolver;
    private final FileUtils fileUtils;
    private final ImageResizer imageResizer;
    private final IntentResolver intentResolver;
    private MethodCall methodCall;
    private Uri pendingCameraMediaUri;
    private MethodChannel.Result pendingResult;
    private final PermissionManager permissionManager;

    interface FileUriResolver {
        void getFullImagePath(Uri uri, OnPathReadyListener onPathReadyListener);

        Uri resolveFileProviderUriForFile(String str, File file);
    }

    interface IntentResolver {
        boolean resolveActivity(Intent intent);
    }

    interface OnPathReadyListener {
        void onPathReady(String str);
    }

    interface PermissionManager {
        void askForPermission(String str, int i);

        boolean isPermissionGranted(String str);

        boolean needRequestCameraPermission();
    }

    public ImagePickerDelegate(final Activity activity2, File externalFilesDirectory2, ImageResizer imageResizer2, ImagePickerCache cache2) {
        this(activity2, externalFilesDirectory2, imageResizer2, (MethodChannel.Result) null, (MethodCall) null, cache2, new PermissionManager() {
            public boolean isPermissionGranted(String permissionName) {
                return ActivityCompat.checkSelfPermission(activity2, permissionName) == 0;
            }

            public void askForPermission(String permissionName, int requestCode) {
                ActivityCompat.requestPermissions(activity2, new String[]{permissionName}, requestCode);
            }

            public boolean needRequestCameraPermission() {
                return ImagePickerUtils.needRequestCameraPermission(activity2);
            }
        }, new IntentResolver() {
            public boolean resolveActivity(Intent intent) {
                return intent.resolveActivity(activity2.getPackageManager()) != null;
            }
        }, new FileUriResolver() {
            public Uri resolveFileProviderUriForFile(String fileProviderName, File file) {
                return FileProvider.getUriForFile(activity2, fileProviderName, file);
            }

            public void getFullImagePath(Uri imageUri, final OnPathReadyListener listener) {
                Activity activity = activity2;
                String[] strArr = new String[1];
                strArr[0] = imageUri != null ? imageUri.getPath() : "";
                MediaScannerConnection.scanFile(activity, strArr, (String[]) null, new MediaScannerConnection.OnScanCompletedListener() {
                    public void onScanCompleted(String path, Uri uri) {
                        listener.onPathReady(path);
                    }
                });
            }
        }, new FileUtils());
    }

    @VisibleForTesting
    ImagePickerDelegate(Activity activity2, File externalFilesDirectory2, ImageResizer imageResizer2, MethodChannel.Result result, MethodCall methodCall2, ImagePickerCache cache2, PermissionManager permissionManager2, IntentResolver intentResolver2, FileUriResolver fileUriResolver2, FileUtils fileUtils2) {
        this.activity = activity2;
        this.externalFilesDirectory = externalFilesDirectory2;
        this.imageResizer = imageResizer2;
        this.fileProviderName = activity2.getPackageName() + ".flutter.image_provider";
        this.pendingResult = result;
        this.methodCall = methodCall2;
        this.permissionManager = permissionManager2;
        this.intentResolver = intentResolver2;
        this.fileUriResolver = fileUriResolver2;
        this.fileUtils = fileUtils2;
        this.cache = cache2;
    }

    /* access modifiers changed from: package-private */
    public void setCameraDevice(CameraDevice device) {
        this.cameraDevice = device;
    }

    /* access modifiers changed from: package-private */
    public CameraDevice getCameraDevice() {
        return this.cameraDevice;
    }

    /* access modifiers changed from: package-private */
    public void saveStateBeforeResult() {
        MethodCall methodCall2 = this.methodCall;
        if (methodCall2 != null) {
            this.cache.saveTypeWithMethodCallName(methodCall2.method);
            this.cache.saveDimensionWithMethodCall(this.methodCall);
            Uri uri = this.pendingCameraMediaUri;
            if (uri != null) {
                this.cache.savePendingCameraMediaUriPath(uri);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void retrieveLostImage(MethodChannel.Result result) {
        int imageQuality;
        Map<String, Object> resultMap = this.cache.getCacheMap();
        String path = (String) resultMap.get("path");
        if (path != null) {
            Double maxWidth = (Double) resultMap.get("maxWidth");
            Double maxHeight = (Double) resultMap.get("maxHeight");
            if (resultMap.get("imageQuality") == null) {
                imageQuality = 100;
            } else {
                imageQuality = ((Integer) resultMap.get("imageQuality")).intValue();
            }
            resultMap.put("path", this.imageResizer.resizeImageIfNeeded(path, maxWidth, maxHeight, Integer.valueOf(imageQuality)));
        }
        if (resultMap.isEmpty()) {
            result.success((Object) null);
        } else {
            result.success(resultMap);
        }
        this.cache.clear();
    }

    public void chooseVideoFromGallery(MethodCall methodCall2, MethodChannel.Result result) {
        if (!setPendingMethodCallAndResult(methodCall2, result)) {
            finishWithAlreadyActiveError(result);
        } else if (!this.permissionManager.isPermissionGranted("android.permission.READ_EXTERNAL_STORAGE")) {
            this.permissionManager.askForPermission("android.permission.READ_EXTERNAL_STORAGE", REQUEST_EXTERNAL_VIDEO_STORAGE_PERMISSION);
        } else {
            launchPickVideoFromGalleryIntent();
        }
    }

    private void launchPickVideoFromGalleryIntent() {
        Intent pickVideoIntent = new Intent("android.intent.action.GET_CONTENT");
        pickVideoIntent.setType("video/*");
        this.activity.startActivityForResult(pickVideoIntent, REQUEST_CODE_CHOOSE_VIDEO_FROM_GALLERY);
    }

    public void takeVideoWithCamera(MethodCall methodCall2, MethodChannel.Result result) {
        if (!setPendingMethodCallAndResult(methodCall2, result)) {
            finishWithAlreadyActiveError(result);
        } else if (!needRequestCameraPermission() || this.permissionManager.isPermissionGranted("android.permission.CAMERA")) {
            launchTakeVideoWithCameraIntent();
        } else {
            this.permissionManager.askForPermission("android.permission.CAMERA", REQUEST_CAMERA_VIDEO_PERMISSION);
        }
    }

    private void launchTakeVideoWithCameraIntent() {
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        MethodCall methodCall2 = this.methodCall;
        if (!(methodCall2 == null || methodCall2.argument("maxDuration") == null)) {
            intent.putExtra("android.intent.extra.durationLimit", ((Integer) this.methodCall.argument("maxDuration")).intValue());
        }
        if (this.cameraDevice == CameraDevice.FRONT) {
            useFrontCamera(intent);
        }
        if (!this.intentResolver.resolveActivity(intent)) {
            finishWithError("no_available_camera", "No cameras available for taking pictures.");
            return;
        }
        File videoFile = createTemporaryWritableVideoFile();
        this.pendingCameraMediaUri = Uri.parse("file:" + videoFile.getAbsolutePath());
        Uri videoUri = this.fileUriResolver.resolveFileProviderUriForFile(this.fileProviderName, videoFile);
        intent.putExtra("output", videoUri);
        grantUriPermissions(intent, videoUri);
        this.activity.startActivityForResult(intent, REQUEST_CODE_TAKE_VIDEO_WITH_CAMERA);
    }

    public void chooseImageFromGallery(MethodCall methodCall2, MethodChannel.Result result) {
        if (!setPendingMethodCallAndResult(methodCall2, result)) {
            finishWithAlreadyActiveError(result);
        } else if (!this.permissionManager.isPermissionGranted("android.permission.READ_EXTERNAL_STORAGE")) {
            this.permissionManager.askForPermission("android.permission.READ_EXTERNAL_STORAGE", REQUEST_EXTERNAL_IMAGE_STORAGE_PERMISSION);
        } else {
            launchPickImageFromGalleryIntent();
        }
    }

    private void launchPickImageFromGalleryIntent() {
        Intent pickImageIntent = new Intent("android.intent.action.GET_CONTENT");
        pickImageIntent.setType("image/*");
        this.activity.startActivityForResult(pickImageIntent, REQUEST_CODE_CHOOSE_IMAGE_FROM_GALLERY);
    }

    public void takeImageWithCamera(MethodCall methodCall2, MethodChannel.Result result) {
        if (!setPendingMethodCallAndResult(methodCall2, result)) {
            finishWithAlreadyActiveError(result);
        } else if (!needRequestCameraPermission() || this.permissionManager.isPermissionGranted("android.permission.CAMERA")) {
            launchTakeImageWithCameraIntent();
        } else {
            this.permissionManager.askForPermission("android.permission.CAMERA", REQUEST_CAMERA_IMAGE_PERMISSION);
        }
    }

    private boolean needRequestCameraPermission() {
        PermissionManager permissionManager2 = this.permissionManager;
        if (permissionManager2 == null) {
            return false;
        }
        return permissionManager2.needRequestCameraPermission();
    }

    private void launchTakeImageWithCameraIntent() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (this.cameraDevice == CameraDevice.FRONT) {
            useFrontCamera(intent);
        }
        if (!this.intentResolver.resolveActivity(intent)) {
            finishWithError("no_available_camera", "No cameras available for taking pictures.");
            return;
        }
        File imageFile = createTemporaryWritableImageFile();
        this.pendingCameraMediaUri = Uri.parse("file:" + imageFile.getAbsolutePath());
        Uri imageUri = this.fileUriResolver.resolveFileProviderUriForFile(this.fileProviderName, imageFile);
        intent.putExtra("output", imageUri);
        grantUriPermissions(intent, imageUri);
        this.activity.startActivityForResult(intent, REQUEST_CODE_TAKE_IMAGE_WITH_CAMERA);
    }

    private File createTemporaryWritableImageFile() {
        return createTemporaryWritableFile(".jpg");
    }

    private File createTemporaryWritableVideoFile() {
        return createTemporaryWritableFile(".mp4");
    }

    private File createTemporaryWritableFile(String suffix) {
        try {
            return File.createTempFile(UUID.randomUUID().toString(), suffix, this.externalFilesDirectory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void grantUriPermissions(Intent intent, Uri imageUri) {
        for (ResolveInfo info : this.activity.getPackageManager().queryIntentActivities(intent, 65536)) {
            this.activity.grantUriPermission(info.activityInfo.packageName, imageUri, 3);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003c, code lost:
        if (r8 != REQUEST_CAMERA_VIDEO_PERMISSION) goto L_0x004e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onRequestPermissionsResult(int r8, java.lang.String[] r9, int[] r10) {
        /*
            r7 = this;
            int r0 = r10.length
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L_0x000b
            r0 = r10[r2]
            if (r0 != 0) goto L_0x000b
            r0 = r1
            goto L_0x000c
        L_0x000b:
            r0 = r2
        L_0x000c:
            r3 = 2355(0x933, float:3.3E-42)
            r4 = 2354(0x932, float:3.299E-42)
            r5 = 2345(0x929, float:3.286E-42)
            r6 = 2344(0x928, float:3.285E-42)
            if (r8 == r6) goto L_0x002f
            if (r8 == r5) goto L_0x0029
            if (r8 == r4) goto L_0x0023
            if (r8 == r3) goto L_0x001d
            return r2
        L_0x001d:
            if (r0 == 0) goto L_0x0034
            r7.launchTakeVideoWithCameraIntent()
            goto L_0x0034
        L_0x0023:
            if (r0 == 0) goto L_0x0034
            r7.launchPickVideoFromGalleryIntent()
            goto L_0x0034
        L_0x0029:
            if (r0 == 0) goto L_0x0034
            r7.launchTakeImageWithCameraIntent()
            goto L_0x0034
        L_0x002f:
            if (r0 == 0) goto L_0x0034
            r7.launchPickImageFromGalleryIntent()
        L_0x0034:
            if (r0 != 0) goto L_0x004e
            if (r8 == r6) goto L_0x0047
            if (r8 == r5) goto L_0x003f
            if (r8 == r4) goto L_0x0047
            if (r8 == r3) goto L_0x003f
            goto L_0x004e
        L_0x003f:
            java.lang.String r2 = "camera_access_denied"
            java.lang.String r3 = "The user did not allow camera access."
            r7.finishWithError(r2, r3)
            goto L_0x004e
        L_0x0047:
            java.lang.String r2 = "photo_access_denied"
            java.lang.String r3 = "The user did not allow photo access."
            r7.finishWithError(r2, r3)
        L_0x004e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.imagepicker.ImagePickerDelegate.onRequestPermissionsResult(int, java.lang.String[], int[]):boolean");
    }

    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_CHOOSE_IMAGE_FROM_GALLERY) {
            handleChooseImageResult(resultCode, data);
            return true;
        } else if (requestCode == REQUEST_CODE_TAKE_IMAGE_WITH_CAMERA) {
            handleCaptureImageResult(resultCode);
            return true;
        } else if (requestCode == REQUEST_CODE_CHOOSE_VIDEO_FROM_GALLERY) {
            handleChooseVideoResult(resultCode, data);
            return true;
        } else if (requestCode != REQUEST_CODE_TAKE_VIDEO_WITH_CAMERA) {
            return false;
        } else {
            handleCaptureVideoResult(resultCode);
            return true;
        }
    }

    private void handleChooseImageResult(int resultCode, Intent data) {
        if (resultCode != -1 || data == null) {
            finishWithSuccess((String) null);
        } else {
            handleImageResult(this.fileUtils.getPathFromUri(this.activity, data.getData()), false);
        }
    }

    private void handleChooseVideoResult(int resultCode, Intent data) {
        if (resultCode != -1 || data == null) {
            finishWithSuccess((String) null);
        } else {
            handleVideoResult(this.fileUtils.getPathFromUri(this.activity, data.getData()));
        }
    }

    private void handleCaptureImageResult(int resultCode) {
        if (resultCode == -1) {
            FileUriResolver fileUriResolver2 = this.fileUriResolver;
            Uri uri = this.pendingCameraMediaUri;
            if (uri == null) {
                uri = Uri.parse(this.cache.retrievePendingCameraMediaUriPath());
            }
            fileUriResolver2.getFullImagePath(uri, new OnPathReadyListener() {
                public void onPathReady(String path) {
                    ImagePickerDelegate.this.handleImageResult(path, true);
                }
            });
            return;
        }
        finishWithSuccess((String) null);
    }

    private void handleCaptureVideoResult(int resultCode) {
        if (resultCode == -1) {
            FileUriResolver fileUriResolver2 = this.fileUriResolver;
            Uri uri = this.pendingCameraMediaUri;
            if (uri == null) {
                uri = Uri.parse(this.cache.retrievePendingCameraMediaUriPath());
            }
            fileUriResolver2.getFullImagePath(uri, new OnPathReadyListener() {
                public void onPathReady(String path) {
                    ImagePickerDelegate.this.handleVideoResult(path);
                }
            });
            return;
        }
        finishWithSuccess((String) null);
    }

    /* access modifiers changed from: private */
    public void handleImageResult(String path, boolean shouldDeleteOriginalIfScaled) {
        MethodCall methodCall2 = this.methodCall;
        if (methodCall2 != null) {
            String finalImagePath = this.imageResizer.resizeImageIfNeeded(path, (Double) methodCall2.argument("maxWidth"), (Double) this.methodCall.argument("maxHeight"), (Integer) this.methodCall.argument("imageQuality"));
            finishWithSuccess(finalImagePath);
            if (finalImagePath != null && !finalImagePath.equals(path) && shouldDeleteOriginalIfScaled) {
                new File(path).delete();
                return;
            }
            return;
        }
        finishWithSuccess(path);
    }

    /* access modifiers changed from: private */
    public void handleVideoResult(String path) {
        finishWithSuccess(path);
    }

    private boolean setPendingMethodCallAndResult(MethodCall methodCall2, MethodChannel.Result result) {
        if (this.pendingResult != null) {
            return false;
        }
        this.methodCall = methodCall2;
        this.pendingResult = result;
        this.cache.clear();
        return true;
    }

    private void finishWithSuccess(String imagePath) {
        MethodChannel.Result result = this.pendingResult;
        if (result == null) {
            this.cache.saveResult(imagePath, (String) null, (String) null);
            return;
        }
        result.success(imagePath);
        clearMethodCallAndResult();
    }

    private void finishWithAlreadyActiveError(MethodChannel.Result result) {
        result.error("already_active", "Image picker is already active", (Object) null);
    }

    private void finishWithError(String errorCode, String errorMessage) {
        MethodChannel.Result result = this.pendingResult;
        if (result == null) {
            this.cache.saveResult((String) null, errorCode, errorMessage);
            return;
        }
        result.error(errorCode, errorMessage, (Object) null);
        clearMethodCallAndResult();
    }

    private void clearMethodCallAndResult() {
        this.methodCall = null;
        this.pendingResult = null;
    }

    private void useFrontCamera(Intent intent) {
        if (Build.VERSION.SDK_INT >= 22) {
            intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
            if (Build.VERSION.SDK_INT >= 26) {
                intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
                return;
            }
            return;
        }
        intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
    }
}
