package com.sangcomz.fishbun.adapter.view;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.sangcomz.fishbun.Fishton;
import com.sangcomz.fishbun.R;
import com.sangcomz.fishbun.adapter.image.ImageAdapter;
import com.sangcomz.fishbun.bean.Album;
import com.sangcomz.fishbun.util.SquareImageView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016R0\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/sangcomz/fishbun/adapter/view/AlbumListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/sangcomz/fishbun/adapter/view/AlbumListAdapter$ViewHolder;", "()V", "value", "", "Lcom/sangcomz/fishbun/bean/Album;", "albumList", "getAlbumList", "()Ljava/util/List;", "setAlbumList", "(Ljava/util/List;)V", "fishton", "Lcom/sangcomz/fishbun/Fishton;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "FishBun_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: AlbumListAdapter.kt */
public final class AlbumListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<? extends Album> albumList = CollectionsKt.emptyList();
    private final Fishton fishton = Fishton.Companion.getInstance();

    public final List<Album> getAlbumList() {
        return this.albumList;
    }

    public final void setAlbumList(List<? extends Album> value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.albumList = value;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkParameterIsNotNull(parent, "parent");
        return new ViewHolder(parent, this.fishton.getAlbumThumbnailSize());
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        Uri uri = Uri.parse(((Album) this.albumList.get(position)).thumbnailPath);
        Intrinsics.checkExpressionValueIsNotNull(uri, "Uri.parse(albumList[position].thumbnailPath)");
        ImageAdapter imageAdapter = this.fishton.getImageAdapter();
        if (imageAdapter != null) {
            SquareImageView imgALbumThumb = holder.getImgALbumThumb();
            Intrinsics.checkExpressionValueIsNotNull(imgALbumThumb, "holder.imgALbumThumb");
            imageAdapter.loadImage(imgALbumThumb, uri);
        }
        View view = holder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
        view.setTag(this.albumList.get(position));
        TextView txtAlbumName = holder.getTxtAlbumName();
        Intrinsics.checkExpressionValueIsNotNull(txtAlbumName, "holder.txtAlbumName");
        txtAlbumName.setText(((Album) this.albumList.get(position)).bucketName);
        TextView txtAlbumCount = holder.getTxtAlbumCount();
        Intrinsics.checkExpressionValueIsNotNull(txtAlbumCount, "holder.txtAlbumCount");
        txtAlbumCount.setText(String.valueOf(((Album) this.albumList.get(position)).counter));
        holder.itemView.setOnClickListener(new AlbumListAdapter$onBindViewHolder$1(this, position));
    }

    public int getItemCount() {
        return this.albumList.size();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0019\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\n \t*\u0004\u0018\u00010\r0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0010\u001a\n \t*\u0004\u0018\u00010\r0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/sangcomz/fishbun/adapter/view/AlbumListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "albumSize", "", "(Landroid/view/ViewGroup;I)V", "imgALbumThumb", "Lcom/sangcomz/fishbun/util/SquareImageView;", "kotlin.jvm.PlatformType", "getImgALbumThumb", "()Lcom/sangcomz/fishbun/util/SquareImageView;", "txtAlbumCount", "Landroid/widget/TextView;", "getTxtAlbumCount", "()Landroid/widget/TextView;", "txtAlbumName", "getTxtAlbumName", "FishBun_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: AlbumListAdapter.kt */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final SquareImageView imgALbumThumb;
        private final TextView txtAlbumCount;
        private final TextView txtAlbumName;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(ViewGroup parent, int albumSize) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.album_item, parent, false));
            Intrinsics.checkParameterIsNotNull(parent, "parent");
            View view = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
            this.imgALbumThumb = (SquareImageView) view.findViewById(R.id.img_album_thumb);
            View view2 = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view2, "itemView");
            this.txtAlbumName = (TextView) view2.findViewById(R.id.txt_album_name);
            View view3 = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view3, "itemView");
            this.txtAlbumCount = (TextView) view3.findViewById(R.id.txt_album_count);
            SquareImageView squareImageView = this.imgALbumThumb;
            Intrinsics.checkExpressionValueIsNotNull(squareImageView, "imgALbumThumb");
            squareImageView.setLayoutParams(new LinearLayout.LayoutParams(albumSize, albumSize));
        }

        public final SquareImageView getImgALbumThumb() {
            return this.imgALbumThumb;
        }

        public final TextView getTxtAlbumName() {
            return this.txtAlbumName;
        }

        public final TextView getTxtAlbumCount() {
            return this.txtAlbumCount;
        }
    }
}
