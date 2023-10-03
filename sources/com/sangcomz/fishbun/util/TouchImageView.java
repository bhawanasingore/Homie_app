package com.sangcomz.fishbun.util;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import android.widget.Scroller;
import androidx.appcompat.widget.AppCompatImageView;

public class TouchImageView extends AppCompatImageView {
    private static final String DEBUG = "DEBUG";
    private static final float SUPER_MAX_MULTIPLIER = 1.25f;
    private static final float SUPER_MIN_MULTIPLIER = 0.75f;
    /* access modifiers changed from: private */
    public Context context;
    private ZoomVariables delayedZoomVariables;
    /* access modifiers changed from: private */
    public GestureDetector.OnDoubleTapListener doubleTapListener = null;
    /* access modifiers changed from: private */
    public Fling fling;
    private boolean imageRenderedAtLeastOnce;
    /* access modifiers changed from: private */
    public float[] m;
    /* access modifiers changed from: private */
    public GestureDetector mGestureDetector;
    /* access modifiers changed from: private */
    public ScaleGestureDetector mScaleDetector;
    private ImageView.ScaleType mScaleType;
    private float matchViewHeight;
    private float matchViewWidth;
    /* access modifiers changed from: private */
    public Matrix matrix;
    /* access modifiers changed from: private */
    public float maxScale;
    /* access modifiers changed from: private */
    public float minScale;
    /* access modifiers changed from: private */
    public float normalizedScale;
    private boolean onDrawReady;
    private float prevMatchViewHeight;
    private float prevMatchViewWidth;
    private Matrix prevMatrix;
    private int prevViewHeight;
    private int prevViewWidth;
    /* access modifiers changed from: private */
    public State state;
    private float superMaxScale;
    private float superMinScale;
    /* access modifiers changed from: private */
    public OnTouchImageViewListener touchImageViewListener = null;
    /* access modifiers changed from: private */
    public View.OnTouchListener userTouchListener = null;
    /* access modifiers changed from: private */
    public int viewHeight;
    /* access modifiers changed from: private */
    public int viewWidth;

    public interface OnTouchImageViewListener {
        void onMove();
    }

    private enum State {
        NONE,
        DRAG,
        ZOOM,
        FLING,
        ANIMATE_ZOOM
    }

    public TouchImageView(Context context2) {
        super(context2);
        sharedConstructing(context2);
    }

    public TouchImageView(Context context2, AttributeSet attrs) {
        super(context2, attrs);
        sharedConstructing(context2);
    }

    public TouchImageView(Context context2, AttributeSet attrs, int defStyle) {
        super(context2, attrs, defStyle);
        sharedConstructing(context2);
    }

    private void sharedConstructing(Context context2) {
        super.setClickable(true);
        this.context = context2;
        this.mScaleDetector = new ScaleGestureDetector(context2, new ScaleListener(this, (AnonymousClass1) null));
        this.mGestureDetector = new GestureDetector(context2, new GestureListener(this, (AnonymousClass1) null));
        this.matrix = new Matrix();
        this.prevMatrix = new Matrix();
        this.m = new float[9];
        this.normalizedScale = 1.0f;
        if (this.mScaleType == null) {
            this.mScaleType = ImageView.ScaleType.FIT_CENTER;
        }
        this.minScale = 1.0f;
        this.maxScale = 8.0f;
        this.superMinScale = 1.0f * SUPER_MIN_MULTIPLIER;
        this.superMaxScale = 8.0f * SUPER_MAX_MULTIPLIER;
        setImageMatrix(this.matrix);
        setScaleType(ImageView.ScaleType.MATRIX);
        setState(State.NONE);
        this.onDrawReady = false;
        super.setOnTouchListener(new PrivateOnTouchListener(this, (AnonymousClass1) null));
    }

    public void setOnTouchListener(View.OnTouchListener l) {
        this.userTouchListener = l;
    }

    public void setOnTouchImageViewListener(OnTouchImageViewListener l) {
        this.touchImageViewListener = l;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener l) {
        this.doubleTapListener = l;
    }

    public void setImageResource(int resId) {
        super.setImageResource(resId);
        savePreviousImageValues();
        fitImageToView();
    }

    public void setImageBitmap(Bitmap bm) {
        super.setImageBitmap(bm);
        savePreviousImageValues();
        fitImageToView();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        savePreviousImageValues();
        fitImageToView();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        savePreviousImageValues();
        fitImageToView();
    }

