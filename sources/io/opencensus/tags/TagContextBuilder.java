package io.opencensus.tags;

import io.opencensus.common.Scope;
import io.opencensus.tags.TagMetadata;

public abstract class TagContextBuilder {
    private static final TagMetadata METADATA_NO_PROPAGATION = TagMetadata.create(TagMetadata.TagTtl.NO_PROPAGATION);
    private static final TagMetadata METADATA_UNLIMITED_PROPAGATION = TagMetadata.create(TagMetadata.TagTtl.UNLIMITED_PROPAGATION);

    public abstract TagContext build();

    public abstract Scope buildScoped();

    @Deprecated
    public abstract TagContextBuilder put(TagKey tagKey, TagValue tagValue);

    public abstract TagContextBuilder remove(TagKey tagKey);

    public TagContextBuilder put(TagKey key, TagValue value, TagMetadata tagMetadata) {
        return put(key, value);
    }

    public final TagContextBuilder putLocal(TagKey key, TagValue value) {
        return put(key, value, METADATA_NO_PROPAGATION);
    }

    public final TagContextBuilder putPropagating(TagKey key, TagValue value) {
        return put(key, value, METADATA_UNLIMITED_PROPAGATION);
    }
}
