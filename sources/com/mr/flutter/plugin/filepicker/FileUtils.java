package com.mr.flutter.plugin.filepicker;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.storage.StorageManager;
import android.provider.DocumentsContract;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.annotation.Nullable;
import com.mr.flutter.plugin.filepicker.FileInfo;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;

public class FileUtils {
    private static final String PRIMARY_VOLUME_NAME = "primary";
    private static final String TAG = "FilePickerUtils";

    public static String[] getMimeTypes(ArrayList<String> allowedExtensions) {
        if (allowedExtensions == null || allowedExtensions.isEmpty()) {
            return null;
        }
        ArrayList<String> mimes = new ArrayList<>();
        for (int i = 0; i < allowedExtensions.size(); i++) {
            String mime = MimeTypeMap.getSingleton().getMimeTypeFromExtension(allowedExtensions.get(i));
            if (mime == null) {
                Log.w(TAG, "Custom file type " + allowedExtensions.get(i) + " is unsupported and will be ignored.");
            } else {
                mimes.add(mime);
            }
        }
        Log.d(TAG, "Allowed file extensions mimes: " + mimes);
        return (String[]) mimes.toArray(new String[0]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004e, code lost:
        if (r1 != null) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0050, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0072, code lost:
        if (r1 == null) goto L_0x007b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getFileName(android.net.Uri r9, android.content.Context r10) {
        /*
            r0 = 0
            java.lang.String r1 = r9.getScheme()
            r2 = -1
            if (r1 == 0) goto L_0x007b
            java.lang.String r1 = r9.getScheme()
            java.lang.String r3 = "content"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x007b
            r1 = 0
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch:{ Exception -> 0x0056 }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r4 = r9
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0056 }
            r1 = r3
            if (r1 == 0) goto L_0x004e
            boolean r3 = r1.moveToFirst()     // Catch:{ Exception -> 0x0056 }
            if (r3 == 0) goto L_0x004e
            java.lang.String r3 = "_data"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ Exception -> 0x0056 }
            if (r3 != r2) goto L_0x003a
            java.lang.String r4 = "_display_name"
            int r4 = r1.getColumnIndex(r4)     // Catch:{ Exception -> 0x0056 }
            r3 = r4
        L_0x003a:
            java.lang.String r4 = r1.getString(r3)     // Catch:{ Exception -> 0x0056 }
            r0 = r4
            if (r0 == 0) goto L_0x0047
            android.net.Uri r4 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x0056 }
            r9 = r4
            goto L_0x004e
        L_0x0047:
            r2 = 0
            if (r1 == 0) goto L_0x004d
            r1.close()
        L_0x004d:
            return r2
        L_0x004e:
            if (r1 == 0) goto L_0x007b
        L_0x0050:
            r1.close()
            goto L_0x007b
        L_0x0054:
            r2 = move-exception
            goto L_0x0075
        L_0x0056:
            r3 = move-exception
            java.lang.String r4 = "FilePickerUtils"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0054 }
            r5.<init>()     // Catch:{ all -> 0x0054 }
            java.lang.String r6 = "Failed to decode file name: "
            r5.append(r6)     // Catch:{ all -> 0x0054 }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x0054 }
            r5.append(r6)     // Catch:{ all -> 0x0054 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0054 }
            android.util.Log.e(r4, r5)     // Catch:{ all -> 0x0054 }
            if (r1 == 0) goto L_0x007b
            goto L_0x0050
        L_0x0075:
            if (r1 == 0) goto L_0x007a
            r1.close()
        L_0x007a:
            throw r2
        L_0x007b:
            java.lang.String r1 = r9.getPath()
            if (r1 == 0) goto L_0x0093
            java.lang.String r0 = r9.getPath()
            r1 = 47
            int r1 = r0.lastIndexOf(r1)
            if (r1 == r2) goto L_0x0093
            int r2 = r1 + 1
            java.lang.String r0 = r0.substring(r2)
        L_0x0093:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mr.flutter.plugin.filepicker.FileUtils.getFileName(android.net.Uri, android.content.Context):java.lang.String");
    }

    public static boolean clearCache(Context context) {
        try {
            File[] files = new File(context.getCacheDir() + "/file_picker/").listFiles();
            if (files == null) {
                return true;
            }
            for (File file : files) {
                file.delete();
            }
            return true;
        } catch (Exception ex) {
            Log.e(TAG, "There was an error while clearing cached files: " + ex.toString());
            return false;
        }
    }

    public static FileInfo openFileStream(Context context, Uri uri, boolean withData) {
        int len;
        BufferedOutputStream out;
        Uri uri2 = uri;
        Log.i(TAG, "Caching from URI: " + uri.toString());
        FileOutputStream fos = null;
        FileInfo.Builder fileInfo = new FileInfo.Builder();
        String fileName = getFileName(uri2, context);
        StringBuilder sb = new StringBuilder();
        sb.append(context.getCacheDir().getAbsolutePath());
        sb.append("/file_picker/");
        sb.append(fileName != null ? fileName : Integer.valueOf(new Random().nextInt(100000)));
        String path = sb.toString();
        File file = new File(path);
        if (!file.exists() || !withData) {
            file.getParentFile().mkdirs();
            try {
                fos = new FileOutputStream(path);
                try {
                    BufferedOutputStream out2 = new BufferedOutputStream(fos);
                    InputStream in = context.getContentResolver().openInputStream(uri2);
                    byte[] buffer = new byte[8192];
                    while (true) {
                        int read = in.read(buffer);
                        len = read;
                        if (read < 0) {
                            break;
                        }
                        int len2 = len;
                        out2.write(buffer, 0, len2);
                        int i = len2;
                    }
                    if (withData) {
                        out = out2;
                        byte[] bytes = new byte[((int) file.length())];
                        FileInputStream fis = new FileInputStream(file);
                        fis.read(bytes);
                        fis.close();
                        fileInfo.withData(bytes);
                    } else {
                        out = out2;
                    }
                } catch (Exception e) {
                    Log.e(TAG, "Failed to load bytes into memory with error " + e.toString() + ". Probably the file is too big to fit device memory. Bytes won't be added to the file this time.");
                } catch (Throwable th) {
                    fos.getFD().sync();
                    throw th;
                }
                out.flush();
                fos.getFD().sync();
            } catch (Exception e2) {
                Exception e3 = e2;
                try {
                    fos.close();
                    Log.e(TAG, "Failed to retrieve path: " + e3.getMessage(), (Throwable) null);
                    return null;
                } catch (IOException | NullPointerException e4) {
                    Log.e(TAG, "Failed to close file streams: " + e3.getMessage(), (Throwable) null);
                    return null;
                }
            }
        } else {
            byte[] bytes2 = new byte[((int) file.length())];
            try {
                BufferedInputStream buf = new BufferedInputStream(new FileInputStream(file));
                buf.read(bytes2, 0, bytes2.length);
                buf.close();
            } catch (FileNotFoundException e5) {
                Log.e(TAG, "File not found: " + e5.getMessage(), (Throwable) null);
            } catch (IOException e6) {
                Log.e(TAG, "Failed to close file streams: " + e6.getMessage(), (Throwable) null);
            }
            fileInfo.withData(bytes2);
        }
        Log.d(TAG, "File loaded and cached at:" + path);
        fileInfo.withPath(path).withName(fileName).withSize(Integer.parseInt(String.valueOf(file.length() / 1024)));
        return fileInfo.build();
    }

    @Nullable
    public static String getFullPathFromTreeUri(@Nullable Uri treeUri, Context con) {
        if (treeUri == null) {
            return null;
        }
        String volumePath = getVolumePath(getVolumeIdFromTreeUri(treeUri), con);
        new FileInfo.Builder();
        if (volumePath == null) {
            return File.separator;
        }
        if (volumePath.endsWith(File.separator)) {
            volumePath = volumePath.substring(0, volumePath.length() - 1);
        }
        String documentPath = getDocumentPathFromTreeUri(treeUri);
        if (documentPath.endsWith(File.separator)) {
            documentPath = documentPath.substring(0, documentPath.length() - 1);
        }
        if (documentPath.length() <= 0) {
            return volumePath;
        }
        if (documentPath.startsWith(File.separator)) {
            return volumePath + documentPath;
        }
        return volumePath + File.separator + documentPath;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    private static String getVolumePath(String volumeId, Context context) {
        String str = volumeId;
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        try {
            StorageManager mStorageManager = (StorageManager) context.getSystemService("storage");
            Class<?> storageVolumeClazz = Class.forName("android.os.storage.StorageVolume");
            Method getVolumeList = mStorageManager.getClass().getMethod("getVolumeList", new Class[0]);
            Method getUuid = storageVolumeClazz.getMethod("getUuid", new Class[0]);
            Method getPath = storageVolumeClazz.getMethod("getPath", new Class[0]);
            Method isPrimary = storageVolumeClazz.getMethod("isPrimary", new Class[0]);
            Object result = getVolumeList.invoke(mStorageManager, new Object[0]);
            int length = Array.getLength(result);
            for (int i = 0; i < length; i++) {
                Object storageVolumeElement = Array.get(result, i);
                String uuid = (String) getUuid.invoke(storageVolumeElement, new Object[0]);
                if (((Boolean) isPrimary.invoke(storageVolumeElement, new Object[0])).booleanValue() && PRIMARY_VOLUME_NAME.equals(str)) {
                    return (String) getPath.invoke(storageVolumeElement, new Object[0]);
                }
                if (uuid != null && uuid.equals(str)) {
                    return (String) getPath.invoke(storageVolumeElement, new Object[0]);
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @TargetApi(21)
    private static String getVolumeIdFromTreeUri(Uri treeUri) {
        String[] split = DocumentsContract.getTreeDocumentId(treeUri).split(":");
        if (split.length > 0) {
            return split[0];
        }
        return null;
    }

    @TargetApi(21)
    private static String getDocumentPathFromTreeUri(Uri treeUri) {
        String[] split = DocumentsContract.getTreeDocumentId(treeUri).split(":");
        if (split.length < 2 || split[1] == null) {
            return File.separator;
        }
        return split[1];
    }
}
