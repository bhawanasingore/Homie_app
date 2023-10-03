package com.google.firestore.v1;

import com.google.firestore.v1.Cursor;
import com.google.firestore.v1.Value;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public final class StructuredQuery extends GeneratedMessageLite<StructuredQuery, Builder> implements StructuredQueryOrBuilder {
    /* access modifiers changed from: private */
    public static final StructuredQuery DEFAULT_INSTANCE;
    public static final int END_AT_FIELD_NUMBER = 8;
    public static final int FROM_FIELD_NUMBER = 2;
    public static final int LIMIT_FIELD_NUMBER = 5;
    public static final int OFFSET_FIELD_NUMBER = 6;
    public static final int ORDER_BY_FIELD_NUMBER = 4;
    private static volatile Parser<StructuredQuery> PARSER = null;
    public static final int SELECT_FIELD_NUMBER = 1;
    public static final int START_AT_FIELD_NUMBER = 7;
    public static final int WHERE_FIELD_NUMBER = 3;
    private int bitField0_;
    private Cursor endAt_;
    private Internal.ProtobufList<CollectionSelector> from_ = emptyProtobufList();
    private Int32Value limit_;
    private int offset_;
    private Internal.ProtobufList<Order> orderBy_ = emptyProtobufList();
    private Projection select_;
    private Cursor startAt_;
    private Filter where_;

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public interface CollectionSelectorOrBuilder extends MessageLiteOrBuilder {
        boolean getAllDescendants();

        String getCollectionId();

        ByteString getCollectionIdBytes();
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public interface CompositeFilterOrBuilder extends MessageLiteOrBuilder {
        Filter getFilters(int i);

        int getFiltersCount();

        List<Filter> getFiltersList();

        CompositeFilter.Operator getOp();

        int getOpValue();
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public interface FieldFilterOrBuilder extends MessageLiteOrBuilder {
        FieldReference getField();

        FieldFilter.Operator getOp();

        int getOpValue();

        Value getValue();

        boolean hasField();

        boolean hasValue();
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public interface FieldReferenceOrBuilder extends MessageLiteOrBuilder {
        String getFieldPath();

        ByteString getFieldPathBytes();
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public interface FilterOrBuilder extends MessageLiteOrBuilder {
        CompositeFilter getCompositeFilter();

        FieldFilter getFieldFilter();

        Filter.FilterTypeCase getFilterTypeCase();

        UnaryFilter getUnaryFilter();
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public interface OrderOrBuilder extends MessageLiteOrBuilder {
        Direction getDirection();

        int getDirectionValue();

        FieldReference getField();

        boolean hasField();
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public interface ProjectionOrBuilder extends MessageLiteOrBuilder {
        FieldReference getFields(int i);

        int getFieldsCount();

        List<FieldReference> getFieldsList();
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public interface UnaryFilterOrBuilder extends MessageLiteOrBuilder {
        FieldReference getField();

        UnaryFilter.Operator getOp();

        int getOpValue();

        UnaryFilter.OperandTypeCase getOperandTypeCase();
    }

    private StructuredQuery() {
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public enum Direction implements Internal.EnumLite {
        DIRECTION_UNSPECIFIED(0),
        ASCENDING(1),
        DESCENDING(2),
        UNRECOGNIZED(-1);
        
        public static final int ASCENDING_VALUE = 1;
        public static final int DESCENDING_VALUE = 2;
        public static final int DIRECTION_UNSPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<Direction> internalValueMap = null;
        private final int value;

        static {
            internalValueMap = new Internal.EnumLiteMap<Direction>() {
                public Direction findValueByNumber(int number) {
                    return Direction.forNumber(number);
                }
            };
        }

        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static Direction valueOf(int value2) {
            return forNumber(value2);
        }

        public static Direction forNumber(int value2) {
            if (value2 == 0) {
                return DIRECTION_UNSPECIFIED;
            }
            if (value2 == 1) {
                return ASCENDING;
            }
            if (value2 != 2) {
                return null;
            }
            return DESCENDING;
        }

        public static Internal.EnumLiteMap<Direction> internalGetValueMap() {
            return internalValueMap;
        }

        private Direction(int value2) {
            this.value = value2;
        }
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class CollectionSelector extends GeneratedMessageLite<CollectionSelector, Builder> implements CollectionSelectorOrBuilder {
        public static final int ALL_DESCENDANTS_FIELD_NUMBER = 3;
        public static final int COLLECTION_ID_FIELD_NUMBER = 2;
        /* access modifiers changed from: private */
        public static final CollectionSelector DEFAULT_INSTANCE;
        private static volatile Parser<CollectionSelector> PARSER;
        private boolean allDescendants_;
        private String collectionId_ = "";

        private CollectionSelector() {
        }

        public String getCollectionId() {
            return this.collectionId_;
        }

        public ByteString getCollectionIdBytes() {
            return ByteString.copyFromUtf8(this.collectionId_);
        }

        /* access modifiers changed from: private */
        public void setCollectionId(String value) {
            if (value != null) {
                this.collectionId_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearCollectionId() {
            this.collectionId_ = getDefaultInstance().getCollectionId();
        }

        /* access modifiers changed from: private */
        public void setCollectionIdBytes(ByteString value) {
            if (value != null) {
                checkByteStringIsUtf8(value);
                this.collectionId_ = value.toStringUtf8();
                return;
            }
            throw null;
        }

        public boolean getAllDescendants() {
            return this.allDescendants_;
        }

        /* access modifiers changed from: private */
        public void setAllDescendants(boolean value) {
            this.allDescendants_ = value;
        }

        /* access modifiers changed from: private */
        public void clearAllDescendants() {
            this.allDescendants_ = false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (!this.collectionId_.isEmpty()) {
                output.writeString(2, getCollectionId());
            }
            boolean z = this.allDescendants_;
            if (z) {
                output.writeBool(3, z);
            }
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (!this.collectionId_.isEmpty()) {
                size2 = 0 + CodedOutputStream.computeStringSize(2, getCollectionId());
            }
            boolean z = this.allDescendants_;
            if (z) {
                size2 += CodedOutputStream.computeBoolSize(3, z);
            }
            this.memoizedSerializedSize = size2;
            return size2;
        }

        public static CollectionSelector parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (CollectionSelector) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static CollectionSelector parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CollectionSelector) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static CollectionSelector parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (CollectionSelector) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static CollectionSelector parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CollectionSelector) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static CollectionSelector parseFrom(InputStream input) throws IOException {
            return (CollectionSelector) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static CollectionSelector parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CollectionSelector) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static CollectionSelector parseDelimitedFrom(InputStream input) throws IOException {
            return (CollectionSelector) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static CollectionSelector parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CollectionSelector) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static CollectionSelector parseFrom(CodedInputStream input) throws IOException {
            return (CollectionSelector) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static CollectionSelector parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CollectionSelector) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CollectionSelector prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
        public static final class Builder extends GeneratedMessageLite.Builder<CollectionSelector, Builder> implements CollectionSelectorOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(CollectionSelector.DEFAULT_INSTANCE);
            }

            public String getCollectionId() {
                return ((CollectionSelector) this.instance).getCollectionId();
            }

            public ByteString getCollectionIdBytes() {
                return ((CollectionSelector) this.instance).getCollectionIdBytes();
            }

            public Builder setCollectionId(String value) {
                copyOnWrite();
                ((CollectionSelector) this.instance).setCollectionId(value);
                return this;
            }

            public Builder clearCollectionId() {
                copyOnWrite();
                ((CollectionSelector) this.instance).clearCollectionId();
                return this;
            }

            public Builder setCollectionIdBytes(ByteString value) {
                copyOnWrite();
                ((CollectionSelector) this.instance).setCollectionIdBytes(value);
                return this;
            }

            public boolean getAllDescendants() {
                return ((CollectionSelector) this.instance).getAllDescendants();
            }

            public Builder setAllDescendants(boolean value) {
                copyOnWrite();
                ((CollectionSelector) this.instance).setAllDescendants(value);
                return this;
            }

            public Builder clearAllDescendants() {
                copyOnWrite();
                ((CollectionSelector) this.instance).clearAllDescendants();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new CollectionSelector();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    CollectionSelector other = (CollectionSelector) arg1;
                    this.collectionId_ = visitor.visitString(!this.collectionId_.isEmpty(), this.collectionId_, !other.collectionId_.isEmpty(), other.collectionId_);
                    boolean z = this.allDescendants_;
                    boolean z2 = other.allDescendants_;
                    this.allDescendants_ = visitor.visitBoolean(z, z, z2, z2);
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
                                this.collectionId_ = input.readStringRequireUtf8();
                            } else if (tag == 24) {
                                this.allDescendants_ = input.readBool();
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
                        synchronized (CollectionSelector.class) {
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
            CollectionSelector collectionSelector = new CollectionSelector();
            DEFAULT_INSTANCE = collectionSelector;
            collectionSelector.makeImmutable();
        }

        public static CollectionSelector getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CollectionSelector> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Filter extends GeneratedMessageLite<Filter, Builder> implements FilterOrBuilder {
        public static final int COMPOSITE_FILTER_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final Filter DEFAULT_INSTANCE;
        public static final int FIELD_FILTER_FIELD_NUMBER = 2;
        private static volatile Parser<Filter> PARSER = null;
        public static final int UNARY_FILTER_FIELD_NUMBER = 3;
        private int filterTypeCase_ = 0;
        private Object filterType_;

        private Filter() {
        }

        /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
        public enum FilterTypeCase implements Internal.EnumLite {
            COMPOSITE_FILTER(1),
            FIELD_FILTER(2),
            UNARY_FILTER(3),
            FILTERTYPE_NOT_SET(0);
            
            private final int value;

            private FilterTypeCase(int value2) {
                this.value = value2;
            }

            @Deprecated
            public static FilterTypeCase valueOf(int value2) {
                return forNumber(value2);
            }

            public static FilterTypeCase forNumber(int value2) {
                if (value2 == 0) {
                    return FILTERTYPE_NOT_SET;
                }
                if (value2 == 1) {
                    return COMPOSITE_FILTER;
                }
                if (value2 == 2) {
                    return FIELD_FILTER;
                }
                if (value2 != 3) {
                    return null;
                }
                return UNARY_FILTER;
            }

            public int getNumber() {
                return this.value;
            }
        }

        public FilterTypeCase getFilterTypeCase() {
            return FilterTypeCase.forNumber(this.filterTypeCase_);
        }

        /* access modifiers changed from: private */
        public void clearFilterType() {
            this.filterTypeCase_ = 0;
            this.filterType_ = null;
        }

        public CompositeFilter getCompositeFilter() {
            if (this.filterTypeCase_ == 1) {
                return (CompositeFilter) this.filterType_;
            }
            return CompositeFilter.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setCompositeFilter(CompositeFilter value) {
            if (value != null) {
                this.filterType_ = value;
                this.filterTypeCase_ = 1;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setCompositeFilter(CompositeFilter.Builder builderForValue) {
            this.filterType_ = builderForValue.build();
            this.filterTypeCase_ = 1;
        }

        /* access modifiers changed from: private */
        public void mergeCompositeFilter(CompositeFilter value) {
            if (this.filterTypeCase_ != 1 || this.filterType_ == CompositeFilter.getDefaultInstance()) {
                this.filterType_ = value;
            } else {
                this.filterType_ = ((CompositeFilter.Builder) CompositeFilter.newBuilder((CompositeFilter) this.filterType_).mergeFrom(value)).buildPartial();
            }
            this.filterTypeCase_ = 1;
        }

        /* access modifiers changed from: private */
        public void clearCompositeFilter() {
            if (this.filterTypeCase_ == 1) {
                this.filterTypeCase_ = 0;
                this.filterType_ = null;
            }
        }

        public FieldFilter getFieldFilter() {
            if (this.filterTypeCase_ == 2) {
                return (FieldFilter) this.filterType_;
            }
            return FieldFilter.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setFieldFilter(FieldFilter value) {
            if (value != null) {
                this.filterType_ = value;
                this.filterTypeCase_ = 2;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setFieldFilter(FieldFilter.Builder builderForValue) {
            this.filterType_ = builderForValue.build();
            this.filterTypeCase_ = 2;
        }

        /* access modifiers changed from: private */
        public void mergeFieldFilter(FieldFilter value) {
            if (this.filterTypeCase_ != 2 || this.filterType_ == FieldFilter.getDefaultInstance()) {
                this.filterType_ = value;
            } else {
                this.filterType_ = ((FieldFilter.Builder) FieldFilter.newBuilder((FieldFilter) this.filterType_).mergeFrom(value)).buildPartial();
            }
            this.filterTypeCase_ = 2;
        }

        /* access modifiers changed from: private */
        public void clearFieldFilter() {
            if (this.filterTypeCase_ == 2) {
                this.filterTypeCase_ = 0;
                this.filterType_ = null;
            }
        }

        public UnaryFilter getUnaryFilter() {
            if (this.filterTypeCase_ == 3) {
                return (UnaryFilter) this.filterType_;
            }
            return UnaryFilter.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setUnaryFilter(UnaryFilter value) {
            if (value != null) {
                this.filterType_ = value;
                this.filterTypeCase_ = 3;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setUnaryFilter(UnaryFilter.Builder builderForValue) {
            this.filterType_ = builderForValue.build();
            this.filterTypeCase_ = 3;
        }

        /* access modifiers changed from: private */
        public void mergeUnaryFilter(UnaryFilter value) {
            if (this.filterTypeCase_ != 3 || this.filterType_ == UnaryFilter.getDefaultInstance()) {
                this.filterType_ = value;
            } else {
                this.filterType_ = ((UnaryFilter.Builder) UnaryFilter.newBuilder((UnaryFilter) this.filterType_).mergeFrom(value)).buildPartial();
            }
            this.filterTypeCase_ = 3;
        }

        /* access modifiers changed from: private */
        public void clearUnaryFilter() {
            if (this.filterTypeCase_ == 3) {
                this.filterTypeCase_ = 0;
                this.filterType_ = null;
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (this.filterTypeCase_ == 1) {
                output.writeMessage(1, (CompositeFilter) this.filterType_);
            }
            if (this.filterTypeCase_ == 2) {
                output.writeMessage(2, (FieldFilter) this.filterType_);
            }
            if (this.filterTypeCase_ == 3) {
                output.writeMessage(3, (UnaryFilter) this.filterType_);
            }
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (this.filterTypeCase_ == 1) {
                size2 = 0 + CodedOutputStream.computeMessageSize(1, (CompositeFilter) this.filterType_);
            }
            if (this.filterTypeCase_ == 2) {
                size2 += CodedOutputStream.computeMessageSize(2, (FieldFilter) this.filterType_);
            }
            if (this.filterTypeCase_ == 3) {
                size2 += CodedOutputStream.computeMessageSize(3, (UnaryFilter) this.filterType_);
            }
            this.memoizedSerializedSize = size2;
            return size2;
        }

        public static Filter parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Filter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Filter parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Filter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Filter parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Filter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Filter parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Filter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Filter parseFrom(InputStream input) throws IOException {
            return (Filter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Filter parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Filter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Filter parseDelimitedFrom(InputStream input) throws IOException {
            return (Filter) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static Filter parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Filter) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Filter parseFrom(CodedInputStream input) throws IOException {
            return (Filter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Filter parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Filter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Filter prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
        public static final class Builder extends GeneratedMessageLite.Builder<Filter, Builder> implements FilterOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(Filter.DEFAULT_INSTANCE);
            }

            public FilterTypeCase getFilterTypeCase() {
                return ((Filter) this.instance).getFilterTypeCase();
            }

            public Builder clearFilterType() {
                copyOnWrite();
                ((Filter) this.instance).clearFilterType();
                return this;
            }

            public CompositeFilter getCompositeFilter() {
                return ((Filter) this.instance).getCompositeFilter();
            }

            public Builder setCompositeFilter(CompositeFilter value) {
                copyOnWrite();
                ((Filter) this.instance).setCompositeFilter(value);
                return this;
            }

            public Builder setCompositeFilter(CompositeFilter.Builder builderForValue) {
                copyOnWrite();
                ((Filter) this.instance).setCompositeFilter(builderForValue);
                return this;
            }

            public Builder mergeCompositeFilter(CompositeFilter value) {
                copyOnWrite();
                ((Filter) this.instance).mergeCompositeFilter(value);
                return this;
            }

            public Builder clearCompositeFilter() {
                copyOnWrite();
                ((Filter) this.instance).clearCompositeFilter();
                return this;
            }

            public FieldFilter getFieldFilter() {
                return ((Filter) this.instance).getFieldFilter();
            }

            public Builder setFieldFilter(FieldFilter value) {
                copyOnWrite();
                ((Filter) this.instance).setFieldFilter(value);
                return this;
            }

            public Builder setFieldFilter(FieldFilter.Builder builderForValue) {
                copyOnWrite();
                ((Filter) this.instance).setFieldFilter(builderForValue);
                return this;
            }

            public Builder mergeFieldFilter(FieldFilter value) {
                copyOnWrite();
                ((Filter) this.instance).mergeFieldFilter(value);
                return this;
            }

            public Builder clearFieldFilter() {
                copyOnWrite();
                ((Filter) this.instance).clearFieldFilter();
                return this;
            }

            public UnaryFilter getUnaryFilter() {
                return ((Filter) this.instance).getUnaryFilter();
            }

            public Builder setUnaryFilter(UnaryFilter value) {
                copyOnWrite();
                ((Filter) this.instance).setUnaryFilter(value);
                return this;
            }

            public Builder setUnaryFilter(UnaryFilter.Builder builderForValue) {
                copyOnWrite();
                ((Filter) this.instance).setUnaryFilter(builderForValue);
                return this;
            }

            public Builder mergeUnaryFilter(UnaryFilter value) {
                copyOnWrite();
                ((Filter) this.instance).mergeUnaryFilter(value);
                return this;
            }

            public Builder clearUnaryFilter() {
                copyOnWrite();
                ((Filter) this.instance).clearUnaryFilter();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            int i;
            boolean z = true;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new Filter();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    Filter other = (Filter) arg1;
                    int i2 = AnonymousClass1.$SwitchMap$com$google$firestore$v1$StructuredQuery$Filter$FilterTypeCase[other.getFilterTypeCase().ordinal()];
                    if (i2 == 1) {
                        if (this.filterTypeCase_ != 1) {
                            z = false;
                        }
                        this.filterType_ = visitor.visitOneofMessage(z, this.filterType_, other.filterType_);
                    } else if (i2 == 2) {
                        if (this.filterTypeCase_ != 2) {
                            z = false;
                        }
                        this.filterType_ = visitor.visitOneofMessage(z, this.filterType_, other.filterType_);
                    } else if (i2 == 3) {
                        if (this.filterTypeCase_ != 3) {
                            z = false;
                        }
                        this.filterType_ = visitor.visitOneofMessage(z, this.filterType_, other.filterType_);
                    } else if (i2 == 4) {
                        if (this.filterTypeCase_ == 0) {
                            z = false;
                        }
                        visitor.visitOneofNotSet(z);
                    }
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE && (i = other.filterTypeCase_) != 0) {
                        this.filterTypeCase_ = i;
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
                                CompositeFilter.Builder subBuilder = null;
                                if (this.filterTypeCase_ == 1) {
                                    subBuilder = (CompositeFilter.Builder) ((CompositeFilter) this.filterType_).toBuilder();
                                }
                                MessageLite readMessage = input.readMessage(CompositeFilter.parser(), extensionRegistry);
                                this.filterType_ = readMessage;
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom((CompositeFilter) readMessage);
                                    this.filterType_ = subBuilder.buildPartial();
                                }
                                this.filterTypeCase_ = 1;
                            } else if (tag == 18) {
                                FieldFilter.Builder subBuilder2 = null;
                                if (this.filterTypeCase_ == 2) {
                                    subBuilder2 = (FieldFilter.Builder) ((FieldFilter) this.filterType_).toBuilder();
                                }
                                MessageLite readMessage2 = input.readMessage(FieldFilter.parser(), extensionRegistry);
                                this.filterType_ = readMessage2;
                                if (subBuilder2 != null) {
                                    subBuilder2.mergeFrom((FieldFilter) readMessage2);
                                    this.filterType_ = subBuilder2.buildPartial();
                                }
                                this.filterTypeCase_ = 2;
                            } else if (tag == 26) {
                                UnaryFilter.Builder subBuilder3 = null;
                                if (this.filterTypeCase_ == 3) {
                                    subBuilder3 = (UnaryFilter.Builder) ((UnaryFilter) this.filterType_).toBuilder();
                                }
                                MessageLite readMessage3 = input.readMessage(UnaryFilter.parser(), extensionRegistry);
                                this.filterType_ = readMessage3;
                                if (subBuilder3 != null) {
                                    subBuilder3.mergeFrom((UnaryFilter) readMessage3);
                                    this.filterType_ = subBuilder3.buildPartial();
                                }
                                this.filterTypeCase_ = 3;
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
                        synchronized (Filter.class) {
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
            Filter filter = new Filter();
            DEFAULT_INSTANCE = filter;
            filter.makeImmutable();
        }

        public static Filter getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Filter> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class CompositeFilter extends GeneratedMessageLite<CompositeFilter, Builder> implements CompositeFilterOrBuilder {
        /* access modifiers changed from: private */
        public static final CompositeFilter DEFAULT_INSTANCE;
        public static final int FILTERS_FIELD_NUMBER = 2;
        public static final int OP_FIELD_NUMBER = 1;
        private static volatile Parser<CompositeFilter> PARSER;
        private int bitField0_;
        private Internal.ProtobufList<Filter> filters_ = emptyProtobufList();
        private int op_;

        private CompositeFilter() {
        }

        /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
        public enum Operator implements Internal.EnumLite {
            OPERATOR_UNSPECIFIED(0),
            AND(1),
            UNRECOGNIZED(-1);
            
            public static final int AND_VALUE = 1;
            public static final int OPERATOR_UNSPECIFIED_VALUE = 0;
            private static final Internal.EnumLiteMap<Operator> internalValueMap = null;
            private final int value;

            static {
                internalValueMap = new Internal.EnumLiteMap<Operator>() {
                    public Operator findValueByNumber(int number) {
                        return Operator.forNumber(number);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static Operator valueOf(int value2) {
                return forNumber(value2);
            }

            public static Operator forNumber(int value2) {
                if (value2 == 0) {
                    return OPERATOR_UNSPECIFIED;
                }
                if (value2 != 1) {
                    return null;
                }
                return AND;
            }

            public static Internal.EnumLiteMap<Operator> internalGetValueMap() {
                return internalValueMap;
            }

            private Operator(int value2) {
                this.value = value2;
            }
        }

        public int getOpValue() {
            return this.op_;
        }

        public Operator getOp() {
            Operator result = Operator.forNumber(this.op_);
            return result == null ? Operator.UNRECOGNIZED : result;
        }

        /* access modifiers changed from: private */
        public void setOpValue(int value) {
            this.op_ = value;
        }

        /* access modifiers changed from: private */
        public void setOp(Operator value) {
            if (value != null) {
                this.op_ = value.getNumber();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearOp() {
            this.op_ = 0;
        }

        public List<Filter> getFiltersList() {
            return this.filters_;
        }

        public List<? extends FilterOrBuilder> getFiltersOrBuilderList() {
            return this.filters_;
        }

        public int getFiltersCount() {
            return this.filters_.size();
        }

        public Filter getFilters(int index) {
            return (Filter) this.filters_.get(index);
        }

        public FilterOrBuilder getFiltersOrBuilder(int index) {
            return (FilterOrBuilder) this.filters_.get(index);
        }

        private void ensureFiltersIsMutable() {
            if (!this.filters_.isModifiable()) {
                this.filters_ = GeneratedMessageLite.mutableCopy(this.filters_);
            }
        }

        /* access modifiers changed from: private */
        public void setFilters(int index, Filter value) {
            if (value != null) {
                ensureFiltersIsMutable();
                this.filters_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setFilters(int index, Filter.Builder builderForValue) {
            ensureFiltersIsMutable();
            this.filters_.set(index, (Filter) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addFilters(Filter value) {
            if (value != null) {
                ensureFiltersIsMutable();
                this.filters_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addFilters(int index, Filter value) {
            if (value != null) {
                ensureFiltersIsMutable();
                this.filters_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addFilters(Filter.Builder builderForValue) {
            ensureFiltersIsMutable();
            this.filters_.add((Filter) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addFilters(int index, Filter.Builder builderForValue) {
            ensureFiltersIsMutable();
            this.filters_.add(index, (Filter) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllFilters(Iterable<? extends Filter> values) {
            ensureFiltersIsMutable();
            AbstractMessageLite.addAll(values, this.filters_);
        }

        /* access modifiers changed from: private */
        public void clearFilters() {
            this.filters_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeFilters(int index) {
            ensureFiltersIsMutable();
            this.filters_.remove(index);
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (this.op_ != Operator.OPERATOR_UNSPECIFIED.getNumber()) {
                output.writeEnum(1, this.op_);
            }
            for (int i = 0; i < this.filters_.size(); i++) {
                output.writeMessage(2, (MessageLite) this.filters_.get(i));
            }
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (this.op_ != Operator.OPERATOR_UNSPECIFIED.getNumber()) {
                size2 = 0 + CodedOutputStream.computeEnumSize(1, this.op_);
            }
            for (int i = 0; i < this.filters_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, (MessageLite) this.filters_.get(i));
            }
            this.memoizedSerializedSize = size2;
            return size2;
        }

        public static CompositeFilter parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (CompositeFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static CompositeFilter parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CompositeFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static CompositeFilter parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (CompositeFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static CompositeFilter parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CompositeFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static CompositeFilter parseFrom(InputStream input) throws IOException {
            return (CompositeFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static CompositeFilter parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CompositeFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static CompositeFilter parseDelimitedFrom(InputStream input) throws IOException {
            return (CompositeFilter) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static CompositeFilter parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CompositeFilter) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static CompositeFilter parseFrom(CodedInputStream input) throws IOException {
            return (CompositeFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static CompositeFilter parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CompositeFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CompositeFilter prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
        public static final class Builder extends GeneratedMessageLite.Builder<CompositeFilter, Builder> implements CompositeFilterOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(CompositeFilter.DEFAULT_INSTANCE);
            }

            public int getOpValue() {
                return ((CompositeFilter) this.instance).getOpValue();
            }

            public Builder setOpValue(int value) {
                copyOnWrite();
                ((CompositeFilter) this.instance).setOpValue(value);
                return this;
            }

            public Operator getOp() {
                return ((CompositeFilter) this.instance).getOp();
            }

            public Builder setOp(Operator value) {
                copyOnWrite();
                ((CompositeFilter) this.instance).setOp(value);
                return this;
            }

            public Builder clearOp() {
                copyOnWrite();
                ((CompositeFilter) this.instance).clearOp();
                return this;
            }

            public List<Filter> getFiltersList() {
                return Collections.unmodifiableList(((CompositeFilter) this.instance).getFiltersList());
            }

            public int getFiltersCount() {
                return ((CompositeFilter) this.instance).getFiltersCount();
            }

            public Filter getFilters(int index) {
                return ((CompositeFilter) this.instance).getFilters(index);
            }

            public Builder setFilters(int index, Filter value) {
                copyOnWrite();
                ((CompositeFilter) this.instance).setFilters(index, value);
                return this;
            }

            public Builder setFilters(int index, Filter.Builder builderForValue) {
                copyOnWrite();
                ((CompositeFilter) this.instance).setFilters(index, builderForValue);
                return this;
            }

            public Builder addFilters(Filter value) {
                copyOnWrite();
                ((CompositeFilter) this.instance).addFilters(value);
                return this;
            }

            public Builder addFilters(int index, Filter value) {
                copyOnWrite();
                ((CompositeFilter) this.instance).addFilters(index, value);
                return this;
            }

            public Builder addFilters(Filter.Builder builderForValue) {
                copyOnWrite();
                ((CompositeFilter) this.instance).addFilters(builderForValue);
                return this;
            }

            public Builder addFilters(int index, Filter.Builder builderForValue) {
                copyOnWrite();
                ((CompositeFilter) this.instance).addFilters(index, builderForValue);
                return this;
            }

            public Builder addAllFilters(Iterable<? extends Filter> values) {
                copyOnWrite();
                ((CompositeFilter) this.instance).addAllFilters(values);
                return this;
            }

            public Builder clearFilters() {
                copyOnWrite();
                ((CompositeFilter) this.instance).clearFilters();
                return this;
            }

            public Builder removeFilters(int index) {
                copyOnWrite();
                ((CompositeFilter) this.instance).removeFilters(index);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new CompositeFilter();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.filters_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    CompositeFilter other = (CompositeFilter) arg1;
                    boolean z = true;
                    boolean z2 = this.op_ != 0;
                    int i = this.op_;
                    if (other.op_ == 0) {
                        z = false;
                    }
                    this.op_ = visitor.visitInt(z2, i, z, other.op_);
                    this.filters_ = visitor.visitList(this.filters_, other.filters_);
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
                                this.op_ = input.readEnum();
                            } else if (tag == 18) {
                                if (!this.filters_.isModifiable()) {
                                    this.filters_ = GeneratedMessageLite.mutableCopy(this.filters_);
                                }
                                this.filters_.add((Filter) input.readMessage(Filter.parser(), extensionRegistry));
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
                        synchronized (CompositeFilter.class) {
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
            CompositeFilter compositeFilter = new CompositeFilter();
            DEFAULT_INSTANCE = compositeFilter;
            compositeFilter.makeImmutable();
        }

        public static CompositeFilter getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CompositeFilter> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class FieldFilter extends GeneratedMessageLite<FieldFilter, Builder> implements FieldFilterOrBuilder {
        /* access modifiers changed from: private */
        public static final FieldFilter DEFAULT_INSTANCE;
        public static final int FIELD_FIELD_NUMBER = 1;
        public static final int OP_FIELD_NUMBER = 2;
        private static volatile Parser<FieldFilter> PARSER = null;
        public static final int VALUE_FIELD_NUMBER = 3;
        private FieldReference field_;
        private int op_;
        private Value value_;

        private FieldFilter() {
        }

        /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
        public enum Operator implements Internal.EnumLite {
            OPERATOR_UNSPECIFIED(0),
            LESS_THAN(1),
            LESS_THAN_OR_EQUAL(2),
            GREATER_THAN(3),
            GREATER_THAN_OR_EQUAL(4),
            EQUAL(5),
            ARRAY_CONTAINS(7),
            IN(8),
            ARRAY_CONTAINS_ANY(9),
            UNRECOGNIZED(-1);
            
            public static final int ARRAY_CONTAINS_ANY_VALUE = 9;
            public static final int ARRAY_CONTAINS_VALUE = 7;
            public static final int EQUAL_VALUE = 5;
            public static final int GREATER_THAN_OR_EQUAL_VALUE = 4;
            public static final int GREATER_THAN_VALUE = 3;
            public static final int IN_VALUE = 8;
            public static final int LESS_THAN_OR_EQUAL_VALUE = 2;
            public static final int LESS_THAN_VALUE = 1;
            public static final int OPERATOR_UNSPECIFIED_VALUE = 0;
            private static final Internal.EnumLiteMap<Operator> internalValueMap = null;
            private final int value;

            static {
                internalValueMap = new Internal.EnumLiteMap<Operator>() {
                    public Operator findValueByNumber(int number) {
                        return Operator.forNumber(number);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static Operator valueOf(int value2) {
                return forNumber(value2);
            }

            public static Operator forNumber(int value2) {
                switch (value2) {
                    case 0:
                        return OPERATOR_UNSPECIFIED;
                    case 1:
                        return LESS_THAN;
                    case 2:
                        return LESS_THAN_OR_EQUAL;
                    case 3:
                        return GREATER_THAN;
                    case 4:
                        return GREATER_THAN_OR_EQUAL;
                    case 5:
                        return EQUAL;
                    case 7:
                        return ARRAY_CONTAINS;
                    case 8:
                        return IN;
                    case 9:
                        return ARRAY_CONTAINS_ANY;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<Operator> internalGetValueMap() {
                return internalValueMap;
            }

            private Operator(int value2) {
                this.value = value2;
            }
        }

        public boolean hasField() {
            return this.field_ != null;
        }

        public FieldReference getField() {
            FieldReference fieldReference = this.field_;
            return fieldReference == null ? FieldReference.getDefaultInstance() : fieldReference;
        }

        /* access modifiers changed from: private */
        public void setField(FieldReference value) {
            if (value != null) {
                this.field_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setField(FieldReference.Builder builderForValue) {
            this.field_ = (FieldReference) builderForValue.build();
        }

        /* access modifiers changed from: private */
        public void mergeField(FieldReference value) {
            FieldReference fieldReference = this.field_;
            if (fieldReference == null || fieldReference == FieldReference.getDefaultInstance()) {
                this.field_ = value;
            } else {
                this.field_ = (FieldReference) ((FieldReference.Builder) FieldReference.newBuilder(this.field_).mergeFrom(value)).buildPartial();
            }
        }

        /* access modifiers changed from: private */
        public void clearField() {
            this.field_ = null;
        }

        public int getOpValue() {
            return this.op_;
        }

        public Operator getOp() {
            Operator result = Operator.forNumber(this.op_);
            return result == null ? Operator.UNRECOGNIZED : result;
        }

        /* access modifiers changed from: private */
        public void setOpValue(int value) {
            this.op_ = value;
        }

        /* access modifiers changed from: private */
        public void setOp(Operator value) {
            if (value != null) {
                this.op_ = value.getNumber();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearOp() {
            this.op_ = 0;
        }

        public boolean hasValue() {
            return this.value_ != null;
        }

        public Value getValue() {
            Value value = this.value_;
            return value == null ? Value.getDefaultInstance() : value;
        }

        /* access modifiers changed from: private */
        public void setValue(Value value) {
            if (value != null) {
                this.value_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setValue(Value.Builder builderForValue) {
            this.value_ = (Value) builderForValue.build();
        }

        /* access modifiers changed from: private */
        public void mergeValue(Value value) {
            Value value2 = this.value_;
            if (value2 == null || value2 == Value.getDefaultInstance()) {
                this.value_ = value;
            } else {
                this.value_ = (Value) ((Value.Builder) Value.newBuilder(this.value_).mergeFrom(value)).buildPartial();
            }
        }

        /* access modifiers changed from: private */
        public void clearValue() {
            this.value_ = null;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (this.field_ != null) {
                output.writeMessage(1, getField());
            }
            if (this.op_ != Operator.OPERATOR_UNSPECIFIED.getNumber()) {
                output.writeEnum(2, this.op_);
            }
            if (this.value_ != null) {
                output.writeMessage(3, getValue());
            }
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (this.field_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(1, getField());
            }
            if (this.op_ != Operator.OPERATOR_UNSPECIFIED.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(2, this.op_);
            }
            if (this.value_ != null) {
                size2 += CodedOutputStream.computeMessageSize(3, getValue());
            }
            this.memoizedSerializedSize = size2;
            return size2;
        }

        public static FieldFilter parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FieldFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FieldFilter parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FieldFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FieldFilter parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FieldFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FieldFilter parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FieldFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FieldFilter parseFrom(InputStream input) throws IOException {
            return (FieldFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FieldFilter parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FieldFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FieldFilter parseDelimitedFrom(InputStream input) throws IOException {
            return (FieldFilter) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static FieldFilter parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FieldFilter) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FieldFilter parseFrom(CodedInputStream input) throws IOException {
            return (FieldFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FieldFilter parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FieldFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FieldFilter prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
        public static final class Builder extends GeneratedMessageLite.Builder<FieldFilter, Builder> implements FieldFilterOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(FieldFilter.DEFAULT_INSTANCE);
            }

            public boolean hasField() {
                return ((FieldFilter) this.instance).hasField();
            }

            public FieldReference getField() {
                return ((FieldFilter) this.instance).getField();
            }

            public Builder setField(FieldReference value) {
                copyOnWrite();
                ((FieldFilter) this.instance).setField(value);
                return this;
            }

            public Builder setField(FieldReference.Builder builderForValue) {
                copyOnWrite();
                ((FieldFilter) this.instance).setField(builderForValue);
                return this;
            }

            public Builder mergeField(FieldReference value) {
                copyOnWrite();
                ((FieldFilter) this.instance).mergeField(value);
                return this;
            }

            public Builder clearField() {
                copyOnWrite();
                ((FieldFilter) this.instance).clearField();
                return this;
            }

            public int getOpValue() {
                return ((FieldFilter) this.instance).getOpValue();
            }

            public Builder setOpValue(int value) {
                copyOnWrite();
                ((FieldFilter) this.instance).setOpValue(value);
                return this;
            }

            public Operator getOp() {
                return ((FieldFilter) this.instance).getOp();
            }

            public Builder setOp(Operator value) {
                copyOnWrite();
                ((FieldFilter) this.instance).setOp(value);
                return this;
            }

            public Builder clearOp() {
                copyOnWrite();
                ((FieldFilter) this.instance).clearOp();
                return this;
            }

            public boolean hasValue() {
                return ((FieldFilter) this.instance).hasValue();
            }

            public Value getValue() {
                return ((FieldFilter) this.instance).getValue();
            }

            public Builder setValue(Value value) {
                copyOnWrite();
                ((FieldFilter) this.instance).setValue(value);
                return this;
            }

            public Builder setValue(Value.Builder builderForValue) {
                copyOnWrite();
                ((FieldFilter) this.instance).setValue(builderForValue);
                return this;
            }

            public Builder mergeValue(Value value) {
                copyOnWrite();
                ((FieldFilter) this.instance).mergeValue(value);
                return this;
            }

            public Builder clearValue() {
                copyOnWrite();
                ((FieldFilter) this.instance).clearValue();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new FieldFilter();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    FieldFilter other = (FieldFilter) arg1;
                    this.field_ = (FieldReference) visitor.visitMessage(this.field_, other.field_);
                    boolean z = true;
                    boolean z2 = this.op_ != 0;
                    int i = this.op_;
                    if (other.op_ == 0) {
                        z = false;
                    }
                    this.op_ = visitor.visitInt(z2, i, z, other.op_);
                    this.value_ = (Value) visitor.visitMessage(this.value_, other.value_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
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
                                FieldReference.Builder subBuilder = null;
                                if (this.field_ != null) {
                                    subBuilder = (FieldReference.Builder) this.field_.toBuilder();
                                }
                                FieldReference fieldReference = (FieldReference) input.readMessage(FieldReference.parser(), extensionRegistry);
                                this.field_ = fieldReference;
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom(fieldReference);
                                    this.field_ = (FieldReference) subBuilder.buildPartial();
                                }
                            } else if (tag == 16) {
                                this.op_ = input.readEnum();
                            } else if (tag == 26) {
                                Value.Builder subBuilder2 = null;
                                if (this.value_ != null) {
                                    subBuilder2 = (Value.Builder) this.value_.toBuilder();
                                }
                                Value value = (Value) input.readMessage(Value.parser(), extensionRegistry);
                                this.value_ = value;
                                if (subBuilder2 != null) {
                                    subBuilder2.mergeFrom(value);
                                    this.value_ = (Value) subBuilder2.buildPartial();
                                }
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
                        synchronized (FieldFilter.class) {
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
            FieldFilter fieldFilter = new FieldFilter();
            DEFAULT_INSTANCE = fieldFilter;
            fieldFilter.makeImmutable();
        }

        public static FieldFilter getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FieldFilter> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class UnaryFilter extends GeneratedMessageLite<UnaryFilter, Builder> implements UnaryFilterOrBuilder {
        /* access modifiers changed from: private */
        public static final UnaryFilter DEFAULT_INSTANCE;
        public static final int FIELD_FIELD_NUMBER = 2;
        public static final int OP_FIELD_NUMBER = 1;
        private static volatile Parser<UnaryFilter> PARSER;
        private int op_;
        private int operandTypeCase_ = 0;
        private Object operandType_;

        private UnaryFilter() {
        }

        /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
        public enum Operator implements Internal.EnumLite {
            OPERATOR_UNSPECIFIED(0),
            IS_NAN(2),
            IS_NULL(3),
            UNRECOGNIZED(-1);
            
            public static final int IS_NAN_VALUE = 2;
            public static final int IS_NULL_VALUE = 3;
            public static final int OPERATOR_UNSPECIFIED_VALUE = 0;
            private static final Internal.EnumLiteMap<Operator> internalValueMap = null;
            private final int value;

            static {
                internalValueMap = new Internal.EnumLiteMap<Operator>() {
                    public Operator findValueByNumber(int number) {
                        return Operator.forNumber(number);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static Operator valueOf(int value2) {
                return forNumber(value2);
            }

            public static Operator forNumber(int value2) {
                if (value2 == 0) {
                    return OPERATOR_UNSPECIFIED;
                }
                if (value2 == 2) {
                    return IS_NAN;
                }
                if (value2 != 3) {
                    return null;
                }
                return IS_NULL;
            }

            public static Internal.EnumLiteMap<Operator> internalGetValueMap() {
                return internalValueMap;
            }

            private Operator(int value2) {
                this.value = value2;
            }
        }

        /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
        public enum OperandTypeCase implements Internal.EnumLite {
            FIELD(2),
            OPERANDTYPE_NOT_SET(0);
            
            private final int value;

            private OperandTypeCase(int value2) {
                this.value = value2;
            }

            @Deprecated
            public static OperandTypeCase valueOf(int value2) {
                return forNumber(value2);
            }

            public static OperandTypeCase forNumber(int value2) {
                if (value2 == 0) {
                    return OPERANDTYPE_NOT_SET;
                }
                if (value2 != 2) {
                    return null;
                }
                return FIELD;
            }

            public int getNumber() {
                return this.value;
            }
        }

        public OperandTypeCase getOperandTypeCase() {
            return OperandTypeCase.forNumber(this.operandTypeCase_);
        }

        /* access modifiers changed from: private */
        public void clearOperandType() {
            this.operandTypeCase_ = 0;
            this.operandType_ = null;
        }

        public int getOpValue() {
            return this.op_;
        }

        public Operator getOp() {
            Operator result = Operator.forNumber(this.op_);
            return result == null ? Operator.UNRECOGNIZED : result;
        }

        /* access modifiers changed from: private */
        public void setOpValue(int value) {
            this.op_ = value;
        }

        /* access modifiers changed from: private */
        public void setOp(Operator value) {
            if (value != null) {
                this.op_ = value.getNumber();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearOp() {
            this.op_ = 0;
        }

        public FieldReference getField() {
            if (this.operandTypeCase_ == 2) {
                return (FieldReference) this.operandType_;
            }
            return FieldReference.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setField(FieldReference value) {
            if (value != null) {
                this.operandType_ = value;
                this.operandTypeCase_ = 2;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setField(FieldReference.Builder builderForValue) {
            this.operandType_ = builderForValue.build();
            this.operandTypeCase_ = 2;
        }

        /* access modifiers changed from: private */
        public void mergeField(FieldReference value) {
            if (this.operandTypeCase_ != 2 || this.operandType_ == FieldReference.getDefaultInstance()) {
                this.operandType_ = value;
            } else {
                this.operandType_ = ((FieldReference.Builder) FieldReference.newBuilder((FieldReference) this.operandType_).mergeFrom(value)).buildPartial();
            }
            this.operandTypeCase_ = 2;
        }

        /* access modifiers changed from: private */
        public void clearField() {
            if (this.operandTypeCase_ == 2) {
                this.operandTypeCase_ = 0;
                this.operandType_ = null;
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (this.op_ != Operator.OPERATOR_UNSPECIFIED.getNumber()) {
                output.writeEnum(1, this.op_);
            }
            if (this.operandTypeCase_ == 2) {
                output.writeMessage(2, (FieldReference) this.operandType_);
            }
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (this.op_ != Operator.OPERATOR_UNSPECIFIED.getNumber()) {
                size2 = 0 + CodedOutputStream.computeEnumSize(1, this.op_);
            }
            if (this.operandTypeCase_ == 2) {
                size2 += CodedOutputStream.computeMessageSize(2, (FieldReference) this.operandType_);
            }
            this.memoizedSerializedSize = size2;
            return size2;
        }

        public static UnaryFilter parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (UnaryFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static UnaryFilter parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UnaryFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static UnaryFilter parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (UnaryFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static UnaryFilter parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UnaryFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static UnaryFilter parseFrom(InputStream input) throws IOException {
            return (UnaryFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static UnaryFilter parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UnaryFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static UnaryFilter parseDelimitedFrom(InputStream input) throws IOException {
            return (UnaryFilter) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static UnaryFilter parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UnaryFilter) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static UnaryFilter parseFrom(CodedInputStream input) throws IOException {
            return (UnaryFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static UnaryFilter parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UnaryFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UnaryFilter prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
        public static final class Builder extends GeneratedMessageLite.Builder<UnaryFilter, Builder> implements UnaryFilterOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(UnaryFilter.DEFAULT_INSTANCE);
            }

            public OperandTypeCase getOperandTypeCase() {
                return ((UnaryFilter) this.instance).getOperandTypeCase();
            }

            public Builder clearOperandType() {
                copyOnWrite();
                ((UnaryFilter) this.instance).clearOperandType();
                return this;
            }

            public int getOpValue() {
                return ((UnaryFilter) this.instance).getOpValue();
            }

            public Builder setOpValue(int value) {
                copyOnWrite();
                ((UnaryFilter) this.instance).setOpValue(value);
                return this;
            }

            public Operator getOp() {
                return ((UnaryFilter) this.instance).getOp();
            }

            public Builder setOp(Operator value) {
                copyOnWrite();
                ((UnaryFilter) this.instance).setOp(value);
                return this;
            }

            public Builder clearOp() {
                copyOnWrite();
                ((UnaryFilter) this.instance).clearOp();
                return this;
            }

            public FieldReference getField() {
                return ((UnaryFilter) this.instance).getField();
            }

            public Builder setField(FieldReference value) {
                copyOnWrite();
                ((UnaryFilter) this.instance).setField(value);
                return this;
            }

            public Builder setField(FieldReference.Builder builderForValue) {
                copyOnWrite();
                ((UnaryFilter) this.instance).setField(builderForValue);
                return this;
            }

            public Builder mergeField(FieldReference value) {
                copyOnWrite();
                ((UnaryFilter) this.instance).mergeField(value);
                return this;
            }

            public Builder clearField() {
                copyOnWrite();
                ((UnaryFilter) this.instance).clearField();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            int i;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new UnaryFilter();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    UnaryFilter other = (UnaryFilter) arg1;
                    boolean z = false;
                    this.op_ = visitor.visitInt(this.op_ != 0, this.op_, other.op_ != 0, other.op_);
                    int i2 = AnonymousClass1.$SwitchMap$com$google$firestore$v1$StructuredQuery$UnaryFilter$OperandTypeCase[other.getOperandTypeCase().ordinal()];
                    if (i2 == 1) {
                        if (this.operandTypeCase_ == 2) {
                            z = true;
                        }
                        this.operandType_ = visitor.visitOneofMessage(z, this.operandType_, other.operandType_);
                    } else if (i2 == 2) {
                        if (this.operandTypeCase_ != 0) {
                            z = true;
                        }
                        visitor.visitOneofNotSet(z);
                    }
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE && (i = other.operandTypeCase_) != 0) {
                        this.operandTypeCase_ = i;
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
                                this.op_ = input.readEnum();
                            } else if (tag == 18) {
                                FieldReference.Builder subBuilder = null;
                                if (this.operandTypeCase_ == 2) {
                                    subBuilder = (FieldReference.Builder) ((FieldReference) this.operandType_).toBuilder();
                                }
                                MessageLite readMessage = input.readMessage(FieldReference.parser(), extensionRegistry);
                                this.operandType_ = readMessage;
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom((FieldReference) readMessage);
                                    this.operandType_ = subBuilder.buildPartial();
                                }
                                this.operandTypeCase_ = 2;
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
                        synchronized (UnaryFilter.class) {
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
            UnaryFilter unaryFilter = new UnaryFilter();
            DEFAULT_INSTANCE = unaryFilter;
            unaryFilter.makeImmutable();
        }

        public static UnaryFilter getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UnaryFilter> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.google.firestore.v1.StructuredQuery$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$StructuredQuery$Filter$FilterTypeCase;
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$StructuredQuery$UnaryFilter$OperandTypeCase;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[UnaryFilter.OperandTypeCase.values().length];
            $SwitchMap$com$google$firestore$v1$StructuredQuery$UnaryFilter$OperandTypeCase = iArr;
            try {
                iArr[UnaryFilter.OperandTypeCase.FIELD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$StructuredQuery$UnaryFilter$OperandTypeCase[UnaryFilter.OperandTypeCase.OPERANDTYPE_NOT_SET.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            int[] iArr2 = new int[Filter.FilterTypeCase.values().length];
            $SwitchMap$com$google$firestore$v1$StructuredQuery$Filter$FilterTypeCase = iArr2;
            try {
                iArr2[Filter.FilterTypeCase.COMPOSITE_FILTER.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$StructuredQuery$Filter$FilterTypeCase[Filter.FilterTypeCase.FIELD_FILTER.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$StructuredQuery$Filter$FilterTypeCase[Filter.FilterTypeCase.UNARY_FILTER.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$StructuredQuery$Filter$FilterTypeCase[Filter.FilterTypeCase.FILTERTYPE_NOT_SET.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            int[] iArr3 = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr3;
            try {
                iArr3[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 4;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.VISIT.ordinal()] = 5;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM.ordinal()] = 6;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 7;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 8;
            } catch (NoSuchFieldError e14) {
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Order extends GeneratedMessageLite<Order, Builder> implements OrderOrBuilder {
        /* access modifiers changed from: private */
        public static final Order DEFAULT_INSTANCE;
        public static final int DIRECTION_FIELD_NUMBER = 2;
        public static final int FIELD_FIELD_NUMBER = 1;
        private static volatile Parser<Order> PARSER;
        private int direction_;
        private FieldReference field_;

        private Order() {
        }

        public boolean hasField() {
            return this.field_ != null;
        }

        public FieldReference getField() {
            FieldReference fieldReference = this.field_;
            return fieldReference == null ? FieldReference.getDefaultInstance() : fieldReference;
        }

        /* access modifiers changed from: private */
        public void setField(FieldReference value) {
            if (value != null) {
                this.field_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setField(FieldReference.Builder builderForValue) {
            this.field_ = (FieldReference) builderForValue.build();
        }

        /* access modifiers changed from: private */
        public void mergeField(FieldReference value) {
            FieldReference fieldReference = this.field_;
            if (fieldReference == null || fieldReference == FieldReference.getDefaultInstance()) {
                this.field_ = value;
            } else {
                this.field_ = (FieldReference) ((FieldReference.Builder) FieldReference.newBuilder(this.field_).mergeFrom(value)).buildPartial();
            }
        }

        /* access modifiers changed from: private */
        public void clearField() {
            this.field_ = null;
        }

        public int getDirectionValue() {
            return this.direction_;
        }

        public Direction getDirection() {
            Direction result = Direction.forNumber(this.direction_);
            return result == null ? Direction.UNRECOGNIZED : result;
        }

        /* access modifiers changed from: private */
        public void setDirectionValue(int value) {
            this.direction_ = value;
        }

        /* access modifiers changed from: private */
        public void setDirection(Direction value) {
            if (value != null) {
                this.direction_ = value.getNumber();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearDirection() {
            this.direction_ = 0;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (this.field_ != null) {
                output.writeMessage(1, getField());
            }
            if (this.direction_ != Direction.DIRECTION_UNSPECIFIED.getNumber()) {
                output.writeEnum(2, this.direction_);
            }
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (this.field_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(1, getField());
            }
            if (this.direction_ != Direction.DIRECTION_UNSPECIFIED.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(2, this.direction_);
            }
            this.memoizedSerializedSize = size2;
            return size2;
        }

        public static Order parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Order) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Order parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Order) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Order parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Order) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Order parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Order) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Order parseFrom(InputStream input) throws IOException {
            return (Order) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Order parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Order) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Order parseDelimitedFrom(InputStream input) throws IOException {
            return (Order) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static Order parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Order) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Order parseFrom(CodedInputStream input) throws IOException {
            return (Order) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Order parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Order) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Order prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
        public static final class Builder extends GeneratedMessageLite.Builder<Order, Builder> implements OrderOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(Order.DEFAULT_INSTANCE);
            }

            public boolean hasField() {
                return ((Order) this.instance).hasField();
            }

            public FieldReference getField() {
                return ((Order) this.instance).getField();
            }

            public Builder setField(FieldReference value) {
                copyOnWrite();
                ((Order) this.instance).setField(value);
                return this;
            }

            public Builder setField(FieldReference.Builder builderForValue) {
                copyOnWrite();
                ((Order) this.instance).setField(builderForValue);
                return this;
            }

            public Builder mergeField(FieldReference value) {
                copyOnWrite();
                ((Order) this.instance).mergeField(value);
                return this;
            }

            public Builder clearField() {
                copyOnWrite();
                ((Order) this.instance).clearField();
                return this;
            }

            public int getDirectionValue() {
                return ((Order) this.instance).getDirectionValue();
            }

            public Builder setDirectionValue(int value) {
                copyOnWrite();
                ((Order) this.instance).setDirectionValue(value);
                return this;
            }

            public Direction getDirection() {
                return ((Order) this.instance).getDirection();
            }

            public Builder setDirection(Direction value) {
                copyOnWrite();
                ((Order) this.instance).setDirection(value);
                return this;
            }

            public Builder clearDirection() {
                copyOnWrite();
                ((Order) this.instance).clearDirection();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new Order();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    Order other = (Order) arg1;
                    this.field_ = (FieldReference) visitor.visitMessage(this.field_, other.field_);
                    boolean z = true;
                    boolean z2 = this.direction_ != 0;
                    int i = this.direction_;
                    if (other.direction_ == 0) {
                        z = false;
                    }
                    this.direction_ = visitor.visitInt(z2, i, z, other.direction_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
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
                                FieldReference.Builder subBuilder = null;
                                if (this.field_ != null) {
                                    subBuilder = (FieldReference.Builder) this.field_.toBuilder();
                                }
                                FieldReference fieldReference = (FieldReference) input.readMessage(FieldReference.parser(), extensionRegistry);
                                this.field_ = fieldReference;
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom(fieldReference);
                                    this.field_ = (FieldReference) subBuilder.buildPartial();
                                }
                            } else if (tag == 16) {
                                this.direction_ = input.readEnum();
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
                        synchronized (Order.class) {
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
            Order order = new Order();
            DEFAULT_INSTANCE = order;
            order.makeImmutable();
        }

        public static Order getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Order> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class FieldReference extends GeneratedMessageLite<FieldReference, Builder> implements FieldReferenceOrBuilder {
        /* access modifiers changed from: private */
        public static final FieldReference DEFAULT_INSTANCE;
        public static final int FIELD_PATH_FIELD_NUMBER = 2;
        private static volatile Parser<FieldReference> PARSER;
        private String fieldPath_ = "";

        private FieldReference() {
        }

        public String getFieldPath() {
            return this.fieldPath_;
        }

        public ByteString getFieldPathBytes() {
            return ByteString.copyFromUtf8(this.fieldPath_);
        }

        /* access modifiers changed from: private */
        public void setFieldPath(String value) {
            if (value != null) {
                this.fieldPath_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearFieldPath() {
            this.fieldPath_ = getDefaultInstance().getFieldPath();
        }

        /* access modifiers changed from: private */
        public void setFieldPathBytes(ByteString value) {
            if (value != null) {
                checkByteStringIsUtf8(value);
                this.fieldPath_ = value.toStringUtf8();
                return;
            }
            throw null;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (!this.fieldPath_.isEmpty()) {
                output.writeString(2, getFieldPath());
            }
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (!this.fieldPath_.isEmpty()) {
                size2 = 0 + CodedOutputStream.computeStringSize(2, getFieldPath());
            }
            this.memoizedSerializedSize = size2;
            return size2;
        }

        public static FieldReference parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FieldReference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FieldReference parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FieldReference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FieldReference parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FieldReference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FieldReference parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FieldReference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FieldReference parseFrom(InputStream input) throws IOException {
            return (FieldReference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FieldReference parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FieldReference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FieldReference parseDelimitedFrom(InputStream input) throws IOException {
            return (FieldReference) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static FieldReference parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FieldReference) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FieldReference parseFrom(CodedInputStream input) throws IOException {
            return (FieldReference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FieldReference parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FieldReference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FieldReference prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
        public static final class Builder extends GeneratedMessageLite.Builder<FieldReference, Builder> implements FieldReferenceOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(FieldReference.DEFAULT_INSTANCE);
            }

            public String getFieldPath() {
                return ((FieldReference) this.instance).getFieldPath();
            }

            public ByteString getFieldPathBytes() {
                return ((FieldReference) this.instance).getFieldPathBytes();
            }

            public Builder setFieldPath(String value) {
                copyOnWrite();
                ((FieldReference) this.instance).setFieldPath(value);
                return this;
            }

            public Builder clearFieldPath() {
                copyOnWrite();
                ((FieldReference) this.instance).clearFieldPath();
                return this;
            }

            public Builder setFieldPathBytes(ByteString value) {
                copyOnWrite();
                ((FieldReference) this.instance).setFieldPathBytes(value);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new FieldReference();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    FieldReference other = (FieldReference) arg1;
                    this.fieldPath_ = ((GeneratedMessageLite.Visitor) arg0).visitString(!this.fieldPath_.isEmpty(), this.fieldPath_, !other.fieldPath_.isEmpty(), other.fieldPath_);
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
                                this.fieldPath_ = input.readStringRequireUtf8();
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
                        synchronized (FieldReference.class) {
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
            FieldReference fieldReference = new FieldReference();
            DEFAULT_INSTANCE = fieldReference;
            fieldReference.makeImmutable();
        }

        public static FieldReference getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FieldReference> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Projection extends GeneratedMessageLite<Projection, Builder> implements ProjectionOrBuilder {
        /* access modifiers changed from: private */
        public static final Projection DEFAULT_INSTANCE;
        public static final int FIELDS_FIELD_NUMBER = 2;
        private static volatile Parser<Projection> PARSER;
        private Internal.ProtobufList<FieldReference> fields_ = emptyProtobufList();

        private Projection() {
        }

        public List<FieldReference> getFieldsList() {
            return this.fields_;
        }

        public List<? extends FieldReferenceOrBuilder> getFieldsOrBuilderList() {
            return this.fields_;
        }

        public int getFieldsCount() {
            return this.fields_.size();
        }

        public FieldReference getFields(int index) {
            return (FieldReference) this.fields_.get(index);
        }

        public FieldReferenceOrBuilder getFieldsOrBuilder(int index) {
            return (FieldReferenceOrBuilder) this.fields_.get(index);
        }

        private void ensureFieldsIsMutable() {
            if (!this.fields_.isModifiable()) {
                this.fields_ = GeneratedMessageLite.mutableCopy(this.fields_);
            }
        }

        /* access modifiers changed from: private */
        public void setFields(int index, FieldReference value) {
            if (value != null) {
                ensureFieldsIsMutable();
                this.fields_.set(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setFields(int index, FieldReference.Builder builderForValue) {
            ensureFieldsIsMutable();
            this.fields_.set(index, (FieldReference) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addFields(FieldReference value) {
            if (value != null) {
                ensureFieldsIsMutable();
                this.fields_.add(value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addFields(int index, FieldReference value) {
            if (value != null) {
                ensureFieldsIsMutable();
                this.fields_.add(index, value);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addFields(FieldReference.Builder builderForValue) {
            ensureFieldsIsMutable();
            this.fields_.add((FieldReference) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addFields(int index, FieldReference.Builder builderForValue) {
            ensureFieldsIsMutable();
            this.fields_.add(index, (FieldReference) builderForValue.build());
        }

        /* access modifiers changed from: private */
        public void addAllFields(Iterable<? extends FieldReference> values) {
            ensureFieldsIsMutable();
            AbstractMessageLite.addAll(values, this.fields_);
        }

        /* access modifiers changed from: private */
        public void clearFields() {
            this.fields_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeFields(int index) {
            ensureFieldsIsMutable();
            this.fields_.remove(index);
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            for (int i = 0; i < this.fields_.size(); i++) {
                output.writeMessage(2, (MessageLite) this.fields_.get(i));
            }
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            for (int i = 0; i < this.fields_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, (MessageLite) this.fields_.get(i));
            }
            this.memoizedSerializedSize = size2;
            return size2;
        }

        public static Projection parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Projection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Projection parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Projection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Projection parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Projection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Projection parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Projection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Projection parseFrom(InputStream input) throws IOException {
            return (Projection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Projection parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Projection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Projection parseDelimitedFrom(InputStream input) throws IOException {
            return (Projection) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static Projection parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Projection) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Projection parseFrom(CodedInputStream input) throws IOException {
            return (Projection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Projection parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Projection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Projection prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
        public static final class Builder extends GeneratedMessageLite.Builder<Projection, Builder> implements ProjectionOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(Projection.DEFAULT_INSTANCE);
            }

            public List<FieldReference> getFieldsList() {
                return Collections.unmodifiableList(((Projection) this.instance).getFieldsList());
            }

            public int getFieldsCount() {
                return ((Projection) this.instance).getFieldsCount();
            }

            public FieldReference getFields(int index) {
                return ((Projection) this.instance).getFields(index);
            }

            public Builder setFields(int index, FieldReference value) {
                copyOnWrite();
                ((Projection) this.instance).setFields(index, value);
                return this;
            }

            public Builder setFields(int index, FieldReference.Builder builderForValue) {
                copyOnWrite();
                ((Projection) this.instance).setFields(index, builderForValue);
                return this;
            }

            public Builder addFields(FieldReference value) {
                copyOnWrite();
                ((Projection) this.instance).addFields(value);
                return this;
            }

            public Builder addFields(int index, FieldReference value) {
                copyOnWrite();
                ((Projection) this.instance).addFields(index, value);
                return this;
            }

            public Builder addFields(FieldReference.Builder builderForValue) {
                copyOnWrite();
                ((Projection) this.instance).addFields(builderForValue);
                return this;
            }

            public Builder addFields(int index, FieldReference.Builder builderForValue) {
                copyOnWrite();
                ((Projection) this.instance).addFields(index, builderForValue);
                return this;
            }

            public Builder addAllFields(Iterable<? extends FieldReference> values) {
                copyOnWrite();
                ((Projection) this.instance).addAllFields(values);
                return this;
            }

            public Builder clearFields() {
                copyOnWrite();
                ((Projection) this.instance).clearFields();
                return this;
            }

            public Builder removeFields(int index) {
                copyOnWrite();
                ((Projection) this.instance).removeFields(index);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new Projection();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.fields_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    this.fields_ = ((GeneratedMessageLite.Visitor) arg0).visitList(this.fields_, ((Projection) arg1).fields_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
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
                                if (!this.fields_.isModifiable()) {
                                    this.fields_ = GeneratedMessageLite.mutableCopy(this.fields_);
                                }
                                this.fields_.add((FieldReference) input.readMessage(FieldReference.parser(), extensionRegistry));
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
                        synchronized (Projection.class) {
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
            Projection projection = new Projection();
            DEFAULT_INSTANCE = projection;
            projection.makeImmutable();
        }

        public static Projection getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Projection> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public boolean hasSelect() {
        return this.select_ != null;
    }

    public Projection getSelect() {
        Projection projection = this.select_;
        return projection == null ? Projection.getDefaultInstance() : projection;
    }

    /* access modifiers changed from: private */
    public void setSelect(Projection value) {
        if (value != null) {
            this.select_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setSelect(Projection.Builder builderForValue) {
        this.select_ = (Projection) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeSelect(Projection value) {
        Projection projection = this.select_;
        if (projection == null || projection == Projection.getDefaultInstance()) {
            this.select_ = value;
        } else {
            this.select_ = (Projection) ((Projection.Builder) Projection.newBuilder(this.select_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearSelect() {
        this.select_ = null;
    }

    public List<CollectionSelector> getFromList() {
        return this.from_;
    }

    public List<? extends CollectionSelectorOrBuilder> getFromOrBuilderList() {
        return this.from_;
    }

    public int getFromCount() {
        return this.from_.size();
    }

    public CollectionSelector getFrom(int index) {
        return (CollectionSelector) this.from_.get(index);
    }

    public CollectionSelectorOrBuilder getFromOrBuilder(int index) {
        return (CollectionSelectorOrBuilder) this.from_.get(index);
    }

    private void ensureFromIsMutable() {
        if (!this.from_.isModifiable()) {
            this.from_ = GeneratedMessageLite.mutableCopy(this.from_);
        }
    }

    /* access modifiers changed from: private */
    public void setFrom(int index, CollectionSelector value) {
        if (value != null) {
            ensureFromIsMutable();
            this.from_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setFrom(int index, CollectionSelector.Builder builderForValue) {
        ensureFromIsMutable();
        this.from_.set(index, (CollectionSelector) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addFrom(CollectionSelector value) {
        if (value != null) {
            ensureFromIsMutable();
            this.from_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addFrom(int index, CollectionSelector value) {
        if (value != null) {
            ensureFromIsMutable();
            this.from_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addFrom(CollectionSelector.Builder builderForValue) {
        ensureFromIsMutable();
        this.from_.add((CollectionSelector) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addFrom(int index, CollectionSelector.Builder builderForValue) {
        ensureFromIsMutable();
        this.from_.add(index, (CollectionSelector) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllFrom(Iterable<? extends CollectionSelector> values) {
        ensureFromIsMutable();
        AbstractMessageLite.addAll(values, this.from_);
    }

    /* access modifiers changed from: private */
    public void clearFrom() {
        this.from_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeFrom(int index) {
        ensureFromIsMutable();
        this.from_.remove(index);
    }

    public boolean hasWhere() {
        return this.where_ != null;
    }

    public Filter getWhere() {
        Filter filter = this.where_;
        return filter == null ? Filter.getDefaultInstance() : filter;
    }

    /* access modifiers changed from: private */
    public void setWhere(Filter value) {
        if (value != null) {
            this.where_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setWhere(Filter.Builder builderForValue) {
        this.where_ = (Filter) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeWhere(Filter value) {
        Filter filter = this.where_;
        if (filter == null || filter == Filter.getDefaultInstance()) {
            this.where_ = value;
        } else {
            this.where_ = (Filter) ((Filter.Builder) Filter.newBuilder(this.where_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearWhere() {
        this.where_ = null;
    }

    public List<Order> getOrderByList() {
        return this.orderBy_;
    }

    public List<? extends OrderOrBuilder> getOrderByOrBuilderList() {
        return this.orderBy_;
    }

    public int getOrderByCount() {
        return this.orderBy_.size();
    }

    public Order getOrderBy(int index) {
        return (Order) this.orderBy_.get(index);
    }

    public OrderOrBuilder getOrderByOrBuilder(int index) {
        return (OrderOrBuilder) this.orderBy_.get(index);
    }

    private void ensureOrderByIsMutable() {
        if (!this.orderBy_.isModifiable()) {
            this.orderBy_ = GeneratedMessageLite.mutableCopy(this.orderBy_);
        }
    }

    /* access modifiers changed from: private */
    public void setOrderBy(int index, Order value) {
        if (value != null) {
            ensureOrderByIsMutable();
            this.orderBy_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setOrderBy(int index, Order.Builder builderForValue) {
        ensureOrderByIsMutable();
        this.orderBy_.set(index, (Order) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addOrderBy(Order value) {
        if (value != null) {
            ensureOrderByIsMutable();
            this.orderBy_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addOrderBy(int index, Order value) {
        if (value != null) {
            ensureOrderByIsMutable();
            this.orderBy_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addOrderBy(Order.Builder builderForValue) {
        ensureOrderByIsMutable();
        this.orderBy_.add((Order) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addOrderBy(int index, Order.Builder builderForValue) {
        ensureOrderByIsMutable();
        this.orderBy_.add(index, (Order) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllOrderBy(Iterable<? extends Order> values) {
        ensureOrderByIsMutable();
        AbstractMessageLite.addAll(values, this.orderBy_);
    }

    /* access modifiers changed from: private */
    public void clearOrderBy() {
        this.orderBy_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeOrderBy(int index) {
        ensureOrderByIsMutable();
        this.orderBy_.remove(index);
    }

    public boolean hasStartAt() {
        return this.startAt_ != null;
    }

    public Cursor getStartAt() {
        Cursor cursor = this.startAt_;
        return cursor == null ? Cursor.getDefaultInstance() : cursor;
    }

    /* access modifiers changed from: private */
    public void setStartAt(Cursor value) {
        if (value != null) {
            this.startAt_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setStartAt(Cursor.Builder builderForValue) {
        this.startAt_ = (Cursor) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeStartAt(Cursor value) {
        Cursor cursor = this.startAt_;
        if (cursor == null || cursor == Cursor.getDefaultInstance()) {
            this.startAt_ = value;
        } else {
            this.startAt_ = (Cursor) ((Cursor.Builder) Cursor.newBuilder(this.startAt_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearStartAt() {
        this.startAt_ = null;
    }

    public boolean hasEndAt() {
        return this.endAt_ != null;
    }

    public Cursor getEndAt() {
        Cursor cursor = this.endAt_;
        return cursor == null ? Cursor.getDefaultInstance() : cursor;
    }

    /* access modifiers changed from: private */
    public void setEndAt(Cursor value) {
        if (value != null) {
            this.endAt_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setEndAt(Cursor.Builder builderForValue) {
        this.endAt_ = (Cursor) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeEndAt(Cursor value) {
        Cursor cursor = this.endAt_;
        if (cursor == null || cursor == Cursor.getDefaultInstance()) {
            this.endAt_ = value;
        } else {
            this.endAt_ = (Cursor) ((Cursor.Builder) Cursor.newBuilder(this.endAt_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearEndAt() {
        this.endAt_ = null;
    }

    public int getOffset() {
        return this.offset_;
    }

    /* access modifiers changed from: private */
    public void setOffset(int value) {
        this.offset_ = value;
    }

    /* access modifiers changed from: private */
    public void clearOffset() {
        this.offset_ = 0;
    }

    public boolean hasLimit() {
        return this.limit_ != null;
    }

    public Int32Value getLimit() {
        Int32Value int32Value = this.limit_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    /* access modifiers changed from: private */
    public void setLimit(Int32Value value) {
        if (value != null) {
            this.limit_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setLimit(Int32Value.Builder builderForValue) {
        this.limit_ = (Int32Value) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeLimit(Int32Value value) {
        Int32Value int32Value = this.limit_;
        if (int32Value == null || int32Value == Int32Value.getDefaultInstance()) {
            this.limit_ = value;
        } else {
            this.limit_ = (Int32Value) ((Int32Value.Builder) Int32Value.newBuilder(this.limit_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearLimit() {
        this.limit_ = null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (this.select_ != null) {
            output.writeMessage(1, getSelect());
        }
        for (int i = 0; i < this.from_.size(); i++) {
            output.writeMessage(2, (MessageLite) this.from_.get(i));
        }
        if (this.where_ != null) {
            output.writeMessage(3, getWhere());
        }
        for (int i2 = 0; i2 < this.orderBy_.size(); i2++) {
            output.writeMessage(4, (MessageLite) this.orderBy_.get(i2));
        }
        if (this.limit_ != null) {
            output.writeMessage(5, getLimit());
        }
        int i3 = this.offset_;
        if (i3 != 0) {
            output.writeInt32(6, i3);
        }
        if (this.startAt_ != null) {
            output.writeMessage(7, getStartAt());
        }
        if (this.endAt_ != null) {
            output.writeMessage(8, getEndAt());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (this.select_ != null) {
            size2 = 0 + CodedOutputStream.computeMessageSize(1, getSelect());
        }
        for (int i = 0; i < this.from_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(2, (MessageLite) this.from_.get(i));
        }
        if (this.where_ != null) {
            size2 += CodedOutputStream.computeMessageSize(3, getWhere());
        }
        for (int i2 = 0; i2 < this.orderBy_.size(); i2++) {
            size2 += CodedOutputStream.computeMessageSize(4, (MessageLite) this.orderBy_.get(i2));
        }
        if (this.limit_ != null) {
            size2 += CodedOutputStream.computeMessageSize(5, getLimit());
        }
        int i3 = this.offset_;
        if (i3 != 0) {
            size2 += CodedOutputStream.computeInt32Size(6, i3);
        }
        if (this.startAt_ != null) {
            size2 += CodedOutputStream.computeMessageSize(7, getStartAt());
        }
        if (this.endAt_ != null) {
            size2 += CodedOutputStream.computeMessageSize(8, getEndAt());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static StructuredQuery parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (StructuredQuery) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static StructuredQuery parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (StructuredQuery) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static StructuredQuery parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (StructuredQuery) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static StructuredQuery parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (StructuredQuery) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static StructuredQuery parseFrom(InputStream input) throws IOException {
        return (StructuredQuery) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static StructuredQuery parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (StructuredQuery) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static StructuredQuery parseDelimitedFrom(InputStream input) throws IOException {
        return (StructuredQuery) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static StructuredQuery parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (StructuredQuery) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static StructuredQuery parseFrom(CodedInputStream input) throws IOException {
        return (StructuredQuery) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static StructuredQuery parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (StructuredQuery) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(StructuredQuery prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<StructuredQuery, Builder> implements StructuredQueryOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(StructuredQuery.DEFAULT_INSTANCE);
        }

        public boolean hasSelect() {
            return ((StructuredQuery) this.instance).hasSelect();
        }

        public Projection getSelect() {
            return ((StructuredQuery) this.instance).getSelect();
        }

        public Builder setSelect(Projection value) {
            copyOnWrite();
            ((StructuredQuery) this.instance).setSelect(value);
            return this;
        }

        public Builder setSelect(Projection.Builder builderForValue) {
            copyOnWrite();
            ((StructuredQuery) this.instance).setSelect(builderForValue);
            return this;
        }

        public Builder mergeSelect(Projection value) {
            copyOnWrite();
            ((StructuredQuery) this.instance).mergeSelect(value);
            return this;
        }

        public Builder clearSelect() {
            copyOnWrite();
            ((StructuredQuery) this.instance).clearSelect();
            return this;
        }

        public List<CollectionSelector> getFromList() {
            return Collections.unmodifiableList(((StructuredQuery) this.instance).getFromList());
        }

        public int getFromCount() {
            return ((StructuredQuery) this.instance).getFromCount();
        }

        public CollectionSelector getFrom(int index) {
            return ((StructuredQuery) this.instance).getFrom(index);
        }

        public Builder setFrom(int index, CollectionSelector value) {
            copyOnWrite();
            ((StructuredQuery) this.instance).setFrom(index, value);
            return this;
        }

        public Builder setFrom(int index, CollectionSelector.Builder builderForValue) {
            copyOnWrite();
            ((StructuredQuery) this.instance).setFrom(index, builderForValue);
            return this;
        }

        public Builder addFrom(CollectionSelector value) {
            copyOnWrite();
            ((StructuredQuery) this.instance).addFrom(value);
            return this;
        }

        public Builder addFrom(int index, CollectionSelector value) {
            copyOnWrite();
            ((StructuredQuery) this.instance).addFrom(index, value);
            return this;
        }

        public Builder addFrom(CollectionSelector.Builder builderForValue) {
            copyOnWrite();
            ((StructuredQuery) this.instance).addFrom(builderForValue);
            return this;
        }

        public Builder addFrom(int index, CollectionSelector.Builder builderForValue) {
            copyOnWrite();
            ((StructuredQuery) this.instance).addFrom(index, builderForValue);
            return this;
        }

        public Builder addAllFrom(Iterable<? extends CollectionSelector> values) {
            copyOnWrite();
            ((StructuredQuery) this.instance).addAllFrom(values);
            return this;
        }

        public Builder clearFrom() {
            copyOnWrite();
            ((StructuredQuery) this.instance).clearFrom();
            return this;
        }

        public Builder removeFrom(int index) {
            copyOnWrite();
            ((StructuredQuery) this.instance).removeFrom(index);
            return this;
        }

        public boolean hasWhere() {
            return ((StructuredQuery) this.instance).hasWhere();
        }

        public Filter getWhere() {
            return ((StructuredQuery) this.instance).getWhere();
        }

        public Builder setWhere(Filter value) {
            copyOnWrite();
            ((StructuredQuery) this.instance).setWhere(value);
            return this;
        }

        public Builder setWhere(Filter.Builder builderForValue) {
            copyOnWrite();
            ((StructuredQuery) this.instance).setWhere(builderForValue);
            return this;
        }

        public Builder mergeWhere(Filter value) {
            copyOnWrite();
            ((StructuredQuery) this.instance).mergeWhere(value);
            return this;
        }

        public Builder clearWhere() {
            copyOnWrite();
            ((StructuredQuery) this.instance).clearWhere();
            return this;
        }

        public List<Order> getOrderByList() {
            return Collections.unmodifiableList(((StructuredQuery) this.instance).getOrderByList());
        }

        public int getOrderByCount() {
            return ((StructuredQuery) this.instance).getOrderByCount();
        }

        public Order getOrderBy(int index) {
            return ((StructuredQuery) this.instance).getOrderBy(index);
        }

        public Builder setOrderBy(int index, Order value) {
            copyOnWrite();
            ((StructuredQuery) this.instance).setOrderBy(index, value);
            return this;
        }

        public Builder setOrderBy(int index, Order.Builder builderForValue) {
            copyOnWrite();
            ((StructuredQuery) this.instance).setOrderBy(index, builderForValue);
            return this;
        }

        public Builder addOrderBy(Order value) {
            copyOnWrite();
            ((StructuredQuery) this.instance).addOrderBy(value);
            return this;
        }

        public Builder addOrderBy(int index, Order value) {
            copyOnWrite();
            ((StructuredQuery) this.instance).addOrderBy(index, value);
            return this;
        }

        public Builder addOrderBy(Order.Builder builderForValue) {
            copyOnWrite();
            ((StructuredQuery) this.instance).addOrderBy(builderForValue);
            return this;
        }

        public Builder addOrderBy(int index, Order.Builder builderForValue) {
            copyOnWrite();
            ((StructuredQuery) this.instance).addOrderBy(index, builderForValue);
            return this;
        }

        public Builder addAllOrderBy(Iterable<? extends Order> values) {
            copyOnWrite();
            ((StructuredQuery) this.instance).addAllOrderBy(values);
            return this;
        }

        public Builder clearOrderBy() {
            copyOnWrite();
            ((StructuredQuery) this.instance).clearOrderBy();
            return this;
        }

        public Builder removeOrderBy(int index) {
            copyOnWrite();
            ((StructuredQuery) this.instance).removeOrderBy(index);
            return this;
        }

        public boolean hasStartAt() {
            return ((StructuredQuery) this.instance).hasStartAt();
        }

        public Cursor getStartAt() {
            return ((StructuredQuery) this.instance).getStartAt();
        }

        public Builder setStartAt(Cursor value) {
            copyOnWrite();
            ((StructuredQuery) this.instance).setStartAt(value);
            return this;
        }

        public Builder setStartAt(Cursor.Builder builderForValue) {
            copyOnWrite();
            ((StructuredQuery) this.instance).setStartAt(builderForValue);
            return this;
        }

        public Builder mergeStartAt(Cursor value) {
            copyOnWrite();
            ((StructuredQuery) this.instance).mergeStartAt(value);
            return this;
        }

        public Builder clearStartAt() {
            copyOnWrite();
            ((StructuredQuery) this.instance).clearStartAt();
            return this;
        }

        public boolean hasEndAt() {
            return ((StructuredQuery) this.instance).hasEndAt();
        }

        public Cursor getEndAt() {
            return ((StructuredQuery) this.instance).getEndAt();
        }

        public Builder setEndAt(Cursor value) {
            copyOnWrite();
            ((StructuredQuery) this.instance).setEndAt(value);
            return this;
        }

        public Builder setEndAt(Cursor.Builder builderForValue) {
            copyOnWrite();
            ((StructuredQuery) this.instance).setEndAt(builderForValue);
            return this;
        }

        public Builder mergeEndAt(Cursor value) {
            copyOnWrite();
            ((StructuredQuery) this.instance).mergeEndAt(value);
            return this;
        }

        public Builder clearEndAt() {
            copyOnWrite();
            ((StructuredQuery) this.instance).clearEndAt();
            return this;
        }

        public int getOffset() {
            return ((StructuredQuery) this.instance).getOffset();
        }

        public Builder setOffset(int value) {
            copyOnWrite();
            ((StructuredQuery) this.instance).setOffset(value);
            return this;
        }

        public Builder clearOffset() {
            copyOnWrite();
            ((StructuredQuery) this.instance).clearOffset();
            return this;
        }

        public boolean hasLimit() {
            return ((StructuredQuery) this.instance).hasLimit();
        }

        public Int32Value getLimit() {
            return ((StructuredQuery) this.instance).getLimit();
        }

        public Builder setLimit(Int32Value value) {
            copyOnWrite();
            ((StructuredQuery) this.instance).setLimit(value);
            return this;
        }

        public Builder setLimit(Int32Value.Builder builderForValue) {
            copyOnWrite();
            ((StructuredQuery) this.instance).setLimit(builderForValue);
            return this;
        }

        public Builder mergeLimit(Int32Value value) {
            copyOnWrite();
            ((StructuredQuery) this.instance).mergeLimit(value);
            return this;
        }

        public Builder clearLimit() {
            copyOnWrite();
            ((StructuredQuery) this.instance).clearLimit();
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
            case 1:
                return new StructuredQuery();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.from_.makeImmutable();
                this.orderBy_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                StructuredQuery other = (StructuredQuery) arg1;
                this.select_ = (Projection) visitor.visitMessage(this.select_, other.select_);
                this.from_ = visitor.visitList(this.from_, other.from_);
                this.where_ = (Filter) visitor.visitMessage(this.where_, other.where_);
                this.orderBy_ = visitor.visitList(this.orderBy_, other.orderBy_);
                this.startAt_ = (Cursor) visitor.visitMessage(this.startAt_, other.startAt_);
                this.endAt_ = (Cursor) visitor.visitMessage(this.endAt_, other.endAt_);
                boolean z = true;
                boolean z2 = this.offset_ != 0;
                int i = this.offset_;
                if (other.offset_ == 0) {
                    z = false;
                }
                this.offset_ = visitor.visitInt(z2, i, z, other.offset_);
                this.limit_ = (Int32Value) visitor.visitMessage(this.limit_, other.limit_);
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
                            Projection.Builder subBuilder = null;
                            if (this.select_ != null) {
                                subBuilder = (Projection.Builder) this.select_.toBuilder();
                            }
                            Projection projection = (Projection) input.readMessage(Projection.parser(), extensionRegistry);
                            this.select_ = projection;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(projection);
                                this.select_ = (Projection) subBuilder.buildPartial();
                            }
                        } else if (tag == 18) {
                            if (!this.from_.isModifiable()) {
                                this.from_ = GeneratedMessageLite.mutableCopy(this.from_);
                            }
                            this.from_.add((CollectionSelector) input.readMessage(CollectionSelector.parser(), extensionRegistry));
                        } else if (tag == 26) {
                            Filter.Builder subBuilder2 = null;
                            if (this.where_ != null) {
                                subBuilder2 = (Filter.Builder) this.where_.toBuilder();
                            }
                            Filter filter = (Filter) input.readMessage(Filter.parser(), extensionRegistry);
                            this.where_ = filter;
                            if (subBuilder2 != null) {
                                subBuilder2.mergeFrom(filter);
                                this.where_ = (Filter) subBuilder2.buildPartial();
                            }
                        } else if (tag == 34) {
                            if (!this.orderBy_.isModifiable()) {
                                this.orderBy_ = GeneratedMessageLite.mutableCopy(this.orderBy_);
                            }
                            this.orderBy_.add((Order) input.readMessage(Order.parser(), extensionRegistry));
                        } else if (tag == 42) {
                            Int32Value.Builder subBuilder3 = null;
                            if (this.limit_ != null) {
                                subBuilder3 = (Int32Value.Builder) this.limit_.toBuilder();
                            }
                            Int32Value int32Value = (Int32Value) input.readMessage(Int32Value.parser(), extensionRegistry);
                            this.limit_ = int32Value;
                            if (subBuilder3 != null) {
                                subBuilder3.mergeFrom(int32Value);
                                this.limit_ = (Int32Value) subBuilder3.buildPartial();
                            }
                        } else if (tag == 48) {
                            this.offset_ = input.readInt32();
                        } else if (tag == 58) {
                            Cursor.Builder subBuilder4 = null;
                            if (this.startAt_ != null) {
                                subBuilder4 = (Cursor.Builder) this.startAt_.toBuilder();
                            }
                            Cursor cursor = (Cursor) input.readMessage(Cursor.parser(), extensionRegistry);
                            this.startAt_ = cursor;
                            if (subBuilder4 != null) {
                                subBuilder4.mergeFrom(cursor);
                                this.startAt_ = (Cursor) subBuilder4.buildPartial();
                            }
                        } else if (tag == 66) {
                            Cursor.Builder subBuilder5 = null;
                            if (this.endAt_ != null) {
                                subBuilder5 = (Cursor.Builder) this.endAt_.toBuilder();
                            }
                            Cursor cursor2 = (Cursor) input.readMessage(Cursor.parser(), extensionRegistry);
                            this.endAt_ = cursor2;
                            if (subBuilder5 != null) {
                                subBuilder5.mergeFrom(cursor2);
                                this.endAt_ = (Cursor) subBuilder5.buildPartial();
                            }
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
                    synchronized (StructuredQuery.class) {
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
        StructuredQuery structuredQuery = new StructuredQuery();
        DEFAULT_INSTANCE = structuredQuery;
        structuredQuery.makeImmutable();
    }

    public static StructuredQuery getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<StructuredQuery> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
