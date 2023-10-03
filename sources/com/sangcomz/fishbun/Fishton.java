package com.sangcomz.fishbun;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.core.view.ViewCompat;
import com.sangcomz.fishbun.adapter.image.ImageAdapter;
import com.sangcomz.fishbun.util.UiUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 y2\u00020\u0001:\u0002yzB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010q\u001a\u00020rH\u0002J\u0006\u0010s\u001a\u00020rJ\u000e\u0010t\u001a\u00020r2\u0006\u0010u\u001a\u00020vJ\u000e\u0010w\u001a\u00020r2\u0006\u0010u\u001a\u00020vJ\u0006\u0010x\u001a\u00020rR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001c\u0010'\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00102\"\u0004\b6\u00104R\u001a\u00107\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00102\"\u0004\b8\u00104R\u001a\u00109\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00102\"\u0004\b:\u00104R\u001a\u0010;\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00102\"\u0004\b<\u00104R\u001a\u0010=\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00102\"\u0004\b>\u00104R\u001a\u0010?\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00102\"\u0004\b@\u00104R\u001a\u0010A\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00102\"\u0004\bB\u00104R\u001a\u0010C\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u00102\"\u0004\bD\u00104R\u001a\u0010E\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\bR\u001c\u0010H\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001c\u0010N\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010K\"\u0004\bP\u0010MR\u001a\u0010Q\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0006\"\u0004\bS\u0010\bR\u001a\u0010T\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0006\"\u0004\bV\u0010\bR$\u0010W\u001a\n\u0012\u0004\u0012\u00020Y\u0018\u00010XX\u000e¢\u0006\u0010\n\u0002\u0010^\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R \u0010_\u001a\b\u0012\u0004\u0012\u00020Y0`X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001c\u0010e\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010K\"\u0004\bg\u0010MR\u001c\u0010h\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010K\"\u0004\bj\u0010MR\u001c\u0010k\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010K\"\u0004\bm\u0010MR\u001c\u0010n\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010K\"\u0004\bp\u0010M¨\u0006{"}, d2 = {"Lcom/sangcomz/fishbun/Fishton;", "", "()V", "albumLandscapeSpanCount", "", "getAlbumLandscapeSpanCount", "()I", "setAlbumLandscapeSpanCount", "(I)V", "albumPortraitSpanCount", "getAlbumPortraitSpanCount", "setAlbumPortraitSpanCount", "albumThumbnailSize", "getAlbumThumbnailSize", "setAlbumThumbnailSize", "colorActionBar", "getColorActionBar", "setColorActionBar", "colorActionBarTitle", "getColorActionBarTitle", "setColorActionBarTitle", "colorSelectCircleStroke", "getColorSelectCircleStroke", "setColorSelectCircleStroke", "colorStatusBar", "getColorStatusBar", "setColorStatusBar", "colorTextMenu", "getColorTextMenu", "setColorTextMenu", "drawableAllDoneButton", "Landroid/graphics/drawable/Drawable;", "getDrawableAllDoneButton", "()Landroid/graphics/drawable/Drawable;", "setDrawableAllDoneButton", "(Landroid/graphics/drawable/Drawable;)V", "drawableDoneButton", "getDrawableDoneButton", "setDrawableDoneButton", "drawableHomeAsUpIndicator", "getDrawableHomeAsUpIndicator", "setDrawableHomeAsUpIndicator", "imageAdapter", "Lcom/sangcomz/fishbun/adapter/image/ImageAdapter;", "getImageAdapter", "()Lcom/sangcomz/fishbun/adapter/image/ImageAdapter;", "setImageAdapter", "(Lcom/sangcomz/fishbun/adapter/image/ImageAdapter;)V", "isAutomaticClose", "", "()Z", "setAutomaticClose", "(Z)V", "isButton", "setButton", "isCamera", "setCamera", "isExceptGif", "setExceptGif", "isShowCount", "setShowCount", "isStartInAllView", "setStartInAllView", "isStatusBarLight", "setStatusBarLight", "isUseAllDoneButton", "setUseAllDoneButton", "isUseDetailView", "setUseDetailView", "maxCount", "getMaxCount", "setMaxCount", "messageLimitReached", "", "getMessageLimitReached", "()Ljava/lang/String;", "setMessageLimitReached", "(Ljava/lang/String;)V", "messageNothingSelected", "getMessageNothingSelected", "setMessageNothingSelected", "minCount", "getMinCount", "setMinCount", "photoSpanCount", "getPhotoSpanCount", "setPhotoSpanCount", "pickerImages", "", "Landroid/net/Uri;", "getPickerImages", "()[Landroid/net/Uri;", "setPickerImages", "([Landroid/net/Uri;)V", "[Landroid/net/Uri;", "selectedImages", "Ljava/util/ArrayList;", "getSelectedImages", "()Ljava/util/ArrayList;", "setSelectedImages", "(Ljava/util/ArrayList;)V", "strAllDoneMenu", "getStrAllDoneMenu", "setStrAllDoneMenu", "strDoneMenu", "getStrDoneMenu", "setStrDoneMenu", "titleActionBar", "getTitleActionBar", "setTitleActionBar", "titleAlbumAllView", "getTitleAlbumAllView", "setTitleAlbumAllView", "init", "", "refresh", "setDefaultDimen", "context", "Landroid/content/Context;", "setDefaultMessage", "setMenuTextColor", "Companion", "FishtonHolder", "FishBun_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: Fishton.kt */
public final class Fishton {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private int albumLandscapeSpanCount;
    private int albumPortraitSpanCount;
    private int albumThumbnailSize;
    private int colorActionBar;
    private int colorActionBarTitle;
    private int colorSelectCircleStroke;
    private int colorStatusBar;
    private int colorTextMenu;
    private Drawable drawableAllDoneButton;
    private Drawable drawableDoneButton;
    private Drawable drawableHomeAsUpIndicator;
    private ImageAdapter imageAdapter;
    private boolean isAutomaticClose;
    private boolean isButton;
    private boolean isCamera;
    private boolean isExceptGif;
    private boolean isShowCount;
    private boolean isStartInAllView;
    private boolean isStatusBarLight;
    private boolean isUseAllDoneButton;
    private boolean isUseDetailView;
    private int maxCount;
    private String messageLimitReached;
    private String messageNothingSelected;
    private int minCount;
    private int photoSpanCount;
    private Uri[] pickerImages;
    private ArrayList<Uri> selectedImages = new ArrayList<>();
    private String strAllDoneMenu;
    private String strDoneMenu;
    private String titleActionBar;
    private String titleAlbumAllView;

