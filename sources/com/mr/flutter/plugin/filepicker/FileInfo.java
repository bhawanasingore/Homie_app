package com.mr.flutter.plugin.filepicker;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.HashMap;

public class FileInfo {
    final byte[] bytes;
    final String name;
    final String path;
    final int size;

    public FileInfo(String path2, String name2, int size2, byte[] bytes2) {
        this.path = path2;
        this.name = name2;
        this.size = size2;
        this.bytes = bytes2;
    }

    public static class Builder {
        private byte[] bytes;
        private String name;
        private String path;
        private int size;

        public Builder withPath(String path2) {
            this.path = path2;
            return this;
        }

        public Builder withName(String name2) {
            this.name = name2;
            return this;
        }

        public Builder withSize(int size2) {
            this.size = size2;
            return this;
        }

        public Builder withData(byte[] bytes2) {
            this.bytes = bytes2;
            return this;
        }

        public FileInfo build() {
            return new FileInfo(this.path, this.name, this.size, this.bytes);
        }
    }

    public HashMap<String, Object> toMap() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("path", this.path);
        data.put(AppMeasurementSdk.ConditionalUserProperty.NAME, this.name);
        data.put("size", Integer.valueOf(this.size));
        data.put("bytes", this.bytes);
        return data;
    }
}
