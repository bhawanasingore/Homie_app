package com.google.rpc;

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
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class BadRequest extends GeneratedMessageLite<BadRequest, Builder> implements BadRequestOrBuilder {
    /* access modifiers changed from: private */
    public static final BadRequest DEFAULT_INSTANCE;
    public static final int FIELD_VIOLATIONS_FIELD_NUMBER = 1;
    private static volatile Parser<BadRequest> PARSER;
    private Internal.ProtobufList<FieldViolation> fieldViolations_ = emptyProtobufList();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface FieldViolationOrBuilder extends MessageLiteOrBuilder {
        String getDescription();

        ByteString getDescriptionBytes();

        String getField();

        ByteString getFieldBytes();
    }

    private BadRequest() {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class FieldViolation extends GeneratedMessageLite<FieldViolation, Builder> implements FieldViolationOrBuilder {
        /* access modifiers changed from: private */
        public static final FieldViolation DEFAULT_INSTANCE;
        public static final int DESCRIPTION_FIELD_NUMBER = 2;
        public static final int FIELD_FIELD_NUMBER = 1;
        private static volatile Parser<FieldViolation> PARSER;
        private String description_ = "";
        private String field_ = "";

        private FieldViolation() {
        }

        public String getField() {
            return this.field_;
        }

        public ByteString getFieldBytes() {
            return ByteString.copyFromUtf8(this.field_);
        }

        /* access modifiers changed from: private */
        public void setField(String value) {
            if (value != null) {
                this.field_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearField() {
            this.field_ = getDefaultInstance().getField();
        }

        /* access modifiers changed from: private */
        public void setFieldBytes(ByteString value) {
            if (value != null) {
                checkByteStringIsUtf8(value);
                this.field_ = value.toStringUtf8();
                return;
            }
            throw null;
        }

        public String getDescription() {
            return this.description_;
        }

        public ByteString getDescriptionBytes() {
            return ByteString.copyFromUtf8(this.description_);
        }

        /* access modifiers changed from: private */
        public void setDescription(String value) {
            if (value != null) {
                this.description_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearDescription() {
            this.description_ = getDefaultInstance().getDescription();
        }

        /* access modifiers changed from: private */
        public void setDescriptionBytes(ByteString value) {
            if (value != null) {
                checkByteStringIsUtf8(value);
                this.description_ = value.toStringUtf8();
                return;
            }
            throw null;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (!this.field_.isEmpty()) {
                output.writeString(1, getField());
            }
            if (!this.description_.isEmpty()) {
                output.writeString(2, getDescription());
            }
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (!this.field_.isEmpty()) {
                size2 = 0 + CodedOutputStream.computeStringSize(1, getField());
            }
            if (!this.description_.isEmpty()) {
                size2 += CodedOutputStream.computeStringSize(2, getDescription());
            }
            this.memoizedSerializedSize = size2;
            return size2;
        }

        public static FieldViolation parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FieldViolation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FieldViolation parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FieldViolation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FieldViolation parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FieldViolation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FieldViolation parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FieldViolation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FieldViolation parseFrom(InputStream input) throws IOException {
            return (FieldViolation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FieldViolation parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FieldViolation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FieldViolation parseDelimitedFrom(InputStream input) throws IOException {
            return (FieldViolation) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static FieldViolation parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FieldViolation) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FieldViolation parseFrom(CodedInputStream input) throws IOException {
            return (FieldViolation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FieldViolation parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FieldViolation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FieldViolation prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<FieldViolation, Builder> implements FieldViolationOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(FieldViolation.DEFAULT_INSTANCE);
            }

            public String getField() {
                return ((FieldViolation) this.instance).getField();
            }

            public ByteString getFieldBytes() {
                return ((FieldViolation) this.instance).getFieldBytes();
            }

            public Builder setField(String value) {
                copyOnWrite();
                ((FieldViolation) this.instance).setField(value);
                return this;
            }

            public Builder clearField() {
                copyOnWrite();
                ((FieldViolation) this.instance).clearField();
                return this;
            }

            public Builder setFieldBytes(ByteString value) {
                copyOnWrite();
                ((FieldViolation) this.instance).setFieldBytes(value);
                return this;
            }

            public String getDescription() {
                return ((FieldViolation) this.instance).getDescription();
            }

            public ByteString getDescriptionBytes() {
                return ((FieldViolation) this.instance).getDescriptionBytes();
            }

            public Builder setDescription(String value) {
                copyOnWrite();
                ((FieldViolation) this.instance).setDescription(value);
                return this;
            }

            public Builder clearDescription() {
                copyOnWrite();
                ((FieldViolation) this.instance).clearDescription();
                return this;
            }

            public Builder setDescriptionBytes(ByteString value) {
                copyOnWrite();
                ((FieldViolation) this.instance).setDescriptionBytes(value);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new FieldViolation();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    FieldViolation other = (FieldViolation) arg1;
                    this.field_ = visitor.visitString(!this.field_.isEmpty(), this.field_, !other.field_.isEmpty(), other.field_);
                    this.description_ = visitor.visitString(!this.description_.isEmpty(), this.description_, !other.description_.isEmpty(), other.description_);
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
                                this.field_ = input.readStringRequireUtf8();
                            } else if (tag == 18) {
                                this.description_ = input.readStringRequireUtf8();
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
                        synchronized (FieldViolation.class) {
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
            FieldViolation fieldViolation = new FieldViolation();
            DEFAULT_INSTANCE = fieldViolation;
            fieldViolation.makeImmutable();
        }

        public static FieldViolation getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FieldViolation> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.google.rpc.BadRequest$1  reason: invalid class name */
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

    public List<FieldViolation> getFieldViolationsList() {
        return this.fieldViolations_;
    }

    public List<? extends FieldViolationOrBuilder> getFieldViolationsOrBuilderList() {
        return this.fieldViolations_;
    }

    public int getFieldViolationsCount() {
        return this.fieldViolations_.size();
    }

    public FieldViolation getFieldViolations(int index) {
        return (FieldViolation) this.fieldViolations_.get(index);
    }

    public FieldViolationOrBuilder getFieldViolationsOrBuilder(int index) {
        return (FieldViolationOrBuilder) this.fieldViolations_.get(index);
    }

    private void ensureFieldViolationsIsMutable() {
        if (!this.fieldViolations_.isModifiable()) {
            this.fieldViolations_ = GeneratedMessageLite.mutableCopy(this.fieldViolations_);
        }
    }

    /* access modifiers changed from: private */
    public void setFieldViolations(int index, FieldViolation value) {
        if (value != null) {
            ensureFieldViolationsIsMutable();
            this.fieldViolations_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setFieldViolations(int index, FieldViolation.Builder builderForValue) {
        ensureFieldViolationsIsMutable();
        this.fieldViolations_.set(index, (FieldViolation) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addFieldViolations(FieldViolation value) {
        if (value != null) {
            ensureFieldViolationsIsMutable();
            this.fieldViolations_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addFieldViolations(int index, FieldViolation value) {
        if (value != null) {
            ensureFieldViolationsIsMutable();
            this.fieldViolations_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addFieldViolations(FieldViolation.Builder builderForValue) {
        ensureFieldViolationsIsMutable();
        this.fieldViolations_.add((FieldViolation) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addFieldViolations(int index, FieldViolation.Builder builderForValue) {
        ensureFieldViolationsIsMutable();
        this.fieldViolations_.add(index, (FieldViolation) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllFieldViolations(Iterable<? extends FieldViolation> values) {
        ensureFieldViolationsIsMutable();
        AbstractMessageLite.addAll(values, this.fieldViolations_);
    }

    /* access modifiers changed from: private */
    public void clearFieldViolations() {
        this.fieldViolations_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeFieldViolations(int index) {
        ensureFieldViolationsIsMutable();
        this.fieldViolations_.remove(index);
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        for (int i = 0; i < this.fieldViolations_.size(); i++) {
            output.writeMessage(1, (MessageLite) this.fieldViolations_.get(i));
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        for (int i = 0; i < this.fieldViolations_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.fieldViolations_.get(i));
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static BadRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (BadRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static BadRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (BadRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static BadRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (BadRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static BadRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (BadRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static BadRequest parseFrom(InputStream input) throws IOException {
        return (BadRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static BadRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (BadRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static BadRequest parseDelimitedFrom(InputStream input) throws IOException {
        return (BadRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static BadRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (BadRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static BadRequest parseFrom(CodedInputStream input) throws IOException {
        return (BadRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static BadRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (BadRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(BadRequest prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<BadRequest, Builder> implements BadRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(BadRequest.DEFAULT_INSTANCE);
        }

        public List<FieldViolation> getFieldViolationsList() {
            return Collections.unmodifiableList(((BadRequest) this.instance).getFieldViolationsList());
        }

        public int getFieldViolationsCount() {
            return ((BadRequest) this.instance).getFieldViolationsCount();
        }

        public FieldViolation getFieldViolations(int index) {
            return ((BadRequest) this.instance).getFieldViolations(index);
        }

        public Builder setFieldViolations(int index, FieldViolation value) {
            copyOnWrite();
            ((BadRequest) this.instance).setFieldViolations(index, value);
            return this;
        }

        public Builder setFieldViolations(int index, FieldViolation.Builder builderForValue) {
            copyOnWrite();
            ((BadRequest) this.instance).setFieldViolations(index, builderForValue);
            return this;
        }

        public Builder addFieldViolations(FieldViolation value) {
            copyOnWrite();
            ((BadRequest) this.instance).addFieldViolations(value);
            return this;
        }

        public Builder addFieldViolations(int index, FieldViolation value) {
            copyOnWrite();
            ((BadRequest) this.instance).addFieldViolations(index, value);
            return this;
        }

        public Builder addFieldViolations(FieldViolation.Builder builderForValue) {
            copyOnWrite();
            ((BadRequest) this.instance).addFieldViolations(builderForValue);
            return this;
        }

        public Builder addFieldViolations(int index, FieldViolation.Builder builderForValue) {
            copyOnWrite();
            ((BadRequest) this.instance).addFieldViolations(index, builderForValue);
            return this;
        }

        public Builder addAllFieldViolations(Iterable<? extends FieldViolation> values) {
            copyOnWrite();
            ((BadRequest) this.instance).addAllFieldViolations(values);
            return this;
        }

        public Builder clearFieldViolations() {
            copyOnWrite();
            ((BadRequest) this.instance).clearFieldViolations();
            return this;
        }

        public Builder removeFieldViolations(int index) {
            copyOnWrite();
            ((BadRequest) this.instance).removeFieldViolations(index);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
            case 1:
                return new BadRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.fieldViolations_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                this.fieldViolations_ = ((GeneratedMessageLite.Visitor) arg0).visitList(this.fieldViolations_, ((BadRequest) arg1).fieldViolations_);
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
                            if (!this.fieldViolations_.isModifiable()) {
                                this.fieldViolations_ = GeneratedMessageLite.mutableCopy(this.fieldViolations_);
                            }
                            this.fieldViolations_.add((FieldViolation) input.readMessage(FieldViolation.parser(), extensionRegistry));
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
                    synchronized (BadRequest.class) {
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
        BadRequest badRequest = new BadRequest();
        DEFAULT_INSTANCE = badRequest;
        badRequest.makeImmutable();
    }

    public static BadRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<BadRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
