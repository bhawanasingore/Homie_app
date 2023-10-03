package com.vitanov.multiimagepicker;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import androidx.loader.content.CursorLoader;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.util.Objects;

public class FileDirectory {
    public static String getPath(Context context, Uri uri) {
        if (Build.VERSION.SDK_INT < 11) {
            return getPath_BelowAPI11(context, uri);
        }
        if (Build.VERSION.SDK_INT < 19) {
            return getPath_API11to18(context, uri);
        }
        return getPath_API19(context, uri);
    }

    @SuppressLint({"NewApi"})
    public static String getPath_API19(Context context, Uri uri) {
        if (!(Build.VERSION.SDK_INT >= 19) || !DocumentsContract.isDocumentUri(context, uri)) {
            if (FirebaseAnalytics.Param.CONTENT.equalsIgnoreCase(uri.getScheme())) {
                return getDataColumn(context, uri, (String) null, (String[]) null);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        } else if (isExternalStorageDocument(uri)) {
            String[] split = DocumentsContract.getDocumentId(uri).split(":");
            if ("primary".equalsIgnoreCase(split[0])) {
                if (Build.VERSION.SDK_INT < 29) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
                return ((File) Objects.requireNonNull(context.getExternalFilesDir((String) null))).getAbsolutePath() + "/" + split[1];
            }
        } else if (isDownloadsDocument(uri)) {
            return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), (String) null, (String[]) null);
        } else if (isMediaDocument(uri)) {
            String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
            String type = split2[0];
            Uri contentUri = null;
            if ("image".equals(type)) {
                contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(type)) {
                contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(type)) {
                contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return getDataColumn(context, contentUri, "_id=?", new String[]{split2[1]});
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    public static String getPath_API11to18(Context context, Uri contentUri) {
        Cursor cursor = new CursorLoader(context, contentUri, new String[]{"_data"}, (String) null, (String[]) null, (String) null).loadInBackground();
        if (cursor == null) {
            return null;
        }
        int column_index = cursor.getColumnIndexOrThrow("_data");
        cursor.moveToFirst();
        String result = cursor.getString(column_index);
        cursor.close();
        return result;
    }

    public static String getPath_BelowAPI11(Context context, Uri contentUri) {
        Cursor cursor = context.getContentResolver().query(contentUri, new String[]{"_data"}, (String) null, (String[]) null, (String) null);
        if (cursor == null) {
            return "";
        }
        int column_index = cursor.getColumnIndexOrThrow("_data");
        cursor.moveToFirst();
        String result = cursor.getString(column_index);
        cursor.close();
        return result;
    }

    private static String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, selection, selectionArgs, (String) null);
            if (cursor != null && cursor.moveToFirst()) {
                return cursor.getString(cursor.getColumnIndexOrThrow("_data"));
            }
            if (cursor == null) {
                return null;
            }
            cursor.close();
            return null;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    private static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    private static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }
}
