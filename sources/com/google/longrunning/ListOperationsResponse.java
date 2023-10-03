package com.google.longrunning;

import com.google.longrunning.Operation;
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

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class ListOperationsResponse extends GeneratedMessageLite<ListOperationsResponse, Builder> implements ListOperationsResponseOrBuilder {
    /* access modifiers changed from: private */
    public static final ListOperationsResponse DEFAULT_INSTANCE;
    public static final int NEXT_PAGE_TOKEN_FIELD_NUMBER = 2;
    public static final int OPERATIONS_FIELD_NUMBER = 1;
    private static volatile Parser<ListOperationsResponse> PARSER;
    private int bitField0_;
    private String nextPageToken_ = "";
    private Internal.ProtobufList<Operation> operations_ = emptyProtobufList();

    private ListOperationsResponse() {
    }

    public List<Operation> getOperationsList() {
        return this.operations_;
    }

    public List<? extends OperationOrBuilder> getOperationsOrBuilderList() {
        return this.operations_;
    }

    public int getOperationsCount() {
        return this.operations_.size();
    }

    public Operation getOperations(int index) {
        return (Operation) this.operations_.get(index);
    }

    public OperationOrBuilder getOperationsOrBuilder(int index) {
        return (OperationOrBuilder) this.operations_.get(index);
    }

    private void ensureOperationsIsMutable() {
        if (!this.operations_.isModifiable()) {
            this.operations_ = GeneratedMessageLite.mutableCopy(this.operations_);
        }
    }

    /* access modifiers changed from: private */
    public void setOperations(int index, Operation value) {
        if (value != null) {
            ensureOperationsIsMutable();
            this.operations_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setOperations(int index, Operation.Builder builderForValue) {
        ensureOperationsIsMutable();
        this.operations_.set(index, (Operation) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addOperations(Operation value) {
        if (value != null) {
            ensureOperationsIsMutable();
            this.operations_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addOperations(int index, Operation value) {
        if (value != null) {
            ensureOperationsIsMutable();
            this.operations_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addOperations(Operation.Builder builderForValue) {
        ensureOperationsIsMutable();
        this.operations_.add((Operation) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addOperations(int index, Operation.Builder builderForValue) {
        ensureOperationsIsMutable();
        this.operations_.add(index, (Operation) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllOperations(Iterable<? extends Operation> values) {
        ensureOperationsIsMutable();
        AbstractMessageLite.addAll(values, this.operations_);
    }

    /* access modifiers changed from: private */
    public void clearOperations() {
        this.operations_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeOperations(int index) {
        ensureOperationsIsMutable();
        this.operations_.remove(index);
    }

    public String getNextPageToken() {
        return this.nextPageToken_;
    }

    public ByteString getNextPageTokenBytes() {
        return ByteString.copyFromUtf8(this.nextPageToken_);
    }

    /* access modifiers changed from: private */
    public void setNextPageToken(String value) {
        if (value != null) {
            this.nextPageToken_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearNextPageToken() {
        this.nextPageToken_ = getDefaultInstance().getNextPageToken();
    }

    /* access modifiers changed from: private */
    public void setNextPageTokenBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.nextPageToken_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        for (int i = 0; i < this.operations_.size(); i++) {
            output.writeMessage(1, (MessageLite) this.operations_.get(i));
        }
        if (!this.nextPageToken_.isEmpty()) {
            output.writeString(2, getNextPageToken());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        for (int i = 0; i < this.operations_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.operations_.get(i));
        }
        if (!this.nextPageToken_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(2, getNextPageToken());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static ListOperationsResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ListOperationsResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ListOperationsResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ListOperationsResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ListOperationsResponse parseFrom(InputStream input) throws IOException {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ListOperationsResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ListOperationsResponse parseDelimitedFrom(InputStream input) throws IOException {
        return (ListOperationsResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static ListOperationsResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ListOperationsResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ListOperationsResponse parseFrom(CodedInputStream input) throws IOException {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ListOperationsResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ListOperationsResponse prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<ListOperationsResponse, Builder> implements ListOperationsResponseOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(ListOperationsResponse.DEFAULT_INSTANCE);
        }

        public List<Operation> getOperationsList() {
            return Collections.unmodifiableList(((ListOperationsResponse) this.instance).getOperationsList());
        }

        public int getOperationsCount() {
            return ((ListOperationsResponse) this.instance).getOperationsCount();
        }

        public Operation getOperations(int index) {
            return ((ListOperationsResponse) this.instance).getOperations(index);
        }

        public Builder setOperations(int index, Operation value) {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).setOperations(index, value);
            return this;
        }

        public Builder setOperations(int index, Operation.Builder builderForValue) {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).setOperations(index, builderForValue);
            return this;
        }

        public Builder addOperations(Operation value) {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).addOperations(value);
            return this;
        }

        public Builder addOperations(int index, Operation value) {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).addOperations(index, value);
            return this;
        }

        public Builder addOperations(Operation.Builder builderForValue) {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).addOperations(builderForValue);
            return this;
        }

        public Builder addOperations(int index, Operation.Builder builderForValue) {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).addOperations(index, builderForValue);
            return this;
        }

        public Builder addAllOperations(Iterable<? extends Operation> values) {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).addAllOperations(values);
            return this;
        }

        public Builder clearOperations() {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).clearOperations();
            return this;
        }

        public Builder removeOperations(int index) {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).removeOperations(index);
            return this;
        }

        public String getNextPageToken() {
            return ((ListOperationsResponse) this.instance).getNextPageToken();
        }

        public ByteString getNextPageTokenBytes() {
            return ((ListOperationsResponse) this.instance).getNextPageTokenBytes();
        }

        public Builder setNextPageToken(String value) {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).setNextPageToken(value);
            return this;
        }

        public Builder clearNextPageToken() {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).clearNextPageToken();
            return this;
        }

        public Builder setNextPageTokenBytes(ByteString value) {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).setNextPageTokenBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.longrunning.ListOperationsResponse$1  reason: invalid class name */
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
                return new ListOperationsResponse();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.operations_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                ListOperationsResponse other = (ListOperationsResponse) arg1;
                this.operations_ = visitor.visitList(this.operations_, other.operations_);
                this.nextPageToken_ = visitor.visitString(!this.nextPageToken_.isEmpty(), this.nextPageToken_, !other.nextPageToken_.isEmpty(), other.nextPageToken_);
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
                            if (!this.operations_.isModifiable()) {
                                this.operations_ = GeneratedMessageLite.mutableCopy(this.operations_);
                            }
                            this.operations_.add((Operation) input.readMessage(Operation.parser(), extensionRegistry));
                        } else if (tag == 18) {
                            this.nextPageToken_ = input.readStringRequireUtf8();
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
                    synchronized (ListOperationsResponse.class) {
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
        ListOperationsResponse listOperationsResponse = new ListOperationsResponse();
        DEFAULT_INSTANCE = listOperationsResponse;
        listOperationsResponse.makeImmutable();
    }

    public static ListOperationsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<ListOperationsResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
