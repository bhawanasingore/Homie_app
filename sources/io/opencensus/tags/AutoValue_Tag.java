package io.opencensus.tags;

final class AutoValue_Tag extends Tag {
    private final TagKey key;
    private final TagMetadata tagMetadata;
    private final TagValue value;

    AutoValue_Tag(TagKey key2, TagValue value2, TagMetadata tagMetadata2) {
        if (key2 != null) {
            this.key = key2;
            if (value2 != null) {
                this.value = value2;
                if (tagMetadata2 != null) {
                    this.tagMetadata = tagMetadata2;
                    return;
                }
                throw new NullPointerException("Null tagMetadata");
            }
            throw new NullPointerException("Null value");
        }
        throw new NullPointerException("Null key");
    }

    public TagKey getKey() {
        return this.key;
    }

    public TagValue getValue() {
        return this.value;
    }

    public TagMetadata getTagMetadata() {
        return this.tagMetadata;
    }

    public String toString() {
        return "Tag{key=" + this.key + ", value=" + this.value + ", tagMetadata=" + this.tagMetadata + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Tag)) {
            return false;
        }
        Tag that = (Tag) o;
        if (!this.key.equals(that.getKey()) || !this.value.equals(that.getValue()) || !this.tagMetadata.equals(that.getTagMetadata())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((1 * 1000003) ^ this.key.hashCode()) * 1000003) ^ this.value.hashCode()) * 1000003) ^ this.tagMetadata.hashCode();
    }
}
