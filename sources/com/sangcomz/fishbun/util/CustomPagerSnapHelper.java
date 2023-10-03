package com.sangcomz.fishbun.util;

import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B6\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012%\b\u0002\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R+\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/sangcomz/fishbun/util/CustomPagerSnapHelper;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "onPageChanged", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;Lkotlin/jvm/functions/Function1;)V", "onFling", "", "velocityX", "velocityY", "FishBun_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: CustomPagerSnapHelper.kt */
public final class CustomPagerSnapHelper extends PagerSnapHelper {
    private final RecyclerView.LayoutManager layoutManager;
    private final Function1<Integer, Unit> onPageChanged;

    public CustomPagerSnapHelper(RecyclerView.LayoutManager layoutManager2) {
        this(layoutManager2, (Function1) null, 2, (DefaultConstructorMarker) null);
    }

    public CustomPagerSnapHelper(RecyclerView.LayoutManager layoutManager2, Function1<? super Integer, Unit> onPageChanged2) {
        Intrinsics.checkParameterIsNotNull(layoutManager2, "layoutManager");
        this.layoutManager = layoutManager2;
        this.onPageChanged = onPageChanged2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CustomPagerSnapHelper(RecyclerView.LayoutManager layoutManager2, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutManager2, (i & 2) != 0 ? null : function1);
    }

    public boolean onFling(int velocityX, int velocityY) {
        Function1<Integer, Unit> function1 = this.onPageChanged;
        if (function1 != null) {
            Unit invoke = function1.invoke(Integer.valueOf(findTargetSnapPosition(this.layoutManager, velocityX, velocityY)));
        }
        return super.onFling(velocityX, velocityY);
    }
}