    public void setScaleType(ImageView.ScaleType type) {
        if (type == ImageView.ScaleType.FIT_START || type == ImageView.ScaleType.FIT_END) {
            throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
        } else if (type == ImageView.ScaleType.MATRIX) {
            super.setScaleType(ImageView.ScaleType.MATRIX);
        } else {
            this.mScaleType = type;
            if (this.onDrawReady) {
                setZoom(this);
            }
        }
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public boolean isZoomed() {
        return this.normalizedScale != 1.0f;
    }

    public RectF getZoomedRect() {
        if (this.mScaleType != ImageView.ScaleType.FIT_XY) {
            PointF topLeft = transformCoordTouchToBitmap(0.0f, 0.0f, true);
            PointF bottomRight = transformCoordTouchToBitmap((float) this.viewWidth, (float) this.viewHeight, true);
            float w = (float) getDrawable().getIntrinsicWidth();
            float h = (float) getDrawable().getIntrinsicHeight();
            return new RectF(topLeft.x / w, topLeft.y / h, bottomRight.x / w, bottomRight.y / h);
        }
        throw new UnsupportedOperationException("getZoomedRect() not supported with FIT_XY");
    }

    private void savePreviousImageValues() {
        Matrix matrix2 = this.matrix;
        if (matrix2 != null && this.viewHeight != 0 && this.viewWidth != 0) {
            matrix2.getValues(this.m);
            this.prevMatrix.setValues(this.m);
            this.prevMatchViewHeight = this.matchViewHeight;
            this.prevMatchViewWidth = this.matchViewWidth;
            this.prevViewHeight = this.viewHeight;
            this.prevViewWidth = this.viewWidth;
        }
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putFloat("saveScale", this.normalizedScale);
        bundle.putFloat("matchViewHeight", this.matchViewHeight);
        bundle.putFloat("matchViewWidth", this.matchViewWidth);
        bundle.putInt("viewWidth", this.viewWidth);
        bundle.putInt("viewHeight", this.viewHeight);
        this.matrix.getValues(this.m);
        bundle.putFloatArray("matrix", this.m);
        bundle.putBoolean("imageRendered", this.imageRenderedAtLeastOnce);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable state2) {
        if (state2 instanceof Bundle) {
            Bundle bundle = (Bundle) state2;
            this.normalizedScale = bundle.getFloat("saveScale");
            float[] floatArray = bundle.getFloatArray("matrix");
            this.m = floatArray;
            this.prevMatrix.setValues(floatArray);
            this.prevMatchViewHeight = bundle.getFloat("matchViewHeight");
            this.prevMatchViewWidth = bundle.getFloat("matchViewWidth");
            this.prevViewHeight = bundle.getInt("viewHeight");
            this.prevViewWidth = bundle.getInt("viewWidth");
            this.imageRenderedAtLeastOnce = bundle.getBoolean("imageRendered");
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            return;
        }
        super.onRestoreInstanceState(state2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (getDrawable() != null) {
            this.onDrawReady = true;
            this.imageRenderedAtLeastOnce = true;
            ZoomVariables zoomVariables = this.delayedZoomVariables;
            if (zoomVariables != null) {
                setZoom(zoomVariables.scale, this.delayedZoomVariables.focusX, this.delayedZoomVariables.focusY, this.delayedZoomVariables.scaleType);
                this.delayedZoomVariables = null;
            }
        }
        super.onDraw(canvas);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        savePreviousImageValues();
    }

    public float getMaxZoom() {
        return this.maxScale;
    }

    public void setMaxZoom(float max) {
        this.maxScale = max;
        this.superMaxScale = SUPER_MAX_MULTIPLIER * max;
    }

    public float getMinZoom() {
        return this.minScale;
    }

    public float getCurrentZoom() {
        return this.normalizedScale;
    }

    public void setMinZoom(float min) {
        this.minScale = min;
        this.superMinScale = SUPER_MIN_MULTIPLIER * min;
    }

    public void resetZoom() {
        this.normalizedScale = 1.0f;
        fitImageToView();
    }

    public void setZoom(float scale) {
        setZoom(scale, 0.5f, 0.5f);
    }

    public void setZoom(float scale, float focusX, float focusY) {
        setZoom(scale, focusX, focusY, this.mScaleType);
    }

    public void setZoom(float scale, float focusX, float focusY, ImageView.ScaleType scaleType) {
        if (!this.onDrawReady) {
            this.delayedZoomVariables = new ZoomVariables(scale, focusX, focusY, scaleType);
            return;
        }
        if (scaleType != this.mScaleType) {
            setScaleType(scaleType);
        }
        resetZoom();
        scaleImage((double) scale, (float) (this.viewWidth / 2), (float) (this.viewHeight / 2), true);
        this.matrix.getValues(this.m);
        this.m[2] = -((getImageWidth() * focusX) - (((float) this.viewWidth) * 0.5f));
        this.m[5] = -((getImageHeight() * focusY) - (((float) this.viewHeight) * 0.5f));
        this.matrix.setValues(this.m);
        fixTrans();
        setImageMatrix(this.matrix);
    }

    public void setZoom(TouchImageView touchImageView) {
        PointF center = touchImageView.getScrollPosition();
        setZoom(touchImageView.getCurrentZoom(), center.x, center.y, touchImageView.getScaleType());
    }

    public PointF getScrollPosition() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return null;
        }
        int drawableWidth = drawable.getIntrinsicWidth();
        int drawableHeight = drawable.getIntrinsicHeight();
        PointF point = transformCoordTouchToBitmap((float) (this.viewWidth / 2), (float) (this.viewHeight / 2), true);
        point.x /= (float) drawableWidth;
        point.y /= (float) drawableHeight;
        return point;
    }

