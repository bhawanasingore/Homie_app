package io.opencensus.stats;

import io.opencensus.common.Duration;
import io.opencensus.common.Function;
import io.opencensus.common.Functions;
import io.opencensus.common.Timestamp;
import io.opencensus.stats.Aggregation;
import io.opencensus.stats.AggregationData;
import io.opencensus.stats.Measure;
import io.opencensus.stats.View;
import io.opencensus.tags.TagValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ViewData {
    public abstract Map<List<TagValue>, AggregationData> getAggregationMap();

    public abstract Timestamp getEnd();

    public abstract Timestamp getStart();

    public abstract View getView();

    @Deprecated
    public abstract AggregationWindowData getWindowData();

    ViewData() {
    }

    @Deprecated
    public static ViewData create(final View view, Map<? extends List<TagValue>, ? extends AggregationData> map, AggregationWindowData windowData) {
        checkWindow(view.getWindow(), windowData);
        final Map<List<TagValue>, AggregationData> deepCopy = new HashMap<>();
        for (Map.Entry<? extends List<TagValue>, ? extends AggregationData> entry : map.entrySet()) {
            checkAggregation(view.getAggregation(), (AggregationData) entry.getValue(), view.getMeasure());
            deepCopy.put(Collections.unmodifiableList(new ArrayList((Collection) entry.getKey())), entry.getValue());
        }
        return (ViewData) windowData.match(new Function<AggregationWindowData.CumulativeData, ViewData>() {
            public ViewData apply(AggregationWindowData.CumulativeData arg) {
                return ViewData.createInternal(View.this, Collections.unmodifiableMap(deepCopy), arg, arg.getStart(), arg.getEnd());
            }
        }, new Function<AggregationWindowData.IntervalData, ViewData>() {
            public ViewData apply(AggregationWindowData.IntervalData arg) {
                Duration duration = ((View.AggregationWindow.Interval) View.this.getWindow()).getDuration();
                return ViewData.createInternal(View.this, Collections.unmodifiableMap(deepCopy), arg, arg.getEnd().addDuration(Duration.create(-duration.getSeconds(), -duration.getNanos())), arg.getEnd());
            }
        }, Functions.throwAssertionError());
    }

    public static ViewData create(View view, Map<? extends List<TagValue>, ? extends AggregationData> map, Timestamp start, Timestamp end) {
        Map<List<TagValue>, AggregationData> deepCopy = new HashMap<>();
        for (Map.Entry<? extends List<TagValue>, ? extends AggregationData> entry : map.entrySet()) {
            checkAggregation(view.getAggregation(), (AggregationData) entry.getValue(), view.getMeasure());
            deepCopy.put(Collections.unmodifiableList(new ArrayList((Collection) entry.getKey())), entry.getValue());
        }
        return createInternal(view, Collections.unmodifiableMap(deepCopy), AggregationWindowData.CumulativeData.create(start, end), start, end);
    }

    /* access modifiers changed from: private */
    public static ViewData createInternal(View view, Map<List<TagValue>, AggregationData> aggregationMap, AggregationWindowData window, Timestamp start, Timestamp end) {
        return new AutoValue_ViewData(view, aggregationMap, window, start, end);
    }

    private static void checkWindow(View.AggregationWindow window, final AggregationWindowData windowData) {
        window.match(new Function<View.AggregationWindow.Cumulative, Void>() {
            public Void apply(View.AggregationWindow.Cumulative arg) {
                AggregationWindowData aggregationWindowData = AggregationWindowData.this;
                ViewData.throwIfWindowMismatch(aggregationWindowData instanceof AggregationWindowData.CumulativeData, arg, aggregationWindowData);
                return null;
            }
        }, new Function<View.AggregationWindow.Interval, Void>() {
            public Void apply(View.AggregationWindow.Interval arg) {
                AggregationWindowData aggregationWindowData = AggregationWindowData.this;
                ViewData.throwIfWindowMismatch(aggregationWindowData instanceof AggregationWindowData.IntervalData, arg, aggregationWindowData);
                return null;
            }
        }, Functions.throwAssertionError());
    }

    /* access modifiers changed from: private */
    public static void throwIfWindowMismatch(boolean isValid, View.AggregationWindow window, AggregationWindowData windowData) {
        if (!isValid) {
            throw new IllegalArgumentException(createErrorMessageForWindow(window, windowData));
        }
    }

    private static String createErrorMessageForWindow(View.AggregationWindow window, AggregationWindowData windowData) {
        return "AggregationWindow and AggregationWindowData types mismatch. AggregationWindow: " + window.getClass().getSimpleName() + " AggregationWindowData: " + windowData.getClass().getSimpleName();
    }

    private static void checkAggregation(final Aggregation aggregation, final AggregationData aggregationData, final Measure measure) {
        aggregation.match(new Function<Aggregation.Sum, Void>() {
            public Void apply(Aggregation.Sum arg) {
                Measure.this.match(new Function<Measure.MeasureDouble, Void>() {
                    public Void apply(Measure.MeasureDouble arg) {
                        ViewData.throwIfAggregationMismatch(aggregationData instanceof AggregationData.SumDataDouble, aggregation, aggregationData);
                        return null;
                    }
                }, new Function<Measure.MeasureLong, Void>() {
                    public Void apply(Measure.MeasureLong arg) {
                        ViewData.throwIfAggregationMismatch(aggregationData instanceof AggregationData.SumDataLong, aggregation, aggregationData);
                        return null;
                    }
                }, Functions.throwAssertionError());
                return null;
            }
        }, new Function<Aggregation.Count, Void>() {
            public Void apply(Aggregation.Count arg) {
                AggregationData aggregationData = AggregationData.this;
                ViewData.throwIfAggregationMismatch(aggregationData instanceof AggregationData.CountData, aggregation, aggregationData);
                return null;
            }
        }, new Function<Aggregation.Distribution, Void>() {
            public Void apply(Aggregation.Distribution arg) {
                AggregationData aggregationData = AggregationData.this;
                ViewData.throwIfAggregationMismatch(aggregationData instanceof AggregationData.DistributionData, aggregation, aggregationData);
                return null;
            }
        }, new Function<Aggregation.LastValue, Void>() {
            public Void apply(Aggregation.LastValue arg) {
                Measure.this.match(new Function<Measure.MeasureDouble, Void>() {
                    public Void apply(Measure.MeasureDouble arg) {
                        ViewData.throwIfAggregationMismatch(aggregationData instanceof AggregationData.LastValueDataDouble, aggregation, aggregationData);
                        return null;
                    }
                }, new Function<Measure.MeasureLong, Void>() {
                    public Void apply(Measure.MeasureLong arg) {
                        ViewData.throwIfAggregationMismatch(aggregationData instanceof AggregationData.LastValueDataLong, aggregation, aggregationData);
                        return null;
                    }
                }, Functions.throwAssertionError());
                return null;
            }
        }, new Function<Aggregation, Void>() {
            public Void apply(Aggregation arg) {
                if (arg instanceof Aggregation.Mean) {
                    AggregationData aggregationData = AggregationData.this;
                    ViewData.throwIfAggregationMismatch(aggregationData instanceof AggregationData.MeanData, aggregation, aggregationData);
                    return null;
                }
                throw new AssertionError();
            }
        });
    }

    /* access modifiers changed from: private */
    public static void throwIfAggregationMismatch(boolean isValid, Aggregation aggregation, AggregationData aggregationData) {
        if (!isValid) {
            throw new IllegalArgumentException(createErrorMessageForAggregation(aggregation, aggregationData));
        }
    }

    private static String createErrorMessageForAggregation(Aggregation aggregation, AggregationData aggregationData) {
        return "Aggregation and AggregationData types mismatch. Aggregation: " + aggregation.getClass().getSimpleName() + " AggregationData: " + aggregationData.getClass().getSimpleName();
    }

    @Deprecated
    public static abstract class AggregationWindowData {
        public abstract <T> T match(Function<? super CumulativeData, T> function, Function<? super IntervalData, T> function2, Function<? super AggregationWindowData, T> function3);

        private AggregationWindowData() {
        }

        @Deprecated
        public static abstract class CumulativeData extends AggregationWindowData {
            public abstract Timestamp getEnd();

            public abstract Timestamp getStart();

            CumulativeData() {
                super();
            }

            public final <T> T match(Function<? super CumulativeData, T> p0, Function<? super IntervalData, T> function, Function<? super AggregationWindowData, T> function2) {
                return p0.apply(this);
            }

            public static CumulativeData create(Timestamp start, Timestamp end) {
                if (start.compareTo(end) <= 0) {
                    return new AutoValue_ViewData_AggregationWindowData_CumulativeData(start, end);
                }
                throw new IllegalArgumentException("Start time is later than end time.");
            }
        }

        @Deprecated
        public static abstract class IntervalData extends AggregationWindowData {
            public abstract Timestamp getEnd();

            IntervalData() {
                super();
            }

            public final <T> T match(Function<? super CumulativeData, T> function, Function<? super IntervalData, T> p1, Function<? super AggregationWindowData, T> function2) {
                return p1.apply(this);
            }

            public static IntervalData create(Timestamp end) {
                return new AutoValue_ViewData_AggregationWindowData_IntervalData(end);
            }
        }
    }
}
