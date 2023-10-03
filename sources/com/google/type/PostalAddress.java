package com.google.type;

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
public final class PostalAddress extends GeneratedMessageLite<PostalAddress, Builder> implements PostalAddressOrBuilder {
    public static final int ADDRESS_LINES_FIELD_NUMBER = 9;
    public static final int ADMINISTRATIVE_AREA_FIELD_NUMBER = 6;
    /* access modifiers changed from: private */
    public static final PostalAddress DEFAULT_INSTANCE;
    public static final int LANGUAGE_CODE_FIELD_NUMBER = 3;
    public static final int LOCALITY_FIELD_NUMBER = 7;
    public static final int ORGANIZATION_FIELD_NUMBER = 11;
    private static volatile Parser<PostalAddress> PARSER = null;
    public static final int POSTAL_CODE_FIELD_NUMBER = 4;
    public static final int RECIPIENTS_FIELD_NUMBER = 10;
    public static final int REGION_CODE_FIELD_NUMBER = 2;
    public static final int REVISION_FIELD_NUMBER = 1;
    public static final int SORTING_CODE_FIELD_NUMBER = 5;
    public static final int SUBLOCALITY_FIELD_NUMBER = 8;
    private Internal.ProtobufList<String> addressLines_ = GeneratedMessageLite.emptyProtobufList();
    private String administrativeArea_ = "";
    private int bitField0_;
    private String languageCode_ = "";
    private String locality_ = "";
    private String organization_ = "";
    private String postalCode_ = "";
    private Internal.ProtobufList<String> recipients_ = GeneratedMessageLite.emptyProtobufList();
    private String regionCode_ = "";
    private int revision_;
    private String sortingCode_ = "";
    private String sublocality_ = "";

    private PostalAddress() {
    }

    public int getRevision() {
        return this.revision_;
    }

    /* access modifiers changed from: private */
    public void setRevision(int value) {
        this.revision_ = value;
    }

    /* access modifiers changed from: private */
    public void clearRevision() {
        this.revision_ = 0;
    }

    public String getRegionCode() {
        return this.regionCode_;
    }

    public ByteString getRegionCodeBytes() {
        return ByteString.copyFromUtf8(this.regionCode_);
    }

