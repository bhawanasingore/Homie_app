package com.google.firestore.v1;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public final class ListCollectionIdsResponse extends GeneratedMessageLite<ListCollectionIdsResponse, Builder> implements ListCollectionIdsResponseOrBuilder {
    public static final int COLLECTION_IDS_FIELD_NUMBER = 1;
    /* access modifiers changed from: private */
    public static final ListCollectionIdsResponse DEFAULT_INSTANCE;
    public static final int NEXT_PAGE_TOKEN_FIELD_NUMBER = 2;
    private static volatile Parser<ListCollectionIdsResponse> PARSER;
    private int bitField0_;
    private Internal.ProtobufList<String> collectionIds_ = GeneratedMessageLite.emptyProtobufList();
    private String nextPageToken_ = "";

    private ListCollectionIdsResponse() {
    }

    public List<String> getCollectionIdsList() {
        return this.collectionIds_;
    }

    public int getCollectionIdsCount() {
        return this.collectionIds_.size();
    }

    public String getCollectionIds(int index) {
        return (String) this.collectionIds_.get(index);
    }

    public ByteString getCollectionIdsBytes(int index) {
        return ByteString.copyFromUtf8((String) this.collectionIds_.get(index));
    }

    private void ensureCollectionIdsIsMutable() {
        if (!this.collectionIds_.isModifiable()) {
            this.collectionIds_ = GeneratedMessageLite.mutableCopy(this.collectionIds_);
        }
    }

    /* access modifiers changed from: private */
    public void setCollectionIds(int index, String value) {
        if (value != null) {
            ensureCollectionIdsIsMutable();
            this.collectionIds_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addCollectionIds(String value) {
        if (value != null) {
            ensureCollectionIdsIsMutable();
            this.collectionIds_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addAllCollectionIds(Iterable<String> values) {
        ensureCollectionIdsIsMutable();
        AbstractMessageLite.addAll(values, this.collectionIds_);
    }

    /* access modifiers changed from: private */
    public void clearCollectionIds() {
        this.collectionIds_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void addCollectionIdsBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            ensureCollectionIdsIsMutable();
            this.collectionIds_.add(value.toStringUtf8());
            return;
        }
        throw null;
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
        for (int i = 0; i < this.collectionIds_.size(); i++) {
            output.writeString(1, (String) this.collectionIds_.get(i));
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
        int dataSize = 0;
        for (int i = 0; i < this.collectionIds_.size(); i++) {
            dataSize += CodedOutputStream.computeStringSizeNoTag((String) this.collectionIds_.get(i));
        }
        int size2 = 0 + dataSize + (getCollectionIdsList().size() * 1);
        if (!this.nextPageToken_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(2, getNextPageToken());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static ListCollectionIdsResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (ListCollectionIdsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ListCollectionIdsResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ListCollectionIdsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ListCollectionIdsResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (ListCollectionIdsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ListCollectionIdsResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ListCollectionIdsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ListCollectionIdsResponse parseFrom(InputStream input) throws IOException {
        return (ListCollectionIdsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ListCollectionIdsResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ListCollectionIdsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ListCollectionIdsResponse parseDelimitedFrom(InputStream input) throws IOException {
        return (ListCollectionIdsResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static ListCollectionIdsResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ListCollectionIdsResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ListCollectionIdsResponse parseFrom(CodedInputStream input) throws IOException {
        return (ListCollectionIdsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ListCollectionIdsResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ListCollectionIdsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ListCollectionIdsResponse prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<ListCollectionIdsResponse, Builder> implements ListCollectionIdsResponseOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(ListCollectionIdsResponse.DEFAULT_INSTANCE);
        }

        public List<String> getCollectionIdsList() {
            return Collections.unmodifiableList(((ListCollectionIdsResponse) this.instance).getCollectionIdsList());
        }

        public int getCollectionIdsCount() {
            return ((ListCollectionIdsResponse) this.instance).getCollectionIdsCount();
        }

        public String getCollectionIds(int index) {
            return ((ListCollectionIdsResponse) this.instance).getCollectionIds(index);
        }

        public ByteString getCollectionIdsBytes(int index) {
            return ((ListCollectionIdsResponse) this.instance).getCollectionIdsBytes(index);
        }

        public Builder setCollectionIds(int index, String value) {
            copyOnWrite();
            ((ListCollectionIdsResponse) this.instance).setCollectionIds(index, value);
            return this;
        }

        public Builder addCollectionIds(String value) {
            copyOnWrite();
            ((ListCollectionIdsResponse) this.instance).addCollectionIds(value);
            return this;
        }

        public Builder addAllCollectionIds(Iterable<String> values) {
            copyOnWrite();
            ((ListCollectionIdsResponse) this.instance).addAllCollectionIds(values);
            return this;
        }

        public Builder clearCollectionIds() {
            copyOnWrite();
            ((ListCollectionIdsResponse) this.instance).clearCollectionIds();
            return this;
        }

        public Builder addCollectionIdsBytes(ByteString value) {
            copyOnWrite();
            ((ListCollectionIdsResponse) this.instance).addCollectionIdsBytes(value);
            return this;
        }

        public String getNextPageToken() {
            return ((ListCollectionIdsResponse) this.instance).getNextPageToken();
        }

        public ByteString getNextPageTokenBytes() {
            return ((ListCollectionIdsResponse) this.instance).getNextPageTokenBytes();
        }

        public Builder setNextPageToken(String value) {
            copyOnWrite();
            ((ListCollectionIdsResponse) this.instance).setNextPageToken(value);
            return this;
        }

        public Builder clearNextPageToken() {
            copyOnWrite();
            ((ListCollectionIdsResponse) this.instance).clearNextPageToken();
            return this;
        }

        public Builder setNextPageTokenBytes(ByteString value) {
            copyOnWrite();
            ((ListCollectionIdsResponse) this.instance).setNextPageTokenBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.ListCollectionIdsResponse$1  reason: invalid class name */
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
                return new ListCollectionIdsResponse();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.collectionIds_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                ListCollectionIdsResponse other = (ListCollectionIdsResponse) arg1;
                this.collectionIds_ = visitor.visitList(this.collectionIds_, other.collectionIds_);
                this.nextPageToken_ = visitor.visitString(!this.nextPageToken_.isEmpty(), this.nextPageToken_, !other.nextPageToken_.isEmpty(), other.nextPageToken_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= other.bitField0_;
                }
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
                            String s = input.readStringRequireUtf8();
                            if (!this.collectionIds_.isModifiable()) {
                                this.collectionIds_ = GeneratedMessageLite.mutableCopy(this.collectionIds_);
                            }
                            this.collectionIds_.add(s);
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
                    synchronized (ListCollectionIdsResponse.class) {
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
        ListCollectionIdsResponse listCollectionIdsResponse = new ListCollectionIdsResponse();
        DEFAULT_INSTANCE = listCollectionIdsResponse;
        listCollectionIdsResponse.makeImmutable();
    }

    public static ListCollectionIdsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<ListCollectionIdsResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
