package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.RenderSurface;
import java.util.LinkedList;
import java.util.Queue;

public class FlutterImageView extends View implements RenderSurface {
    private Bitmap currentBitmap;
    private Image currentImage;
    private FlutterRenderer flutterRenderer;
    private Queue<Image> imageQueue;
    private ImageReader imageReader;
    private boolean isAttachedToFlutterRenderer;
    private SurfaceKind kind;
    private int pendingImages;

    public enum SurfaceKind {
        background,
        overlay
    }

    public FlutterImageView(Context context, int width, int height, SurfaceKind kind2) {
        this(context, createImageReader(width, height), kind2);
    }

    public FlutterImageView(Context context) {
        this(context, 1, 1, SurfaceKind.background);
    }

    public FlutterImageView(Context context, AttributeSet attrs) {
        this(context, 1, 1, SurfaceKind.background);
    }

    FlutterImageView(Context context, ImageReader imageReader2, SurfaceKind kind2) {
        super(context, (AttributeSet) null);
        this.pendingImages = 0;
        this.isAttachedToFlutterRenderer = false;
        this.imageReader = imageReader2;
        this.kind = kind2;
        this.imageQueue = new LinkedList();
        init();
    }

    private void init() {
        setAlpha(0.0f);
    }

    private static ImageReader createImageReader(int width, int height) {
        if (Build.VERSION.SDK_INT >= 29) {
            return ImageReader.newInstance(width, height, 1, 3, 768);
        }
        return ImageReader.newInstance(width, height, 1, 3);
    }

    public Surface getSurface() {
        return this.imageReader.getSurface();
    }

    public FlutterRenderer getAttachedRenderer() {
        return this.flutterRenderer;
    }

    public void attachToRenderer(FlutterRenderer flutterRenderer2) {
        if (!this.isAttachedToFlutterRenderer) {
            if (AnonymousClass1.$SwitchMap$io$flutter$embedding$android$FlutterImageView$SurfaceKind[this.kind.ordinal()] == 1) {
                flutterRenderer2.swapSurface(this.imageReader.getSurface());
            }
            setAlpha(1.0f);
            this.flutterRenderer = flutterRenderer2;
            this.isAttachedToFlutterRenderer = true;
        }
    }

    /* renamed from: io.flutter.embedding.android.FlutterImageView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$android$FlutterImageView$SurfaceKind;

        static {
            int[] iArr = new int[SurfaceKind.values().length];
            $SwitchMap$io$flutter$embedding$android$FlutterImageView$SurfaceKind = iArr;
            try {
                iArr[SurfaceKind.background.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$io$flutter$embedding$android$FlutterImageView$SurfaceKind[SurfaceKind.overlay.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public void detachFromRenderer() {
        if (this.isAttachedToFlutterRenderer) {
            setAlpha(0.0f);
            acquireLatestImage();
            this.currentBitmap = null;
            for (Image image : this.imageQueue) {
                image.close();
            }
            this.imageQueue.clear();
            Image image2 = this.currentImage;
            if (image2 != null) {
                image2.close();
                this.currentImage = null;
            }
            invalidate();
            this.isAttachedToFlutterRenderer = false;
        }
    }

    public void pause() {
    }

    public boolean acquireLatestImage() {
        Image image;
        if (!this.isAttachedToFlutterRenderer) {
            return false;
        }
        int imageOpenedCount = this.imageQueue.size();
        if (this.currentImage != null) {
            imageOpenedCount++;
        }
        if (imageOpenedCount < this.imageReader.getMaxImages() && (image = this.imageReader.acquireLatestImage()) != null) {
            this.imageQueue.add(image);
        }
        invalidate();
        return !this.imageQueue.isEmpty();
    }

    public void resizeIfNeeded(int width, int height) {
        if (this.flutterRenderer != null) {
            if (width != this.imageReader.getWidth() || height != this.imageReader.getHeight()) {
                this.imageQueue.clear();
                this.currentImage = null;
                this.imageReader.close();
                this.imageReader = createImageReader(width, height);
                this.pendingImages = 0;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.imageQueue.isEmpty()) {
            Image image = this.currentImage;
            if (image != null) {
                image.close();
            }
            this.currentImage = this.imageQueue.poll();
            updateCurrentBitmap();
        }
        Bitmap bitmap = this.currentBitmap;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void updateCurrentBitmap() {
        if (Build.VERSION.SDK_INT >= 29) {
            HardwareBuffer buffer = this.currentImage.getHardwareBuffer();
            this.currentBitmap = Bitmap.wrapHardwareBuffer(buffer, ColorSpace.get(ColorSpace.Named.SRGB));
            buffer.close();
            return;
        }
        Image.Plane[] imagePlanes = this.currentImage.getPlanes();
        if (imagePlanes.length == 1) {
            Image.Plane imagePlane = imagePlanes[0];
            int desiredWidth = imagePlane.getRowStride() / imagePlane.getPixelStride();
            int desiredHeight = this.currentImage.getHeight();
            Bitmap bitmap = this.currentBitmap;
            if (!(bitmap != null && bitmap.getWidth() == desiredWidth && this.currentBitmap.getHeight() == desiredHeight)) {
                this.currentBitmap = Bitmap.createBitmap(desiredWidth, desiredHeight, Bitmap.Config.ARGB_8888);
            }
            this.currentBitmap.copyPixelsFromBuffer(imagePlane.getBuffer());
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
        if (!(width == this.imageReader.getWidth() && height == this.imageReader.getHeight()) && this.kind == SurfaceKind.background && this.isAttachedToFlutterRenderer) {
            resizeIfNeeded(width, height);
            this.flutterRenderer.swapSurface(this.imageReader.getSurface());
        }
    }
}
