package io.opencensus.trace;

import io.opencensus.common.Function;
import io.opencensus.internal.Utils;

public abstract class AttributeValue {
    @Deprecated
    public abstract <T> T match(Function<? super String, T> function, Function<? super Boolean, T> function2, Function<? super Long, T> function3, Function<Object, T> function4);

    public abstract <T> T match(Function<? super String, T> function, Function<? super Boolean, T> function2, Function<? super Long, T> function3, Function<? super Double, T> function4, Function<Object, T> function5);

    public static AttributeValue stringAttributeValue(String stringValue) {
        return AttributeValueString.create(stringValue);
    }

    public static AttributeValue booleanAttributeValue(boolean booleanValue) {
        return AttributeValueBoolean.create(Boolean.valueOf(booleanValue));
    }

    public static AttributeValue longAttributeValue(long longValue) {
        return AttributeValueLong.create(Long.valueOf(longValue));
    }

    public static AttributeValue doubleAttributeValue(double doubleValue) {
        return AttributeValueDouble.create(Double.valueOf(doubleValue));
    }

    AttributeValue() {
    }

    static abstract class AttributeValueString extends AttributeValue {
        /* access modifiers changed from: package-private */
        public abstract String getStringValue();

        AttributeValueString() {
        }

        static AttributeValue create(String stringValue) {
            return new AutoValue_AttributeValue_AttributeValueString((String) Utils.checkNotNull(stringValue, "stringValue"));
        }

        public final <T> T match(Function<? super String, T> stringFunction, Function<? super Boolean, T> function, Function<? super Long, T> function2, Function<Object, T> function3) {
            return stringFunction.apply(getStringValue());
        }

        public final <T> T match(Function<? super String, T> stringFunction, Function<? super Boolean, T> function, Function<? super Long, T> function2, Function<? super Double, T> function3, Function<Object, T> function4) {
            return stringFunction.apply(getStringValue());
        }
    }

    static abstract class AttributeValueBoolean extends AttributeValue {
        /* access modifiers changed from: package-private */
        public abstract Boolean getBooleanValue();

        AttributeValueBoolean() {
        }

        static AttributeValue create(Boolean booleanValue) {
            return new AutoValue_AttributeValue_AttributeValueBoolean((Boolean) Utils.checkNotNull(booleanValue, "booleanValue"));
        }

        public final <T> T match(Function<? super String, T> function, Function<? super Boolean, T> booleanFunction, Function<? super Long, T> function2, Function<Object, T> function3) {
            return booleanFunction.apply(getBooleanValue());
        }

        public final <T> T match(Function<? super String, T> function, Function<? super Boolean, T> booleanFunction, Function<? super Long, T> function2, Function<? super Double, T> function3, Function<Object, T> function4) {
            return booleanFunction.apply(getBooleanValue());
        }
    }

    static abstract class AttributeValueLong extends AttributeValue {
        /* access modifiers changed from: package-private */
        public abstract Long getLongValue();

        AttributeValueLong() {
        }

        static AttributeValue create(Long longValue) {
            return new AutoValue_AttributeValue_AttributeValueLong((Long) Utils.checkNotNull(longValue, "longValue"));
        }

        public final <T> T match(Function<? super String, T> function, Function<? super Boolean, T> function2, Function<? super Long, T> longFunction, Function<Object, T> function3) {
            return longFunction.apply(getLongValue());
        }

        public final <T> T match(Function<? super String, T> function, Function<? super Boolean, T> function2, Function<? super Long, T> longFunction, Function<? super Double, T> function3, Function<Object, T> function4) {
            return longFunction.apply(getLongValue());
        }
    }

    static abstract class AttributeValueDouble extends AttributeValue {
        /* access modifiers changed from: package-private */
        public abstract Double getDoubleValue();

        AttributeValueDouble() {
        }

        static AttributeValue create(Double doubleValue) {
            return new AutoValue_AttributeValue_AttributeValueDouble((Double) Utils.checkNotNull(doubleValue, "doubleValue"));
        }

        public final <T> T match(Function<? super String, T> function, Function<? super Boolean, T> function2, Function<? super Long, T> function3, Function<Object, T> defaultFunction) {
            return defaultFunction.apply(getDoubleValue());
        }

        public final <T> T match(Function<? super String, T> function, Function<? super Boolean, T> function2, Function<? super Long, T> function3, Function<? super Double, T> doubleFunction, Function<Object, T> function4) {
            return doubleFunction.apply(getDoubleValue());
        }
    }
}
