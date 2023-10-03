package com.google.firestore.v1;

import com.google.firestore.v1.Target;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public final class ListenRequest extends GeneratedMessageLite<ListenRequest, Builder> implements ListenRequestOrBuilder {
    public static final int ADD_TARGET_FIELD_NUMBER = 2;
    public static final int DATABASE_FIELD_NUMBER = 1;
    /* access modifiers changed from: private */
    public static final ListenRequest DEFAULT_INSTANCE;
    public static final int LABELS_FIELD_NUMBER = 4;
    private static volatile Parser<ListenRequest> PARSER = null;
    public static final int REMOVE_TARGET_FIELD_NUMBER = 3;
    private int bitField0_;
    private String database_ = "";
    private MapFieldLite<String, String> labels_ = MapFieldLite.emptyMapField();
    private int targetChangeCase_ = 0;
    private Object targetChange_;

    private ListenRequest() {
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public enum TargetChangeCase implements Internal.EnumLite {
        ADD_TARGET(2),
        REMOVE_TARGET(3),
        TARGETCHANGE_NOT_SET(0);
        
        private final int value;

        private TargetChangeCase(int value2) {
            this.value = value2;
        }

        @Deprecated
        public static TargetChangeCase valueOf(int value2) {
            return forNumber(value2);
        }

        public static TargetChangeCase forNumber(int value2) {
            if (value2 == 0) {
                return TARGETCHANGE_NOT_SET;
            }
            if (value2 == 2) {
                return ADD_TARGET;
            }
            if (value2 != 3) {
                return null;
            }
            return REMOVE_TARGET;
        }

        public int getNumber() {
            return this.value;
        }
    }

    public TargetChangeCase getTargetChangeCase() {
        return TargetChangeCase.forNumber(this.targetChangeCase_);
    }

    /* access modifiers changed from: private */
    public void clearTargetChange() {
        this.targetChangeCase_ = 0;
        this.targetChange_ = null;
    }

    public String getDatabase() {
        return this.database_;
    }

    public ByteString getDatabaseBytes() {
        return ByteString.copyFromUtf8(this.database_);
    }

    /* access modifiers changed from: private */
    public void setDatabase(String value) {
        if (value != null) {
            this.database_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearDatabase() {
        this.database_ = getDefaultInstance().getDatabase();
    }

    /* access modifiers changed from: private */
    public void setDatabaseBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.database_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public Target getAddTarget() {
        if (this.targetChangeCase_ == 2) {
            return (Target) this.targetChange_;
        }
        return Target.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setAddTarget(Target value) {
        if (value != null) {
            this.targetChange_ = value;
            this.targetChangeCase_ = 2;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setAddTarget(Target.Builder builderForValue) {
        this.targetChange_ = builderForValue.build();
        this.targetChangeCase_ = 2;
    }

    /* access modifiers changed from: private */
    public void mergeAddTarget(Target value) {
        if (this.targetChangeCase_ != 2 || this.targetChange_ == Target.getDefaultInstance()) {
            this.targetChange_ = value;
        } else {
            this.targetChange_ = ((Target.Builder) Target.newBuilder((Target) this.targetChange_).mergeFrom(value)).buildPartial();
        }
        this.targetChangeCase_ = 2;
    }

    /* access modifiers changed from: private */
    public void clearAddTarget() {
        if (this.targetChangeCase_ == 2) {
            this.targetChangeCase_ = 0;
            this.targetChange_ = null;
        }
    }

    public int getRemoveTarget() {
        if (this.targetChangeCase_ == 3) {
            return ((Integer) this.targetChange_).intValue();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public void setRemoveTarget(int value) {
        this.targetChangeCase_ = 3;
        this.targetChange_ = Integer.valueOf(value);
    }

    /* access modifiers changed from: private */
    public void clearRemoveTarget() {
        if (this.targetChangeCase_ == 3) {
            this.targetChangeCase_ = 0;
            this.targetChange_ = null;
        }
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    private static final class LabelsDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.STRING, "");

        private LabelsDefaultEntryHolder() {
        }
    }

    private MapFieldLite<String, String> internalGetLabels() {
        return this.labels_;
    }

    private MapFieldLite<String, String> internalGetMutableLabels() {
        if (!this.labels_.isMutable()) {
            this.labels_ = this.labels_.mutableCopy();
        }
        return this.labels_;
    }

    public int getLabelsCount() {
        return internalGetLabels().size();
    }

    public boolean containsLabels(String key) {
        if (key != null) {
            return internalGetLabels().containsKey(key);
        }
        throw null;
    }

    @Deprecated
    public Map<String, String> getLabels() {
        return getLabelsMap();
    }

    public Map<String, String> getLabelsMap() {
        return Collections.unmodifiableMap(internalGetLabels());
    }

    public String getLabelsOrDefault(String key, String defaultValue) {
        if (key != null) {
            Map<String, String> map = internalGetLabels();
            return map.containsKey(key) ? map.get(key) : defaultValue;
        }
        throw null;
    }

    public String getLabelsOrThrow(String key) {
        if (key != null) {
            Map<String, String> map = internalGetLabels();
            if (map.containsKey(key)) {
                return map.get(key);
            }
            throw new IllegalArgumentException();
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public Map<String, String> getMutableLabelsMap() {
        return internalGetMutableLabels();
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.database_.isEmpty()) {
            output.writeString(1, getDatabase());
        }
        if (this.targetChangeCase_ == 2) {
            output.writeMessage(2, (Target) this.targetChange_);
        }
        if (this.targetChangeCase_ == 3) {
            output.writeInt32(3, ((Integer) this.targetChange_).intValue());
        }
        for (Map.Entry<String, String> entry : internalGetLabels().entrySet()) {
            LabelsDefaultEntryHolder.defaultEntry.serializeTo(output, 4, entry.getKey(), entry.getValue());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.database_.isEmpty()) {
            size2 = 0 + CodedOutputStream.computeStringSize(1, getDatabase());
        }
        if (this.targetChangeCase_ == 2) {
            size2 += CodedOutputStream.computeMessageSize(2, (Target) this.targetChange_);
        }
        if (this.targetChangeCase_ == 3) {
            size2 += CodedOutputStream.computeInt32Size(3, ((Integer) this.targetChange_).intValue());
        }
        for (Map.Entry<String, String> entry : internalGetLabels().entrySet()) {
            size2 += LabelsDefaultEntryHolder.defaultEntry.computeMessageSize(4, entry.getKey(), entry.getValue());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static ListenRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (ListenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ListenRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ListenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ListenRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (ListenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ListenRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ListenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ListenRequest parseFrom(InputStream input) throws IOException {
        return (ListenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ListenRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ListenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ListenRequest parseDelimitedFrom(InputStream input) throws IOException {
        return (ListenRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static ListenRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ListenRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ListenRequest parseFrom(CodedInputStream input) throws IOException {
        return (ListenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ListenRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ListenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ListenRequest prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<ListenRequest, Builder> implements ListenRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(ListenRequest.DEFAULT_INSTANCE);
        }

        public TargetChangeCase getTargetChangeCase() {
            return ((ListenRequest) this.instance).getTargetChangeCase();
        }

        public Builder clearTargetChange() {
            copyOnWrite();
            ((ListenRequest) this.instance).clearTargetChange();
            return this;
        }

        public String getDatabase() {
            return ((ListenRequest) this.instance).getDatabase();
        }

        public ByteString getDatabaseBytes() {
            return ((ListenRequest) this.instance).getDatabaseBytes();
        }

        public Builder setDatabase(String value) {
            copyOnWrite();
            ((ListenRequest) this.instance).setDatabase(value);
            return this;
        }

        public Builder clearDatabase() {
            copyOnWrite();
            ((ListenRequest) this.instance).clearDatabase();
            return this;
        }

        public Builder setDatabaseBytes(ByteString value) {
            copyOnWrite();
            ((ListenRequest) this.instance).setDatabaseBytes(value);
            return this;
        }

        public Target getAddTarget() {
            return ((ListenRequest) this.instance).getAddTarget();
        }

        public Builder setAddTarget(Target value) {
            copyOnWrite();
            ((ListenRequest) this.instance).setAddTarget(value);
            return this;
        }

        public Builder setAddTarget(Target.Builder builderForValue) {
            copyOnWrite();
            ((ListenRequest) this.instance).setAddTarget(builderForValue);
            return this;
        }

        public Builder mergeAddTarget(Target value) {
            copyOnWrite();
            ((ListenRequest) this.instance).mergeAddTarget(value);
            return this;
        }

        public Builder clearAddTarget() {
            copyOnWrite();
            ((ListenRequest) this.instance).clearAddTarget();
            return this;
        }

        public int getRemoveTarget() {
            return ((ListenRequest) this.instance).getRemoveTarget();
        }

        public Builder setRemoveTarget(int value) {
            copyOnWrite();
            ((ListenRequest) this.instance).setRemoveTarget(value);
            return this;
        }

        public Builder clearRemoveTarget() {
            copyOnWrite();
            ((ListenRequest) this.instance).clearRemoveTarget();
            return this;
        }

        public int getLabelsCount() {
            return ((ListenRequest) this.instance).getLabelsMap().size();
        }

        public boolean containsLabels(String key) {
            if (key != null) {
                return ((ListenRequest) this.instance).getLabelsMap().containsKey(key);
            }
            throw null;
        }

        public Builder clearLabels() {
            copyOnWrite();
            ((ListenRequest) this.instance).getMutableLabelsMap().clear();
            return this;
        }

        public Builder removeLabels(String key) {
            if (key != null) {
                copyOnWrite();
                ((ListenRequest) this.instance).getMutableLabelsMap().remove(key);
                return this;
            }
            throw null;
        }

        @Deprecated
        public Map<String, String> getLabels() {
            return getLabelsMap();
        }

        public Map<String, String> getLabelsMap() {
            return Collections.unmodifiableMap(((ListenRequest) this.instance).getLabelsMap());
        }

        public String getLabelsOrDefault(String key, String defaultValue) {
            if (key != null) {
                Map<String, String> map = ((ListenRequest) this.instance).getLabelsMap();
                return map.containsKey(key) ? map.get(key) : defaultValue;
            }
            throw null;
        }

        public String getLabelsOrThrow(String key) {
            if (key != null) {
                Map<String, String> map = ((ListenRequest) this.instance).getLabelsMap();
                if (map.containsKey(key)) {
                    return map.get(key);
                }
                throw new IllegalArgumentException();
            }
            throw null;
        }

        public Builder putLabels(String key, String value) {
            if (key == null) {
                throw null;
            } else if (value != null) {
                copyOnWrite();
                ((ListenRequest) this.instance).getMutableLabelsMap().put(key, value);
                return this;
            } else {
                throw null;
            }
        }

        public Builder putAllLabels(Map<String, String> values) {
            copyOnWrite();
            ((ListenRequest) this.instance).getMutableLabelsMap().putAll(values);
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.ListenRequest$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$ListenRequest$TargetChangeCase;
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
            int[] iArr2 = new int[TargetChangeCase.values().length];
            $SwitchMap$com$google$firestore$v1$ListenRequest$TargetChangeCase = iArr2;
            try {
                iArr2[TargetChangeCase.ADD_TARGET.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$ListenRequest$TargetChangeCase[TargetChangeCase.REMOVE_TARGET.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$ListenRequest$TargetChangeCase[TargetChangeCase.TARGETCHANGE_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
            case 1:
                return new ListenRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.labels_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                ListenRequest other = (ListenRequest) arg1;
                boolean z = true;
                this.database_ = visitor.visitString(!this.database_.isEmpty(), this.database_, !other.database_.isEmpty(), other.database_);
                this.labels_ = visitor.visitMap(this.labels_, other.internalGetLabels());
                int i = AnonymousClass1.$SwitchMap$com$google$firestore$v1$ListenRequest$TargetChangeCase[other.getTargetChangeCase().ordinal()];
                if (i == 1) {
                    if (this.targetChangeCase_ != 2) {
                        z = false;
                    }
                    this.targetChange_ = visitor.visitOneofMessage(z, this.targetChange_, other.targetChange_);
                } else if (i == 2) {
                    if (this.targetChangeCase_ != 3) {
                        z = false;
                    }
                    this.targetChange_ = visitor.visitOneofInt(z, this.targetChange_, other.targetChange_);
                } else if (i == 3) {
                    if (this.targetChangeCase_ == 0) {
                        z = false;
                    }
                    visitor.visitOneofNotSet(z);
                }
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    int i2 = other.targetChangeCase_;
                    if (i2 != 0) {
                        this.targetChangeCase_ = i2;
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
                            this.database_ = input.readStringRequireUtf8();
                        } else if (tag == 18) {
                            Target.Builder subBuilder = null;
                            if (this.targetChangeCase_ == 2) {
                                subBuilder = (Target.Builder) ((Target) this.targetChange_).toBuilder();
                            }
                            MessageLite readMessage = input.readMessage(Target.parser(), extensionRegistry);
                            this.targetChange_ = readMessage;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom((Target) readMessage);
                                this.targetChange_ = subBuilder.buildPartial();
                            }
                            this.targetChangeCase_ = 2;
                        } else if (tag == 24) {
                            this.targetChangeCase_ = 3;
                            this.targetChange_ = Integer.valueOf(input.readInt32());
                        } else if (tag == 34) {
                            if (!this.labels_.isMutable()) {
                                this.labels_ = this.labels_.mutableCopy();
                            }
                            LabelsDefaultEntryHolder.defaultEntry.parseInto(this.labels_, input, extensionRegistry);
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
                    synchronized (ListenRequest.class) {
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
        ListenRequest listenRequest = new ListenRequest();
        DEFAULT_INSTANCE = listenRequest;
        listenRequest.makeImmutable();
    }

    public static ListenRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<ListenRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
