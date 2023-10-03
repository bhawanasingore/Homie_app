package com.google.firebase.firestore.util;

import android.os.Build;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public class FileUtil {
    public static void delete(File file) throws IOException {
        if (Build.VERSION.SDK_INT >= 26) {
            DefaultFileDeleter.delete(file);
        } else {
            LegacyFileDeleter.delete(file);
        }
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    private static class DefaultFileDeleter {
        private DefaultFileDeleter() {
        }

        public static void delete(File file) throws IOException {
            try {
                Files.deleteIfExists(file.toPath());
            } catch (IOException e) {
                throw new IOException("Failed to delete file " + file + ": " + e);
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    private static class LegacyFileDeleter {
        private LegacyFileDeleter() {
        }

        public static void delete(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                throw new IOException("Failed to delete file " + file);
            }
        }
    }
}
