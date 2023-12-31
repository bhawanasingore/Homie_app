package io.opencensus.stats;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.opencensus.common.Functions;
import io.opencensus.common.Timestamp;
import io.opencensus.internal.Utils;
import io.opencensus.stats.Measure;
import io.opencensus.stats.View;
import io.opencensus.stats.ViewData;
import io.opencensus.tags.TagContext;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

final class NoopStats {
    private NoopStats() {
    }

    static StatsComponent newNoopStatsComponent() {
        return new NoopStatsComponent();
    }

    static StatsRecorder getNoopStatsRecorder() {
        return NoopStatsRecorder.INSTANCE;
    }

    static MeasureMap newNoopMeasureMap() {
        return new NoopMeasureMap();
    }

    static ViewManager newNoopViewManager() {
        return new NoopViewManager();
    }

    private static final class NoopStatsComponent extends StatsComponent {
        private volatile boolean isRead;
        private final ViewManager viewManager;

        private NoopStatsComponent() {
            this.viewManager = NoopStats.newNoopViewManager();
        }

        public ViewManager getViewManager() {
            return this.viewManager;
        }

        public StatsRecorder getStatsRecorder() {
            return NoopStats.getNoopStatsRecorder();
        }

        public StatsCollectionState getState() {
            this.isRead = true;
            return StatsCollectionState.DISABLED;
        }

        @Deprecated
        public void setState(StatsCollectionState state) {
            Utils.checkNotNull(state, "state");
            Utils.checkState(!this.isRead, "State was already read, cannot set state.");
        }
    }

    private static final class NoopStatsRecorder extends StatsRecorder {
        static final StatsRecorder INSTANCE = new NoopStatsRecorder();

        private NoopStatsRecorder() {
        }

        public MeasureMap newMeasureMap() {
            return NoopStats.newNoopMeasureMap();
        }
    }

    private static final class NoopMeasureMap extends MeasureMap {
        private static final Logger logger = Logger.getLogger(NoopMeasureMap.class.getName());
        private boolean hasUnsupportedValues;

        private NoopMeasureMap() {
        }

        public MeasureMap put(Measure.MeasureDouble measure, double value) {
            if (value < 0.0d) {
                this.hasUnsupportedValues = true;
            }
            return this;
        }

        public MeasureMap put(Measure.MeasureLong measure, long value) {
            if (value < 0) {
                this.hasUnsupportedValues = true;
            }
            return this;
        }

        public void record() {
        }

        public void record(TagContext tags) {
            Utils.checkNotNull(tags, "tags");
            if (this.hasUnsupportedValues) {
                logger.log(Level.WARNING, "Dropping values, value to record must be non-negative.");
            }
        }
    }

    private static final class NoopViewManager extends ViewManager {
        private static final Timestamp ZERO_TIMESTAMP = Timestamp.create(0, 0);
        @Nullable
        private volatile Set<View> exportedViews;
        private final Map<View.Name, View> registeredViews;

        private NoopViewManager() {
            this.registeredViews = new HashMap();
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x002a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void registerView(io.opencensus.stats.View r5) {
            /*
                r4 = this;
                java.lang.String r0 = "newView"
                io.opencensus.internal.Utils.checkNotNull(r5, r0)
                java.util.Map<io.opencensus.stats.View$Name, io.opencensus.stats.View> r0 = r4.registeredViews
                monitor-enter(r0)
                r1 = 0
                r4.exportedViews = r1     // Catch:{ all -> 0x0035 }
                java.util.Map<io.opencensus.stats.View$Name, io.opencensus.stats.View> r1 = r4.registeredViews     // Catch:{ all -> 0x0035 }
                io.opencensus.stats.View$Name r2 = r5.getName()     // Catch:{ all -> 0x0035 }
                java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0035 }
                io.opencensus.stats.View r1 = (io.opencensus.stats.View) r1     // Catch:{ all -> 0x0035 }
                if (r1 == 0) goto L_0x0022
                boolean r2 = r5.equals(r1)     // Catch:{ all -> 0x0035 }
                if (r2 == 0) goto L_0x0020
                goto L_0x0022
            L_0x0020:
                r2 = 0
                goto L_0x0023
            L_0x0022:
                r2 = 1
            L_0x0023:
                java.lang.String r3 = "A different view with the same name already exists."
                io.opencensus.internal.Utils.checkArgument(r2, r3)     // Catch:{ all -> 0x0035 }
                if (r1 != 0) goto L_0x0033
                java.util.Map<io.opencensus.stats.View$Name, io.opencensus.stats.View> r2 = r4.registeredViews     // Catch:{ all -> 0x0035 }
                io.opencensus.stats.View$Name r3 = r5.getName()     // Catch:{ all -> 0x0035 }
                r2.put(r3, r5)     // Catch:{ all -> 0x0035 }
            L_0x0033:
                monitor-exit(r0)     // Catch:{ all -> 0x0035 }
                return
            L_0x0035:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0035 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.opencensus.stats.NoopStats.NoopViewManager.registerView(io.opencensus.stats.View):void");
        }

        @Nullable
        public ViewData getView(View.Name name) {
            Utils.checkNotNull(name, AppMeasurementSdk.ConditionalUserProperty.NAME);
            synchronized (this.registeredViews) {
                View view = this.registeredViews.get(name);
                if (view == null) {
                    return null;
                }
                ViewData create = ViewData.create(view, Collections.emptyMap(), (ViewData.AggregationWindowData) view.getWindow().match(Functions.returnConstant(ViewData.AggregationWindowData.CumulativeData.create(ZERO_TIMESTAMP, ZERO_TIMESTAMP)), Functions.returnConstant(ViewData.AggregationWindowData.IntervalData.create(ZERO_TIMESTAMP)), Functions.throwAssertionError()));
                return create;
            }
        }

        public Set<View> getAllExportedViews() {
            Set<View> views = this.exportedViews;
            if (views == null) {
                synchronized (this.registeredViews) {
                    Set<View> filterExportedViews = filterExportedViews(this.registeredViews.values());
                    views = filterExportedViews;
                    this.exportedViews = filterExportedViews;
                }
            }
            return views;
        }

        private static Set<View> filterExportedViews(Collection<View> allViews) {
            Set<View> views = new HashSet<>();
            for (View view : allViews) {
                if (!(view.getWindow() instanceof View.AggregationWindow.Interval)) {
                    views.add(view);
                }
            }
            return Collections.unmodifiableSet(views);
        }
    }
}
