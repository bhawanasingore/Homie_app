package com.sangcomz.fishbun.adapter.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.sangcomz.fishbun.define.Define;
import com.sangcomz.fishbun.ui.picker.PickerActivity;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 15})
/* compiled from: AlbumListAdapter.kt */
final class AlbumListAdapter$onBindViewHolder$1 implements View.OnClickListener {
    final /* synthetic */ int $position;
    final /* synthetic */ AlbumListAdapter this$0;

    AlbumListAdapter$onBindViewHolder$1(AlbumListAdapter albumListAdapter, int i) {
        this.this$0 = albumListAdapter;
        this.$position = i;
    }

    public final void onClick(View it) {
        Intrinsics.checkExpressionValueIsNotNull(it, "it");
        Intent intent = new Intent(it.getContext(), PickerActivity.class);
        Intent $this$apply = intent;
        $this$apply.putExtra(Define.BUNDLE_NAME.ALBUM.name(), this.this$0.getAlbumList().get(this.$position));
        $this$apply.putExtra(Define.BUNDLE_NAME.POSITION.name(), this.$position);
        Context context = it.getContext();
        if (context != null) {
            ((Activity) context).startActivityForResult(intent, new Define().ENTER_ALBUM_REQUEST_CODE);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
    }
}
