package com.google.protobuf;

import com.google.protobuf.Internal;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public enum NullValue implements Internal.EnumLite {
    NULL_VALUE(0),
    UNRECOGNIZED(-1);
    
    public static final int NULL_VALUE_VALUE = 0;
    private static final Internal.EnumLiteMap<NullValue> internalValueMap = null;
    private final int value;

    static {
        internalValueMap = new Internal.EnumLiteMap<NullValue>() {
            public NullValue findValueByNumber(int number) {
                return NullValue.forNumber(number);
            }
        };
    }

    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static NullValue valueOf(int value2) {
        return forNumber(value2);
    }

    public static NullValue forNumber(int value2) {
        if (value2 != 0) {
            return null;
        }
        return NULL_VALUE;
    }

    public static Internal.EnumLiteMap<NullValue> internalGetValueMap() {
        return internalValueMap;
    }

    private NullValue(int value2) {
        this.value = value2;
    }
}
