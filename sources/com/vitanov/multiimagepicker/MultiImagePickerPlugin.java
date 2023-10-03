package com.vitanov.multiimagepicker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sangcomz.fishbun.FishBun;
import com.sangcomz.fishbun.FishBunCreator;
import com.sangcomz.fishbun.adapter.image.impl.GlideAdapter;
import com.sangcomz.fishbun.define.Define;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MultiImagePickerPlugin implements FlutterPlugin, ActivityAware, MethodChannel.MethodCallHandler, PluginRegistry.ActivityResultListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String ANDROID_OPTIONS = "androidOptions";
    private static final String CHANNEL_NAME = "multi_image_picker";
    private static final String ENABLE_CAMERA = "enableCamera";
    private static final String MAX_IMAGES = "maxImages";
    private static final String PICK_IMAGES = "pickImages";
    private static final int REQUEST_CODE_CHOOSE = 1001;
    private static final String REQUEST_METADATA = "requestMetadata";
    private static final String REQUEST_ORIGINAL = "requestOriginal";
    private static final String REQUEST_THUMBNAIL = "requestThumbnail";
    private static final String SELECTED_ASSETS = "selectedAssets";
    private Activity activity;
    private MethodChannel channel;
    private Context context;
    private BinaryMessenger messenger;
    private MethodCall methodCall;
    private MethodChannel.Result pendingResult;

    public static void registerWith(PluginRegistry.Registrar registrar) {
        MultiImagePickerPlugin instance = new MultiImagePickerPlugin();
        instance.onAttachedToEngine(registrar.context(), registrar.messenger(), registrar.activity());
        registrar.addActivityResultListener(instance);
    }

    private void onAttachedToEngine(Context applicationContext, BinaryMessenger binaryMessenger, Activity activity2) {
        this.context = applicationContext;
        this.messenger = binaryMessenger;
        if (activity2 != null) {
            this.activity = activity2;
        }
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, CHANNEL_NAME);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        onAttachedToEngine(binding.getApplicationContext(), binding.getBinaryMessenger(), (Activity) null);
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        this.context = null;
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
            this.channel = null;
        }
        this.messenger = null;
    }

    public void onAttachedToActivity(ActivityPluginBinding binding) {
        binding.addActivityResultListener(this);
        this.activity = binding.getActivity();
    }

    public void onDetachedFromActivity() {
        this.activity = null;
    }

    public void onDetachedFromActivityForConfigChanges() {
        this.activity = null;
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding binding) {
        binding.addActivityResultListener(this);
        this.activity = binding.getActivity();
    }

    private static class GetThumbnailTask extends AsyncTask<String, Void, ByteBuffer> {
        private WeakReference<Activity> activityReference;
        final int height;
        final String identifier;
        BinaryMessenger messenger;
        final int quality;
        final int width;

        GetThumbnailTask(Activity context, BinaryMessenger messenger2, String identifier2, int width2, int height2, int quality2) {
            this.messenger = messenger2;
            this.identifier = identifier2;
            this.width = width2;
            this.height = height2;
            this.quality = quality2;
            this.activityReference = new WeakReference<>(context);
        }

        /* access modifiers changed from: protected */
        public ByteBuffer doInBackground(String... strings) {
            Uri uri = Uri.parse(this.identifier);
            byte[] byteArray = null;
            try {
                Activity activity = (Activity) this.activityReference.get();
                if (activity != null) {
                    if (!activity.isFinishing()) {
                        Bitmap bitmap = ThumbnailUtils.extractThumbnail(MultiImagePickerPlugin.getCorrectlyOrientedImage(activity, uri), this.width, this.height, 2);
                        if (bitmap == null) {
                            return null;
                        }
                        ByteArrayOutputStream bitmapStream = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.JPEG, this.quality, bitmapStream);
                        byteArray = bitmapStream.toByteArray();
                        bitmap.recycle();
                        bitmapStream.close();
                        if (byteArray == null) {
                            return null;
                        }
                        ByteBuffer buffer = ByteBuffer.allocateDirect(byteArray.length);
                        buffer.put(byteArray);
                        return buffer;
                    }
                }
                return null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(ByteBuffer buffer) {
            super.onPostExecute(buffer);
            if (buffer != null) {
                BinaryMessenger binaryMessenger = this.messenger;
                binaryMessenger.send("multi_image_picker/image/" + this.identifier + ".thumb", buffer);
                buffer.clear();
            }
        }
    }

    private static class GetImageTask extends AsyncTask<String, Void, ByteBuffer> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final WeakReference<Activity> activityReference;
        final String identifier;
        final BinaryMessenger messenger;
        final int quality;

        static {
            Class<MultiImagePickerPlugin> cls = MultiImagePickerPlugin.class;
        }

        GetImageTask(Activity context, BinaryMessenger messenger2, String identifier2, int quality2) {
            this.messenger = messenger2;
            this.identifier = identifier2;
            this.quality = quality2;
            this.activityReference = new WeakReference<>(context);
        }

        /* access modifiers changed from: protected */
        public ByteBuffer doInBackground(String... strings) {
            Uri uri = Uri.parse(this.identifier);
            byte[] bytesArray = null;
            try {
                Activity activity = (Activity) this.activityReference.get();
                if (activity != null) {
                    if (!activity.isFinishing()) {
                        Bitmap bitmap = MultiImagePickerPlugin.getCorrectlyOrientedImage(activity, uri);
                        if (bitmap == null) {
                            return null;
                        }
                        ByteArrayOutputStream bitmapStream = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.JPEG, this.quality, bitmapStream);
                        bytesArray = bitmapStream.toByteArray();
                        bitmap.recycle();
                        bitmapStream.close();
                        ByteBuffer buffer = ByteBuffer.allocateDirect(bytesArray.length);
                        buffer.put(bytesArray);
                        return buffer;
                    }
                }
                return null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(ByteBuffer buffer) {
            super.onPostExecute(buffer);
            BinaryMessenger binaryMessenger = this.messenger;
            binaryMessenger.send("multi_image_picker/image/" + this.identifier + ".original", buffer);
            buffer.clear();
        }
    }

    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        Uri uri;
        MethodCall methodCall2 = call;
        if (!setPendingMethodCallAndResult(call, result)) {
            finishWithAlreadyActiveError(result);
            return;
        }
        MethodChannel.Result result2 = result;
        if (PICK_IMAGES.equals(methodCall2.method)) {
            presentPicker(((Integer) this.methodCall.argument(MAX_IMAGES)).intValue(), ((Boolean) this.methodCall.argument(ENABLE_CAMERA)).booleanValue(), (ArrayList) this.methodCall.argument(SELECTED_ASSETS), (HashMap) methodCall2.argument(ANDROID_OPTIONS));
        } else if (REQUEST_ORIGINAL.equals(methodCall2.method)) {
            String identifier = (String) methodCall2.argument("identifier");
            int quality = ((Integer) methodCall2.argument("quality")).intValue();
            if (!uriExists(identifier)) {
                finishWithError("ASSET_DOES_NOT_EXIST", "The requested image does not exist.");
                return;
            }
            new GetImageTask(this.activity, this.messenger, identifier, quality).execute(new String[0]);
            finishWithSuccess();
        } else if (REQUEST_THUMBNAIL.equals(methodCall2.method)) {
            String identifier2 = (String) methodCall2.argument("identifier");
            int width = ((Integer) methodCall2.argument("width")).intValue();
            int height = ((Integer) methodCall2.argument("height")).intValue();
            int quality2 = ((Integer) methodCall2.argument("quality")).intValue();
            if (!uriExists(identifier2)) {
                finishWithError("ASSET_DOES_NOT_EXIST", "The requested image does not exist.");
                return;
            }
            new GetThumbnailTask(this.activity, this.messenger, identifier2, width, height, quality2).execute(new String[0]);
            finishWithSuccess();
        } else if (REQUEST_METADATA.equals(methodCall2.method)) {
            Uri uri2 = Uri.parse((String) methodCall2.argument("identifier"));
            if (Build.VERSION.SDK_INT >= 29) {
                uri = MediaStore.setRequireOriginal(uri2);
            } else {
                uri = uri2;
            }
            try {
                finishWithSuccess(getPictureExif(new ExifInterface(this.context.getContentResolver().openInputStream(uri)), uri));
            } catch (IOException e) {
                finishWithError("Exif error", e.toString());
            }
        } else {
            this.pendingResult.notImplemented();
            clearMethodCallAndResult();
        }
    }

    private HashMap<String, Object> getPictureExif(ExifInterface exifInterface, Uri uri) {
        HashMap<String, Object> hotfix_map;
        ExifInterface exifInterface2 = exifInterface;
        Uri uri2 = uri;
        HashMap<String, Object> result = new HashMap<>();
        String[] tags_str = {ExifInterface.TAG_DATETIME, ExifInterface.TAG_GPS_DATESTAMP, ExifInterface.TAG_GPS_LATITUDE_REF, ExifInterface.TAG_GPS_LONGITUDE_REF, ExifInterface.TAG_GPS_PROCESSING_METHOD, ExifInterface.TAG_IMAGE_WIDTH, ExifInterface.TAG_IMAGE_LENGTH, ExifInterface.TAG_MAKE, ExifInterface.TAG_MODEL};
        String[] tags_double = {ExifInterface.TAG_APERTURE_VALUE, ExifInterface.TAG_FLASH, ExifInterface.TAG_FOCAL_LENGTH, ExifInterface.TAG_GPS_ALTITUDE, ExifInterface.TAG_GPS_ALTITUDE_REF, ExifInterface.TAG_GPS_LONGITUDE, ExifInterface.TAG_GPS_LATITUDE, ExifInterface.TAG_IMAGE_LENGTH, ExifInterface.TAG_IMAGE_WIDTH, ExifInterface.TAG_ISO_SPEED, ExifInterface.TAG_ORIENTATION, ExifInterface.TAG_WHITE_BALANCE, ExifInterface.TAG_EXPOSURE_TIME};
        result.putAll(getExif_str(exifInterface2, tags_str));
        HashMap<String, Object> exif_double = getExif_double(exifInterface2, tags_double);
        result.putAll(exif_double);
        if ((exif_double.isEmpty() || !exif_double.containsKey(ExifInterface.TAG_GPS_LATITUDE) || !exif_double.containsKey(ExifInterface.TAG_GPS_LONGITUDE)) && uri2 != null) {
            if (Build.VERSION.SDK_INT < 29) {
                hotfix_map = getLatLng(uri2);
            } else {
                hotfix_map = getLatLng(exifInterface, uri);
            }
            result.putAll(hotfix_map);
        }
        if (Build.VERSION.SDK_INT == 23) {
            result.putAll(getExif_str(exifInterface2, new String[]{ExifInterface.TAG_DATETIME_DIGITIZED, ExifInterface.TAG_SUBSEC_TIME, ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, ExifInterface.TAG_SUBSEC_TIME_ORIGINAL}));
        }
        if (Build.VERSION.SDK_INT > 23) {
            String[] tags_24_str = {ExifInterface.TAG_ARTIST, ExifInterface.TAG_CFA_PATTERN, ExifInterface.TAG_COMPONENTS_CONFIGURATION, ExifInterface.TAG_COPYRIGHT, ExifInterface.TAG_DATETIME_ORIGINAL, ExifInterface.TAG_DEVICE_SETTING_DESCRIPTION, ExifInterface.TAG_EXIF_VERSION, ExifInterface.TAG_FILE_SOURCE, ExifInterface.TAG_FLASHPIX_VERSION, ExifInterface.TAG_GPS_AREA_INFORMATION, ExifInterface.TAG_GPS_DEST_BEARING_REF, ExifInterface.TAG_GPS_DEST_DISTANCE_REF, ExifInterface.TAG_GPS_DEST_LATITUDE_REF, ExifInterface.TAG_GPS_DEST_LONGITUDE_REF, ExifInterface.TAG_GPS_IMG_DIRECTION_REF, ExifInterface.TAG_GPS_MAP_DATUM, ExifInterface.TAG_GPS_MEASURE_MODE, ExifInterface.TAG_GPS_SATELLITES, ExifInterface.TAG_GPS_SPEED_REF, ExifInterface.TAG_GPS_STATUS, ExifInterface.TAG_GPS_TRACK_REF, ExifInterface.TAG_GPS_VERSION_ID, ExifInterface.TAG_IMAGE_DESCRIPTION, ExifInterface.TAG_IMAGE_UNIQUE_ID, ExifInterface.TAG_INTEROPERABILITY_INDEX, ExifInterface.TAG_MAKER_NOTE, ExifInterface.TAG_OECF, ExifInterface.TAG_RELATED_SOUND_FILE, ExifInterface.TAG_SCENE_TYPE, ExifInterface.TAG_SOFTWARE, ExifInterface.TAG_SPATIAL_FREQUENCY_RESPONSE, ExifInterface.TAG_SPECTRAL_SENSITIVITY, ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, ExifInterface.TAG_USER_COMMENT};
            String[] tags24_double = {ExifInterface.TAG_APERTURE_VALUE, ExifInterface.TAG_BITS_PER_SAMPLE, ExifInterface.TAG_BRIGHTNESS_VALUE, ExifInterface.TAG_COLOR_SPACE, ExifInterface.TAG_COMPRESSED_BITS_PER_PIXEL, ExifInterface.TAG_COMPRESSION, ExifInterface.TAG_CONTRAST, ExifInterface.TAG_CUSTOM_RENDERED, ExifInterface.TAG_DIGITAL_ZOOM_RATIO, ExifInterface.TAG_EXPOSURE_BIAS_VALUE, ExifInterface.TAG_EXPOSURE_INDEX, ExifInterface.TAG_EXPOSURE_MODE, ExifInterface.TAG_EXPOSURE_PROGRAM, ExifInterface.TAG_FLASH_ENERGY, ExifInterface.TAG_FOCAL_LENGTH_IN_35MM_FILM, ExifInterface.TAG_FOCAL_PLANE_RESOLUTION_UNIT, ExifInterface.TAG_FOCAL_PLANE_X_RESOLUTION, ExifInterface.TAG_FOCAL_PLANE_Y_RESOLUTION, ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_GAIN_CONTROL, ExifInterface.TAG_GPS_DEST_BEARING, ExifInterface.TAG_GPS_DEST_DISTANCE, ExifInterface.TAG_GPS_DEST_LATITUDE, ExifInterface.TAG_GPS_DEST_LONGITUDE, ExifInterface.TAG_GPS_DIFFERENTIAL, ExifInterface.TAG_GPS_DOP, ExifInterface.TAG_GPS_IMG_DIRECTION, ExifInterface.TAG_GPS_SPEED, ExifInterface.TAG_GPS_TRACK, ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, ExifInterface.TAG_LIGHT_SOURCE, ExifInterface.TAG_MAX_APERTURE_VALUE, ExifInterface.TAG_METERING_MODE, ExifInterface.TAG_PHOTOMETRIC_INTERPRETATION, ExifInterface.TAG_PIXEL_X_DIMENSION, ExifInterface.TAG_PIXEL_Y_DIMENSION, ExifInterface.TAG_PLANAR_CONFIGURATION, ExifInterface.TAG_PRIMARY_CHROMATICITIES, ExifInterface.TAG_REFERENCE_BLACK_WHITE, ExifInterface.TAG_RESOLUTION_UNIT, ExifInterface.TAG_ROWS_PER_STRIP, ExifInterface.TAG_SAMPLES_PER_PIXEL, ExifInterface.TAG_SATURATION, ExifInterface.TAG_SCENE_CAPTURE_TYPE, ExifInterface.TAG_SENSING_METHOD, ExifInterface.TAG_SHARPNESS, ExifInterface.TAG_SHUTTER_SPEED_VALUE, ExifInterface.TAG_STRIP_BYTE_COUNTS, ExifInterface.TAG_STRIP_OFFSETS, ExifInterface.TAG_SUBJECT_AREA, ExifInterface.TAG_SUBJECT_DISTANCE, ExifInterface.TAG_SUBJECT_DISTANCE_RANGE, ExifInterface.TAG_SUBJECT_LOCATION, ExifInterface.TAG_THUMBNAIL_IMAGE_LENGTH, ExifInterface.TAG_THUMBNAIL_IMAGE_WIDTH, ExifInterface.TAG_TRANSFER_FUNCTION, ExifInterface.TAG_WHITE_POINT, ExifInterface.TAG_X_RESOLUTION, ExifInterface.TAG_Y_CB_CR_COEFFICIENTS, ExifInterface.TAG_Y_CB_CR_POSITIONING, ExifInterface.TAG_Y_CB_CR_SUB_SAMPLING, ExifInterface.TAG_Y_RESOLUTION};
            result.putAll(getExif_str(exifInterface2, tags_24_str));
            result.putAll(getExif_double(exifInterface2, tags24_double));
        }
        return result;
    }

    private HashMap<String, Object> getExif_str(ExifInterface exifInterface, String[] tags) {
        HashMap<String, Object> result = new HashMap<>();
        for (String tag : tags) {
            String attribute = exifInterface.getAttribute(tag);
            if (!TextUtils.isEmpty(attribute)) {
                result.put(tag, attribute);
            }
        }
        return result;
    }

    private HashMap<String, Object> getExif_double(ExifInterface exifInterface, String[] tags) {
        HashMap<String, Object> result = new HashMap<>();
        for (String tag : tags) {
            double attribute = exifInterface.getAttributeDouble(tag, 0.0d);
            if (attribute != 0.0d) {
                result.put(tag, Double.valueOf(attribute));
            }
        }
        return result;
    }

    private boolean uriExists(String identifier) {
        return getFileName(Uri.parse(identifier)) != null;
    }

    private void presentPicker(int maxImages, boolean enableCamera, ArrayList<String> selectedAssets, HashMap<String, String> options) {
        HashMap<String, String> hashMap = options;
        String actionBarColor = hashMap.get("actionBarColor");
        String statusBarColor = hashMap.get("statusBarColor");
        String lightStatusBar = hashMap.get("lightStatusBar");
        String actionBarTitle = hashMap.get("actionBarTitle");
        String actionBarTitleColor = hashMap.get("actionBarTitleColor");
        String allViewTitle = hashMap.get("allViewTitle");
        String startInAllView = hashMap.get("startInAllView");
        String useDetailsView = hashMap.get("useDetailsView");
        String selectCircleStrokeColor = hashMap.get("selectCircleStrokeColor");
        String selectionLimitReachedText = hashMap.get("selectionLimitReachedText");
        String textOnNothingSelected = hashMap.get("textOnNothingSelected");
        String backButtonDrawable = hashMap.get("backButtonDrawable");
        String okButtonDrawable = hashMap.get("okButtonDrawable");
        String autoCloseOnSelectionLimit = hashMap.get("autoCloseOnSelectionLimit");
        ArrayList<Uri> selectedUris = new ArrayList<>();
        Iterator<String> it = selectedAssets.iterator();
        while (it.hasNext()) {
            String allViewTitle2 = allViewTitle;
            selectedUris.add(Uri.parse(it.next()));
            HashMap<String, String> hashMap2 = options;
            allViewTitle = allViewTitle2;
        }
        String allViewTitle3 = allViewTitle;
        String actionBarTitleColor2 = actionBarTitleColor;
        FishBunCreator fishBun = FishBun.with(this.activity).setImageAdapter(new GlideAdapter()).setMaxCount(maxImages).setCamera(enableCamera).setRequestCode(1001).setSelectedImages(selectedUris).exceptGif(true).setIsUseDetailView(useDetailsView.equals("true")).setReachLimitAutomaticClose(autoCloseOnSelectionLimit.equals("true")).isStartInAllView(startInAllView.equals("true"));
        if (!textOnNothingSelected.isEmpty()) {
            fishBun.textOnNothingSelected(textOnNothingSelected);
        }
        String str = startInAllView;
        if (!backButtonDrawable.isEmpty()) {
            String str2 = useDetailsView;
            fishBun.setHomeAsUpIndicatorDrawable(ContextCompat.getDrawable(this.context, this.context.getResources().getIdentifier(backButtonDrawable, "drawable", this.context.getPackageName())));
        }
        if (!okButtonDrawable.isEmpty()) {
            fishBun.setDoneButtonDrawable(ContextCompat.getDrawable(this.context, this.context.getResources().getIdentifier(okButtonDrawable, "drawable", this.context.getPackageName())));
        }
        if (actionBarColor != null && !actionBarColor.isEmpty()) {
            int color = Color.parseColor(actionBarColor);
            if (statusBarColor == null || statusBarColor.isEmpty()) {
                fishBun.setActionBarColor(color);
            } else {
                int statusBarColorInt = Color.parseColor(statusBarColor);
                if (lightStatusBar == null || lightStatusBar.isEmpty()) {
                    fishBun.setActionBarColor(color, statusBarColorInt);
                } else {
                    fishBun.setActionBarColor(color, statusBarColorInt, lightStatusBar.equals("true"));
                }
            }
        }
        if (actionBarTitle != null && !actionBarTitle.isEmpty()) {
            fishBun.setActionBarTitle(actionBarTitle);
        }
        if (selectionLimitReachedText != null && !selectionLimitReachedText.isEmpty()) {
            fishBun.textOnImagesSelectionLimitReached(selectionLimitReachedText);
        }
        if (selectCircleStrokeColor != null && !selectCircleStrokeColor.isEmpty()) {
            fishBun.setSelectCircleStrokeColor(Color.parseColor(selectCircleStrokeColor));
        }
        if (actionBarTitleColor2 != null && !actionBarTitleColor2.isEmpty()) {
            fishBun.setActionBarTitleColor(Color.parseColor(actionBarTitleColor2));
        }
        if (allViewTitle3 == null || allViewTitle3.isEmpty()) {
        } else {
            fishBun.setAllViewTitle(allViewTitle3);
        }
        fishBun.startAlbum();
    }

    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1001 && resultCode == 0) {
            finishWithError("CANCELLED", "The user has cancelled the selection");
        } else if (requestCode == 1001 && resultCode == -1) {
            List<Uri> photos = data.getParcelableArrayListExtra(Define.INTENT_PATH);
            if (photos == null) {
                clearMethodCallAndResult();
                return false;
            }
            List<HashMap<String, Object>> result = new ArrayList<>(photos.size());
            for (Uri uri : photos) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("identifier", uri.toString());
                int width = 0;
                int height = 0;
                try {
                    InputStream is = this.context.getContentResolver().openInputStream(uri);
                    BitmapFactory.Options dbo = new BitmapFactory.Options();
                    dbo.inJustDecodeBounds = true;
                    dbo.inScaled = false;
                    dbo.inSampleSize = 1;
                    BitmapFactory.decodeStream(is, (Rect) null, dbo);
                    if (is != null) {
                        is.close();
                    }
                    int orientation = getOrientation(this.context, uri);
                    if (orientation != 90) {
                        if (orientation != 270) {
                            width = dbo.outWidth;
                            height = dbo.outHeight;
                            map.put("width", Integer.valueOf(width));
                            map.put("height", Integer.valueOf(height));
                            map.put(AppMeasurementSdk.ConditionalUserProperty.NAME, getFileName(uri));
                            result.add(map);
                        }
                    }
                    width = dbo.outHeight;
                    height = dbo.outWidth;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                map.put("width", Integer.valueOf(width));
                map.put("height", Integer.valueOf(height));
                map.put(AppMeasurementSdk.ConditionalUserProperty.NAME, getFileName(uri));
                result.add(map);
            }
            finishWithSuccess((List) result);
            return true;
        } else {
            finishWithSuccess((List) Collections.emptyList());
            clearMethodCallAndResult();
        }
        return false;
    }

    private HashMap<String, Object> getLatLng(ExifInterface exifInterface, @NonNull Uri uri) {
        HashMap<String, Object> result = new HashMap<>();
        double[] latLong = exifInterface.getLatLong();
        if (latLong != null && latLong.length == 2) {
            result.put(ExifInterface.TAG_GPS_LATITUDE, Double.valueOf(Math.abs(latLong[0])));
            result.put(ExifInterface.TAG_GPS_LONGITUDE, Double.valueOf(Math.abs(latLong[1])));
        }
        return result;
    }

    private HashMap<String, Object> getLatLng(@NonNull Uri uri) {
        HashMap<String, Object> result = new HashMap<>();
        List<String> latlngList = Arrays.asList(new String[]{"latitude", "longitude"});
        String uriScheme = uri.getScheme();
        if (uriScheme == null) {
            return result;
        }
        if (uriScheme.equals(FirebaseAnalytics.Param.CONTENT)) {
            Cursor cursor = this.context.getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
            if (cursor == null) {
                return result;
            }
            try {
                List<String> columnNamesList = Arrays.asList(cursor.getColumnNames());
                for (String latorlngStr : latlngList) {
                    cursor.moveToFirst();
                    int index = columnNamesList.indexOf(latorlngStr);
                    if (index > -1) {
                        Double val = Double.valueOf(cursor.getDouble(index));
                        if (latorlngStr.equals("latitude")) {
                            result.put(ExifInterface.TAG_GPS_LATITUDE, Double.valueOf(Math.abs(val.doubleValue())));
                        } else {
                            result.put(ExifInterface.TAG_GPS_LONGITUDE, Double.valueOf(Math.abs(val.doubleValue())));
                        }
                    }
                }
                try {
                    cursor.close();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            } catch (NullPointerException e2) {
                e2.printStackTrace();
                cursor.close();
            } catch (Throwable th) {
                Throwable th2 = th;
                try {
                    cursor.close();
                } catch (NullPointerException e3) {
                    e3.printStackTrace();
                }
                throw th2;
            }
        }
        return result;
    }

    private String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals(FirebaseAnalytics.Param.CONTENT)) {
            Cursor cursor = this.context.getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        result = cursor.getString(cursor.getColumnIndex("_display_name"));
                    }
                } catch (Throwable th) {
                    cursor.close();
                    throw th;
                }
            }
            cursor.close();
        }
        if (result != null) {
            return result;
        }
        String result2 = uri.getPath();
        int cut = result2.lastIndexOf(47);
        if (cut != -1) {
            return result2.substring(cut + 1);
        }
        return result2;
    }

    private static int getOrientation(Context context2, Uri photoUri) {
        try {
            int orientation = new ExifInterface(context2.getContentResolver().openInputStream(photoUri)).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
            if (orientation == 3) {
                return 180;
            }
            if (orientation == 6) {
                return 90;
            }
            if (orientation != 8) {
                return 0;
            }
            return 270;
        } catch (Exception e) {
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public static Bitmap getCorrectlyOrientedImage(Context context2, Uri photoUri) throws IOException {
        InputStream is = context2.getContentResolver().openInputStream(photoUri);
        BitmapFactory.Options dbo = new BitmapFactory.Options();
        dbo.inScaled = false;
        dbo.inSampleSize = 1;
        dbo.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(is, (Rect) null, dbo);
        if (is != null) {
            is.close();
        }
        int orientation = getOrientation(context2, photoUri);
        InputStream is2 = context2.getContentResolver().openInputStream(photoUri);
        Bitmap srcBitmap = BitmapFactory.decodeStream(is2);
        if (is2 != null) {
            is2.close();
        }
        if (orientation <= 0) {
            return srcBitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate((float) orientation);
        return Bitmap.createBitmap(srcBitmap, 0, 0, srcBitmap.getWidth(), srcBitmap.getHeight(), matrix, true);
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int height = options.outHeight;
        int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            int halfHeight = height / 2;
            int halfWidth = width / 2;
            while (halfHeight / inSampleSize >= reqHeight && halfWidth / inSampleSize >= reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

    private void finishWithSuccess(List imagePathList) {
        MethodChannel.Result result = this.pendingResult;
        if (result != null) {
            result.success(imagePathList);
        }
        clearMethodCallAndResult();
    }

    private void finishWithSuccess(HashMap<String, Object> hashMap) {
        MethodChannel.Result result = this.pendingResult;
        if (result != null) {
            result.success(hashMap);
        }
        clearMethodCallAndResult();
    }

    private void finishWithSuccess() {
        MethodChannel.Result result = this.pendingResult;
        if (result != null) {
            result.success(true);
        }
        clearMethodCallAndResult();
    }

    private void finishWithAlreadyActiveError(MethodChannel.Result result) {
        if (result != null) {
            result.error("already_active", "Image picker is already active", (Object) null);
        }
    }

    private void finishWithError(String errorCode, String errorMessage) {
        MethodChannel.Result result = this.pendingResult;
        if (result != null) {
            result.error(errorCode, errorMessage, (Object) null);
        }
        clearMethodCallAndResult();
    }

    private void clearMethodCallAndResult() {
        this.methodCall = null;
        this.pendingResult = null;
    }

    private boolean setPendingMethodCallAndResult(MethodCall methodCall2, MethodChannel.Result result) {
        if (this.pendingResult != null) {
            return false;
        }
        this.methodCall = methodCall2;
        this.pendingResult = result;
        return true;
    }
}
