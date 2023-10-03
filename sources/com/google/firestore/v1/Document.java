package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public final class Document extends GeneratedMessageLite<Document, Builder> implements DocumentOrBuilder {
    public static final int CREATE_TIME_FIELD_NUMBER = 3;
    /* access modifiers changed from: private */
    public static final Document DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Document> PARSER = null;
    public static final int UPDATE_TIME_FIELD_NUMBER = 4;
    private int bitField0_;
    private Timestamp createTime_;
    private MapFieldLite<String, Value> fields_ = MapFieldLite.emptyMapField();
    private String name_ = "";
    private Timestamp updateTime_;

    private Document() {
    }

    public String getName() {
        return this.name_;
    }

    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    /* access modifiers changed from: private */
    public void setName(String value) {
        if (value != null) {
            this.name_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* access modifiers changed from: private */
    public void setNameBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.name_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
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

    public boolean hasCreateTime() {
        return this.createTime_ != null;
    }

    public Timestamp getCreateTime() {
        Timestamp timestamp = this.createTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    /* access modifiers changed from: private */
    public void setCreateTime(Timestamp value) {
        if (value != null) {
            this.createTime_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setCreateTime(Timestamp.Builder builderForValue) {
        this.createTime_ = (Timestamp) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeCreateTime(Timestamp value) {
        Timestamp timestamp = this.createTime_;
        if (timestamp == null || timestamp == Timestamp.getDefaultInstance()) {
            this.createTime_ = value;
        } else {
            this.createTime_ = (Timestamp) ((Timestamp.Builder) Timestamp.newBuilder(this.createTime_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearCreateTime() {
        this.createTime_ = null;
    }

    public boolean hasUpdateTime() {
        return this.updateTime_ != null;
    }

    public Timestamp getUpdateTime() {
        Timestamp timestamp = this.updateTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    /* access modifiers changed from: private */
    public void setUpdateTime(Timestamp value) {
        if (value != null) {
            this.updateTime_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setUpdateTime(Timestamp.Builder builderForValue) {
        this.updateTime_ = (Timestamp) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeUpdateTime(Timestamp value) {
        Timestamp timestamp = this.updateTime_;
        if (timestamp == null || timestamp == Timestamp.getDefaultInstance()) {
            this.updateTime_ = value;
        } else {
            this.updateTime_ = (Timestamp) ((Timestamp.Builder) Timestamp.newBuilder(this.updateTime_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearUpdateTime() {
        this.updateTime_ = null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.name_.isEmpty()) {
            output.writeString(1, getName());
        }
        for (Map.Entry<String, Value> entry : internalGetFields().entrySet()) {
            FieldsDefaultEntryHolder.defaultEntry.serializeTo(output, 2, entry.getKey(), entry.getValue());
        }
        if (this.createTime_ != null) {
            output.writeMessage(3, getCreateTime());
        }
        if (this.updateTime_ != null) {
            output.writeMessage(4, getUpdateTime());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.name_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getName());
        }
        for (Map.Entry<String, Value> entry : internalGetFields().entrySet()) {
            size2 += FieldsDefaultEntryHolder.defaultEntry.computeMessageSize(2, entry.getKey(), entry.getValue());
        }
        if (this.createTime_ != null) {
            size2 += CodedOutputStream.computeMessageSize(3, getCreateTime());
        }
        if (this.updateTime_ != null) {
            size2 += CodedOutputStream.computeMessageSize(4, getUpdateTime());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Document parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Document) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Document parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Document) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Document parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Document) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Document parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Document) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Document parseFrom(InputStream input) throws IOException {
        return (Document) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Document parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Document) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Document parseDelimitedFrom(InputStream input) throws IOException {
        return (Document) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Document parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Document) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Document parseFrom(CodedInputStream input) throws IOException {
        return (Document) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Document parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Document) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Document prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<Document, Builder> implements DocumentOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Document.DEFAULT_INSTANCE);
        }

        public String getName() {
            return ((Document) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((Document) this.instance).getNameBytes();
        }

        public Builder setName(String value) {
            copyOnWrite();
            ((Document) this.instance).setName(value);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((Document) this.instance).clearName();
            return this;
        }

        public Builder setNameBytes(ByteString value) {
            copyOnWrite();
            ((Document) this.instance).setNameBytes(value);
            return this;
        }

        public int getFieldsCount() {
            return ((Document) this.instance).getFieldsMap().size();
        }

        public boolean containsFields(String key) {
            if (key != null) {
                return ((Document) this.instance).getFieldsMap().containsKey(key);
            }
            throw null;
        }

        public Builder clearFields() {
            copyOnWrite();
            ((Document) this.instance).getMutableFieldsMap().clear();
            return this;
        }

        public Builder removeFields(String key) {
            if (key != null) {
                copyOnWrite();
                ((Document) this.instance).getMutableFieldsMap().remove(key);
                return this;
            }
            throw null;
        }

        @Deprecated
        public Map<String, Value> getFields() {
            return getFieldsMap();
        }

        public Map<String, Value> getFieldsMap() {
            return Collections.unmodifiableMap(((Document) this.instance).getFieldsMap());
        }

        public Value getFieldsOrDefault(String key, Value defaultValue) {
            if (key != null) {
                Map<String, Value> map = ((Document) this.instance).getFieldsMap();
                return map.containsKey(key) ? map.get(key) : defaultValue;
            }
            throw null;
        }

        public Value getFieldsOrThrow(String key) {
            if (key != null) {
                Map<String, Value> map = ((Document) this.instance).getFieldsMap();
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
                ((Document) this.instance).getMutableFieldsMap().put(key, value);
                return this;
            } else {
                throw null;
            }
        }

        public Builder putAllFields(Map<String, Value> values) {
            copyOnWrite();
            ((Document) this.instance).getMutableFieldsMap().putAll(values);
            return this;
        }

        public boolean hasCreateTime() {
            return ((Document) this.instance).hasCreateTime();
        }

        public Timestamp getCreateTime() {
            return ((Document) this.instance).getCreateTime();
        }

        public Builder setCreateTime(Timestamp value) {
            copyOnWrite();
            ((Document) this.instance).setCreateTime(value);
            return this;
        }

        public Builder setCreateTime(Timestamp.Builder builderForValue) {
            copyOnWrite();
            ((Document) this.instance).setCreateTime(builderForValue);
            return this;
        }

        public Builder mergeCreateTime(Timestamp value) {
            copyOnWrite();
            ((Document) this.instance).mergeCreateTime(value);
            return this;
        }

        public Builder clearCreateTime() {
            copyOnWrite();
            ((Document) this.instance).clearCreateTime();
            return this;
        }

        public boolean hasUpdateTime() {
            return ((Document) this.instance).hasUpdateTime();
        }

        public Timestamp getUpdateTime() {
            return ((Document) this.instance).getUpdateTime();
        }

        public Builder setUpdateTime(Timestamp value) {
            copyOnWrite();
            ((Document) this.instance).setUpdateTime(value);
            return this;
        }

        public Builder setUpdateTime(Timestamp.Builder builderForValue) {
            copyOnWrite();
            ((Document) this.instance).setUpdateTime(builderForValue);
            return this;
        }

        public Builder mergeUpdateTime(Timestamp value) {
            copyOnWrite();
            ((Document) this.instance).mergeUpdateTime(value);
            return this;
        }

        public Builder clearUpdateTime() {
            copyOnWrite();
            ((Document) this.instance).clearUpdateTime();
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.Document$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
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
                return new Document();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.fields_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                Document other = (Document) arg1;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !other.name_.isEmpty(), other.name_);
                this.fields_ = visitor.visitMap(this.fields_, other.internalGetFields());
                this.createTime_ = (Timestamp) visitor.visitMessage(this.createTime_, other.createTime_);
                this.updateTime_ = (Timestamp) visitor.visitMessage(this.updateTime_, other.updateTime_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= other.bitField0_;
                }
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
                            this.name_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            if (!this.fields_.isMutable()) {
                                this.fields_ = this.fields_.mutableCopy();
                            }
                            FieldsDefaultEntryHolder.defaultEntry.parseInto(this.fields_, input, extensionRegistry);
                        } else if (tag == 26) {
                            Timestamp.Builder subBuilder = null;
                            if (this.createTime_ != null) {
                                subBuilder = (Timestamp.Builder) this.createTime_.toBuilder();
                            }
                            Timestamp timestamp = (Timestamp) input.readMessage(Timestamp.parser(), extensionRegistry);
                            this.createTime_ = timestamp;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(timestamp);
                                this.createTime_ = (Timestamp) subBuilder.buildPartial();
                            }
                        } else if (tag == 34) {
                            Timestamp.Builder subBuilder2 = null;
                            if (this.updateTime_ != null) {
                                subBuilder2 = (Timestamp.Builder) this.updateTime_.toBuilder();
                            }
                            Timestamp timestamp2 = (Timestamp) input.readMessage(Timestamp.parser(), extensionRegistry);
                            this.updateTime_ = timestamp2;
                            if (subBuilder2 != null) {
                                subBuilder2.mergeFrom(timestamp2);
                                this.updateTime_ = (Timestamp) subBuilder2.buildPartial();
                            }
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
                    synchronized (Document.class) {
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
        Document document = new Document();
        DEFAULT_INSTANCE = document;
        document.makeImmutable();
    }

    public static Document getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Document> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
