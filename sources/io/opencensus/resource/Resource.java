package io.opencensus.resource;

import io.opencensus.internal.StringUtils;
import io.opencensus.internal.Utils;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

public abstract class Resource {
    private static final Map<String, String> ENV_LABEL_MAP = parseResourceLabels(System.getenv(OC_RESOURCE_LABELS_ENV));
    @Nullable
    private static final String ENV_TYPE = parseResourceType(System.getenv(OC_RESOURCE_TYPE_ENV));
    private static final String ERROR_MESSAGE_INVALID_CHARS = " should be a ASCII string with a length greater than 0 and not exceed 255 characters.";
    private static final String ERROR_MESSAGE_INVALID_VALUE = " should be a ASCII string with a length not exceed 255 characters.";
    private static final String LABEL_KEY_VALUE_SPLITTER = "=";
    private static final String LABEL_LIST_SPLITTER = ",";
    static final int MAX_LENGTH = 255;
    private static final String OC_RESOURCE_LABELS_ENV = "OC_RESOURCE_LABELS";
    private static final String OC_RESOURCE_TYPE_ENV = "OC_RESOURCE_TYPE";

    public abstract Map<String, String> getLabels();

    @Nullable
    public abstract String getType();

    Resource() {
    }

    public static Resource createFromEnvironmentVariables() {
        return createInternal(ENV_TYPE, ENV_LABEL_MAP);
    }

    public static Resource create(@Nullable String type, Map<String, String> labels) {
        return createInternal(type, Collections.unmodifiableMap(new LinkedHashMap((Map) Utils.checkNotNull(labels, "labels"))));
    }

    @Nullable
    public static Resource mergeResources(List<Resource> resources) {
        Resource currentResource = null;
        for (Resource resource : resources) {
            currentResource = merge(currentResource, resource);
        }
        return currentResource;
    }

    private static Resource createInternal(@Nullable String type, Map<String, String> labels) {
        return new AutoValue_Resource(type, labels);
    }

    @Nullable
    static String parseResourceType(@Nullable String rawEnvType) {
        if (rawEnvType == null || rawEnvType.isEmpty()) {
            return rawEnvType;
        }
        Utils.checkArgument(isValidAndNotEmpty(rawEnvType), "Type should be a ASCII string with a length greater than 0 and not exceed 255 characters.");
        return rawEnvType.trim();
    }

    static Map<String, String> parseResourceLabels(@Nullable String rawEnvLabels) {
        if (rawEnvLabels == null) {
            return Collections.emptyMap();
        }
        Map<String, String> labels = new HashMap<>();
        for (String rawLabel : rawEnvLabels.split(LABEL_LIST_SPLITTER, -1)) {
            String[] keyValuePair = rawLabel.split(LABEL_KEY_VALUE_SPLITTER, -1);
            if (keyValuePair.length == 2) {
                String key = keyValuePair[0].trim();
                String value = keyValuePair[1].trim().replaceAll("^\"|\"$", "");
                Utils.checkArgument(isValidAndNotEmpty(key), "Label key should be a ASCII string with a length greater than 0 and not exceed 255 characters.");
                Utils.checkArgument(isValid(value), "Label value should be a ASCII string with a length not exceed 255 characters.");
                labels.put(key, value);
            }
        }
        return Collections.unmodifiableMap(labels);
    }

    @Nullable
    private static Resource merge(@Nullable Resource resource, @Nullable Resource otherResource) {
        if (otherResource == null) {
            return resource;
        }
        if (resource == null) {
            return otherResource;
        }
        String mergedType = resource.getType() != null ? resource.getType() : otherResource.getType();
        Map<String, String> mergedLabelMap = new LinkedHashMap<>(otherResource.getLabels());
        for (Map.Entry<String, String> entry : resource.getLabels().entrySet()) {
            mergedLabelMap.put(entry.getKey(), entry.getValue());
        }
        return createInternal(mergedType, Collections.unmodifiableMap(mergedLabelMap));
    }

    private static boolean isValid(String name) {
        return name.length() <= 255 && StringUtils.isPrintableString(name);
    }

    private static boolean isValidAndNotEmpty(String name) {
        return !name.isEmpty() && isValid(name);
    }
}
