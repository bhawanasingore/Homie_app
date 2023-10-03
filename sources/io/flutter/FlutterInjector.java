package io.flutter;

import io.flutter.embedding.engine.loader.FlutterLoader;
import java.io.PrintStream;

public final class FlutterInjector {
    private static boolean accessed;
    private static FlutterInjector instance;
    private FlutterLoader flutterLoader;
    private boolean shouldLoadNative;

    public static void setInstance(FlutterInjector injector) {
        if (!accessed) {
            instance = injector;
            return;
        }
        throw new IllegalStateException("Cannot change the FlutterInjector instance once it's been read. If you're trying to dependency inject, be sure to do so at the beginning of the program");
    }

    public static FlutterInjector instance() {
        accessed = true;
        if (instance == null) {
            instance = new Builder().build();
        }
        return instance;
    }

    public static void reset() {
        accessed = false;
        instance = null;
    }

    private FlutterInjector(boolean shouldLoadNative2, FlutterLoader flutterLoader2) {
        this.shouldLoadNative = shouldLoadNative2;
        this.flutterLoader = flutterLoader2;
    }

    public boolean shouldLoadNative() {
        return this.shouldLoadNative;
    }

    public FlutterLoader flutterLoader() {
        return this.flutterLoader;
    }

    public static final class Builder {
        private FlutterLoader flutterLoader;
        private boolean shouldLoadNative = true;

        public Builder setShouldLoadNative(boolean shouldLoadNative2) {
            this.shouldLoadNative = shouldLoadNative2;
            return this;
        }

        public Builder setFlutterLoader(FlutterLoader flutterLoader2) {
            this.flutterLoader = flutterLoader2;
            return this;
        }

        private void fillDefaults() {
            if (this.flutterLoader == null) {
                this.flutterLoader = new FlutterLoader();
            }
        }

        public FlutterInjector build() {
            fillDefaults();
            PrintStream printStream = System.out;
            printStream.println("should load native is " + this.shouldLoadNative);
            return new FlutterInjector(this.shouldLoadNative, this.flutterLoader);
        }
    }
}
