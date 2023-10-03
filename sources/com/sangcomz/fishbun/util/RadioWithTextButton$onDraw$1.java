package com.sangcomz.fishbun.util;

import android.graphics.Canvas;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 15})
/* compiled from: RadioWithTextButton.kt */
final class RadioWithTextButton$onDraw$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Canvas $canvas;
    final /* synthetic */ RadioWithTextButton this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RadioWithTextButton$onDraw$1(RadioWithTextButton radioWithTextButton, Canvas canvas) {
        super(0);
        this.this$0 = radioWithTextButton;
        this.$canvas = canvas;
    }

    public final void invoke() {
        this.$canvas.drawCircle((float) (this.this$0.getWidth() / 2), (float) (this.this$0.getHeight() / 2), (float) (this.this$0.getWidth() / 3), this.this$0.circlePaint);
    }
}
