package io.opencensus.tags.propagation;

public final class TagContextSerializationException extends Exception {
    private static final long serialVersionUID = 0;

    public TagContextSerializationException(String message) {
        super(message);
    }

    public TagContextSerializationException(String message, Throwable cause) {
        super(message, cause);
    }
}
