package com.sangcomz.fishbun.adapter.image.impl;

import android.net.Uri;
import android.widget.ImageView;
import com.sangcomz.fishbun.adapter.image.ImageAdapter;
import com.squareup.picasso.Picasso;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/sangcomz/fishbun/adapter/image/impl/PicassoAdapter;", "Lcom/sangcomz/fishbun/adapter/image/ImageAdapter;", "()V", "loadDetailImage", "", "target", "Landroid/widget/ImageView;", "loadUrl", "Landroid/net/Uri;", "loadImage", "FishBun_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: PicassoAdapter.kt */
public final class PicassoAdapter implements ImageAdapter {
    public void loadImage(ImageView target, Uri loadUrl) {
        Intrinsics.checkParameterIsNotNull(target, "target");
        Intrinsics.checkParameterIsNotNull(loadUrl, "loadUrl");
        Picasso.with(target.getContext()).load(loadUrl).fit().centerCrop().into(target);
    }

    public void loadDetailImage(ImageView target, Uri loadUrl) {
        Intrinsics.checkParameterIsNotNull(target, "target");
        Intrinsics.checkParameterIsNotNull(loadUrl, "loadUrl");
        Picasso.with(target.getContext()).load(loadUrl).fit().centerInside().into(target);
    }
}