    /* access modifiers changed from: private */
    public void setRegionCode(String value) {
        if (value != null) {
            this.regionCode_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearRegionCode() {
        this.regionCode_ = getDefaultInstance().getRegionCode();
    }

    /* access modifiers changed from: private */
    public void setRegionCodeBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.regionCode_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getLanguageCode() {
        return this.languageCode_;
    }

    public ByteString getLanguageCodeBytes() {
        return ByteString.copyFromUtf8(this.languageCode_);
    }

    /* access modifiers changed from: private */
    public void setLanguageCode(String value) {
        if (value != null) {
            this.languageCode_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearLanguageCode() {
        this.languageCode_ = getDefaultInstance().getLanguageCode();
    }

    /* access modifiers changed from: private */
    public void setLanguageCodeBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.languageCode_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getPostalCode() {
        return this.postalCode_;
    }

    public ByteString getPostalCodeBytes() {
        return ByteString.copyFromUtf8(this.postalCode_);
    }

    /* access modifiers changed from: private */
    public void setPostalCode(String value) {
        if (value != null) {
            this.postalCode_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearPostalCode() {
        this.postalCode_ = getDefaultInstance().getPostalCode();
    }

    /* access modifiers changed from: private */
    public void setPostalCodeBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.postalCode_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getSortingCode() {
        return this.sortingCode_;
    }

    public ByteString getSortingCodeBytes() {
        return ByteString.copyFromUtf8(this.sortingCode_);
    }

    /* access modifiers changed from: private */
    public void setSortingCode(String value) {
        if (value != null) {
            this.sortingCode_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearSortingCode() {
        this.sortingCode_ = getDefaultInstance().getSortingCode();
    }

    /* access modifiers changed from: private */
    public void setSortingCodeBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.sortingCode_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getAdministrativeArea() {
        return this.administrativeArea_;
    }

    public ByteString getAdministrativeAreaBytes() {
        return ByteString.copyFromUtf8(this.administrativeArea_);
    }

    /* access modifiers changed from: private */
    public void setAdministrativeArea(String value) {
        if (value != null) {
            this.administrativeArea_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearAdministrativeArea() {
        this.administrativeArea_ = getDefaultInstance().getAdministrativeArea();
    }

    /* access modifiers changed from: private */
    public void setAdministrativeAreaBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.administrativeArea_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getLocality() {
        return this.locality_;
    }

    public ByteString getLocalityBytes() {
        return ByteString.copyFromUtf8(this.locality_);
    }

    /* access modifiers changed from: private */
    public void setLocality(String value) {
        if (value != null) {
            this.locality_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearLocality() {
        this.locality_ = getDefaultInstance().getLocality();
    }

    /* access modifiers changed from: private */
    public void setLocalityBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.locality_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getSublocality() {
        return this.sublocality_;
    }

    public ByteString getSublocalityBytes() {
        return ByteString.copyFromUtf8(this.sublocality_);
    }

    /* access modifiers changed from: private */
    public void setSublocality(String value) {
        if (value != null) {
            this.sublocality_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearSublocality() {
        this.sublocality_ = getDefaultInstance().getSublocality();
    }

    /* access modifiers changed from: private */
    public void setSublocalityBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.sublocality_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public List<String> getAddressLinesList() {
        return this.addressLines_;
    }

    public int getAddressLinesCount() {
        return this.addressLines_.size();
    }

    public String getAddressLines(int index) {
        return (String) this.addressLines_.get(index);
    }

    public ByteString getAddressLinesBytes(int index) {
        return ByteString.copyFromUtf8((String) this.addressLines_.get(index));
    }

    private void ensureAddressLinesIsMutable() {
        if (!this.addressLines_.isModifiable()) {
            this.addressLines_ = GeneratedMessageLite.mutableCopy(this.addressLines_);
        }
    }

    /* access modifiers changed from: private */
    public void setAddressLines(int index, String value) {
        if (value != null) {
            ensureAddressLinesIsMutable();
            this.addressLines_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addAddressLines(String value) {
        if (value != null) {
            ensureAddressLinesIsMutable();
            this.addressLines_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addAllAddressLines(Iterable<String> values) {
        ensureAddressLinesIsMutable();
        AbstractMessageLite.addAll(values, this.addressLines_);
    }

    /* access modifiers changed from: private */
    public void clearAddressLines() {
        this.addressLines_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void addAddressLinesBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            ensureAddressLinesIsMutable();
            this.addressLines_.add(value.toStringUtf8());
            return;
        }
        throw null;
    }

    public List<String> getRecipientsList() {
        return this.recipients_;
    }

    public int getRecipientsCount() {
        return this.recipients_.size();
    }

    public String getRecipients(int index) {
        return (String) this.recipients_.get(index);
    }

    public ByteString getRecipientsBytes(int index) {
        return ByteString.copyFromUtf8((String) this.recipients_.get(index));
    }

    private void ensureRecipientsIsMutable() {
        if (!this.recipients_.isModifiable()) {
            this.recipients_ = GeneratedMessageLite.mutableCopy(this.recipients_);
        }
    }

    /* access modifiers changed from: private */
    public void setRecipients(int index, String value) {
        if (value != null) {
            ensureRecipientsIsMutable();
            this.recipients_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addRecipients(String value) {
        if (value != null) {
            ensureRecipientsIsMutable();
            this.recipients_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addAllRecipients(Iterable<String> values) {
        ensureRecipientsIsMutable();
        AbstractMessageLite.addAll(values, this.recipients_);
    }

    /* access modifiers changed from: private */
    public void clearRecipients() {
        this.recipients_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void addRecipientsBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            ensureRecipientsIsMutable();
            this.recipients_.add(value.toStringUtf8());
            return;
        }
        throw null;
    }

    public String getOrganization() {
        return this.organization_;
    }

    public ByteString getOrganizationBytes() {
        return ByteString.copyFromUtf8(this.organization_);
    }

    /* access modifiers changed from: private */
    public void setOrganization(String value) {
        if (value != null) {
            this.organization_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearOrganization() {
        this.organization_ = getDefaultInstance().getOrganization();
    }

    /* access modifiers changed from: private */
    public void setOrganizationBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.organization_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        int i = this.revision_;
        if (i != 0) {
            output.writeInt32(1, i);
        }
        if (!this.regionCode_.isEmpty()) {
            output.writeString(2, getRegionCode());
        }
        if (!this.languageCode_.isEmpty()) {
            output.writeString(3, getLanguageCode());
        }
        if (!this.postalCode_.isEmpty()) {
            output.writeString(4, getPostalCode());
        }
        if (!this.sortingCode_.isEmpty()) {
            output.writeString(5, getSortingCode());
        }
        if (!this.administrativeArea_.isEmpty()) {
            output.writeString(6, getAdministrativeArea());
        }
        if (!this.locality_.isEmpty()) {
            output.writeString(7, getLocality());
        }
        if (!this.sublocality_.isEmpty()) {
            output.writeString(8, getSublocality());
        }
        for (int i2 = 0; i2 < this.addressLines_.size(); i2++) {
            output.writeString(9, (String) this.addressLines_.get(i2));
        }
        for (int i3 = 0; i3 < this.recipients_.size(); i3++) {
            output.writeString(10, (String) this.recipients_.get(i3));
        }
        if (!this.organization_.isEmpty()) {
            output.writeString(11, getOrganization());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        int i = this.revision_;
        if (i != 0) {
            size2 = 0 + CodedOutputStream.computeInt32Size(1, i);
        }
        if (!this.regionCode_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(2, getRegionCode());
        }
        if (!this.languageCode_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(3, getLanguageCode());
        }
        if (!this.postalCode_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(4, getPostalCode());
        }
        if (!this.sortingCode_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(5, getSortingCode());
        }
        if (!this.administrativeArea_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(6, getAdministrativeArea());
        }
        if (!this.locality_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(7, getLocality());
        }
        if (!this.sublocality_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(8, getSublocality());
        }
        int dataSize = 0;
        for (int i2 = 0; i2 < this.addressLines_.size(); i2++) {
            dataSize += CodedOutputStream.computeStringSizeNoTag((String) this.addressLines_.get(i2));
        }
        int size3 = size2 + dataSize + (getAddressLinesList().size() * 1);
        int dataSize2 = 0;
        for (int i3 = 0; i3 < this.recipients_.size(); i3++) {
            dataSize2 += CodedOutputStream.computeStringSizeNoTag((String) this.recipients_.get(i3));
        }
        int size4 = size3 + dataSize2 + (getRecipientsList().size() * 1);
        if (!this.organization_.isEmpty()) {
            size4 += CodedOutputStream.computeStringSize(11, getOrganization());
        }
        this.memoizedSerializedSize = size4;
        return size4;
    }

    public static PostalAddress parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static PostalAddress parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static PostalAddress parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static PostalAddress parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static PostalAddress parseFrom(InputStream input) throws IOException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static PostalAddress parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static PostalAddress parseDelimitedFrom(InputStream input) throws IOException {
        return (PostalAddress) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static PostalAddress parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (PostalAddress) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static PostalAddress parseFrom(CodedInputStream input) throws IOException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static PostalAddress parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(PostalAddress prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<PostalAddress, Builder> implements PostalAddressOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(PostalAddress.DEFAULT_INSTANCE);
        }

        public int getRevision() {
            return ((PostalAddress) this.instance).getRevision();
        }

        public Builder setRevision(int value) {
            copyOnWrite();
            ((PostalAddress) this.instance).setRevision(value);
            return this;
        }

        public Builder clearRevision() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearRevision();
            return this;
        }

        public String getRegionCode() {
            return ((PostalAddress) this.instance).getRegionCode();
        }

        public ByteString getRegionCodeBytes() {
            return ((PostalAddress) this.instance).getRegionCodeBytes();
        }

        public Builder setRegionCode(String value) {
            copyOnWrite();
            ((PostalAddress) this.instance).setRegionCode(value);
            return this;
        }

        public Builder clearRegionCode() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearRegionCode();
            return this;
        }

        public Builder setRegionCodeBytes(ByteString value) {
            copyOnWrite();
            ((PostalAddress) this.instance).setRegionCodeBytes(value);
            return this;
        }

        public String getLanguageCode() {
            return ((PostalAddress) this.instance).getLanguageCode();
        }

        public ByteString getLanguageCodeBytes() {
            return ((PostalAddress) this.instance).getLanguageCodeBytes();
        }

        public Builder setLanguageCode(String value) {
            copyOnWrite();
            ((PostalAddress) this.instance).setLanguageCode(value);
            return this;
        }

        public Builder clearLanguageCode() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearLanguageCode();
            return this;
        }

        public Builder setLanguageCodeBytes(ByteString value) {
            copyOnWrite();
            ((PostalAddress) this.instance).setLanguageCodeBytes(value);
            return this;
        }

        public String getPostalCode() {
            return ((PostalAddress) this.instance).getPostalCode();
        }

        public ByteString getPostalCodeBytes() {
            return ((PostalAddress) this.instance).getPostalCodeBytes();
        }

        public Builder setPostalCode(String value) {
            copyOnWrite();
            ((PostalAddress) this.instance).setPostalCode(value);
            return this;
        }

        public Builder clearPostalCode() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearPostalCode();
            return this;
        }

        public Builder setPostalCodeBytes(ByteString value) {
            copyOnWrite();
            ((PostalAddress) this.instance).setPostalCodeBytes(value);
            return this;
        }

        public String getSortingCode() {
            return ((PostalAddress) this.instance).getSortingCode();
        }

        public ByteString getSortingCodeBytes() {
            return ((PostalAddress) this.instance).getSortingCodeBytes();
        }

        public Builder setSortingCode(String value) {
            copyOnWrite();
            ((PostalAddress) this.instance).setSortingCode(value);
            return this;
        }

        public Builder clearSortingCode() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearSortingCode();
            return this;
        }

        public Builder setSortingCodeBytes(ByteString value) {
            copyOnWrite();
            ((PostalAddress) this.instance).setSortingCodeBytes(value);
            return this;
        }

        public String getAdministrativeArea() {
            return ((PostalAddress) this.instance).getAdministrativeArea();
        }

        public ByteString getAdministrativeAreaBytes() {
            return ((PostalAddress) this.instance).getAdministrativeAreaBytes();
        }

        public Builder setAdministrativeArea(String value) {
            copyOnWrite();
            ((PostalAddress) this.instance).setAdministrativeArea(value);
            return this;
        }

        public Builder clearAdministrativeArea() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearAdministrativeArea();
            return this;
        }

        public Builder setAdministrativeAreaBytes(ByteString value) {
            copyOnWrite();
            ((PostalAddress) this.instance).setAdministrativeAreaBytes(value);
            return this;
        }

        public String getLocality() {
            return ((PostalAddress) this.instance).getLocality();
        }

        public ByteString getLocalityBytes() {
            return ((PostalAddress) this.instance).getLocalityBytes();
        }

        public Builder setLocality(String value) {
            copyOnWrite();
            ((PostalAddress) this.instance).setLocality(value);
            return this;
        }

        public Builder clearLocality() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearLocality();
            return this;
        }

        public Builder setLocalityBytes(ByteString value) {
            copyOnWrite();
            ((PostalAddress) this.instance).setLocalityBytes(value);
            return this;
        }

        public String getSublocality() {
            return ((PostalAddress) this.instance).getSublocality();
        }

        public ByteString getSublocalityBytes() {
            return ((PostalAddress) this.instance).getSublocalityBytes();
        }

        public Builder setSublocality(String value) {
            copyOnWrite();
            ((PostalAddress) this.instance).setSublocality(value);
            return this;
        }

        public Builder clearSublocality() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearSublocality();
            return this;
        }

        public Builder setSublocalityBytes(ByteString value) {
            copyOnWrite();
            ((PostalAddress) this.instance).setSublocalityBytes(value);
            return this;
        }

        public List<String> getAddressLinesList() {
            return Collections.unmodifiableList(((PostalAddress) this.instance).getAddressLinesList());
        }

        public int getAddressLinesCount() {
            return ((PostalAddress) this.instance).getAddressLinesCount();
        }

        public String getAddressLines(int index) {
            return ((PostalAddress) this.instance).getAddressLines(index);
        }

        public ByteString getAddressLinesBytes(int index) {
            return ((PostalAddress) this.instance).getAddressLinesBytes(index);
        }

        public Builder setAddressLines(int index, String value) {
            copyOnWrite();
            ((PostalAddress) this.instance).setAddressLines(index, value);
            return this;
        }

        public Builder addAddressLines(String value) {
            copyOnWrite();
            ((PostalAddress) this.instance).addAddressLines(value);
            return this;
        }

        public Builder addAllAddressLines(Iterable<String> values) {
            copyOnWrite();
            ((PostalAddress) this.instance).addAllAddressLines(values);
            return this;
        }

        public Builder clearAddressLines() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearAddressLines();
            return this;
        }

        public Builder addAddressLinesBytes(ByteString value) {
            copyOnWrite();
            ((PostalAddress) this.instance).addAddressLinesBytes(value);
            return this;
        }

        public List<String> getRecipientsList() {
            return Collections.unmodifiableList(((PostalAddress) this.instance).getRecipientsList());
        }

        public int getRecipientsCount() {
            return ((PostalAddress) this.instance).getRecipientsCount();
        }

        public String getRecipients(int index) {
            return ((PostalAddress) this.instance).getRecipients(index);
        }

        public ByteString getRecipientsBytes(int index) {
            return ((PostalAddress) this.instance).getRecipientsBytes(index);
        }

        public Builder setRecipients(int index, String value) {
            copyOnWrite();
            ((PostalAddress) this.instance).setRecipients(index, value);
            return this;
        }

        public Builder addRecipients(String value) {
            copyOnWrite();
            ((PostalAddress) this.instance).addRecipients(value);
            return this;
        }

        public Builder addAllRecipients(Iterable<String> values) {
            copyOnWrite();
            ((PostalAddress) this.instance).addAllRecipients(values);
            return this;
        }

        public Builder clearRecipients() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearRecipients();
            return this;
        }

        public Builder addRecipientsBytes(ByteString value) {
            copyOnWrite();
            ((PostalAddress) this.instance).addRecipientsBytes(value);
            return this;
        }

        public String getOrganization() {
            return ((PostalAddress) this.instance).getOrganization();
        }

        public ByteString getOrganizationBytes() {
            return ((PostalAddress) this.instance).getOrganizationBytes();
        }

        public Builder setOrganization(String value) {
            copyOnWrite();
            ((PostalAddress) this.instance).setOrganization(value);
            return this;
        }

        public Builder clearOrganization() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearOrganization();
            return this;
        }

        public Builder setOrganizationBytes(ByteString value) {
            copyOnWrite();
            ((PostalAddress) this.instance).setOrganizationBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.type.PostalAddress$1  reason: invalid class name */
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
                return new PostalAddress();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.addressLines_.makeImmutable();
                this.recipients_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                PostalAddress other = (PostalAddress) arg1;
                boolean z = false;
                boolean z2 = this.revision_ != 0;
                int i = this.revision_;
                if (other.revision_ != 0) {
                    z = true;
                }
                this.revision_ = visitor.visitInt(z2, i, z, other.revision_);
                this.regionCode_ = visitor.visitString(!this.regionCode_.isEmpty(), this.regionCode_, !other.regionCode_.isEmpty(), other.regionCode_);
                this.languageCode_ = visitor.visitString(!this.languageCode_.isEmpty(), this.languageCode_, !other.languageCode_.isEmpty(), other.languageCode_);
                this.postalCode_ = visitor.visitString(!this.postalCode_.isEmpty(), this.postalCode_, !other.postalCode_.isEmpty(), other.postalCode_);
                this.sortingCode_ = visitor.visitString(!this.sortingCode_.isEmpty(), this.sortingCode_, !other.sortingCode_.isEmpty(), other.sortingCode_);
                this.administrativeArea_ = visitor.visitString(!this.administrativeArea_.isEmpty(), this.administrativeArea_, !other.administrativeArea_.isEmpty(), other.administrativeArea_);
                this.locality_ = visitor.visitString(!this.locality_.isEmpty(), this.locality_, !other.locality_.isEmpty(), other.locality_);
                this.sublocality_ = visitor.visitString(!this.sublocality_.isEmpty(), this.sublocality_, !other.sublocality_.isEmpty(), other.sublocality_);
                this.addressLines_ = visitor.visitList(this.addressLines_, other.addressLines_);
                this.recipients_ = visitor.visitList(this.recipients_, other.recipients_);
                this.organization_ = visitor.visitString(!this.organization_.isEmpty(), this.organization_, true ^ other.organization_.isEmpty(), other.organization_);
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
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 8:
                                this.revision_ = input.readInt32();
                                break;
                            case 18:
                                this.regionCode_ = input.readStringRequireUtf8();
                                break;
                            case 26:
                                this.languageCode_ = input.readStringRequireUtf8();
                                break;
                            case 34:
                                this.postalCode_ = input.readStringRequireUtf8();
                                break;
                            case 42:
                                this.sortingCode_ = input.readStringRequireUtf8();
                                break;
                            case 50:
                                this.administrativeArea_ = input.readStringRequireUtf8();
                                break;
                            case 58:
                                this.locality_ = input.readStringRequireUtf8();
                                break;
                            case 66:
                                this.sublocality_ = input.readStringRequireUtf8();
                                break;
                            case 74:
                                String s = input.readStringRequireUtf8();
                                if (!this.addressLines_.isModifiable()) {
                                    this.addressLines_ = GeneratedMessageLite.mutableCopy(this.addressLines_);
                                }
                                this.addressLines_.add(s);
                                break;
                            case 82:
                                String s2 = input.readStringRequireUtf8();
                                if (!this.recipients_.isModifiable()) {
                                    this.recipients_ = GeneratedMessageLite.mutableCopy(this.recipients_);
                                }
                                this.recipients_.add(s2);
                                break;
                            case 90:
                                this.organization_ = input.readStringRequireUtf8();
                                break;
                            default:
                                if (input.skipField(tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
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
                    synchronized (PostalAddress.class) {
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
        PostalAddress postalAddress = new PostalAddress();
        DEFAULT_INSTANCE = postalAddress;
        postalAddress.makeImmutable();
    }

    public static PostalAddress getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<PostalAddress> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