    public void setScrollPosition(float focusX, float focusY) {
        setZoom(this.normalizedScale, focusX, focusY);
    }

    /* access modifiers changed from: private */
    public void fixTrans() {
        this.matrix.getValues(this.m);
        float[] fArr = this.m;
        float transX = fArr[2];
        float transY = fArr[5];
        float fixTransX = getFixTrans(transX, (float) this.viewWidth, getImageWidth());
        float fixTransY = getFixTrans(transY, (float) this.viewHeight, getImageHeight());
        if (fixTransX != 0.0f || fixTransY != 0.0f) {
            this.matrix.postTranslate(fixTransX, fixTransY);
        }
    }

    /* access modifiers changed from: private */
    public void fixScaleTrans() {
        fixTrans();
        this.matrix.getValues(this.m);
        float imageWidth = getImageWidth();
        int i = this.viewWidth;
        if (imageWidth < ((float) i)) {
            this.m[2] = (((float) i) - getImageWidth()) / 2.0f;
        }
        float imageHeight = getImageHeight();
        int i2 = this.viewHeight;
        if (imageHeight < ((float) i2)) {
            this.m[5] = (((float) i2) - getImageHeight()) / 2.0f;
        }
        this.matrix.setValues(this.m);
    }

    private float getFixTrans(float trans, float viewSize, float contentSize) {
        float maxTrans;
        float minTrans;
        if (contentSize <= viewSize) {
            minTrans = 0.0f;
            maxTrans = viewSize - contentSize;
        } else {
            minTrans = viewSize - contentSize;
            maxTrans = 0.0f;
        }
        if (trans < minTrans) {
            return (-trans) + minTrans;
        }
        if (trans > maxTrans) {
            return (-trans) + maxTrans;
        }
        return 0.0f;
    }

    /* access modifiers changed from: private */
    public float getFixDragTrans(float delta, float viewSize, float contentSize) {
        if (contentSize <= viewSize) {
            return 0.0f;
        }
        return delta;
    }

    /* access modifiers changed from: private */
    public float getImageWidth() {
        return this.matchViewWidth * this.normalizedScale;
    }

    /* access modifiers changed from: private */
    public float getImageHeight() {
        return this.matchViewHeight * this.normalizedScale;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Drawable drawable = getDrawable();
        if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int drawableWidth = drawable.getIntrinsicWidth();
        int drawableHeight = drawable.getIntrinsicHeight();
        int widthSize = View.MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = View.MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        this.viewWidth = setViewSize(widthMode, widthSize, drawableWidth);
        int viewSize = setViewSize(heightMode, heightSize, drawableHeight);
        this.viewHeight = viewSize;
        setMeasuredDimension(this.viewWidth, viewSize);
        fitImageToView();
    }

