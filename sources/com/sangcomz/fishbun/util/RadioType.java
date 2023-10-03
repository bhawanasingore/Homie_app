package com.sangcomz.fishbun.util;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b6\u0018\u00002\u00020\u0001:\u0003\r\u000e\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00002\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\fJ\"\u0010\t\u001a\u00020\u00002\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\fJ\"\u0010\u000b\u001a\u00020\u00002\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\f\u0001\u0003\f\u0006\n¨\u0006\u0010"}, d2 = {"Lcom/sangcomz/fishbun/util/RadioType;", "", "()V", "isRadioDrawable", "block", "Lkotlin/Function1;", "Lcom/sangcomz/fishbun/util/RadioType$RadioDrawable;", "", "Lkotlin/ExtensionFunctionType;", "isRadioNone", "Lcom/sangcomz/fishbun/util/RadioType$None;", "isRadioText", "Lcom/sangcomz/fishbun/util/RadioType$RadioText;", "None", "RadioDrawable", "RadioText", "FishBun_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: RadioType.kt */
public abstract class RadioType {
    private RadioType() {
    }

    public /* synthetic */ RadioType(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/sangcomz/fishbun/util/RadioType$RadioText;", "Lcom/sangcomz/fishbun/util/RadioType;", "text", "", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "FishBun_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: RadioType.kt */
    public static final class RadioText extends RadioType {
        private final String text;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RadioText(String text2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkParameterIsNotNull(text2, "text");
            this.text = text2;
        }

        public final String getText() {
            return this.text;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/sangcomz/fishbun/util/RadioType$RadioDrawable;", "Lcom/sangcomz/fishbun/util/RadioType;", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "FishBun_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: RadioType.kt */
    public static final class RadioDrawable extends RadioType {
        private final Drawable drawable;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RadioDrawable(Drawable drawable2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkParameterIsNotNull(drawable2, "drawable");
            this.drawable = drawable2;
        }

        public final Drawable getDrawable() {
            return this.drawable;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sangcomz/fishbun/util/RadioType$None;", "Lcom/sangcomz/fishbun/util/RadioType;", "()V", "FishBun_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: RadioType.kt */
    public static final class None extends RadioType {
        public static final None INSTANCE = new None();

        private None() {
            super((DefaultConstructorMarker) null);
        }
    }

    public final RadioType isRadioText(Function1<? super RadioText, Unit> block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        if (this instanceof RadioText) {
            block.invoke(this);
        }
        return this;
    }

    public final RadioType isRadioDrawable(Function1<? super RadioDrawable, Unit> block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        if (this instanceof RadioDrawable) {
            block.invoke(this);
        }
        return this;
    }

    public final RadioType isRadioNone(Function1<? super None, Unit> block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        if (this instanceof None) {
            block.invoke(this);
        }
        return this;
    }
}
