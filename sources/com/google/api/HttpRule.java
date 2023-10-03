package com.google.api;

import com.google.api.CustomHttpPattern;
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
public final class HttpRule extends GeneratedMessageLite<HttpRule, Builder> implements HttpRuleOrBuilder {
    public static final int ADDITIONAL_BINDINGS_FIELD_NUMBER = 11;
    public static final int BODY_FIELD_NUMBER = 7;
    public static final int CUSTOM_FIELD_NUMBER = 8;
    /* access modifiers changed from: private */
    public static final HttpRule DEFAULT_INSTANCE;
    public static final int DELETE_FIELD_NUMBER = 5;
    public static final int GET_FIELD_NUMBER = 2;
    private static volatile Parser<HttpRule> PARSER = null;
    public static final int PATCH_FIELD_NUMBER = 6;
    public static final int POST_FIELD_NUMBER = 4;
    public static final int PUT_FIELD_NUMBER = 3;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private Internal.ProtobufList<HttpRule> additionalBindings_ = emptyProtobufList();
    private int bitField0_;
    private String body_ = "";
    private int patternCase_ = 0;
    private Object pattern_;
    private String selector_ = "";

    private HttpRule() {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public enum PatternCase implements Internal.EnumLite {
        GET(2),
        PUT(3),
        POST(4),
        DELETE(5),
        PATCH(6),
        CUSTOM(8),
        PATTERN_NOT_SET(0);
        
        private final int value;

        private PatternCase(int value2) {
            this.value = value2;
        }

        @Deprecated
        public static PatternCase valueOf(int value2) {
            return forNumber(value2);
        }

        public static PatternCase forNumber(int value2) {
            if (value2 == 0) {
                return PATTERN_NOT_SET;
            }
            if (value2 == 8) {
                return CUSTOM;
            }
            if (value2 == 2) {
                return GET;
            }
            if (value2 == 3) {
                return PUT;
            }
            if (value2 == 4) {
                return POST;
            }
            if (value2 == 5) {
                return DELETE;
            }
            if (value2 != 6) {
                return null;
            }
            return PATCH;
        }

        public int getNumber() {
            return this.value;
        }
    }

    public PatternCase getPatternCase() {
        return PatternCase.forNumber(this.patternCase_);
    }

    /* access modifiers changed from: private */
    public void clearPattern() {
        this.patternCase_ = 0;
        this.pattern_ = null;
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

    public String getGet() {
        if (this.patternCase_ == 2) {
            return (String) this.pattern_;
        }
        return "";
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.protobuf.ByteString getGetBytes() {
        /*
            r3 = this;
            java.lang.String r0 = ""
            int r1 = r3.patternCase_
            r2 = 2
            if (r1 != r2) goto L_0x000c
            java.lang.Object r1 = r3.pattern_
            r0 = r1
            java.lang.String r0 = (java.lang.String) r0
        L_0x000c:
            com.google.protobuf.ByteString r1 = com.google.protobuf.ByteString.copyFromUtf8(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.HttpRule.getGetBytes():com.google.protobuf.ByteString");
    }

    /* access modifiers changed from: private */
    public void setGet(String value) {
        if (value != null) {
            this.patternCase_ = 2;
            this.pattern_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearGet() {
        if (this.patternCase_ == 2) {
            this.patternCase_ = 0;
            this.pattern_ = null;
        }
    }

    /* access modifiers changed from: private */
    public void setGetBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.patternCase_ = 2;
            this.pattern_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getPut() {
        if (this.patternCase_ == 3) {
            return (String) this.pattern_;
        }
        return "";
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.protobuf.ByteString getPutBytes() {
        /*
            r3 = this;
            java.lang.String r0 = ""
            int r1 = r3.patternCase_
            r2 = 3
            if (r1 != r2) goto L_0x000c
            java.lang.Object r1 = r3.pattern_
            r0 = r1
            java.lang.String r0 = (java.lang.String) r0
        L_0x000c:
            com.google.protobuf.ByteString r1 = com.google.protobuf.ByteString.copyFromUtf8(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.HttpRule.getPutBytes():com.google.protobuf.ByteString");
    }

    /* access modifiers changed from: private */
    public void setPut(String value) {
        if (value != null) {
            this.patternCase_ = 3;
            this.pattern_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearPut() {
        if (this.patternCase_ == 3) {
            this.patternCase_ = 0;
            this.pattern_ = null;
        }
    }

    /* access modifiers changed from: private */
    public void setPutBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.patternCase_ = 3;
            this.pattern_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getPost() {
        if (this.patternCase_ == 4) {
            return (String) this.pattern_;
        }
        return "";
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.protobuf.ByteString getPostBytes() {
        /*
            r3 = this;
            java.lang.String r0 = ""
            int r1 = r3.patternCase_
            r2 = 4
            if (r1 != r2) goto L_0x000c
            java.lang.Object r1 = r3.pattern_
            r0 = r1
            java.lang.String r0 = (java.lang.String) r0
        L_0x000c:
            com.google.protobuf.ByteString r1 = com.google.protobuf.ByteString.copyFromUtf8(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.HttpRule.getPostBytes():com.google.protobuf.ByteString");
    }

    /* access modifiers changed from: private */
    public void setPost(String value) {
        if (value != null) {
            this.patternCase_ = 4;
            this.pattern_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearPost() {
        if (this.patternCase_ == 4) {
            this.patternCase_ = 0;
            this.pattern_ = null;
        }
    }

    /* access modifiers changed from: private */
    public void setPostBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.patternCase_ = 4;
            this.pattern_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getDelete() {
        if (this.patternCase_ == 5) {
            return (String) this.pattern_;
        }
        return "";
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.protobuf.ByteString getDeleteBytes() {
        /*
            r3 = this;
            java.lang.String r0 = ""
            int r1 = r3.patternCase_
            r2 = 5
            if (r1 != r2) goto L_0x000c
            java.lang.Object r1 = r3.pattern_
            r0 = r1
            java.lang.String r0 = (java.lang.String) r0
        L_0x000c:
            com.google.protobuf.ByteString r1 = com.google.protobuf.ByteString.copyFromUtf8(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.HttpRule.getDeleteBytes():com.google.protobuf.ByteString");
    }

    /* access modifiers changed from: private */
    public void setDelete(String value) {
        if (value != null) {
            this.patternCase_ = 5;
            this.pattern_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearDelete() {
        if (this.patternCase_ == 5) {
            this.patternCase_ = 0;
            this.pattern_ = null;
        }
    }

    /* access modifiers changed from: private */
    public void setDeleteBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.patternCase_ = 5;
            this.pattern_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getPatch() {
        if (this.patternCase_ == 6) {
            return (String) this.pattern_;
        }
        return "";
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.protobuf.ByteString getPatchBytes() {
        /*
            r3 = this;
            java.lang.String r0 = ""
            int r1 = r3.patternCase_
            r2 = 6
            if (r1 != r2) goto L_0x000c
            java.lang.Object r1 = r3.pattern_
            r0 = r1
            java.lang.String r0 = (java.lang.String) r0
        L_0x000c:
            com.google.protobuf.ByteString r1 = com.google.protobuf.ByteString.copyFromUtf8(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.HttpRule.getPatchBytes():com.google.protobuf.ByteString");
    }

    /* access modifiers changed from: private */
    public void setPatch(String value) {
        if (value != null) {
            this.patternCase_ = 6;
            this.pattern_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearPatch() {
        if (this.patternCase_ == 6) {
            this.patternCase_ = 0;
            this.pattern_ = null;
        }
    }

    /* access modifiers changed from: private */
    public void setPatchBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.patternCase_ = 6;
            this.pattern_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public CustomHttpPattern getCustom() {
        if (this.patternCase_ == 8) {
            return (CustomHttpPattern) this.pattern_;
        }
        return CustomHttpPattern.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setCustom(CustomHttpPattern value) {
        if (value != null) {
            this.pattern_ = value;
            this.patternCase_ = 8;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setCustom(CustomHttpPattern.Builder builderForValue) {
        this.pattern_ = builderForValue.build();
        this.patternCase_ = 8;
    }

    /* access modifiers changed from: private */
    public void mergeCustom(CustomHttpPattern value) {
        if (this.patternCase_ != 8 || this.pattern_ == CustomHttpPattern.getDefaultInstance()) {
            this.pattern_ = value;
        } else {
            this.pattern_ = ((CustomHttpPattern.Builder) CustomHttpPattern.newBuilder((CustomHttpPattern) this.pattern_).mergeFrom(value)).buildPartial();
        }
        this.patternCase_ = 8;
    }

    /* access modifiers changed from: private */
    public void clearCustom() {
        if (this.patternCase_ == 8) {
            this.patternCase_ = 0;
            this.pattern_ = null;
        }
    }

    public String getBody() {
        return this.body_;
    }

    public ByteString getBodyBytes() {
        return ByteString.copyFromUtf8(this.body_);
    }

    /* access modifiers changed from: private */
    public void setBody(String value) {
        if (value != null) {
            this.body_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearBody() {
        this.body_ = getDefaultInstance().getBody();
    }

    /* access modifiers changed from: private */
    public void setBodyBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.body_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public List<HttpRule> getAdditionalBindingsList() {
        return this.additionalBindings_;
    }

    public List<? extends HttpRuleOrBuilder> getAdditionalBindingsOrBuilderList() {
        return this.additionalBindings_;
    }

    public int getAdditionalBindingsCount() {
        return this.additionalBindings_.size();
    }

    public HttpRule getAdditionalBindings(int index) {
        return (HttpRule) this.additionalBindings_.get(index);
    }

    public HttpRuleOrBuilder getAdditionalBindingsOrBuilder(int index) {
        return (HttpRuleOrBuilder) this.additionalBindings_.get(index);
    }

    private void ensureAdditionalBindingsIsMutable() {
        if (!this.additionalBindings_.isModifiable()) {
            this.additionalBindings_ = GeneratedMessageLite.mutableCopy(this.additionalBindings_);
        }
    }

    /* access modifiers changed from: private */
    public void setAdditionalBindings(int index, HttpRule value) {
        if (value != null) {
            ensureAdditionalBindingsIsMutable();
            this.additionalBindings_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setAdditionalBindings(int index, Builder builderForValue) {
        ensureAdditionalBindingsIsMutable();
        this.additionalBindings_.set(index, (HttpRule) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAdditionalBindings(HttpRule value) {
        if (value != null) {
            ensureAdditionalBindingsIsMutable();
            this.additionalBindings_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addAdditionalBindings(int index, HttpRule value) {
        if (value != null) {
            ensureAdditionalBindingsIsMutable();
            this.additionalBindings_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addAdditionalBindings(Builder builderForValue) {
        ensureAdditionalBindingsIsMutable();
        this.additionalBindings_.add((HttpRule) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAdditionalBindings(int index, Builder builderForValue) {
        ensureAdditionalBindingsIsMutable();
        this.additionalBindings_.add(index, (HttpRule) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllAdditionalBindings(Iterable<? extends HttpRule> values) {
        ensureAdditionalBindingsIsMutable();
        AbstractMessageLite.addAll(values, this.additionalBindings_);
    }

    /* access modifiers changed from: private */
    public void clearAdditionalBindings() {
        this.additionalBindings_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeAdditionalBindings(int index) {
        ensureAdditionalBindingsIsMutable();
        this.additionalBindings_.remove(index);
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.selector_.isEmpty()) {
            output.writeString(1, getSelector());
        }
        if (this.patternCase_ == 2) {
            output.writeString(2, getGet());
        }
        if (this.patternCase_ == 3) {
            output.writeString(3, getPut());
        }
        if (this.patternCase_ == 4) {
            output.writeString(4, getPost());
        }
        if (this.patternCase_ == 5) {
            output.writeString(5, getDelete());
        }
        if (this.patternCase_ == 6) {
            output.writeString(6, getPatch());
        }
        if (!this.body_.isEmpty()) {
            output.writeString(7, getBody());
        }
        if (this.patternCase_ == 8) {
            output.writeMessage(8, (CustomHttpPattern) this.pattern_);
        }
        for (int i = 0; i < this.additionalBindings_.size(); i++) {
            output.writeMessage(11, (MessageLite) this.additionalBindings_.get(i));
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
        if (this.patternCase_ == 2) {
            size2 += CodedOutputStream.computeStringSize(2, getGet());
        }
        if (this.patternCase_ == 3) {
            size2 += CodedOutputStream.computeStringSize(3, getPut());
        }
        if (this.patternCase_ == 4) {
            size2 += CodedOutputStream.computeStringSize(4, getPost());
        }
        if (this.patternCase_ == 5) {
            size2 += CodedOutputStream.computeStringSize(5, getDelete());
        }
        if (this.patternCase_ == 6) {
            size2 += CodedOutputStream.computeStringSize(6, getPatch());
        }
        if (!this.body_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(7, getBody());
        }
        if (this.patternCase_ == 8) {
            size2 += CodedOutputStream.computeMessageSize(8, (CustomHttpPattern) this.pattern_);
        }
        for (int i = 0; i < this.additionalBindings_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(11, (MessageLite) this.additionalBindings_.get(i));
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static HttpRule parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (HttpRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HttpRule parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HttpRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HttpRule parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (HttpRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HttpRule parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HttpRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HttpRule parseFrom(InputStream input) throws IOException {
        return (HttpRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static HttpRule parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HttpRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static HttpRule parseDelimitedFrom(InputStream input) throws IOException {
        return (HttpRule) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static HttpRule parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HttpRule) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static HttpRule parseFrom(CodedInputStream input) throws IOException {
        return (HttpRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static HttpRule parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HttpRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(HttpRule prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<HttpRule, Builder> implements HttpRuleOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(HttpRule.DEFAULT_INSTANCE);
        }

        public PatternCase getPatternCase() {
            return ((HttpRule) this.instance).getPatternCase();
        }

        public Builder clearPattern() {
            copyOnWrite();
            ((HttpRule) this.instance).clearPattern();
            return this;
        }

        public String getSelector() {
            return ((HttpRule) this.instance).getSelector();
        }

        public ByteString getSelectorBytes() {
            return ((HttpRule) this.instance).getSelectorBytes();
        }

        public Builder setSelector(String value) {
            copyOnWrite();
            ((HttpRule) this.instance).setSelector(value);
            return this;
        }

        public Builder clearSelector() {
            copyOnWrite();
            ((HttpRule) this.instance).clearSelector();
            return this;
        }

        public Builder setSelectorBytes(ByteString value) {
            copyOnWrite();
            ((HttpRule) this.instance).setSelectorBytes(value);
            return this;
        }

        public String getGet() {
            return ((HttpRule) this.instance).getGet();
        }

        public ByteString getGetBytes() {
            return ((HttpRule) this.instance).getGetBytes();
        }

        public Builder setGet(String value) {
            copyOnWrite();
            ((HttpRule) this.instance).setGet(value);
            return this;
        }

        public Builder clearGet() {
            copyOnWrite();
            ((HttpRule) this.instance).clearGet();
            return this;
        }

        public Builder setGetBytes(ByteString value) {
            copyOnWrite();
            ((HttpRule) this.instance).setGetBytes(value);
            return this;
        }

        public String getPut() {
            return ((HttpRule) this.instance).getPut();
        }

        public ByteString getPutBytes() {
            return ((HttpRule) this.instance).getPutBytes();
        }

        public Builder setPut(String value) {
            copyOnWrite();
            ((HttpRule) this.instance).setPut(value);
            return this;
        }

        public Builder clearPut() {
            copyOnWrite();
            ((HttpRule) this.instance).clearPut();
            return this;
        }

        public Builder setPutBytes(ByteString value) {
            copyOnWrite();
            ((HttpRule) this.instance).setPutBytes(value);
            return this;
        }

        public String getPost() {
            return ((HttpRule) this.instance).getPost();
        }

        public ByteString getPostBytes() {
            return ((HttpRule) this.instance).getPostBytes();
        }

        public Builder setPost(String value) {
            copyOnWrite();
            ((HttpRule) this.instance).setPost(value);
            return this;
        }

        public Builder clearPost() {
            copyOnWrite();
            ((HttpRule) this.instance).clearPost();
            return this;
        }

        public Builder setPostBytes(ByteString value) {
            copyOnWrite();
            ((HttpRule) this.instance).setPostBytes(value);
            return this;
        }

        public String getDelete() {
            return ((HttpRule) this.instance).getDelete();
        }

        public ByteString getDeleteBytes() {
            return ((HttpRule) this.instance).getDeleteBytes();
        }

        public Builder setDelete(String value) {
            copyOnWrite();
            ((HttpRule) this.instance).setDelete(value);
            return this;
        }

        public Builder clearDelete() {
            copyOnWrite();
            ((HttpRule) this.instance).clearDelete();
            return this;
        }

        public Builder setDeleteBytes(ByteString value) {
            copyOnWrite();
            ((HttpRule) this.instance).setDeleteBytes(value);
            return this;
        }

        public String getPatch() {
            return ((HttpRule) this.instance).getPatch();
        }

        public ByteString getPatchBytes() {
            return ((HttpRule) this.instance).getPatchBytes();
        }

        public Builder setPatch(String value) {
            copyOnWrite();
            ((HttpRule) this.instance).setPatch(value);
            return this;
        }

        public Builder clearPatch() {
            copyOnWrite();
            ((HttpRule) this.instance).clearPatch();
            return this;
        }

        public Builder setPatchBytes(ByteString value) {
            copyOnWrite();
            ((HttpRule) this.instance).setPatchBytes(value);
            return this;
        }

        public CustomHttpPattern getCustom() {
            return ((HttpRule) this.instance).getCustom();
        }

        public Builder setCustom(CustomHttpPattern value) {
            copyOnWrite();
            ((HttpRule) this.instance).setCustom(value);
            return this;
        }

        public Builder setCustom(CustomHttpPattern.Builder builderForValue) {
            copyOnWrite();
            ((HttpRule) this.instance).setCustom(builderForValue);
            return this;
        }

        public Builder mergeCustom(CustomHttpPattern value) {
            copyOnWrite();
            ((HttpRule) this.instance).mergeCustom(value);
            return this;
        }

        public Builder clearCustom() {
            copyOnWrite();
            ((HttpRule) this.instance).clearCustom();
            return this;
        }

        public String getBody() {
            return ((HttpRule) this.instance).getBody();
        }

        public ByteString getBodyBytes() {
            return ((HttpRule) this.instance).getBodyBytes();
        }

        public Builder setBody(String value) {
            copyOnWrite();
            ((HttpRule) this.instance).setBody(value);
            return this;
        }

        public Builder clearBody() {
            copyOnWrite();
            ((HttpRule) this.instance).clearBody();
            return this;
        }

        public Builder setBodyBytes(ByteString value) {
            copyOnWrite();
            ((HttpRule) this.instance).setBodyBytes(value);
            return this;
        }

        public List<HttpRule> getAdditionalBindingsList() {
            return Collections.unmodifiableList(((HttpRule) this.instance).getAdditionalBindingsList());
        }

        public int getAdditionalBindingsCount() {
            return ((HttpRule) this.instance).getAdditionalBindingsCount();
        }

        public HttpRule getAdditionalBindings(int index) {
            return ((HttpRule) this.instance).getAdditionalBindings(index);
        }

        public Builder setAdditionalBindings(int index, HttpRule value) {
            copyOnWrite();
            ((HttpRule) this.instance).setAdditionalBindings(index, value);
            return this;
        }

        public Builder setAdditionalBindings(int index, Builder builderForValue) {
            copyOnWrite();
            ((HttpRule) this.instance).setAdditionalBindings(index, builderForValue);
            return this;
        }

        public Builder addAdditionalBindings(HttpRule value) {
            copyOnWrite();
            ((HttpRule) this.instance).addAdditionalBindings(value);
            return this;
        }

        public Builder addAdditionalBindings(int index, HttpRule value) {
            copyOnWrite();
            ((HttpRule) this.instance).addAdditionalBindings(index, value);
            return this;
        }

        public Builder addAdditionalBindings(Builder builderForValue) {
            copyOnWrite();
            ((HttpRule) this.instance).addAdditionalBindings(builderForValue);
            return this;
        }

        public Builder addAdditionalBindings(int index, Builder builderForValue) {
            copyOnWrite();
            ((HttpRule) this.instance).addAdditionalBindings(index, builderForValue);
            return this;
        }

        public Builder addAllAdditionalBindings(Iterable<? extends HttpRule> values) {
            copyOnWrite();
            ((HttpRule) this.instance).addAllAdditionalBindings(values);
            return this;
        }

        public Builder clearAdditionalBindings() {
            copyOnWrite();
            ((HttpRule) this.instance).clearAdditionalBindings();
            return this;
        }

        public Builder removeAdditionalBindings(int index) {
            copyOnWrite();
            ((HttpRule) this.instance).removeAdditionalBindings(index);
            return this;
        }
    }

    /* renamed from: com.google.api.HttpRule$1  reason: invalid class name */
    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$api$HttpRule$PatternCase;
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
            int[] iArr2 = new int[PatternCase.values().length];
            $SwitchMap$com$google$api$HttpRule$PatternCase = iArr2;
            try {
                iArr2[PatternCase.GET.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$api$HttpRule$PatternCase[PatternCase.PUT.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$google$api$HttpRule$PatternCase[PatternCase.POST.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$google$api$HttpRule$PatternCase[PatternCase.DELETE.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$google$api$HttpRule$PatternCase[PatternCase.PATCH.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$com$google$api$HttpRule$PatternCase[PatternCase.CUSTOM.ordinal()] = 6;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$com$google$api$HttpRule$PatternCase[PatternCase.PATTERN_NOT_SET.ordinal()] = 7;
            } catch (NoSuchFieldError e15) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
            case 1:
                return new HttpRule();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.additionalBindings_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                HttpRule other = (HttpRule) arg1;
                boolean z = true;
                this.selector_ = visitor.visitString(!this.selector_.isEmpty(), this.selector_, !other.selector_.isEmpty(), other.selector_);
                this.body_ = visitor.visitString(!this.body_.isEmpty(), this.body_, !other.body_.isEmpty(), other.body_);
                this.additionalBindings_ = visitor.visitList(this.additionalBindings_, other.additionalBindings_);
                switch (AnonymousClass1.$SwitchMap$com$google$api$HttpRule$PatternCase[other.getPatternCase().ordinal()]) {
                    case 1:
                        if (this.patternCase_ != 2) {
                            z = false;
                        }
                        this.pattern_ = visitor.visitOneofString(z, this.pattern_, other.pattern_);
                        break;
                    case 2:
                        if (this.patternCase_ != 3) {
                            z = false;
                        }
                        this.pattern_ = visitor.visitOneofString(z, this.pattern_, other.pattern_);
                        break;
                    case 3:
                        if (this.patternCase_ != 4) {
                            z = false;
                        }
                        this.pattern_ = visitor.visitOneofString(z, this.pattern_, other.pattern_);
                        break;
                    case 4:
                        if (this.patternCase_ != 5) {
                            z = false;
                        }
                        this.pattern_ = visitor.visitOneofString(z, this.pattern_, other.pattern_);
                        break;
                    case 5:
                        if (this.patternCase_ != 6) {
                            z = false;
                        }
                        this.pattern_ = visitor.visitOneofString(z, this.pattern_, other.pattern_);
                        break;
                    case 6:
                        if (this.patternCase_ != 8) {
                            z = false;
                        }
                        this.pattern_ = visitor.visitOneofMessage(z, this.pattern_, other.pattern_);
                        break;
                    case 7:
                        if (this.patternCase_ == 0) {
                            z = false;
                        }
                        visitor.visitOneofNotSet(z);
                        break;
                }
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    int i = other.patternCase_;
                    if (i != 0) {
                        this.patternCase_ = i;
                    }
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
                            this.selector_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            String s = input.readStringRequireUtf8();
                            this.patternCase_ = 2;
                            this.pattern_ = s;
                        } else if (tag == 26) {
                            String s2 = input.readStringRequireUtf8();
                            this.patternCase_ = 3;
                            this.pattern_ = s2;
                        } else if (tag == 34) {
                            String s3 = input.readStringRequireUtf8();
                            this.patternCase_ = 4;
                            this.pattern_ = s3;
                        } else if (tag == 42) {
                            String s4 = input.readStringRequireUtf8();
                            this.patternCase_ = 5;
                            this.pattern_ = s4;
                        } else if (tag == 50) {
                            String s5 = input.readStringRequireUtf8();
                            this.patternCase_ = 6;
                            this.pattern_ = s5;
                        } else if (tag == 58) {
                            this.body_ = input.readStringRequireUtf8();
                        } else if (tag == 66) {
                            CustomHttpPattern.Builder subBuilder = null;
                            if (this.patternCase_ == 8) {
                                subBuilder = (CustomHttpPattern.Builder) ((CustomHttpPattern) this.pattern_).toBuilder();
                            }
                            MessageLite readMessage = input.readMessage(CustomHttpPattern.parser(), extensionRegistry);
                            this.pattern_ = readMessage;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom((CustomHttpPattern) readMessage);
                                this.pattern_ = subBuilder.buildPartial();
                            }
                            this.patternCase_ = 8;
                        } else if (tag == 90) {
                            if (!this.additionalBindings_.isModifiable()) {
                                this.additionalBindings_ = GeneratedMessageLite.mutableCopy(this.additionalBindings_);
                            }
                            this.additionalBindings_.add((HttpRule) input.readMessage(parser(), extensionRegistry));
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
                    synchronized (HttpRule.class) {
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
        HttpRule httpRule = new HttpRule();
        DEFAULT_INSTANCE = httpRule;
        httpRule.makeImmutable();
    }

    public static HttpRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<HttpRule> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
