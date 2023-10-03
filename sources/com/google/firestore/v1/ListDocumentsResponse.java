package com.google.firestore.v1;

import com.google.firestore.v1.Document;
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
public final class ListDocumentsResponse extends GeneratedMessageLite<ListDocumentsResponse, Builder> implements ListDocumentsResponseOrBuilder {
    /* access modifiers changed from: private */
    public static final ListDocumentsResponse DEFAULT_INSTANCE;
    public static final int DOCUMENTS_FIELD_NUMBER = 1;
    public static final int NEXT_PAGE_TOKEN_FIELD_NUMBER = 2;
    private static volatile Parser<ListDocumentsResponse> PARSER;
    private int bitField0_;
    private Internal.ProtobufList<Document> documents_ = emptyProtobufList();
    private String nextPageToken_ = "";

    private ListDocumentsResponse() {
    }

    public List<Document> getDocumentsList() {
        return this.documents_;
    }

    public List<? extends DocumentOrBuilder> getDocumentsOrBuilderList() {
        return this.documents_;
    }

    public int getDocumentsCount() {
        return this.documents_.size();
    }

    public Document getDocuments(int index) {
        return (Document) this.documents_.get(index);
    }

    public DocumentOrBuilder getDocumentsOrBuilder(int index) {
        return (DocumentOrBuilder) this.documents_.get(index);
    }

    private void ensureDocumentsIsMutable() {
        if (!this.documents_.isModifiable()) {
            this.documents_ = GeneratedMessageLite.mutableCopy(this.documents_);
        }
    }

    /* access modifiers changed from: private */
    public void setDocuments(int index, Document value) {
        if (value != null) {
            ensureDocumentsIsMutable();
            this.documents_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setDocuments(int index, Document.Builder builderForValue) {
        ensureDocumentsIsMutable();
        this.documents_.set(index, (Document) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addDocuments(Document value) {
        if (value != null) {
            ensureDocumentsIsMutable();
            this.documents_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addDocuments(int index, Document value) {
        if (value != null) {
            ensureDocumentsIsMutable();
            this.documents_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addDocuments(Document.Builder builderForValue) {
        ensureDocumentsIsMutable();
        this.documents_.add((Document) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addDocuments(int index, Document.Builder builderForValue) {
        ensureDocumentsIsMutable();
        this.documents_.add(index, (Document) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllDocuments(Iterable<? extends Document> values) {
        ensureDocumentsIsMutable();
        AbstractMessageLite.addAll(values, this.documents_);
    }

    /* access modifiers changed from: private */
    public void clearDocuments() {
        this.documents_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeDocuments(int index) {
        ensureDocumentsIsMutable();
        this.documents_.remove(index);
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
        for (int i = 0; i < this.documents_.size(); i++) {
            output.writeMessage(1, (MessageLite) this.documents_.get(i));
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
        for (int i = 0; i < this.documents_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.documents_.get(i));
        }
        if (!this.nextPageToken_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(2, getNextPageToken());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static ListDocumentsResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (ListDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ListDocumentsResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ListDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ListDocumentsResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (ListDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ListDocumentsResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ListDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ListDocumentsResponse parseFrom(InputStream input) throws IOException {
        return (ListDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ListDocumentsResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ListDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ListDocumentsResponse parseDelimitedFrom(InputStream input) throws IOException {
        return (ListDocumentsResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static ListDocumentsResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ListDocumentsResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ListDocumentsResponse parseFrom(CodedInputStream input) throws IOException {
        return (ListDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ListDocumentsResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ListDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ListDocumentsResponse prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<ListDocumentsResponse, Builder> implements ListDocumentsResponseOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(ListDocumentsResponse.DEFAULT_INSTANCE);
        }

        public List<Document> getDocumentsList() {
            return Collections.unmodifiableList(((ListDocumentsResponse) this.instance).getDocumentsList());
        }

        public int getDocumentsCount() {
            return ((ListDocumentsResponse) this.instance).getDocumentsCount();
        }

        public Document getDocuments(int index) {
            return ((ListDocumentsResponse) this.instance).getDocuments(index);
        }

        public Builder setDocuments(int index, Document value) {
            copyOnWrite();
            ((ListDocumentsResponse) this.instance).setDocuments(index, value);
            return this;
        }

        public Builder setDocuments(int index, Document.Builder builderForValue) {
            copyOnWrite();
            ((ListDocumentsResponse) this.instance).setDocuments(index, builderForValue);
            return this;
        }

        public Builder addDocuments(Document value) {
            copyOnWrite();
            ((ListDocumentsResponse) this.instance).addDocuments(value);
            return this;
        }

        public Builder addDocuments(int index, Document value) {
            copyOnWrite();
            ((ListDocumentsResponse) this.instance).addDocuments(index, value);
            return this;
        }

        public Builder addDocuments(Document.Builder builderForValue) {
            copyOnWrite();
            ((ListDocumentsResponse) this.instance).addDocuments(builderForValue);
            return this;
        }

        public Builder addDocuments(int index, Document.Builder builderForValue) {
            copyOnWrite();
            ((ListDocumentsResponse) this.instance).addDocuments(index, builderForValue);
            return this;
        }

        public Builder addAllDocuments(Iterable<? extends Document> values) {
            copyOnWrite();
            ((ListDocumentsResponse) this.instance).addAllDocuments(values);
            return this;
        }

        public Builder clearDocuments() {
            copyOnWrite();
            ((ListDocumentsResponse) this.instance).clearDocuments();
            return this;
        }

        public Builder removeDocuments(int index) {
            copyOnWrite();
            ((ListDocumentsResponse) this.instance).removeDocuments(index);
            return this;
        }

        public String getNextPageToken() {
            return ((ListDocumentsResponse) this.instance).getNextPageToken();
        }

        public ByteString getNextPageTokenBytes() {
            return ((ListDocumentsResponse) this.instance).getNextPageTokenBytes();
        }

        public Builder setNextPageToken(String value) {
            copyOnWrite();
            ((ListDocumentsResponse) this.instance).setNextPageToken(value);
            return this;
        }

        public Builder clearNextPageToken() {
            copyOnWrite();
            ((ListDocumentsResponse) this.instance).clearNextPageToken();
            return this;
        }

        public Builder setNextPageTokenBytes(ByteString value) {
            copyOnWrite();
            ((ListDocumentsResponse) this.instance).setNextPageTokenBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.ListDocumentsResponse$1  reason: invalid class name */
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
                return new ListDocumentsResponse();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.documents_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                ListDocumentsResponse other = (ListDocumentsResponse) arg1;
                this.documents_ = visitor.visitList(this.documents_, other.documents_);
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
                            if (!this.documents_.isModifiable()) {
                                this.documents_ = GeneratedMessageLite.mutableCopy(this.documents_);
                            }
                            this.documents_.add((Document) input.readMessage(Document.parser(), extensionRegistry));
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
                    synchronized (ListDocumentsResponse.class) {
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
        ListDocumentsResponse listDocumentsResponse = new ListDocumentsResponse();
        DEFAULT_INSTANCE = listDocumentsResponse;
        listDocumentsResponse.makeImmutable();
    }

    public static ListDocumentsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<ListDocumentsResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
