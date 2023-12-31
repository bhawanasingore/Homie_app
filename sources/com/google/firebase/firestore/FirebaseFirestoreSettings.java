package com.google.firebase.firestore;

import com.google.firebase.firestore.util.Preconditions;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public final class FirebaseFirestoreSettings {
    public static final long CACHE_SIZE_UNLIMITED = -1;
    private static final long DEFAULT_CACHE_SIZE_BYTES = 104857600;
    private static final String DEFAULT_HOST = "firestore.googleapis.com";
    private static final boolean DEFAULT_TIMESTAMPS_IN_SNAPSHOTS_ENABLED = true;
    private static final long MINIMUM_CACHE_BYTES = 1048576;
    private final long cacheSizeBytes;
    /* access modifiers changed from: private */
    public final String host;
    /* access modifiers changed from: private */
    public final boolean persistenceEnabled;
    /* access modifiers changed from: private */
    public final boolean sslEnabled;
    /* access modifiers changed from: private */
    public final boolean timestampsInSnapshotsEnabled;

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder {
        /* access modifiers changed from: private */
        public long cacheSizeBytes;
        /* access modifiers changed from: private */
        public String host;
        /* access modifiers changed from: private */
        public boolean persistenceEnabled;
        /* access modifiers changed from: private */
        public boolean sslEnabled;
        /* access modifiers changed from: private */
        public boolean timestampsInSnapshotsEnabled;

        public Builder() {
            this.host = FirebaseFirestoreSettings.DEFAULT_HOST;
            this.sslEnabled = true;
            this.persistenceEnabled = true;
            this.timestampsInSnapshotsEnabled = true;
            this.cacheSizeBytes = FirebaseFirestoreSettings.DEFAULT_CACHE_SIZE_BYTES;
        }

        public Builder(FirebaseFirestoreSettings settings) {
            Preconditions.checkNotNull(settings, "Provided settings must not be null.");
            this.host = settings.host;
            this.sslEnabled = settings.sslEnabled;
            this.persistenceEnabled = settings.persistenceEnabled;
            this.timestampsInSnapshotsEnabled = settings.timestampsInSnapshotsEnabled;
        }

        public Builder setHost(String host2) {
            this.host = (String) Preconditions.checkNotNull(host2, "Provided host must not be null.");
            return this;
        }

        public Builder setSslEnabled(boolean value) {
            this.sslEnabled = value;
            return this;
        }

        public Builder setPersistenceEnabled(boolean value) {
            this.persistenceEnabled = value;
            return this;
        }

        @Deprecated
        public Builder setTimestampsInSnapshotsEnabled(boolean value) {
            this.timestampsInSnapshotsEnabled = value;
            return this;
        }

        public Builder setCacheSizeBytes(long value) {
            if (value == -1 || value >= FirebaseFirestoreSettings.MINIMUM_CACHE_BYTES) {
                this.cacheSizeBytes = value;
                return this;
            }
            throw new IllegalArgumentException("Cache size must be set to at least 1048576 bytes");
        }

        public String getHost() {
            return this.host;
        }

        public boolean isSslEnabled() {
            return this.sslEnabled;
        }

        public boolean isPersistenceEnabled() {
            return this.persistenceEnabled;
        }

        public long getCacheSizeBytes() {
            return this.cacheSizeBytes;
        }

        public FirebaseFirestoreSettings build() {
            if (this.sslEnabled || !this.host.equals(FirebaseFirestoreSettings.DEFAULT_HOST)) {
                return new FirebaseFirestoreSettings(this);
            }
            throw new IllegalStateException("You can't set the 'sslEnabled' setting unless you also set a non-default 'host'.");
        }
    }

    private FirebaseFirestoreSettings(Builder builder) {
        this.host = builder.host;
        this.sslEnabled = builder.sslEnabled;
        this.persistenceEnabled = builder.persistenceEnabled;
        this.timestampsInSnapshotsEnabled = builder.timestampsInSnapshotsEnabled;
        this.cacheSizeBytes = builder.cacheSizeBytes;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FirebaseFirestoreSettings that = (FirebaseFirestoreSettings) o;
        if (this.host.equals(that.host) && this.sslEnabled == that.sslEnabled && this.persistenceEnabled == that.persistenceEnabled && this.timestampsInSnapshotsEnabled == that.timestampsInSnapshotsEnabled && this.cacheSizeBytes == that.cacheSizeBytes) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.host.hashCode() * 31) + (this.sslEnabled ? 1 : 0)) * 31) + (this.persistenceEnabled ? 1 : 0)) * 31) + (this.timestampsInSnapshotsEnabled ? 1 : 0)) * 31) + ((int) this.cacheSizeBytes);
    }

    public String toString() {
        return "FirebaseFirestoreSettings{host=" + this.host + ", sslEnabled=" + this.sslEnabled + ", persistenceEnabled=" + this.persistenceEnabled + ", timestampsInSnapshotsEnabled=" + this.timestampsInSnapshotsEnabled + ", cacheSizeBytes=" + this.cacheSizeBytes + "}";
    }

    public String getHost() {
        return this.host;
    }

    public boolean isSslEnabled() {
        return this.sslEnabled;
    }

    public boolean isPersistenceEnabled() {
        return this.persistenceEnabled;
    }

    public boolean areTimestampsInSnapshotsEnabled() {
        return this.timestampsInSnapshotsEnabled;
    }

    public long getCacheSizeBytes() {
        return this.cacheSizeBytes;
    }
}
