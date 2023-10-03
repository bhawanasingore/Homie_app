package com.sangcomz.fishbun.adapter.image;

import android.net.Uri;
import android.widget.ImageView;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/sangcomz/fishbun/adapter/image/ImageAdapter;", "", "loadDetailImage", "", "target", "Landroid/widget/ImageView;", "loadUrl", "Landroid/net/Uri;", "loadImage", "FishBun_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: ImageAdapter.kt */
public interface ImageAdapter {
    void loadDetailImage(ImageView imageView, Uri uri);

    void loadImage(ImageView imageView, Uri uri);
}
