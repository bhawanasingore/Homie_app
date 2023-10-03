package io.flutter.embedding.engine;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlutterShellArgs {
    public static final String ARG_CACHE_SKSL = "--cache-sksl";
    public static final String ARG_DART_FLAGS = "--dart-flags";
    public static final String ARG_DISABLE_SERVICE_AUTH_CODES = "--disable-service-auth-codes";
    public static final String ARG_DUMP_SHADER_SKP_ON_SHADER_COMPILATION = "--dump-skp-on-shader-compilation";
    public static final String ARG_ENABLE_DART_PROFILING = "--enable-dart-profiling";
    public static final String ARG_ENABLE_SOFTWARE_RENDERING = "--enable-software-rendering";
    public static final String ARG_ENDLESS_TRACE_BUFFER = "--endless-trace-buffer";
    public static final String ARG_KEY_CACHE_SKSL = "cache-sksl";
    public static final String ARG_KEY_DART_FLAGS = "dart-flags";
    public static final String ARG_KEY_DISABLE_SERVICE_AUTH_CODES = "disable-service-auth-codes";
    public static final String ARG_KEY_DUMP_SHADER_SKP_ON_SHADER_COMPILATION = "dump-skp-on-shader-compilation";
    public static final String ARG_KEY_ENABLE_DART_PROFILING = "enable-dart-profiling";
    public static final String ARG_KEY_ENABLE_SOFTWARE_RENDERING = "enable-software-rendering";
    public static final String ARG_KEY_ENDLESS_TRACE_BUFFER = "endless-trace-buffer";
    public static final String ARG_KEY_OBSERVATORY_PORT = "observatory-port";
    public static final String ARG_KEY_PURGE_PERSISTENT_CACHE = "purge-persistent-cache";
    public static final String ARG_KEY_SKIA_DETERMINISTIC_RENDERING = "skia-deterministic-rendering";
    public static final String ARG_KEY_START_PAUSED = "start-paused";
    public static final String ARG_KEY_TRACE_SKIA = "trace-skia";
    public static final String ARG_KEY_TRACE_STARTUP = "trace-startup";
    public static final String ARG_KEY_TRACE_SYSTRACE = "trace-systrace";
    public static final String ARG_KEY_USE_TEST_FONTS = "use-test-fonts";
    public static final String ARG_KEY_VERBOSE_LOGGING = "verbose-logging";
    public static final String ARG_OBSERVATORY_PORT = "--observatory-port=";
    public static final String ARG_PURGE_PERSISTENT_CACHE = "--purge-persistent-cache";
    public static final String ARG_SKIA_DETERMINISTIC_RENDERING = "--skia-deterministic-rendering";
    public static final String ARG_START_PAUSED = "--start-paused";
    public static final String ARG_TRACE_SKIA = "--trace-skia";
    public static final String ARG_TRACE_STARTUP = "--trace-startup";
    public static final String ARG_TRACE_SYSTRACE = "--trace-systrace";
    public static final String ARG_USE_TEST_FONTS = "--use-test-fonts";
    public static final String ARG_VERBOSE_LOGGING = "--verbose-logging";
    private Set<String> args;

    public static FlutterShellArgs fromIntent(Intent intent) {
        ArrayList<String> args2 = new ArrayList<>();
        if (intent.getBooleanExtra(ARG_KEY_TRACE_STARTUP, false)) {
            args2.add(ARG_TRACE_STARTUP);
        }
        if (intent.getBooleanExtra(ARG_KEY_START_PAUSED, false)) {
            args2.add(ARG_START_PAUSED);
        }
        int observatoryPort = intent.getIntExtra(ARG_KEY_OBSERVATORY_PORT, 0);
        if (observatoryPort > 0) {
            args2.add(ARG_OBSERVATORY_PORT + Integer.toString(observatoryPort));
        }
        if (intent.getBooleanExtra(ARG_KEY_DISABLE_SERVICE_AUTH_CODES, false)) {
            args2.add(ARG_DISABLE_SERVICE_AUTH_CODES);
        }
        if (intent.getBooleanExtra(ARG_KEY_ENDLESS_TRACE_BUFFER, false)) {
            args2.add(ARG_ENDLESS_TRACE_BUFFER);
        }
        if (intent.getBooleanExtra(ARG_KEY_USE_TEST_FONTS, false)) {
            args2.add(ARG_USE_TEST_FONTS);
        }
        if (intent.getBooleanExtra(ARG_KEY_ENABLE_DART_PROFILING, false)) {
            args2.add(ARG_ENABLE_DART_PROFILING);
        }
        if (intent.getBooleanExtra(ARG_KEY_ENABLE_SOFTWARE_RENDERING, false)) {
            args2.add(ARG_ENABLE_SOFTWARE_RENDERING);
        }
        if (intent.getBooleanExtra(ARG_KEY_SKIA_DETERMINISTIC_RENDERING, false)) {
            args2.add(ARG_SKIA_DETERMINISTIC_RENDERING);
        }
        if (intent.getBooleanExtra(ARG_KEY_TRACE_SKIA, false)) {
            args2.add(ARG_TRACE_SKIA);
        }
        if (intent.getBooleanExtra(ARG_KEY_TRACE_SYSTRACE, false)) {
            args2.add(ARG_TRACE_SYSTRACE);
        }
        if (intent.getBooleanExtra(ARG_KEY_DUMP_SHADER_SKP_ON_SHADER_COMPILATION, false)) {
            args2.add(ARG_DUMP_SHADER_SKP_ON_SHADER_COMPILATION);
        }
        if (intent.getBooleanExtra(ARG_KEY_CACHE_SKSL, false)) {
            args2.add(ARG_CACHE_SKSL);
        }
        if (intent.getBooleanExtra(ARG_KEY_PURGE_PERSISTENT_CACHE, false)) {
            args2.add(ARG_PURGE_PERSISTENT_CACHE);
        }
        if (intent.getBooleanExtra(ARG_KEY_VERBOSE_LOGGING, false)) {
            args2.add(ARG_VERBOSE_LOGGING);
        }
        if (intent.hasExtra(ARG_KEY_DART_FLAGS)) {
            args2.add("--dart-flags=" + intent.getStringExtra(ARG_KEY_DART_FLAGS));
        }
        return new FlutterShellArgs((List<String>) args2);
    }

    public FlutterShellArgs(String[] args2) {
        this.args = new HashSet(Arrays.asList(args2));
    }

    public FlutterShellArgs(List<String> args2) {
        this.args = new HashSet(args2);
    }

    public FlutterShellArgs(Set<String> args2) {
        this.args = new HashSet(args2);
    }

    public void add(String arg) {
        this.args.add(arg);
    }

    public void remove(String arg) {
        this.args.remove(arg);
    }

    public String[] toArray() {
        return (String[]) this.args.toArray(new String[this.args.size()]);
    }
}
