package io.flutter.embedding.engine.mutatorsstack;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import io.flutter.embedding.android.AndroidTouchProcessor;

public class FlutterMutatorView extends FrameLayout {
    private final AndroidTouchProcessor androidTouchProcessor;
    private int left;
    private FlutterMutatorsStack mutatorsStack;
    private int prevLeft;
    private int prevTop;
    private float screenDensity;
    private int top;

    public FlutterMutatorView(Context context, float screenDensity2, AndroidTouchProcessor androidTouchProcessor2) {
        super(context, (AttributeSet) null);
        this.screenDensity = screenDensity2;
        this.androidTouchProcessor = androidTouchProcessor2;
    }

    public FlutterMutatorView(Context context) {
        super(context, (AttributeSet) null);
        this.screenDensity = 1.0f;
        this.androidTouchProcessor = null;
    }

    public void readyToDisplay(FlutterMutatorsStack mutatorsStack2, int left2, int top2, int width, int height) {
        this.mutatorsStack = mutatorsStack2;
        this.left = left2;
        this.top = top2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.leftMargin = left2;
        layoutParams.topMargin = top2;
        setLayoutParams(layoutParams);
        setWillNotDraw(false);
    }

    public void draw(Canvas canvas) {
        canvas.save();
        for (Path path : this.mutatorsStack.getFinalClippingPaths()) {
            Path pathCopy = new Path(path);
            pathCopy.offset((float) (-this.left), (float) (-this.top));
            canvas.clipPath(pathCopy);
        }
        super.draw(canvas);
        canvas.restore();
    }

    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.concat(getPlatformViewMatrix());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    private Matrix getPlatformViewMatrix() {
        Matrix finalMatrix = new Matrix(this.mutatorsStack.getFinalMatrix());
        float f = this.screenDensity;
        finalMatrix.preScale(1.0f / f, 1.0f / f);
        finalMatrix.postTranslate((float) (-this.left), (float) (-this.top));
        return finalMatrix;
    }

    public boolean onInterceptTouchEvent(MotionEvent event) {
        return true;
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.androidTouchProcessor == null) {
            return super.onTouchEvent(event);
        }
        Matrix screenMatrix = new Matrix();
        int action = event.getAction();
        if (action == 0) {
            int i = this.left;
            this.prevLeft = i;
            int i2 = this.top;
            this.prevTop = i2;
            screenMatrix.postTranslate((float) i, (float) i2);
        } else if (action != 2) {
            screenMatrix.postTranslate((float) this.left, (float) this.top);
        } else {
            screenMatrix.postTranslate((float) this.prevLeft, (float) this.prevTop);
            this.prevLeft = this.left;
            this.prevTop = this.top;
        }
        return this.androidTouchProcessor.onTouchEvent(event, screenMatrix);
    }
}
