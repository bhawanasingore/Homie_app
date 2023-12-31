package io.opencensus.stats;

import io.opencensus.common.Duration;
import io.opencensus.common.Function;
import io.opencensus.internal.StringUtils;
import io.opencensus.internal.Utils;
import io.opencensus.tags.TagKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public abstract class View {
    static final int NAME_MAX_LENGTH = 255;
    private static final Comparator<TagKey> TAG_KEY_COMPARATOR = new Comparator<TagKey>() {
        public int compare(TagKey key1, TagKey key2) {
            return key1.getName().compareToIgnoreCase(key2.getName());
        }
    };

    public abstract Aggregation getAggregation();

    public abstract List<TagKey> getColumns();

    public abstract String getDescription();

    public abstract Measure getMeasure();

    public abstract Name getName();

    @Deprecated
    public abstract AggregationWindow getWindow();

    View() {
    }

    @Deprecated
    public static View create(Name name, String description, Measure measure, Aggregation aggregation, List<TagKey> columns, AggregationWindow window) {
        Utils.checkArgument(new HashSet(columns).size() == columns.size(), "Columns have duplicate.");
        List<TagKey> tagKeys = new ArrayList<>(columns);
        Collections.sort(tagKeys, TAG_KEY_COMPARATOR);
        return new AutoValue_View(name, description, measure, aggregation, Collections.unmodifiableList(tagKeys), window);
    }

    public static View create(Name name, String description, Measure measure, Aggregation aggregation, List<TagKey> columns) {
        Utils.checkArgument(new HashSet(columns).size() == columns.size(), "Columns have duplicate.");
        return create(name, description, measure, aggregation, columns, AggregationWindow.Cumulative.create());
    }

    public static abstract class Name {
        public abstract String asString();

        Name() {
        }

        public static Name create(String name) {
            Utils.checkArgument(StringUtils.isPrintableString(name) && name.length() <= 255, "Name should be a ASCII string with a length no greater than 255 characters.");
            return new AutoValue_View_Name(name);
        }
    }

    @Deprecated
    public static abstract class AggregationWindow {
        public abstract <T> T match(Function<? super Cumulative, T> function, Function<? super Interval, T> function2, Function<? super AggregationWindow, T> function3);

        private AggregationWindow() {
        }

        @Deprecated
        public static abstract class Cumulative extends AggregationWindow {
            private static final Cumulative CUMULATIVE = new AutoValue_View_AggregationWindow_Cumulative();

            Cumulative() {
                super();
            }

            public static Cumulative create() {
                return CUMULATIVE;
            }

            public final <T> T match(Function<? super Cumulative, T> p0, Function<? super Interval, T> function, Function<? super AggregationWindow, T> function2) {
                return p0.apply(this);
            }
        }

        @Deprecated
        public static abstract class Interval extends AggregationWindow {
            private static final Duration ZERO = Duration.create(0, 0);

            public abstract Duration getDuration();

            Interval() {
                super();
            }

            public static Interval create(Duration duration) {
                Utils.checkArgument(duration.compareTo(ZERO) > 0, "Duration must be positive");
                return new AutoValue_View_AggregationWindow_Interval(duration);
            }

            public final <T> T match(Function<? super Cumulative, T> function, Function<? super Interval, T> p1, Function<? super AggregationWindow, T> function2) {
                return p1.apply(this);
            }
        }
    }
}
