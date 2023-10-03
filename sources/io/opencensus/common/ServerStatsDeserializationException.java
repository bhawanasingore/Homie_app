package io.opencensus.common;

public final class ServerStatsDeserializationException extends Exception {
    private static final long serialVersionUID = 0;

    public ServerStatsDeserializationException(String message) {
        super(message);
    }

    public ServerStatsDeserializationException(String message, Throwable cause) {
        super(message, cause);
    }
}
