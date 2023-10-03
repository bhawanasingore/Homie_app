package com.google.api;

import com.google.api.MetricRule;
import com.google.api.QuotaLimit;
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
public final class Quota extends GeneratedMessageLite<Quota, Builder> implements QuotaOrBuilder {
    /* access modifiers changed from: private */
    public static final Quota DEFAULT_INSTANCE;
    public static final int LIMITS_FIELD_NUMBER = 3;
    public static final int METRIC_RULES_FIELD_NUMBER = 4;
    private static volatile Parser<Quota> PARSER;
    private Internal.ProtobufList<QuotaLimit> limits_ = emptyProtobufList();
    private Internal.ProtobufList<MetricRule> metricRules_ = emptyProtobufList();

    private Quota() {
    }

    public List<QuotaLimit> getLimitsList() {
        return this.limits_;
    }

    public List<? extends QuotaLimitOrBuilder> getLimitsOrBuilderList() {
        return this.limits_;
    }

    public int getLimitsCount() {
        return this.limits_.size();
    }

    public QuotaLimit getLimits(int index) {
        return (QuotaLimit) this.limits_.get(index);
    }

    public QuotaLimitOrBuilder getLimitsOrBuilder(int index) {
        return (QuotaLimitOrBuilder) this.limits_.get(index);
    }

    private void ensureLimitsIsMutable() {
        if (!this.limits_.isModifiable()) {
            this.limits_ = GeneratedMessageLite.mutableCopy(this.limits_);
        }
    }

