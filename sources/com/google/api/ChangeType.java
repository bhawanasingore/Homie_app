package com.google.api;

import com.google.protobuf.Internal;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public enum ChangeType implements Internal.EnumLite {
    CHANGE_TYPE_UNSPECIFIED(0),
    ADDED(1),
    REMOVED(2),
    MODIFIED(3),
    UNRECOGNIZED(-1);
    
    public static final int ADDED_VALUE = 1;
    public static final int CHANGE_TYPE_UNSPECIFIED_VALUE = 0;
    public static final int MODIFIED_VALUE = 3;
    public static final int REMOVED_VALUE = 2;
    private static final Internal.EnumLiteMap<ChangeType> internalValueMap = null;
    private final int value;

    static {
        internalValueMap = new Internal.EnumLiteMap<ChangeType>() {
            public ChangeType findValueByNumber(int number) {
                return ChangeType.forNumber(number);
            }
        };
    }

    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static ChangeType valueOf(int value2) {
        return forNumber(value2);
    }

    public static ChangeType forNumber(int value2) {
        if (value2 == 0) {
            return CHANGE_TYPE_UNSPECIFIED;
        }
        if (value2 == 1) {
            return ADDED;
        }
        if (value2 == 2) {
            return REMOVED;
        }
        if (value2 != 3) {
            return null;
        }
        return MODIFIED;
    }

    public static Internal.EnumLiteMap<ChangeType> internalGetValueMap() {
        return internalValueMap;
    }

    private ChangeType(int value2) {
        this.value = value2;
    }
}
