package io.flutter.plugin.editing;

import android.graphics.Insets;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import java.util.List;

class ImeSyncDeferringInsetsCallback extends WindowInsetsAnimation.Callback implements View.OnApplyWindowInsetsListener {
    private boolean animating = false;
    private int deferredInsetTypes;
    private WindowInsets lastWindowInsets;
    private boolean needsSave = false;
    private int overlayInsetTypes;
    private View view;

    ImeSyncDeferringInsetsCallback(View view2, int overlayInsetTypes2, int deferredInsetTypes2) {
        super(1);
        this.overlayInsetTypes = overlayInsetTypes2;
        this.deferredInsetTypes = deferredInsetTypes2;
        this.view = view2;
    }

    /* access modifiers changed from: package-private */
    public void install() {
        this.view.setWindowInsetsAnimationCallback(this);
        this.view.setOnApplyWindowInsetsListener(this);
    }

    /* access modifiers changed from: package-private */
    public void remove() {
        this.view.setWindowInsetsAnimationCallback((WindowInsetsAnimation.Callback) null);
        this.view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) null);
    }

    public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
        this.view = view2;
        if (this.needsSave) {
            this.lastWindowInsets = windowInsets;
            this.needsSave = false;
        }
        if (this.animating) {
            return WindowInsets.CONSUMED;
        }
        return view2.onApplyWindowInsets(windowInsets);
    }

    public void onPrepare(WindowInsetsAnimation animation) {
        if ((animation.getTypeMask() & this.deferredInsetTypes) != 0) {
            this.animating = true;
            this.needsSave = true;
        }
    }

    public WindowInsets onProgress(WindowInsets insets, List<WindowInsetsAnimation> runningAnimations) {
        if (!this.animating || this.needsSave) {
            return insets;
        }
        boolean matching = false;
        for (WindowInsetsAnimation animation : runningAnimations) {
            if ((animation.getTypeMask() & this.deferredInsetTypes) != 0) {
                matching = true;
            }
        }
        if (!matching) {
            return insets;
        }
        WindowInsets.Builder builder = new WindowInsets.Builder(this.lastWindowInsets);
        builder.setInsets(this.deferredInsetTypes, Insets.of(0, 0, 0, Math.max(insets.getInsets(this.deferredInsetTypes).bottom - insets.getInsets(this.overlayInsetTypes).bottom, 0)));
        this.view.onApplyWindowInsets(builder.build());
        return insets;
    }

    public void onEnd(WindowInsetsAnimation animation) {
        View view2;
        if (this.animating && (animation.getTypeMask() & this.deferredInsetTypes) != 0) {
            this.animating = false;
            WindowInsets windowInsets = this.lastWindowInsets;
            if (windowInsets != null && (view2 = this.view) != null) {
                view2.dispatchApplyWindowInsets(windowInsets);
            }
        }
    }
}
