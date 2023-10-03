package io.flutter.plugins.imagepicker;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.plugin.common.MethodCall;
import java.util.HashMap;
import java.util.Map;

class ImagePickerCache {
    private static final String FLUTTER_IMAGE_PICKER_IMAGE_PATH_KEY = "flutter_image_picker_image_path";
    private static final String MAP_KEY_ERROR_CODE = "errorCode";
    private static final String MAP_KEY_ERROR_MESSAGE = "errorMessage";
    static final String MAP_KEY_IMAGE_QUALITY = "imageQuality";
    static final String MAP_KEY_MAX_HEIGHT = "maxHeight";
    static final String MAP_KEY_MAX_WIDTH = "maxWidth";
    static final String MAP_KEY_PATH = "path";
    private static final String MAP_KEY_TYPE = "type";
    @VisibleForTesting
    static final String SHARED_PREFERENCES_NAME = "flutter_image_picker_shared_preference";
    private static final String SHARED_PREFERENCE_ERROR_CODE_KEY = "flutter_image_picker_error_code";
    private static final String SHARED_PREFERENCE_ERROR_MESSAGE_KEY = "flutter_image_picker_error_message";
    private static final String SHARED_PREFERENCE_IMAGE_QUALITY_KEY = "flutter_image_picker_image_quality";
    private static final String SHARED_PREFERENCE_MAX_HEIGHT_KEY = "flutter_image_picker_max_height";
    private static final String SHARED_PREFERENCE_MAX_WIDTH_KEY = "flutter_image_picker_max_width";
    private static final String SHARED_PREFERENCE_PENDING_IMAGE_URI_PATH_KEY = "flutter_image_picker_pending_image_uri";
    private static final String SHARED_PREFERENCE_TYPE_KEY = "flutter_image_picker_type";
    private SharedPreferences prefs;

    ImagePickerCache(Context context) {
        this.prefs = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
    }

    /* access modifiers changed from: package-private */
    public void saveTypeWithMethodCallName(String methodCallName) {
        if (methodCallName.equals("pickImage")) {
            setType("image");
        } else if (methodCallName.equals("pickVideo")) {
            setType("video");
        }
    }

    private void setType(String type) {
        this.prefs.edit().putString(SHARED_PREFERENCE_TYPE_KEY, type).apply();
    }

    /* access modifiers changed from: package-private */
    public void saveDimensionWithMethodCall(MethodCall methodCall) {
        int imageQuality;
        Double maxWidth = (Double) methodCall.argument(MAP_KEY_MAX_WIDTH);
        Double maxHeight = (Double) methodCall.argument(MAP_KEY_MAX_HEIGHT);
        if (methodCall.argument(MAP_KEY_IMAGE_QUALITY) == null) {
            imageQuality = 100;
        } else {
            imageQuality = ((Integer) methodCall.argument(MAP_KEY_IMAGE_QUALITY)).intValue();
        }
        setMaxDimension(maxWidth, maxHeight, imageQuality);
    }

    private void setMaxDimension(Double maxWidth, Double maxHeight, int imageQuality) {
        SharedPreferences.Editor editor = this.prefs.edit();
        if (maxWidth != null) {
            editor.putLong(SHARED_PREFERENCE_MAX_WIDTH_KEY, Double.doubleToRawLongBits(maxWidth.doubleValue()));
        }
        if (maxHeight != null) {
            editor.putLong(SHARED_PREFERENCE_MAX_HEIGHT_KEY, Double.doubleToRawLongBits(maxHeight.doubleValue()));
        }
        if (imageQuality <= -1 || imageQuality >= 101) {
            editor.putInt(SHARED_PREFERENCE_IMAGE_QUALITY_KEY, 100);
        } else {
            editor.putInt(SHARED_PREFERENCE_IMAGE_QUALITY_KEY, imageQuality);
        }
        editor.apply();
    }

    /* access modifiers changed from: package-private */
    public void savePendingCameraMediaUriPath(Uri uri) {
        this.prefs.edit().putString(SHARED_PREFERENCE_PENDING_IMAGE_URI_PATH_KEY, uri.getPath()).apply();
    }

    /* access modifiers changed from: package-private */
    public String retrievePendingCameraMediaUriPath() {
        return this.prefs.getString(SHARED_PREFERENCE_PENDING_IMAGE_URI_PATH_KEY, "");
    }

    /* access modifiers changed from: package-private */
    public void saveResult(@Nullable String path, @Nullable String errorCode, @Nullable String errorMessage) {
        SharedPreferences.Editor editor = this.prefs.edit();
        if (path != null) {
            editor.putString(FLUTTER_IMAGE_PICKER_IMAGE_PATH_KEY, path);
        }
        if (errorCode != null) {
            editor.putString(SHARED_PREFERENCE_ERROR_CODE_KEY, errorCode);
        }
        if (errorMessage != null) {
            editor.putString(SHARED_PREFERENCE_ERROR_MESSAGE_KEY, errorMessage);
        }
        editor.apply();
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        this.prefs.edit().clear().apply();
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> getCacheMap() {
        Map<String, Object> resultMap = new HashMap<>();
        boolean hasData = false;
        if (this.prefs.contains(FLUTTER_IMAGE_PICKER_IMAGE_PATH_KEY)) {
            resultMap.put(MAP_KEY_PATH, this.prefs.getString(FLUTTER_IMAGE_PICKER_IMAGE_PATH_KEY, ""));
            hasData = true;
        }
        if (this.prefs.contains(SHARED_PREFERENCE_ERROR_CODE_KEY)) {
            resultMap.put(MAP_KEY_ERROR_CODE, this.prefs.getString(SHARED_PREFERENCE_ERROR_CODE_KEY, ""));
            hasData = true;
            if (this.prefs.contains(SHARED_PREFERENCE_ERROR_MESSAGE_KEY)) {
                resultMap.put(MAP_KEY_ERROR_MESSAGE, this.prefs.getString(SHARED_PREFERENCE_ERROR_MESSAGE_KEY, ""));
            }
        }
        if (hasData) {
            if (this.prefs.contains(SHARED_PREFERENCE_TYPE_KEY)) {
                resultMap.put("type", this.prefs.getString(SHARED_PREFERENCE_TYPE_KEY, ""));
            }
            if (this.prefs.contains(SHARED_PREFERENCE_MAX_WIDTH_KEY)) {
                resultMap.put(MAP_KEY_MAX_WIDTH, Double.valueOf(Double.longBitsToDouble(this.prefs.getLong(SHARED_PREFERENCE_MAX_WIDTH_KEY, 0))));
            }
            if (this.prefs.contains(SHARED_PREFERENCE_MAX_HEIGHT_KEY)) {
                resultMap.put(MAP_KEY_MAX_HEIGHT, Double.valueOf(Double.longBitsToDouble(this.prefs.getLong(SHARED_PREFERENCE_MAX_HEIGHT_KEY, 0))));
            }
            if (this.prefs.contains(SHARED_PREFERENCE_IMAGE_QUALITY_KEY)) {
                resultMap.put(MAP_KEY_IMAGE_QUALITY, Integer.valueOf(this.prefs.getInt(SHARED_PREFERENCE_IMAGE_QUALITY_KEY, 100)));
            } else {
                resultMap.put(MAP_KEY_IMAGE_QUALITY, 100);
            }
        }
        return resultMap;
    }
}
