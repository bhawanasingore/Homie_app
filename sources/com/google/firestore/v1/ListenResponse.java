package com.google.firestore.v1;

import com.google.firestore.v1.DocumentChange;
import com.google.firestore.v1.DocumentDelete;
import com.google.firestore.v1.DocumentRemove;
import com.google.firestore.v1.ExistenceFilter;
import com.google.firestore.v1.TargetChange;
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

/* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
public final class ListenResponse extends GeneratedMessageLite<ListenResponse, Builder> implements ListenResponseOrBuilder {
    /* access modifiers changed from: private */
    public static final ListenResponse DEFAULT_INSTANCE;
    public static final int DOCUMENT_CHANGE_FIELD_NUMBER = 3;
    public static final int DOCUMENT_DELETE_FIELD_NUMBER = 4;
    public static final int DOCUMENT_REMOVE_FIELD_NUMBER = 6;
    public static final int FILTER_FIELD_NUMBER = 5;
    private static volatile Parser<ListenResponse> PARSER = null;
    public static final int TARGET_CHANGE_FIELD_NUMBER = 2;
    private int responseTypeCase_ = 0;
    private Object responseType_;

    private ListenResponse() {
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public enum ResponseTypeCase implements Internal.EnumLite {
        TARGET_CHANGE(2),
        DOCUMENT_CHANGE(3),
        DOCUMENT_DELETE(4),
        DOCUMENT_REMOVE(6),
        FILTER(5),
        RESPONSETYPE_NOT_SET(0);
        
        private final int value;

        private ResponseTypeCase(int value2) {
            this.value = value2;
        }

        @Deprecated
        public static ResponseTypeCase valueOf(int value2) {
            return forNumber(value2);
        }

        public static ResponseTypeCase forNumber(int value2) {
            if (value2 == 0) {
                return RESPONSETYPE_NOT_SET;
            }
            if (value2 == 2) {
                return TARGET_CHANGE;
            }
            if (value2 == 3) {
                return DOCUMENT_CHANGE;
            }
            if (value2 == 4) {
                return DOCUMENT_DELETE;
            }
            if (value2 == 5) {
                return FILTER;
            }
            if (value2 != 6) {
                return null;
            }
            return DOCUMENT_REMOVE;
        }

        public int getNumber() {
            return this.value;
        }
    }

    public ResponseTypeCase getResponseTypeCase() {
        return ResponseTypeCase.forNumber(this.responseTypeCase_);
    }

    /* access modifiers changed from: private */
    public void clearResponseType() {
        this.responseTypeCase_ = 0;
        this.responseType_ = null;
    }

    public TargetChange getTargetChange() {
        if (this.responseTypeCase_ == 2) {
            return (TargetChange) this.responseType_;
        }
        return TargetChange.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setTargetChange(TargetChange value) {
        if (value != null) {
            this.responseType_ = value;
            this.responseTypeCase_ = 2;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setTargetChange(TargetChange.Builder builderForValue) {
        this.responseType_ = builderForValue.build();
        this.responseTypeCase_ = 2;
    }

    /* access modifiers changed from: private */
    public void mergeTargetChange(TargetChange value) {
        if (this.responseTypeCase_ != 2 || this.responseType_ == TargetChange.getDefaultInstance()) {
            this.responseType_ = value;
        } else {
            this.responseType_ = ((TargetChange.Builder) TargetChange.newBuilder((TargetChange) this.responseType_).mergeFrom(value)).buildPartial();
        }
        this.responseTypeCase_ = 2;
    }

    /* access modifiers changed from: private */
    public void clearTargetChange() {
        if (this.responseTypeCase_ == 2) {
            this.responseTypeCase_ = 0;
            this.responseType_ = null;
        }
    }

    public DocumentChange getDocumentChange() {
        if (this.responseTypeCase_ == 3) {
            return (DocumentChange) this.responseType_;
        }
        return DocumentChange.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setDocumentChange(DocumentChange value) {
        if (value != null) {
            this.responseType_ = value;
            this.responseTypeCase_ = 3;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setDocumentChange(DocumentChange.Builder builderForValue) {
        this.responseType_ = builderForValue.build();
        this.responseTypeCase_ = 3;
    }

    /* access modifiers changed from: private */
    public void mergeDocumentChange(DocumentChange value) {
        if (this.responseTypeCase_ != 3 || this.responseType_ == DocumentChange.getDefaultInstance()) {
            this.responseType_ = value;
        } else {
            this.responseType_ = ((DocumentChange.Builder) DocumentChange.newBuilder((DocumentChange) this.responseType_).mergeFrom(value)).buildPartial();
        }
        this.responseTypeCase_ = 3;
    }

    /* access modifiers changed from: private */
    public void clearDocumentChange() {
        if (this.responseTypeCase_ == 3) {
            this.responseTypeCase_ = 0;
            this.responseType_ = null;
        }
    }

    public DocumentDelete getDocumentDelete() {
        if (this.responseTypeCase_ == 4) {
            return (DocumentDelete) this.responseType_;
        }
        return DocumentDelete.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setDocumentDelete(DocumentDelete value) {
        if (value != null) {
            this.responseType_ = value;
            this.responseTypeCase_ = 4;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setDocumentDelete(DocumentDelete.Builder builderForValue) {
        this.responseType_ = builderForValue.build();
        this.responseTypeCase_ = 4;
    }

    /* access modifiers changed from: private */
    public void mergeDocumentDelete(DocumentDelete value) {
        if (this.responseTypeCase_ != 4 || this.responseType_ == DocumentDelete.getDefaultInstance()) {
            this.responseType_ = value;
        } else {
            this.responseType_ = ((DocumentDelete.Builder) DocumentDelete.newBuilder((DocumentDelete) this.responseType_).mergeFrom(value)).buildPartial();
        }
        this.responseTypeCase_ = 4;
    }

    /* access modifiers changed from: private */
    public void clearDocumentDelete() {
        if (this.responseTypeCase_ == 4) {
            this.responseTypeCase_ = 0;
            this.responseType_ = null;
        }
    }

    public DocumentRemove getDocumentRemove() {
        if (this.responseTypeCase_ == 6) {
            return (DocumentRemove) this.responseType_;
        }
        return DocumentRemove.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setDocumentRemove(DocumentRemove value) {
        if (value != null) {
            this.responseType_ = value;
            this.responseTypeCase_ = 6;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setDocumentRemove(DocumentRemove.Builder builderForValue) {
        this.responseType_ = builderForValue.build();
        this.responseTypeCase_ = 6;
    }

    /* access modifiers changed from: private */
    public void mergeDocumentRemove(DocumentRemove value) {
        if (this.responseTypeCase_ != 6 || this.responseType_ == DocumentRemove.getDefaultInstance()) {
            this.responseType_ = value;
        } else {
            this.responseType_ = ((DocumentRemove.Builder) DocumentRemove.newBuilder((DocumentRemove) this.responseType_).mergeFrom(value)).buildPartial();
        }
        this.responseTypeCase_ = 6;
    }

    /* access modifiers changed from: private */
    public void clearDocumentRemove() {
        if (this.responseTypeCase_ == 6) {
            this.responseTypeCase_ = 0;
            this.responseType_ = null;
        }
    }

    public ExistenceFilter getFilter() {
        if (this.responseTypeCase_ == 5) {
            return (ExistenceFilter) this.responseType_;
        }
        return ExistenceFilter.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setFilter(ExistenceFilter value) {
        if (value != null) {
            this.responseType_ = value;
            this.responseTypeCase_ = 5;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setFilter(ExistenceFilter.Builder builderForValue) {
        this.responseType_ = builderForValue.build();
        this.responseTypeCase_ = 5;
    }

    /* access modifiers changed from: private */
    public void mergeFilter(ExistenceFilter value) {
        if (this.responseTypeCase_ != 5 || this.responseType_ == ExistenceFilter.getDefaultInstance()) {
            this.responseType_ = value;
        } else {
            this.responseType_ = ((ExistenceFilter.Builder) ExistenceFilter.newBuilder((ExistenceFilter) this.responseType_).mergeFrom(value)).buildPartial();
        }
        this.responseTypeCase_ = 5;
    }

    /* access modifiers changed from: private */
    public void clearFilter() {
        if (this.responseTypeCase_ == 5) {
            this.responseTypeCase_ = 0;
            this.responseType_ = null;
        }
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (this.responseTypeCase_ == 2) {
            output.writeMessage(2, (TargetChange) this.responseType_);
        }
        if (this.responseTypeCase_ == 3) {
            output.writeMessage(3, (DocumentChange) this.responseType_);
        }
        if (this.responseTypeCase_ == 4) {
            output.writeMessage(4, (DocumentDelete) this.responseType_);
        }
        if (this.responseTypeCase_ == 5) {
            output.writeMessage(5, (ExistenceFilter) this.responseType_);
        }
        if (this.responseTypeCase_ == 6) {
            output.writeMessage(6, (DocumentRemove) this.responseType_);
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (this.responseTypeCase_ == 2) {
            size2 = 0 + CodedOutputStream.computeMessageSize(2, (TargetChange) this.responseType_);
        }
        if (this.responseTypeCase_ == 3) {
            size2 += CodedOutputStream.computeMessageSize(3, (DocumentChange) this.responseType_);
        }
        if (this.responseTypeCase_ == 4) {
            size2 += CodedOutputStream.computeMessageSize(4, (DocumentDelete) this.responseType_);
        }
        if (this.responseTypeCase_ == 5) {
            size2 += CodedOutputStream.computeMessageSize(5, (ExistenceFilter) this.responseType_);
        }
        if (this.responseTypeCase_ == 6) {
            size2 += CodedOutputStream.computeMessageSize(6, (DocumentRemove) this.responseType_);
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static ListenResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (ListenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ListenResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ListenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ListenResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (ListenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ListenResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ListenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ListenResponse parseFrom(InputStream input) throws IOException {
        return (ListenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ListenResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ListenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ListenResponse parseDelimitedFrom(InputStream input) throws IOException {
        return (ListenResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static ListenResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ListenResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ListenResponse parseFrom(CodedInputStream input) throws IOException {
        return (ListenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ListenResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ListenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ListenResponse prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    public static final class Builder extends GeneratedMessageLite.Builder<ListenResponse, Builder> implements ListenResponseOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(ListenResponse.DEFAULT_INSTANCE);
        }

        public ResponseTypeCase getResponseTypeCase() {
            return ((ListenResponse) this.instance).getResponseTypeCase();
        }

        public Builder clearResponseType() {
            copyOnWrite();
            ((ListenResponse) this.instance).clearResponseType();
            return this;
        }

        public TargetChange getTargetChange() {
            return ((ListenResponse) this.instance).getTargetChange();
        }

        public Builder setTargetChange(TargetChange value) {
            copyOnWrite();
            ((ListenResponse) this.instance).setTargetChange(value);
            return this;
        }

        public Builder setTargetChange(TargetChange.Builder builderForValue) {
            copyOnWrite();
            ((ListenResponse) this.instance).setTargetChange(builderForValue);
            return this;
        }

        public Builder mergeTargetChange(TargetChange value) {
            copyOnWrite();
            ((ListenResponse) this.instance).mergeTargetChange(value);
            return this;
        }

        public Builder clearTargetChange() {
            copyOnWrite();
            ((ListenResponse) this.instance).clearTargetChange();
            return this;
        }

        public DocumentChange getDocumentChange() {
            return ((ListenResponse) this.instance).getDocumentChange();
        }

        public Builder setDocumentChange(DocumentChange value) {
            copyOnWrite();
            ((ListenResponse) this.instance).setDocumentChange(value);
            return this;
        }

        public Builder setDocumentChange(DocumentChange.Builder builderForValue) {
            copyOnWrite();
            ((ListenResponse) this.instance).setDocumentChange(builderForValue);
            return this;
        }

        public Builder mergeDocumentChange(DocumentChange value) {
            copyOnWrite();
            ((ListenResponse) this.instance).mergeDocumentChange(value);
            return this;
        }

        public Builder clearDocumentChange() {
            copyOnWrite();
            ((ListenResponse) this.instance).clearDocumentChange();
            return this;
        }

        public DocumentDelete getDocumentDelete() {
            return ((ListenResponse) this.instance).getDocumentDelete();
        }

        public Builder setDocumentDelete(DocumentDelete value) {
            copyOnWrite();
            ((ListenResponse) this.instance).setDocumentDelete(value);
            return this;
        }

        public Builder setDocumentDelete(DocumentDelete.Builder builderForValue) {
            copyOnWrite();
            ((ListenResponse) this.instance).setDocumentDelete(builderForValue);
            return this;
        }

        public Builder mergeDocumentDelete(DocumentDelete value) {
            copyOnWrite();
            ((ListenResponse) this.instance).mergeDocumentDelete(value);
            return this;
        }

        public Builder clearDocumentDelete() {
            copyOnWrite();
            ((ListenResponse) this.instance).clearDocumentDelete();
            return this;
        }

        public DocumentRemove getDocumentRemove() {
            return ((ListenResponse) this.instance).getDocumentRemove();
        }

        public Builder setDocumentRemove(DocumentRemove value) {
            copyOnWrite();
            ((ListenResponse) this.instance).setDocumentRemove(value);
            return this;
        }

        public Builder setDocumentRemove(DocumentRemove.Builder builderForValue) {
            copyOnWrite();
            ((ListenResponse) this.instance).setDocumentRemove(builderForValue);
            return this;
        }

        public Builder mergeDocumentRemove(DocumentRemove value) {
            copyOnWrite();
            ((ListenResponse) this.instance).mergeDocumentRemove(value);
            return this;
        }

        public Builder clearDocumentRemove() {
            copyOnWrite();
            ((ListenResponse) this.instance).clearDocumentRemove();
            return this;
        }

        public ExistenceFilter getFilter() {
            return ((ListenResponse) this.instance).getFilter();
        }

        public Builder setFilter(ExistenceFilter value) {
            copyOnWrite();
            ((ListenResponse) this.instance).setFilter(value);
            return this;
        }

        public Builder setFilter(ExistenceFilter.Builder builderForValue) {
            copyOnWrite();
            ((ListenResponse) this.instance).setFilter(builderForValue);
            return this;
        }

        public Builder mergeFilter(ExistenceFilter value) {
            copyOnWrite();
            ((ListenResponse) this.instance).mergeFilter(value);
            return this;
        }

        public Builder clearFilter() {
            copyOnWrite();
            ((ListenResponse) this.instance).clearFilter();
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.ListenResponse$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-firestore@@21.4.3 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$ListenResponse$ResponseTypeCase;
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
            int[] iArr2 = new int[ResponseTypeCase.values().length];
            $SwitchMap$com$google$firestore$v1$ListenResponse$ResponseTypeCase = iArr2;
            try {
                iArr2[ResponseTypeCase.TARGET_CHANGE.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$ListenResponse$ResponseTypeCase[ResponseTypeCase.DOCUMENT_CHANGE.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$ListenResponse$ResponseTypeCase[ResponseTypeCase.DOCUMENT_DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$ListenResponse$ResponseTypeCase[ResponseTypeCase.DOCUMENT_REMOVE.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$ListenResponse$ResponseTypeCase[ResponseTypeCase.FILTER.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$ListenResponse$ResponseTypeCase[ResponseTypeCase.RESPONSETYPE_NOT_SET.ordinal()] = 6;
            } catch (NoSuchFieldError e14) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        int i;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
            case 1:
                return new ListenResponse();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                ListenResponse other = (ListenResponse) arg1;
                boolean z = true;
                switch (AnonymousClass1.$SwitchMap$com$google$firestore$v1$ListenResponse$ResponseTypeCase[other.getResponseTypeCase().ordinal()]) {
                    case 1:
                        if (this.responseTypeCase_ != 2) {
                            z = false;
                        }
                        this.responseType_ = visitor.visitOneofMessage(z, this.responseType_, other.responseType_);
                        break;
                    case 2:
                        if (this.responseTypeCase_ != 3) {
                            z = false;
                        }
                        this.responseType_ = visitor.visitOneofMessage(z, this.responseType_, other.responseType_);
                        break;
                    case 3:
                        if (this.responseTypeCase_ != 4) {
                            z = false;
                        }
                        this.responseType_ = visitor.visitOneofMessage(z, this.responseType_, other.responseType_);
                        break;
                    case 4:
                        if (this.responseTypeCase_ != 6) {
                            z = false;
                        }
                        this.responseType_ = visitor.visitOneofMessage(z, this.responseType_, other.responseType_);
                        break;
                    case 5:
                        if (this.responseTypeCase_ != 5) {
                            z = false;
                        }
                        this.responseType_ = visitor.visitOneofMessage(z, this.responseType_, other.responseType_);
                        break;
                    case 6:
                        if (this.responseTypeCase_ == 0) {
                            z = false;
                        }
                        visitor.visitOneofNotSet(z);
                        break;
                }
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE && (i = other.responseTypeCase_) != 0) {
                    this.responseTypeCase_ = i;
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
                        } else if (tag == 18) {
                            TargetChange.Builder subBuilder = null;
                            if (this.responseTypeCase_ == 2) {
                                subBuilder = (TargetChange.Builder) ((TargetChange) this.responseType_).toBuilder();
                            }
                            MessageLite readMessage = input.readMessage(TargetChange.parser(), extensionRegistry);
                            this.responseType_ = readMessage;
                            if (subBuilder != null) {
                                subBuilder.mergeFrom((TargetChange) readMessage);
                                this.responseType_ = subBuilder.buildPartial();
                            }
                            this.responseTypeCase_ = 2;
                        } else if (tag == 26) {
                            DocumentChange.Builder subBuilder2 = null;
                            if (this.responseTypeCase_ == 3) {
                                subBuilder2 = (DocumentChange.Builder) ((DocumentChange) this.responseType_).toBuilder();
                            }
                            MessageLite readMessage2 = input.readMessage(DocumentChange.parser(), extensionRegistry);
                            this.responseType_ = readMessage2;
                            if (subBuilder2 != null) {
                                subBuilder2.mergeFrom((DocumentChange) readMessage2);
                                this.responseType_ = subBuilder2.buildPartial();
                            }
                            this.responseTypeCase_ = 3;
                        } else if (tag == 34) {
                            DocumentDelete.Builder subBuilder3 = null;
                            if (this.responseTypeCase_ == 4) {
                                subBuilder3 = (DocumentDelete.Builder) ((DocumentDelete) this.responseType_).toBuilder();
                            }
                            MessageLite readMessage3 = input.readMessage(DocumentDelete.parser(), extensionRegistry);
                            this.responseType_ = readMessage3;
                            if (subBuilder3 != null) {
                                subBuilder3.mergeFrom((DocumentDelete) readMessage3);
                                this.responseType_ = subBuilder3.buildPartial();
                            }
                            this.responseTypeCase_ = 4;
                        } else if (tag == 42) {
                            ExistenceFilter.Builder subBuilder4 = null;
                            if (this.responseTypeCase_ == 5) {
                                subBuilder4 = (ExistenceFilter.Builder) ((ExistenceFilter) this.responseType_).toBuilder();
                            }
                            MessageLite readMessage4 = input.readMessage(ExistenceFilter.parser(), extensionRegistry);
                            this.responseType_ = readMessage4;
                            if (subBuilder4 != null) {
                                subBuilder4.mergeFrom((ExistenceFilter) readMessage4);
                                this.responseType_ = subBuilder4.buildPartial();
                            }
                            this.responseTypeCase_ = 5;
                        } else if (tag == 50) {
                            DocumentRemove.Builder subBuilder5 = null;
                            if (this.responseTypeCase_ == 6) {
                                subBuilder5 = (DocumentRemove.Builder) ((DocumentRemove) this.responseType_).toBuilder();
                            }
                            MessageLite readMessage5 = input.readMessage(DocumentRemove.parser(), extensionRegistry);
                            this.responseType_ = readMessage5;
                            if (subBuilder5 != null) {
                                subBuilder5.mergeFrom((DocumentRemove) readMessage5);
                                this.responseType_ = subBuilder5.buildPartial();
                            }
                            this.responseTypeCase_ = 6;
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
                    synchronized (ListenResponse.class) {
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
        ListenResponse listenResponse = new ListenResponse();
        DEFAULT_INSTANCE = listenResponse;
        listenResponse.makeImmutable();
    }

    public static ListenResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<ListenResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