    @JvmStatic
    public static final Fishton getInstance() {
        return Companion.getInstance();
    }

    public Fishton() {
        init();
    }

    public final ImageAdapter getImageAdapter() {
        return this.imageAdapter;
    }

    public final void setImageAdapter(ImageAdapter imageAdapter2) {
        this.imageAdapter = imageAdapter2;
    }

    public final Uri[] getPickerImages() {
        return this.pickerImages;
    }

    public final void setPickerImages(Uri[] uriArr) {
        this.pickerImages = uriArr;
    }

    public final int getMaxCount() {
        return this.maxCount;
    }

    public final void setMaxCount(int i) {
        this.maxCount = i;
    }

    public final int getMinCount() {
        return this.minCount;
    }

    public final void setMinCount(int i) {
        this.minCount = i;
    }

    public final boolean isExceptGif() {
        return this.isExceptGif;
    }

    public final void setExceptGif(boolean z) {
        this.isExceptGif = z;
    }

    public final ArrayList<Uri> getSelectedImages() {
        return this.selectedImages;
    }

    public final void setSelectedImages(ArrayList<Uri> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.selectedImages = arrayList;
    }

    public final int getPhotoSpanCount() {
        return this.photoSpanCount;
    }

    public final void setPhotoSpanCount(int i) {
        this.photoSpanCount = i;
    }

    public final int getAlbumPortraitSpanCount() {
        return this.albumPortraitSpanCount;
    }

