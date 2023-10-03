package com.sangcomz.fishbun.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import com.sangcomz.fishbun.define.Define;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CameraUtil {
    private String savePath;

    public void takePicture(Activity activity, String saveDir) {
        Uri uri;
        Intent takePictureIntent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (takePictureIntent.resolveActivity(activity.getPackageManager()) != null) {
            File photoFile = null;
            try {
                photoFile = createImageFile(saveDir);
                setSavePath(photoFile.getAbsolutePath());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if (photoFile != null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    uri = FileProvider.getUriForFile(activity, activity.getApplicationContext().getPackageName() + ".fishbunfileprovider", photoFile);
                } else {
                    uri = Uri.fromFile(photoFile);
                }
                takePictureIntent.putExtra("output", uri);
                new Define().getClass();
                activity.startActivityForResult(takePictureIntent, 128);
            }
        }
    }

    private File createImageFile(String saveDir) throws IOException {
        File dir = new File(saveDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return File.createTempFile("JPEG_" + timeStamp + "_", ".jpg", new File(saveDir));
    }

    public String getSavePath() {
        return this.savePath;
    }

    public void setSavePath(String savePath2) {
        this.savePath = savePath2;
    }
}
