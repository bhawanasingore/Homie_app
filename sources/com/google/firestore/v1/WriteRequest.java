package com.google.firestore.v1;

import com.google.firestore.v1.Write;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public final class WriteRequest extends GeneratedMessageLite<WriteRequest, Builder> implements WriteRequestOrBuilder {
    public static final int DATABASE_FIELD_NUMBER = 1;
    /* access modifiers changed from: private */
    public static final WriteRequest DEFAULT_INSTANCE;
    public static final int LABELS_FIELD_NUMBER = 5;
    private static volatile Parser<WriteRequest> PARSER = null;
    public static final int STREAM_ID_FIELD_NUMBER = 2;
    public static final int STREAM_TOKEN_FIELD_NUMBER = 4;
    public static final int WRITES_FIELD_NUMBER = 3;
    private int bitField0_;
    private String database_ = "";
    private MapFieldLite<String, String> labels_ = MapFieldLite.emptyMapField();
    private String streamId_ = "";
    private ByteString streamToken_ = ByteString.EMPTY;
    private Internal.ProtobufList<Write> writes_ = emptyProtobufList();

    private WriteRequest() {
    }

    public String getDatabase() {
        return this.database_;
    }

    public ByteString getDatabaseBytes() {
        return ByteString.copyFromUtf8(this.database_);
    }

    /* access modifiers changed from: private */
    public void setDatabase(String value) {
        if (value != null) {
            this.database_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearDatabase() {
        this.database_ = getDefaultInstance().getDatabase();
    }

    /* access modifiers changed from: private */
    public void setDatabaseBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.database_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getStreamId() {
        return this.streamId_;
    }

    public ByteString getStreamIdBytes() {
        return ByteString.copyFromUtf8(this.streamId_);
    }

    /* access modifiers changed from: private */
    public void setStreamId(String value) {
        if (value != null) {
            this.streamId_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearStreamId() {
        this.streamId_ = getDefaultInstance().getStreamId();
    }

    /* access modifiers changed from: private */
    public void setStreamIdBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.streamId_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public List<Write> getWritesList() {
        return this.writes_;
    }

    public List<? extends WriteOrBuilder> getWritesOrBuilderList() {
        return this.writes_;
    }

    public int getWritesCount() {
        return this.writes_.size();
    }

    public Write getWrites(int index) {
        return (Write) this.writes_.get(index);
    }

    public WriteOrBuilder getWritesOrBuilder(int index) {
        return (WriteOrBuilder) this.writes_.get(index);
    }

    private void ensureWritesIsMutable() {
        if (!this.writes_.isModifiable()) {
            this.writes_ = GeneratedMessageLite.mutableCopy(this.writes_);
        }
    }

    /* access modifiers changed from: private */
    public void setWrites(int index, Write value) {
        if (value != null) {
            ensureWritesIsMutable();
            this.writes_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setWrites(int index, Write.Builder builderForValue) {
        ensureWritesIsMutable();
        this.writes_.set(index, (Write) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addWrites(Write value) {
        if (value != null) {
            ensureWritesIsMutable();
            this.writes_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addWrites(int index, Write value) {
        if (value != null) {
            ensureWritesIsMutable();
            this.writes_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addWrites(Write.Builder builderForValue) {
        ensureWritesIsMutable();
        this.writes_.add((Write) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addWrites(int index, Write.Builder builderForValue) {
        ensureWritesIsMutable();
        this.writes_.add(index, (Write) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllWrites(Iterable<? extends Write> values) {
        ensureWritesIsMutable();
        AbstractMessageLite.addAll(values, this.writes_);
    }

    /* access modifiers changed from: private */
    public void clearWrites() {
        this.writes_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeWrites(int index) {
        ensureWritesIsMutable();
        this.writes_.remove(index);
    }

    public ByteString getStreamToken() {
        return this.streamToken_;
    }

    /* access modifiers changed from: private */
    public void setStreamToken(ByteString value) {
        if (value != null) {
            this.streamToken_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearStreamToken() {
        this.streamToken_ = getDefaultInstance().getStreamToken();
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    private static final class LabelsDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.STRING, "");

        private LabelsDefaultEntryHolder() {
        }
    }

    private MapFieldLite<String, String> internalGetLabels() {
        return this.labels_;
    }

    private MapFieldLite<String, String> internalGetMutableLabels() {
        if (!this.labels_.isMutable()) {
            this.labels_ = this.labels_.mutableCopy();
        }
        return this.labels_;
    }

    public int getLabelsCount() {
        return internalGetLabels().size();
    }

    public boolean containsLabels(String key) {
        if (key != null) {
            return internalGetLabels().containsKey(key);
        }
        throw null;
    }

    @Deprecated
    public Map<String, String> getLabels() {
        return getLabelsMap();
    }

    public Map<String, String> getLabelsMap() {
        return Collections.unmodifiableMap(internalGetLabels());
    }

    public String getLabelsOrDefault(String key, String defaultValue) {
        if (key != null) {
            Map<String, String> map = internalGetLabels();
            return map.containsKey(key) ? map.get(key) : defaultValue;
        }
        throw null;
    }

    public String getLabelsOrThrow(String key) {
        if (key != null) {
            Map<String, String> map = internalGetLabels();
            if (map.containsKey(key)) {
                return map.get(key);
            }
            throw new IllegalArgumentException();
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public Map<String, String> getMutableLabelsMap() {
        return internalGetMutableLabels();
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.database_.isEmpty()) {
            output.writeString(1, getDatabase());
        }
        if (!this.streamId_.isEmpty()) {
            output.writeString(2, getStreamId());
        }
        for (int i = 0; i < this.writes_.size(); i++) {
            output.writeMessage(3, (MessageLite) this.writes_.get(i));
        }
        if (!this.streamToken_.isEmpty()) {
            output.writeBytes(4, this.streamToken_);
        }
        for (Map.Entry<String, String> entry : internalGetLabels().entrySet()) {
            LabelsDefaultEntryHolder.defaultEntry.serializeTo(output, 5, entry.getKey(), entry.getValue());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.database_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getDatabase());
        }
        if (!this.streamId_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(2, getStreamId());
        }
        for (int i = 0; i < this.writes_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(3, (MessageLite) this.writes_.get(i));
        }
        if (!this.streamToken_.isEmpty()) {
            size2 += CodedOutputStream.computeBytesSize(4, this.streamToken_);
        }
        for (Map.Entry<String, String> entry : internalGetLabels().entrySet()) {
            size2 += LabelsDefaultEntryHolder.defaultEntry.computeMessageSize(5, entry.getKey(), entry.getValue());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static WriteRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (WriteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static WriteRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (WriteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static WriteRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (WriteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static WriteRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (WriteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static WriteRequest parseFrom(InputStream input) throws IOException {
        return (WriteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static WriteRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (WriteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static WriteRequest parseDelimitedFrom(InputStream input) throws IOException {
        return (WriteRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static WriteRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (WriteRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static WriteRequest parseFrom(CodedInputStream input) throws IOException {
        return (WriteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static WriteRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (WriteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(WriteRequest prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<WriteRequest, Builder> implements WriteRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(WriteRequest.DEFAULT_INSTANCE);
        }

        public String getDatabase() {
            return ((WriteRequest) this.instance).getDatabase();
        }

        public ByteString getDatabaseBytes() {
            return ((WriteRequest) this.instance).getDatabaseBytes();
        }

        public Builder setDatabase(String value) {
            copyOnWrite();
            ((WriteRequest) this.instance).setDatabase(value);
            return this;
        }

        public Builder clearDatabase() {
            copyOnWrite();
            ((WriteRequest) this.instance).clearDatabase();
            return this;
        }

        public Builder setDatabaseBytes(ByteString value) {
            copyOnWrite();
            ((WriteRequest) this.instance).setDatabaseBytes(value);
            return this;
        }

        public String getStreamId() {
            return ((WriteRequest) this.instance).getStreamId();
        }

        public ByteString getStreamIdBytes() {
            return ((WriteRequest) this.instance).getStreamIdBytes();
        }

        public Builder setStreamId(String value) {
            copyOnWrite();
            ((WriteRequest) this.instance).setStreamId(value);
            return this;
        }

        public Builder clearStreamId() {
            copyOnWrite();
            ((WriteRequest) this.instance).clearStreamId();
            return this;
        }

        public Builder setStreamIdBytes(ByteString value) {
            copyOnWrite();
            ((WriteRequest) this.instance).setStreamIdBytes(value);
            return this;
        }

        public List<Write> getWritesList() {
            return Collections.unmodifiableList(((WriteRequest) this.instance).getWritesList());
        }

        public int getWritesCount() {
            return ((WriteRequest) this.instance).getWritesCount();
        }

        public Write getWrites(int index) {
            return ((WriteRequest) this.instance).getWrites(index);
        }

        public Builder setWrites(int index, Write value) {
            copyOnWrite();
            ((WriteRequest) this.instance).setWrites(index, value);
            return this;
        }

        public Builder setWrites(int index, Write.Builder builderForValue) {
            copyOnWrite();
            ((WriteRequest) this.instance).setWrites(index, builderForValue);
            return this;
        }

        public Builder addWrites(Write value) {
            copyOnWrite();
            ((WriteRequest) this.instance).addWrites(value);
            return this;
        }

        public Builder addWrites(int index, Write value) {
            copyOnWrite();
            ((WriteRequest) this.instance).addWrites(index, value);
            return this;
        }

        public Builder addWrites(Write.Builder builderForValue) {
            copyOnWrite();
            ((WriteRequest) this.instance).addWrites(builderForValue);
            return this;
        }

        public Builder addWrites(int index, Write.Builder builderForValue) {
            copyOnWrite();
            ((WriteRequest) this.instance).addWrites(index, builderForValue);
            return this;
        }

        public Builder addAllWrites(Iterable<? extends Write> values) {
            copyOnWrite();
            ((WriteRequest) this.instance).addAllWrites(values);
            return this;
        }

        public Builder clearWrites() {
            copyOnWrite();
            ((WriteRequest) this.instance).clearWrites();
            return this;
        }

        public Builder removeWrites(int index) {
            copyOnWrite();
            ((WriteRequest) this.instance).removeWrites(index);
            return this;
        }

        public ByteString getStreamToken() {
            return ((WriteRequest) this.instance).getStreamToken();
        }

        public Builder setStreamToken(ByteString value) {
            copyOnWrite();
            ((WriteRequest) this.instance).setStreamToken(value);
            return this;
        }

        public Builder clearStreamToken() {
            copyOnWrite();
            ((WriteRequest) this.instance).clearStreamToken();
            return this;
        }

        public int getLabelsCount() {
            return ((WriteRequest) this.instance).getLabelsMap().size();
        }

        public boolean containsLabels(String key) {
            if (key != null) {
                return ((WriteRequest) this.instance).getLabelsMap().containsKey(key);
            }
            throw null;
        }

        public Builder clearLabels() {
            copyOnWrite();
            ((WriteRequest) this.instance).getMutableLabelsMap().clear();
            return this;
        }

        public Builder removeLabels(String key) {
            if (key != null) {
                copyOnWrite();
                ((WriteRequest) this.instance).getMutableLabelsMap().remove(key);
                return this;
            }
            throw null;
        }

        @Deprecated
        public Map<String, String> getLabels() {
            return getLabelsMap();
        }

        public Map<String, String> getLabelsMap() {
            return Collections.unmodifiableMap(((WriteRequest) this.instance).getLabelsMap());
        }

        public String getLabelsOrDefault(String key, String defaultValue) {
            if (key != null) {
                Map<String, String> map = ((WriteRequest) this.instance).getLabelsMap();
                return map.containsKey(key) ? map.get(key) : defaultValue;
            }
            throw null;
        }

        public String getLabelsOrThrow(String key) {
            if (key != null) {
                Map<String, String> map = ((WriteRequest) this.instance).getLabelsMap();
                if (map.containsKey(key)) {
                    return map.get(key);
                }
                throw new IllegalArgumentException();
            }
            throw null;
        }

        public Builder putLabels(String key, String value) {
            if (key == null) {
                throw null;
            } else if (value != null) {
                copyOnWrite();
                ((WriteRequest) this.instance).getMutableLabelsMap().put(key, value);
                return this;
            } else {
                throw null;
            }
        }

        public Builder putAllLabels(Map<String, String> values) {
            copyOnWrite();
            ((WriteRequest) this.instance).getMutableLabelsMap().putAll(values);
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.WriteRequest$1  reason: invalid class name */
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
                return new WriteRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.writes_.makeImmutable();
                this.labels_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                WriteRequest other = (WriteRequest) arg1;
                boolean z = true;
                this.database_ = visitor.visitString(!this.database_.isEmpty(), this.database_, !other.database_.isEmpty(), other.database_);
                this.streamId_ = visitor.visitString(!this.streamId_.isEmpty(), this.streamId_, !other.streamId_.isEmpty(), other.streamId_);
                this.writes_ = visitor.visitList(this.writes_, other.writes_);
                boolean z2 = this.streamToken_ != ByteString.EMPTY;
                ByteString byteString = this.streamToken_;
                if (other.streamToken_ == ByteString.EMPTY) {
                    z = false;
                }
                this.streamToken_ = visitor.visitByteString(z2, byteString, z, other.streamToken_);
                this.labels_ = visitor.visitMap(this.labels_, other.internalGetLabels());
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
                            this.database_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            this.streamId_ = input.readStringRequireUtf8();
                        } else if (tag == 26) {
                            if (!this.writes_.isModifiable()) {
                                this.writes_ = GeneratedMessageLite.mutableCopy(this.writes_);
                            }
                            this.writes_.add((Write) input.readMessage(Write.parser(), extensionRegistry));
                        } else if (tag == 34) {
                            this.streamToken_ = input.readBytes();
                        } else if (tag == 42) {
                            if (!this.labels_.isMutable()) {
                                this.labels_ = this.labels_.mutableCopy();
                            }
                            LabelsDefaultEntryHolder.defaultEntry.parseInto(this.labels_, input, extensionRegistry);
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
                    synchronized (WriteRequest.class) {
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
        WriteRequest writeRequest = new WriteRequest();
        DEFAULT_INSTANCE = writeRequest;
        writeRequest.makeImmutable();
    }

    public static WriteRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<WriteRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
