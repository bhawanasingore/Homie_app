package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.LongMath;
import io.grpc.internal.RetriableStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class ServiceConfigUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long DURATION_SECONDS_MAX = 315576000000L;
    private static final long DURATION_SECONDS_MIN = -315576000000L;
    private static final String HEDGING_POLICY_HEDGING_DELAY_KEY = "hedgingDelay";
    private static final String HEDGING_POLICY_MAX_ATTEMPTS_KEY = "maxAttempts";
    private static final String HEDGING_POLICY_NON_FATAL_STATUS_CODES_KEY = "nonFatalStatusCodes";
    private static final String METHOD_CONFIG_HEDGING_POLICY_KEY = "hedgingPolicy";
    private static final String METHOD_CONFIG_MAX_REQUEST_MESSAGE_BYTES_KEY = "maxRequestMessageBytes";
    private static final String METHOD_CONFIG_MAX_RESPONSE_MESSAGE_BYTES_KEY = "maxResponseMessageBytes";
    private static final String METHOD_CONFIG_NAME_KEY = "name";
    private static final String METHOD_CONFIG_RETRY_POLICY_KEY = "retryPolicy";
    private static final String METHOD_CONFIG_TIMEOUT_KEY = "timeout";
    private static final String METHOD_CONFIG_WAIT_FOR_READY_KEY = "waitForReady";
    private static final String NAME_METHOD_KEY = "method";
    private static final String NAME_SERVICE_KEY = "service";
    private static final long NANOS_PER_SECOND = TimeUnit.SECONDS.toNanos(1);
    private static final String RETRY_POLICY_BACKOFF_MULTIPLIER_KEY = "backoffMultiplier";
    private static final String RETRY_POLICY_INITIAL_BACKOFF_KEY = "initialBackoff";
    private static final String RETRY_POLICY_MAX_ATTEMPTS_KEY = "maxAttempts";
    private static final String RETRY_POLICY_MAX_BACKOFF_KEY = "maxBackoff";
    private static final String RETRY_POLICY_RETRYABLE_STATUS_CODES_KEY = "retryableStatusCodes";
    private static final String SERVICE_CONFIG_LOAD_BALANCING_CONFIG_KEY = "loadBalancingConfig";
    private static final String SERVICE_CONFIG_LOAD_BALANCING_POLICY_KEY = "loadBalancingPolicy";
    private static final String SERVICE_CONFIG_METHOD_CONFIG_KEY = "methodConfig";
    private static final String SERVICE_CONFIG_STICKINESS_METADATA_KEY = "stickinessMetadataKey";
    private static final String XDS_CONFIG_BALANCER_NAME_KEY = "balancerName";
    private static final String XDS_CONFIG_CHILD_POLICY_KEY = "childPolicy";
    private static final String XDS_CONFIG_FALLBACK_POLICY_KEY = "fallbackPolicy";

    private ServiceConfigUtil() {
    }

    @Nullable
    public static String getHealthCheckedServiceName(@Nullable Map<String, ?> serviceConfig) {
        if (serviceConfig == null || !serviceConfig.containsKey("healthCheckConfig")) {
            return null;
        }
        Map<String, ?> healthCheck = getObject(serviceConfig, "healthCheckConfig");
        if (!healthCheck.containsKey("serviceName")) {
            return null;
        }
        return getString(healthCheck, "serviceName");
    }

    @Nullable
    static RetriableStream.Throttle getThrottlePolicy(@Nullable Map<String, ?> serviceConfig) {
        if (serviceConfig == null || !serviceConfig.containsKey("retryThrottling")) {
            return null;
        }
        Map<String, ?> throttling = getObject(serviceConfig, "retryThrottling");
        float maxTokens = getDouble(throttling, "maxTokens").floatValue();
        float tokenRatio = getDouble(throttling, "tokenRatio").floatValue();
        boolean z = true;
        Preconditions.checkState(maxTokens > 0.0f, "maxToken should be greater than zero");
        if (tokenRatio <= 0.0f) {
            z = false;
        }
        Preconditions.checkState(z, "tokenRatio should be greater than zero");
        return new RetriableStream.Throttle(maxTokens, tokenRatio);
    }

    @Nullable
    static Integer getMaxAttemptsFromRetryPolicy(Map<String, ?> retryPolicy) {
        if (!retryPolicy.containsKey("maxAttempts")) {
            return null;
        }
        return Integer.valueOf(getDouble(retryPolicy, "maxAttempts").intValue());
    }

    @Nullable
    static Long getInitialBackoffNanosFromRetryPolicy(Map<String, ?> retryPolicy) {
        if (!retryPolicy.containsKey(RETRY_POLICY_INITIAL_BACKOFF_KEY)) {
            return null;
        }
        try {
            return Long.valueOf(parseDuration(getString(retryPolicy, RETRY_POLICY_INITIAL_BACKOFF_KEY)));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Nullable
    static Long getMaxBackoffNanosFromRetryPolicy(Map<String, ?> retryPolicy) {
        if (!retryPolicy.containsKey(RETRY_POLICY_MAX_BACKOFF_KEY)) {
            return null;
        }
        try {
            return Long.valueOf(parseDuration(getString(retryPolicy, RETRY_POLICY_MAX_BACKOFF_KEY)));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Nullable
    static Double getBackoffMultiplierFromRetryPolicy(Map<String, ?> retryPolicy) {
        if (!retryPolicy.containsKey(RETRY_POLICY_BACKOFF_MULTIPLIER_KEY)) {
            return null;
        }
        return getDouble(retryPolicy, RETRY_POLICY_BACKOFF_MULTIPLIER_KEY);
    }

    @Nullable
    static List<String> getRetryableStatusCodesFromRetryPolicy(Map<String, ?> retryPolicy) {
        if (!retryPolicy.containsKey(RETRY_POLICY_RETRYABLE_STATUS_CODES_KEY)) {
            return null;
        }
        return checkStringList(getList(retryPolicy, RETRY_POLICY_RETRYABLE_STATUS_CODES_KEY));
    }

    @Nullable
    static Integer getMaxAttemptsFromHedgingPolicy(Map<String, ?> hedgingPolicy) {
        if (!hedgingPolicy.containsKey("maxAttempts")) {
            return null;
        }
        return Integer.valueOf(getDouble(hedgingPolicy, "maxAttempts").intValue());
    }

    @Nullable
    static Long getHedgingDelayNanosFromHedgingPolicy(Map<String, ?> hedgingPolicy) {
        if (!hedgingPolicy.containsKey(HEDGING_POLICY_HEDGING_DELAY_KEY)) {
            return null;
        }
        try {
            return Long.valueOf(parseDuration(getString(hedgingPolicy, HEDGING_POLICY_HEDGING_DELAY_KEY)));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Nullable
    static List<String> getNonFatalStatusCodesFromHedgingPolicy(Map<String, ?> hedgingPolicy) {
        if (!hedgingPolicy.containsKey(HEDGING_POLICY_NON_FATAL_STATUS_CODES_KEY)) {
            return null;
        }
        return checkStringList(getList(hedgingPolicy, HEDGING_POLICY_NON_FATAL_STATUS_CODES_KEY));
    }

    @Nullable
    static String getServiceFromName(Map<String, ?> name) {
        if (!name.containsKey("service")) {
            return null;
        }
        return getString(name, "service");
    }

    @Nullable
    static String getMethodFromName(Map<String, ?> name) {
        if (!name.containsKey("method")) {
            return null;
        }
        return getString(name, "method");
    }

    @Nullable
    static Map<String, ?> getRetryPolicyFromMethodConfig(Map<String, ?> methodConfig) {
        if (!methodConfig.containsKey(METHOD_CONFIG_RETRY_POLICY_KEY)) {
            return null;
        }
        return getObject(methodConfig, METHOD_CONFIG_RETRY_POLICY_KEY);
    }

    @Nullable
    static Map<String, ?> getHedgingPolicyFromMethodConfig(Map<String, ?> methodConfig) {
        if (!methodConfig.containsKey(METHOD_CONFIG_HEDGING_POLICY_KEY)) {
            return null;
        }
        return getObject(methodConfig, METHOD_CONFIG_HEDGING_POLICY_KEY);
    }

    @Nullable
    static List<Map<String, ?>> getNameListFromMethodConfig(Map<String, ?> methodConfig) {
        if (!methodConfig.containsKey("name")) {
            return null;
        }
        return checkObjectList(getList(methodConfig, "name"));
    }

    @Nullable
    static Long getTimeoutFromMethodConfig(Map<String, ?> methodConfig) {
        if (!methodConfig.containsKey("timeout")) {
            return null;
        }
        try {
            return Long.valueOf(parseDuration(getString(methodConfig, "timeout")));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Nullable
    static Boolean getWaitForReadyFromMethodConfig(Map<String, ?> methodConfig) {
        if (!methodConfig.containsKey(METHOD_CONFIG_WAIT_FOR_READY_KEY)) {
            return null;
        }
        return getBoolean(methodConfig, METHOD_CONFIG_WAIT_FOR_READY_KEY);
    }

    @Nullable
    static Integer getMaxRequestMessageBytesFromMethodConfig(Map<String, ?> methodConfig) {
        if (!methodConfig.containsKey(METHOD_CONFIG_MAX_REQUEST_MESSAGE_BYTES_KEY)) {
            return null;
        }
        return Integer.valueOf(getDouble(methodConfig, METHOD_CONFIG_MAX_REQUEST_MESSAGE_BYTES_KEY).intValue());
    }

    @Nullable
    static Integer getMaxResponseMessageBytesFromMethodConfig(Map<String, ?> methodConfig) {
        if (!methodConfig.containsKey(METHOD_CONFIG_MAX_RESPONSE_MESSAGE_BYTES_KEY)) {
            return null;
        }
        return Integer.valueOf(getDouble(methodConfig, METHOD_CONFIG_MAX_RESPONSE_MESSAGE_BYTES_KEY).intValue());
    }

    @Nullable
    static List<Map<String, ?>> getMethodConfigFromServiceConfig(Map<String, ?> serviceConfig) {
        if (!serviceConfig.containsKey(SERVICE_CONFIG_METHOD_CONFIG_KEY)) {
            return null;
        }
        return checkObjectList(getList(serviceConfig, SERVICE_CONFIG_METHOD_CONFIG_KEY));
    }

    public static List<Map<String, ?>> getLoadBalancingConfigsFromServiceConfig(Map<String, ?> serviceConfig) {
        List<Map<String, ?>> lbConfigs = new ArrayList<>();
        if (serviceConfig.containsKey(SERVICE_CONFIG_LOAD_BALANCING_CONFIG_KEY)) {
            for (Map<String, ?> config : checkObjectList(getList(serviceConfig, SERVICE_CONFIG_LOAD_BALANCING_CONFIG_KEY))) {
                lbConfigs.add(config);
            }
        }
        if (lbConfigs.isEmpty() && serviceConfig.containsKey(SERVICE_CONFIG_LOAD_BALANCING_POLICY_KEY)) {
            lbConfigs.add(Collections.singletonMap(getString(serviceConfig, SERVICE_CONFIG_LOAD_BALANCING_POLICY_KEY).toLowerCase(Locale.ROOT), Collections.emptyMap()));
        }
        return Collections.unmodifiableList(lbConfigs);
    }

    public static LbConfig unwrapLoadBalancingConfig(Map<String, ?> lbConfig) {
        if (lbConfig.size() == 1) {
            String key = (String) lbConfig.entrySet().iterator().next().getKey();
            return new LbConfig(key, getObject(lbConfig, key));
        }
        throw new RuntimeException("There are " + lbConfig.size() + " fields in a LoadBalancingConfig object. Exactly one is expected. Config=" + lbConfig);
    }

    public static List<LbConfig> unwrapLoadBalancingConfigList(List<Map<String, ?>> list) {
        ArrayList<LbConfig> result = new ArrayList<>();
        for (Map<String, ?> rawChildPolicy : list) {
            result.add(unwrapLoadBalancingConfig(rawChildPolicy));
        }
        return Collections.unmodifiableList(result);
    }

    public static String getBalancerNameFromXdsConfig(LbConfig xdsConfig) {
        return getString(xdsConfig.getRawConfigValue(), XDS_CONFIG_BALANCER_NAME_KEY);
    }

    @Nullable
    public static List<LbConfig> getChildPolicyFromXdsConfig(LbConfig xdsConfig) {
        List<?> rawChildPolicies = getList(xdsConfig.getRawConfigValue(), XDS_CONFIG_CHILD_POLICY_KEY);
        if (rawChildPolicies != null) {
            return unwrapLoadBalancingConfigList(checkObjectList(rawChildPolicies));
        }
        return null;
    }

    @Nullable
    public static List<LbConfig> getFallbackPolicyFromXdsConfig(LbConfig xdsConfig) {
        List<?> rawFallbackPolicies = getList(xdsConfig.getRawConfigValue(), XDS_CONFIG_FALLBACK_POLICY_KEY);
        if (rawFallbackPolicies != null) {
            return unwrapLoadBalancingConfigList(checkObjectList(rawFallbackPolicies));
        }
        return null;
    }

    @Nullable
    public static String getStickinessMetadataKeyFromServiceConfig(Map<String, ?> serviceConfig) {
        if (!serviceConfig.containsKey(SERVICE_CONFIG_STICKINESS_METADATA_KEY)) {
            return null;
        }
        return getString(serviceConfig, SERVICE_CONFIG_STICKINESS_METADATA_KEY);
    }

    @Nullable
    static List<?> getList(Map<String, ?> obj, String key) {
        if (!obj.containsKey(key)) {
            return null;
        }
        Object obj2 = obj.get(key);
        if (obj2 instanceof List) {
            return (List) obj2;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not List", new Object[]{obj2, key, obj}));
    }

    @Nullable
    static Map<String, ?> getObject(Map<String, ?> obj, String key) {
        if (!obj.containsKey(key)) {
            return null;
        }
        Object obj2 = obj.get(key);
        if (obj2 instanceof Map) {
            return (Map) obj2;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not object", new Object[]{obj2, key, obj}));
    }

    @Nullable
    static Double getDouble(Map<String, ?> obj, String key) {
        if (!obj.containsKey(key)) {
            return null;
        }
        Object obj2 = obj.get(key);
        if (obj2 instanceof Double) {
            return (Double) obj2;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not Double", new Object[]{obj2, key, obj}));
    }

    @Nullable
    static String getString(Map<String, ?> obj, String key) {
        if (!obj.containsKey(key)) {
            return null;
        }
        Object obj2 = obj.get(key);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not String", new Object[]{obj2, key, obj}));
    }

    @Nullable
    static Boolean getBoolean(Map<String, ?> obj, String key) {
        if (!obj.containsKey(key)) {
            return null;
        }
        Object obj2 = obj.get(key);
        if (obj2 instanceof Boolean) {
            return (Boolean) obj2;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not Boolean", new Object[]{obj2, key, obj}));
    }

    static List<Map<String, ?>> checkObjectList(List<?> rawList) {
        int i = 0;
        while (i < rawList.size()) {
            if (rawList.get(i) instanceof Map) {
                i++;
            } else {
                throw new ClassCastException(String.format("value %s for idx %d in %s is not object", new Object[]{rawList.get(i), Integer.valueOf(i), rawList}));
            }
        }
        return rawList;
    }

    static List<String> checkStringList(List<?> rawList) {
        int i = 0;
        while (i < rawList.size()) {
            if (rawList.get(i) instanceof String) {
                i++;
            } else {
                throw new ClassCastException(String.format("value '%s' for idx %d in '%s' is not string", new Object[]{rawList.get(i), Integer.valueOf(i), rawList}));
            }
        }
        return rawList;
    }

    private static long parseDuration(String value) throws ParseException {
        if (value.isEmpty() || value.charAt(value.length() - 1) != 's') {
            throw new ParseException("Invalid duration string: " + value, 0);
        }
        boolean negative = false;
        if (value.charAt(0) == '-') {
            negative = true;
            value = value.substring(1);
        }
        String secondValue = value.substring(0, value.length() - 1);
        String nanoValue = "";
        int pointPosition = secondValue.indexOf(46);
        if (pointPosition != -1) {
            nanoValue = secondValue.substring(pointPosition + 1);
            secondValue = secondValue.substring(0, pointPosition);
        }
        long seconds = Long.parseLong(secondValue);
        int nanos = nanoValue.isEmpty() ? 0 : parseNanos(nanoValue);
        if (seconds >= 0) {
            if (negative) {
                seconds = -seconds;
                nanos = -nanos;
            }
            try {
                return normalizedDuration(seconds, nanos);
            } catch (IllegalArgumentException e) {
                throw new ParseException("Duration value is out of range.", 0);
            }
        } else {
            throw new ParseException("Invalid duration string: " + value, 0);
        }
    }

    private static int parseNanos(String value) throws ParseException {
        int result = 0;
        for (int i = 0; i < 9; i++) {
            result *= 10;
            if (i < value.length()) {
                if (value.charAt(i) < '0' || value.charAt(i) > '9') {
                    throw new ParseException("Invalid nanoseconds.", 0);
                }
                result += value.charAt(i) - '0';
            }
        }
        return result;
    }

    private static long normalizedDuration(long seconds, int nanos) {
        long j = NANOS_PER_SECOND;
        if (((long) nanos) <= (-j) || ((long) nanos) >= j) {
            seconds = LongMath.checkedAdd(seconds, ((long) nanos) / NANOS_PER_SECOND);
            nanos = (int) (((long) nanos) % NANOS_PER_SECOND);
        }
        if (seconds > 0 && nanos < 0) {
            nanos = (int) (((long) nanos) + NANOS_PER_SECOND);
            seconds--;
        }
        if (seconds < 0 && nanos > 0) {
            nanos = (int) (((long) nanos) - NANOS_PER_SECOND);
            seconds++;
        }
        if (durationIsValid(seconds, nanos)) {
            return saturatedAdd(TimeUnit.SECONDS.toNanos(seconds), (long) nanos);
        }
        throw new IllegalArgumentException(String.format("Duration is not valid. See proto definition for valid values. Seconds (%s) must be in range [-315,576,000,000, +315,576,000,000]. Nanos (%s) must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds", new Object[]{Long.valueOf(seconds), Integer.valueOf(nanos)}));
    }

    private static boolean durationIsValid(long seconds, int nanos) {
        if (seconds < DURATION_SECONDS_MIN || seconds > DURATION_SECONDS_MAX || ((long) nanos) < -999999999 || ((long) nanos) >= NANOS_PER_SECOND) {
            return false;
        }
        if (seconds >= 0 && nanos >= 0) {
            return true;
        }
        if (seconds > 0 || nanos > 0) {
            return false;
        }
        return true;
    }

    private static long saturatedAdd(long a, long b) {
        long naiveSum = a + b;
        boolean z = true;
        boolean z2 = (a ^ b) < 0;
        if ((a ^ naiveSum) < 0) {
            z = false;
        }
        if (z2 || z) {
            return naiveSum;
        }
        return ((naiveSum >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    public static final class LbConfig {
        private final String policyName;
        private final Map<String, ?> rawConfigValue;

        public LbConfig(String policyName2, Map<String, ?> rawConfigValue2) {
            this.policyName = (String) Preconditions.checkNotNull(policyName2, "policyName");
            this.rawConfigValue = (Map) Preconditions.checkNotNull(rawConfigValue2, "rawConfigValue");
        }

        public String getPolicyName() {
            return this.policyName;
        }

        public Map<String, ?> getRawConfigValue() {
            return this.rawConfigValue;
        }

        public boolean equals(Object o) {
            if (!(o instanceof LbConfig)) {
                return false;
            }
            LbConfig other = (LbConfig) o;
            if (!this.policyName.equals(other.policyName) || !this.rawConfigValue.equals(other.rawConfigValue)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hashCode(this.policyName, this.rawConfigValue);
        }

        public String toString() {
            return MoreObjects.toStringHelper((Object) this).add("policyName", (Object) this.policyName).add("rawConfigValue", (Object) this.rawConfigValue).toString();
        }
    }
}
