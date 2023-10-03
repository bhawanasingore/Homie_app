package com.sangcomz.fishbun;

import android.net.Uri;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\bH&J \u0010\u000f\u001a\u00020\u00032\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013H&J\b\u0010\u0014\u001a\u00020\u0015H&¨\u0006\u0016"}, d2 = {"Lcom/sangcomz/fishbun/BaseProperty;", "", "exceptGif", "Lcom/sangcomz/fishbun/FishBunCreator;", "isExcept", "", "setMaxCount", "count", "", "setMinCount", "setPickerCount", "setReachLimitAutomaticClose", "isAutomaticClose", "setRequestCode", "requestCode", "setSelectedImages", "selectedImages", "Ljava/util/ArrayList;", "Landroid/net/Uri;", "Lkotlin/collections/ArrayList;", "startAlbum", "", "FishBun_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: BaseProperty.kt */
public interface BaseProperty {
    FishBunCreator exceptGif(boolean z);

    FishBunCreator setMaxCount(int i);

    FishBunCreator setMinCount(int i);

    FishBunCreator setPickerCount(int i);

    FishBunCreator setReachLimitAutomaticClose(boolean z);

    FishBunCreator setRequestCode(int i);

    FishBunCreator setSelectedImages(ArrayList<Uri> arrayList);

    void startAlbum();
}
