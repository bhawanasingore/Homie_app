package com.sangcomz.fishbun.ui.picker;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import com.sangcomz.fishbun.permission.PermissionCheck;
import com.sangcomz.fishbun.util.CameraUtil;
import com.sangcomz.fishbun.util.RegexUtil;
import java.util.ArrayList;

public class PickerController {
    private ArrayList<Uri> addImagePaths = new ArrayList<>();
    private CameraUtil cameraUtil = new CameraUtil();
    private String pathDir = "";
    /* access modifiers changed from: private */
    public PickerActivity pickerActivity;
    private ContentResolver resolver;

    PickerController(PickerActivity pickerActivity2) {
        this.pickerActivity = pickerActivity2;
        this.resolver = pickerActivity2.getContentResolver();
    }

    public void takePicture(Activity activity, String saveDir) {
        this.cameraUtil.takePicture(activity, saveDir);
    }

    public void setToolbarTitle(int total) {
        this.pickerActivity.showToolbarTitle(total);
    }

    /* access modifiers changed from: package-private */
    public String getSavePath() {
        return this.cameraUtil.getSavePath();
    }

    /* access modifiers changed from: package-private */
    public void setSavePath(String savePath) {
        this.cameraUtil.setSavePath(savePath);
    }

    public void setAddImagePath(Uri imagePath) {
        this.addImagePaths.add(imagePath);
    }

    /* access modifiers changed from: protected */
    public ArrayList<Uri> getAddImagePaths() {
        return this.addImagePaths;
    }

    public void setAddImagePaths(ArrayList<Uri> addImagePaths2) {
        this.addImagePaths = addImagePaths2;
    }

    /* access modifiers changed from: package-private */
    public boolean checkPermission() {
        PermissionCheck permissionCheck = new PermissionCheck(this.pickerActivity);
        if (Build.VERSION.SDK_INT < 23 || permissionCheck.CheckStoragePermission()) {
            return true;
        }
        return false;
    }

    public boolean checkCameraPermission() {
        PermissionCheck permissionCheck = new PermissionCheck(this.pickerActivity);
        if (Build.VERSION.SDK_INT < 23 || permissionCheck.CheckCameraPermission()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void displayImage(Long bucketId, Boolean exceptGif) {
        new DisplayImage(bucketId, exceptGif).execute(new Void[0]);
    }

    private class DisplayImage extends AsyncTask<Void, Void, Uri[]> {
        private Long bucketId;
        Boolean exceptGif;

        DisplayImage(Long bucketId2, Boolean exceptGif2) {
            this.bucketId = bucketId2;
            this.exceptGif = exceptGif2;
        }

        /* access modifiers changed from: protected */
        public Uri[] doInBackground(Void... params) {
            return PickerController.this.getAllMediaThumbnailsPath(this.bucketId.longValue(), this.exceptGif);
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Uri[] result) {
            super.onPostExecute(result);
            PickerController.this.pickerActivity.setAdapter(result);
        }
    }

    /* access modifiers changed from: private */
    public Uri[] getAllMediaThumbnailsPath(long id, Boolean exceptGif) {
        Cursor c;
        String bucketId = String.valueOf(id);
        int i = 0;
        String[] selectionArgs = {bucketId};
        Uri images = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        if (!bucketId.equals("0")) {
            c = this.resolver.query(images, (String[]) null, "bucket_id = ?", selectionArgs, "_id DESC");
        } else {
            c = this.resolver.query(images, (String[]) null, (String) null, (String[]) null, "_id DESC");
        }
        if (c != null) {
            i = c.getCount();
        }
        Uri[] imageUris = new Uri[i];
        if (c != null) {
            try {
                if (c.moveToFirst()) {
                    setPathDir(c.getString(c.getColumnIndex("_data")), c.getString(c.getColumnIndex("_display_name")));
                    int position = -1;
                    do {
                        if (!exceptGif.booleanValue() || !RegexUtil.checkGif(c.getString(c.getColumnIndex("_data")))) {
                            int imgId = c.getInt(c.getColumnIndex("_id"));
                            Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                            position++;
                            imageUris[position] = Uri.withAppendedPath(uri, "" + imgId);
                        }
                    } while (c.moveToNext() != 0);
                }
                c.close();
            } catch (Exception e) {
                if (!c.isClosed()) {
                    c.close();
                }
            }
        }
        return imageUris;
    }

    private String setPathDir(String path, String fileName) {
        String replace = path.replace("/" + fileName, "");
        this.pathDir = replace;
        return replace;
    }

    public String getPathDir(Long bucketId) {
        if (this.pathDir.equals("") || bucketId.longValue() == 0) {
            this.pathDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM + "/Camera").getAbsolutePath();
        }
        return this.pathDir;
    }

    public void finishActivity() {
        this.pickerActivity.finishActivity();
    }
}
