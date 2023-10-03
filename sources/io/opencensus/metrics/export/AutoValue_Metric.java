package io.opencensus.metrics.export;

import java.util.List;

final class AutoValue_Metric extends Metric {
    private final MetricDescriptor metricDescriptor;
    private final List<TimeSeries> timeSeriesList;

    AutoValue_Metric(MetricDescriptor metricDescriptor2, List<TimeSeries> timeSeriesList2) {
        if (metricDescriptor2 != null) {
            this.metricDescriptor = metricDescriptor2;
            if (timeSeriesList2 != null) {
                this.timeSeriesList = timeSeriesList2;
                return;
            }
            throw new NullPointerException("Null timeSeriesList");
        }
        throw new NullPointerException("Null metricDescriptor");
    }

    public MetricDescriptor getMetricDescriptor() {
        return this.metricDescriptor;
    }

    public List<TimeSeries> getTimeSeriesList() {
        return this.timeSeriesList;
    }

    public String toString() {
        return "Metric{metricDescriptor=" + this.metricDescriptor + ", timeSeriesList=" + this.timeSeriesList + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Metric)) {
            return false;
        }
        Metric that = (Metric) o;
        if (!this.metricDescriptor.equals(that.getMetricDescriptor()) || !this.timeSeriesList.equals(that.getTimeSeriesList())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((1 * 1000003) ^ this.metricDescriptor.hashCode()) * 1000003) ^ this.timeSeriesList.hashCode();
    }
}
