package com.google.api;

import com.google.api.Authentication;
import com.google.api.Backend;
import com.google.api.Billing;
import com.google.api.Context;
import com.google.api.Control;
import com.google.api.Documentation;
import com.google.api.Endpoint;
import com.google.api.Experimental;
import com.google.api.Http;
import com.google.api.LogDescriptor;
import com.google.api.Logging;
import com.google.api.MetricDescriptor;
import com.google.api.MonitoredResourceDescriptor;
import com.google.api.Monitoring;
import com.google.api.Quota;
import com.google.api.SourceInfo;
import com.google.api.SystemParameters;
import com.google.api.Usage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Api;
import com.google.protobuf.ApiOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Enum;
import com.google.protobuf.EnumOrBuilder;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.Type;
import com.google.protobuf.TypeOrBuilder;
import com.google.protobuf.UInt32Value;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class Service extends GeneratedMessageLite<Service, Builder> implements ServiceOrBuilder {
    public static final int APIS_FIELD_NUMBER = 3;
    public static final int AUTHENTICATION_FIELD_NUMBER = 11;
    public static final int BACKEND_FIELD_NUMBER = 8;
    public static final int BILLING_FIELD_NUMBER = 26;
    public static final int CONFIG_VERSION_FIELD_NUMBER = 20;
    public static final int CONTEXT_FIELD_NUMBER = 12;
    public static final int CONTROL_FIELD_NUMBER = 21;
    /* access modifiers changed from: private */
    public static final Service DEFAULT_INSTANCE;
    public static final int DOCUMENTATION_FIELD_NUMBER = 6;
    public static final int ENDPOINTS_FIELD_NUMBER = 18;
    public static final int ENUMS_FIELD_NUMBER = 5;
    public static final int EXPERIMENTAL_FIELD_NUMBER = 101;
    public static final int HTTP_FIELD_NUMBER = 9;
    public static final int ID_FIELD_NUMBER = 33;
    public static final int LOGGING_FIELD_NUMBER = 27;
    public static final int LOGS_FIELD_NUMBER = 23;
    public static final int METRICS_FIELD_NUMBER = 24;
    public static final int MONITORED_RESOURCES_FIELD_NUMBER = 25;
    public static final int MONITORING_FIELD_NUMBER = 28;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Service> PARSER = null;
    public static final int PRODUCER_PROJECT_ID_FIELD_NUMBER = 22;
    public static final int QUOTA_FIELD_NUMBER = 10;
    public static final int SOURCE_INFO_FIELD_NUMBER = 37;
    public static final int SYSTEM_PARAMETERS_FIELD_NUMBER = 29;
    public static final int TITLE_FIELD_NUMBER = 2;
    public static final int TYPES_FIELD_NUMBER = 4;
    public static final int USAGE_FIELD_NUMBER = 15;
    private Internal.ProtobufList<Api> apis_ = emptyProtobufList();
    private Authentication authentication_;
    private Backend backend_;
    private Billing billing_;
    private int bitField0_;
    private UInt32Value configVersion_;
    private Context context_;
    private Control control_;
    private Documentation documentation_;
    private Internal.ProtobufList<Endpoint> endpoints_ = emptyProtobufList();
    private Internal.ProtobufList<Enum> enums_ = emptyProtobufList();
    private Experimental experimental_;
    private Http http_;
    private String id_ = "";
    private Logging logging_;
    private Internal.ProtobufList<LogDescriptor> logs_ = emptyProtobufList();
    private Internal.ProtobufList<MetricDescriptor> metrics_ = emptyProtobufList();
    private Internal.ProtobufList<MonitoredResourceDescriptor> monitoredResources_ = emptyProtobufList();
    private Monitoring monitoring_;
    private String name_ = "";
    private String producerProjectId_ = "";
    private Quota quota_;
    private SourceInfo sourceInfo_;
    private SystemParameters systemParameters_;
    private String title_ = "";
    private Internal.ProtobufList<Type> types_ = emptyProtobufList();
    private Usage usage_;

    private Service() {
    }

    public boolean hasConfigVersion() {
        return this.configVersion_ != null;
    }

    public UInt32Value getConfigVersion() {
        UInt32Value uInt32Value = this.configVersion_;
        return uInt32Value == null ? UInt32Value.getDefaultInstance() : uInt32Value;
    }

    /* access modifiers changed from: private */
    public void setConfigVersion(UInt32Value value) {
        if (value != null) {
            this.configVersion_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setConfigVersion(UInt32Value.Builder builderForValue) {
        this.configVersion_ = (UInt32Value) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeConfigVersion(UInt32Value value) {
        UInt32Value uInt32Value = this.configVersion_;
        if (uInt32Value == null || uInt32Value == UInt32Value.getDefaultInstance()) {
            this.configVersion_ = value;
        } else {
            this.configVersion_ = (UInt32Value) ((UInt32Value.Builder) UInt32Value.newBuilder(this.configVersion_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearConfigVersion() {
        this.configVersion_ = null;
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

    public String getId() {
        return this.id_;
    }

    public ByteString getIdBytes() {
        return ByteString.copyFromUtf8(this.id_);
    }

    /* access modifiers changed from: private */
    public void setId(String value) {
        if (value != null) {
            this.id_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    /* access modifiers changed from: private */
    public void setIdBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.id_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getTitle() {
        return this.title_;
    }

    public ByteString getTitleBytes() {
        return ByteString.copyFromUtf8(this.title_);
    }

    /* access modifiers changed from: private */
    public void setTitle(String value) {
        if (value != null) {
            this.title_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    /* access modifiers changed from: private */
    public void setTitleBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.title_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public String getProducerProjectId() {
        return this.producerProjectId_;
    }

    public ByteString getProducerProjectIdBytes() {
        return ByteString.copyFromUtf8(this.producerProjectId_);
    }

    /* access modifiers changed from: private */
    public void setProducerProjectId(String value) {
        if (value != null) {
            this.producerProjectId_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearProducerProjectId() {
        this.producerProjectId_ = getDefaultInstance().getProducerProjectId();
    }

    /* access modifiers changed from: private */
    public void setProducerProjectIdBytes(ByteString value) {
        if (value != null) {
            checkByteStringIsUtf8(value);
            this.producerProjectId_ = value.toStringUtf8();
            return;
        }
        throw null;
    }

    public List<Api> getApisList() {
        return this.apis_;
    }

    public List<? extends ApiOrBuilder> getApisOrBuilderList() {
        return this.apis_;
    }

    public int getApisCount() {
        return this.apis_.size();
    }

    public Api getApis(int index) {
        return (Api) this.apis_.get(index);
    }

    public ApiOrBuilder getApisOrBuilder(int index) {
        return (ApiOrBuilder) this.apis_.get(index);
    }

    private void ensureApisIsMutable() {
        if (!this.apis_.isModifiable()) {
            this.apis_ = GeneratedMessageLite.mutableCopy(this.apis_);
        }
    }

    /* access modifiers changed from: private */
    public void setApis(int index, Api value) {
        if (value != null) {
            ensureApisIsMutable();
            this.apis_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setApis(int index, Api.Builder builderForValue) {
        ensureApisIsMutable();
        this.apis_.set(index, (Api) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addApis(Api value) {
        if (value != null) {
            ensureApisIsMutable();
            this.apis_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addApis(int index, Api value) {
        if (value != null) {
            ensureApisIsMutable();
            this.apis_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addApis(Api.Builder builderForValue) {
        ensureApisIsMutable();
        this.apis_.add((Api) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addApis(int index, Api.Builder builderForValue) {
        ensureApisIsMutable();
        this.apis_.add(index, (Api) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllApis(Iterable<? extends Api> values) {
        ensureApisIsMutable();
        AbstractMessageLite.addAll(values, this.apis_);
    }

    /* access modifiers changed from: private */
    public void clearApis() {
        this.apis_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeApis(int index) {
        ensureApisIsMutable();
        this.apis_.remove(index);
    }

    public List<Type> getTypesList() {
        return this.types_;
    }

    public List<? extends TypeOrBuilder> getTypesOrBuilderList() {
        return this.types_;
    }

    public int getTypesCount() {
        return this.types_.size();
    }

    public Type getTypes(int index) {
        return (Type) this.types_.get(index);
    }

    public TypeOrBuilder getTypesOrBuilder(int index) {
        return (TypeOrBuilder) this.types_.get(index);
    }

    private void ensureTypesIsMutable() {
        if (!this.types_.isModifiable()) {
            this.types_ = GeneratedMessageLite.mutableCopy(this.types_);
        }
    }

    /* access modifiers changed from: private */
    public void setTypes(int index, Type value) {
        if (value != null) {
            ensureTypesIsMutable();
            this.types_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setTypes(int index, Type.Builder builderForValue) {
        ensureTypesIsMutable();
        this.types_.set(index, (Type) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addTypes(Type value) {
        if (value != null) {
            ensureTypesIsMutable();
            this.types_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addTypes(int index, Type value) {
        if (value != null) {
            ensureTypesIsMutable();
            this.types_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addTypes(Type.Builder builderForValue) {
        ensureTypesIsMutable();
        this.types_.add((Type) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addTypes(int index, Type.Builder builderForValue) {
        ensureTypesIsMutable();
        this.types_.add(index, (Type) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllTypes(Iterable<? extends Type> values) {
        ensureTypesIsMutable();
        AbstractMessageLite.addAll(values, this.types_);
    }

    /* access modifiers changed from: private */
    public void clearTypes() {
        this.types_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeTypes(int index) {
        ensureTypesIsMutable();
        this.types_.remove(index);
    }

    public List<Enum> getEnumsList() {
        return this.enums_;
    }

    public List<? extends EnumOrBuilder> getEnumsOrBuilderList() {
        return this.enums_;
    }

    public int getEnumsCount() {
        return this.enums_.size();
    }

    public Enum getEnums(int index) {
        return (Enum) this.enums_.get(index);
    }

    public EnumOrBuilder getEnumsOrBuilder(int index) {
        return (EnumOrBuilder) this.enums_.get(index);
    }

    private void ensureEnumsIsMutable() {
        if (!this.enums_.isModifiable()) {
            this.enums_ = GeneratedMessageLite.mutableCopy(this.enums_);
        }
    }

    /* access modifiers changed from: private */
    public void setEnums(int index, Enum value) {
        if (value != null) {
            ensureEnumsIsMutable();
            this.enums_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setEnums(int index, Enum.Builder builderForValue) {
        ensureEnumsIsMutable();
        this.enums_.set(index, (Enum) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addEnums(Enum value) {
        if (value != null) {
            ensureEnumsIsMutable();
            this.enums_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addEnums(int index, Enum value) {
        if (value != null) {
            ensureEnumsIsMutable();
            this.enums_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addEnums(Enum.Builder builderForValue) {
        ensureEnumsIsMutable();
        this.enums_.add((Enum) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addEnums(int index, Enum.Builder builderForValue) {
        ensureEnumsIsMutable();
        this.enums_.add(index, (Enum) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllEnums(Iterable<? extends Enum> values) {
        ensureEnumsIsMutable();
        AbstractMessageLite.addAll(values, this.enums_);
    }

    /* access modifiers changed from: private */
    public void clearEnums() {
        this.enums_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeEnums(int index) {
        ensureEnumsIsMutable();
        this.enums_.remove(index);
    }

    public boolean hasDocumentation() {
        return this.documentation_ != null;
    }

    public Documentation getDocumentation() {
        Documentation documentation = this.documentation_;
        return documentation == null ? Documentation.getDefaultInstance() : documentation;
    }

    /* access modifiers changed from: private */
    public void setDocumentation(Documentation value) {
        if (value != null) {
            this.documentation_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setDocumentation(Documentation.Builder builderForValue) {
        this.documentation_ = (Documentation) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeDocumentation(Documentation value) {
        Documentation documentation = this.documentation_;
        if (documentation == null || documentation == Documentation.getDefaultInstance()) {
            this.documentation_ = value;
        } else {
            this.documentation_ = (Documentation) ((Documentation.Builder) Documentation.newBuilder(this.documentation_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearDocumentation() {
        this.documentation_ = null;
    }

    public boolean hasBackend() {
        return this.backend_ != null;
    }

    public Backend getBackend() {
        Backend backend = this.backend_;
        return backend == null ? Backend.getDefaultInstance() : backend;
    }

    /* access modifiers changed from: private */
    public void setBackend(Backend value) {
        if (value != null) {
            this.backend_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setBackend(Backend.Builder builderForValue) {
        this.backend_ = (Backend) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeBackend(Backend value) {
        Backend backend = this.backend_;
        if (backend == null || backend == Backend.getDefaultInstance()) {
            this.backend_ = value;
        } else {
            this.backend_ = (Backend) ((Backend.Builder) Backend.newBuilder(this.backend_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearBackend() {
        this.backend_ = null;
    }

    public boolean hasHttp() {
        return this.http_ != null;
    }

    public Http getHttp() {
        Http http = this.http_;
        return http == null ? Http.getDefaultInstance() : http;
    }

    /* access modifiers changed from: private */
    public void setHttp(Http value) {
        if (value != null) {
            this.http_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setHttp(Http.Builder builderForValue) {
        this.http_ = (Http) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeHttp(Http value) {
        Http http = this.http_;
        if (http == null || http == Http.getDefaultInstance()) {
            this.http_ = value;
        } else {
            this.http_ = (Http) ((Http.Builder) Http.newBuilder(this.http_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearHttp() {
        this.http_ = null;
    }

    public boolean hasQuota() {
        return this.quota_ != null;
    }

    public Quota getQuota() {
        Quota quota = this.quota_;
        return quota == null ? Quota.getDefaultInstance() : quota;
    }

    /* access modifiers changed from: private */
    public void setQuota(Quota value) {
        if (value != null) {
            this.quota_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setQuota(Quota.Builder builderForValue) {
        this.quota_ = (Quota) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeQuota(Quota value) {
        Quota quota = this.quota_;
        if (quota == null || quota == Quota.getDefaultInstance()) {
            this.quota_ = value;
        } else {
            this.quota_ = (Quota) ((Quota.Builder) Quota.newBuilder(this.quota_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearQuota() {
        this.quota_ = null;
    }

    public boolean hasAuthentication() {
        return this.authentication_ != null;
    }

    public Authentication getAuthentication() {
        Authentication authentication = this.authentication_;
        return authentication == null ? Authentication.getDefaultInstance() : authentication;
    }

    /* access modifiers changed from: private */
    public void setAuthentication(Authentication value) {
        if (value != null) {
            this.authentication_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setAuthentication(Authentication.Builder builderForValue) {
        this.authentication_ = (Authentication) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeAuthentication(Authentication value) {
        Authentication authentication = this.authentication_;
        if (authentication == null || authentication == Authentication.getDefaultInstance()) {
            this.authentication_ = value;
        } else {
            this.authentication_ = (Authentication) ((Authentication.Builder) Authentication.newBuilder(this.authentication_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearAuthentication() {
        this.authentication_ = null;
    }

    public boolean hasContext() {
        return this.context_ != null;
    }

    public Context getContext() {
        Context context = this.context_;
        return context == null ? Context.getDefaultInstance() : context;
    }

    /* access modifiers changed from: private */
    public void setContext(Context value) {
        if (value != null) {
            this.context_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setContext(Context.Builder builderForValue) {
        this.context_ = (Context) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeContext(Context value) {
        Context context = this.context_;
        if (context == null || context == Context.getDefaultInstance()) {
            this.context_ = value;
        } else {
            this.context_ = (Context) ((Context.Builder) Context.newBuilder(this.context_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearContext() {
        this.context_ = null;
    }

    public boolean hasUsage() {
        return this.usage_ != null;
    }

    public Usage getUsage() {
        Usage usage = this.usage_;
        return usage == null ? Usage.getDefaultInstance() : usage;
    }

    /* access modifiers changed from: private */
    public void setUsage(Usage value) {
        if (value != null) {
            this.usage_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setUsage(Usage.Builder builderForValue) {
        this.usage_ = (Usage) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeUsage(Usage value) {
        Usage usage = this.usage_;
        if (usage == null || usage == Usage.getDefaultInstance()) {
            this.usage_ = value;
        } else {
            this.usage_ = (Usage) ((Usage.Builder) Usage.newBuilder(this.usage_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearUsage() {
        this.usage_ = null;
    }

    public List<Endpoint> getEndpointsList() {
        return this.endpoints_;
    }

    public List<? extends EndpointOrBuilder> getEndpointsOrBuilderList() {
        return this.endpoints_;
    }

    public int getEndpointsCount() {
        return this.endpoints_.size();
    }

    public Endpoint getEndpoints(int index) {
        return (Endpoint) this.endpoints_.get(index);
    }

    public EndpointOrBuilder getEndpointsOrBuilder(int index) {
        return (EndpointOrBuilder) this.endpoints_.get(index);
    }

    private void ensureEndpointsIsMutable() {
        if (!this.endpoints_.isModifiable()) {
            this.endpoints_ = GeneratedMessageLite.mutableCopy(this.endpoints_);
        }
    }

    /* access modifiers changed from: private */
    public void setEndpoints(int index, Endpoint value) {
        if (value != null) {
            ensureEndpointsIsMutable();
            this.endpoints_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setEndpoints(int index, Endpoint.Builder builderForValue) {
        ensureEndpointsIsMutable();
        this.endpoints_.set(index, (Endpoint) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addEndpoints(Endpoint value) {
        if (value != null) {
            ensureEndpointsIsMutable();
            this.endpoints_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addEndpoints(int index, Endpoint value) {
        if (value != null) {
            ensureEndpointsIsMutable();
            this.endpoints_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addEndpoints(Endpoint.Builder builderForValue) {
        ensureEndpointsIsMutable();
        this.endpoints_.add((Endpoint) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addEndpoints(int index, Endpoint.Builder builderForValue) {
        ensureEndpointsIsMutable();
        this.endpoints_.add(index, (Endpoint) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllEndpoints(Iterable<? extends Endpoint> values) {
        ensureEndpointsIsMutable();
        AbstractMessageLite.addAll(values, this.endpoints_);
    }

    /* access modifiers changed from: private */
    public void clearEndpoints() {
        this.endpoints_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeEndpoints(int index) {
        ensureEndpointsIsMutable();
        this.endpoints_.remove(index);
    }

    public boolean hasControl() {
        return this.control_ != null;
    }

    public Control getControl() {
        Control control = this.control_;
        return control == null ? Control.getDefaultInstance() : control;
    }

    /* access modifiers changed from: private */
    public void setControl(Control value) {
        if (value != null) {
            this.control_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setControl(Control.Builder builderForValue) {
        this.control_ = (Control) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeControl(Control value) {
        Control control = this.control_;
        if (control == null || control == Control.getDefaultInstance()) {
            this.control_ = value;
        } else {
            this.control_ = (Control) ((Control.Builder) Control.newBuilder(this.control_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearControl() {
        this.control_ = null;
    }

    public List<LogDescriptor> getLogsList() {
        return this.logs_;
    }

    public List<? extends LogDescriptorOrBuilder> getLogsOrBuilderList() {
        return this.logs_;
    }

    public int getLogsCount() {
        return this.logs_.size();
    }

    public LogDescriptor getLogs(int index) {
        return (LogDescriptor) this.logs_.get(index);
    }

    public LogDescriptorOrBuilder getLogsOrBuilder(int index) {
        return (LogDescriptorOrBuilder) this.logs_.get(index);
    }

    private void ensureLogsIsMutable() {
        if (!this.logs_.isModifiable()) {
            this.logs_ = GeneratedMessageLite.mutableCopy(this.logs_);
        }
    }

    /* access modifiers changed from: private */
    public void setLogs(int index, LogDescriptor value) {
        if (value != null) {
            ensureLogsIsMutable();
            this.logs_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setLogs(int index, LogDescriptor.Builder builderForValue) {
        ensureLogsIsMutable();
        this.logs_.set(index, (LogDescriptor) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addLogs(LogDescriptor value) {
        if (value != null) {
            ensureLogsIsMutable();
            this.logs_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addLogs(int index, LogDescriptor value) {
        if (value != null) {
            ensureLogsIsMutable();
            this.logs_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addLogs(LogDescriptor.Builder builderForValue) {
        ensureLogsIsMutable();
        this.logs_.add((LogDescriptor) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addLogs(int index, LogDescriptor.Builder builderForValue) {
        ensureLogsIsMutable();
        this.logs_.add(index, (LogDescriptor) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllLogs(Iterable<? extends LogDescriptor> values) {
        ensureLogsIsMutable();
        AbstractMessageLite.addAll(values, this.logs_);
    }

    /* access modifiers changed from: private */
    public void clearLogs() {
        this.logs_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeLogs(int index) {
        ensureLogsIsMutable();
        this.logs_.remove(index);
    }

    public List<MetricDescriptor> getMetricsList() {
        return this.metrics_;
    }

    public List<? extends MetricDescriptorOrBuilder> getMetricsOrBuilderList() {
        return this.metrics_;
    }

    public int getMetricsCount() {
        return this.metrics_.size();
    }

    public MetricDescriptor getMetrics(int index) {
        return (MetricDescriptor) this.metrics_.get(index);
    }

    public MetricDescriptorOrBuilder getMetricsOrBuilder(int index) {
        return (MetricDescriptorOrBuilder) this.metrics_.get(index);
    }

    private void ensureMetricsIsMutable() {
        if (!this.metrics_.isModifiable()) {
            this.metrics_ = GeneratedMessageLite.mutableCopy(this.metrics_);
        }
    }

    /* access modifiers changed from: private */
    public void setMetrics(int index, MetricDescriptor value) {
        if (value != null) {
            ensureMetricsIsMutable();
            this.metrics_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setMetrics(int index, MetricDescriptor.Builder builderForValue) {
        ensureMetricsIsMutable();
        this.metrics_.set(index, (MetricDescriptor) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addMetrics(MetricDescriptor value) {
        if (value != null) {
            ensureMetricsIsMutable();
            this.metrics_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addMetrics(int index, MetricDescriptor value) {
        if (value != null) {
            ensureMetricsIsMutable();
            this.metrics_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addMetrics(MetricDescriptor.Builder builderForValue) {
        ensureMetricsIsMutable();
        this.metrics_.add((MetricDescriptor) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addMetrics(int index, MetricDescriptor.Builder builderForValue) {
        ensureMetricsIsMutable();
        this.metrics_.add(index, (MetricDescriptor) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllMetrics(Iterable<? extends MetricDescriptor> values) {
        ensureMetricsIsMutable();
        AbstractMessageLite.addAll(values, this.metrics_);
    }

    /* access modifiers changed from: private */
    public void clearMetrics() {
        this.metrics_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeMetrics(int index) {
        ensureMetricsIsMutable();
        this.metrics_.remove(index);
    }

    public List<MonitoredResourceDescriptor> getMonitoredResourcesList() {
        return this.monitoredResources_;
    }

    public List<? extends MonitoredResourceDescriptorOrBuilder> getMonitoredResourcesOrBuilderList() {
        return this.monitoredResources_;
    }

    public int getMonitoredResourcesCount() {
        return this.monitoredResources_.size();
    }

    public MonitoredResourceDescriptor getMonitoredResources(int index) {
        return (MonitoredResourceDescriptor) this.monitoredResources_.get(index);
    }

    public MonitoredResourceDescriptorOrBuilder getMonitoredResourcesOrBuilder(int index) {
        return (MonitoredResourceDescriptorOrBuilder) this.monitoredResources_.get(index);
    }

    private void ensureMonitoredResourcesIsMutable() {
        if (!this.monitoredResources_.isModifiable()) {
            this.monitoredResources_ = GeneratedMessageLite.mutableCopy(this.monitoredResources_);
        }
    }

    /* access modifiers changed from: private */
    public void setMonitoredResources(int index, MonitoredResourceDescriptor value) {
        if (value != null) {
            ensureMonitoredResourcesIsMutable();
            this.monitoredResources_.set(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setMonitoredResources(int index, MonitoredResourceDescriptor.Builder builderForValue) {
        ensureMonitoredResourcesIsMutable();
        this.monitoredResources_.set(index, (MonitoredResourceDescriptor) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addMonitoredResources(MonitoredResourceDescriptor value) {
        if (value != null) {
            ensureMonitoredResourcesIsMutable();
            this.monitoredResources_.add(value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addMonitoredResources(int index, MonitoredResourceDescriptor value) {
        if (value != null) {
            ensureMonitoredResourcesIsMutable();
            this.monitoredResources_.add(index, value);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addMonitoredResources(MonitoredResourceDescriptor.Builder builderForValue) {
        ensureMonitoredResourcesIsMutable();
        this.monitoredResources_.add((MonitoredResourceDescriptor) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addMonitoredResources(int index, MonitoredResourceDescriptor.Builder builderForValue) {
        ensureMonitoredResourcesIsMutable();
        this.monitoredResources_.add(index, (MonitoredResourceDescriptor) builderForValue.build());
    }

    /* access modifiers changed from: private */
    public void addAllMonitoredResources(Iterable<? extends MonitoredResourceDescriptor> values) {
        ensureMonitoredResourcesIsMutable();
        AbstractMessageLite.addAll(values, this.monitoredResources_);
    }

    /* access modifiers changed from: private */
    public void clearMonitoredResources() {
        this.monitoredResources_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeMonitoredResources(int index) {
        ensureMonitoredResourcesIsMutable();
        this.monitoredResources_.remove(index);
    }

    public boolean hasBilling() {
        return this.billing_ != null;
    }

    public Billing getBilling() {
        Billing billing = this.billing_;
        return billing == null ? Billing.getDefaultInstance() : billing;
    }

    /* access modifiers changed from: private */
    public void setBilling(Billing value) {
        if (value != null) {
            this.billing_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setBilling(Billing.Builder builderForValue) {
        this.billing_ = (Billing) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeBilling(Billing value) {
        Billing billing = this.billing_;
        if (billing == null || billing == Billing.getDefaultInstance()) {
            this.billing_ = value;
        } else {
            this.billing_ = (Billing) ((Billing.Builder) Billing.newBuilder(this.billing_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearBilling() {
        this.billing_ = null;
    }

    public boolean hasLogging() {
        return this.logging_ != null;
    }

    public Logging getLogging() {
        Logging logging = this.logging_;
        return logging == null ? Logging.getDefaultInstance() : logging;
    }

    /* access modifiers changed from: private */
    public void setLogging(Logging value) {
        if (value != null) {
            this.logging_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setLogging(Logging.Builder builderForValue) {
        this.logging_ = (Logging) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeLogging(Logging value) {
        Logging logging = this.logging_;
        if (logging == null || logging == Logging.getDefaultInstance()) {
            this.logging_ = value;
        } else {
            this.logging_ = (Logging) ((Logging.Builder) Logging.newBuilder(this.logging_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearLogging() {
        this.logging_ = null;
    }

    public boolean hasMonitoring() {
        return this.monitoring_ != null;
    }

    public Monitoring getMonitoring() {
        Monitoring monitoring = this.monitoring_;
        return monitoring == null ? Monitoring.getDefaultInstance() : monitoring;
    }

    /* access modifiers changed from: private */
    public void setMonitoring(Monitoring value) {
        if (value != null) {
            this.monitoring_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setMonitoring(Monitoring.Builder builderForValue) {
        this.monitoring_ = (Monitoring) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeMonitoring(Monitoring value) {
        Monitoring monitoring = this.monitoring_;
        if (monitoring == null || monitoring == Monitoring.getDefaultInstance()) {
            this.monitoring_ = value;
        } else {
            this.monitoring_ = (Monitoring) ((Monitoring.Builder) Monitoring.newBuilder(this.monitoring_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearMonitoring() {
        this.monitoring_ = null;
    }

    public boolean hasSystemParameters() {
        return this.systemParameters_ != null;
    }

    public SystemParameters getSystemParameters() {
        SystemParameters systemParameters = this.systemParameters_;
        return systemParameters == null ? SystemParameters.getDefaultInstance() : systemParameters;
    }

    /* access modifiers changed from: private */
    public void setSystemParameters(SystemParameters value) {
        if (value != null) {
            this.systemParameters_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setSystemParameters(SystemParameters.Builder builderForValue) {
        this.systemParameters_ = (SystemParameters) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeSystemParameters(SystemParameters value) {
        SystemParameters systemParameters = this.systemParameters_;
        if (systemParameters == null || systemParameters == SystemParameters.getDefaultInstance()) {
            this.systemParameters_ = value;
        } else {
            this.systemParameters_ = (SystemParameters) ((SystemParameters.Builder) SystemParameters.newBuilder(this.systemParameters_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearSystemParameters() {
        this.systemParameters_ = null;
    }

    public boolean hasSourceInfo() {
        return this.sourceInfo_ != null;
    }

    public SourceInfo getSourceInfo() {
        SourceInfo sourceInfo = this.sourceInfo_;
        return sourceInfo == null ? SourceInfo.getDefaultInstance() : sourceInfo;
    }

    /* access modifiers changed from: private */
    public void setSourceInfo(SourceInfo value) {
        if (value != null) {
            this.sourceInfo_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setSourceInfo(SourceInfo.Builder builderForValue) {
        this.sourceInfo_ = (SourceInfo) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeSourceInfo(SourceInfo value) {
        SourceInfo sourceInfo = this.sourceInfo_;
        if (sourceInfo == null || sourceInfo == SourceInfo.getDefaultInstance()) {
            this.sourceInfo_ = value;
        } else {
            this.sourceInfo_ = (SourceInfo) ((SourceInfo.Builder) SourceInfo.newBuilder(this.sourceInfo_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearSourceInfo() {
        this.sourceInfo_ = null;
    }

    public boolean hasExperimental() {
        return this.experimental_ != null;
    }

    public Experimental getExperimental() {
        Experimental experimental = this.experimental_;
        return experimental == null ? Experimental.getDefaultInstance() : experimental;
    }

    /* access modifiers changed from: private */
    public void setExperimental(Experimental value) {
        if (value != null) {
            this.experimental_ = value;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setExperimental(Experimental.Builder builderForValue) {
        this.experimental_ = (Experimental) builderForValue.build();
    }

    /* access modifiers changed from: private */
    public void mergeExperimental(Experimental value) {
        Experimental experimental = this.experimental_;
        if (experimental == null || experimental == Experimental.getDefaultInstance()) {
            this.experimental_ = value;
        } else {
            this.experimental_ = (Experimental) ((Experimental.Builder) Experimental.newBuilder(this.experimental_).mergeFrom(value)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearExperimental() {
        this.experimental_ = null;
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (!this.name_.isEmpty()) {
            output.writeString(1, getName());
        }
        if (!this.title_.isEmpty()) {
            output.writeString(2, getTitle());
        }
        for (int i = 0; i < this.apis_.size(); i++) {
            output.writeMessage(3, (MessageLite) this.apis_.get(i));
        }
        for (int i2 = 0; i2 < this.types_.size(); i2++) {
            output.writeMessage(4, (MessageLite) this.types_.get(i2));
        }
        for (int i3 = 0; i3 < this.enums_.size(); i3++) {
            output.writeMessage(5, (MessageLite) this.enums_.get(i3));
        }
        if (this.documentation_ != null) {
            output.writeMessage(6, getDocumentation());
        }
        if (this.backend_ != null) {
            output.writeMessage(8, getBackend());
        }
        if (this.http_ != null) {
            output.writeMessage(9, getHttp());
        }
        if (this.quota_ != null) {
            output.writeMessage(10, getQuota());
        }
        if (this.authentication_ != null) {
            output.writeMessage(11, getAuthentication());
        }
        if (this.context_ != null) {
            output.writeMessage(12, getContext());
        }
        if (this.usage_ != null) {
            output.writeMessage(15, getUsage());
        }
        for (int i4 = 0; i4 < this.endpoints_.size(); i4++) {
            output.writeMessage(18, (MessageLite) this.endpoints_.get(i4));
        }
        if (this.configVersion_ != null) {
            output.writeMessage(20, getConfigVersion());
        }
        if (this.control_ != null) {
            output.writeMessage(21, getControl());
        }
        if (!this.producerProjectId_.isEmpty()) {
            output.writeString(22, getProducerProjectId());
        }
        for (int i5 = 0; i5 < this.logs_.size(); i5++) {
            output.writeMessage(23, (MessageLite) this.logs_.get(i5));
        }
        for (int i6 = 0; i6 < this.metrics_.size(); i6++) {
            output.writeMessage(24, (MessageLite) this.metrics_.get(i6));
        }
        for (int i7 = 0; i7 < this.monitoredResources_.size(); i7++) {
            output.writeMessage(25, (MessageLite) this.monitoredResources_.get(i7));
        }
        if (this.billing_ != null) {
            output.writeMessage(26, getBilling());
        }
        if (this.logging_ != null) {
            output.writeMessage(27, getLogging());
        }
        if (this.monitoring_ != null) {
            output.writeMessage(28, getMonitoring());
        }
        if (this.systemParameters_ != null) {
            output.writeMessage(29, getSystemParameters());
        }
        if (!this.id_.isEmpty()) {
            output.writeString(33, getId());
        }
        if (this.sourceInfo_ != null) {
            output.writeMessage(37, getSourceInfo());
        }
        if (this.experimental_ != null) {
            output.writeMessage(101, getExperimental());
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
        if (!this.title_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(2, getTitle());
        }
        for (int i = 0; i < this.apis_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(3, (MessageLite) this.apis_.get(i));
        }
        for (int i2 = 0; i2 < this.types_.size(); i2++) {
            size2 += CodedOutputStream.computeMessageSize(4, (MessageLite) this.types_.get(i2));
        }
        for (int i3 = 0; i3 < this.enums_.size(); i3++) {
            size2 += CodedOutputStream.computeMessageSize(5, (MessageLite) this.enums_.get(i3));
        }
        if (this.documentation_ != null) {
            size2 += CodedOutputStream.computeMessageSize(6, getDocumentation());
        }
        if (this.backend_ != null) {
            size2 += CodedOutputStream.computeMessageSize(8, getBackend());
        }
        if (this.http_ != null) {
            size2 += CodedOutputStream.computeMessageSize(9, getHttp());
        }
        if (this.quota_ != null) {
            size2 += CodedOutputStream.computeMessageSize(10, getQuota());
        }
        if (this.authentication_ != null) {
            size2 += CodedOutputStream.computeMessageSize(11, getAuthentication());
        }
        if (this.context_ != null) {
            size2 += CodedOutputStream.computeMessageSize(12, getContext());
        }
        if (this.usage_ != null) {
            size2 += CodedOutputStream.computeMessageSize(15, getUsage());
        }
        for (int i4 = 0; i4 < this.endpoints_.size(); i4++) {
            size2 += CodedOutputStream.computeMessageSize(18, (MessageLite) this.endpoints_.get(i4));
        }
        if (this.configVersion_ != null) {
            size2 += CodedOutputStream.computeMessageSize(20, getConfigVersion());
        }
        if (this.control_ != null) {
            size2 += CodedOutputStream.computeMessageSize(21, getControl());
        }
        if (!this.producerProjectId_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(22, getProducerProjectId());
        }
        for (int i5 = 0; i5 < this.logs_.size(); i5++) {
            size2 += CodedOutputStream.computeMessageSize(23, (MessageLite) this.logs_.get(i5));
        }
        for (int i6 = 0; i6 < this.metrics_.size(); i6++) {
            size2 += CodedOutputStream.computeMessageSize(24, (MessageLite) this.metrics_.get(i6));
        }
        for (int i7 = 0; i7 < this.monitoredResources_.size(); i7++) {
            size2 += CodedOutputStream.computeMessageSize(25, (MessageLite) this.monitoredResources_.get(i7));
        }
        if (this.billing_ != null) {
            size2 += CodedOutputStream.computeMessageSize(26, getBilling());
        }
        if (this.logging_ != null) {
            size2 += CodedOutputStream.computeMessageSize(27, getLogging());
        }
        if (this.monitoring_ != null) {
            size2 += CodedOutputStream.computeMessageSize(28, getMonitoring());
        }
        if (this.systemParameters_ != null) {
            size2 += CodedOutputStream.computeMessageSize(29, getSystemParameters());
        }
        if (!this.id_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(33, getId());
        }
        if (this.sourceInfo_ != null) {
            size2 += CodedOutputStream.computeMessageSize(37, getSourceInfo());
        }
        if (this.experimental_ != null) {
            size2 += CodedOutputStream.computeMessageSize(101, getExperimental());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static Service parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Service) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Service parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Service) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Service parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Service) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Service parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Service) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Service parseFrom(InputStream input) throws IOException {
        return (Service) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Service parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Service) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Service parseDelimitedFrom(InputStream input) throws IOException {
        return (Service) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Service parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Service) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Service parseFrom(CodedInputStream input) throws IOException {
        return (Service) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Service parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Service) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Service prototype) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(prototype);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Service, Builder> implements ServiceOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            super(Service.DEFAULT_INSTANCE);
        }

        public boolean hasConfigVersion() {
            return ((Service) this.instance).hasConfigVersion();
        }

        public UInt32Value getConfigVersion() {
            return ((Service) this.instance).getConfigVersion();
        }

        public Builder setConfigVersion(UInt32Value value) {
            copyOnWrite();
            ((Service) this.instance).setConfigVersion(value);
            return this;
        }

        public Builder setConfigVersion(UInt32Value.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).setConfigVersion(builderForValue);
            return this;
        }

        public Builder mergeConfigVersion(UInt32Value value) {
            copyOnWrite();
            ((Service) this.instance).mergeConfigVersion(value);
            return this;
        }

        public Builder clearConfigVersion() {
            copyOnWrite();
            ((Service) this.instance).clearConfigVersion();
            return this;
        }

        public String getName() {
            return ((Service) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((Service) this.instance).getNameBytes();
        }

        public Builder setName(String value) {
            copyOnWrite();
            ((Service) this.instance).setName(value);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((Service) this.instance).clearName();
            return this;
        }

        public Builder setNameBytes(ByteString value) {
            copyOnWrite();
            ((Service) this.instance).setNameBytes(value);
            return this;
        }

        public String getId() {
            return ((Service) this.instance).getId();
        }

        public ByteString getIdBytes() {
            return ((Service) this.instance).getIdBytes();
        }

        public Builder setId(String value) {
            copyOnWrite();
            ((Service) this.instance).setId(value);
            return this;
        }

        public Builder clearId() {
            copyOnWrite();
            ((Service) this.instance).clearId();
            return this;
        }

        public Builder setIdBytes(ByteString value) {
            copyOnWrite();
            ((Service) this.instance).setIdBytes(value);
            return this;
        }

        public String getTitle() {
            return ((Service) this.instance).getTitle();
        }

        public ByteString getTitleBytes() {
            return ((Service) this.instance).getTitleBytes();
        }

        public Builder setTitle(String value) {
            copyOnWrite();
            ((Service) this.instance).setTitle(value);
            return this;
        }

        public Builder clearTitle() {
            copyOnWrite();
            ((Service) this.instance).clearTitle();
            return this;
        }

        public Builder setTitleBytes(ByteString value) {
            copyOnWrite();
            ((Service) this.instance).setTitleBytes(value);
            return this;
        }

        public String getProducerProjectId() {
            return ((Service) this.instance).getProducerProjectId();
        }

        public ByteString getProducerProjectIdBytes() {
            return ((Service) this.instance).getProducerProjectIdBytes();
        }

        public Builder setProducerProjectId(String value) {
            copyOnWrite();
            ((Service) this.instance).setProducerProjectId(value);
            return this;
        }

        public Builder clearProducerProjectId() {
            copyOnWrite();
            ((Service) this.instance).clearProducerProjectId();
            return this;
        }

        public Builder setProducerProjectIdBytes(ByteString value) {
            copyOnWrite();
            ((Service) this.instance).setProducerProjectIdBytes(value);
            return this;
        }

        public List<Api> getApisList() {
            return Collections.unmodifiableList(((Service) this.instance).getApisList());
        }

        public int getApisCount() {
            return ((Service) this.instance).getApisCount();
        }

        public Api getApis(int index) {
            return ((Service) this.instance).getApis(index);
        }

        public Builder setApis(int index, Api value) {
            copyOnWrite();
            ((Service) this.instance).setApis(index, value);
            return this;
        }

        public Builder setApis(int index, Api.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).setApis(index, builderForValue);
            return this;
        }

        public Builder addApis(Api value) {
            copyOnWrite();
            ((Service) this.instance).addApis(value);
            return this;
        }

        public Builder addApis(int index, Api value) {
            copyOnWrite();
            ((Service) this.instance).addApis(index, value);
            return this;
        }

        public Builder addApis(Api.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).addApis(builderForValue);
            return this;
        }

        public Builder addApis(int index, Api.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).addApis(index, builderForValue);
            return this;
        }

        public Builder addAllApis(Iterable<? extends Api> values) {
            copyOnWrite();
            ((Service) this.instance).addAllApis(values);
            return this;
        }

        public Builder clearApis() {
            copyOnWrite();
            ((Service) this.instance).clearApis();
            return this;
        }

        public Builder removeApis(int index) {
            copyOnWrite();
            ((Service) this.instance).removeApis(index);
            return this;
        }

        public List<Type> getTypesList() {
            return Collections.unmodifiableList(((Service) this.instance).getTypesList());
        }

        public int getTypesCount() {
            return ((Service) this.instance).getTypesCount();
        }

        public Type getTypes(int index) {
            return ((Service) this.instance).getTypes(index);
        }

        public Builder setTypes(int index, Type value) {
            copyOnWrite();
            ((Service) this.instance).setTypes(index, value);
            return this;
        }

        public Builder setTypes(int index, Type.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).setTypes(index, builderForValue);
            return this;
        }

        public Builder addTypes(Type value) {
            copyOnWrite();
            ((Service) this.instance).addTypes(value);
            return this;
        }

        public Builder addTypes(int index, Type value) {
            copyOnWrite();
            ((Service) this.instance).addTypes(index, value);
            return this;
        }

        public Builder addTypes(Type.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).addTypes(builderForValue);
            return this;
        }

        public Builder addTypes(int index, Type.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).addTypes(index, builderForValue);
            return this;
        }

        public Builder addAllTypes(Iterable<? extends Type> values) {
            copyOnWrite();
            ((Service) this.instance).addAllTypes(values);
            return this;
        }

        public Builder clearTypes() {
            copyOnWrite();
            ((Service) this.instance).clearTypes();
            return this;
        }

        public Builder removeTypes(int index) {
            copyOnWrite();
            ((Service) this.instance).removeTypes(index);
            return this;
        }

        public List<Enum> getEnumsList() {
            return Collections.unmodifiableList(((Service) this.instance).getEnumsList());
        }

        public int getEnumsCount() {
            return ((Service) this.instance).getEnumsCount();
        }

        public Enum getEnums(int index) {
            return ((Service) this.instance).getEnums(index);
        }

        public Builder setEnums(int index, Enum value) {
            copyOnWrite();
            ((Service) this.instance).setEnums(index, value);
            return this;
        }

        public Builder setEnums(int index, Enum.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).setEnums(index, builderForValue);
            return this;
        }

        public Builder addEnums(Enum value) {
            copyOnWrite();
            ((Service) this.instance).addEnums(value);
            return this;
        }

        public Builder addEnums(int index, Enum value) {
            copyOnWrite();
            ((Service) this.instance).addEnums(index, value);
            return this;
        }

        public Builder addEnums(Enum.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).addEnums(builderForValue);
            return this;
        }

        public Builder addEnums(int index, Enum.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).addEnums(index, builderForValue);
            return this;
        }

        public Builder addAllEnums(Iterable<? extends Enum> values) {
            copyOnWrite();
            ((Service) this.instance).addAllEnums(values);
            return this;
        }

        public Builder clearEnums() {
            copyOnWrite();
            ((Service) this.instance).clearEnums();
            return this;
        }

        public Builder removeEnums(int index) {
            copyOnWrite();
            ((Service) this.instance).removeEnums(index);
            return this;
        }

        public boolean hasDocumentation() {
            return ((Service) this.instance).hasDocumentation();
        }

        public Documentation getDocumentation() {
            return ((Service) this.instance).getDocumentation();
        }

        public Builder setDocumentation(Documentation value) {
            copyOnWrite();
            ((Service) this.instance).setDocumentation(value);
            return this;
        }

        public Builder setDocumentation(Documentation.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).setDocumentation(builderForValue);
            return this;
        }

        public Builder mergeDocumentation(Documentation value) {
            copyOnWrite();
            ((Service) this.instance).mergeDocumentation(value);
            return this;
        }

        public Builder clearDocumentation() {
            copyOnWrite();
            ((Service) this.instance).clearDocumentation();
            return this;
        }

        public boolean hasBackend() {
            return ((Service) this.instance).hasBackend();
        }

        public Backend getBackend() {
            return ((Service) this.instance).getBackend();
        }

        public Builder setBackend(Backend value) {
            copyOnWrite();
            ((Service) this.instance).setBackend(value);
            return this;
        }

        public Builder setBackend(Backend.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).setBackend(builderForValue);
            return this;
        }

        public Builder mergeBackend(Backend value) {
            copyOnWrite();
            ((Service) this.instance).mergeBackend(value);
            return this;
        }

        public Builder clearBackend() {
            copyOnWrite();
            ((Service) this.instance).clearBackend();
            return this;
        }

        public boolean hasHttp() {
            return ((Service) this.instance).hasHttp();
        }

        public Http getHttp() {
            return ((Service) this.instance).getHttp();
        }

        public Builder setHttp(Http value) {
            copyOnWrite();
            ((Service) this.instance).setHttp(value);
            return this;
        }

        public Builder setHttp(Http.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).setHttp(builderForValue);
            return this;
        }

        public Builder mergeHttp(Http value) {
            copyOnWrite();
            ((Service) this.instance).mergeHttp(value);
            return this;
        }

        public Builder clearHttp() {
            copyOnWrite();
            ((Service) this.instance).clearHttp();
            return this;
        }

        public boolean hasQuota() {
            return ((Service) this.instance).hasQuota();
        }

        public Quota getQuota() {
            return ((Service) this.instance).getQuota();
        }

        public Builder setQuota(Quota value) {
            copyOnWrite();
            ((Service) this.instance).setQuota(value);
            return this;
        }

        public Builder setQuota(Quota.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).setQuota(builderForValue);
            return this;
        }

        public Builder mergeQuota(Quota value) {
            copyOnWrite();
            ((Service) this.instance).mergeQuota(value);
            return this;
        }

        public Builder clearQuota() {
            copyOnWrite();
            ((Service) this.instance).clearQuota();
            return this;
        }

        public boolean hasAuthentication() {
            return ((Service) this.instance).hasAuthentication();
        }

        public Authentication getAuthentication() {
            return ((Service) this.instance).getAuthentication();
        }

        public Builder setAuthentication(Authentication value) {
            copyOnWrite();
            ((Service) this.instance).setAuthentication(value);
            return this;
        }

        public Builder setAuthentication(Authentication.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).setAuthentication(builderForValue);
            return this;
        }

        public Builder mergeAuthentication(Authentication value) {
            copyOnWrite();
            ((Service) this.instance).mergeAuthentication(value);
            return this;
        }

        public Builder clearAuthentication() {
            copyOnWrite();
            ((Service) this.instance).clearAuthentication();
            return this;
        }

        public boolean hasContext() {
            return ((Service) this.instance).hasContext();
        }

        public Context getContext() {
            return ((Service) this.instance).getContext();
        }

        public Builder setContext(Context value) {
            copyOnWrite();
            ((Service) this.instance).setContext(value);
            return this;
        }

        public Builder setContext(Context.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).setContext(builderForValue);
            return this;
        }

        public Builder mergeContext(Context value) {
            copyOnWrite();
            ((Service) this.instance).mergeContext(value);
            return this;
        }

        public Builder clearContext() {
            copyOnWrite();
            ((Service) this.instance).clearContext();
            return this;
        }

        public boolean hasUsage() {
            return ((Service) this.instance).hasUsage();
        }

        public Usage getUsage() {
            return ((Service) this.instance).getUsage();
        }

        public Builder setUsage(Usage value) {
            copyOnWrite();
            ((Service) this.instance).setUsage(value);
            return this;
        }

        public Builder setUsage(Usage.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).setUsage(builderForValue);
            return this;
        }

        public Builder mergeUsage(Usage value) {
            copyOnWrite();
            ((Service) this.instance).mergeUsage(value);
            return this;
        }

        public Builder clearUsage() {
            copyOnWrite();
            ((Service) this.instance).clearUsage();
            return this;
        }

        public List<Endpoint> getEndpointsList() {
            return Collections.unmodifiableList(((Service) this.instance).getEndpointsList());
        }

        public int getEndpointsCount() {
            return ((Service) this.instance).getEndpointsCount();
        }

        public Endpoint getEndpoints(int index) {
            return ((Service) this.instance).getEndpoints(index);
        }

        public Builder setEndpoints(int index, Endpoint value) {
            copyOnWrite();
            ((Service) this.instance).setEndpoints(index, value);
            return this;
        }

        public Builder setEndpoints(int index, Endpoint.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).setEndpoints(index, builderForValue);
            return this;
        }

        public Builder addEndpoints(Endpoint value) {
            copyOnWrite();
            ((Service) this.instance).addEndpoints(value);
            return this;
        }

        public Builder addEndpoints(int index, Endpoint value) {
            copyOnWrite();
            ((Service) this.instance).addEndpoints(index, value);
            return this;
        }

        public Builder addEndpoints(Endpoint.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).addEndpoints(builderForValue);
            return this;
        }

        public Builder addEndpoints(int index, Endpoint.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).addEndpoints(index, builderForValue);
            return this;
        }

        public Builder addAllEndpoints(Iterable<? extends Endpoint> values) {
            copyOnWrite();
            ((Service) this.instance).addAllEndpoints(values);
            return this;
        }

        public Builder clearEndpoints() {
            copyOnWrite();
            ((Service) this.instance).clearEndpoints();
            return this;
        }

        public Builder removeEndpoints(int index) {
            copyOnWrite();
            ((Service) this.instance).removeEndpoints(index);
            return this;
        }

        public boolean hasControl() {
            return ((Service) this.instance).hasControl();
        }

        public Control getControl() {
            return ((Service) this.instance).getControl();
        }

        public Builder setControl(Control value) {
            copyOnWrite();
            ((Service) this.instance).setControl(value);
            return this;
        }

        public Builder setControl(Control.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).setControl(builderForValue);
            return this;
        }

        public Builder mergeControl(Control value) {
            copyOnWrite();
            ((Service) this.instance).mergeControl(value);
            return this;
        }

        public Builder clearControl() {
            copyOnWrite();
            ((Service) this.instance).clearControl();
            return this;
        }

        public List<LogDescriptor> getLogsList() {
            return Collections.unmodifiableList(((Service) this.instance).getLogsList());
        }

        public int getLogsCount() {
            return ((Service) this.instance).getLogsCount();
        }

        public LogDescriptor getLogs(int index) {
            return ((Service) this.instance).getLogs(index);
        }

        public Builder setLogs(int index, LogDescriptor value) {
            copyOnWrite();
            ((Service) this.instance).setLogs(index, value);
            return this;
        }

        public Builder setLogs(int index, LogDescriptor.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).setLogs(index, builderForValue);
            return this;
        }

        public Builder addLogs(LogDescriptor value) {
            copyOnWrite();
            ((Service) this.instance).addLogs(value);
            return this;
        }

        public Builder addLogs(int index, LogDescriptor value) {
            copyOnWrite();
            ((Service) this.instance).addLogs(index, value);
            return this;
        }

        public Builder addLogs(LogDescriptor.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).addLogs(builderForValue);
            return this;
        }

        public Builder addLogs(int index, LogDescriptor.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).addLogs(index, builderForValue);
            return this;
        }

        public Builder addAllLogs(Iterable<? extends LogDescriptor> values) {
            copyOnWrite();
            ((Service) this.instance).addAllLogs(values);
            return this;
        }

        public Builder clearLogs() {
            copyOnWrite();
            ((Service) this.instance).clearLogs();
            return this;
        }

        public Builder removeLogs(int index) {
            copyOnWrite();
            ((Service) this.instance).removeLogs(index);
            return this;
        }

        public List<MetricDescriptor> getMetricsList() {
            return Collections.unmodifiableList(((Service) this.instance).getMetricsList());
        }

        public int getMetricsCount() {
            return ((Service) this.instance).getMetricsCount();
        }

        public MetricDescriptor getMetrics(int index) {
            return ((Service) this.instance).getMetrics(index);
        }

        public Builder setMetrics(int index, MetricDescriptor value) {
            copyOnWrite();
            ((Service) this.instance).setMetrics(index, value);
            return this;
        }

        public Builder setMetrics(int index, MetricDescriptor.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).setMetrics(index, builderForValue);
            return this;
        }

        public Builder addMetrics(MetricDescriptor value) {
            copyOnWrite();
            ((Service) this.instance).addMetrics(value);
            return this;
        }

        public Builder addMetrics(int index, MetricDescriptor value) {
            copyOnWrite();
            ((Service) this.instance).addMetrics(index, value);
            return this;
        }

        public Builder addMetrics(MetricDescriptor.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).addMetrics(builderForValue);
            return this;
        }

        public Builder addMetrics(int index, MetricDescriptor.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).addMetrics(index, builderForValue);
            return this;
        }

        public Builder addAllMetrics(Iterable<? extends MetricDescriptor> values) {
            copyOnWrite();
            ((Service) this.instance).addAllMetrics(values);
            return this;
        }

        public Builder clearMetrics() {
            copyOnWrite();
            ((Service) this.instance).clearMetrics();
            return this;
        }

        public Builder removeMetrics(int index) {
            copyOnWrite();
            ((Service) this.instance).removeMetrics(index);
            return this;
        }

        public List<MonitoredResourceDescriptor> getMonitoredResourcesList() {
            return Collections.unmodifiableList(((Service) this.instance).getMonitoredResourcesList());
        }

        public int getMonitoredResourcesCount() {
            return ((Service) this.instance).getMonitoredResourcesCount();
        }

        public MonitoredResourceDescriptor getMonitoredResources(int index) {
            return ((Service) this.instance).getMonitoredResources(index);
        }

        public Builder setMonitoredResources(int index, MonitoredResourceDescriptor value) {
            copyOnWrite();
            ((Service) this.instance).setMonitoredResources(index, value);
            return this;
        }

        public Builder setMonitoredResources(int index, MonitoredResourceDescriptor.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).setMonitoredResources(index, builderForValue);
            return this;
        }

        public Builder addMonitoredResources(MonitoredResourceDescriptor value) {
            copyOnWrite();
            ((Service) this.instance).addMonitoredResources(value);
            return this;
        }

        public Builder addMonitoredResources(int index, MonitoredResourceDescriptor value) {
            copyOnWrite();
            ((Service) this.instance).addMonitoredResources(index, value);
            return this;
        }

        public Builder addMonitoredResources(MonitoredResourceDescriptor.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).addMonitoredResources(builderForValue);
            return this;
        }

        public Builder addMonitoredResources(int index, MonitoredResourceDescriptor.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).addMonitoredResources(index, builderForValue);
            return this;
        }

        public Builder addAllMonitoredResources(Iterable<? extends MonitoredResourceDescriptor> values) {
            copyOnWrite();
            ((Service) this.instance).addAllMonitoredResources(values);
            return this;
        }

        public Builder clearMonitoredResources() {
            copyOnWrite();
            ((Service) this.instance).clearMonitoredResources();
            return this;
        }

        public Builder removeMonitoredResources(int index) {
            copyOnWrite();
            ((Service) this.instance).removeMonitoredResources(index);
            return this;
        }

        public boolean hasBilling() {
            return ((Service) this.instance).hasBilling();
        }

        public Billing getBilling() {
            return ((Service) this.instance).getBilling();
        }

        public Builder setBilling(Billing value) {
            copyOnWrite();
            ((Service) this.instance).setBilling(value);
            return this;
        }

        public Builder setBilling(Billing.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).setBilling(builderForValue);
            return this;
        }

        public Builder mergeBilling(Billing value) {
            copyOnWrite();
            ((Service) this.instance).mergeBilling(value);
            return this;
        }

        public Builder clearBilling() {
            copyOnWrite();
            ((Service) this.instance).clearBilling();
            return this;
        }

        public boolean hasLogging() {
            return ((Service) this.instance).hasLogging();
        }

        public Logging getLogging() {
            return ((Service) this.instance).getLogging();
        }

        public Builder setLogging(Logging value) {
            copyOnWrite();
            ((Service) this.instance).setLogging(value);
            return this;
        }

        public Builder setLogging(Logging.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).setLogging(builderForValue);
            return this;
        }

        public Builder mergeLogging(Logging value) {
            copyOnWrite();
            ((Service) this.instance).mergeLogging(value);
            return this;
        }

        public Builder clearLogging() {
            copyOnWrite();
            ((Service) this.instance).clearLogging();
            return this;
        }

        public boolean hasMonitoring() {
            return ((Service) this.instance).hasMonitoring();
        }

        public Monitoring getMonitoring() {
            return ((Service) this.instance).getMonitoring();
        }

        public Builder setMonitoring(Monitoring value) {
            copyOnWrite();
            ((Service) this.instance).setMonitoring(value);
            return this;
        }

        public Builder setMonitoring(Monitoring.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).setMonitoring(builderForValue);
            return this;
        }

        public Builder mergeMonitoring(Monitoring value) {
            copyOnWrite();
            ((Service) this.instance).mergeMonitoring(value);
            return this;
        }

        public Builder clearMonitoring() {
            copyOnWrite();
            ((Service) this.instance).clearMonitoring();
            return this;
        }

        public boolean hasSystemParameters() {
            return ((Service) this.instance).hasSystemParameters();
        }

        public SystemParameters getSystemParameters() {
            return ((Service) this.instance).getSystemParameters();
        }

        public Builder setSystemParameters(SystemParameters value) {
            copyOnWrite();
            ((Service) this.instance).setSystemParameters(value);
            return this;
        }

        public Builder setSystemParameters(SystemParameters.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).setSystemParameters(builderForValue);
            return this;
        }

        public Builder mergeSystemParameters(SystemParameters value) {
            copyOnWrite();
            ((Service) this.instance).mergeSystemParameters(value);
            return this;
        }

        public Builder clearSystemParameters() {
            copyOnWrite();
            ((Service) this.instance).clearSystemParameters();
            return this;
        }

        public boolean hasSourceInfo() {
            return ((Service) this.instance).hasSourceInfo();
        }

        public SourceInfo getSourceInfo() {
            return ((Service) this.instance).getSourceInfo();
        }

        public Builder setSourceInfo(SourceInfo value) {
            copyOnWrite();
            ((Service) this.instance).setSourceInfo(value);
            return this;
        }

        public Builder setSourceInfo(SourceInfo.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).setSourceInfo(builderForValue);
            return this;
        }

        public Builder mergeSourceInfo(SourceInfo value) {
            copyOnWrite();
            ((Service) this.instance).mergeSourceInfo(value);
            return this;
        }

        public Builder clearSourceInfo() {
            copyOnWrite();
            ((Service) this.instance).clearSourceInfo();
            return this;
        }

        public boolean hasExperimental() {
            return ((Service) this.instance).hasExperimental();
        }

        public Experimental getExperimental() {
            return ((Service) this.instance).getExperimental();
        }

        public Builder setExperimental(Experimental value) {
            copyOnWrite();
            ((Service) this.instance).setExperimental(value);
            return this;
        }

        public Builder setExperimental(Experimental.Builder builderForValue) {
            copyOnWrite();
            ((Service) this.instance).setExperimental(builderForValue);
            return this;
        }

        public Builder mergeExperimental(Experimental value) {
            copyOnWrite();
            ((Service) this.instance).mergeExperimental(value);
            return this;
        }

        public Builder clearExperimental() {
            copyOnWrite();
            ((Service) this.instance).clearExperimental();
            return this;
        }
    }

    /* renamed from: com.google.api.Service$1  reason: invalid class name */
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
                return new Service();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.apis_.makeImmutable();
                this.types_.makeImmutable();
                this.enums_.makeImmutable();
                this.endpoints_.makeImmutable();
                this.logs_.makeImmutable();
                this.metrics_.makeImmutable();
                this.monitoredResources_.makeImmutable();
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) arg0;
                Service other = (Service) arg1;
                this.configVersion_ = (UInt32Value) visitor.visitMessage(this.configVersion_, other.configVersion_);
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !other.name_.isEmpty(), other.name_);
                this.id_ = visitor.visitString(!this.id_.isEmpty(), this.id_, !other.id_.isEmpty(), other.id_);
                this.title_ = visitor.visitString(!this.title_.isEmpty(), this.title_, !other.title_.isEmpty(), other.title_);
                this.producerProjectId_ = visitor.visitString(!this.producerProjectId_.isEmpty(), this.producerProjectId_, !other.producerProjectId_.isEmpty(), other.producerProjectId_);
                this.apis_ = visitor.visitList(this.apis_, other.apis_);
                this.types_ = visitor.visitList(this.types_, other.types_);
                this.enums_ = visitor.visitList(this.enums_, other.enums_);
                this.documentation_ = (Documentation) visitor.visitMessage(this.documentation_, other.documentation_);
                this.backend_ = (Backend) visitor.visitMessage(this.backend_, other.backend_);
                this.http_ = (Http) visitor.visitMessage(this.http_, other.http_);
                this.quota_ = (Quota) visitor.visitMessage(this.quota_, other.quota_);
                this.authentication_ = (Authentication) visitor.visitMessage(this.authentication_, other.authentication_);
                this.context_ = (Context) visitor.visitMessage(this.context_, other.context_);
                this.usage_ = (Usage) visitor.visitMessage(this.usage_, other.usage_);
                this.endpoints_ = visitor.visitList(this.endpoints_, other.endpoints_);
                this.control_ = (Control) visitor.visitMessage(this.control_, other.control_);
                this.logs_ = visitor.visitList(this.logs_, other.logs_);
                this.metrics_ = visitor.visitList(this.metrics_, other.metrics_);
                this.monitoredResources_ = visitor.visitList(this.monitoredResources_, other.monitoredResources_);
                this.billing_ = (Billing) visitor.visitMessage(this.billing_, other.billing_);
                this.logging_ = (Logging) visitor.visitMessage(this.logging_, other.logging_);
                this.monitoring_ = (Monitoring) visitor.visitMessage(this.monitoring_, other.monitoring_);
                this.systemParameters_ = (SystemParameters) visitor.visitMessage(this.systemParameters_, other.systemParameters_);
                this.sourceInfo_ = (SourceInfo) visitor.visitMessage(this.sourceInfo_, other.sourceInfo_);
                this.experimental_ = (Experimental) visitor.visitMessage(this.experimental_, other.experimental_);
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
                            case 10:
                                this.name_ = input.readStringRequireUtf8();
                                break;
                            case 18:
                                this.title_ = input.readStringRequireUtf8();
                                break;
                            case 26:
                                if (!this.apis_.isModifiable()) {
                                    this.apis_ = GeneratedMessageLite.mutableCopy(this.apis_);
                                }
                                this.apis_.add((Api) input.readMessage(Api.parser(), extensionRegistry));
                                break;
                            case 34:
                                if (!this.types_.isModifiable()) {
                                    this.types_ = GeneratedMessageLite.mutableCopy(this.types_);
                                }
                                this.types_.add((Type) input.readMessage(Type.parser(), extensionRegistry));
                                break;
                            case 42:
                                if (!this.enums_.isModifiable()) {
                                    this.enums_ = GeneratedMessageLite.mutableCopy(this.enums_);
                                }
                                this.enums_.add((Enum) input.readMessage(Enum.parser(), extensionRegistry));
                                break;
                            case 50:
                                Documentation.Builder subBuilder = null;
                                if (this.documentation_ != null) {
                                    subBuilder = (Documentation.Builder) this.documentation_.toBuilder();
                                }
                                Documentation documentation = (Documentation) input.readMessage(Documentation.parser(), extensionRegistry);
                                this.documentation_ = documentation;
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(documentation);
                                    this.documentation_ = (Documentation) subBuilder.buildPartial();
                                    break;
                                }
                            case 66:
                                Backend.Builder subBuilder2 = null;
                                if (this.backend_ != null) {
                                    subBuilder2 = (Backend.Builder) this.backend_.toBuilder();
                                }
                                Backend backend = (Backend) input.readMessage(Backend.parser(), extensionRegistry);
                                this.backend_ = backend;
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(backend);
                                    this.backend_ = (Backend) subBuilder2.buildPartial();
                                    break;
                                }
                            case 74:
                                Http.Builder subBuilder3 = null;
                                if (this.http_ != null) {
                                    subBuilder3 = (Http.Builder) this.http_.toBuilder();
                                }
                                Http http = (Http) input.readMessage(Http.parser(), extensionRegistry);
                                this.http_ = http;
                                if (subBuilder3 == null) {
                                    break;
                                } else {
                                    subBuilder3.mergeFrom(http);
                                    this.http_ = (Http) subBuilder3.buildPartial();
                                    break;
                                }
                            case 82:
                                Quota.Builder subBuilder4 = null;
                                if (this.quota_ != null) {
                                    subBuilder4 = (Quota.Builder) this.quota_.toBuilder();
                                }
                                Quota quota = (Quota) input.readMessage(Quota.parser(), extensionRegistry);
                                this.quota_ = quota;
                                if (subBuilder4 == null) {
                                    break;
                                } else {
                                    subBuilder4.mergeFrom(quota);
                                    this.quota_ = (Quota) subBuilder4.buildPartial();
                                    break;
                                }
                            case 90:
                                Authentication.Builder subBuilder5 = null;
                                if (this.authentication_ != null) {
                                    subBuilder5 = (Authentication.Builder) this.authentication_.toBuilder();
                                }
                                Authentication authentication = (Authentication) input.readMessage(Authentication.parser(), extensionRegistry);
                                this.authentication_ = authentication;
                                if (subBuilder5 == null) {
                                    break;
                                } else {
                                    subBuilder5.mergeFrom(authentication);
                                    this.authentication_ = (Authentication) subBuilder5.buildPartial();
                                    break;
                                }
                            case 98:
                                Context.Builder subBuilder6 = null;
                                if (this.context_ != null) {
                                    subBuilder6 = (Context.Builder) this.context_.toBuilder();
                                }
                                Context context = (Context) input.readMessage(Context.parser(), extensionRegistry);
                                this.context_ = context;
                                if (subBuilder6 == null) {
                                    break;
                                } else {
                                    subBuilder6.mergeFrom(context);
                                    this.context_ = (Context) subBuilder6.buildPartial();
                                    break;
                                }
                            case 122:
                                Usage.Builder subBuilder7 = null;
                                if (this.usage_ != null) {
                                    subBuilder7 = (Usage.Builder) this.usage_.toBuilder();
                                }
                                Usage usage = (Usage) input.readMessage(Usage.parser(), extensionRegistry);
                                this.usage_ = usage;
                                if (subBuilder7 == null) {
                                    break;
                                } else {
                                    subBuilder7.mergeFrom(usage);
                                    this.usage_ = (Usage) subBuilder7.buildPartial();
                                    break;
                                }
                            case 146:
                                if (!this.endpoints_.isModifiable()) {
                                    this.endpoints_ = GeneratedMessageLite.mutableCopy(this.endpoints_);
                                }
                                this.endpoints_.add((Endpoint) input.readMessage(Endpoint.parser(), extensionRegistry));
                                break;
                            case 162:
                                UInt32Value.Builder subBuilder8 = null;
                                if (this.configVersion_ != null) {
                                    subBuilder8 = (UInt32Value.Builder) this.configVersion_.toBuilder();
                                }
                                UInt32Value uInt32Value = (UInt32Value) input.readMessage(UInt32Value.parser(), extensionRegistry);
                                this.configVersion_ = uInt32Value;
                                if (subBuilder8 == null) {
                                    break;
                                } else {
                                    subBuilder8.mergeFrom(uInt32Value);
                                    this.configVersion_ = (UInt32Value) subBuilder8.buildPartial();
                                    break;
                                }
                            case 170:
                                Control.Builder subBuilder9 = null;
                                if (this.control_ != null) {
                                    subBuilder9 = (Control.Builder) this.control_.toBuilder();
                                }
                                Control control = (Control) input.readMessage(Control.parser(), extensionRegistry);
                                this.control_ = control;
                                if (subBuilder9 == null) {
                                    break;
                                } else {
                                    subBuilder9.mergeFrom(control);
                                    this.control_ = (Control) subBuilder9.buildPartial();
                                    break;
                                }
                            case 178:
                                this.producerProjectId_ = input.readStringRequireUtf8();
                                break;
                            case 186:
                                if (!this.logs_.isModifiable()) {
                                    this.logs_ = GeneratedMessageLite.mutableCopy(this.logs_);
                                }
                                this.logs_.add((LogDescriptor) input.readMessage(LogDescriptor.parser(), extensionRegistry));
                                break;
                            case 194:
                                if (!this.metrics_.isModifiable()) {
                                    this.metrics_ = GeneratedMessageLite.mutableCopy(this.metrics_);
                                }
                                this.metrics_.add((MetricDescriptor) input.readMessage(MetricDescriptor.parser(), extensionRegistry));
                                break;
                            case 202:
                                if (!this.monitoredResources_.isModifiable()) {
                                    this.monitoredResources_ = GeneratedMessageLite.mutableCopy(this.monitoredResources_);
                                }
                                this.monitoredResources_.add((MonitoredResourceDescriptor) input.readMessage(MonitoredResourceDescriptor.parser(), extensionRegistry));
                                break;
                            case 210:
                                Billing.Builder subBuilder10 = null;
                                if (this.billing_ != null) {
                                    subBuilder10 = (Billing.Builder) this.billing_.toBuilder();
                                }
                                Billing billing = (Billing) input.readMessage(Billing.parser(), extensionRegistry);
                                this.billing_ = billing;
                                if (subBuilder10 == null) {
                                    break;
                                } else {
                                    subBuilder10.mergeFrom(billing);
                                    this.billing_ = (Billing) subBuilder10.buildPartial();
                                    break;
                                }
                            case 218:
                                Logging.Builder subBuilder11 = null;
                                if (this.logging_ != null) {
                                    subBuilder11 = (Logging.Builder) this.logging_.toBuilder();
                                }
                                Logging logging = (Logging) input.readMessage(Logging.parser(), extensionRegistry);
                                this.logging_ = logging;
                                if (subBuilder11 == null) {
                                    break;
                                } else {
                                    subBuilder11.mergeFrom(logging);
                                    this.logging_ = (Logging) subBuilder11.buildPartial();
                                    break;
                                }
                            case 226:
                                Monitoring.Builder subBuilder12 = null;
                                if (this.monitoring_ != null) {
                                    subBuilder12 = (Monitoring.Builder) this.monitoring_.toBuilder();
                                }
                                Monitoring monitoring = (Monitoring) input.readMessage(Monitoring.parser(), extensionRegistry);
                                this.monitoring_ = monitoring;
                                if (subBuilder12 == null) {
                                    break;
                                } else {
                                    subBuilder12.mergeFrom(monitoring);
                                    this.monitoring_ = (Monitoring) subBuilder12.buildPartial();
                                    break;
                                }
                            case 234:
                                SystemParameters.Builder subBuilder13 = null;
                                if (this.systemParameters_ != null) {
                                    subBuilder13 = (SystemParameters.Builder) this.systemParameters_.toBuilder();
                                }
                                SystemParameters systemParameters = (SystemParameters) input.readMessage(SystemParameters.parser(), extensionRegistry);
                                this.systemParameters_ = systemParameters;
                                if (subBuilder13 == null) {
                                    break;
                                } else {
                                    subBuilder13.mergeFrom(systemParameters);
                                    this.systemParameters_ = (SystemParameters) subBuilder13.buildPartial();
                                    break;
                                }
                            case 266:
                                this.id_ = input.readStringRequireUtf8();
                                break;
                            case 298:
                                SourceInfo.Builder subBuilder14 = null;
                                if (this.sourceInfo_ != null) {
                                    subBuilder14 = (SourceInfo.Builder) this.sourceInfo_.toBuilder();
                                }
                                SourceInfo sourceInfo = (SourceInfo) input.readMessage(SourceInfo.parser(), extensionRegistry);
                                this.sourceInfo_ = sourceInfo;
                                if (subBuilder14 == null) {
                                    break;
                                } else {
                                    subBuilder14.mergeFrom(sourceInfo);
                                    this.sourceInfo_ = (SourceInfo) subBuilder14.buildPartial();
                                    break;
                                }
                            case 810:
                                Experimental.Builder subBuilder15 = null;
                                if (this.experimental_ != null) {
                                    subBuilder15 = (Experimental.Builder) this.experimental_.toBuilder();
                                }
                                Experimental experimental = (Experimental) input.readMessage(Experimental.parser(), extensionRegistry);
                                this.experimental_ = experimental;
                                if (subBuilder15 == null) {
                                    break;
                                } else {
                                    subBuilder15.mergeFrom(experimental);
                                    this.experimental_ = (Experimental) subBuilder15.buildPartial();
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
                    synchronized (Service.class) {
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
        Service service = new Service();
        DEFAULT_INSTANCE = service;
        service.makeImmutable();
    }

    public static Service getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Service> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
