package io.opencensus.tags;

import io.opencensus.tags.TagMetadata;

public abstract class Tag {
    private static final TagMetadata METADATA_UNLIMITED_PROPAGATION = TagMetadata.create(TagMetadata.TagTtl.UNLIMITED_PROPAGATION);

    public abstract TagKey getKey();

    public abstract TagMetadata getTagMetadata();

    public abstract TagValue getValue();

    Tag() {
    }

    @Deprecated
    public static Tag create(TagKey key, TagValue value) {
        return create(key, value, METADATA_UNLIMITED_PROPAGATION);
    }

    public static Tag create(TagKey key, TagValue value, TagMetadata tagMetadata) {
        return new AutoValue_Tag(key, value, tagMetadata);
    }
}
