package com.noeatsleepdev.geoflutterfire;

import android.os.Build;
import androidx.core.app.NotificationCompat;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/noeatsleepdev/geoflutterfire/GeoflutterfirePlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "onMethodCall", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "geoflutterfire_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GeoflutterfirePlugin.kt */
public final class GeoflutterfirePlugin implements MethodChannel.MethodCallHandler {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final void registerWith(@NotNull PluginRegistry.Registrar registrar) {
        Companion.registerWith(registrar);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/noeatsleepdev/geoflutterfire/GeoflutterfirePlugin$Companion;", "", "()V", "registerWith", "", "registrar", "Lio/flutter/plugin/common/PluginRegistry$Registrar;", "geoflutterfire_debug"}, k = 1, mv = {1, 1, 15})
    /* compiled from: GeoflutterfirePlugin.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        @JvmStatic
        public final void registerWith(@NotNull PluginRegistry.Registrar registrar) {
            Intrinsics.checkParameterIsNotNull(registrar, "registrar");
            new MethodChannel(registrar.messenger(), "geoflutterfire").setMethodCallHandler(new GeoflutterfirePlugin());
        }
    }

    public void onMethodCall(@NotNull MethodCall call, @NotNull MethodChannel.Result result) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(result, "result");
        if (Intrinsics.areEqual((Object) call.method, (Object) "getPlatformVersion")) {
            result.success("Android " + Build.VERSION.RELEASE);
            return;
        }
        result.notImplemented();
    }
}
