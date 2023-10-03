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
public final class PreconditionFailure extends GeneratedMessageLite<PreconditionFailure, Builder> implements PreconditionFailureOrBuilder {
    /* access modifiers changed from: private */
    public static final PreconditionFailure DEFAULT_INSTANCE;
    private static volatile Parser<PreconditionFailure> PARSER = null;
    public static final int VIOLATIONS_FIELD_NUMBER = 1;
    private Internal.ProtobufList<Violation> violations_ = emptyProtobufList();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface ViolationOrBuilder extends MessageLiteOrBuilder {
        String getDescription();

        ByteString getDescriptionBytes();

        String getSubject();

        ByteString getSubjectBytes();

        String getType();

        ByteString getTypeBytes();
    }

    private PreconditionFailure() {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Violation extends GeneratedMessageLite<Violation, Builder> implements ViolationOrBuilder {
        /* access modifiers changed from: private */
        public static final Violation DEFAULT_INSTANCE;
        public static final int DESCRIPTION_FIELD_NUMBER = 3;
        private static volatile Parser<Violation> PARSER = null;
        public static final int SUBJECT_FIELD_NUMBER = 2;
        public static final int TYPE_FIELD_NUMBER = 1;
        private String description_ = "";
        private String subject_ = "";
        private String type_ = "";

        private Violation() {
        }

        public String getType() {
            return this.type_;
        }

        public ByteString getTypeBytes() {
            return ByteString.copyFromUtf8(this.type_);
        }

        /* access modifiers changed from: private */
        public void setType(String value) {
            if (value != null) {
                this.type_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearType() {
            this.type_ = getDefaultInstance().getType();
        }

        /* access modifiers changed from: private */
        public void setTypeBytes(ByteString value) {
            if (value != null) {
                checkByteStringIsUtf8(value);
                this.type_ = value.toStringUtf8();
                return;
            }
            throw null;
        }

        public String getSubject() {
            return this.subject_;
        }

        public ByteString getSubjectBytes() {
            return ByteString.copyFromUtf8(this.subject_);
        }

        /* access modifiers changed from: private */
        public void setSubject(String value) {
            if (value != null) {
                this.subject_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearSubject() {
            this.subject_ = getDefaultInstance().getSubject();
        }

        /* access modifiers changed from: private */
        public void setSubjectBytes(ByteString value) {
            if (value != null) {
                checkByteStringIsUtf8(value);
                this.subject_ = value.toStringUtf8();
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
            if (!this.type_.isEmpty()) {
                output.writeString(1, getType());
            }
            if (!this.subject_.isEmpty()) {
                output.writeString(2, getSubject());
            }
            if (!this.description_.isEmpty()) {
                output.writeString(3, getDescription());
            }
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (!this.type_.isEmpty()) {
                size2 = 0 + CodedOutputStream.computeStringSize(1, getType());
            }
            if (!this.subject_.isEmpty()) {
                size2 += CodedOutputStream.computeStringSize(2, getSubject());
            }
            if (!this.description_.isEmpty()) {
                size2 += CodedOutputStream.computeStringSize(3, getDescription());
            }
            this.memoizedSerializedSize = size2;
            return size2;
        }

        public static Violation parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Violation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Violation parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Violation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Violation parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Violation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Violation parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Violation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Violation parseFrom(InputStream input) throws IOException {
            return (Violation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Violation parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Violation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Violation parseDelimitedFrom(InputStream input) throws IOException {
            return (Violation) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static Violation parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Violation) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Violation parseFrom(CodedInputStream input) throws IOException {
            return (Violation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Violation parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Violation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Violation prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<Violation, Builder> implements ViolationOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(Violation.DEFAULT_INSTANCE);
            }

            public String getType() {
                return ((Violation) this.instance).getType();
            }

            public ByteString getTypeBytes() {
                return ((Violation) this.instance).getTypeBytes();
            }

            public Builder setType(String value) {
                copyOnWrite();
                ((Violation) this.instance).setType(value);
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                ((Violation) this.instance).clearType();
                return this;
            }

            public Builder setTypeBytes(ByteString value) {
                copyOnWrite();
                ((Violation) this.instance).setTypeBytes(value);
                return this;
            }

            public String getSubject() {
                return ((Violation) this.instance).getSubject();
            }

            public ByteString getSubjectBytes() {
                return ((Violation) this.instance).getSubjectBytes();
            }

            public Builder setSubject(String value) {
                copyOnWrite();
                ((Violation) this.instance).setSubject(value);
                return this;
            }

            public Builder clearSubject() {
                copyOnWrite();
                ((Violation) this.instance).clearSubject();
                return this;
            }

            public Builder setSubjectBytes(ByteString value) {
                copyOnWrite();
                ((Violation) this.instance).setSubjectBytes(value);
                return this;
            }

            public String getDescription() {
                return ((Violation) this.instance).getDescription();
            }

            public ByteString getDescriptionBytes() {
                return ((Violation) this.instance).getDescriptionBytes();
            }

            public Builder setDescription(String value) {
                copyOnWrite();
                ((Violation) this.instance).setDescription(value);
                return this;
            }

            public Builder clearDescription() {
                copyOnWrite();
                ((Violation) this.instance).clearDescription();
                return this;
            }

            public Builder setDescriptionBytes(ByteString value) {
                copyOnWrite();
                ((Violation) this.instance).setDescriptionBytes(value);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new Violation();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    Violation other = (Violation) arg1;
                    this.type_ = visitor.visitString(!this.type_.isEmpty(), this.type_, !other.type_.isEmpty(), other.type_);
                    this.subject_ = visitor.visitString(!this.subject_.isEmpty(), this.subject_, !other.subject_.isEmpty(), other.subject_);
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
                                this.type_ = input.readStringRequireUtf8();
                            } else if (tag == 18) {
                                this.subject_ = input.readStringRequireUtf8();
                            } else if (tag == 26) {
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
                        synchronized (Violation.class) {
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
            Violation violation = new Violation();
            DEFAULT_INSTANCE = violation;
            violation.makeImmutable();
        }

        public static Violation getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Violation> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.google.rpc.PreconditionFailure$1  reason: invalid class name */
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

    public List<Violation> getViolationsList() {
        return this.violations_;
    }

    public List<? extends ViolationOrBuilder> getViolationsOrBuilderList() {
        return this.violations_;
    }

    public int getViolationsCount() {
        return this.violations_.size();
    }

    public Violation getViolations(int index) {
        return (Violation) this.violations_.get(index);
    }

    public ViolationOrBuilder getViolationsOrBuilder(int index) {
        return (ViolationOrBuilder) this.violations_.get(index);
    }

    private void ensureViolationsIsMutable() {
        if (!this.violations_.isModifiable()) {
            this.violations_ = GeneratedMessageLite.mutableCopy(this.violations_);
        }
    }

    /* access modifiers changed from: private */
    public void setViolations(int index, Violation value) {
        if (value != null) {
            ensureViolationsIsMutable();
            this.violations_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setViolations(int index, Violation.Builder builderForValue) {
        ensureViolationsIsMutable();
        this.violations_.set(index, (Violation) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addViolations(Violation value) {
        if (value != null) {
            ensureViolationsIsMutable();
            this.violations_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addViolations(int index, Violation value) {
        if (value != null) {
            ensureViolationsIsMutable();
            this.violations_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addViolations(Violation.Builder builderForValue) {
        ensureViolationsIsMutable();
        this.violations_.add((Violation) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addViolations(int index, Violation.Builder builderForValue) {
        ensureViolationsIsMutable();
        this.violations_.add(index, (Violation) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllViolations(Iterable<? extends Violation> values) {
        ensureViolationsIsMutable();
        AbstractMessageLite.addAll(values, this.violations_);
    }

    /* access modifiers changed from: private */
    public void clearViolations() {
        this.violations_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeViolations(int index) {
        ensureViolationsIsMutable();
        this.violations_.remove(index);
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        for (int i = 0; i < this.violations_.size(); i++) {
            output.writeMessage(1, (MessageLite) this.violations_.get(i));
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        for (int i = 0; i < this.violations_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.violations_.get(i));
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static PreconditionFailure parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (PreconditionFailure) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static PreconditionFailure parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (PreconditionFailure) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static PreconditionFailure parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (PreconditionFailure) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static PreconditionFailure parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (PreconditionFailure) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static PreconditionFailure parseFrom(InputStream input) throws IOException {
        return (PreconditionFailure) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static PreconditionFailure parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (PreconditionFailure) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static PreconditionFailure parseDelimitedFrom(InputStream input) throws IOException {
        return (PreconditionFailure) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static PreconditionFailure parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (PreconditionFailure) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static PreconditionFailure parseFrom(CodedInputStream input) throws IOException {
        return (PreconditionFailure) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static PreconditionFailure parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (PreconditionFailure) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(PreconditionFailure prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<PreconditionFailure, Builder> implements PreconditionFailureOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(PreconditionFailure.DEFAULT_INSTANCE);
        }

        public List<Violation> getViolationsList() {
            return Collections.unmodifiableList(((PreconditionFailure) this.instance).getViolationsList());
        }

        public int getViolationsCount() {
            return ((PreconditionFailure) this.instance).getViolationsCount();
        }

        public Violation getViolations(int index) {
            return ((PreconditionFailure) this.instance).getViolations(index);
        }

        public Builder setViolations(int index, Violation value) {
            copyOnWrite();
            ((PreconditionFailure) this.instance).setViolations(index, value);
            return this;
        }

        public Builder setViolations(int index, Violation.Builder builderForValue) {
            copyOnWrite();
            ((PreconditionFailure) this.instance).setViolations(index, builderForValue);
            return this;
        }

        public Builder addViolations(Violation value) {
            copyOnWrite();
            ((PreconditionFailure) this.instance).addViolations(value);
            return this;
        }

        public Builder addViolations(int index, Violation value) {
            copyOnWrite();
            ((PreconditionFailure) this.instance).addViolations(index, value);
            return this;
        }

        public Builder addViolations(Violation.Builder builderForValue) {
            copyOnWrite();
            ((PreconditionFailure) this.instance).addViolations(builderForValue);
            return this;
        }

        public Builder addViolations(int index, Violation.Builder builderForValue) {
            copyOnWrite();
            ((PreconditionFailure) this.instance).addViolations(index, builderForValue);
            return this;
        }

        public Builder addAllViolations(Iterable<? extends Violation> values) {
            copyOnWrite();
            ((PreconditionFailure) this.instance).addAllViolations(values);
            return this;
        }

        public Builder clearViolations() {
            copyOnWrite();
            ((PreconditionFailure) this.instance).clearViolations();
            return this;
        }

        public Builder removeViolations(int index) {
            copyOnWrite();
            ((PreconditionFailure) this.instance).removeViolations(index);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
            case 1:
                return new PreconditionFailure();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.violations_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                this.violations_ = ((GeneratedMessageLite.Visitor) arg0).visitList(this.violations_, ((PreconditionFailure) arg1).violations_);
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
                            if (!this.violations_.isModifiable()) {
                                this.violations_ = GeneratedMessageLite.mutableCopy(this.violations_);
                            }
                            this.violations_.add((Violation) input.readMessage(Violation.parser(), extensionRegistry));
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
                    synchronized (PreconditionFailure.class) {
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
        PreconditionFailure preconditionFailure = new PreconditionFailure();
        DEFAULT_INSTANCE = preconditionFailure;
        preconditionFailure.makeImmutable();
    }

    public static PreconditionFailure getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<PreconditionFailure> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
