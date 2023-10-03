package com.google.api;

import com.google.api.DocumentationRule;
import com.google.api.Page;
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
public final class Documentation extends GeneratedMessageLite<Documentation, Builder> implements DocumentationOrBuilder {
    /* access modifiers changed from: private */
    public static final Documentation DEFAULT_INSTANCE;
    public static final int DOCUMENTATION_ROOT_URL_FIELD_NUMBER = 4;
    public static final int OVERVIEW_FIELD_NUMBER = 2;
    public static final int PAGES_FIELD_NUMBER = 5;
    private static volatile Parser<Documentation> PARSER = null;
    public static final int RULES_FIELD_NUMBER = 3;
    public static final int SUMMARY_FIELD_NUMBER = 1;
    private int bitField0_;
    private String documentationRootUrl_ = "";
    private String overview_ = "";
    private Internal.ProtobufList<Page> pages_ = emptyProtobufList();
    private Internal.ProtobufList<DocumentationRule> rules_ = emptyProtobufList();
    private String summary_ = "";

    private Documentation() {
    }

    public String getSummary() {
        return this.summary_;
    }

    public ByteString getSummaryBytes() {
        return ByteString.copyFromUtf8(this.summary_);
    }

    /* access modifiers changed from: private */
    public void setSummary(String value) {
        if (value != null) {
            this.summary_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearSummary() {
        this.summary_ = getDefaultInstance().getSummary();
    }

    /* access modifiers changed from: private */
    public void setSummaryBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.summary_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public List<Page> getPagesList() {
        return this.pages_;
    }

    public List<? extends PageOrBuilder> getPagesOrBuilderList() {
        return this.pages_;
    }

    public int getPagesCount() {
        return this.pages_.size();
    }

    public Page getPages(int index) {
        return (Page) this.pages_.get(index);
    }

    public PageOrBuilder getPagesOrBuilder(int index) {
        return (PageOrBuilder) this.pages_.get(index);
    }

    private void ensurePagesIsMutable() {
        if (!this.pages_.isModifiable()) {
            this.pages_ = GeneratedMessageLite.mutableCopy(this.pages_);
        }
    }

    /* access modifiers changed from: private */
    public void setPages(int index, Page value) {
        if (value != null) {
            ensurePagesIsMutable();
            this.pages_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setPages(int index, Page.Builder builderForValue) {
        ensurePagesIsMutable();
        this.pages_.set(index, (Page) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addPages(Page value) {
        if (value != null) {
            ensurePagesIsMutable();
            this.pages_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addPages(int index, Page value) {
        if (value != null) {
            ensurePagesIsMutable();
            this.pages_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addPages(Page.Builder builderForValue) {
        ensurePagesIsMutable();
        this.pages_.add((Page) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addPages(int index, Page.Builder builderForValue) {
        ensurePagesIsMutable();
        this.pages_.add(index, (Page) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllPages(Iterable<? extends Page> values) {
        ensurePagesIsMutable();
        AbstractMessageLite.addAll(values, this.pages_);
    }

    /* access modifiers changed from: private */
    public void clearPages() {
        this.pages_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removePages(int index) {
        ensurePagesIsMutable();
        this.pages_.remove(index);
    }

    public List<DocumentationRule> getRulesList() {
        return this.rules_;
    }

    public List<? extends DocumentationRuleOrBuilder> getRulesOrBuilderList() {
        return this.rules_;
    }

    public int getRulesCount() {
        return this.rules_.size();
    }

    public DocumentationRule getRules(int index) {
        return (DocumentationRule) this.rules_.get(index);
    }

    public DocumentationRuleOrBuilder getRulesOrBuilder(int index) {
        return (DocumentationRuleOrBuilder) this.rules_.get(index);
    }

    private void ensureRulesIsMutable() {
        if (!this.rules_.isModifiable()) {
            this.rules_ = GeneratedMessageLite.mutableCopy(this.rules_);
        }
    }

    /* access modifiers changed from: private */
    public void setRules(int index, DocumentationRule value) {
        if (value != null) {
            ensureRulesIsMutable();
            this.rules_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setRules(int index, DocumentationRule.Builder builderForValue) {
        ensureRulesIsMutable();
        this.rules_.set(index, (DocumentationRule) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addRules(DocumentationRule value) {
        if (value != null) {
            ensureRulesIsMutable();
            this.rules_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addRules(int index, DocumentationRule value) {
        if (value != null) {
            ensureRulesIsMutable();
            this.rules_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addRules(DocumentationRule.Builder builderForValue) {
        ensureRulesIsMutable();
        this.rules_.add((DocumentationRule) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addRules(int index, DocumentationRule.Builder builderForValue) {
        ensureRulesIsMutable();
        this.rules_.add(index, (DocumentationRule) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllRules(Iterable<? extends DocumentationRule> values) {
        ensureRulesIsMutable();
        AbstractMessageLite.addAll(values, this.rules_);
    }

    /* access modifiers changed from: private */
    public void clearRules() {
        this.rules_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeRules(int index) {
        ensureRulesIsMutable();
        this.rules_.remove(index);
    }

    public String getDocumentationRootUrl() {
        return this.documentationRootUrl_;
    }

    public ByteString getDocumentationRootUrlBytes() {
        return ByteString.copyFromUtf8(this.documentationRootUrl_);
    }

    /* access modifiers changed from: private */
    public void setDocumentationRootUrl(String value) {
        if (value != null) {
            this.documentationRootUrl_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearDocumentationRootUrl() {
        this.documentationRootUrl_ = getDefaultInstance().getDocumentationRootUrl();
    }

    /* access modifiers changed from: private */
    public void setDocumentationRootUrlBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.documentationRootUrl_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getOverview() {
        return this.overview_;
    }

    public ByteString getOverviewBytes() {
        return ByteString.copyFromUtf8(this.overview_);
    }

    /* access modifiers changed from: private */
    public void setOverview(String value) {
        if (value != null) {
            this.overview_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearOverview() {
        this.overview_ = getDefaultInstance().getOverview();
    }

    /* access modifiers changed from: private */
    public void setOverviewBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.overview_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.summary_.isEmpty()) {
            output.writeString(1, getSummary());
        }
        if (!this.overview_.isEmpty()) {
            output.writeString(2, getOverview());
        }
        for (int i = 0; i < this.rules_.size(); i++) {
            output.writeMessage(3, (MessageLite) this.rules_.get(i));
        }
        if (!this.documentationRootUrl_.isEmpty()) {
            output.writeString(4, getDocumentationRootUrl());
        }
        for (int i2 = 0; i2 < this.pages_.size(); i2++) {
            output.writeMessage(5, (MessageLite) this.pages_.get(i2));
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.summary_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getSummary());
        }
        if (!this.overview_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(2, getOverview());
        }
        for (int i = 0; i < this.rules_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(3, (MessageLite) this.rules_.get(i));
        }
        if (!this.documentationRootUrl_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(4, getDocumentationRootUrl());
        }
        for (int i2 = 0; i2 < this.pages_.size(); i2++) {
            size2 += CodedOutputStream.computeMessageSize(5, (MessageLite) this.pages_.get(i2));
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Documentation parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Documentation parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Documentation parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Documentation parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Documentation parseFrom(InputStream input) throws IOException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Documentation parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Documentation parseDelimitedFrom(InputStream input) throws IOException {
        return (Documentation) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Documentation parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Documentation) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Documentation parseFrom(CodedInputStream input) throws IOException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Documentation parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Documentation prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Documentation, Builder> implements DocumentationOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Documentation.DEFAULT_INSTANCE);
        }

        public String getSummary() {
            return ((Documentation) this.instance).getSummary();
        }

        public ByteString getSummaryBytes() {
            return ((Documentation) this.instance).getSummaryBytes();
        }

        public Builder setSummary(String value) {
            copyOnWrite();
            ((Documentation) this.instance).setSummary(value);
            return this;
        }

        public Builder clearSummary() {
            copyOnWrite();
            ((Documentation) this.instance).clearSummary();
            return this;
        }

        public Builder setSummaryBytes(ByteString value) {
            copyOnWrite();
            ((Documentation) this.instance).setSummaryBytes(value);
            return this;
        }

        public List<Page> getPagesList() {
            return Collections.unmodifiableList(((Documentation) this.instance).getPagesList());
        }

        public int getPagesCount() {
            return ((Documentation) this.instance).getPagesCount();
        }

        public Page getPages(int index) {
            return ((Documentation) this.instance).getPages(index);
        }

        public Builder setPages(int index, Page value) {
            copyOnWrite();
            ((Documentation) this.instance).setPages(index, value);
            return this;
        }

        public Builder setPages(int index, Page.Builder builderForValue) {
            copyOnWrite();
            ((Documentation) this.instance).setPages(index, builderForValue);
            return this;
        }

        public Builder addPages(Page value) {
            copyOnWrite();
            ((Documentation) this.instance).addPages(value);
            return this;
        }

        public Builder addPages(int index, Page value) {
            copyOnWrite();
            ((Documentation) this.instance).addPages(index, value);
            return this;
        }

        public Builder addPages(Page.Builder builderForValue) {
            copyOnWrite();
            ((Documentation) this.instance).addPages(builderForValue);
            return this;
        }

        public Builder addPages(int index, Page.Builder builderForValue) {
            copyOnWrite();
            ((Documentation) this.instance).addPages(index, builderForValue);
            return this;
        }

        public Builder addAllPages(Iterable<? extends Page> values) {
            copyOnWrite();
            ((Documentation) this.instance).addAllPages(values);
            return this;
        }

        public Builder clearPages() {
            copyOnWrite();
            ((Documentation) this.instance).clearPages();
            return this;
        }

        public Builder removePages(int index) {
            copyOnWrite();
            ((Documentation) this.instance).removePages(index);
            return this;
        }

        public List<DocumentationRule> getRulesList() {
            return Collections.unmodifiableList(((Documentation) this.instance).getRulesList());
        }

        public int getRulesCount() {
            return ((Documentation) this.instance).getRulesCount();
        }

        public DocumentationRule getRules(int index) {
            return ((Documentation) this.instance).getRules(index);
        }

        public Builder setRules(int index, DocumentationRule value) {
            copyOnWrite();
            ((Documentation) this.instance).setRules(index, value);
            return this;
        }

        public Builder setRules(int index, DocumentationRule.Builder builderForValue) {
            copyOnWrite();
            ((Documentation) this.instance).setRules(index, builderForValue);
            return this;
        }

        public Builder addRules(DocumentationRule value) {
            copyOnWrite();
            ((Documentation) this.instance).addRules(value);
            return this;
        }

        public Builder addRules(int index, DocumentationRule value) {
            copyOnWrite();
            ((Documentation) this.instance).addRules(index, value);
            return this;
        }

        public Builder addRules(DocumentationRule.Builder builderForValue) {
            copyOnWrite();
            ((Documentation) this.instance).addRules(builderForValue);
            return this;
        }

        public Builder addRules(int index, DocumentationRule.Builder builderForValue) {
            copyOnWrite();
            ((Documentation) this.instance).addRules(index, builderForValue);
            return this;
        }

        public Builder addAllRules(Iterable<? extends DocumentationRule> values) {
            copyOnWrite();
            ((Documentation) this.instance).addAllRules(values);
            return this;
        }

        public Builder clearRules() {
            copyOnWrite();
            ((Documentation) this.instance).clearRules();
            return this;
        }

        public Builder removeRules(int index) {
            copyOnWrite();
            ((Documentation) this.instance).removeRules(index);
            return this;
        }

        public String getDocumentationRootUrl() {
            return ((Documentation) this.instance).getDocumentationRootUrl();
        }

        public ByteString getDocumentationRootUrlBytes() {
            return ((Documentation) this.instance).getDocumentationRootUrlBytes();
        }

        public Builder setDocumentationRootUrl(String value) {
            copyOnWrite();
            ((Documentation) this.instance).setDocumentationRootUrl(value);
            return this;
        }

        public Builder clearDocumentationRootUrl() {
            copyOnWrite();
            ((Documentation) this.instance).clearDocumentationRootUrl();
            return this;
        }

        public Builder setDocumentationRootUrlBytes(ByteString value) {
            copyOnWrite();
            ((Documentation) this.instance).setDocumentationRootUrlBytes(value);
            return this;
        }

        public String getOverview() {
            return ((Documentation) this.instance).getOverview();
        }

        public ByteString getOverviewBytes() {
            return ((Documentation) this.instance).getOverviewBytes();
        }

        public Builder setOverview(String value) {
            copyOnWrite();
            ((Documentation) this.instance).setOverview(value);
            return this;
        }

        public Builder clearOverview() {
            copyOnWrite();
            ((Documentation) this.instance).clearOverview();
            return this;
        }

        public Builder setOverviewBytes(ByteString value) {
            copyOnWrite();
            ((Documentation) this.instance).setOverviewBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.api.Documentation$1  reason: invalid class name */
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
                return new Documentation();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.pages_.makeImmutable();
                this.rules_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                Documentation other = (Documentation) arg1;
                this.summary_ = visitor.visitString(!this.summary_.isEmpty(), this.summary_, !other.summary_.isEmpty(), other.summary_);
                this.pages_ = visitor.visitList(this.pages_, other.pages_);
                this.rules_ = visitor.visitList(this.rules_, other.rules_);
                this.documentationRootUrl_ = visitor.visitString(!this.documentationRootUrl_.isEmpty(), this.documentationRootUrl_, !other.documentationRootUrl_.isEmpty(), other.documentationRootUrl_);
                this.overview_ = visitor.visitString(!this.overview_.isEmpty(), this.overview_, !other.overview_.isEmpty(), other.overview_);
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
                            this.summary_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            this.overview_ = input.readStringRequireUtf8();
                        } else if (tag == 26) {
                            if (!this.rules_.isModifiable()) {
                                this.rules_ = GeneratedMessageLite.mutableCopy(this.rules_);
                            }
                            this.rules_.add((DocumentationRule) input.readMessage(DocumentationRule.parser(), extensionRegistry));
                        } else if (tag == 34) {
                            this.documentationRootUrl_ = input.readStringRequireUtf8();
                        } else if (tag == 42) {
                            if (!this.pages_.isModifiable()) {
                                this.pages_ = GeneratedMessageLite.mutableCopy(this.pages_);
                            }
                            this.pages_.add((Page) input.readMessage(Page.parser(), extensionRegistry));
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
                    synchronized (Documentation.class) {
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
        Documentation documentation = new Documentation();
        DEFAULT_INSTANCE = documentation;
        documentation.makeImmutable();
    }

    public static Documentation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Documentation> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
