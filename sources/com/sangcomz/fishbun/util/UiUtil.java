package com.sangcomz.fishbun.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.Window;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0001\u001a\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u001a*\u0010\t\u001a\u00020\n\"\b\b\u0000\u0010\u000b*\u00020\u0002*\u0002H\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\rH\b¢\u0006\u0002\u0010\u000e\u001a\n\u0010\t\u001a\u00020\u000f*\u00020\u0002\u001a\u0014\u0010\u0010\u001a\u00020\n*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0001H\u0007¨\u0006\u0013"}, d2 = {"getDimension", "", "Landroid/content/Context;", "id", "getDrawableFromBitmap", "Landroid/graphics/drawable/BitmapDrawable;", "Landroid/content/res/Resources;", "bitmap", "Landroid/graphics/Bitmap;", "isLandscape", "", "T", "block", "Lkotlin/Function0;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "", "setStatusBarColor", "Landroid/app/Activity;", "colorStatusBar", "FishBun_release"}, k = 2, mv = {1, 1, 15})
/* compiled from: UiUtil.kt */
public final class UiUtil {
    public static final void setStatusBarColor(Activity $this$setStatusBarColor, int colorStatusBar) {
        Intrinsics.checkParameterIsNotNull($this$setStatusBarColor, "$this$setStatusBarColor");
        if (colorStatusBar != Integer.MAX_VALUE) {
            Window $this$with = $this$setStatusBarColor.getWindow();
            $this$with.clearFlags(67108864);
            $this$with.addFlags(Integer.MIN_VALUE);
            $this$with.setStatusBarColor(colorStatusBar);
        }
    }

    public static final boolean isLandscape(Context $this$isLandscape) {
        Intrinsics.checkParameterIsNotNull($this$isLandscape, "$this$isLandscape");
        Resources resources = $this$isLandscape.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return resources.getConfiguration().orientation == 2;
    }

    public static final <T extends Context> void isLandscape(T $this$isLandscape, Function0<Unit> block) {
        Intrinsics.checkParameterIsNotNull($this$isLandscape, "$this$isLandscape");
        Intrinsics.checkParameterIsNotNull(block, "block");
        if (isLandscape($this$isLandscape)) {
            block.invoke();
        }
    }

    public static final int getDimension(Context $this$getDimension, int id) {
        Intrinsics.checkParameterIsNotNull($this$getDimension, "$this$getDimension");
        return (int) $this$getDimension.getResources().getDimension(id);
    }

    public static final BitmapDrawable getDrawableFromBitmap(Resources $this$getDrawableFromBitmap, Bitmap bitmap) {
        Intrinsics.checkParameterIsNotNull($this$getDrawableFromBitmap, "$this$getDrawableFromBitmap");
        if (bitmap != null) {
            return new BitmapDrawable($this$getDrawableFromBitmap, bitmap);
        }
        return null;
    }
}
