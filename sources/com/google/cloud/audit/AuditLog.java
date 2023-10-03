package com.google.cloud.audit;

import com.google.cloud.audit.AuthenticationInfo;
import com.google.cloud.audit.AuthorizationInfo;
import com.google.cloud.audit.RequestMetadata;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.Struct;
import com.google.rpc.Status;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class AuditLog extends GeneratedMessageLite<AuditLog, Builder> implements AuditLogOrBuilder {
    public static final int AUTHENTICATION_INFO_FIELD_NUMBER = 3;
    public static final int AUTHORIZATION_INFO_FIELD_NUMBER = 9;
    /* access modifiers changed from: private */
    public static final AuditLog DEFAULT_INSTANCE;
    public static final int METHOD_NAME_FIELD_NUMBER = 8;
    public static final int NUM_RESPONSE_ITEMS_FIELD_NUMBER = 12;
    private static volatile Parser<AuditLog> PARSER = null;
    public static final int REQUEST_FIELD_NUMBER = 16;
    public static final int REQUEST_METADATA_FIELD_NUMBER = 4;
    public static final int RESOURCE_NAME_FIELD_NUMBER = 11;
    public static final int RESPONSE_FIELD_NUMBER = 17;
    public static final int SERVICE_DATA_FIELD_NUMBER = 15;
    public static final int SERVICE_NAME_FIELD_NUMBER = 7;
    public static final int STATUS_FIELD_NUMBER = 2;
    private AuthenticationInfo authenticationInfo_;
    private Internal.ProtobufList<AuthorizationInfo> authorizationInfo_ = emptyProtobufList();
    private int bitField0_;
    private String methodName_ = "";
    private long numResponseItems_;
    private RequestMetadata requestMetadata_;
    private Struct request_;
    private String resourceName_ = "";
    private Struct response_;
    private Any serviceData_;
    private String serviceName_ = "";
    private Status status_;

    private AuditLog() {
    }

    public String getServiceName() {
        return this.serviceName_;
    }

    public ByteString getServiceNameBytes() {
        return ByteString.copyFromUtf8(this.serviceName_);
    }

    /* access modifiers changed from: private */
    public void setServiceName(String value) {
        if (value != null) {
            this.serviceName_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearServiceName() {
        this.serviceName_ = getDefaultInstance().getServiceName();
    }

    /* access modifiers changed from: private */
    public void setServiceNameBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.serviceName_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getMethodName() {
        return this.methodName_;
    }

    public ByteString getMethodNameBytes() {
        return ByteString.copyFromUtf8(this.methodName_);
    }

    /* access modifiers changed from: private */
    public void setMethodName(String value) {
        if (value != null) {
            this.methodName_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearMethodName() {
        this.methodName_ = getDefaultInstance().getMethodName();
    }

    /* access modifiers changed from: private */
    public void setMethodNameBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.methodName_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getResourceName() {
        return this.resourceName_;
    }

    public ByteString getResourceNameBytes() {
        return ByteString.copyFromUtf8(this.resourceName_);
    }

    /* access modifiers changed from: private */
    public void setResourceName(String value) {
        if (value != null) {
            this.resourceName_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearResourceName() {
        this.resourceName_ = getDefaultInstance().getResourceName();
    }

    /* access modifiers changed from: private */
    public void setResourceNameBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.resourceName_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public long getNumResponseItems() {
        return this.numResponseItems_;
    }

    /* access modifiers changed from: private */
    public void setNumResponseItems(long value) {
        this.numResponseItems_ = value;
    }

    /* access modifiers changed from: private */
    public void clearNumResponseItems() {
        this.numResponseItems_ = 0;
    }

    public boolean hasStatus() {
        return this.status_ != null;
    }

    public Status getStatus() {
        Status status = this.status_;
        return status == null ? Status.getDefaultInstance() : status;
    }

    /* access modifiers changed from: private */
    public void setStatus(Status value) {
        if (value != null) {
            this.status_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setStatus(Status.Builder builderForValue) {
        this.status_ = (Status) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeStatus(Status value) {
        Status status = this.status_;
        if (status == null || status == Status.getDefaultInstance()) {
            this.status_ = value;
        } else {
            this.status_ = (Status) ((Status.Builder) Status.newBuilder(this.status_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearStatus() {
        this.status_ = null;
    }

    public boolean hasAuthenticationInfo() {
        return this.authenticationInfo_ != null;
    }

    public AuthenticationInfo getAuthenticationInfo() {
        AuthenticationInfo authenticationInfo = this.authenticationInfo_;
        return authenticationInfo == null ? AuthenticationInfo.getDefaultInstance() : authenticationInfo;
    }

    /* access modifiers changed from: private */
    public void setAuthenticationInfo(AuthenticationInfo value) {
        if (value != null) {
            this.authenticationInfo_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setAuthenticationInfo(AuthenticationInfo.Builder builderForValue) {
        this.authenticationInfo_ = (AuthenticationInfo) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeAuthenticationInfo(AuthenticationInfo value) {
        AuthenticationInfo authenticationInfo = this.authenticationInfo_;
        if (authenticationInfo == null || authenticationInfo == AuthenticationInfo.getDefaultInstance()) {
            this.authenticationInfo_ = value;
        } else {
            this.authenticationInfo_ = (AuthenticationInfo) ((AuthenticationInfo.Builder) AuthenticationInfo.newBuilder(this.authenticationInfo_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearAuthenticationInfo() {
        this.authenticationInfo_ = null;
    }

    public List<AuthorizationInfo> getAuthorizationInfoList() {
        return this.authorizationInfo_;
    }

    public List<? extends AuthorizationInfoOrBuilder> getAuthorizationInfoOrBuilderList() {
        return this.authorizationInfo_;
    }

    public int getAuthorizationInfoCount() {
        return this.authorizationInfo_.size();
    }

    public AuthorizationInfo getAuthorizationInfo(int index) {
        return (AuthorizationInfo) this.authorizationInfo_.get(index);
    }

    public AuthorizationInfoOrBuilder getAuthorizationInfoOrBuilder(int index) {
        return (AuthorizationInfoOrBuilder) this.authorizationInfo_.get(index);
    }

    private void ensureAuthorizationInfoIsMutable() {
        if (!this.authorizationInfo_.isModifiable()) {
            this.authorizationInfo_ = GeneratedMessageLite.mutableCopy(this.authorizationInfo_);
        }
    }

    /* access modifiers changed from: private */
    public void setAuthorizationInfo(int index, AuthorizationInfo value) {
        if (value != null) {
            ensureAuthorizationInfoIsMutable();
            this.authorizationInfo_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setAuthorizationInfo(int index, AuthorizationInfo.Builder builderForValue) {
        ensureAuthorizationInfoIsMutable();
        this.authorizationInfo_.set(index, (AuthorizationInfo) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAuthorizationInfo(AuthorizationInfo value) {
        if (value != null) {
            ensureAuthorizationInfoIsMutable();
            this.authorizationInfo_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addAuthorizationInfo(int index, AuthorizationInfo value) {
        if (value != null) {
            ensureAuthorizationInfoIsMutable();
            this.authorizationInfo_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addAuthorizationInfo(AuthorizationInfo.Builder builderForValue) {
        ensureAuthorizationInfoIsMutable();
        this.authorizationInfo_.add((AuthorizationInfo) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAuthorizationInfo(int index, AuthorizationInfo.Builder builderForValue) {
        ensureAuthorizationInfoIsMutable();
        this.authorizationInfo_.add(index, (AuthorizationInfo) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllAuthorizationInfo(Iterable<? extends AuthorizationInfo> values) {
        ensureAuthorizationInfoIsMutable();
        AbstractMessageLite.addAll(values, this.authorizationInfo_);
    }

    /* access modifiers changed from: private */
    public void clearAuthorizationInfo() {
        this.authorizationInfo_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeAuthorizationInfo(int index) {
        ensureAuthorizationInfoIsMutable();
        this.authorizationInfo_.remove(index);
    }

    public boolean hasRequestMetadata() {
        return this.requestMetadata_ != null;
    }

    public RequestMetadata getRequestMetadata() {
        RequestMetadata requestMetadata = this.requestMetadata_;
        return requestMetadata == null ? RequestMetadata.getDefaultInstance() : requestMetadata;
    }

    /* access modifiers changed from: private */
    public void setRequestMetadata(RequestMetadata value) {
        if (value != null) {
            this.requestMetadata_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setRequestMetadata(RequestMetadata.Builder builderForValue) {
        this.requestMetadata_ = (RequestMetadata) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeRequestMetadata(RequestMetadata value) {
        RequestMetadata requestMetadata = this.requestMetadata_;
        if (requestMetadata == null || requestMetadata == RequestMetadata.getDefaultInstance()) {
            this.requestMetadata_ = value;
        } else {
            this.requestMetadata_ = (RequestMetadata) ((RequestMetadata.Builder) RequestMetadata.newBuilder(this.requestMetadata_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearRequestMetadata() {
        this.requestMetadata_ = null;
    }

    public boolean hasRequest() {
        return this.request_ != null;
    }

    public Struct getRequest() {
        Struct struct = this.request_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    /* access modifiers changed from: private */
    public void setRequest(Struct value) {
        if (value != null) {
            this.request_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setRequest(Struct.Builder builderForValue) {
        this.request_ = (Struct) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeRequest(Struct value) {
        Struct struct = this.request_;
        if (struct == null || struct == Struct.getDefaultInstance()) {
            this.request_ = value;
        } else {
            this.request_ = (Struct) ((Struct.Builder) Struct.newBuilder(this.request_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearRequest() {
        this.request_ = null;
    }

    public boolean hasResponse() {
        return this.response_ != null;
    }

    public Struct getResponse() {
        Struct struct = this.response_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    /* access modifiers changed from: private */
    public void setResponse(Struct value) {
        if (value != null) {
            this.response_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setResponse(Struct.Builder builderForValue) {
        this.response_ = (Struct) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeResponse(Struct value) {
        Struct struct = this.response_;
        if (struct == null || struct == Struct.getDefaultInstance()) {
            this.response_ = value;
        } else {
            this.response_ = (Struct) ((Struct.Builder) Struct.newBuilder(this.response_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearResponse() {
        this.response_ = null;
    }

    public boolean hasServiceData() {
        return this.serviceData_ != null;
    }

    public Any getServiceData() {
        Any any = this.serviceData_;
        return any == null ? Any.getDefaultInstance() : any;
    }

    /* access modifiers changed from: private */
    public void setServiceData(Any value) {
        if (value != null) {
            this.serviceData_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setServiceData(Any.Builder builderForValue) {
        this.serviceData_ = (Any) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeServiceData(Any value) {
        Any any = this.serviceData_;
        if (any == null || any == Any.getDefaultInstance()) {
            this.serviceData_ = value;
        } else {
            this.serviceData_ = (Any) ((Any.Builder) Any.newBuilder(this.serviceData_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearServiceData() {
        this.serviceData_ = null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (this.status_ != null) {
            output.writeMessage(2, getStatus());
        }
        if (this.authenticationInfo_ != null) {
            output.writeMessage(3, getAuthenticationInfo());
        }
        if (this.requestMetadata_ != null) {
            output.writeMessage(4, getRequestMetadata());
        }
        if (!this.serviceName_.isEmpty()) {
            output.writeString(7, getServiceName());
        }
        if (!this.methodName_.isEmpty()) {
            output.writeString(8, getMethodName());
        }
        for (int i = 0; i < this.authorizationInfo_.size(); i++) {
            output.writeMessage(9, (MessageLite) this.authorizationInfo_.get(i));
        }
        if (!this.resourceName_.isEmpty()) {
            output.writeString(11, getResourceName());
        }
        long j = this.numResponseItems_;
        if (j != 0) {
            output.writeInt64(12, j);
        }
        if (this.serviceData_ != null) {
            output.writeMessage(15, getServiceData());
        }
        if (this.request_ != null) {
            output.writeMessage(16, getRequest());
        }
        if (this.response_ != null) {
            output.writeMessage(17, getResponse());
        }
    }

    public int getSerializedSize() {
        int size = this.memoizedSerializedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (this.status_ != null) {
            size2 = 0 + CodedOutputStream.computeMessageSize(2, getStatus());
        }
        if (this.authenticationInfo_ != null) {
            size2 += CodedOutputStream.computeMessageSize(3, getAuthenticationInfo());
        }
        if (this.requestMetadata_ != null) {
            size2 += CodedOutputStream.computeMessageSize(4, getRequestMetadata());
        }
        if (!this.serviceName_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(7, getServiceName());
        }
        if (!this.methodName_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(8, getMethodName());
        }
        for (int i = 0; i < this.authorizationInfo_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(9, (MessageLite) this.authorizationInfo_.get(i));
        }
        if (!this.resourceName_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(11, getResourceName());
        }
        long j = this.numResponseItems_;
        if (j != 0) {
            size2 += CodedOutputStream.computeInt64Size(12, j);
        }
        if (this.serviceData_ != null) {
            size2 += CodedOutputStream.computeMessageSize(15, getServiceData());
        }
        if (this.request_ != null) {
            size2 += CodedOutputStream.computeMessageSize(16, getRequest());
        }
        if (this.response_ != null) {
            size2 += CodedOutputStream.computeMessageSize(17, getResponse());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static AuditLog parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AuditLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AuditLog parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AuditLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AuditLog parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AuditLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AuditLog parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AuditLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AuditLog parseFrom(InputStream input) throws IOException {
        return (AuditLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AuditLog parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AuditLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AuditLog parseDelimitedFrom(InputStream input) throws IOException {
        return (AuditLog) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AuditLog parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AuditLog) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AuditLog parseFrom(CodedInputStream input) throws IOException {
        return (AuditLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AuditLog parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AuditLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(AuditLog prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<AuditLog, Builder> implements AuditLogOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(AuditLog.DEFAULT_INSTANCE);
        }

        public String getServiceName() {
            return ((AuditLog) this.instance).getServiceName();
        }

        public ByteString getServiceNameBytes() {
            return ((AuditLog) this.instance).getServiceNameBytes();
        }

        public Builder setServiceName(String value) {
            copyOnWrite();
            ((AuditLog) this.instance).setServiceName(value);
            return this;
        }

        public Builder clearServiceName() {
            copyOnWrite();
            ((AuditLog) this.instance).clearServiceName();
            return this;
        }

        public Builder setServiceNameBytes(ByteString value) {
            copyOnWrite();
            ((AuditLog) this.instance).setServiceNameBytes(value);
            return this;
        }

        public String getMethodName() {
            return ((AuditLog) this.instance).getMethodName();
        }

        public ByteString getMethodNameBytes() {
            return ((AuditLog) this.instance).getMethodNameBytes();
        }

        public Builder setMethodName(String value) {
            copyOnWrite();
            ((AuditLog) this.instance).setMethodName(value);
            return this;
        }

        public Builder clearMethodName() {
            copyOnWrite();
            ((AuditLog) this.instance).clearMethodName();
            return this;
        }

        public Builder setMethodNameBytes(ByteString value) {
            copyOnWrite();
            ((AuditLog) this.instance).setMethodNameBytes(value);
            return this;
        }

        public String getResourceName() {
            return ((AuditLog) this.instance).getResourceName();
        }

        public ByteString getResourceNameBytes() {
            return ((AuditLog) this.instance).getResourceNameBytes();
        }

        public Builder setResourceName(String value) {
            copyOnWrite();
            ((AuditLog) this.instance).setResourceName(value);
            return this;
        }

        public Builder clearResourceName() {
            copyOnWrite();
            ((AuditLog) this.instance).clearResourceName();
            return this;
        }

        public Builder setResourceNameBytes(ByteString value) {
            copyOnWrite();
            ((AuditLog) this.instance).setResourceNameBytes(value);
            return this;
        }

        public long getNumResponseItems() {
            return ((AuditLog) this.instance).getNumResponseItems();
        }

        public Builder setNumResponseItems(long value) {
            copyOnWrite();
            ((AuditLog) this.instance).setNumResponseItems(value);
            return this;
        }

        public Builder clearNumResponseItems() {
            copyOnWrite();
            ((AuditLog) this.instance).clearNumResponseItems();
            return this;
        }

        public boolean hasStatus() {
            return ((AuditLog) this.instance).hasStatus();
        }

        public Status getStatus() {
            return ((AuditLog) this.instance).getStatus();
        }

        public Builder setStatus(Status value) {
            copyOnWrite();
            ((AuditLog) this.instance).setStatus(value);
            return this;
        }

        public Builder setStatus(Status.Builder builderForValue) {
            copyOnWrite();
            ((AuditLog) this.instance).setStatus(builderForValue);
            return this;
        }

        public Builder mergeStatus(Status value) {
            copyOnWrite();
            ((AuditLog) this.instance).mergeStatus(value);
            return this;
        }

        public Builder clearStatus() {
            copyOnWrite();
            ((AuditLog) this.instance).clearStatus();
            return this;
        }

        public boolean hasAuthenticationInfo() {
            return ((AuditLog) this.instance).hasAuthenticationInfo();
        }

        public AuthenticationInfo getAuthenticationInfo() {
            return ((AuditLog) this.instance).getAuthenticationInfo();
        }

        public Builder setAuthenticationInfo(AuthenticationInfo value) {
            copyOnWrite();
            ((AuditLog) this.instance).setAuthenticationInfo(value);
            return this;
        }

        public Builder setAuthenticationInfo(AuthenticationInfo.Builder builderForValue) {
            copyOnWrite();
            ((AuditLog) this.instance).setAuthenticationInfo(builderForValue);
            return this;
        }

        public Builder mergeAuthenticationInfo(AuthenticationInfo value) {
            copyOnWrite();
            ((AuditLog) this.instance).mergeAuthenticationInfo(value);
            return this;
        }

        public Builder clearAuthenticationInfo() {
            copyOnWrite();
            ((AuditLog) this.instance).clearAuthenticationInfo();
            return this;
        }

        public List<AuthorizationInfo> getAuthorizationInfoList() {
            return Collections.unmodifiableList(((AuditLog) this.instance).getAuthorizationInfoList());
        }

        public int getAuthorizationInfoCount() {
            return ((AuditLog) this.instance).getAuthorizationInfoCount();
        }

        public AuthorizationInfo getAuthorizationInfo(int index) {
            return ((AuditLog) this.instance).getAuthorizationInfo(index);
        }

        public Builder setAuthorizationInfo(int index, AuthorizationInfo value) {
            copyOnWrite();
            ((AuditLog) this.instance).setAuthorizationInfo(index, value);
            return this;
        }

        public Builder setAuthorizationInfo(int index, AuthorizationInfo.Builder builderForValue) {
            copyOnWrite();
            ((AuditLog) this.instance).setAuthorizationInfo(index, builderForValue);
            return this;
        }

        public Builder addAuthorizationInfo(AuthorizationInfo value) {
            copyOnWrite();
            ((AuditLog) this.instance).addAuthorizationInfo(value);
            return this;
        }

        public Builder addAuthorizationInfo(int index, AuthorizationInfo value) {
            copyOnWrite();
            ((AuditLog) this.instance).addAuthorizationInfo(index, value);
            return this;
        }

        public Builder addAuthorizationInfo(AuthorizationInfo.Builder builderForValue) {
            copyOnWrite();
            ((AuditLog) this.instance).addAuthorizationInfo(builderForValue);
            return this;
        }

        public Builder addAuthorizationInfo(int index, AuthorizationInfo.Builder builderForValue) {
            copyOnWrite();
            ((AuditLog) this.instance).addAuthorizationInfo(index, builderForValue);
            return this;
        }

        public Builder addAllAuthorizationInfo(Iterable<? extends AuthorizationInfo> values) {
            copyOnWrite();
            ((AuditLog) this.instance).addAllAuthorizationInfo(values);
            return this;
        }

        public Builder clearAuthorizationInfo() {
            copyOnWrite();
            ((AuditLog) this.instance).clearAuthorizationInfo();
            return this;
        }

        public Builder removeAuthorizationInfo(int index) {
            copyOnWrite();
            ((AuditLog) this.instance).removeAuthorizationInfo(index);
            return this;
        }

        public boolean hasRequestMetadata() {
            return ((AuditLog) this.instance).hasRequestMetadata();
        }

        public RequestMetadata getRequestMetadata() {
            return ((AuditLog) this.instance).getRequestMetadata();
        }

        public Builder setRequestMetadata(RequestMetadata value) {
            copyOnWrite();
            ((AuditLog) this.instance).setRequestMetadata(value);
            return this;
        }

        public Builder setRequestMetadata(RequestMetadata.Builder builderForValue) {
            copyOnWrite();
            ((AuditLog) this.instance).setRequestMetadata(builderForValue);
            return this;
        }

        public Builder mergeRequestMetadata(RequestMetadata value) {
            copyOnWrite();
            ((AuditLog) this.instance).mergeRequestMetadata(value);
            return this;
        }

        public Builder clearRequestMetadata() {
            copyOnWrite();
            ((AuditLog) this.instance).clearRequestMetadata();
            return this;
        }

        public boolean hasRequest() {
            return ((AuditLog) this.instance).hasRequest();
        }

        public Struct getRequest() {
            return ((AuditLog) this.instance).getRequest();
        }

        public Builder setRequest(Struct value) {
            copyOnWrite();
            ((AuditLog) this.instance).setRequest(value);
            return this;
        }

        public Builder setRequest(Struct.Builder builderForValue) {
            copyOnWrite();
            ((AuditLog) this.instance).setRequest(builderForValue);
            return this;
        }

        public Builder mergeRequest(Struct value) {
            copyOnWrite();
            ((AuditLog) this.instance).mergeRequest(value);
            return this;
        }

        public Builder clearRequest() {
            copyOnWrite();
            ((AuditLog) this.instance).clearRequest();
            return this;
        }

        public boolean hasResponse() {
            return ((AuditLog) this.instance).hasResponse();
        }

        public Struct getResponse() {
            return ((AuditLog) this.instance).getResponse();
        }

        public Builder setResponse(Struct value) {
            copyOnWrite();
            ((AuditLog) this.instance).setResponse(value);
            return this;
        }

        public Builder setResponse(Struct.Builder builderForValue) {
            copyOnWrite();
            ((AuditLog) this.instance).setResponse(builderForValue);
            return this;
        }

        public Builder mergeResponse(Struct value) {
            copyOnWrite();
            ((AuditLog) this.instance).mergeResponse(value);
            return this;
        }

        public Builder clearResponse() {
            copyOnWrite();
            ((AuditLog) this.instance).clearResponse();
            return this;
        }

        public boolean hasServiceData() {
            return ((AuditLog) this.instance).hasServiceData();
        }

        public Any getServiceData() {
            return ((AuditLog) this.instance).getServiceData();
        }

        public Builder setServiceData(Any value) {
            copyOnWrite();
            ((AuditLog) this.instance).setServiceData(value);
            return this;
        }

        public Builder setServiceData(Any.Builder builderForValue) {
            copyOnWrite();
            ((AuditLog) this.instance).setServiceData(builderForValue);
            return this;
        }

        public Builder mergeServiceData(Any value) {
            copyOnWrite();
            ((AuditLog) this.instance).mergeServiceData(value);
            return this;
        }

        public Builder clearServiceData() {
            copyOnWrite();
            ((AuditLog) this.instance).clearServiceData();
            return this;
        }
    }

    /* renamed from: com.google.cloud.audit.AuditLog$1  reason: invalid class name */
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
                return new AuditLog();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.authorizationInfo_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                AuditLog other = (AuditLog) arg1;
                this.serviceName_ = visitor.visitString(!this.serviceName_.isEmpty(), this.serviceName_, !other.serviceName_.isEmpty(), other.serviceName_);
                this.methodName_ = visitor.visitString(!this.methodName_.isEmpty(), this.methodName_, !other.methodName_.isEmpty(), other.methodName_);
                this.resourceName_ = visitor.visitString(!this.resourceName_.isEmpty(), this.resourceName_, !other.resourceName_.isEmpty(), other.resourceName_);
                this.numResponseItems_ = visitor.visitLong(this.numResponseItems_ != 0, this.numResponseItems_, other.numResponseItems_ != 0, other.numResponseItems_);
                this.status_ = (Status) visitor.visitMessage(this.status_, other.status_);
                this.authenticationInfo_ = (AuthenticationInfo) visitor.visitMessage(this.authenticationInfo_, other.authenticationInfo_);
                this.authorizationInfo_ = visitor.visitList(this.authorizationInfo_, other.authorizationInfo_);
                this.requestMetadata_ = (RequestMetadata) visitor.visitMessage(this.requestMetadata_, other.requestMetadata_);
                this.request_ = (Struct) visitor.visitMessage(this.request_, other.request_);
                this.response_ = (Struct) visitor.visitMessage(this.response_, other.response_);
                this.serviceData_ = (Any) visitor.visitMessage(this.serviceData_, other.serviceData_);
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
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 18:
                                Status.Builder subBuilder = null;
                                if (this.status_ != null) {
                                    subBuilder = (Status.Builder) this.status_.toBuilder();
                                }
                                Status status = (Status) input.readMessage(Status.parser(), extensionRegistry);
                                this.status_ = status;
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(status);
                                    this.status_ = (Status) subBuilder.buildPartial();
                                    break;
                                }
                            case 26:
                                AuthenticationInfo.Builder subBuilder2 = null;
                                if (this.authenticationInfo_ != null) {
                                    subBuilder2 = (AuthenticationInfo.Builder) this.authenticationInfo_.toBuilder();
                                }
                                AuthenticationInfo authenticationInfo = (AuthenticationInfo) input.readMessage(AuthenticationInfo.parser(), extensionRegistry);
                                this.authenticationInfo_ = authenticationInfo;
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(authenticationInfo);
                                    this.authenticationInfo_ = (AuthenticationInfo) subBuilder2.buildPartial();
                                    break;
                                }
                            case 34:
                                RequestMetadata.Builder subBuilder3 = null;
                                if (this.requestMetadata_ != null) {
                                    subBuilder3 = (RequestMetadata.Builder) this.requestMetadata_.toBuilder();
                                }
                                RequestMetadata requestMetadata = (RequestMetadata) input.readMessage(RequestMetadata.parser(), extensionRegistry);
                                this.requestMetadata_ = requestMetadata;
                                if (subBuilder3 == null) {
                                    break;
                                } else {
                                    subBuilder3.mergeFrom(requestMetadata);
                                    this.requestMetadata_ = (RequestMetadata) subBuilder3.buildPartial();
                                    break;
                                }
                            case 58:
                                this.serviceName_ = input.readStringRequireUtf8();
                                break;
                            case 66:
                                this.methodName_ = input.readStringRequireUtf8();
                                break;
                            case 74:
                                if (!this.authorizationInfo_.isModifiable()) {
                                    this.authorizationInfo_ = GeneratedMessageLite.mutableCopy(this.authorizationInfo_);
                                }
                                this.authorizationInfo_.add((AuthorizationInfo) input.readMessage(AuthorizationInfo.parser(), extensionRegistry));
                                break;
                            case 90:
                                this.resourceName_ = input.readStringRequireUtf8();
                                break;
                            case 96:
                                this.numResponseItems_ = input.readInt64();
                                break;
                            case 122:
                                Any.Builder subBuilder4 = null;
                                if (this.serviceData_ != null) {
                                    subBuilder4 = (Any.Builder) this.serviceData_.toBuilder();
                                }
                                Any any = (Any) input.readMessage(Any.parser(), extensionRegistry);
                                this.serviceData_ = any;
                                if (subBuilder4 == null) {
                                    break;
                                } else {
                                    subBuilder4.mergeFrom(any);
                                    this.serviceData_ = (Any) subBuilder4.buildPartial();
                                    break;
                                }
                            case 130:
                                Struct.Builder subBuilder5 = null;
                                if (this.request_ != null) {
                                    subBuilder5 = (Struct.Builder) this.request_.toBuilder();
                                }
                                Struct struct = (Struct) input.readMessage(Struct.parser(), extensionRegistry);
                                this.request_ = struct;
                                if (subBuilder5 == null) {
                                    break;
                                } else {
                                    subBuilder5.mergeFrom(struct);
                                    this.request_ = (Struct) subBuilder5.buildPartial();
                                    break;
                                }
                            case 138:
                                Struct.Builder subBuilder6 = null;
                                if (this.response_ != null) {
                                    subBuilder6 = (Struct.Builder) this.response_.toBuilder();
                                }
                                Struct struct2 = (Struct) input.readMessage(Struct.parser(), extensionRegistry);
                                this.response_ = struct2;
                                if (subBuilder6 == null) {
                                    break;
                                } else {
                                    subBuilder6.mergeFrom(struct2);
                                    this.response_ = (Struct) subBuilder6.buildPartial();
                                    break;
                                }
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
                    synchronized (AuditLog.class) {
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
        AuditLog auditLog = new AuditLog();
        DEFAULT_INSTANCE = auditLog;
        auditLog.makeImmutable();
    }

    public static AuditLog getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AuditLog> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
