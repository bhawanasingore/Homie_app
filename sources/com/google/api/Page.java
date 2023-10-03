package com.google.api;

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

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class Page extends GeneratedMessageLite<Page, Builder> implements PageOrBuilder {
    public static final int CONTENT_FIELD_NUMBER = 2;
    /* access modifiers changed from: private */
    public static final Page DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Page> PARSER = null;
    public static final int SUBPAGES_FIELD_NUMBER = 3;
    private int bitField0_;
    private String content_ = "";
    private String name_ = "";
    private Internal.ProtobufList<Page> subpages_ = emptyProtobufList();

    private Page() {
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

    public String getContent() {
        return this.content_;
    }

    public ByteString getContentBytes() {
        return ByteString.copyFromUtf8(this.content_);
    }

    /* access modifiers changed from: private */
    public void setContent(String value) {
        if (value != null) {
            this.content_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearContent() {
        this.content_ = getDefaultInstance().getContent();
    }

    /* access modifiers changed from: private */
    public void setContentBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.content_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public List<Page> getSubpagesList() {
        return this.subpages_;
    }

    public List<? extends PageOrBuilder> getSubpagesOrBuilderList() {
        return this.subpages_;
    }

    public int getSubpagesCount() {
        return this.subpages_.size();
    }

    public Page getSubpages(int index) {
        return (Page) this.subpages_.get(index);
    }

    public PageOrBuilder getSubpagesOrBuilder(int index) {
        return (PageOrBuilder) this.subpages_.get(index);
    }

    private void ensureSubpagesIsMutable() {
        if (!this.subpages_.isModifiable()) {
            this.subpages_ = GeneratedMessageLite.mutableCopy(this.subpages_);
        }
    }

    /* access modifiers changed from: private */
    public void setSubpages(int index, Page value) {
        if (value != null) {
            ensureSubpagesIsMutable();
            this.subpages_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setSubpages(int index, Builder builderForValue) {
        ensureSubpagesIsMutable();
        this.subpages_.set(index, (Page) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addSubpages(Page value) {
        if (value != null) {
            ensureSubpagesIsMutable();
            this.subpages_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addSubpages(int index, Page value) {
        if (value != null) {
            ensureSubpagesIsMutable();
            this.subpages_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addSubpages(Builder builderForValue) {
        ensureSubpagesIsMutable();
        this.subpages_.add((Page) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addSubpages(int index, Builder builderForValue) {
        ensureSubpagesIsMutable();
        this.subpages_.add(index, (Page) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllSubpages(Iterable<? extends Page> values) {
        ensureSubpagesIsMutable();
        AbstractMessageLite.addAll(values, this.subpages_);
    }

    /* access modifiers changed from: private */
    public void clearSubpages() {
        this.subpages_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeSubpages(int index) {
        ensureSubpagesIsMutable();
        this.subpages_.remove(index);
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.name_.isEmpty()) {
            output.writeString(1, getName());
        }
        if (!this.content_.isEmpty()) {
            output.writeString(2, getContent());
        }
        for (int i = 0; i < this.subpages_.size(); i++) {
            output.writeMessage(3, (MessageLite) this.subpages_.get(i));
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.name_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getName());
        }
        if (!this.content_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(2, getContent());
        }
        for (int i = 0; i < this.subpages_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(3, (MessageLite) this.subpages_.get(i));
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Page parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Page) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Page parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Page) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Page parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Page) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Page parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Page) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Page parseFrom(InputStream input) throws IOException {
        return (Page) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Page parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Page) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Page parseDelimitedFrom(InputStream input) throws IOException {
        return (Page) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Page parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Page) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Page parseFrom(CodedInputStream input) throws IOException {
        return (Page) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Page parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Page) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Page prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Page, Builder> implements PageOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Page.DEFAULT_INSTANCE);
        }

        public String getName() {
            return ((Page) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((Page) this.instance).getNameBytes();
        }

        public Builder setName(String value) {
            copyOnWrite();
            ((Page) this.instance).setName(value);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((Page) this.instance).clearName();
            return this;
        }

        public Builder setNameBytes(ByteString value) {
            copyOnWrite();
            ((Page) this.instance).setNameBytes(value);
            return this;
        }

        public String getContent() {
            return ((Page) this.instance).getContent();
        }

        public ByteString getContentBytes() {
            return ((Page) this.instance).getContentBytes();
        }

        public Builder setContent(String value) {
            copyOnWrite();
            ((Page) this.instance).setContent(value);
            return this;
        }

        public Builder clearContent() {
            copyOnWrite();
            ((Page) this.instance).clearContent();
            return this;
        }

        public Builder setContentBytes(ByteString value) {
            copyOnWrite();
            ((Page) this.instance).setContentBytes(value);
            return this;
        }

        public List<Page> getSubpagesList() {
            return Collections.unmodifiableList(((Page) this.instance).getSubpagesList());
        }

        public int getSubpagesCount() {
            return ((Page) this.instance).getSubpagesCount();
        }

        public Page getSubpages(int index) {
            return ((Page) this.instance).getSubpages(index);
        }

        public Builder setSubpages(int index, Page value) {
            copyOnWrite();
            ((Page) this.instance).setSubpages(index, value);
            return this;
        }

        public Builder setSubpages(int index, Builder builderForValue) {
            copyOnWrite();
            ((Page) this.instance).setSubpages(index, builderForValue);
            return this;
        }

        public Builder addSubpages(Page value) {
            copyOnWrite();
            ((Page) this.instance).addSubpages(value);
            return this;
        }

        public Builder addSubpages(int index, Page value) {
            copyOnWrite();
            ((Page) this.instance).addSubpages(index, value);
            return this;
        }

        public Builder addSubpages(Builder builderForValue) {
            copyOnWrite();
            ((Page) this.instance).addSubpages(builderForValue);
            return this;
        }

        public Builder addSubpages(int index, Builder builderForValue) {
            copyOnWrite();
            ((Page) this.instance).addSubpages(index, builderForValue);
            return this;
        }

        public Builder addAllSubpages(Iterable<? extends Page> values) {
            copyOnWrite();
            ((Page) this.instance).addAllSubpages(values);
            return this;
        }

        public Builder clearSubpages() {
            copyOnWrite();
            ((Page) this.instance).clearSubpages();
            return this;
        }

        public Builder removeSubpages(int index) {
            copyOnWrite();
            ((Page) this.instance).removeSubpages(index);
            return this;
        }
    }

    /* renamed from: com.google.api.Page$1  reason: invalid class name */
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
                return new Page();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.subpages_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                Page other = (Page) arg1;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !other.name_.isEmpty(), other.name_);
                this.content_ = visitor.visitString(!this.content_.isEmpty(), this.content_, !other.content_.isEmpty(), other.content_);
                this.subpages_ = visitor.visitList(this.subpages_, other.subpages_);
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
                            this.name_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            this.content_ = input.readStringRequireUtf8();
                        } else if (tag == 26) {
                            if (!this.subpages_.isModifiable()) {
                                this.subpages_ = GeneratedMessageLite.mutableCopy(this.subpages_);
                            }
                            this.subpages_.add((Page) input.readMessage(parser(), extensionRegistry));
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
                    synchronized (Page.class) {
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
        Page page = new Page();
        DEFAULT_INSTANCE = page;
        page.makeImmutable();
    }

    public static Page getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Page> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
