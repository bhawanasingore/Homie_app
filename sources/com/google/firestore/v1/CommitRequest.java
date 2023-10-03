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
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public final class CommitRequest extends GeneratedMessageLite<CommitRequest, Builder> implements CommitRequestOrBuilder {
    public static final int DATABASE_FIELD_NUMBER = 1;
    /* access modifiers changed from: private */
    public static final CommitRequest DEFAULT_INSTANCE;
    private static volatile Parser<CommitRequest> PARSER = null;
    public static final int TRANSACTION_FIELD_NUMBER = 3;
    public static final int WRITES_FIELD_NUMBER = 2;
    private int bitField0_;
    private String database_ = "";
    private ByteString transaction_ = ByteString.EMPTY;
    private Internal.ProtobufList<Write> writes_ = emptyProtobufList();

    private CommitRequest() {
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

    public ByteString getTransaction() {
        return this.transaction_;
    }

    /* access modifiers changed from: private */
    public void setTransaction(ByteString value) {
        if (value != null) {
            this.transaction_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearTransaction() {
        this.transaction_ = getDefaultInstance().getTransaction();
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.database_.isEmpty()) {
            output.writeString(1, getDatabase());
        }
        for (int i = 0; i < this.writes_.size(); i++) {
            output.writeMessage(2, (MessageLite) this.writes_.get(i));
        }
        if (!this.transaction_.isEmpty()) {
            output.writeBytes(3, this.transaction_);
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
        for (int i = 0; i < this.writes_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(2, (MessageLite) this.writes_.get(i));
        }
        if (!this.transaction_.isEmpty()) {
            size2 += CodedOutputStream.computeBytesSize(3, this.transaction_);
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static CommitRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (CommitRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static CommitRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (CommitRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static CommitRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (CommitRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static CommitRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (CommitRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static CommitRequest parseFrom(InputStream input) throws IOException {
        return (CommitRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static CommitRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (CommitRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static CommitRequest parseDelimitedFrom(InputStream input) throws IOException {
        return (CommitRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static CommitRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (CommitRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static CommitRequest parseFrom(CodedInputStream input) throws IOException {
        return (CommitRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static CommitRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (CommitRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(CommitRequest prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<CommitRequest, Builder> implements CommitRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(CommitRequest.DEFAULT_INSTANCE);
        }

        public String getDatabase() {
            return ((CommitRequest) this.instance).getDatabase();
        }

        public ByteString getDatabaseBytes() {
            return ((CommitRequest) this.instance).getDatabaseBytes();
        }

        public Builder setDatabase(String value) {
            copyOnWrite();
            ((CommitRequest) this.instance).setDatabase(value);
            return this;
        }

        public Builder clearDatabase() {
            copyOnWrite();
            ((CommitRequest) this.instance).clearDatabase();
            return this;
        }

        public Builder setDatabaseBytes(ByteString value) {
            copyOnWrite();
            ((CommitRequest) this.instance).setDatabaseBytes(value);
            return this;
        }

        public List<Write> getWritesList() {
            return Collections.unmodifiableList(((CommitRequest) this.instance).getWritesList());
        }

        public int getWritesCount() {
            return ((CommitRequest) this.instance).getWritesCount();
        }

        public Write getWrites(int index) {
            return ((CommitRequest) this.instance).getWrites(index);
        }

        public Builder setWrites(int index, Write value) {
            copyOnWrite();
            ((CommitRequest) this.instance).setWrites(index, value);
            return this;
        }

        public Builder setWrites(int index, Write.Builder builderForValue) {
            copyOnWrite();
            ((CommitRequest) this.instance).setWrites(index, builderForValue);
            return this;
        }

        public Builder addWrites(Write value) {
            copyOnWrite();
            ((CommitRequest) this.instance).addWrites(value);
            return this;
        }

        public Builder addWrites(int index, Write value) {
            copyOnWrite();
            ((CommitRequest) this.instance).addWrites(index, value);
            return this;
        }

        public Builder addWrites(Write.Builder builderForValue) {
            copyOnWrite();
            ((CommitRequest) this.instance).addWrites(builderForValue);
            return this;
        }

        public Builder addWrites(int index, Write.Builder builderForValue) {
            copyOnWrite();
            ((CommitRequest) this.instance).addWrites(index, builderForValue);
            return this;
        }

        public Builder addAllWrites(Iterable<? extends Write> values) {
            copyOnWrite();
            ((CommitRequest) this.instance).addAllWrites(values);
            return this;
        }

        public Builder clearWrites() {
            copyOnWrite();
            ((CommitRequest) this.instance).clearWrites();
            return this;
        }

        public Builder removeWrites(int index) {
            copyOnWrite();
            ((CommitRequest) this.instance).removeWrites(index);
            return this;
        }

        public ByteString getTransaction() {
            return ((CommitRequest) this.instance).getTransaction();
        }

        public Builder setTransaction(ByteString value) {
            copyOnWrite();
            ((CommitRequest) this.instance).setTransaction(value);
            return this;
        }

        public Builder clearTransaction() {
            copyOnWrite();
            ((CommitRequest) this.instance).clearTransaction();
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.CommitRequest$1  reason: invalid class name */
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
                return new CommitRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.writes_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                CommitRequest other = (CommitRequest) arg1;
                boolean z = true;
                this.database_ = visitor.visitString(!this.database_.isEmpty(), this.database_, !other.database_.isEmpty(), other.database_);
                this.writes_ = visitor.visitList(this.writes_, other.writes_);
                boolean z2 = this.transaction_ != ByteString.EMPTY;
                ByteString byteString = this.transaction_;
                if (other.transaction_ == ByteString.EMPTY) {
                    z = false;
                }
                this.transaction_ = visitor.visitByteString(z2, byteString, z, other.transaction_);
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
                            if (!this.writes_.isModifiable()) {
                                this.writes_ = GeneratedMessageLite.mutableCopy(this.writes_);
                            }
                            this.writes_.add((Write) input.readMessage(Write.parser(), extensionRegistry));
                        } else if (tag == 26) {
                            this.transaction_ = input.readBytes();
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
                    synchronized (CommitRequest.class) {
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
        CommitRequest commitRequest = new CommitRequest();
        DEFAULT_INSTANCE = commitRequest;
        commitRequest.makeImmutable();
    }

    public static CommitRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<CommitRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
