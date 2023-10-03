package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public final class ListCollectionIdsRequest extends GeneratedMessageLite<ListCollectionIdsRequest, Builder> implements ListCollectionIdsRequestOrBuilder {
    /* access modifiers changed from: private */
    public static final ListCollectionIdsRequest DEFAULT_INSTANCE;
    public static final int PAGE_SIZE_FIELD_NUMBER = 2;
    public static final int PAGE_TOKEN_FIELD_NUMBER = 3;
    public static final int PARENT_FIELD_NUMBER = 1;
    private static volatile Parser<ListCollectionIdsRequest> PARSER;
    private int pageSize_;
    private String pageToken_ = "";
    private String parent_ = "";

    private ListCollectionIdsRequest() {
    }

    public String getParent() {
        return this.parent_;
    }

    public ByteString getParentBytes() {
        return ByteString.copyFromUtf8(this.parent_);
    }

    /* access modifiers changed from: private */
    public void setParent(String value) {
        if (value != null) {
            this.parent_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearParent() {
        this.parent_ = getDefaultInstance().getParent();
    }

    /* access modifiers changed from: private */
    public void setParentBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.parent_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public int getPageSize() {
        return this.pageSize_;
    }

    /* access modifiers changed from: private */
    public void setPageSize(int value) {
        this.pageSize_ = value;
    }

    /* access modifiers changed from: private */
    public void clearPageSize() {
        this.pageSize_ = 0;
    }

    public String getPageToken() {
        return this.pageToken_;
    }

    public ByteString getPageTokenBytes() {
        return ByteString.copyFromUtf8(this.pageToken_);
    }

    /* access modifiers changed from: private */
    public void setPageToken(String value) {
        if (value != null) {
            this.pageToken_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearPageToken() {
        this.pageToken_ = getDefaultInstance().getPageToken();
    }

    /* access modifiers changed from: private */
    public void setPageTokenBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.pageToken_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.parent_.isEmpty()) {
            output.writeString(1, getParent());
        }
        int i = this.pageSize_;
        if (i != 0) {
            output.writeInt32(2, i);
        }
        if (!this.pageToken_.isEmpty()) {
            output.writeString(3, getPageToken());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.parent_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getParent());
        }
        int i = this.pageSize_;
        if (i != 0) {
            size2 += CodedOutputStream.computeInt32Size(2, i);
        }
        if (!this.pageToken_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(3, getPageToken());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static ListCollectionIdsRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (ListCollectionIdsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ListCollectionIdsRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ListCollectionIdsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ListCollectionIdsRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (ListCollectionIdsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ListCollectionIdsRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ListCollectionIdsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ListCollectionIdsRequest parseFrom(InputStream input) throws IOException {
        return (ListCollectionIdsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ListCollectionIdsRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ListCollectionIdsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ListCollectionIdsRequest parseDelimitedFrom(InputStream input) throws IOException {
        return (ListCollectionIdsRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static ListCollectionIdsRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ListCollectionIdsRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ListCollectionIdsRequest parseFrom(CodedInputStream input) throws IOException {
        return (ListCollectionIdsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ListCollectionIdsRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ListCollectionIdsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ListCollectionIdsRequest prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<ListCollectionIdsRequest, Builder> implements ListCollectionIdsRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(ListCollectionIdsRequest.DEFAULT_INSTANCE);
        }

        public String getParent() {
            return ((ListCollectionIdsRequest) this.instance).getParent();
        }

        public ByteString getParentBytes() {
            return ((ListCollectionIdsRequest) this.instance).getParentBytes();
        }

        public Builder setParent(String value) {
            copyOnWrite();
            ((ListCollectionIdsRequest) this.instance).setParent(value);
            return this;
        }

        public Builder clearParent() {
            copyOnWrite();
            ((ListCollectionIdsRequest) this.instance).clearParent();
            return this;
        }

        public Builder setParentBytes(ByteString value) {
            copyOnWrite();
            ((ListCollectionIdsRequest) this.instance).setParentBytes(value);
            return this;
        }

        public int getPageSize() {
            return ((ListCollectionIdsRequest) this.instance).getPageSize();
        }

        public Builder setPageSize(int value) {
            copyOnWrite();
            ((ListCollectionIdsRequest) this.instance).setPageSize(value);
            return this;
        }

        public Builder clearPageSize() {
            copyOnWrite();
            ((ListCollectionIdsRequest) this.instance).clearPageSize();
            return this;
        }

        public String getPageToken() {
            return ((ListCollectionIdsRequest) this.instance).getPageToken();
        }

        public ByteString getPageTokenBytes() {
            return ((ListCollectionIdsRequest) this.instance).getPageTokenBytes();
        }

        public Builder setPageToken(String value) {
            copyOnWrite();
            ((ListCollectionIdsRequest) this.instance).setPageToken(value);
            return this;
        }

        public Builder clearPageToken() {
            copyOnWrite();
            ((ListCollectionIdsRequest) this.instance).clearPageToken();
            return this;
        }

        public Builder setPageTokenBytes(ByteString value) {
            copyOnWrite();
            ((ListCollectionIdsRequest) this.instance).setPageTokenBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.ListCollectionIdsRequest$1  reason: invalid class name */
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
                return new ListCollectionIdsRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                ListCollectionIdsRequest other = (ListCollectionIdsRequest) arg1;
                this.parent_ = visitor.visitString(!this.parent_.isEmpty(), this.parent_, !other.parent_.isEmpty(), other.parent_);
                boolean z = false;
                boolean z2 = this.pageSize_ != 0;
                int i = this.pageSize_;
                if (other.pageSize_ != 0) {
                    z = true;
                }
                this.pageSize_ = visitor.visitInt(z2, i, z, other.pageSize_);
                this.pageToken_ = visitor.visitString(!this.pageToken_.isEmpty(), this.pageToken_, true ^ other.pageToken_.isEmpty(), other.pageToken_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case 6:
                CodedInputStream input = (CodedInputStream) arg0;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) arg1;
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.readTag();
                        if (tag == 0) {
                            done = true;
                        } else if (tag == 10) {
                            this.parent_ = input.readStringRequireUtf8();
                        } else if (tag == 16) {
                            this.pageSize_ = input.readInt32();
                        } else if (tag == 26) {
                            this.pageToken_ = input.readStringRequireUtf8();
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
                    synchronized (ListCollectionIdsRequest.class) {
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
        ListCollectionIdsRequest listCollectionIdsRequest = new ListCollectionIdsRequest();
        DEFAULT_INSTANCE = listCollectionIdsRequest;
        listCollectionIdsRequest.makeImmutable();
    }

    public static ListCollectionIdsRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<ListCollectionIdsRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
