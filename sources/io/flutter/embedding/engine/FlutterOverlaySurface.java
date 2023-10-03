package io.flutter.embedding.engine;

import android.view.Surface;

public class FlutterOverlaySurface {
    private final int id;
    private final Surface surface;

    public FlutterOverlaySurface(int id2, Surface surface2) {
        this.id = id2;
        this.surface = surface2;
    }

    public int getId() {
        return this.id;
    }

    public Surface getSurface() {
        return this.surface;
    }
}
