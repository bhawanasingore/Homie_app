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
public final class Help extends GeneratedMessageLite<Help, Builder> implements HelpOrBuilder {
    /* access modifiers changed from: private */
    public static final Help DEFAULT_INSTANCE;
    public static final int LINKS_FIELD_NUMBER = 1;
    private static volatile Parser<Help> PARSER;
    private Internal.ProtobufList<Link> links_ = emptyProtobufList();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface LinkOrBuilder extends MessageLiteOrBuilder {
        String getDescription();

        ByteString getDescriptionBytes();

        String getUrl();

        ByteString getUrlBytes();
    }

    private Help() {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Link extends GeneratedMessageLite<Link, Builder> implements LinkOrBuilder {
        /* access modifiers changed from: private */
        public static final Link DEFAULT_INSTANCE;
        public static final int DESCRIPTION_FIELD_NUMBER = 1;
        private static volatile Parser<Link> PARSER = null;
        public static final int URL_FIELD_NUMBER = 2;
        private String description_ = "";
        private String url_ = "";

        private Link() {
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

        public String getUrl() {
            return this.url_;
        }

        public ByteString getUrlBytes() {
            return ByteString.copyFromUtf8(this.url_);
        }

        /* access modifiers changed from: private */
        public void setUrl(String value) {
            if (value != null) {
                this.url_ = value;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearUrl() {
            this.url_ = getDefaultInstance().getUrl();
        }

        /* access modifiers changed from: private */
        public void setUrlBytes(ByteString value) {
            if (value != null) {
                checkByteStringIsUtf8(value);
                this.url_ = value.toStringUtf8();
                return;
            }
            throw null;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (!this.description_.isEmpty()) {
                output.writeString(1, getDescription());
            }
            if (!this.url_.isEmpty()) {
                output.writeString(2, getUrl());
            }
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (!this.description_.isEmpty()) {
                size2 = 0 + CodedOutputStream.computeStringSize(1, getDescription());
            }
            if (!this.url_.isEmpty()) {
                size2 += CodedOutputStream.computeStringSize(2, getUrl());
            }
            this.memoizedSerializedSize = size2;
            return size2;
        }

        public static Link parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Link) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Link parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Link) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Link parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Link) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Link parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Link) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Link parseFrom(InputStream input) throws IOException {
            return (Link) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Link parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Link) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Link parseDelimitedFrom(InputStream input) throws IOException {
            return (Link) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static Link parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Link) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Link parseFrom(CodedInputStream input) throws IOException {
            return (Link) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Link parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Link) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Link prototype) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<Link, Builder> implements LinkOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            private Builder() {
                super(Link.DEFAULT_INSTANCE);
            }

            public String getDescription() {
                return ((Link) this.instance).getDescription();
            }

            public ByteString getDescriptionBytes() {
                return ((Link) this.instance).getDescriptionBytes();
            }

            public Builder setDescription(String value) {
                copyOnWrite();
                ((Link) this.instance).setDescription(value);
                return this;
            }

            public Builder clearDescription() {
                copyOnWrite();
                ((Link) this.instance).clearDescription();
                return this;
            }

            public Builder setDescriptionBytes(ByteString value) {
                copyOnWrite();
                ((Link) this.instance).setDescriptionBytes(value);
                return this;
            }

            public String getUrl() {
                return ((Link) this.instance).getUrl();
            }

            public ByteString getUrlBytes() {
                return ((Link) this.instance).getUrlBytes();
            }

            public Builder setUrl(String value) {
                copyOnWrite();
                ((Link) this.instance).setUrl(value);
                return this;
            }

            public Builder clearUrl() {
                copyOnWrite();
                ((Link) this.instance).clearUrl();
                return this;
            }

