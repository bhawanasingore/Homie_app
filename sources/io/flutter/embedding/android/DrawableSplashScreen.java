package io.flutter.embedding.android;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import io.flutter.embedding.android.SplashScreen;

public final class DrawableSplashScreen implements SplashScreen {
    private final long crossfadeDurationInMillis;
    private final Drawable drawable;
    private final ImageView.ScaleType scaleType;
    private DrawableSplashScreenView splashView;

    public /* synthetic */ boolean doesSplashViewRememberItsTransition() {
        return SplashScreen.CC.$default$doesSplashViewRememberItsTransition(this);
    }

    public /* synthetic */ Bundle saveSplashScreenState() {
        return SplashScreen.CC.$default$saveSplashScreenState(this);
    }

    public DrawableSplashScreen(Drawable drawable2) {
        this(drawable2, ImageView.ScaleType.FIT_XY, 500);
    }

    public DrawableSplashScreen(Drawable drawable2, ImageView.ScaleType scaleType2, long crossfadeDurationInMillis2) {
        this.drawable = drawable2;
        this.scaleType = scaleType2;
        this.crossfadeDurationInMillis = crossfadeDurationInMillis2;
    }

    public View createSplashView(Context context, Bundle savedInstanceState) {
        DrawableSplashScreenView drawableSplashScreenView = new DrawableSplashScreenView(context);
        this.splashView = drawableSplashScreenView;
        drawableSplashScreenView.setSplashDrawable(this.drawable, this.scaleType);
        return this.splashView;
    }

    public void transitionToFlutter(final Runnable onTransitionComplete) {
        DrawableSplashScreenView drawableSplashScreenView = this.splashView;
        if (drawableSplashScreenView == null) {
            onTransitionComplete.run();
        } else {
            drawableSplashScreenView.animate().alpha(0.0f).setDuration(this.crossfadeDurationInMillis).setListener(new Animator.AnimatorListener() {
                public void onAnimationStart(Animator animation) {
                }

                public void onAnimationEnd(Animator animation) {
                    onTransitionComplete.run();
                }

                public void onAnimationCancel(Animator animation) {
                    onTransitionComplete.run();
                }

                public void onAnimationRepeat(Animator animation) {
                }
            });
        }
    }

    public static class DrawableSplashScreenView extends ImageView {
        public DrawableSplashScreenView(Context context) {
            this(context, (AttributeSet) null, 0);
        }

        public DrawableSplashScreenView(Context context, AttributeSet attrs) {
            this(context, attrs, 0);
        }

        public DrawableSplashScreenView(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }

        public void setSplashDrawable(Drawable drawable) {
            setSplashDrawable(drawable, ImageView.ScaleType.FIT_XY);
        }

        public void setSplashDrawable(Drawable drawable, ImageView.ScaleType scaleType) {
            setScaleType(scaleType);
            setImageDrawable(drawable);
        }
    }
}
