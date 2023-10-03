package com.google.logging.type;

import com.google.protobuf.Internal;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public enum LogSeverity implements Internal.EnumLite {
    DEFAULT(0),
    DEBUG(100),
    INFO(200),
    NOTICE(NOTICE_VALUE),
    WARNING(WARNING_VALUE),
    ERROR(ERROR_VALUE),
    CRITICAL(CRITICAL_VALUE),
    ALERT(ALERT_VALUE),
    EMERGENCY(EMERGENCY_VALUE),
    UNRECOGNIZED(-1);
    
    public static final int ALERT_VALUE = 700;
    public static final int CRITICAL_VALUE = 600;
    public static final int DEBUG_VALUE = 100;
    public static final int DEFAULT_VALUE = 0;
    public static final int EMERGENCY_VALUE = 800;
    public static final int ERROR_VALUE = 500;
    public static final int INFO_VALUE = 200;
    public static final int NOTICE_VALUE = 300;
    public static final int WARNING_VALUE = 400;
    private static final Internal.EnumLiteMap<LogSeverity> internalValueMap = null;
    private final int value;

    static {
        internalValueMap = new Internal.EnumLiteMap<LogSeverity>() {
            public LogSeverity findValueByNumber(int number) {
                return LogSeverity.forNumber(number);
            }
        };
    }

    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static LogSeverity valueOf(int value2) {
        return forNumber(value2);
    }

    public static LogSeverity forNumber(int value2) {
        if (value2 == 0) {
            return DEFAULT;
        }
        if (value2 == 100) {
            return DEBUG;
        }
        if (value2 == 200) {
            return INFO;
        }
        if (value2 == 300) {
            return NOTICE;
        }
        if (value2 == 400) {
            return WARNING;
        }
        if (value2 == 500) {
            return ERROR;
        }
        if (value2 == 600) {
            return CRITICAL;
        }
        if (value2 == 700) {
            return ALERT;
        }
        if (value2 != 800) {
            return null;
        }
        return EMERGENCY;
    }

    public static Internal.EnumLiteMap<LogSeverity> internalGetValueMap() {
        return internalValueMap;
    }

    private LogSeverity(int value2) {
        this.value = value2;
    }
}
