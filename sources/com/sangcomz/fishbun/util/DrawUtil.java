package com.sangcomz.fishbun.util;

import android.graphics.Paint;
import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"setTextSizeForWidth", "", "Landroid/graphics/Paint;", "text", "", "desiredWidth", "", "FishBun_release"}, k = 2, mv = {1, 1, 15})
/* compiled from: DrawUtil.kt */
public final class DrawUtil {
    public static final void setTextSizeForWidth(Paint $this$setTextSizeForWidth, String text, float desiredWidth) {
        Intrinsics.checkParameterIsNotNull($this$setTextSizeForWidth, "$this$setTextSizeForWidth");
        Intrinsics.checkParameterIsNotNull(text, "text");
        Rect textBounds = new Rect();
        $this$setTextSizeForWidth.setTextSize(44.0f);
        $this$setTextSizeForWidth.getTextBounds(text, 0, text.length(), textBounds);
        if (((float) textBounds.width()) > desiredWidth) {
            $this$setTextSizeForWidth.setTextSize((desiredWidth / ((float) textBounds.width())) * 44.0f);
        }
    }
}
