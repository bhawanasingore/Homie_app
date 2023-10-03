package com.google.longrunning;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class ListOperationsRequest extends GeneratedMessageLite<ListOperationsRequest, Builder> implements ListOperationsRequestOrBuilder {
    /* access modifiers changed from: private */
    public static final ListOperationsRequest DEFAULT_INSTANCE;
    public static final int FILTER_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 4;
    public static final int PAGE_SIZE_FIELD_NUMBER = 2;
    public static final int PAGE_TOKEN_FIELD_NUMBER = 3;
    private static volatile Parser<ListOperationsRequest> PARSER;
    private String filter_ = "";
    private String name_ = "";
    private int pageSize_;
    private String pageToken_ = "";

    private ListOperationsRequest() {
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

    public String getFilter() {
        return this.filter_;
    }

    public ByteString getFilterBytes() {
        return ByteString.copyFromUtf8(this.filter_);
    }

    /* access modifiers changed from: private */
    public void setFilter(String value) {
        if (value != null) {
            this.filter_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearFilter() {
        this.filter_ = getDefaultInstance().getFilter();
    }

    /* access modifiers changed from: private */
    public void setFilterBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.filter_ = value.toStringUtf8();
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
        if (!this.filter_.isEmpty()) {
            output.writeString(1, getFilter());
        }
        int i = this.pageSize_;
        if (i != 0) {
            output.writeInt32(2, i);
        }
        if (!this.pageToken_.isEmpty()) {
            output.writeString(3, getPageToken());
        }
        if (!this.name_.isEmpty()) {
            output.writeString(4, getName());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.filter_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getFilter());
        }
        int i = this.pageSize_;
        if (i != 0) {
            size2 += CodedOutputStream.computeInt32Size(2, i);
        }
        if (!this.pageToken_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(3, getPageToken());
        }
        if (!this.name_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(4, getName());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static ListOperationsRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (ListOperationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ListOperationsRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ListOperationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ListOperationsRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (ListOperationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ListOperationsRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ListOperationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ListOperationsRequest parseFrom(InputStream input) throws IOException {
        return (ListOperationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ListOperationsRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ListOperationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ListOperationsRequest parseDelimitedFrom(InputStream input) throws IOException {
        return (ListOperationsRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static ListOperationsRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ListOperationsRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ListOperationsRequest parseFrom(CodedInputStream input) throws IOException {
        return (ListOperationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ListOperationsRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ListOperationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ListOperationsRequest prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<ListOperationsRequest, Builder> implements ListOperationsRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(ListOperationsRequest.DEFAULT_INSTANCE);
        }

        public String getName() {
            return ((ListOperationsRequest) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((ListOperationsRequest) this.instance).getNameBytes();
        }

        public Builder setName(String value) {
            copyOnWrite();
            ((ListOperationsRequest) this.instance).setName(value);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((ListOperationsRequest) this.instance).clearName();
            return this;
        }

        public Builder setNameBytes(ByteString value) {
            copyOnWrite();
            ((ListOperationsRequest) this.instance).setNameBytes(value);
            return this;
        }

        public String getFilter() {
            return ((ListOperationsRequest) this.instance).getFilter();
        }

        public ByteString getFilterBytes() {
            return ((ListOperationsRequest) this.instance).getFilterBytes();
        }

        public Builder setFilter(String value) {
            copyOnWrite();
            ((ListOperationsRequest) this.instance).setFilter(value);
            return this;
        }

        public Builder clearFilter() {
            copyOnWrite();
            ((ListOperationsRequest) this.instance).clearFilter();
            return this;
        }

        public Builder setFilterBytes(ByteString value) {
            copyOnWrite();
            ((ListOperationsRequest) this.instance).setFilterBytes(value);
            return this;
        }

        public int getPageSize() {
            return ((ListOperationsRequest) this.instance).getPageSize();
        }

        public Builder setPageSize(int value) {
            copyOnWrite();
            ((ListOperationsRequest) this.instance).setPageSize(value);
            return this;
        }

        public Builder clearPageSize() {
            copyOnWrite();
            ((ListOperationsRequest) this.instance).clearPageSize();
            return this;
        }

        public String getPageToken() {
            return ((ListOperationsRequest) this.instance).getPageToken();
        }

        public ByteString getPageTokenBytes() {
            return ((ListOperationsRequest) this.instance).getPageTokenBytes();
        }

        public Builder setPageToken(String value) {
            copyOnWrite();
            ((ListOperationsRequest) this.instance).setPageToken(value);
            return this;
        }

        public Builder clearPageToken() {
            copyOnWrite();
            ((ListOperationsRequest) this.instance).clearPageToken();
            return this;
        }

        public Builder setPageTokenBytes(ByteString value) {
            copyOnWrite();
            ((ListOperationsRequest) this.instance).setPageTokenBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.longrunning.ListOperationsRequest$1  reason: invalid class name */
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
                return new ListOperationsRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                ListOperationsRequest other = (ListOperationsRequest) arg1;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !other.name_.isEmpty(), other.name_);
                this.filter_ = visitor.visitString(!this.filter_.isEmpty(), this.filter_, !other.filter_.isEmpty(), other.filter_);
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
                            this.filter_ = input.readStringRequireUtf8();
                        } else if (tag == 16) {
                            this.pageSize_ = input.readInt32();
                        } else if (tag == 26) {
                            this.pageToken_ = input.readStringRequireUtf8();
                        } else if (tag == 34) {
                            this.name_ = input.readStringRequireUtf8();
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
                    synchronized (ListOperationsRequest.class) {
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
        ListOperationsRequest listOperationsRequest = new ListOperationsRequest();
        DEFAULT_INSTANCE = listOperationsRequest;
        listOperationsRequest.makeImmutable();
    }

    public static ListOperationsRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<ListOperationsRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
