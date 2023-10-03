package com.google.longrunning;

import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.rpc.Status;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class Operation extends GeneratedMessageLite<Operation, Builder> implements OperationOrBuilder {
    /* access modifiers changed from: private */
    public static final Operation DEFAULT_INSTANCE;
    public static final int DONE_FIELD_NUMBER = 3;
    public static final int ERROR_FIELD_NUMBER = 4;
    public static final int METADATA_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Operation> PARSER = null;
    public static final int RESPONSE_FIELD_NUMBER = 5;
    private boolean done_;
    private Any metadata_;
    private String name_ = "";
    private int resultCase_ = 0;
    private Object result_;

    private Operation() {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public enum ResultCase implements Internal.EnumLite {
        ERROR(4),
        RESPONSE(5),
        RESULT_NOT_SET(0);
        
        private final int value;

        private ResultCase(int value2) {
            this.value = value2;
        }

        @Deprecated
        public static ResultCase valueOf(int value2) {
            return forNumber(value2);
        }

        public static ResultCase forNumber(int value2) {
            if (value2 == 0) {
                return RESULT_NOT_SET;
            }
            if (value2 == 4) {
                return ERROR;
            }
            if (value2 != 5) {
                return null;
            }
            return RESPONSE;
        }

        public int getNumber() {
            return this.value;
        }
    }

    public ResultCase getResultCase() {
        return ResultCase.forNumber(this.resultCase_);
    }

    /* access modifiers changed from: private */
    public void clearResult() {
        this.resultCase_ = 0;
        this.result_ = null;
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

    public boolean hasMetadata() {
        return this.metadata_ != null;
    }

    public Any getMetadata() {
        Any any = this.metadata_;
        return any == null ? Any.getDefaultInstance() : any;
    }

    /* access modifiers changed from: private */
    public void setMetadata(Any value) {
        if (value != null) {
            this.metadata_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setMetadata(Any.Builder builderForValue) {
        this.metadata_ = (Any) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeMetadata(Any value) {
        Any any = this.metadata_;
        if (any == null || any == Any.getDefaultInstance()) {
            this.metadata_ = value;
        } else {
            this.metadata_ = (Any) ((Any.Builder) Any.newBuilder(this.metadata_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearMetadata() {
        this.metadata_ = null;
    }

    public boolean getDone() {
        return this.done_;
    }

    /* access modifiers changed from: private */
    public void setDone(boolean value) {
        this.done_ = value;
    }

    /* access modifiers changed from: private */
    public void clearDone() {
        this.done_ = false;
    }

    public Status getError() {
        if (this.resultCase_ == 4) {
            return (Status) this.result_;
        }
        return Status.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setError(Status value) {
        if (value != null) {
            this.result_ = value;
            this.resultCase_ = 4;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setError(Status.Builder builderForValue) {
        this.result_ = builderForValue.build();
        this.resultCase_ = 4;
    }

    /* access modifiers changed from: private */
    public void mergeError(Status value) {
        if (this.resultCase_ != 4 || this.result_ == Status.getDefaultInstance()) {
            this.result_ = value;
        } else {
            this.result_ = ((Status.Builder) Status.newBuilder((Status) this.result_).mergeFrom(value)).buildPartial();
        }
        this.resultCase_ = 4;
    }

    /* access modifiers changed from: private */
    public void clearError() {
        if (this.resultCase_ == 4) {
            this.resultCase_ = 0;
            this.result_ = null;
        }
    }

    public Any getResponse() {
        if (this.resultCase_ == 5) {
            return (Any) this.result_;
        }
        return Any.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setResponse(Any value) {
        if (value != null) {
            this.result_ = value;
            this.resultCase_ = 5;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setResponse(Any.Builder builderForValue) {
        this.result_ = builderForValue.build();
        this.resultCase_ = 5;
    }

    /* access modifiers changed from: private */
    public void mergeResponse(Any value) {
        if (this.resultCase_ != 5 || this.result_ == Any.getDefaultInstance()) {
            this.result_ = value;
        } else {
            this.result_ = ((Any.Builder) Any.newBuilder((Any) this.result_).mergeFrom(value)).buildPartial();
        }
        this.resultCase_ = 5;
    }

    /* access modifiers changed from: private */
    public void clearResponse() {
        if (this.resultCase_ == 5) {
            this.resultCase_ = 0;
            this.result_ = null;
        }
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.name_.isEmpty()) {
            output.writeString(1, getName());
        }
        if (this.metadata_ != null) {
            output.writeMessage(2, getMetadata());
        }
        boolean z = this.done_;
        if (z) {
            output.writeBool(3, z);
        }
        if (this.resultCase_ == 4) {
            output.writeMessage(4, (Status) this.result_);
        }
        if (this.resultCase_ == 5) {
            output.writeMessage(5, (Any) this.result_);
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
        if (this.metadata_ != null) {
            size2 += CodedOutputStream.computeMessageSize(2, getMetadata());
        }
        boolean z = this.done_;
        if (z) {
            size2 += CodedOutputStream.computeBoolSize(3, z);
        }
        if (this.resultCase_ == 4) {
            size2 += CodedOutputStream.computeMessageSize(4, (Status) this.result_);
        }
        if (this.resultCase_ == 5) {
            size2 += CodedOutputStream.computeMessageSize(5, (Any) this.result_);
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Operation parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Operation parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Operation parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Operation parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Operation parseFrom(InputStream input) throws IOException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Operation parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Operation parseDelimitedFrom(InputStream input) throws IOException {
        return (Operation) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Operation parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Operation) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Operation parseFrom(CodedInputStream input) throws IOException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Operation parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Operation prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Operation, Builder> implements OperationOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Operation.DEFAULT_INSTANCE);
        }

        public ResultCase getResultCase() {
            return ((Operation) this.instance).getResultCase();
        }

        public Builder clearResult() {
            copyOnWrite();
            ((Operation) this.instance).clearResult();
            return this;
        }

        public String getName() {
            return ((Operation) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((Operation) this.instance).getNameBytes();
        }

        public Builder setName(String value) {
            copyOnWrite();
            ((Operation) this.instance).setName(value);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((Operation) this.instance).clearName();
            return this;
        }

        public Builder setNameBytes(ByteString value) {
            copyOnWrite();
            ((Operation) this.instance).setNameBytes(value);
            return this;
        }

        public boolean hasMetadata() {
            return ((Operation) this.instance).hasMetadata();
        }

        public Any getMetadata() {
            return ((Operation) this.instance).getMetadata();
        }

        public Builder setMetadata(Any value) {
            copyOnWrite();
            ((Operation) this.instance).setMetadata(value);
            return this;
        }

        public Builder setMetadata(Any.Builder builderForValue) {
            copyOnWrite();
            ((Operation) this.instance).setMetadata(builderForValue);
            return this;
        }

        public Builder mergeMetadata(Any value) {
            copyOnWrite();
            ((Operation) this.instance).mergeMetadata(value);
            return this;
        }

        public Builder clearMetadata() {
            copyOnWrite();
            ((Operation) this.instance).clearMetadata();
            return this;
        }

        public boolean getDone() {
            return ((Operation) this.instance).getDone();
        }

        public Builder setDone(boolean value) {
            copyOnWrite();
            ((Operation) this.instance).setDone(value);
            return this;
        }

        public Builder clearDone() {
            copyOnWrite();
            ((Operation) this.instance).clearDone();
            return this;
        }

        public Status getError() {
            return ((Operation) this.instance).getError();
        }

        public Builder setError(Status value) {
            copyOnWrite();
            ((Operation) this.instance).setError(value);
            return this;
        }

        public Builder setError(Status.Builder builderForValue) {
            copyOnWrite();
            ((Operation) this.instance).setError(builderForValue);
            return this;
        }

        public Builder mergeError(Status value) {
            copyOnWrite();
            ((Operation) this.instance).mergeError(value);
            return this;
        }

        public Builder clearError() {
            copyOnWrite();
            ((Operation) this.instance).clearError();
            return this;
        }

        public Any getResponse() {
            return ((Operation) this.instance).getResponse();
        }

        public Builder setResponse(Any value) {
            copyOnWrite();
            ((Operation) this.instance).setResponse(value);
            return this;
        }

        public Builder setResponse(Any.Builder builderForValue) {
            copyOnWrite();
            ((Operation) this.instance).setResponse(builderForValue);
            return this;
        }

        public Builder mergeResponse(Any value) {
            copyOnWrite();
            ((Operation) this.instance).mergeResponse(value);
            return this;
        }

        public Builder clearResponse() {
            copyOnWrite();
            ((Operation) this.instance).clearResponse();
            return this;
        }
    }

    /* renamed from: com.google.longrunning.Operation$1  reason: invalid class name */
    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$longrunning$Operation$ResultCase;
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
            int[] iArr2 = new int[ResultCase.values().length];
            $SwitchMap$com$google$longrunning$Operation$ResultCase = iArr2;
            try {
                iArr2[ResultCase.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$longrunning$Operation$ResultCase[ResultCase.RESPONSE.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$google$longrunning$Operation$ResultCase[ResultCase.RESULT_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        int i;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
            case 1:
                return new Operation();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                Operation other = (Operation) arg1;
                boolean z = true;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !other.name_.isEmpty(), other.name_);
                this.metadata_ = (Any) visitor.visitMessage(this.metadata_, other.metadata_);
                boolean z2 = this.done_;
                boolean z3 = other.done_;
                this.done_ = visitor.visitBoolean(z2, z2, z3, z3);
                int i2 = AnonymousClass1.$SwitchMap$com$google$longrunning$Operation$ResultCase[other.getResultCase().ordinal()];
                if (i2 == 1) {
                    if (this.resultCase_ != 4) {
                        z = false;
                    }
                    this.result_ = visitor.visitOneofMessage(z, this.result_, other.result_);
                } else if (i2 == 2) {
                    if (this.resultCase_ != 5) {
                        z = false;
                    }
                    this.result_ = visitor.visitOneofMessage(z, this.result_, other.result_);
                } else if (i2 == 3) {
                    if (this.resultCase_ == 0) {
                        z = false;
                    }
                    visitor.visitOneofNotSet(z);
                }
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE && (i = other.resultCase_) != 0) {
                    this.resultCase_ = i;
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
                            Any.Builder subBuilder = null;
                            if (this.metadata_ != null) {
                                subBuilder = (Any.Builder) this.metadata_.toBuilder();
                            }
                            Any any = (Any) input.readMessage(Any.parser(), extensionRegistry);
                            this.metadata_ = any;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(any);
                                this.metadata_ = (Any) subBuilder.buildPartial();
                            }
                        } else if (tag == 24) {
                            this.done_ = input.readBool();
                        } else if (tag == 34) {
                            Status.Builder subBuilder2 = null;
                            if (this.resultCase_ == 4) {
                                subBuilder2 = (Status.Builder) ((Status) this.result_).toBuilder();
                            }
                            MessageLite readMessage = input.readMessage(Status.parser(), extensionRegistry);
                            this.result_ = readMessage;
                            if (subBuilder2 != null) {
                                subBuilder2.mergeFrom((Status) readMessage);
                                this.result_ = subBuilder2.buildPartial();
                            }
                            this.resultCase_ = 4;
                        } else if (tag == 42) {
                            Any.Builder subBuilder3 = null;
                            if (this.resultCase_ == 5) {
                                subBuilder3 = (Any.Builder) ((Any) this.result_).toBuilder();
                            }
                            MessageLite readMessage2 = input.readMessage(Any.parser(), extensionRegistry);
                            this.result_ = readMessage2;
                            if (subBuilder3 != null) {
                                subBuilder3.mergeFrom((Any) readMessage2);
                                this.result_ = subBuilder3.buildPartial();
                            }
                            this.resultCase_ = 5;
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
                    synchronized (Operation.class) {
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
        Operation operation = new Operation();
        DEFAULT_INSTANCE = operation;
        operation.makeImmutable();
    }

    public static Operation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Operation> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
