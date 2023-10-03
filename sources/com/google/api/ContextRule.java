package com.google.api;

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

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class ContextRule extends GeneratedMessageLite<ContextRule, Builder> implements ContextRuleOrBuilder {
    /* access modifiers changed from: private */
    public static final ContextRule DEFAULT_INSTANCE;
    private static volatile Parser<ContextRule> PARSER = null;
    public static final int PROVIDED_FIELD_NUMBER = 3;
    public static final int REQUESTED_FIELD_NUMBER = 2;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private int bitField0_;
    private Internal.ProtobufList<String> provided_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<String> requested_ = GeneratedMessageLite.emptyProtobufList();
    private String selector_ = "";

    private ContextRule() {
    }

    public String getSelector() {
        return this.selector_;
    }

    public ByteString getSelectorBytes() {
        return ByteString.copyFromUtf8(this.selector_);
    }

    /* access modifiers changed from: private */
    public void setSelector(String value) {
        if (value != null) {
            this.selector_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearSelector() {
        this.selector_ = getDefaultInstance().getSelector();
    }

    /* access modifiers changed from: private */
    public void setSelectorBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.selector_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public List<String> getRequestedList() {
        return this.requested_;
    }

    public int getRequestedCount() {
        return this.requested_.size();
    }

    public String getRequested(int index) {
        return (String) this.requested_.get(index);
    }

    public ByteString getRequestedBytes(int index) {
        return ByteString.copyFromUtf8((String) this.requested_.get(index));
    }

    private void ensureRequestedIsMutable() {
        if (!this.requested_.isModifiable()) {
            this.requested_ = GeneratedMessageLite.mutableCopy(this.requested_);
        }
    }

    /* access modifiers changed from: private */
    public void setRequested(int index, String value) {
        if (value != null) {
            ensureRequestedIsMutable();
            this.requested_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addRequested(String value) {
        if (value != null) {
            ensureRequestedIsMutable();
            this.requested_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addAllRequested(Iterable<String> values) {
        ensureRequestedIsMutable();
        AbstractMessageLite.addAll(values, this.requested_);
    }

    /* access modifiers changed from: private */
    public void clearRequested() {
        this.requested_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void addRequestedBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            ensureRequestedIsMutable();
            this.requested_.add(value.toStringUtf8());
            return;
        }
        throw null;
    }

    public List<String> getProvidedList() {
        return this.provided_;
    }

    public int getProvidedCount() {
        return this.provided_.size();
    }

    public String getProvided(int index) {
        return (String) this.provided_.get(index);
    }

    public ByteString getProvidedBytes(int index) {
        return ByteString.copyFromUtf8((String) this.provided_.get(index));
    }

    private void ensureProvidedIsMutable() {
        if (!this.provided_.isModifiable()) {
            this.provided_ = GeneratedMessageLite.mutableCopy(this.provided_);
        }
    }

    /* access modifiers changed from: private */
    public void setProvided(int index, String value) {
        if (value != null) {
            ensureProvidedIsMutable();
            this.provided_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addProvided(String value) {
        if (value != null) {
            ensureProvidedIsMutable();
            this.provided_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addAllProvided(Iterable<String> values) {
        ensureProvidedIsMutable();
        AbstractMessageLite.addAll(values, this.provided_);
    }

    /* access modifiers changed from: private */
    public void clearProvided() {
        this.provided_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void addProvidedBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            ensureProvidedIsMutable();
            this.provided_.add(value.toStringUtf8());
            return;
        }
        throw null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.selector_.isEmpty()) {
            output.writeString(1, getSelector());
        }
        for (int i = 0; i < this.requested_.size(); i++) {
            output.writeString(2, (String) this.requested_.get(i));
        }
        for (int i2 = 0; i2 < this.provided_.size(); i2++) {
            output.writeString(3, (String) this.provided_.get(i2));
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.selector_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getSelector());
        }
        int dataSize = 0;
        for (int i = 0; i < this.requested_.size(); i++) {
            dataSize += CodedOutputStream.computeStringSizeNoTag((String) this.requested_.get(i));
        }
        int size3 = size2 + dataSize + (getRequestedList().size() * 1);
        int dataSize2 = 0;
        for (int i2 = 0; i2 < this.provided_.size(); i2++) {
            dataSize2 += CodedOutputStream.computeStringSizeNoTag((String) this.provided_.get(i2));
        }
        int size4 = size3 + dataSize2 + (getProvidedList().size() * 1);
        this.memoizedSerializedSize = size4;
        return size4;
    }

    public static ContextRule parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (ContextRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ContextRule parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ContextRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ContextRule parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (ContextRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ContextRule parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ContextRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ContextRule parseFrom(InputStream input) throws IOException {
        return (ContextRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ContextRule parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ContextRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ContextRule parseDelimitedFrom(InputStream input) throws IOException {
        return (ContextRule) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static ContextRule parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ContextRule) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ContextRule parseFrom(CodedInputStream input) throws IOException {
        return (ContextRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ContextRule parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ContextRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ContextRule prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<ContextRule, Builder> implements ContextRuleOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(ContextRule.DEFAULT_INSTANCE);
        }

        public String getSelector() {
            return ((ContextRule) this.instance).getSelector();
        }

        public ByteString getSelectorBytes() {
            return ((ContextRule) this.instance).getSelectorBytes();
        }

        public Builder setSelector(String value) {
            copyOnWrite();
            ((ContextRule) this.instance).setSelector(value);
            return this;
        }

        public Builder clearSelector() {
            copyOnWrite();
            ((ContextRule) this.instance).clearSelector();
            return this;
        }

        public Builder setSelectorBytes(ByteString value) {
            copyOnWrite();
            ((ContextRule) this.instance).setSelectorBytes(value);
            return this;
        }

        public List<String> getRequestedList() {
            return Collections.unmodifiableList(((ContextRule) this.instance).getRequestedList());
        }

        public int getRequestedCount() {
            return ((ContextRule) this.instance).getRequestedCount();
        }

        public String getRequested(int index) {
            return ((ContextRule) this.instance).getRequested(index);
        }

        public ByteString getRequestedBytes(int index) {
            return ((ContextRule) this.instance).getRequestedBytes(index);
        }

        public Builder setRequested(int index, String value) {
            copyOnWrite();
            ((ContextRule) this.instance).setRequested(index, value);
            return this;
        }

        public Builder addRequested(String value) {
            copyOnWrite();
            ((ContextRule) this.instance).addRequested(value);
            return this;
        }

        public Builder addAllRequested(Iterable<String> values) {
            copyOnWrite();
            ((ContextRule) this.instance).addAllRequested(values);
            return this;
        }

        public Builder clearRequested() {
            copyOnWrite();
            ((ContextRule) this.instance).clearRequested();
            return this;
        }

        public Builder addRequestedBytes(ByteString value) {
            copyOnWrite();
            ((ContextRule) this.instance).addRequestedBytes(value);
            return this;
        }

        public List<String> getProvidedList() {
            return Collections.unmodifiableList(((ContextRule) this.instance).getProvidedList());
        }

        public int getProvidedCount() {
            return ((ContextRule) this.instance).getProvidedCount();
        }

        public String getProvided(int index) {
            return ((ContextRule) this.instance).getProvided(index);
        }

        public ByteString getProvidedBytes(int index) {
            return ((ContextRule) this.instance).getProvidedBytes(index);
        }

        public Builder setProvided(int index, String value) {
            copyOnWrite();
            ((ContextRule) this.instance).setProvided(index, value);
            return this;
        }

        public Builder addProvided(String value) {
            copyOnWrite();
            ((ContextRule) this.instance).addProvided(value);
            return this;
        }

        public Builder addAllProvided(Iterable<String> values) {
            copyOnWrite();
            ((ContextRule) this.instance).addAllProvided(values);
            return this;
        }

        public Builder clearProvided() {
            copyOnWrite();
            ((ContextRule) this.instance).clearProvided();
            return this;
        }

        public Builder addProvidedBytes(ByteString value) {
            copyOnWrite();
            ((ContextRule) this.instance).addProvidedBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.api.ContextRule$1  reason: invalid class name */
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
                return new ContextRule();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.requested_.makeImmutable();
                this.provided_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                ContextRule other = (ContextRule) arg1;
                this.selector_ = visitor.visitString(!this.selector_.isEmpty(), this.selector_, !other.selector_.isEmpty(), other.selector_);
                this.requested_ = visitor.visitList(this.requested_, other.requested_);
                this.provided_ = visitor.visitList(this.provided_, other.provided_);
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
                            this.selector_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            String s = input.readStringRequireUtf8();
                            if (!this.requested_.isModifiable()) {
                                this.requested_ = GeneratedMessageLite.mutableCopy(this.requested_);
                            }
                            this.requested_.add(s);
                        } else if (tag == 26) {
                            String s2 = input.readStringRequireUtf8();
                            if (!this.provided_.isModifiable()) {
                                this.provided_ = GeneratedMessageLite.mutableCopy(this.provided_);
                            }
                            this.provided_.add(s2);
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
                    synchronized (ContextRule.class) {
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
        ContextRule contextRule = new ContextRule();
        DEFAULT_INSTANCE = contextRule;
        contextRule.makeImmutable();
    }

    public static ContextRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<ContextRule> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