    public final void setAlbumPortraitSpanCount(int i) {
        this.albumPortraitSpanCount = i;
    }

    public final int getAlbumLandscapeSpanCount() {
        return this.albumLandscapeSpanCount;
    }

    public final void setAlbumLandscapeSpanCount(int i) {
        this.albumLandscapeSpanCount = i;
    }

    public final boolean isAutomaticClose() {
        return this.isAutomaticClose;
    }

    public final void setAutomaticClose(boolean z) {
        this.isAutomaticClose = z;
    }

    public final boolean isButton() {
        return this.isButton;
    }

    public final void setButton(boolean z) {
        this.isButton = z;
    }

    public final int getColorActionBar() {
        return this.colorActionBar;
    }

    public final void setColorActionBar(int i) {
        this.colorActionBar = i;
    }

    public final int getColorActionBarTitle() {
        return this.colorActionBarTitle;
    }

    public final void setColorActionBarTitle(int i) {
        this.colorActionBarTitle = i;
    }

    public final int getColorStatusBar() {
        return this.colorStatusBar;
    }

    public final void setColorStatusBar(int i) {
        this.colorStatusBar = i;
    }

    public final boolean isStatusBarLight() {
        return this.isStatusBarLight;
    }

    public final void setStatusBarLight(boolean z) {
        this.isStatusBarLight = z;
    }

    public final boolean isCamera() {
        return this.isCamera;
    }

    public final void setCamera(boolean z) {
        this.isCamera = z;
    }

    public final int getAlbumThumbnailSize() {
        return this.albumThumbnailSize;
    }

    public final void setAlbumThumbnailSize(int i) {
        this.albumThumbnailSize = i;
    }

    public final String getMessageNothingSelected() {
        return this.messageNothingSelected;
    }

    public final void setMessageNothingSelected(String str) {
        this.messageNothingSelected = str;
    }

    public final String getMessageLimitReached() {
        return this.messageLimitReached;
    }

    public final void setMessageLimitReached(String str) {
        this.messageLimitReached = str;
    }

    public final String getTitleAlbumAllView() {
        return this.titleAlbumAllView;
    }

    public final void setTitleAlbumAllView(String str) {
        this.titleAlbumAllView = str;
    }

    public final String getTitleActionBar() {
        return this.titleActionBar;
    }

    public final void setTitleActionBar(String str) {
        this.titleActionBar = str;
    }

    public final Drawable getDrawableHomeAsUpIndicator() {
        return this.drawableHomeAsUpIndicator;
    }

    public final void setDrawableHomeAsUpIndicator(Drawable drawable) {
        this.drawableHomeAsUpIndicator = drawable;
    }

    public final Drawable getDrawableDoneButton() {
        return this.drawableDoneButton;
    }

    public final void setDrawableDoneButton(Drawable drawable) {
        this.drawableDoneButton = drawable;
    }

    public final Drawable getDrawableAllDoneButton() {
        return this.drawableAllDoneButton;
    }

    public final void setDrawableAllDoneButton(Drawable drawable) {
        this.drawableAllDoneButton = drawable;
    }

    public final boolean isUseAllDoneButton() {
        return this.isUseAllDoneButton;
    }

    public final void setUseAllDoneButton(boolean z) {
        this.isUseAllDoneButton = z;
    }

    public final String getStrDoneMenu() {
        return this.strDoneMenu;
    }

    public final void setStrDoneMenu(String str) {
        this.strDoneMenu = str;
    }

    public final String getStrAllDoneMenu() {
        return this.strAllDoneMenu;
    }

    public final void setStrAllDoneMenu(String str) {
        this.strAllDoneMenu = str;
    }

    public final int getColorTextMenu() {
        return this.colorTextMenu;
    }

    public final void setColorTextMenu(int i) {
        this.colorTextMenu = i;
    }

    public final boolean isUseDetailView() {
        return this.isUseDetailView;
    }

    public final void setUseDetailView(boolean z) {
        this.isUseDetailView = z;
    }

    public final boolean isShowCount() {
        return this.isShowCount;
    }

