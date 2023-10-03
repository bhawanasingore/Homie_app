package com.google.protobuf;

import com.google.protobuf.Internal;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public enum Syntax implements Internal.EnumLite {
    SYNTAX_PROTO2(0),
    SYNTAX_PROTO3(1),
    UNRECOGNIZED(-1);
    
    public static final int SYNTAX_PROTO2_VALUE = 0;
    public static final int SYNTAX_PROTO3_VALUE = 1;
    private static final Internal.EnumLiteMap<Syntax> internalValueMap = null;
    private final int value;

    static {
        internalValueMap = new Internal.EnumLiteMap<Syntax>() {
            public Syntax findValueByNumber(int number) {
                return Syntax.forNumber(number);
            }
        };
    }

    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static Syntax valueOf(int value2) {
        return forNumber(value2);
    }

    public static Syntax forNumber(int value2) {
        if (value2 == 0) {
            return SYNTAX_PROTO2;
        }
        if (value2 != 1) {
            return null;
        }
        return SYNTAX_PROTO3;
    }

    public static Internal.EnumLiteMap<Syntax> internalGetValueMap() {
        return internalValueMap;
    }

    private Syntax(int value2) {
        this.value = value2;
    }
}
