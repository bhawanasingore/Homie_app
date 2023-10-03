package com.sangcomz.fishbun;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.sangcomz.fishbun.adapter.image.ImageAdapter;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/sangcomz/fishbun/FishBun;", "", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "_context", "Ljava/lang/ref/WeakReference;", "getContext", "()Landroid/app/Activity;", "setImageAdapter", "Lcom/sangcomz/fishbun/FishBunCreator;", "imageAdapter", "Lcom/sangcomz/fishbun/adapter/image/ImageAdapter;", "Companion", "FishBun_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: FishBun.kt */
public final class FishBun {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final WeakReference<Activity> _context;

    @JvmStatic
    public static final FishBun with(Activity activity) {
        return Companion.with(activity);
    }

    @JvmStatic
    public static final FishBun with(Fragment fragment) {
        return Companion.with(fragment);
    }

    private FishBun(Activity context) {
        this._context = new WeakReference<>(context);
    }

    public /* synthetic */ FishBun(Activity context, DefaultConstructorMarker $constructor_marker) {
        this(context);
    }

    public final Activity getContext() {
        return (Activity) this._context.get();
    }

    public final FishBunCreator setImageAdapter(ImageAdapter imageAdapter) {
        Intrinsics.checkParameterIsNotNull(imageAdapter, "imageAdapter");
        Fishton fishton = Fishton.Companion.getInstance();
        Fishton $this$apply = fishton;
        $this$apply.refresh();
        $this$apply.setImageAdapter(imageAdapter);
        return new FishBunCreator(this, fishton);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/sangcomz/fishbun/FishBun$Companion;", "", "()V", "with", "Lcom/sangcomz/fishbun/FishBun;", "activity", "Landroid/app/Activity;", "fragment", "Landroidx/fragment/app/Fragment;", "FishBun_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: FishBun.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        @JvmStatic
        public final FishBun with(Activity activity) {
            Intrinsics.checkParameterIsNotNull(activity, "activity");
            return new FishBun(activity, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final FishBun with(Fragment fragment) {
            Intrinsics.checkParameterIsNotNull(fragment, "fragment");
            return new FishBun(fragment.getActivity(), (DefaultConstructorMarker) null);
        }
    }
}
