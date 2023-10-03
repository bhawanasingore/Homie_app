package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class Struct extends GeneratedMessageLite<Struct, Builder> implements StructOrBuilder {
    /* access modifiers changed from: private */
    public static final Struct DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 1;
    private static volatile Parser<Struct> PARSER;
    private MapFieldLite<String, Value> fields_ = MapFieldLite.emptyMapField();

    private Struct() {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    private static final class FieldsDefaultEntryHolder {
        static final MapEntryLite<String, Value> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Value.getDefaultInstance());

        private FieldsDefaultEntryHolder() {
        }
    }

    private MapFieldLite<String, Value> internalGetFields() {
        return this.fields_;
    }

    private MapFieldLite<String, Value> internalGetMutableFields() {
        if (!this.fields_.isMutable()) {
            this.fields_ = this.fields_.mutableCopy();
        }
        return this.fields_;
    }

    public int getFieldsCount() {
        return internalGetFields().size();
    }

    public boolean containsFields(String key) {
        if (key != null) {
            return internalGetFields().containsKey(key);
        }
        throw null;
    }

    @Deprecated
    public Map<String, Value> getFields() {
        return getFieldsMap();
    }

    public Map<String, Value> getFieldsMap() {
        return Collections.unmodifiableMap(internalGetFields());
    }

    public Value getFieldsOrDefault(String key, Value defaultValue) {
        if (key != null) {
            Map<String, Value> map = internalGetFields();
            return map.containsKey(key) ? map.get(key) : defaultValue;
        }
        throw null;
    }

    public Value getFieldsOrThrow(String key) {
        if (key != null) {
            Map<String, Value> map = internalGetFields();
            if (map.containsKey(key)) {
                return map.get(key);
            }
            throw new IllegalArgumentException();
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public Map<String, Value> getMutableFieldsMap() {
        return internalGetMutableFields();
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        for (Map.Entry<String, Value> entry : internalGetFields().entrySet()) {
            FieldsDefaultEntryHolder.defaultEntry.serializeTo(output, 1, entry.getKey(), entry.getValue());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        for (Map.Entry<String, Value> entry : internalGetFields().entrySet()) {
            size2 += FieldsDefaultEntryHolder.defaultEntry.computeMessageSize(1, entry.getKey(), entry.getValue());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Struct parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Struct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Struct parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Struct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Struct parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Struct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Struct parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Struct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Struct parseFrom(InputStream input) throws IOException {
        return (Struct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Struct parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Struct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Struct parseDelimitedFrom(InputStream input) throws IOException {
        return (Struct) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Struct parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Struct) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Struct parseFrom(CodedInputStream input) throws IOException {
        return (Struct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Struct parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Struct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Struct prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Struct, Builder> implements StructOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Struct.DEFAULT_INSTANCE);
        }

        public int getFieldsCount() {
            return ((Struct) this.instance).getFieldsMap().size();
        }

        public boolean containsFields(String key) {
            if (key != null) {
                return ((Struct) this.instance).getFieldsMap().containsKey(key);
            }
            throw null;
        }

        public Builder clearFields() {
            copyOnWrite();
            ((Struct) this.instance).getMutableFieldsMap().clear();
            return this;
        }

        public Builder removeFields(String key) {
            if (key != null) {
                copyOnWrite();
                ((Struct) this.instance).getMutableFieldsMap().remove(key);
                return this;
            }
            throw null;
        }

        @Deprecated
        public Map<String, Value> getFields() {
            return getFieldsMap();
        }

        public Map<String, Value> getFieldsMap() {
            return Collections.unmodifiableMap(((Struct) this.instance).getFieldsMap());
        }

        public Value getFieldsOrDefault(String key, Value defaultValue) {
            if (key != null) {
                Map<String, Value> map = ((Struct) this.instance).getFieldsMap();
                return map.containsKey(key) ? map.get(key) : defaultValue;
            }
            throw null;
        }

        public Value getFieldsOrThrow(String key) {
            if (key != null) {
                Map<String, Value> map = ((Struct) this.instance).getFieldsMap();
                if (map.containsKey(key)) {
                    return map.get(key);
                }
                throw new IllegalArgumentException();
            }
            throw null;
        }

        public Builder putFields(String key, Value value) {
            if (key == null) {
                throw null;
            } else if (value != null) {
                copyOnWrite();
                ((Struct) this.instance).getMutableFieldsMap().put(key, value);
                return this;
            } else {
                throw null;
            }
        }

        public Builder putAllFields(Map<String, Value> values) {
            copyOnWrite();
            ((Struct) this.instance).getMutableFieldsMap().putAll(values);
            return this;
        }
    }

    /* renamed from: com.google.protobuf.Struct$1  reason: invalid class name */
    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.VISIT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
            case 1:
                return new Struct();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.fields_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                this.fields_ = ((GeneratedMessageLite.Visitor) arg0).visitMap(this.fields_, ((Struct) arg1).internalGetFields());
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case 6:
                CodedInputStream input = (CodedInputStream) arg0;
                ExtensionRegistryLite extensionRegistry = (ExtensionRegistryLite) arg1;
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.readTag();
                        if (tag == 0) {
                            done = true;
                        } else if (tag == 10) {
                            if (!this.fields_.isMutable()) {
                                this.fields_ = this.fields_.mutableCopy();
                            }
                            FieldsDefaultEntryHolder.defaultEntry.parseInto(this.fields_, input, extensionRegistry);
                        } else if (!input.skipField(tag)) {
                            done = true;
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw new RuntimeException(e.setUnfinishedMessage(this));
                    } catch (IOException e2) {
                        throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (PARSER == null) {
                    synchronized (Struct.class) {
                        if (PARSER == null) {
                            PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        }
                    }
                }
                return PARSER;
            default:
                throw new UnsupportedOperationException();
        }
        return DEFAULT_INSTANCE;
    }

    static {
        Struct struct = new Struct();
        DEFAULT_INSTANCE = struct;
        struct.makeImmutable();
    }

    public static Struct getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Struct> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
