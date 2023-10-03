package io.opencensus.tags.propagation;

public final class TagContextDeserializationException extends Exception {
    private static final long serialVersionUID = 0;

    public TagContextDeserializationException(String message) {
        super(message);
    }

    public TagContextDeserializationException(String message, Throwable cause) {
        super(message, cause);
    }
}
