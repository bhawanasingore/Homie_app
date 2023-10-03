package com.sangcomz.fishbun.adapter.view;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.sangcomz.fishbun.Fishton;
import com.sangcomz.fishbun.R;
import com.sangcomz.fishbun.adapter.image.ImageAdapter;
import com.sangcomz.fishbun.util.TouchImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/sangcomz/fishbun/adapter/view/DetailViewPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "inflater", "Landroid/view/LayoutInflater;", "images", "", "Landroid/net/Uri;", "(Landroid/view/LayoutInflater;[Landroid/net/Uri;)V", "fishton", "Lcom/sangcomz/fishbun/Fishton;", "[Landroid/net/Uri;", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "targetObject", "", "getCount", "instantiateItem", "isViewFromObject", "", "view", "Landroid/view/View;", "FishBun_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: DetailViewPagerAdapter.kt */
public final class DetailViewPagerAdapter extends PagerAdapter {
    private final Fishton fishton = Fishton.Companion.getInstance();
    private final Uri[] images;
    private final LayoutInflater inflater;

    public DetailViewPagerAdapter(LayoutInflater inflater2, Uri[] images2) {
        Intrinsics.checkParameterIsNotNull(inflater2, "inflater");
        Intrinsics.checkParameterIsNotNull(images2, "images");
        this.inflater = inflater2;
        this.images = images2;
    }

    public Object instantiateItem(ViewGroup container, int position) {
        Intrinsics.checkParameterIsNotNull(container, "container");
        View itemView = this.inflater.inflate(R.layout.detail_item, container, false);
        container.addView(itemView);
        ImageAdapter imageAdapter = this.fishton.getImageAdapter();
        if (imageAdapter != null) {
            Intrinsics.checkExpressionValueIsNotNull(itemView, "itemView");
            TouchImageView touchImageView = (TouchImageView) itemView.findViewById(R.id.img_detail_image);
            Intrinsics.checkExpressionValueIsNotNull(touchImageView, "itemView.img_detail_image");
            imageAdapter.loadDetailImage(touchImageView, this.images[position]);
        }
        Intrinsics.checkExpressionValueIsNotNull(itemView, "itemView");
        return itemView;
    }

    public int getCount() {
        return this.images.length;
    }

    public void destroyItem(ViewGroup container, int position, Object targetObject) {
        Intrinsics.checkParameterIsNotNull(container, "container");
        Intrinsics.checkParameterIsNotNull(targetObject, "targetObject");
        if (container instanceof ViewPager) {
            container.removeView((ConstraintLayout) targetObject);
        }
    }

    public boolean isViewFromObject(View view, Object targetObject) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(targetObject, "targetObject");
        return Intrinsics.areEqual((Object) view, targetObject);
    }
}
