package io.opencensus.tags;

import java.util.HashMap;
import java.util.Iterator;
import javax.annotation.Nullable;

public abstract class TagContext {
    /* access modifiers changed from: protected */
    public abstract Iterator<Tag> getIterator();

    public String toString() {
        return "TagContext";
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof TagContext)) {
            return false;
        }
        Iterator<Tag> iter1 = getIterator();
        Iterator<Tag> iter2 = ((TagContext) other).getIterator();
        HashMap<Tag, Integer> tags = new HashMap<>();
        while (iter1 != null && iter1.hasNext()) {
            Tag tag = iter1.next();
            if (tags.containsKey(tag)) {
                tags.put(tag, Integer.valueOf(tags.get(tag).intValue() + 1));
            } else {
                tags.put(tag, 1);
            }
        }
        while (iter2 != null && iter2.hasNext()) {
            Tag tag2 = iter2.next();
            if (!tags.containsKey(tag2)) {
                return false;
            }
            int count = tags.get(tag2).intValue();
            if (count > 1) {
                tags.put(tag2, Integer.valueOf(count - 1));
            } else {
                tags.remove(tag2);
            }
        }
        return tags.isEmpty();
    }

    public final int hashCode() {
        int hashCode = 0;
        Iterator<Tag> i = getIterator();
        if (i == null) {
            return 0;
        }
        while (i.hasNext()) {
            Tag tag = i.next();
            if (tag != null) {
                hashCode += tag.hashCode();
            }
        }
        return hashCode;
    }
}
