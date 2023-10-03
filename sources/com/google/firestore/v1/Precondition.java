package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public final class Precondition extends GeneratedMessageLite<Precondition, Builder> implements PreconditionOrBuilder {
    /* access modifiers changed from: private */
    public static final Precondition DEFAULT_INSTANCE;
    public static final int EXISTS_FIELD_NUMBER = 1;
    private static volatile Parser<Precondition> PARSER = null;
    public static final int UPDATE_TIME_FIELD_NUMBER = 2;
    private int conditionTypeCase_ = 0;
    private Object conditionType_;

    private Precondition() {
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public enum ConditionTypeCase implements Internal.EnumLite {
        EXISTS(1),
        UPDATE_TIME(2),
        CONDITIONTYPE_NOT_SET(0);
        
        private final int value;

        private ConditionTypeCase(int value2) {
            this.value = value2;
        }

        @Deprecated
        public static ConditionTypeCase valueOf(int value2) {
            return forNumber(value2);
        }

        public static ConditionTypeCase forNumber(int value2) {
            if (value2 == 0) {
                return CONDITIONTYPE_NOT_SET;
            }
            if (value2 == 1) {
                return EXISTS;
            }
            if (value2 != 2) {
                return null;
            }
            return UPDATE_TIME;
        }

        public int getNumber() {
            return this.value;
        }
    }

    public ConditionTypeCase getConditionTypeCase() {
        return ConditionTypeCase.forNumber(this.conditionTypeCase_);
    }

    /* access modifiers changed from: private */
    public void clearConditionType() {
        this.conditionTypeCase_ = 0;
        this.conditionType_ = null;
    }

    public boolean getExists() {
        if (this.conditionTypeCase_ == 1) {
            return ((Boolean) this.conditionType_).booleanValue();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void setExists(boolean value) {
        this.conditionTypeCase_ = 1;
        this.conditionType_ = Boolean.valueOf(value);
    }

    /* access modifiers changed from: private */
    public void clearExists() {
        if (this.conditionTypeCase_ == 1) {
            this.conditionTypeCase_ = 0;
            this.conditionType_ = null;
        }
    }

    public Timestamp getUpdateTime() {
        if (this.conditionTypeCase_ == 2) {
            return (Timestamp) this.conditionType_;
        }
        return Timestamp.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setUpdateTime(Timestamp value) {
        if (value != null) {
            this.conditionType_ = value;
            this.conditionTypeCase_ = 2;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setUpdateTime(Timestamp.Builder builderForValue) {
        this.conditionType_ = builderForValue.build();
        this.conditionTypeCase_ = 2;
    }

    /* access modifiers changed from: private */
    public void mergeUpdateTime(Timestamp value) {
        if (this.conditionTypeCase_ != 2 || this.conditionType_ == Timestamp.getDefaultInstance()) {
            this.conditionType_ = value;
        } else {
            this.conditionType_ = ((Timestamp.Builder) Timestamp.newBuilder((Timestamp) this.conditionType_).mergeFrom(value)).buildPartial();
        }
        this.conditionTypeCase_ = 2;
    }

    /* access modifiers changed from: private */
    public void clearUpdateTime() {
        if (this.conditionTypeCase_ == 2) {
            this.conditionTypeCase_ = 0;
            this.conditionType_ = null;
        }
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (this.conditionTypeCase_ == 1) {
            output.writeBool(1, ((Boolean) this.conditionType_).booleanValue());
        }
        if (this.conditionTypeCase_ == 2) {
            output.writeMessage(2, (Timestamp) this.conditionType_);
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (this.conditionTypeCase_ == 1) {
            size2 = 0 + CodedOutputStream.computeBoolSize(1, ((Boolean) this.conditionType_).booleanValue());
        }
        if (this.conditionTypeCase_ == 2) {
            size2 += CodedOutputStream.computeMessageSize(2, (Timestamp) this.conditionType_);
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Precondition parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Precondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Precondition parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Precondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Precondition parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Precondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Precondition parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Precondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Precondition parseFrom(InputStream input) throws IOException {
        return (Precondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Precondition parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Precondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Precondition parseDelimitedFrom(InputStream input) throws IOException {
        return (Precondition) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Precondition parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Precondition) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Precondition parseFrom(CodedInputStream input) throws IOException {
        return (Precondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Precondition parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Precondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Precondition prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<Precondition, Builder> implements PreconditionOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Precondition.DEFAULT_INSTANCE);
        }

        public ConditionTypeCase getConditionTypeCase() {
            return ((Precondition) this.instance).getConditionTypeCase();
        }

        public Builder clearConditionType() {
            copyOnWrite();
            ((Precondition) this.instance).clearConditionType();
            return this;
        }

        public boolean getExists() {
            return ((Precondition) this.instance).getExists();
        }

        public Builder setExists(boolean value) {
            copyOnWrite();
            ((Precondition) this.instance).setExists(value);
            return this;
        }

        public Builder clearExists() {
            copyOnWrite();
            ((Precondition) this.instance).clearExists();
            return this;
        }

        public Timestamp getUpdateTime() {
            return ((Precondition) this.instance).getUpdateTime();
        }

        public Builder setUpdateTime(Timestamp value) {
            copyOnWrite();
            ((Precondition) this.instance).setUpdateTime(value);
            return this;
        }

        public Builder setUpdateTime(Timestamp.Builder builderForValue) {
            copyOnWrite();
            ((Precondition) this.instance).setUpdateTime(builderForValue);
            return this;
        }

        public Builder mergeUpdateTime(Timestamp value) {
            copyOnWrite();
            ((Precondition) this.instance).mergeUpdateTime(value);
            return this;
        }

        public Builder clearUpdateTime() {
            copyOnWrite();
            ((Precondition) this.instance).clearUpdateTime();
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.Precondition$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$Precondition$ConditionTypeCase;
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
            int[] iArr2 = new int[ConditionTypeCase.values().length];
            $SwitchMap$com$google$firestore$v1$Precondition$ConditionTypeCase = iArr2;
            try {
                iArr2[ConditionTypeCase.EXISTS.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Precondition$ConditionTypeCase[ConditionTypeCase.UPDATE_TIME.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Precondition$ConditionTypeCase[ConditionTypeCase.CONDITIONTYPE_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        int i;
        boolean z = true;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
            case 1:
                return new Precondition();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                Precondition other = (Precondition) arg1;
                int i2 = AnonymousClass1.$SwitchMap$com$google$firestore$v1$Precondition$ConditionTypeCase[other.getConditionTypeCase().ordinal()];
                if (i2 == 1) {
                    if (this.conditionTypeCase_ != 1) {
                        z = false;
                    }
                    this.conditionType_ = visitor.visitOneofBoolean(z, this.conditionType_, other.conditionType_);
                } else if (i2 == 2) {
                    if (this.conditionTypeCase_ != 2) {
                        z = false;
                    }
                    this.conditionType_ = visitor.visitOneofMessage(z, this.conditionType_, other.conditionType_);
                } else if (i2 == 3) {
                    if (this.conditionTypeCase_ == 0) {
                        z = false;
                    }
                    visitor.visitOneofNotSet(z);
                }
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE && (i = other.conditionTypeCase_) != 0) {
                    this.conditionTypeCase_ = i;
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
                            this.conditionTypeCase_ = 1;
                            this.conditionType_ = Boolean.valueOf(input.readBool());
                        } else if (tag == 18) {
                            Timestamp.Builder subBuilder = null;
                            if (this.conditionTypeCase_ == 2) {
                                subBuilder = (Timestamp.Builder) ((Timestamp) this.conditionType_).toBuilder();
                            }
                            MessageLite readMessage = input.readMessage(Timestamp.parser(), extensionRegistry);
                            this.conditionType_ = readMessage;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom((Timestamp) readMessage);
                                this.conditionType_ = subBuilder.buildPartial();
                            }
                            this.conditionTypeCase_ = 2;
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
                    synchronized (Precondition.class) {
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
        Precondition precondition = new Precondition();
        DEFAULT_INSTANCE = precondition;
        precondition.makeImmutable();
    }

    public static Precondition getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Precondition> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
