package io.opencensus.metrics.data;

public abstract class AttachmentValue {
    public abstract String getValue();

    public static abstract class AttachmentValueString extends AttachmentValue {
        AttachmentValueString() {
        }

        public static AttachmentValueString create(String value) {
            return new AutoValue_AttachmentValue_AttachmentValueString(value);
        }
    }
}
