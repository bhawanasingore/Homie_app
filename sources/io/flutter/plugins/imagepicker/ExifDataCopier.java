package io.flutter.plugins.imagepicker;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;

class ExifDataCopier {
    ExifDataCopier() {
    }

    /* access modifiers changed from: package-private */
    public void copyExif(String filePathOri, String filePathDest) {
        try {
            try {
                ExifInterface oldExif = new ExifInterface(filePathOri);
                try {
                    ExifInterface newExif = new ExifInterface(filePathDest);
                    for (String attribute : Arrays.asList(new String[]{ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_ISO_SPEED_RATINGS, ExifInterface.TAG_GPS_ALTITUDE, ExifInterface.TAG_GPS_ALTITUDE_REF, ExifInterface.TAG_FOCAL_LENGTH, ExifInterface.TAG_GPS_DATESTAMP, ExifInterface.TAG_WHITE_BALANCE, ExifInterface.TAG_GPS_PROCESSING_METHOD, ExifInterface.TAG_GPS_TIMESTAMP, ExifInterface.TAG_DATETIME, ExifInterface.TAG_FLASH, ExifInterface.TAG_GPS_LATITUDE, ExifInterface.TAG_GPS_LATITUDE_REF, ExifInterface.TAG_GPS_LONGITUDE, ExifInterface.TAG_GPS_LONGITUDE_REF, ExifInterface.TAG_MAKE, ExifInterface.TAG_MODEL, ExifInterface.TAG_ORIENTATION})) {
                        setIfNotNull(oldExif, newExif, attribute);
                    }
                    newExif.saveAttributes();
                } catch (Exception e) {
                    ex = e;
                    Log.e("ExifDataCopier", "Error preserving Exif data on selected image: " + ex);
                }
            } catch (Exception e2) {
                ex = e2;
                String str = filePathDest;
                Log.e("ExifDataCopier", "Error preserving Exif data on selected image: " + ex);
            }
        } catch (Exception e3) {
            ex = e3;
            String str2 = filePathOri;
            String str3 = filePathDest;
            Log.e("ExifDataCopier", "Error preserving Exif data on selected image: " + ex);
        }
    }

    private static void setIfNotNull(ExifInterface oldExif, ExifInterface newExif, String property) {
        if (oldExif.getAttribute(property) != null) {
            newExif.setAttribute(property, oldExif.getAttribute(property));
        }
    }
}