    private void fitImageToView() {
        float scaleY;
        float scaleX;
        Drawable drawable = getDrawable();
        if (drawable != null && drawable.getIntrinsicWidth() != 0 && drawable.getIntrinsicHeight() != 0 && this.matrix != null && this.prevMatrix != null) {
            int drawableWidth = drawable.getIntrinsicWidth();
            int drawableHeight = drawable.getIntrinsicHeight();
            float scaleX2 = ((float) this.viewWidth) / ((float) drawableWidth);
            float scaleY2 = ((float) this.viewHeight) / ((float) drawableHeight);
            int i = AnonymousClass1.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()];
            if (i == 1) {
                scaleX = 1.0f;
                scaleY = 1.0f;
            } else if (i != 2) {
                if (i == 3) {
                    float min = Math.min(1.0f, Math.min(scaleX2, scaleY2));
                    scaleY2 = min;
                    scaleX2 = min;
                } else if (i != 4) {
                    if (i == 5) {
                        scaleX = scaleX2;
                        scaleY = scaleY2;
                    } else {
                        throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
                    }
                }
                float scaleX3 = Math.min(scaleX2, scaleY2);
                scaleX = scaleX3;
                scaleY = scaleX3;
            } else {
                float scaleX4 = Math.max(scaleX2, scaleY2);
                scaleX = scaleX4;
                scaleY = scaleX4;
            }
            int i2 = this.viewWidth;
            float redundantXSpace = ((float) i2) - (((float) drawableWidth) * scaleX);
            int i3 = this.viewHeight;
            float redundantYSpace = ((float) i3) - (((float) drawableHeight) * scaleY);
            this.matchViewWidth = ((float) i2) - redundantXSpace;
            this.matchViewHeight = ((float) i3) - redundantYSpace;
            if (isZoomed() || this.imageRenderedAtLeastOnce) {
                if (this.prevMatchViewWidth == 0.0f || this.prevMatchViewHeight == 0.0f) {
                    savePreviousImageValues();
                }
                this.prevMatrix.getValues(this.m);
                float[] fArr = this.m;
                float f = this.matchViewWidth / ((float) drawableWidth);
                float f2 = this.normalizedScale;
                fArr[0] = f * f2;
                fArr[4] = (this.matchViewHeight / ((float) drawableHeight)) * f2;
                float transX = fArr[2];
                float transY = fArr[5];
                translateMatrixAfterRotate(2, transX, this.prevMatchViewWidth * f2, getImageWidth(), this.prevViewWidth, this.viewWidth, drawableWidth);
                translateMatrixAfterRotate(5, transY, this.prevMatchViewHeight * this.normalizedScale, getImageHeight(), this.prevViewHeight, this.viewHeight, drawableHeight);
                this.matrix.setValues(this.m);
            } else {
                this.matrix.setScale(scaleX, scaleY);
                this.matrix.postTranslate(redundantXSpace / 2.0f, redundantYSpace / 2.0f);
                this.normalizedScale = 1.0f;
            }
            fixTrans();
            setImageMatrix(this.matrix);
        }
    }

    /* renamed from: com.sangcomz.fishbun.util.TouchImageView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_XY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private int setViewSize(int mode, int size, int drawableWidth) {
        if (mode == Integer.MIN_VALUE) {
            return Math.min(drawableWidth, size);
        }
        if (mode == 0) {
            return drawableWidth;
        }
        if (mode != 1073741824) {
            return size;
        }
        return size;
    }

    private void translateMatrixAfterRotate(int axis, float trans, float prevImageSize, float imageSize, int prevViewSize, int viewSize, int drawableSize) {
        if (imageSize < ((float) viewSize)) {
            float[] fArr = this.m;
            fArr[axis] = (((float) viewSize) - (((float) drawableSize) * fArr[0])) * 0.5f;
        } else if (trans > 0.0f) {
            this.m[axis] = -((imageSize - ((float) viewSize)) * 0.5f);
        } else {
            this.m[axis] = -((((Math.abs(trans) + (((float) prevViewSize) * 0.5f)) / prevImageSize) * imageSize) - (((float) viewSize) * 0.5f));
        }
    }

    /* access modifiers changed from: private */
    public void setState(State state2) {
        this.state = state2;
    }

    public boolean canScrollHorizontallyFroyo(int direction) {
        return canScrollHorizontally(direction);
    }

    public boolean canScrollHorizontally(int direction) {
        this.matrix.getValues(this.m);
        float x = this.m[2];
        if (getImageWidth() <= ((float) this.viewWidth)) {
            return false;
        }
        if (x >= -1.0f && direction < 0) {
            return false;
        }
        if (Math.abs(x) + ((float) this.viewWidth) + 1.0f < getImageWidth() || direction <= 0) {
            return true;
        }
        return false;
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private GestureListener() {
        }

        /* synthetic */ GestureListener(TouchImageView x0, AnonymousClass1 x1) {
            this();
        }

        public boolean onSingleTapConfirmed(MotionEvent e) {
            if (TouchImageView.this.doubleTapListener != null) {
                return TouchImageView.this.doubleTapListener.onSingleTapConfirmed(e);
            }
            return TouchImageView.this.performClick();
        }

        public void onLongPress(MotionEvent e) {
            TouchImageView.this.performLongClick();
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (TouchImageView.this.fling != null) {
                TouchImageView.this.fling.cancelFling();
            }
            TouchImageView touchImageView = TouchImageView.this;
            Fling unused = touchImageView.fling = new Fling(touchImageView, (int) velocityX, (int) velocityY);
            TouchImageView touchImageView2 = TouchImageView.this;
            touchImageView2.compatPostOnAnimation(touchImageView2.fling);
            return super.onFling(e1, e2, velocityX, velocityY);
        }

        public boolean onDoubleTap(MotionEvent e) {
            boolean consumed = false;
            if (TouchImageView.this.doubleTapListener != null) {
                consumed = TouchImageView.this.doubleTapListener.onDoubleTap(e);
            }
            if (TouchImageView.this.state != State.NONE) {
                return consumed;
            }
            TouchImageView.this.compatPostOnAnimation(new DoubleTapZoom(TouchImageView.this.normalizedScale == TouchImageView.this.minScale ? TouchImageView.this.maxScale : TouchImageView.this.minScale, e.getX(), e.getY(), false));
            return true;
        }

        public boolean onDoubleTapEvent(MotionEvent e) {
            if (TouchImageView.this.doubleTapListener != null) {
                return TouchImageView.this.doubleTapListener.onDoubleTapEvent(e);
            }
            return false;
        }
    }

    private class PrivateOnTouchListener implements View.OnTouchListener {
        private PointF last;

        private PrivateOnTouchListener() {
            this.last = new PointF();
        }

        /* synthetic */ PrivateOnTouchListener(TouchImageView x0, AnonymousClass1 x1) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x004a, code lost:
            if (r1 != 6) goto L_0x00c6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouch(android.view.View r10, android.view.MotionEvent r11) {
            /*
                r9 = this;
                com.sangcomz.fishbun.util.TouchImageView r0 = com.sangcomz.fishbun.util.TouchImageView.this
                android.view.ScaleGestureDetector r0 = r0.mScaleDetector
                r0.onTouchEvent(r11)
                com.sangcomz.fishbun.util.TouchImageView r0 = com.sangcomz.fishbun.util.TouchImageView.this
                android.view.GestureDetector r0 = r0.mGestureDetector
                r0.onTouchEvent(r11)
                android.graphics.PointF r0 = new android.graphics.PointF
                float r1 = r11.getX()
                float r2 = r11.getY()
                r0.<init>(r1, r2)
                com.sangcomz.fishbun.util.TouchImageView r1 = com.sangcomz.fishbun.util.TouchImageView.this
                com.sangcomz.fishbun.util.TouchImageView$State r1 = r1.state
                com.sangcomz.fishbun.util.TouchImageView$State r2 = com.sangcomz.fishbun.util.TouchImageView.State.NONE
                r3 = 1
                if (r1 == r2) goto L_0x003e
                com.sangcomz.fishbun.util.TouchImageView r1 = com.sangcomz.fishbun.util.TouchImageView.this
                com.sangcomz.fishbun.util.TouchImageView$State r1 = r1.state
                com.sangcomz.fishbun.util.TouchImageView$State r2 = com.sangcomz.fishbun.util.TouchImageView.State.DRAG
                if (r1 == r2) goto L_0x003e
                com.sangcomz.fishbun.util.TouchImageView r1 = com.sangcomz.fishbun.util.TouchImageView.this
                com.sangcomz.fishbun.util.TouchImageView$State r1 = r1.state
                com.sangcomz.fishbun.util.TouchImageView$State r2 = com.sangcomz.fishbun.util.TouchImageView.State.FLING
                if (r1 != r2) goto L_0x00c6
            L_0x003e:
                int r1 = r11.getAction()
                if (r1 == 0) goto L_0x00a8
                if (r1 == r3) goto L_0x00a0
                r2 = 2
                if (r1 == r2) goto L_0x004e
                r2 = 6
                if (r1 == r2) goto L_0x00a0
                goto L_0x00c6
            L_0x004e:
                com.sangcomz.fishbun.util.TouchImageView r1 = com.sangcomz.fishbun.util.TouchImageView.this
                com.sangcomz.fishbun.util.TouchImageView$State r1 = r1.state
                com.sangcomz.fishbun.util.TouchImageView$State r2 = com.sangcomz.fishbun.util.TouchImageView.State.DRAG
                if (r1 != r2) goto L_0x00c6
                float r1 = r0.x
                android.graphics.PointF r2 = r9.last
                float r2 = r2.x
                float r1 = r1 - r2
                float r2 = r0.y
                android.graphics.PointF r4 = r9.last
                float r4 = r4.y
                float r2 = r2 - r4
                com.sangcomz.fishbun.util.TouchImageView r4 = com.sangcomz.fishbun.util.TouchImageView.this
                int r5 = r4.viewWidth
                float r5 = (float) r5
                com.sangcomz.fishbun.util.TouchImageView r6 = com.sangcomz.fishbun.util.TouchImageView.this
                float r6 = r6.getImageWidth()
                float r4 = r4.getFixDragTrans(r1, r5, r6)
                com.sangcomz.fishbun.util.TouchImageView r5 = com.sangcomz.fishbun.util.TouchImageView.this
                int r6 = r5.viewHeight
                float r6 = (float) r6
                com.sangcomz.fishbun.util.TouchImageView r7 = com.sangcomz.fishbun.util.TouchImageView.this
                float r7 = r7.getImageHeight()
                float r5 = r5.getFixDragTrans(r2, r6, r7)
                com.sangcomz.fishbun.util.TouchImageView r6 = com.sangcomz.fishbun.util.TouchImageView.this
                android.graphics.Matrix r6 = r6.matrix
                r6.postTranslate(r4, r5)
                com.sangcomz.fishbun.util.TouchImageView r6 = com.sangcomz.fishbun.util.TouchImageView.this
                r6.fixTrans()
                android.graphics.PointF r6 = r9.last
                float r7 = r0.x
                float r8 = r0.y
                r6.set(r7, r8)
                goto L_0x00c6
            L_0x00a0:
                com.sangcomz.fishbun.util.TouchImageView r1 = com.sangcomz.fishbun.util.TouchImageView.this
                com.sangcomz.fishbun.util.TouchImageView$State r2 = com.sangcomz.fishbun.util.TouchImageView.State.NONE
                r1.setState(r2)
                goto L_0x00c6
            L_0x00a8:
                android.graphics.PointF r1 = r9.last
                r1.set(r0)
                com.sangcomz.fishbun.util.TouchImageView r1 = com.sangcomz.fishbun.util.TouchImageView.this
                com.sangcomz.fishbun.util.TouchImageView$Fling r1 = r1.fling
                if (r1 == 0) goto L_0x00be
                com.sangcomz.fishbun.util.TouchImageView r1 = com.sangcomz.fishbun.util.TouchImageView.this
                com.sangcomz.fishbun.util.TouchImageView$Fling r1 = r1.fling
                r1.cancelFling()
            L_0x00be:
                com.sangcomz.fishbun.util.TouchImageView r1 = com.sangcomz.fishbun.util.TouchImageView.this
                com.sangcomz.fishbun.util.TouchImageView$State r2 = com.sangcomz.fishbun.util.TouchImageView.State.DRAG
                r1.setState(r2)
            L_0x00c6:
                com.sangcomz.fishbun.util.TouchImageView r1 = com.sangcomz.fishbun.util.TouchImageView.this
                android.graphics.Matrix r2 = r1.matrix
                r1.setImageMatrix(r2)
                com.sangcomz.fishbun.util.TouchImageView r1 = com.sangcomz.fishbun.util.TouchImageView.this
                android.view.View$OnTouchListener r1 = r1.userTouchListener
                if (r1 == 0) goto L_0x00e0
                com.sangcomz.fishbun.util.TouchImageView r1 = com.sangcomz.fishbun.util.TouchImageView.this
                android.view.View$OnTouchListener r1 = r1.userTouchListener
                r1.onTouch(r10, r11)
            L_0x00e0:
                com.sangcomz.fishbun.util.TouchImageView r1 = com.sangcomz.fishbun.util.TouchImageView.this
                com.sangcomz.fishbun.util.TouchImageView$OnTouchImageViewListener r1 = r1.touchImageViewListener
                if (r1 == 0) goto L_0x00f1
                com.sangcomz.fishbun.util.TouchImageView r1 = com.sangcomz.fishbun.util.TouchImageView.this
                com.sangcomz.fishbun.util.TouchImageView$OnTouchImageViewListener r1 = r1.touchImageViewListener
                r1.onMove()
            L_0x00f1:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sangcomz.fishbun.util.TouchImageView.PrivateOnTouchListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private ScaleListener() {
        }

        /* synthetic */ ScaleListener(TouchImageView x0, AnonymousClass1 x1) {
            this();
        }

        public boolean onScaleBegin(ScaleGestureDetector detector) {
            TouchImageView.this.setState(State.ZOOM);
            return true;
        }

        public boolean onScale(ScaleGestureDetector detector) {
            TouchImageView.this.scaleImage((double) detector.getScaleFactor(), detector.getFocusX(), detector.getFocusY(), true);
            if (TouchImageView.this.touchImageViewListener == null) {
                return true;
            }
            TouchImageView.this.touchImageViewListener.onMove();
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector detector) {
            float targetZoom;
            super.onScaleEnd(detector);
            TouchImageView.this.setState(State.NONE);
            boolean animateToZoomBoundary = false;
            float targetZoom2 = TouchImageView.this.normalizedScale;
            if (TouchImageView.this.normalizedScale > TouchImageView.this.maxScale) {
                animateToZoomBoundary = true;
                targetZoom = TouchImageView.this.maxScale;
            } else if (TouchImageView.this.normalizedScale < TouchImageView.this.minScale) {
                animateToZoomBoundary = true;
                targetZoom = TouchImageView.this.minScale;
            } else {
                targetZoom = targetZoom2;
            }
            if (animateToZoomBoundary) {
                TouchImageView touchImageView = TouchImageView.this;
                TouchImageView.this.compatPostOnAnimation(new DoubleTapZoom(targetZoom, (float) (touchImageView.viewWidth / 2), (float) (TouchImageView.this.viewHeight / 2), true));
            }
        }
    }

    /* access modifiers changed from: private */
    public void scaleImage(double deltaScale, float focusX, float focusY, boolean stretchImageToSuper) {
        float upperScale;
        float lowerScale;
        if (stretchImageToSuper) {
            lowerScale = this.superMinScale;
            upperScale = this.superMaxScale;
        } else {
            lowerScale = this.minScale;
            upperScale = this.maxScale;
        }
        float origScale = this.normalizedScale;
        float f = (float) (((double) this.normalizedScale) * deltaScale);
        this.normalizedScale = f;
        if (f > upperScale) {
            this.normalizedScale = upperScale;
            deltaScale = (double) (upperScale / origScale);
        } else if (f < lowerScale) {
            this.normalizedScale = lowerScale;
            deltaScale = (double) (lowerScale / origScale);
        }
        this.matrix.postScale((float) deltaScale, (float) deltaScale, focusX, focusY);
        fixScaleTrans();
    }

    private class DoubleTapZoom implements Runnable {
        private static final float ZOOM_TIME = 500.0f;
        private float bitmapX;
        private float bitmapY;
        private PointF endTouch;
        private AccelerateDecelerateInterpolator interpolator = new AccelerateDecelerateInterpolator();
        private long startTime;
        private PointF startTouch;
        private float startZoom;
        private boolean stretchImageToSuper;
        private float targetZoom;

        DoubleTapZoom(float targetZoom2, float focusX, float focusY, boolean stretchImageToSuper2) {
            TouchImageView.this.setState(State.ANIMATE_ZOOM);
            this.startTime = System.currentTimeMillis();
            this.startZoom = TouchImageView.this.normalizedScale;
            this.targetZoom = targetZoom2;
            this.stretchImageToSuper = stretchImageToSuper2;
            PointF bitmapPoint = TouchImageView.this.transformCoordTouchToBitmap(focusX, focusY, false);
            this.bitmapX = bitmapPoint.x;
            float f = bitmapPoint.y;
            this.bitmapY = f;
            this.startTouch = TouchImageView.this.transformCoordBitmapToTouch(this.bitmapX, f);
            this.endTouch = new PointF((float) (TouchImageView.this.viewWidth / 2), (float) (TouchImageView.this.viewHeight / 2));
        }

        public void run() {
            float t = interpolate();
            TouchImageView.this.scaleImage(calculateDeltaScale(t), this.bitmapX, this.bitmapY, this.stretchImageToSuper);
            translateImageToCenterTouchPosition(t);
            TouchImageView.this.fixScaleTrans();
            TouchImageView touchImageView = TouchImageView.this;
            touchImageView.setImageMatrix(touchImageView.matrix);
            if (TouchImageView.this.touchImageViewListener != null) {
                TouchImageView.this.touchImageViewListener.onMove();
            }
            if (t < 1.0f) {
                TouchImageView.this.compatPostOnAnimation(this);
            } else {
                TouchImageView.this.setState(State.NONE);
            }
        }

        private void translateImageToCenterTouchPosition(float t) {
            float targetX = this.startTouch.x + ((this.endTouch.x - this.startTouch.x) * t);
            float targetY = this.startTouch.y + ((this.endTouch.y - this.startTouch.y) * t);
            PointF curr = TouchImageView.this.transformCoordBitmapToTouch(this.bitmapX, this.bitmapY);
            TouchImageView.this.matrix.postTranslate(targetX - curr.x, targetY - curr.y);
        }

        private float interpolate() {
            return this.interpolator.getInterpolation(Math.min(1.0f, ((float) (System.currentTimeMillis() - this.startTime)) / ZOOM_TIME));
        }

        private double calculateDeltaScale(float t) {
            float f = this.startZoom;
            return ((double) (f + ((this.targetZoom - f) * t))) / ((double) TouchImageView.this.normalizedScale);
        }
    }

    /* access modifiers changed from: private */
    public PointF transformCoordTouchToBitmap(float x, float y, boolean clipToBitmap) {
        this.matrix.getValues(this.m);
        float origW = (float) getDrawable().getIntrinsicWidth();
        float origH = (float) getDrawable().getIntrinsicHeight();
        float[] fArr = this.m;
        float transX = fArr[2];
        float transY = fArr[5];
        float finalX = ((x - transX) * origW) / getImageWidth();
        float finalY = ((y - transY) * origH) / getImageHeight();
        if (clipToBitmap) {
            finalX = Math.min(Math.max(finalX, 0.0f), origW);
            finalY = Math.min(Math.max(finalY, 0.0f), origH);
        }
        return new PointF(finalX, finalY);
    }

    /* access modifiers changed from: private */
    public PointF transformCoordBitmapToTouch(float bx, float by) {
        this.matrix.getValues(this.m);
        return new PointF(this.m[2] + (getImageWidth() * (bx / ((float) getDrawable().getIntrinsicWidth()))), this.m[5] + (getImageHeight() * (by / ((float) getDrawable().getIntrinsicHeight()))));
    }

    private class Fling implements Runnable {
        int currX;
        int currY;
        CompatScroller scroller;
        final /* synthetic */ TouchImageView this$0;

        Fling(TouchImageView touchImageView, int velocityX, int velocityY) {
            int maxX;
            int minX;
            int minY;
            int maxY;
            TouchImageView touchImageView2 = touchImageView;
            this.this$0 = touchImageView2;
            touchImageView2.setState(State.FLING);
            this.scroller = new CompatScroller(touchImageView.context);
            touchImageView.matrix.getValues(touchImageView.m);
            int startX = (int) touchImageView.m[2];
            int startY = (int) touchImageView.m[5];
            if (touchImageView.getImageWidth() > ((float) touchImageView.viewWidth)) {
                minX = touchImageView.viewWidth - ((int) touchImageView.getImageWidth());
                maxX = 0;
            } else {
                minX = startX;
                maxX = startX;
            }
            if (touchImageView.getImageHeight() > ((float) touchImageView.viewHeight)) {
                maxY = 0;
                minY = touchImageView.viewHeight - ((int) touchImageView.getImageHeight());
            } else {
                maxY = startY;
                minY = startY;
            }
            this.scroller.fling(startX, startY, velocityX, velocityY, minX, maxX, minY, maxY);
            this.currX = startX;
            this.currY = startY;
        }

        public void cancelFling() {
            if (this.scroller != null) {
                this.this$0.setState(State.NONE);
                this.scroller.forceFinished(true);
            }
        }

        public void run() {
            if (this.this$0.touchImageViewListener != null) {
                this.this$0.touchImageViewListener.onMove();
            }
            if (this.scroller.isFinished()) {
                this.scroller = null;
            } else if (this.scroller.computeScrollOffset()) {
                int newX = this.scroller.getCurrX();
                int newY = this.scroller.getCurrY();
                this.currX = newX;
                this.currY = newY;
                this.this$0.matrix.postTranslate((float) (newX - this.currX), (float) (newY - this.currY));
                this.this$0.fixTrans();
                TouchImageView touchImageView = this.this$0;
                touchImageView.setImageMatrix(touchImageView.matrix);
                this.this$0.compatPostOnAnimation(this);
            }
        }
    }

    private class CompatScroller {
        boolean isPreGingerbread;
        OverScroller overScroller;
        Scroller scroller;

        public CompatScroller(Context context) {
            if (Build.VERSION.SDK_INT < 9) {
                this.isPreGingerbread = true;
                this.scroller = new Scroller(context);
                return;
            }
            this.isPreGingerbread = false;
            this.overScroller = new OverScroller(context);
        }

        public void fling(int startX, int startY, int velocityX, int velocityY, int minX, int maxX, int minY, int maxY) {
            if (this.isPreGingerbread) {
                this.scroller.fling(startX, startY, velocityX, velocityY, minX, maxX, minY, maxY);
            } else {
                this.overScroller.fling(startX, startY, velocityX, velocityY, minX, maxX, minY, maxY);
            }
        }

        public void forceFinished(boolean finished) {
            if (this.isPreGingerbread) {
                this.scroller.forceFinished(finished);
            } else {
                this.overScroller.forceFinished(finished);
            }
        }

        public boolean isFinished() {
            if (this.isPreGingerbread) {
                return this.scroller.isFinished();
            }
            return this.overScroller.isFinished();
        }

        public boolean computeScrollOffset() {
            if (this.isPreGingerbread) {
                return this.scroller.computeScrollOffset();
            }
            this.overScroller.computeScrollOffset();
            return this.overScroller.computeScrollOffset();
        }

        public int getCurrX() {
            if (this.isPreGingerbread) {
                return this.scroller.getCurrX();
            }
            return this.overScroller.getCurrX();
        }

        public int getCurrY() {
            if (this.isPreGingerbread) {
                return this.scroller.getCurrY();
            }
            return this.overScroller.getCurrY();
        }
    }

    /* access modifiers changed from: private */
    public void compatPostOnAnimation(Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            postOnAnimation(runnable);
        } else {
            postDelayed(runnable, 16);
        }
    }

    private class ZoomVariables {
        public float focusX;
        public float focusY;
        public float scale;
        public ImageView.ScaleType scaleType;

        public ZoomVariables(float scale2, float focusX2, float focusY2, ImageView.ScaleType scaleType2) {
            this.scale = scale2;
            this.focusX = focusX2;
            this.focusY = focusY2;
            this.scaleType = scaleType2;
        }
    }

    private void printMatrixInfo() {
        float[] n = new float[9];
        this.matrix.getValues(n);
        Log.d(DEBUG, "Scale: " + n[0] + " TransX: " + n[2] + " TransY: " + n[5]);
    }
}
