package io.opencensus.stats;

import io.opencensus.common.Function;
import io.opencensus.internal.StringUtils;
import io.opencensus.internal.Utils;

public abstract class Measure {
    private static final String ERROR_MESSAGE_INVALID_NAME = "Name should be a ASCII string with a length no greater than 255 characters.";
    static final int NAME_MAX_LENGTH = 255;

    public abstract String getDescription();

    public abstract String getName();

    public abstract String getUnit();

    public abstract <T> T match(Function<? super MeasureDouble, T> function, Function<? super MeasureLong, T> function2, Function<? super Measure, T> function3);

    private Measure() {
    }

    public static abstract class MeasureDouble extends Measure {
        public abstract String getDescription();

        public abstract String getName();

        public abstract String getUnit();

        MeasureDouble() {
            super();
        }

        public static MeasureDouble create(String name, String description, String unit) {
            Utils.checkArgument(StringUtils.isPrintableString(name) && name.length() <= 255, Measure.ERROR_MESSAGE_INVALID_NAME);
            return new AutoValue_Measure_MeasureDouble(name, description, unit);
        }

        public <T> T match(Function<? super MeasureDouble, T> p0, Function<? super MeasureLong, T> function, Function<? super Measure, T> function2) {
            return p0.apply(this);
        }
    }

    public static abstract class MeasureLong extends Measure {
        public abstract String getDescription();

        public abstract String getName();

        public abstract String getUnit();

        MeasureLong() {
            super();
        }

        public static MeasureLong create(String name, String description, String unit) {
            Utils.checkArgument(StringUtils.isPrintableString(name) && name.length() <= 255, Measure.ERROR_MESSAGE_INVALID_NAME);
            return new AutoValue_Measure_MeasureLong(name, description, unit);
        }

        public <T> T match(Function<? super MeasureDouble, T> function, Function<? super MeasureLong, T> p1, Function<? super Measure, T> function2) {
            return p1.apply(this);
        }
    }
}
