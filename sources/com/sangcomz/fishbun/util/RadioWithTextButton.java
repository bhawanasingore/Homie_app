package com.sangcomz.fishbun.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.sangcomz.fishbun.R;
import com.sangcomz.fishbun.util.RadioType;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 12\u00020\u0001:\u00011B'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ0\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0017H\u0002J\b\u0010#\u001a\u00020\fH\u0002J\u0016\u0010$\u001a\u00020\u001b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0&H\u0002J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J\u0010\u0010(\u001a\u00020\u001b2\b\b\u0001\u0010)\u001a\u00020\fJ\u000e\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020,J\u0010\u0010-\u001a\u00020\u001b2\b\b\u0001\u0010)\u001a\u00020\fJ\u000e\u0010.\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010/\u001a\u00020\u001b2\b\b\u0001\u0010)\u001a\u00020\fJ\u0006\u00100\u001a\u00020\u001bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u000e\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u00062"}, d2 = {"Lcom/sangcomz/fishbun/util/RadioWithTextButton;", "Landroid/view/View;", "context", "Landroid/content/Context;", "textPaint", "Landroid/graphics/Paint;", "strokePaint", "circlePaint", "(Landroid/content/Context;Landroid/graphics/Paint;Landroid/graphics/Paint;Landroid/graphics/Paint;)V", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_centerRect", "Landroid/graphics/Rect;", "get_centerRect", "()Landroid/graphics/Rect;", "centerRect", "getCenterRect", "radioType", "Lcom/sangcomz/fishbun/util/RadioType;", "textWidth", "", "getTextWidth", "()F", "drawTextCentered", "", "canvas", "Landroid/graphics/Canvas;", "paint", "text", "", "cx", "cy", "fetchAccentColor", "isSelected", "block", "Lkotlin/Function0;", "onDraw", "setCircleColor", "color", "setDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setStrokeColor", "setText", "setTextColor", "unselect", "Companion", "FishBun_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: RadioWithTextButton.kt */
public final class RadioWithTextButton extends View {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float PADDING_TEXT = 20.0f;
    private HashMap _$_findViewCache;
    private Rect _centerRect;
    /* access modifiers changed from: private */
    public Paint circlePaint;
    private RadioType radioType;
    private Paint strokePaint;
    private Paint textPaint;

    public RadioWithTextButton(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public RadioWithTextButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RadioWithTextButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.radioType = RadioType.None.INSTANCE;
        Paint $this$apply = new Paint(1);
        $this$apply.setFakeBoldText(true);
        this.textPaint = $this$apply;
        this.strokePaint = new Paint(1);
        this.circlePaint = new Paint(1);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RadioWithTextButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RadioWithTextButton(Context context, Paint textPaint2, Paint strokePaint2, Paint circlePaint2) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(textPaint2, "textPaint");
        Intrinsics.checkParameterIsNotNull(strokePaint2, "strokePaint");
        Intrinsics.checkParameterIsNotNull(circlePaint2, "circlePaint");
        this.textPaint = textPaint2;
        this.strokePaint = strokePaint2;
        this.circlePaint = circlePaint2;
    }

    private final float getTextWidth() {
        return ((float) ((getWidth() / 3) * 2)) - PADDING_TEXT;
    }

    private final Rect getCenterRect() {
        Rect rect = get_centerRect();
        if (rect == null) {
            Intrinsics.throwNpe();
        }
        return rect;
    }

    private final Rect get_centerRect() {
        if (this._centerRect == null) {
            Rect r = new Rect(0, 0, getWidth(), getHeight());
            int width = getWidth() / 4;
            this._centerRect = new Rect((int) (r.exactCenterX() - ((float) width)), (int) (r.exactCenterY() - ((float) width)), getWidth() - width, getHeight() - width);
        }
        return this._centerRect;
    }

    public final void setTextColor(int color) {
        this.textPaint.setColor(color);
    }

    public final void setCircleColor(int color) {
        this.circlePaint.setColor(color);
    }

    public final void setStrokeColor(int color) {
        this.strokePaint.setColor(color);
    }

    public final void setText(String text) {
        Intrinsics.checkParameterIsNotNull(text, "text");
        this.radioType = new RadioType.RadioText(text);
        invalidate();
    }

    public final void setDrawable(Drawable drawable) {
        Intrinsics.checkParameterIsNotNull(drawable, "drawable");
        this.radioType = new RadioType.RadioDrawable(drawable);
        invalidate();
    }

    public final void unselect() {
        this.radioType = RadioType.None.INSTANCE;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        this.strokePaint.setStrokeWidth((float) (getWidth() / 18));
        isSelected(new RadioWithTextButton$onDraw$1(this, canvas));
        RadioType this_$iv = this.radioType;
        if (this_$iv instanceof RadioType.RadioText) {
            drawTextCentered(canvas, this.textPaint, ((RadioType.RadioText) this_$iv).getText(), (float) (getWidth() / 2), (float) (getHeight() / 2));
        }
        if (this_$iv instanceof RadioType.RadioDrawable) {
            RadioType.RadioDrawable $receiver = (RadioType.RadioDrawable) this_$iv;
            $receiver.getDrawable().setBounds(getCenterRect());
            $receiver.getDrawable().draw(canvas);
        }
        if (this_$iv instanceof RadioType.None) {
            RadioType.None none = (RadioType.None) this_$iv;
            this.strokePaint.setStyle(Paint.Style.STROKE);
            canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) (getWidth() / 3), this.strokePaint);
        }
    }

    private final void isSelected(Function0<Unit> block) {
        if (!Intrinsics.areEqual((Object) this.radioType, (Object) RadioType.None.INSTANCE)) {
            block.invoke();
        }
    }

    private final void drawTextCentered(Canvas canvas, Paint paint, String text, float cx, float cy) {
        Rect textBounds = new Rect();
        Paint $this$with = paint;
        DrawUtil.setTextSizeForWidth($this$with, text, getTextWidth());
        $this$with.getTextBounds(text, 0, text.length(), textBounds);
        canvas.drawText(text, cx - textBounds.exactCenterX(), cy - textBounds.exactCenterY(), paint);
    }

    private final int fetchAccentColor() {
        TypedValue typedValue = new TypedValue();
        TypedArray a = getContext().obtainStyledAttributes(typedValue.data, new int[]{R.attr.colorAccent});
        int color = a.getColor(0, 0);
        a.recycle();
        return color;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/sangcomz/fishbun/util/RadioWithTextButton$Companion;", "", "()V", "PADDING_TEXT", "", "FishBun_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: RadioWithTextButton.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}
