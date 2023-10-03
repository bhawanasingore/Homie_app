package com.google.firestore.v1;

import com.google.firestore.v1.StructuredQuery;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public final class Target extends GeneratedMessageLite<Target, Builder> implements TargetOrBuilder {
    /* access modifiers changed from: private */
    public static final Target DEFAULT_INSTANCE;
    public static final int DOCUMENTS_FIELD_NUMBER = 3;
    public static final int ONCE_FIELD_NUMBER = 6;
    private static volatile Parser<Target> PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 2;
    public static final int READ_TIME_FIELD_NUMBER = 11;
    public static final int RESUME_TOKEN_FIELD_NUMBER = 4;
    public static final int TARGET_ID_FIELD_NUMBER = 5;
    private boolean once_;
    private int resumeTypeCase_ = 0;
    private Object resumeType_;
    private int targetId_;
    private int targetTypeCase_ = 0;
    private Object targetType_;

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public interface DocumentsTargetOrBuilder extends MessageLiteOrBuilder {
        String getDocuments(int i);

        ByteString getDocumentsBytes(int i);

        int getDocumentsCount();

        List<String> getDocumentsList();
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public interface QueryTargetOrBuilder extends MessageLiteOrBuilder {
        String getParent();

        ByteString getParentBytes();

        QueryTarget.QueryTypeCase getQueryTypeCase();

        StructuredQuery getStructuredQuery();
    }

    private Target() {
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class DocumentsTarget extends GeneratedMessageLite<DocumentsTarget, Builder> implements DocumentsTargetOrBuilder {
        /* access modifiers changed from: private */
        public static final DocumentsTarget DEFAULT_INSTANCE;
        public static final int DOCUMENTS_FIELD_NUMBER = 2;
        private static volatile Parser<DocumentsTarget> PARSER;
        private Internal.ProtobufList<String> documents_ = GeneratedMessageLite.emptyProtobufList();

        private DocumentsTarget() {
        }

        public List<String> getDocumentsList() {
            return this.documents_;
        }

        public int getDocumentsCount() {
            return this.documents_.size();
        }

        public String getDocuments(int index) {
            return (String) this.documents_.get(index);
        }

        public ByteString getDocumentsBytes(int index) {
            return ByteString.copyFromUtf8((String) this.documents_.get(index));
        }

        private void ensureDocumentsIsMutable() {
            if (!this.documents_.isModifiable()) {
                this.documents_ = GeneratedMessageLite.mutableCopy(this.documents_);
            }
        }

        /* access modifiers changed from: private */
        public void setDocuments(int index, String value) {
            if (value != null) {
                ensureDocumentsIsMutable();
                this.documents_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addDocuments(String value) {
            if (value != null) {
                ensureDocumentsIsMutable();
                this.documents_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addAllDocuments(Iterable<String> values) {
            ensureDocumentsIsMutable();
            AbstractMessageLite.addAll(values, this.documents_);
        }

        /* access modifiers changed from: private */
        public void clearDocuments() {
            this.documents_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void addDocumentsBytes(ByteString value) {
            if (value != null) {
                checkByteStringIsUtf8(value);
                ensureDocumentsIsMutable();
                this.documents_.add(value.toStringUtf8());
                return;
            }
            throw null;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            for (int i = 0; i < this.documents_.size(); i++) {
                output.writeString(2, (String) this.documents_.get(i));
            }
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int dataSize = 0;
            for (int i = 0; i < this.documents_.size(); i++) {
                dataSize += CodedOutputStream.computeStringSizeNoTag((String) this.documents_.get(i));
            }
            int size2 = 0 + dataSize + (getDocumentsList().size() * 1);
            this.memoizedSerializedSize = size2;
            return size2;
        }

        public static DocumentsTarget parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DocumentsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static DocumentsTarget parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DocumentsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static DocumentsTarget parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DocumentsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static DocumentsTarget parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DocumentsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static DocumentsTarget parseFrom(InputStream input) throws IOException {
            return (DocumentsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static DocumentsTarget parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DocumentsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static DocumentsTarget parseDelimitedFrom(InputStream input) throws IOException {
            return (DocumentsTarget) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static DocumentsTarget parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DocumentsTarget) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static DocumentsTarget parseFrom(CodedInputStream input) throws IOException {
            return (DocumentsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static DocumentsTarget parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DocumentsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DocumentsTarget prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
        public static final class Builder extends GeneratedMessageLite.Builder<DocumentsTarget, Builder> implements DocumentsTargetOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(DocumentsTarget.DEFAULT_INSTANCE);
            }

            public List<String> getDocumentsList() {
                return Collections.unmodifiableList(((DocumentsTarget) this.instance).getDocumentsList());
            }

            public int getDocumentsCount() {
                return ((DocumentsTarget) this.instance).getDocumentsCount();
            }

            public String getDocuments(int index) {
                return ((DocumentsTarget) this.instance).getDocuments(index);
            }

            public ByteString getDocumentsBytes(int index) {
                return ((DocumentsTarget) this.instance).getDocumentsBytes(index);
            }

            public Builder setDocuments(int index, String value) {
                copyOnWrite();
                ((DocumentsTarget) this.instance).setDocuments(index, value);
                return this;
            }

            public Builder addDocuments(String value) {
                copyOnWrite();
                ((DocumentsTarget) this.instance).addDocuments(value);
                return this;
            }

            public Builder addAllDocuments(Iterable<String> values) {
                copyOnWrite();
                ((DocumentsTarget) this.instance).addAllDocuments(values);
                return this;
            }

            public Builder clearDocuments() {
                copyOnWrite();
                ((DocumentsTarget) this.instance).clearDocuments();
                return this;
            }

            public Builder addDocumentsBytes(ByteString value) {
                copyOnWrite();
                ((DocumentsTarget) this.instance).addDocumentsBytes(value);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new DocumentsTarget();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.documents_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    this.documents_ = ((GeneratedMessageLite.Visitor) arg0).visitList(this.documents_, ((DocumentsTarget) arg1).documents_);
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
                            } else if (tag == 18) {
                                String s = input.readStringRequireUtf8();
                                if (!this.documents_.isModifiable()) {
                                    this.documents_ = GeneratedMessageLite.mutableCopy(this.documents_);
                                }
                                this.documents_.add(s);
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
                        synchronized (DocumentsTarget.class) {
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
            DocumentsTarget documentsTarget = new DocumentsTarget();
            DEFAULT_INSTANCE = documentsTarget;
            documentsTarget.makeImmutable();
        }

        public static DocumentsTarget getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DocumentsTarget> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class QueryTarget extends GeneratedMessageLite<QueryTarget, Builder> implements QueryTargetOrBuilder {
        /* access modifiers changed from: private */
        public static final QueryTarget DEFAULT_INSTANCE;
        public static final int PARENT_FIELD_NUMBER = 1;
        private static volatile Parser<QueryTarget> PARSER = null;
        public static final int STRUCTURED_QUERY_FIELD_NUMBER = 2;
        private String parent_ = "";
        private int queryTypeCase_ = 0;
        private Object queryType_;

        private QueryTarget() {
        }

        /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
        public enum QueryTypeCase implements Internal.EnumLite {
            STRUCTURED_QUERY(2),
            QUERYTYPE_NOT_SET(0);
            
            private final int value;

            private QueryTypeCase(int value2) {
                this.value = value2;
            }

            @Deprecated
            public static QueryTypeCase valueOf(int value2) {
                return forNumber(value2);
            }

            public static QueryTypeCase forNumber(int value2) {
                if (value2 == 0) {
                    return QUERYTYPE_NOT_SET;
                }
                if (value2 != 2) {
                    return null;
                }
                return STRUCTURED_QUERY;
            }

            public int getNumber() {
                return this.value;
            }
        }

        public QueryTypeCase getQueryTypeCase() {
            return QueryTypeCase.forNumber(this.queryTypeCase_);
        }

        /* access modifiers changed from: private */
        public void clearQueryType() {
            this.queryTypeCase_ = 0;
            this.queryType_ = null;
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

        public StructuredQuery getStructuredQuery() {
            if (this.queryTypeCase_ == 2) {
                return (StructuredQuery) this.queryType_;
            }
            return StructuredQuery.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setStructuredQuery(StructuredQuery value) {
            if (value != null) {
                this.queryType_ = value;
                this.queryTypeCase_ = 2;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setStructuredQuery(StructuredQuery.Builder builderForValue) {
            this.queryType_ = builderForValue.build();
            this.queryTypeCase_ = 2;
        }

        /* access modifiers changed from: private */
        public void mergeStructuredQuery(StructuredQuery value) {
            if (this.queryTypeCase_ != 2 || this.queryType_ == StructuredQuery.getDefaultInstance()) {
                this.queryType_ = value;
            } else {
                this.queryType_ = ((StructuredQuery.Builder) StructuredQuery.newBuilder((StructuredQuery) this.queryType_).mergeFrom(value)).buildPartial();
            }
            this.queryTypeCase_ = 2;
        }

        /* access modifiers changed from: private */
        public void clearStructuredQuery() {
            if (this.queryTypeCase_ == 2) {
                this.queryTypeCase_ = 0;
                this.queryType_ = null;
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (!this.parent_.isEmpty()) {
                output.writeString(1, getParent());
            }
            if (this.queryTypeCase_ == 2) {
                output.writeMessage(2, (StructuredQuery) this.queryType_);
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
            if (this.queryTypeCase_ == 2) {
                size2 += CodedOutputStream.computeMessageSize(2, (StructuredQuery) this.queryType_);
            }
            this.memoizedSerializedSize = size2;
            return size2;
        }

        public static QueryTarget parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (QueryTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static QueryTarget parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (QueryTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static QueryTarget parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (QueryTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static QueryTarget parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (QueryTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static QueryTarget parseFrom(InputStream input) throws IOException {
            return (QueryTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static QueryTarget parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static QueryTarget parseDelimitedFrom(InputStream input) throws IOException {
            return (QueryTarget) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static QueryTarget parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryTarget) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static QueryTarget parseFrom(CodedInputStream input) throws IOException {
            return (QueryTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static QueryTarget parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(QueryTarget prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
        public static final class Builder extends GeneratedMessageLite.Builder<QueryTarget, Builder> implements QueryTargetOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(QueryTarget.DEFAULT_INSTANCE);
            }

            public QueryTypeCase getQueryTypeCase() {
                return ((QueryTarget) this.instance).getQueryTypeCase();
            }

            public Builder clearQueryType() {
                copyOnWrite();
                ((QueryTarget) this.instance).clearQueryType();
                return this;
            }

            public String getParent() {
                return ((QueryTarget) this.instance).getParent();
            }

            public ByteString getParentBytes() {
                return ((QueryTarget) this.instance).getParentBytes();
            }

            public Builder setParent(String value) {
                copyOnWrite();
                ((QueryTarget) this.instance).setParent(value);
                return this;
            }

            public Builder clearParent() {
                copyOnWrite();
                ((QueryTarget) this.instance).clearParent();
                return this;
            }

            public Builder setParentBytes(ByteString value) {
                copyOnWrite();
                ((QueryTarget) this.instance).setParentBytes(value);
                return this;
            }

            public StructuredQuery getStructuredQuery() {
                return ((QueryTarget) this.instance).getStructuredQuery();
            }

            public Builder setStructuredQuery(StructuredQuery value) {
                copyOnWrite();
                ((QueryTarget) this.instance).setStructuredQuery(value);
                return this;
            }

            public Builder setStructuredQuery(StructuredQuery.Builder builderForValue) {
                copyOnWrite();
                ((QueryTarget) this.instance).setStructuredQuery(builderForValue);
                return this;
            }

            public Builder mergeStructuredQuery(StructuredQuery value) {
                copyOnWrite();
                ((QueryTarget) this.instance).mergeStructuredQuery(value);
                return this;
            }

            public Builder clearStructuredQuery() {
                copyOnWrite();
                ((QueryTarget) this.instance).clearStructuredQuery();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            int i;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new QueryTarget();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    QueryTarget other = (QueryTarget) arg1;
                    boolean z = true;
                    this.parent_ = visitor.visitString(!this.parent_.isEmpty(), this.parent_, !other.parent_.isEmpty(), other.parent_);
                    int i2 = AnonymousClass1.$SwitchMap$com$google$firestore$v1$Target$QueryTarget$QueryTypeCase[other.getQueryTypeCase().ordinal()];
                    if (i2 == 1) {
                        if (this.queryTypeCase_ != 2) {
                            z = false;
                        }
                        this.queryType_ = visitor.visitOneofMessage(z, this.queryType_, other.queryType_);
                    } else if (i2 == 2) {
                        if (this.queryTypeCase_ == 0) {
                            z = false;
                        }
                        visitor.visitOneofNotSet(z);
                    }
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE && (i = other.queryTypeCase_) != 0) {
                        this.queryTypeCase_ = i;
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
                                this.parent_ = input.readStringRequireUtf8();
                            } else if (tag == 18) {
                                StructuredQuery.Builder subBuilder = null;
                                if (this.queryTypeCase_ == 2) {
                                    subBuilder = (StructuredQuery.Builder) ((StructuredQuery) this.queryType_).toBuilder();
                                }
                                MessageLite readMessage = input.readMessage(StructuredQuery.parser(), extensionRegistry);
                                this.queryType_ = readMessage;
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom((StructuredQuery) readMessage);
                                    this.queryType_ = subBuilder.buildPartial();
                                }
                                this.queryTypeCase_ = 2;
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
                        synchronized (QueryTarget.class) {
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
            QueryTarget queryTarget = new QueryTarget();
            DEFAULT_INSTANCE = queryTarget;
            queryTarget.makeImmutable();
        }

        public static QueryTarget getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<QueryTarget> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public enum TargetTypeCase implements Internal.EnumLite {
        QUERY(2),
        DOCUMENTS(3),
        TARGETTYPE_NOT_SET(0);
        
        private final int value;

        private TargetTypeCase(int value2) {
            this.value = value2;
        }

        @Deprecated
        public static TargetTypeCase valueOf(int value2) {
            return forNumber(value2);
        }

        public static TargetTypeCase forNumber(int value2) {
            if (value2 == 0) {
                return TARGETTYPE_NOT_SET;
            }
            if (value2 == 2) {
                return QUERY;
            }
            if (value2 != 3) {
                return null;
            }
            return DOCUMENTS;
        }

        public int getNumber() {
            return this.value;
        }
    }

    public TargetTypeCase getTargetTypeCase() {
        return TargetTypeCase.forNumber(this.targetTypeCase_);
    }

    /* access modifiers changed from: private */
    public void clearTargetType() {
        this.targetTypeCase_ = 0;
        this.targetType_ = null;
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public enum ResumeTypeCase implements Internal.EnumLite {
        RESUME_TOKEN(4),
        READ_TIME(11),
        RESUMETYPE_NOT_SET(0);
        
        private final int value;

        private ResumeTypeCase(int value2) {
            this.value = value2;
        }

        @Deprecated
        public static ResumeTypeCase valueOf(int value2) {
            return forNumber(value2);
        }

        public static ResumeTypeCase forNumber(int value2) {
            if (value2 == 0) {
                return RESUMETYPE_NOT_SET;
            }
            if (value2 == 4) {
                return RESUME_TOKEN;
            }
            if (value2 != 11) {
                return null;
            }
            return READ_TIME;
        }

        public int getNumber() {
            return this.value;
        }
    }

    public ResumeTypeCase getResumeTypeCase() {
        return ResumeTypeCase.forNumber(this.resumeTypeCase_);
    }

    /* access modifiers changed from: private */
    public void clearResumeType() {
        this.resumeTypeCase_ = 0;
        this.resumeType_ = null;
    }

    public QueryTarget getQuery() {
        if (this.targetTypeCase_ == 2) {
            return (QueryTarget) this.targetType_;
        }
        return QueryTarget.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setQuery(QueryTarget value) {
        if (value != null) {
            this.targetType_ = value;
            this.targetTypeCase_ = 2;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setQuery(QueryTarget.Builder builderForValue) {
        this.targetType_ = builderForValue.build();
        this.targetTypeCase_ = 2;
    }

    /* access modifiers changed from: private */
    public void mergeQuery(QueryTarget value) {
        if (this.targetTypeCase_ != 2 || this.targetType_ == QueryTarget.getDefaultInstance()) {
            this.targetType_ = value;
        } else {
            this.targetType_ = ((QueryTarget.Builder) QueryTarget.newBuilder((QueryTarget) this.targetType_).mergeFrom(value)).buildPartial();
        }
        this.targetTypeCase_ = 2;
    }

    /* access modifiers changed from: private */
    public void clearQuery() {
        if (this.targetTypeCase_ == 2) {
            this.targetTypeCase_ = 0;
            this.targetType_ = null;
        }
    }

    public DocumentsTarget getDocuments() {
        if (this.targetTypeCase_ == 3) {
            return (DocumentsTarget) this.targetType_;
        }
        return DocumentsTarget.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setDocuments(DocumentsTarget value) {
        if (value != null) {
            this.targetType_ = value;
            this.targetTypeCase_ = 3;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setDocuments(DocumentsTarget.Builder builderForValue) {
        this.targetType_ = builderForValue.build();
        this.targetTypeCase_ = 3;
    }

    /* access modifiers changed from: private */
    public void mergeDocuments(DocumentsTarget value) {
        if (this.targetTypeCase_ != 3 || this.targetType_ == DocumentsTarget.getDefaultInstance()) {
            this.targetType_ = value;
        } else {
            this.targetType_ = ((DocumentsTarget.Builder) DocumentsTarget.newBuilder((DocumentsTarget) this.targetType_).mergeFrom(value)).buildPartial();
        }
        this.targetTypeCase_ = 3;
    }

    /* access modifiers changed from: private */
    public void clearDocuments() {
        if (this.targetTypeCase_ == 3) {
            this.targetTypeCase_ = 0;
            this.targetType_ = null;
        }
    }

    public ByteString getResumeToken() {
        if (this.resumeTypeCase_ == 4) {
            return (ByteString) this.resumeType_;
        }
        return ByteString.EMPTY;
    }

    /* access modifiers changed from: private */
    public void setResumeToken(ByteString value) {
        if (value != null) {
            this.resumeTypeCase_ = 4;
            this.resumeType_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearResumeToken() {
        if (this.resumeTypeCase_ == 4) {
            this.resumeTypeCase_ = 0;
            this.resumeType_ = null;
        }
    }

    public Timestamp getReadTime() {
        if (this.resumeTypeCase_ == 11) {
            return (Timestamp) this.resumeType_;
        }
        return Timestamp.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setReadTime(Timestamp value) {
        if (value != null) {
            this.resumeType_ = value;
            this.resumeTypeCase_ = 11;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setReadTime(Timestamp.Builder builderForValue) {
        this.resumeType_ = builderForValue.build();
        this.resumeTypeCase_ = 11;
    }

    /* access modifiers changed from: private */
    public void mergeReadTime(Timestamp value) {
        if (this.resumeTypeCase_ != 11 || this.resumeType_ == Timestamp.getDefaultInstance()) {
            this.resumeType_ = value;
        } else {
            this.resumeType_ = ((Timestamp.Builder) Timestamp.newBuilder((Timestamp) this.resumeType_).mergeFrom(value)).buildPartial();
        }
        this.resumeTypeCase_ = 11;
    }

    /* access modifiers changed from: private */
    public void clearReadTime() {
        if (this.resumeTypeCase_ == 11) {
            this.resumeTypeCase_ = 0;
            this.resumeType_ = null;
        }
    }

    public int getTargetId() {
        return this.targetId_;
    }

    /* access modifiers changed from: private */
    public void setTargetId(int value) {
        this.targetId_ = value;
    }

    /* access modifiers changed from: private */
    public void clearTargetId() {
        this.targetId_ = 0;
    }

    public boolean getOnce() {
        return this.once_;
    }

    /* access modifiers changed from: private */
    public void setOnce(boolean value) {
        this.once_ = value;
    }

    /* access modifiers changed from: private */
    public void clearOnce() {
        this.once_ = false;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (this.targetTypeCase_ == 2) {
            output.writeMessage(2, (QueryTarget) this.targetType_);
        }
        if (this.targetTypeCase_ == 3) {
            output.writeMessage(3, (DocumentsTarget) this.targetType_);
        }
        if (this.resumeTypeCase_ == 4) {
            output.writeBytes(4, (ByteString) this.resumeType_);
        }
        int i = this.targetId_;
        if (i != 0) {
            output.writeInt32(5, i);
        }
        boolean z = this.once_;
        if (z) {
            output.writeBool(6, z);
        }
        if (this.resumeTypeCase_ == 11) {
            output.writeMessage(11, (Timestamp) this.resumeType_);
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (this.targetTypeCase_ == 2) {
            size2 = 0 + CodedOutputStream.computeMessageSize(2, (QueryTarget) this.targetType_);
        }
        if (this.targetTypeCase_ == 3) {
            size2 += CodedOutputStream.computeMessageSize(3, (DocumentsTarget) this.targetType_);
        }
        if (this.resumeTypeCase_ == 4) {
            size2 += CodedOutputStream.computeBytesSize(4, (ByteString) this.resumeType_);
        }
        int i = this.targetId_;
        if (i != 0) {
            size2 += CodedOutputStream.computeInt32Size(5, i);
        }
        boolean z = this.once_;
        if (z) {
            size2 += CodedOutputStream.computeBoolSize(6, z);
        }
        if (this.resumeTypeCase_ == 11) {
            size2 += CodedOutputStream.computeMessageSize(11, (Timestamp) this.resumeType_);
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Target parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Target) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Target parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Target) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Target parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Target) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Target parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Target) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Target parseFrom(InputStream input) throws IOException {
        return (Target) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Target parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Target) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Target parseDelimitedFrom(InputStream input) throws IOException {
        return (Target) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Target parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Target) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Target parseFrom(CodedInputStream input) throws IOException {
        return (Target) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Target parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Target) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Target prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<Target, Builder> implements TargetOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Target.DEFAULT_INSTANCE);
        }

        public TargetTypeCase getTargetTypeCase() {
            return ((Target) this.instance).getTargetTypeCase();
        }

        public Builder clearTargetType() {
            copyOnWrite();
            ((Target) this.instance).clearTargetType();
            return this;
        }

        public ResumeTypeCase getResumeTypeCase() {
            return ((Target) this.instance).getResumeTypeCase();
        }

        public Builder clearResumeType() {
            copyOnWrite();
            ((Target) this.instance).clearResumeType();
            return this;
        }

        public QueryTarget getQuery() {
            return ((Target) this.instance).getQuery();
        }

        public Builder setQuery(QueryTarget value) {
            copyOnWrite();
            ((Target) this.instance).setQuery(value);
            return this;
        }

        public Builder setQuery(QueryTarget.Builder builderForValue) {
            copyOnWrite();
            ((Target) this.instance).setQuery(builderForValue);
            return this;
        }

        public Builder mergeQuery(QueryTarget value) {
            copyOnWrite();
            ((Target) this.instance).mergeQuery(value);
            return this;
        }

        public Builder clearQuery() {
            copyOnWrite();
            ((Target) this.instance).clearQuery();
            return this;
        }

        public DocumentsTarget getDocuments() {
            return ((Target) this.instance).getDocuments();
        }

        public Builder setDocuments(DocumentsTarget value) {
            copyOnWrite();
            ((Target) this.instance).setDocuments(value);
            return this;
        }

        public Builder setDocuments(DocumentsTarget.Builder builderForValue) {
            copyOnWrite();
            ((Target) this.instance).setDocuments(builderForValue);
            return this;
        }

        public Builder mergeDocuments(DocumentsTarget value) {
            copyOnWrite();
            ((Target) this.instance).mergeDocuments(value);
            return this;
        }

        public Builder clearDocuments() {
            copyOnWrite();
            ((Target) this.instance).clearDocuments();
            return this;
        }

        public ByteString getResumeToken() {
            return ((Target) this.instance).getResumeToken();
        }

        public Builder setResumeToken(ByteString value) {
            copyOnWrite();
            ((Target) this.instance).setResumeToken(value);
            return this;
        }

        public Builder clearResumeToken() {
            copyOnWrite();
            ((Target) this.instance).clearResumeToken();
            return this;
        }

        public Timestamp getReadTime() {
            return ((Target) this.instance).getReadTime();
        }

        public Builder setReadTime(Timestamp value) {
            copyOnWrite();
            ((Target) this.instance).setReadTime(value);
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builderForValue) {
            copyOnWrite();
            ((Target) this.instance).setReadTime(builderForValue);
            return this;
        }

        public Builder mergeReadTime(Timestamp value) {
            copyOnWrite();
            ((Target) this.instance).mergeReadTime(value);
            return this;
        }

        public Builder clearReadTime() {
            copyOnWrite();
            ((Target) this.instance).clearReadTime();
            return this;
        }

        public int getTargetId() {
            return ((Target) this.instance).getTargetId();
        }

        public Builder setTargetId(int value) {
            copyOnWrite();
            ((Target) this.instance).setTargetId(value);
            return this;
        }

        public Builder clearTargetId() {
            copyOnWrite();
            ((Target) this.instance).clearTargetId();
            return this;
        }

        public boolean getOnce() {
            return ((Target) this.instance).getOnce();
        }

        public Builder setOnce(boolean value) {
            copyOnWrite();
            ((Target) this.instance).setOnce(value);
            return this;
        }

        public Builder clearOnce() {
            copyOnWrite();
            ((Target) this.instance).clearOnce();
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
            case 1:
                return new Target();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                Target other = (Target) arg1;
                boolean z = false;
                this.targetId_ = visitor.visitInt(this.targetId_ != 0, this.targetId_, other.targetId_ != 0, other.targetId_);
                boolean z2 = this.once_;
                boolean z3 = other.once_;
                this.once_ = visitor.visitBoolean(z2, z2, z3, z3);
                int i = AnonymousClass1.$SwitchMap$com$google$firestore$v1$Target$TargetTypeCase[other.getTargetTypeCase().ordinal()];
                if (i == 1) {
                    this.targetType_ = visitor.visitOneofMessage(this.targetTypeCase_ == 2, this.targetType_, other.targetType_);
                } else if (i == 2) {
                    this.targetType_ = visitor.visitOneofMessage(this.targetTypeCase_ == 3, this.targetType_, other.targetType_);
                } else if (i == 3) {
                    visitor.visitOneofNotSet(this.targetTypeCase_ != 0);
                }
                int i2 = AnonymousClass1.$SwitchMap$com$google$firestore$v1$Target$ResumeTypeCase[other.getResumeTypeCase().ordinal()];
                if (i2 == 1) {
                    if (this.resumeTypeCase_ == 4) {
                        z = true;
                    }
                    this.resumeType_ = visitor.visitOneofByteString(z, this.resumeType_, other.resumeType_);
                } else if (i2 == 2) {
                    if (this.resumeTypeCase_ == 11) {
                        z = true;
                    }
                    this.resumeType_ = visitor.visitOneofMessage(z, this.resumeType_, other.resumeType_);
                } else if (i2 == 3) {
                    if (this.resumeTypeCase_ != 0) {
                        z = true;
                    }
                    visitor.visitOneofNotSet(z);
                }
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    int i3 = other.targetTypeCase_;
                    if (i3 != 0) {
                        this.targetTypeCase_ = i3;
                    }
                    int i4 = other.resumeTypeCase_;
                    if (i4 != 0) {
                        this.resumeTypeCase_ = i4;
                    }
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
                        } else if (tag == 18) {
                            QueryTarget.Builder subBuilder = null;
                            if (this.targetTypeCase_ == 2) {
                                subBuilder = (QueryTarget.Builder) ((QueryTarget) this.targetType_).toBuilder();
                            }
                            MessageLite readMessage = input.readMessage(QueryTarget.parser(), extensionRegistry);
                            this.targetType_ = readMessage;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom((QueryTarget) readMessage);
                                this.targetType_ = subBuilder.buildPartial();
                            }
                            this.targetTypeCase_ = 2;
                        } else if (tag == 26) {
                            DocumentsTarget.Builder subBuilder2 = null;
                            if (this.targetTypeCase_ == 3) {
                                subBuilder2 = (DocumentsTarget.Builder) ((DocumentsTarget) this.targetType_).toBuilder();
                            }
                            MessageLite readMessage2 = input.readMessage(DocumentsTarget.parser(), extensionRegistry);
                            this.targetType_ = readMessage2;
                            if (subBuilder2 != null) {
                                subBuilder2.mergeFrom((DocumentsTarget) readMessage2);
                                this.targetType_ = subBuilder2.buildPartial();
                            }
                            this.targetTypeCase_ = 3;
                        } else if (tag == 34) {
                            this.resumeTypeCase_ = 4;
                            this.resumeType_ = input.readBytes();
                        } else if (tag == 40) {
                            this.targetId_ = input.readInt32();
                        } else if (tag == 48) {
                            this.once_ = input.readBool();
                        } else if (tag == 90) {
                            Timestamp.Builder subBuilder3 = null;
                            if (this.resumeTypeCase_ == 11) {
                                subBuilder3 = (Timestamp.Builder) ((Timestamp) this.resumeType_).toBuilder();
                            }
                            MessageLite readMessage3 = input.readMessage(Timestamp.parser(), extensionRegistry);
                            this.resumeType_ = readMessage3;
                            if (subBuilder3 != null) {
                                subBuilder3.mergeFrom((Timestamp) readMessage3);
                                this.resumeType_ = subBuilder3.buildPartial();
                            }
                            this.resumeTypeCase_ = 11;
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
                    synchronized (Target.class) {
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

    /* renamed from: com.google.firestore.v1.Target$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$Target$QueryTarget$QueryTypeCase;
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$Target$ResumeTypeCase;
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$Target$TargetTypeCase;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[ResumeTypeCase.values().length];
            $SwitchMap$com$google$firestore$v1$Target$ResumeTypeCase = iArr;
            try {
                iArr[ResumeTypeCase.RESUME_TOKEN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Target$ResumeTypeCase[ResumeTypeCase.READ_TIME.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Target$ResumeTypeCase[ResumeTypeCase.RESUMETYPE_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            int[] iArr2 = new int[TargetTypeCase.values().length];
            $SwitchMap$com$google$firestore$v1$Target$TargetTypeCase = iArr2;
            try {
                iArr2[TargetTypeCase.QUERY.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Target$TargetTypeCase[TargetTypeCase.DOCUMENTS.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Target$TargetTypeCase[TargetTypeCase.TARGETTYPE_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            int[] iArr3 = new int[QueryTarget.QueryTypeCase.values().length];
            $SwitchMap$com$google$firestore$v1$Target$QueryTarget$QueryTypeCase = iArr3;
            try {
                iArr3[QueryTarget.QueryTypeCase.STRUCTURED_QUERY.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Target$QueryTarget$QueryTypeCase[QueryTarget.QueryTypeCase.QUERYTYPE_NOT_SET.ordinal()] = 2;
            } catch (NoSuchFieldError e8) {
            }
            int[] iArr4 = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr4;
            try {
                iArr4[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.VISIT.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM.ordinal()] = 6;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 7;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 8;
            } catch (NoSuchFieldError e16) {
            }
        }
    }

    static {
        Target target = new Target();
        DEFAULT_INSTANCE = target;
        target.makeImmutable();
    }

    public static Target getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Target> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
