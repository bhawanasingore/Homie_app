package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.Header;
import io.grpc.okhttp.internal.framed.Settings;
import java.util.EnumMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.ByteString;

class OkHttpFrameLogger {
    private static final int BUFFER_LENGTH_THRESHOLD = 64;
    private final Level level;
    private final Logger logger;

    enum Direction {
        INBOUND,
        OUTBOUND
    }

    OkHttpFrameLogger(Level level2, Class<?> clazz) {
        this(level2, Logger.getLogger(clazz.getName()));
    }

    OkHttpFrameLogger(Level level2, Logger logger2) {
        this.level = (Level) Preconditions.checkNotNull(level2, FirebaseAnalytics.Param.LEVEL);
        this.logger = (Logger) Preconditions.checkNotNull(logger2, "logger");
    }

    private static String toString(Settings settings) {
        EnumMap<SettingParams, Integer> map = new EnumMap<>(SettingParams.class);
        for (SettingParams p : SettingParams.values()) {
            if (settings.isSet(p.getBit())) {
                map.put(p, Integer.valueOf(settings.get(p.getBit())));
            }
        }
        return map.toString();
    }

    private static String toString(Buffer buf) {
        if (buf.size() <= 64) {
            return buf.snapshot().hex();
        }
        return buf.snapshot((int) Math.min(buf.size(), 64)).hex() + "...";
    }

    private boolean isEnabled() {
        return this.logger.isLoggable(this.level);
    }

    /* access modifiers changed from: package-private */
    public void logData(Direction direction, int streamId, Buffer data, int length, boolean endStream) {
        if (isEnabled()) {
            Logger logger2 = this.logger;
            Level level2 = this.level;
            logger2.log(level2, direction + " DATA: streamId=" + streamId + " endStream=" + endStream + " length=" + length + " bytes=" + toString(data));
        }
    }

    /* access modifiers changed from: package-private */
    public void logHeaders(Direction direction, int streamId, List<Header> headers, boolean endStream) {
        if (isEnabled()) {
            Logger logger2 = this.logger;
            Level level2 = this.level;
            logger2.log(level2, direction + " HEADERS: streamId=" + streamId + " headers=" + headers + " endStream=" + endStream);
        }
    }

    public void logPriority(Direction direction, int streamId, int streamDependency, int weight, boolean exclusive) {
        if (isEnabled()) {
            Logger logger2 = this.logger;
            Level level2 = this.level;
            logger2.log(level2, direction + " PRIORITY: streamId=" + streamId + " streamDependency=" + streamDependency + " weight=" + weight + " exclusive=" + exclusive);
        }
    }

    /* access modifiers changed from: package-private */
    public void logRstStream(Direction direction, int streamId, ErrorCode errorCode) {
        if (isEnabled()) {
            Logger logger2 = this.logger;
            Level level2 = this.level;
            logger2.log(level2, direction + " RST_STREAM: streamId=" + streamId + " errorCode=" + errorCode);
        }
    }

    /* access modifiers changed from: package-private */
    public void logSettingsAck(Direction direction) {
        if (isEnabled()) {
            Logger logger2 = this.logger;
            Level level2 = this.level;
            logger2.log(level2, direction + " SETTINGS: ack=true");
        }
    }

    /* access modifiers changed from: package-private */
    public void logSettings(Direction direction, Settings settings) {
        if (isEnabled()) {
            Logger logger2 = this.logger;
            Level level2 = this.level;
            logger2.log(level2, direction + " SETTINGS: ack=false settings=" + toString(settings));
        }
    }

    /* access modifiers changed from: package-private */
    public void logPing(Direction direction, long data) {
        if (isEnabled()) {
            Logger logger2 = this.logger;
            Level level2 = this.level;
            logger2.log(level2, direction + " PING: ack=false bytes=" + data);
        }
    }

    /* access modifiers changed from: package-private */
    public void logPingAck(Direction direction, long data) {
        if (isEnabled()) {
            Logger logger2 = this.logger;
            Level level2 = this.level;
            logger2.log(level2, direction + " PING: ack=true bytes=" + data);
        }
    }

    /* access modifiers changed from: package-private */
    public void logPushPromise(Direction direction, int streamId, int promisedStreamId, List<Header> headers) {
        if (isEnabled()) {
            Logger logger2 = this.logger;
            Level level2 = this.level;
            logger2.log(level2, direction + " PUSH_PROMISE: streamId=" + streamId + " promisedStreamId=" + promisedStreamId + " headers=" + headers);
        }
    }

    /* access modifiers changed from: package-private */
    public void logGoAway(Direction direction, int lastStreamId, ErrorCode errorCode, ByteString debugData) {
        if (isEnabled()) {
            Logger logger2 = this.logger;
            Level level2 = this.level;
            logger2.log(level2, direction + " GO_AWAY: lastStreamId=" + lastStreamId + " errorCode=" + errorCode + " length=" + debugData.size() + " bytes=" + toString(new Buffer().write(debugData)));
        }
    }

    /* access modifiers changed from: package-private */
    public void logWindowsUpdate(Direction direction, int streamId, long windowSizeIncrement) {
        if (isEnabled()) {
            Logger logger2 = this.logger;
            Level level2 = this.level;
            logger2.log(level2, direction + " WINDOW_UPDATE: streamId=" + streamId + " windowSizeIncrement=" + windowSizeIncrement);
        }
    }

    private enum SettingParams {
        HEADER_TABLE_SIZE(1),
        ENABLE_PUSH(2),
        MAX_CONCURRENT_STREAMS(4),
        MAX_FRAME_SIZE(5),
        MAX_HEADER_LIST_SIZE(6),
        INITIAL_WINDOW_SIZE(7);
        
        private final int bit;

        private SettingParams(int bit2) {
            this.bit = bit2;
        }

        public int getBit() {
            return this.bit;
        }
    }
}
