package io.opencensus.stats;

import io.opencensus.internal.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class BucketBoundaries {
    private static final Logger logger = Logger.getLogger(BucketBoundaries.class.getName());

    public abstract List<Double> getBoundaries();

    public static final BucketBoundaries create(List<Double> bucketBoundaries) {
        Utils.checkNotNull(bucketBoundaries, "bucketBoundaries");
        List<Double> bucketBoundariesCopy = new ArrayList<>(bucketBoundaries);
        if (bucketBoundariesCopy.size() > 1) {
            double previous = bucketBoundariesCopy.get(0).doubleValue();
            for (int i = 1; i < bucketBoundariesCopy.size(); i++) {
                double next = bucketBoundariesCopy.get(i).doubleValue();
                Utils.checkArgument(previous < next, "Bucket boundaries not sorted.");
                previous = next;
            }
        }
        return new AutoValue_BucketBoundaries(Collections.unmodifiableList(dropNegativeBucketBounds(bucketBoundariesCopy)));
    }

    private static List<Double> dropNegativeBucketBounds(List<Double> bucketBoundaries) {
        int negativeBucketBounds = 0;
        int zeroBucketBounds = 0;
        for (Double value : bucketBoundaries) {
            if (value.doubleValue() > 0.0d) {
                break;
            } else if (value.doubleValue() == 0.0d) {
                zeroBucketBounds++;
            } else {
                negativeBucketBounds++;
            }
        }
        if (negativeBucketBounds > 0) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            logger2.log(level, "Dropping " + negativeBucketBounds + " negative bucket boundaries, the values must be strictly > 0.");
        }
        return bucketBoundaries.subList(negativeBucketBounds + zeroBucketBounds, bucketBoundaries.size());
    }
}
