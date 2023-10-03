package com.sangcomz.fishbun.ui.album;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import com.sangcomz.fishbun.bean.Album;
import com.sangcomz.fishbun.permission.PermissionCheck;
import com.sangcomz.fishbun.util.CameraUtil;
import com.sangcomz.fishbun.util.RegexUtil;
import java.util.ArrayList;
import java.util.HashMap;

class AlbumController {
    /* access modifiers changed from: private */
    public AlbumActivity albumActivity;
    private CameraUtil cameraUtil = new CameraUtil();
    /* access modifiers changed from: private */
    public ContentResolver resolver;

    AlbumController(AlbumActivity albumActivity2) {
        this.albumActivity = albumActivity2;
        this.resolver = albumActivity2.getContentResolver();
    }

    /* access modifiers changed from: package-private */
    public boolean checkPermission() {
        PermissionCheck permissionCheck = new PermissionCheck(this.albumActivity);
        if (Build.VERSION.SDK_INT < 23 || permissionCheck.CheckStoragePermission()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean checkCameraPermission() {
        PermissionCheck permissionCheck = new PermissionCheck(this.albumActivity);
        if (Build.VERSION.SDK_INT < 23 || permissionCheck.CheckCameraPermission()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void getAlbumList(String allViewTitle, Boolean exceptGif) {
        new LoadAlbumList(allViewTitle, exceptGif).execute(new Void[0]);
    }

    private class LoadAlbumList extends AsyncTask<Void, Void, ArrayList<Album>> {
        String allViewTitle;
        Boolean exceptGif;

        LoadAlbumList(String allViewTitle2, Boolean exceptGif2) {
            this.allViewTitle = allViewTitle2;
            this.exceptGif = exceptGif2;
        }

        /* access modifiers changed from: protected */
        public ArrayList<Album> doInBackground(Void... params) {
            int bucketData;
            String orderBy;
            LoadAlbumList loadAlbumList = this;
            HashMap<Long, Album> albumHashMap = new HashMap<>();
            String orderBy2 = "_id DESC";
            Cursor c = AlbumController.this.resolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_data", "_id", "bucket_display_name", "bucket_id"}, (String) null, (String[]) null, "_id DESC");
            int totalCounter = 0;
            if (c != null) {
                int bucketData2 = c.getColumnIndex("_data");
                int bucketColumn = c.getColumnIndex("bucket_display_name");
                int bucketColumnId = c.getColumnIndex("bucket_id");
                Album album = r13;
                Album album2 = new Album(0, loadAlbumList.allViewTitle, (String) null, 0);
                albumHashMap.put(0L, album);
                while (c.moveToNext()) {
                    if (!loadAlbumList.exceptGif.booleanValue() || !RegexUtil.checkGif(c.getString(bucketData2))) {
                        totalCounter++;
                        long bucketId = (long) c.getInt(bucketColumnId);
                        Album album3 = albumHashMap.get(Long.valueOf(bucketId));
                        if (album3 == null) {
                            int imgId = c.getInt(c.getColumnIndex("_id"));
                            Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                            StringBuilder sb = new StringBuilder();
                            orderBy = orderBy2;
                            sb.append("");
                            sb.append(imgId);
                            Uri path = Uri.withAppendedPath(uri, sb.toString());
                            Long valueOf = Long.valueOf(bucketId);
                            Album album4 = r13;
                            bucketData = bucketData2;
                            Album album5 = album3;
                            int i = imgId;
                            Album album6 = new Album(bucketId, c.getString(bucketColumn), path.toString(), 1);
                            albumHashMap.put(valueOf, album6);
                            if (albumHashMap.get(0L).thumbnailPath == null) {
                                albumHashMap.get(0L).thumbnailPath = path.toString();
                            }
                        } else {
                            orderBy = orderBy2;
                            bucketData = bucketData2;
                            album3.counter++;
                        }
                        loadAlbumList = this;
                        orderBy2 = orderBy;
                        bucketData2 = bucketData;
                    }
                }
                int i2 = bucketData2;
                Album allAlbum = albumHashMap.get(0L);
                if (allAlbum != null) {
                    allAlbum.counter = totalCounter;
                }
                c.close();
            }
            if (totalCounter == 0) {
                albumHashMap.clear();
            }
            ArrayList<Album> albumList = new ArrayList<>();
            for (Album album7 : albumHashMap.values()) {
                if (album7.bucketId == 0) {
                    albumList.add(0, album7);
                } else {
                    albumList.add(album7);
                }
            }
            return albumList;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(ArrayList<Album> albumList) {
            super.onPostExecute(albumList);
            AlbumController.this.albumActivity.setAlbumList(albumList);
        }
    }

    /* access modifiers changed from: package-private */
    public void takePicture(Activity activity, String saveDir) {
        this.cameraUtil.takePicture(activity, saveDir);
    }

    /* access modifiers changed from: package-private */
    public String getSavePath() {
        return this.cameraUtil.getSavePath();
    }

    /* access modifiers changed from: package-private */
    public String getPathDir() {
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM + "/Camera").getAbsolutePath();
    }
}
