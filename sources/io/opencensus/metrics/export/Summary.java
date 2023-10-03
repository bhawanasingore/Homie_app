package io.opencensus.metrics.export;

import io.opencensus.internal.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

public abstract class Summary {
    @Nullable
    public abstract Long getCount();

    public abstract Snapshot getSnapshot();

    @Nullable
    public abstract Double getSum();

    Summary() {
    }

    public static Summary create(@Nullable Long count, @Nullable Double sum, Snapshot snapshot) {
        checkCountAndSum(count, sum);
        Utils.checkNotNull(snapshot, "snapshot");
        return new AutoValue_Summary(count, sum, snapshot);
    }

    public static abstract class Snapshot {
        @Nullable
        public abstract Long getCount();

        @Nullable
        public abstract Double getSum();

        public abstract List<ValueAtPercentile> getValueAtPercentiles();

        public static Snapshot create(@Nullable Long count, @Nullable Double sum, List<ValueAtPercentile> valueAtPercentiles) {
            Summary.checkCountAndSum(count, sum);
            Utils.checkListElementNotNull((List) Utils.checkNotNull(valueAtPercentiles, "valueAtPercentiles"), "valueAtPercentile");
            return new AutoValue_Summary_Snapshot(count, sum, Collections.unmodifiableList(new ArrayList(valueAtPercentiles)));
        }

        public static abstract class ValueAtPercentile {
            public abstract double getPercentile();

            public abstract double getValue();

            public static ValueAtPercentile create(double percentile, double value) {
                boolean z = true;
                Utils.checkArgument(0.0d < percentile && percentile <= 100.0d, "percentile must be in the interval (0.0, 100.0]");
                if (value < 0.0d) {
                    z = false;
                }
                Utils.checkArgument(z, "value must be non-negative");
                return new AutoValue_Summary_Snapshot_ValueAtPercentile(percentile, value);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void checkCountAndSum(@Nullable Long count, @Nullable Double sum) {
        boolean z = false;
        Utils.checkArgument(count == null || count.longValue() >= 0, "count must be non-negative.");
        Utils.checkArgument(sum == null || sum.doubleValue() >= 0.0d, "sum must be non-negative.");
        if (count != null && count.longValue() == 0) {
            if (sum == null || sum.doubleValue() == 0.0d) {
                z = true;
            }
            Utils.checkArgument(z, "sum must be 0 if count is 0.");
        }
    }
}
