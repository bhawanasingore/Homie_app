package com.google.common.escape;

import com.google.common.base.Function;

public abstract class Escaper {
    private final Function<String, String> asFunction = new Function<String, String>() {
        public String apply(String from) {
            return Escaper.this.escape(from);
        }
    };

    public abstract String escape(String str);

    protected Escaper() {
    }

    public final Function<String, String> asFunction() {
        return this.asFunction;
    }
}