            public Builder setUrlBytes(ByteString value) {
                copyOnWrite();
                ((Link) this.instance).setUrlBytes(value);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new Link();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                    Link other = (Link) arg1;
                    this.description_ = visitor.visitString(!this.description_.isEmpty(), this.description_, !other.description_.isEmpty(), other.description_);
                    this.url_ = visitor.visitString(!this.url_.isEmpty(), this.url_, !other.url_.isEmpty(), other.url_);
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
                                this.description_ = input.readStringRequireUtf8();
                            } else if (tag == 18) {
                                this.url_ = input.readStringRequireUtf8();
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
                        synchronized (Link.class) {
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
            Link link = new Link();
            DEFAULT_INSTANCE = link;
            link.makeImmutable();
        }

        public static Link getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Link> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.google.rpc.Help$1  reason: invalid class name */
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

    public List<Link> getLinksList() {
        return this.links_;
    }

    public List<? extends LinkOrBuilder> getLinksOrBuilderList() {
        return this.links_;
    }

    public int getLinksCount() {
        return this.links_.size();
    }

    public Link getLinks(int index) {
        return (Link) this.links_.get(index);
    }

    public LinkOrBuilder getLinksOrBuilder(int index) {
        return (LinkOrBuilder) this.links_.get(index);
    }

    private void ensureLinksIsMutable() {
        if (!this.links_.isModifiable()) {
            this.links_ = GeneratedMessageLite.mutableCopy(this.links_);
        }
    }

    /* access modifiers changed from: private */
    public void setLinks(int index, Link value) {
        if (value != null) {
            ensureLinksIsMutable();
            this.links_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setLinks(int index, Link.Builder builderForValue) {
        ensureLinksIsMutable();
        this.links_.set(index, (Link) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addLinks(Link value) {
        if (value != null) {
            ensureLinksIsMutable();
            this.links_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addLinks(int index, Link value) {
        if (value != null) {
            ensureLinksIsMutable();
            this.links_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addLinks(Link.Builder builderForValue) {
        ensureLinksIsMutable();
        this.links_.add((Link) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addLinks(int index, Link.Builder builderForValue) {
        ensureLinksIsMutable();
        this.links_.add(index, (Link) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllLinks(Iterable<? extends Link> values) {
        ensureLinksIsMutable();
        AbstractMessageLite.addAll(values, this.links_);
    }

    /* access modifiers changed from: private */
    public void clearLinks() {
        this.links_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeLinks(int index) {
        ensureLinksIsMutable();
        this.links_.remove(index);
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        for (int i = 0; i < this.links_.size(); i++) {
            output.writeMessage(1, (MessageLite) this.links_.get(i));
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        for (int i = 0; i < this.links_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.links_.get(i));
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Help parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Help) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Help parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Help) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Help parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Help) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Help parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Help) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Help parseFrom(InputStream input) throws IOException {
        return (Help) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Help parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Help) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Help parseDelimitedFrom(InputStream input) throws IOException {
        return (Help) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Help parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Help) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Help parseFrom(CodedInputStream input) throws IOException {
        return (Help) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Help parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Help) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Help prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Help, Builder> implements HelpOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Help.DEFAULT_INSTANCE);
        }

        public List<Link> getLinksList() {
            return Collections.unmodifiableList(((Help) this.instance).getLinksList());
        }

        public int getLinksCount() {
            return ((Help) this.instance).getLinksCount();
        }

        public Link getLinks(int index) {
            return ((Help) this.instance).getLinks(index);
        }

        public Builder setLinks(int index, Link value) {
            copyOnWrite();
            ((Help) this.instance).setLinks(index, value);
            return this;
        }

        public Builder setLinks(int index, Link.Builder builderForValue) {
            copyOnWrite();
            ((Help) this.instance).setLinks(index, builderForValue);
            return this;
        }

        public Builder addLinks(Link value) {
            copyOnWrite();
            ((Help) this.instance).addLinks(value);
            return this;
        }

        public Builder addLinks(int index, Link value) {
            copyOnWrite();
            ((Help) this.instance).addLinks(index, value);
            return this;
        }

        public Builder addLinks(Link.Builder builderForValue) {
            copyOnWrite();
            ((Help) this.instance).addLinks(builderForValue);
            return this;
        }

        public Builder addLinks(int index, Link.Builder builderForValue) {
            copyOnWrite();
            ((Help) this.instance).addLinks(index, builderForValue);
            return this;
        }

        public Builder addAllLinks(Iterable<? extends Link> values) {
            copyOnWrite();
            ((Help) this.instance).addAllLinks(values);
            return this;
        }

        public Builder clearLinks() {
            copyOnWrite();
            ((Help) this.instance).clearLinks();
            return this;
        }

        public Builder removeLinks(int index) {
            copyOnWrite();
            ((Help) this.instance).removeLinks(index);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
            case 1:
                return new Help();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.links_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                this.links_ = ((GeneratedMessageLite.Visitor) arg0).visitList(this.links_, ((Help) arg1).links_);
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
                            if (!this.links_.isModifiable()) {
                                this.links_ = GeneratedMessageLite.mutableCopy(this.links_);
                            }
                            this.links_.add((Link) input.readMessage(Link.parser(), extensionRegistry));
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
                    synchronized (Help.class) {
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
        Help help = new Help();
        DEFAULT_INSTANCE = help;
        help.makeImmutable();
    }

    public static Help getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Help> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