    public final void setShowCount(boolean z) {
        this.isShowCount = z;
    }

    public final int getColorSelectCircleStroke() {
        return this.colorSelectCircleStroke;
    }

    public final void setColorSelectCircleStroke(int i) {
        this.colorSelectCircleStroke = i;
    }

    public final boolean isStartInAllView() {
        return this.isStartInAllView;
    }

    public final void setStartInAllView(boolean z) {
        this.isStartInAllView = z;
    }

    public final void refresh() {
        init();
    }

    private final void init() {
        this.imageAdapter = null;
        this.maxCount = 10;
        this.minCount = 1;
        this.isExceptGif = true;
        this.selectedImages = new ArrayList<>();
        this.photoSpanCount = 3;
        this.albumPortraitSpanCount = 1;
        this.albumLandscapeSpanCount = 2;
        this.isAutomaticClose = false;
        this.isButton = false;
        this.colorActionBar = Color.parseColor("#3F51B5");
        this.colorActionBarTitle = Color.parseColor("#ffffff");
        this.colorStatusBar = Color.parseColor("#303F9F");
        this.isStatusBarLight = false;
        this.isCamera = false;
        this.albumThumbnailSize = Integer.MAX_VALUE;
        Drawable drawable = null;
        this.drawableHomeAsUpIndicator = drawable;
        this.drawableDoneButton = drawable;
        this.drawableAllDoneButton = drawable;
        String str = null;
        this.strDoneMenu = str;
        this.strAllDoneMenu = str;
        this.colorTextMenu = Integer.MAX_VALUE;
        this.isUseAllDoneButton = false;
        this.isUseDetailView = true;
        this.isShowCount = true;
        this.colorSelectCircleStroke = Color.parseColor("#c1ffffff");
        this.isStartInAllView = false;
    }

    public final void setDefaultMessage(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        String str = this.messageNothingSelected;
        if (str == null) {
            str = context.getString(R.string.msg_no_selected);
        }
        this.messageNothingSelected = str;
        String str2 = this.messageLimitReached;
        if (str2 == null) {
            str2 = context.getString(R.string.msg_full_image);
        }
        this.messageLimitReached = str2;
        String str3 = this.titleAlbumAllView;
        if (str3 == null) {
            str3 = context.getString(R.string.str_all_view);
        }
        this.titleAlbumAllView = str3;
        String str4 = this.titleActionBar;
        if (str4 == null) {
            str4 = context.getString(R.string.album);
        }
        this.titleActionBar = str4;
    }

    public final void setMenuTextColor() {
        int i;
        if (this.drawableDoneButton == null && this.drawableAllDoneButton == null && this.strDoneMenu != null && (i = this.colorTextMenu) == Integer.MAX_VALUE) {
            if (this.isStatusBarLight) {
                i = ViewCompat.MEASURED_STATE_MASK;
            }
            this.colorTextMenu = i;
        }
    }

    public final void setDefaultDimen(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        int i = this.albumThumbnailSize;
        if (i == Integer.MAX_VALUE) {
            i = UiUtil.getDimension(context, R.dimen.album_thum_size);
        }
        this.albumThumbnailSize = i;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/sangcomz/fishbun/Fishton$FishtonHolder;", "", "()V", "INSTANCE", "Lcom/sangcomz/fishbun/Fishton;", "getINSTANCE", "()Lcom/sangcomz/fishbun/Fishton;", "FishBun_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: Fishton.kt */
    private static final class FishtonHolder {
        public static final FishtonHolder INSTANCE = new FishtonHolder();

        /* renamed from: INSTANCE  reason: collision with other field name */
        private static final Fishton f0INSTANCE = new Fishton();

        private FishtonHolder() {
        }

        public final Fishton getINSTANCE() {
            return f0INSTANCE;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/sangcomz/fishbun/Fishton$Companion;", "", "()V", "getInstance", "Lcom/sangcomz/fishbun/Fishton;", "FishBun_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: Fishton.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        @JvmStatic
        public final Fishton getInstance() {
            return FishtonHolder.INSTANCE.getINSTANCE();
        }
    }
}
