package io.opencensus.common;

import io.opencensus.common.ServerStatsFieldEnums;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class ServerStatsEncoding {
    public static final byte CURRENT_VERSION = 0;

    private ServerStatsEncoding() {
    }

    public static byte[] toBytes(ServerStats stats) {
        ByteBuffer bb = ByteBuffer.allocate(ServerStatsFieldEnums.getTotalSize() + 1);
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.put((byte) 0);
        bb.put((byte) ServerStatsFieldEnums.Id.SERVER_STATS_LB_LATENCY_ID.value());
        bb.putLong(stats.getLbLatencyNs());
        bb.put((byte) ServerStatsFieldEnums.Id.SERVER_STATS_SERVICE_LATENCY_ID.value());
        bb.putLong(stats.getServiceLatencyNs());
        bb.put((byte) ServerStatsFieldEnums.Id.SERVER_STATS_TRACE_OPTION_ID.value());
        bb.put(stats.getTraceOption());
        return bb.array();
    }

    public static ServerStats parseBytes(byte[] serialized) throws ServerStatsDeserializationException {
        ByteBuffer bb = ByteBuffer.wrap(serialized);
        bb.order(ByteOrder.LITTLE_ENDIAN);
        long serviceLatencyNs = 0;
        long lbLatencyNs = 0;
        byte traceOption = 0;
        if (bb.hasRemaining()) {
            byte version = bb.get();
            if (version > 0 || version < 0) {
                throw new ServerStatsDeserializationException("Invalid ServerStats version: " + version);
            }
            while (bb.hasRemaining()) {
                ServerStatsFieldEnums.Id id = ServerStatsFieldEnums.Id.valueOf((int) bb.get() & 255);
                if (id == null) {
                    bb.position(bb.limit());
                } else {
                    int i = AnonymousClass1.$SwitchMap$io$opencensus$common$ServerStatsFieldEnums$Id[id.ordinal()];
                    if (i == 1) {
                        lbLatencyNs = bb.getLong();
                    } else if (i == 2) {
                        serviceLatencyNs = bb.getLong();
                    } else if (i == 3) {
                        traceOption = bb.get();
                    }
                }
            }
            try {
                return ServerStats.create(lbLatencyNs, serviceLatencyNs, traceOption);
            } catch (IllegalArgumentException e) {
                throw new ServerStatsDeserializationException("Serialized ServiceStats contains invalid values: " + e.getMessage());
            }
        } else {
            throw new ServerStatsDeserializationException("Serialized ServerStats buffer is empty");
        }
    }

    /* renamed from: io.opencensus.common.ServerStatsEncoding$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$opencensus$common$ServerStatsFieldEnums$Id;

        static {
            int[] iArr = new int[ServerStatsFieldEnums.Id.values().length];
            $SwitchMap$io$opencensus$common$ServerStatsFieldEnums$Id = iArr;
            try {
                iArr[ServerStatsFieldEnums.Id.SERVER_STATS_LB_LATENCY_ID.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$io$opencensus$common$ServerStatsFieldEnums$Id[ServerStatsFieldEnums.Id.SERVER_STATS_SERVICE_LATENCY_ID.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$io$opencensus$common$ServerStatsFieldEnums$Id[ServerStatsFieldEnums.Id.SERVER_STATS_TRACE_OPTION_ID.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }
}
