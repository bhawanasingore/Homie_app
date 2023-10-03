package io.opencensus.trace.export;

public abstract class ExportComponent {
    public abstract RunningSpanStore getRunningSpanStore();

    public abstract SampledSpanStore getSampledSpanStore();

    public abstract SpanExporter getSpanExporter();

    public static ExportComponent newNoopExportComponent() {
        return new NoopExportComponent();
    }

    public void shutdown() {
    }

    private static final class NoopExportComponent extends ExportComponent {
        private final SampledSpanStore noopSampledSpanStore;

        private NoopExportComponent() {
            this.noopSampledSpanStore = SampledSpanStore.newNoopSampledSpanStore();
        }

        public SpanExporter getSpanExporter() {
            return SpanExporter.getNoopSpanExporter();
        }

        public RunningSpanStore getRunningSpanStore() {
            return RunningSpanStore.getNoopRunningSpanStore();
        }

        public SampledSpanStore getSampledSpanStore() {
            return this.noopSampledSpanStore;
        }
    }
}
