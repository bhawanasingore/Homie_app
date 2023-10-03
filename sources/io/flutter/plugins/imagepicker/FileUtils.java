package io.flutter.plugins.imagepicker;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class FileUtils {
    FileUtils() {
    }

    /* access modifiers changed from: package-private */
    public String getPathFromUri(Context context, Uri uri) {
        File file = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        boolean success = false;
        try {
            String extension = getImageExtension(uri);
            InputStream inputStream2 = context.getContentResolver().openInputStream(uri);
            file = File.createTempFile("image_picker", extension, context.getCacheDir());
            file.deleteOnExit();
            OutputStream outputStream2 = new FileOutputStream(file);
            if (inputStream2 != null) {
                copy(inputStream2, outputStream2);
                success = true;
            }
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException e) {
                }
            }
            try {
                outputStream2.close();
            } catch (IOException e2) {
                success = false;
            }
        } catch (IOException e3) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                }
            }
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e6) {
                }
            }
            throw th;
        }
        if (success) {
            return file.getPath();
        }
        return null;
    }

    private static String getImageExtension(Uri uriImage) {
        String extension = null;
        try {
            String imagePath = uriImage.getPath();
            if (!(imagePath == null || imagePath.lastIndexOf(".") == -1)) {
                extension = imagePath.substring(imagePath.lastIndexOf(".") + 1);
            }
        } catch (Exception e) {
            extension = null;
        }
        if (extension == null || extension.isEmpty()) {
            extension = "jpg";
        }
        return "." + extension;
    }

    private static void copy(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[4096];
        while (true) {
            int read = in.read(buffer);
            int bytesRead = read;
            if (read != -1) {
                out.write(buffer, 0, bytesRead);
            } else {
                out.flush();
                return;
            }
        }
    }
}
