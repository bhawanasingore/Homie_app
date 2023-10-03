package com.google.firestore.v1;

import com.google.firestore.v1.Value;
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
public final class Cursor extends GeneratedMessageLite<Cursor, Builder> implements CursorOrBuilder {
    public static final int BEFORE_FIELD_NUMBER = 2;
    /* access modifiers changed from: private */
    public static final Cursor DEFAULT_INSTANCE;
    private static volatile Parser<Cursor> PARSER = null;
    public static final int VALUES_FIELD_NUMBER = 1;
    private boolean before_;
    private int bitField0_;
    private Internal.ProtobufList<Value> values_ = emptyProtobufList();

    private Cursor() {
    }

    public List<Value> getValuesList() {
        return this.values_;
    }

    public List<? extends ValueOrBuilder> getValuesOrBuilderList() {
        return this.values_;
    }

    public int getValuesCount() {
        return this.values_.size();
    }

    public Value getValues(int index) {
        return (Value) this.values_.get(index);
    }

    public ValueOrBuilder getValuesOrBuilder(int index) {
        return (ValueOrBuilder) this.values_.get(index);
    }

    private void ensureValuesIsMutable() {
        if (!this.values_.isModifiable()) {
            this.values_ = GeneratedMessageLite.mutableCopy(this.values_);
        }
    }

    /* access modifiers changed from: private */
    public void setValues(int index, Value value) {
        if (value != null) {
            ensureValuesIsMutable();
            this.values_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setValues(int index, Value.Builder builderForValue) {
        ensureValuesIsMutable();
        this.values_.set(index, (Value) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addValues(Value value) {
        if (value != null) {
            ensureValuesIsMutable();
            this.values_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addValues(int index, Value value) {
        if (value != null) {
            ensureValuesIsMutable();
            this.values_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addValues(Value.Builder builderForValue) {
        ensureValuesIsMutable();
        this.values_.add((Value) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addValues(int index, Value.Builder builderForValue) {
        ensureValuesIsMutable();
        this.values_.add(index, (Value) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllValues(Iterable<? extends Value> values) {
        ensureValuesIsMutable();
        AbstractMessageLite.addAll(values, this.values_);
    }

    /* access modifiers changed from: private */
    public void clearValues() {
        this.values_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeValues(int index) {
        ensureValuesIsMutable();
        this.values_.remove(index);
    }

    public boolean getBefore() {
        return this.before_;
    }

    /* access modifiers changed from: private */
    public void setBefore(boolean value) {
        this.before_ = value;
    }

    /* access modifiers changed from: private */
    public void clearBefore() {
        this.before_ = false;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        for (int i = 0; i < this.values_.size(); i++) {
            output.writeMessage(1, (MessageLite) this.values_.get(i));
        }
        boolean z = this.before_;
        if (z) {
            output.writeBool(2, z);
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        for (int i = 0; i < this.values_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.values_.get(i));
        }
        boolean z = this.before_;
        if (z) {
            size2 += CodedOutputStream.computeBoolSize(2, z);
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Cursor parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Cursor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Cursor parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Cursor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Cursor parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Cursor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Cursor parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Cursor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Cursor parseFrom(InputStream input) throws IOException {
        return (Cursor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Cursor parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Cursor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Cursor parseDelimitedFrom(InputStream input) throws IOException {
        return (Cursor) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Cursor parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Cursor) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Cursor parseFrom(CodedInputStream input) throws IOException {
        return (Cursor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Cursor parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Cursor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Cursor prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<Cursor, Builder> implements CursorOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Cursor.DEFAULT_INSTANCE);
        }

        public List<Value> getValuesList() {
            return Collections.unmodifiableList(((Cursor) this.instance).getValuesList());
        }

        public int getValuesCount() {
            return ((Cursor) this.instance).getValuesCount();
        }

        public Value getValues(int index) {
            return ((Cursor) this.instance).getValues(index);
        }

        public Builder setValues(int index, Value value) {
            copyOnWrite();
            ((Cursor) this.instance).setValues(index, value);
            return this;
        }

        public Builder setValues(int index, Value.Builder builderForValue) {
            copyOnWrite();
            ((Cursor) this.instance).setValues(index, builderForValue);
            return this;
        }

        public Builder addValues(Value value) {
            copyOnWrite();
            ((Cursor) this.instance).addValues(value);
            return this;
        }

        public Builder addValues(int index, Value value) {
            copyOnWrite();
            ((Cursor) this.instance).addValues(index, value);
            return this;
        }

        public Builder addValues(Value.Builder builderForValue) {
            copyOnWrite();
            ((Cursor) this.instance).addValues(builderForValue);
            return this;
        }

        public Builder addValues(int index, Value.Builder builderForValue) {
            copyOnWrite();
            ((Cursor) this.instance).addValues(index, builderForValue);
            return this;
        }

        public Builder addAllValues(Iterable<? extends Value> values) {
            copyOnWrite();
            ((Cursor) this.instance).addAllValues(values);
            return this;
        }

        public Builder clearValues() {
            copyOnWrite();
            ((Cursor) this.instance).clearValues();
            return this;
        }

        public Builder removeValues(int index) {
            copyOnWrite();
            ((Cursor) this.instance).removeValues(index);
            return this;
        }

        public boolean getBefore() {
            return ((Cursor) this.instance).getBefore();
        }

        public Builder setBefore(boolean value) {
            copyOnWrite();
            ((Cursor) this.instance).setBefore(value);
            return this;
        }

        public Builder clearBefore() {
            copyOnWrite();
            ((Cursor) this.instance).clearBefore();
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.Cursor$1  reason: invalid class name */
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
                return new Cursor();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.values_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                Cursor other = (Cursor) arg1;
                this.values_ = visitor.visitList(this.values_, other.values_);
                boolean z = this.before_;
                boolean z2 = other.before_;
                this.before_ = visitor.visitBoolean(z, z, z2, z2);
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
                            if (!this.values_.isModifiable()) {
                                this.values_ = GeneratedMessageLite.mutableCopy(this.values_);
                            }
                            this.values_.add((Value) input.readMessage(Value.parser(), extensionRegistry));
                        } else if (tag == 16) {
                            this.before_ = input.readBool();
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
                    synchronized (Cursor.class) {
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
        Cursor cursor = new Cursor();
        DEFAULT_INSTANCE = cursor;
        cursor.makeImmutable();
    }

    public static Cursor getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Cursor> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