    /* access modifiers changed from: private */
    public void setLimits(int index, QuotaLimit value) {
        if (value != null) {
            ensureLimitsIsMutable();
            this.limits_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setLimits(int index, QuotaLimit.Builder builderForValue) {
        ensureLimitsIsMutable();
        this.limits_.set(index, (QuotaLimit) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addLimits(QuotaLimit value) {
        if (value != null) {
            ensureLimitsIsMutable();
            this.limits_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addLimits(int index, QuotaLimit value) {
        if (value != null) {
            ensureLimitsIsMutable();
            this.limits_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addLimits(QuotaLimit.Builder builderForValue) {
        ensureLimitsIsMutable();
        this.limits_.add((QuotaLimit) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addLimits(int index, QuotaLimit.Builder builderForValue) {
        ensureLimitsIsMutable();
        this.limits_.add(index, (QuotaLimit) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllLimits(Iterable<? extends QuotaLimit> values) {
        ensureLimitsIsMutable();
        AbstractMessageLite.addAll(values, this.limits_);
    }

    /* access modifiers changed from: private */
    public void clearLimits() {
        this.limits_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeLimits(int index) {
        ensureLimitsIsMutable();
        this.limits_.remove(index);
    }

    public List<MetricRule> getMetricRulesList() {
        return this.metricRules_;
    }

    public List<? extends MetricRuleOrBuilder> getMetricRulesOrBuilderList() {
        return this.metricRules_;
    }

    public int getMetricRulesCount() {
        return this.metricRules_.size();
    }

    public MetricRule getMetricRules(int index) {
        return (MetricRule) this.metricRules_.get(index);
    }

    public MetricRuleOrBuilder getMetricRulesOrBuilder(int index) {
        return (MetricRuleOrBuilder) this.metricRules_.get(index);
    }

    private void ensureMetricRulesIsMutable() {
        if (!this.metricRules_.isModifiable()) {
            this.metricRules_ = GeneratedMessageLite.mutableCopy(this.metricRules_);
        }
    }

    /* access modifiers changed from: private */
    public void setMetricRules(int index, MetricRule value) {
        if (value != null) {
            ensureMetricRulesIsMutable();
            this.metricRules_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setMetricRules(int index, MetricRule.Builder builderForValue) {
        ensureMetricRulesIsMutable();
        this.metricRules_.set(index, (MetricRule) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addMetricRules(MetricRule value) {
        if (value != null) {
            ensureMetricRulesIsMutable();
            this.metricRules_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addMetricRules(int index, MetricRule value) {
        if (value != null) {
            ensureMetricRulesIsMutable();
            this.metricRules_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addMetricRules(MetricRule.Builder builderForValue) {
        ensureMetricRulesIsMutable();
        this.metricRules_.add((MetricRule) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addMetricRules(int index, MetricRule.Builder builderForValue) {
        ensureMetricRulesIsMutable();
        this.metricRules_.add(index, (MetricRule) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllMetricRules(Iterable<? extends MetricRule> values) {
        ensureMetricRulesIsMutable();
        AbstractMessageLite.addAll(values, this.metricRules_);
    }

    /* access modifiers changed from: private */
    public void clearMetricRules() {
        this.metricRules_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeMetricRules(int index) {
        ensureMetricRulesIsMutable();
        this.metricRules_.remove(index);
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        for (int i = 0; i < this.limits_.size(); i++) {
            output.writeMessage(3, (MessageLite) this.limits_.get(i));
        }
        for (int i2 = 0; i2 < this.metricRules_.size(); i2++) {
            output.writeMessage(4, (MessageLite) this.metricRules_.get(i2));
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        for (int i = 0; i < this.limits_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(3, (MessageLite) this.limits_.get(i));
        }
        for (int i2 = 0; i2 < this.metricRules_.size(); i2++) {
            size2 += CodedOutputStream.computeMessageSize(4, (MessageLite) this.metricRules_.get(i2));
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Quota parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Quota) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Quota parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Quota) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Quota parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Quota) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Quota parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Quota) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Quota parseFrom(InputStream input) throws IOException {
        return (Quota) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Quota parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Quota) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Quota parseDelimitedFrom(InputStream input) throws IOException {
        return (Quota) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Quota parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Quota) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Quota parseFrom(CodedInputStream input) throws IOException {
        return (Quota) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Quota parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Quota) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Quota prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Quota, Builder> implements QuotaOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Quota.DEFAULT_INSTANCE);
        }

        public List<QuotaLimit> getLimitsList() {
            return Collections.unmodifiableList(((Quota) this.instance).getLimitsList());
        }

        public int getLimitsCount() {
            return ((Quota) this.instance).getLimitsCount();
        }

        public QuotaLimit getLimits(int index) {
            return ((Quota) this.instance).getLimits(index);
        }

        public Builder setLimits(int index, QuotaLimit value) {
            copyOnWrite();
            ((Quota) this.instance).setLimits(index, value);
            return this;
        }

        public Builder setLimits(int index, QuotaLimit.Builder builderForValue) {
            copyOnWrite();
            ((Quota) this.instance).setLimits(index, builderForValue);
            return this;
        }

        public Builder addLimits(QuotaLimit value) {
            copyOnWrite();
            ((Quota) this.instance).addLimits(value);
            return this;
        }

        public Builder addLimits(int index, QuotaLimit value) {
            copyOnWrite();
            ((Quota) this.instance).addLimits(index, value);
            return this;
        }

        public Builder addLimits(QuotaLimit.Builder builderForValue) {
            copyOnWrite();
            ((Quota) this.instance).addLimits(builderForValue);
            return this;
        }

        public Builder addLimits(int index, QuotaLimit.Builder builderForValue) {
            copyOnWrite();
            ((Quota) this.instance).addLimits(index, builderForValue);
            return this;
        }

        public Builder addAllLimits(Iterable<? extends QuotaLimit> values) {
            copyOnWrite();
            ((Quota) this.instance).addAllLimits(values);
            return this;
        }

        public Builder clearLimits() {
            copyOnWrite();
            ((Quota) this.instance).clearLimits();
            return this;
        }

        public Builder removeLimits(int index) {
            copyOnWrite();
            ((Quota) this.instance).removeLimits(index);
            return this;
        }

        public List<MetricRule> getMetricRulesList() {
            return Collections.unmodifiableList(((Quota) this.instance).getMetricRulesList());
        }

        public int getMetricRulesCount() {
            return ((Quota) this.instance).getMetricRulesCount();
        }

        public MetricRule getMetricRules(int index) {
            return ((Quota) this.instance).getMetricRules(index);
        }

        public Builder setMetricRules(int index, MetricRule value) {
            copyOnWrite();
            ((Quota) this.instance).setMetricRules(index, value);
            return this;
        }

        public Builder setMetricRules(int index, MetricRule.Builder builderForValue) {
            copyOnWrite();
            ((Quota) this.instance).setMetricRules(index, builderForValue);
            return this;
        }

        public Builder addMetricRules(MetricRule value) {
            copyOnWrite();
            ((Quota) this.instance).addMetricRules(value);
            return this;
        }

        public Builder addMetricRules(int index, MetricRule value) {
            copyOnWrite();
            ((Quota) this.instance).addMetricRules(index, value);
            return this;
        }

        public Builder addMetricRules(MetricRule.Builder builderForValue) {
            copyOnWrite();
            ((Quota) this.instance).addMetricRules(builderForValue);
            return this;
        }

        public Builder addMetricRules(int index, MetricRule.Builder builderForValue) {
            copyOnWrite();
            ((Quota) this.instance).addMetricRules(index, builderForValue);
            return this;
        }

        public Builder addAllMetricRules(Iterable<? extends MetricRule> values) {
            copyOnWrite();
            ((Quota) this.instance).addAllMetricRules(values);
            return this;
        }

        public Builder clearMetricRules() {
            copyOnWrite();
            ((Quota) this.instance).clearMetricRules();
            return this;
        }

        public Builder removeMetricRules(int index) {
            copyOnWrite();
            ((Quota) this.instance).removeMetricRules(index);
            return this;
        }
    }

    /* renamed from: com.google.api.Quota$1  reason: invalid class name */
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
                return new Quota();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.limits_.makeImmutable();
                this.metricRules_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                Quota other = (Quota) arg1;
                this.limits_ = visitor.visitList(this.limits_, other.limits_);
                this.metricRules_ = visitor.visitList(this.metricRules_, other.metricRules_);
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
                        } else if (tag == 26) {
                            if (!this.limits_.isModifiable()) {
                                this.limits_ = GeneratedMessageLite.mutableCopy(this.limits_);
                            }
                            this.limits_.add((QuotaLimit) input.readMessage(QuotaLimit.parser(), extensionRegistry));
                        } else if (tag == 34) {
                            if (!this.metricRules_.isModifiable()) {
                                this.metricRules_ = GeneratedMessageLite.mutableCopy(this.metricRules_);
                            }
                            this.metricRules_.add((MetricRule) input.readMessage(MetricRule.parser(), extensionRegistry));
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
                    synchronized (Quota.class) {
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
        Quota quota = new Quota();
        DEFAULT_INSTANCE = quota;
        quota.makeImmutable();
    }

    public static Quota getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Quota> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
