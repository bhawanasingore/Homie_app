package io.flutter.plugin.platform;

import android.content.Context;
import io.flutter.plugin.common.MessageCodec;

public abstract class PlatformViewFactory {
    private final MessageCodec<Object> createArgsCodec;

    public abstract PlatformView create(Context context, int i, Object obj);

    public PlatformViewFactory(MessageCodec<Object> createArgsCodec2) {
        this.createArgsCodec = createArgsCodec2;
    }

    public final MessageCodec<Object> getCreateArgsCodec() {
        return this.createArgsCodec;
    }
}
