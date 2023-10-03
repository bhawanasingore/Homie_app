package com.google.rpc;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
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

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class Status extends GeneratedMessageLite<Status, Builder> implements StatusOrBuilder {
    public static final int CODE_FIELD_NUMBER = 1;
    /* access modifiers changed from: private */
    public static final Status DEFAULT_INSTANCE;
    public static final int DETAILS_FIELD_NUMBER = 3;
    public static final int MESSAGE_FIELD_NUMBER = 2;
    private static volatile Parser<Status> PARSER;
    private int bitField0_;
    private int code_;
    private Internal.ProtobufList<Any> details_ = emptyProtobufList();
    private String message_ = "";

    private Status() {
    }

    public int getCode() {
        return this.code_;
    }

    /* access modifiers changed from: private */
    public void setCode(int value) {
        this.code_ = value;
    }

    /* access modifiers changed from: private */
    public void clearCode() {
        this.code_ = 0;
    }

    public String getMessage() {
        return this.message_;
    }

    public ByteString getMessageBytes() {
        return ByteString.copyFromUtf8(this.message_);
    }

    /* access modifiers changed from: private */
    public void setMessage(String value) {
        if (value != null) {
            this.message_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearMessage() {
        this.message_ = getDefaultInstance().getMessage();
    }

    /* access modifiers changed from: private */
    public void setMessageBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.message_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public List<Any> getDetailsList() {
        return this.details_;
    }

    public List<? extends AnyOrBuilder> getDetailsOrBuilderList() {
        return this.details_;
    }

    public int getDetailsCount() {
        return this.details_.size();
    }

    public Any getDetails(int index) {
        return (Any) this.details_.get(index);
    }

    public AnyOrBuilder getDetailsOrBuilder(int index) {
        return (AnyOrBuilder) this.details_.get(index);
    }

    private void ensureDetailsIsMutable() {
        if (!this.details_.isModifiable()) {
            this.details_ = GeneratedMessageLite.mutableCopy(this.details_);
        }
    }

    /* access modifiers changed from: private */
    public void setDetails(int index, Any value) {
        if (value != null) {
            ensureDetailsIsMutable();
            this.details_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setDetails(int index, Any.Builder builderForValue) {
        ensureDetailsIsMutable();
        this.details_.set(index, (Any) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addDetails(Any value) {
        if (value != null) {
            ensureDetailsIsMutable();
            this.details_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addDetails(int index, Any value) {
        if (value != null) {
            ensureDetailsIsMutable();
            this.details_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addDetails(Any.Builder builderForValue) {
        ensureDetailsIsMutable();
        this.details_.add((Any) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addDetails(int index, Any.Builder builderForValue) {
        ensureDetailsIsMutable();
        this.details_.add(index, (Any) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllDetails(Iterable<? extends Any> values) {
        ensureDetailsIsMutable();
        AbstractMessageLite.addAll(values, this.details_);
    }

    /* access modifiers changed from: private */
    public void clearDetails() {
        this.details_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeDetails(int index) {
        ensureDetailsIsMutable();
        this.details_.remove(index);
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        int i = this.code_;
        if (i != 0) {
            output.writeInt32(1, i);
        }
        if (!this.message_.isEmpty()) {
            output.writeString(2, getMessage());
        }
        for (int i2 = 0; i2 < this.details_.size(); i2++) {
            output.writeMessage(3, (MessageLite) this.details_.get(i2));
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        int i = this.code_;
        if (i != 0) {
            size2 = 0 + CodedOutputStream.computeInt32Size(1, i);
        }
        if (!this.message_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(2, getMessage());
        }
        for (int i2 = 0; i2 < this.details_.size(); i2++) {
            size2 += CodedOutputStream.computeMessageSize(3, (MessageLite) this.details_.get(i2));
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Status parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Status) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Status parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Status) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Status parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Status) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Status parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Status) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Status parseFrom(InputStream input) throws IOException {
        return (Status) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Status parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Status) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Status parseDelimitedFrom(InputStream input) throws IOException {
        return (Status) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Status parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Status) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Status parseFrom(CodedInputStream input) throws IOException {
        return (Status) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Status parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Status) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Status prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Status, Builder> implements StatusOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Status.DEFAULT_INSTANCE);
        }

        public int getCode() {
            return ((Status) this.instance).getCode();
        }

        public Builder setCode(int value) {
            copyOnWrite();
            ((Status) this.instance).setCode(value);
            return this;
        }

        public Builder clearCode() {
            copyOnWrite();
            ((Status) this.instance).clearCode();
            return this;
        }

        public String getMessage() {
            return ((Status) this.instance).getMessage();
        }

        public ByteString getMessageBytes() {
            return ((Status) this.instance).getMessageBytes();
        }

        public Builder setMessage(String value) {
            copyOnWrite();
            ((Status) this.instance).setMessage(value);
            return this;
        }

        public Builder clearMessage() {
            copyOnWrite();
            ((Status) this.instance).clearMessage();
            return this;
        }

        public Builder setMessageBytes(ByteString value) {
            copyOnWrite();
            ((Status) this.instance).setMessageBytes(value);
            return this;
        }

        public List<Any> getDetailsList() {
            return Collections.unmodifiableList(((Status) this.instance).getDetailsList());
        }

        public int getDetailsCount() {
            return ((Status) this.instance).getDetailsCount();
        }

        public Any getDetails(int index) {
            return ((Status) this.instance).getDetails(index);
        }

        public Builder setDetails(int index, Any value) {
            copyOnWrite();
            ((Status) this.instance).setDetails(index, value);
            return this;
        }

        public Builder setDetails(int index, Any.Builder builderForValue) {
            copyOnWrite();
            ((Status) this.instance).setDetails(index, builderForValue);
            return this;
        }

        public Builder addDetails(Any value) {
            copyOnWrite();
            ((Status) this.instance).addDetails(value);
            return this;
        }

        public Builder addDetails(int index, Any value) {
            copyOnWrite();
            ((Status) this.instance).addDetails(index, value);
            return this;
        }

        public Builder addDetails(Any.Builder builderForValue) {
            copyOnWrite();
            ((Status) this.instance).addDetails(builderForValue);
            return this;
        }

        public Builder addDetails(int index, Any.Builder builderForValue) {
            copyOnWrite();
            ((Status) this.instance).addDetails(index, builderForValue);
            return this;
        }

        public Builder addAllDetails(Iterable<? extends Any> values) {
            copyOnWrite();
            ((Status) this.instance).addAllDetails(values);
            return this;
        }

        public Builder clearDetails() {
            copyOnWrite();
            ((Status) this.instance).clearDetails();
            return this;
        }

        public Builder removeDetails(int index) {
            copyOnWrite();
            ((Status) this.instance).removeDetails(index);
            return this;
        }
    }

    /* renamed from: com.google.rpc.Status$1  reason: invalid class name */
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
                return new Status();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.details_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                Status other = (Status) arg1;
                boolean z = false;
                boolean z2 = this.code_ != 0;
                int i = this.code_;
                if (other.code_ != 0) {
                    z = true;
                }
                this.code_ = visitor.visitInt(z2, i, z, other.code_);
                this.message_ = visitor.visitString(!this.message_.isEmpty(), this.message_, true ^ other.message_.isEmpty(), other.message_);
                this.details_ = visitor.visitList(this.details_, other.details_);
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
                        } else if (tag == 8) {
                            this.code_ = input.readInt32();
                        } else if (tag == 18) {
                            this.message_ = input.readStringRequireUtf8();
                        } else if (tag == 26) {
                            if (!this.details_.isModifiable()) {
                                this.details_ = GeneratedMessageLite.mutableCopy(this.details_);
                            }
                            this.details_.add((Any) input.readMessage(Any.parser(), extensionRegistry));
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
                    synchronized (Status.class) {
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
        Status status = new Status();
        DEFAULT_INSTANCE = status;
        status.makeImmutable();
    }

    public static Status getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Status> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
