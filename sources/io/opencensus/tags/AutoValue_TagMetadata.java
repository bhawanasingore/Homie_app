package io.opencensus.tags;

import io.opencensus.tags.TagMetadata;

final class AutoValue_TagMetadata extends TagMetadata {
    private final TagMetadata.TagTtl tagTtl;

    AutoValue_TagMetadata(TagMetadata.TagTtl tagTtl2) {
        if (tagTtl2 != null) {
            this.tagTtl = tagTtl2;
            return;
        }
        throw new NullPointerException("Null tagTtl");
    }

    public TagMetadata.TagTtl getTagTtl() {
        return this.tagTtl;
    }

    public String toString() {
        return "TagMetadata{tagTtl=" + this.tagTtl + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof TagMetadata) {
            return this.tagTtl.equals(((TagMetadata) o).getTagTtl());
        }
        return false;
    }

    public int hashCode() {
        return (1 * 1000003) ^ this.tagTtl.hashCode();
    }
}
