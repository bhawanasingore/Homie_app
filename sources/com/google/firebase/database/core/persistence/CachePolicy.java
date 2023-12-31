package com.google.firebase.database.core.persistence;

/* compiled from: com.google.firebase:firebase-database@@19.3.0 */
public interface CachePolicy {
    public static final CachePolicy NONE = new CachePolicy() {
        public boolean shouldPrune(long currentSizeBytes, long countOfPrunableQueries) {
            return false;
        }

        public boolean shouldCheckCacheSize(long serverUpdatesSinceLastCheck) {
            return false;
        }

        public float getPercentOfQueriesToPruneAtOnce() {
            return 0.0f;
        }

        public long getMaxNumberOfQueriesToKeep() {
            return Long.MAX_VALUE;
        }
    };

    long getMaxNumberOfQueriesToKeep();

    float getPercentOfQueriesToPruneAtOnce();

    boolean shouldCheckCacheSize(long j);

    boolean shouldPrune(long j, long j2);
}
