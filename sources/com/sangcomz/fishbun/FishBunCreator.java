package com.sangcomz.fishbun;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.sangcomz.fishbun.bean.Album;
import com.sangcomz.fishbun.define.Define;
import com.sangcomz.fishbun.ui.album.AlbumActivity;
import com.sangcomz.fishbun.ui.picker.PickerActivity;
import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0016J \u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u0012\u0010\u0012\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tH\u0016J\u0010\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u0010\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\tH\u0016J\u0010\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\tH\u0016J\u0012\u0010\u001e\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010!\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\fH\u0016J\u0010\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\fH\u0016J\u0012\u0010'\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010(\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\fH\u0016J\u0010\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\fH\u0016J\u0010\u0010-\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\fH\u0016J\u0010\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\tH\u0016J\u0012\u00100\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u00102\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u00020\tH\u0016J\u0010\u00105\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\tH\u0016J\u0010\u00106\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\tH\u0017J\u0010\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u00020\tH\u0016J\u0010\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\fH\u0016J\u0010\u0010;\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\tH\u0016J\u0016\u0010>\u001a\u00020\u00002\f\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@H\u0016J\b\u0010B\u001a\u00020CH\u0016J\u0012\u0010D\u001a\u00020\u00002\b\u0010E\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010F\u001a\u00020\u00002\b\u0010E\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/sangcomz/fishbun/FishBunCreator;", "Lcom/sangcomz/fishbun/BaseProperty;", "Lcom/sangcomz/fishbun/CustomizationProperty;", "fishBun", "Lcom/sangcomz/fishbun/FishBun;", "fishton", "Lcom/sangcomz/fishbun/Fishton;", "(Lcom/sangcomz/fishbun/FishBun;Lcom/sangcomz/fishbun/Fishton;)V", "requestCode", "", "exceptGif", "isExcept", "", "isStartInAllView", "setActionBarColor", "actionbarColor", "statusBarColor", "isStatusBarLight", "setActionBarTitle", "actionBarTitle", "", "setActionBarTitleColor", "actionbarTitleColor", "setAlbumSpanCount", "portraitSpanCount", "landscapeSpanCount", "setAlbumSpanCountOnlPortrait", "setAlbumSpanCountOnlyLandscape", "setAlbumThumbnailSize", "size", "setAllDoneButtonDrawable", "icon", "Landroid/graphics/drawable/Drawable;", "setAllViewTitle", "allViewTitle", "setButtonInAlbumActivity", "isButton", "setCamera", "isCamera", "setDoneButtonDrawable", "setHomeAsUpIndicatorDrawable", "setIsShowCount", "isShow", "setIsUseAllDoneButton", "isUse", "setIsUseDetailView", "setMaxCount", "count", "setMenuAllDoneText", "text", "setMenuDoneText", "setMenuTextColor", "color", "setMinCount", "setPickerCount", "setPickerSpanCount", "spanCount", "setReachLimitAutomaticClose", "isAutomaticClose", "setRequestCode", "setSelectCircleStrokeColor", "strokeColor", "setSelectedImages", "selectedImages", "Ljava/util/ArrayList;", "Landroid/net/Uri;", "startAlbum", "", "textOnImagesSelectionLimitReached", "message", "textOnNothingSelected", "FishBun_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: FishBunCreator.kt */
public final class FishBunCreator implements BaseProperty, CustomizationProperty {
    private final FishBun fishBun;
    private final Fishton fishton;
    private int requestCode = 27;

    public FishBunCreator(FishBun fishBun2, Fishton fishton2) {
        Intrinsics.checkParameterIsNotNull(fishBun2, "fishBun");
        Intrinsics.checkParameterIsNotNull(fishton2, "fishton");
        this.fishBun = fishBun2;
        this.fishton = fishton2;
    }

    public FishBunCreator setSelectedImages(ArrayList<Uri> selectedImages) {
        Intrinsics.checkParameterIsNotNull(selectedImages, "selectedImages");
        this.fishton.setSelectedImages(selectedImages);
        return this;
    }

    public FishBunCreator setAlbumThumbnailSize(int size) {
        this.fishton.setAlbumThumbnailSize(size);
        return this;
    }

    public FishBunCreator setPickerSpanCount(int spanCount) {
        this.fishton.setPhotoSpanCount(spanCount <= 0 ? 3 : spanCount);
        return this;
    }

    @Deprecated(message = "instead setMaxCount(count)", replaceWith = @ReplaceWith(expression = "setMaxCount(count)", imports = {}))
    public FishBunCreator setPickerCount(int count) {
        setMaxCount(count);
        return this;
    }

    public FishBunCreator setMaxCount(int count) {
        this.fishton.setMaxCount(count <= 0 ? 1 : count);
        return this;
    }

    public FishBunCreator setMinCount(int count) {
        this.fishton.setMinCount(count <= 0 ? 1 : count);
        return this;
    }

    public FishBunCreator setActionBarTitleColor(int actionbarTitleColor) {
        this.fishton.setColorActionBarTitle(actionbarTitleColor);
        return this;
    }

    public FishBunCreator setActionBarColor(int actionbarColor) {
        this.fishton.setColorActionBar(actionbarColor);
        return this;
    }

    public FishBunCreator setActionBarColor(int actionbarColor, int statusBarColor) {
        FishBunCreator $this$apply = this;
        $this$apply.fishton.setColorActionBar(actionbarColor);
        $this$apply.fishton.setColorStatusBar(statusBarColor);
        return this;
    }

    public FishBunCreator setActionBarColor(int actionbarColor, int statusBarColor, boolean isStatusBarLight) {
        FishBunCreator $this$apply = this;
        $this$apply.fishton.setColorActionBar(actionbarColor);
        $this$apply.fishton.setColorStatusBar(statusBarColor);
        $this$apply.fishton.setStatusBarLight(isStatusBarLight);
        return this;
    }

    public FishBunCreator setCamera(boolean isCamera) {
        this.fishton.setCamera(isCamera);
        return this;
    }

    public FishBunCreator setRequestCode(int requestCode2) {
        this.requestCode = requestCode2;
        return this;
    }

    public FishBunCreator textOnNothingSelected(String message) {
        this.fishton.setMessageNothingSelected(message);
        return this;
    }

    public FishBunCreator textOnImagesSelectionLimitReached(String message) {
        this.fishton.setMessageLimitReached(message);
        return this;
    }

    public FishBunCreator setButtonInAlbumActivity(boolean isButton) {
        this.fishton.setButton(isButton);
        return this;
    }

    public FishBunCreator setReachLimitAutomaticClose(boolean isAutomaticClose) {
        this.fishton.setAutomaticClose(isAutomaticClose);
        return this;
    }

    public FishBunCreator setAlbumSpanCount(int portraitSpanCount, int landscapeSpanCount) {
        FishBunCreator $this$apply = this;
        $this$apply.fishton.setAlbumPortraitSpanCount(portraitSpanCount);
        $this$apply.fishton.setAlbumLandscapeSpanCount(landscapeSpanCount);
        return this;
    }

    public FishBunCreator setAlbumSpanCountOnlyLandscape(int landscapeSpanCount) {
        this.fishton.setAlbumLandscapeSpanCount(landscapeSpanCount);
        return this;
    }

    public FishBunCreator setAlbumSpanCountOnlPortrait(int portraitSpanCount) {
        this.fishton.setAlbumPortraitSpanCount(portraitSpanCount);
        return this;
    }

    public FishBunCreator setAllViewTitle(String allViewTitle) {
        this.fishton.setTitleAlbumAllView(allViewTitle);
        return this;
    }

    public FishBunCreator setActionBarTitle(String actionBarTitle) {
        this.fishton.setTitleActionBar(actionBarTitle);
        return this;
    }

    public FishBunCreator setHomeAsUpIndicatorDrawable(Drawable icon) {
        this.fishton.setDrawableHomeAsUpIndicator(icon);
        return this;
    }

    public FishBunCreator setDoneButtonDrawable(Drawable icon) {
        this.fishton.setDrawableDoneButton(icon);
        return this;
    }

    public FishBunCreator setAllDoneButtonDrawable(Drawable icon) {
        this.fishton.setDrawableAllDoneButton(icon);
        return this;
    }

    public FishBunCreator setIsUseAllDoneButton(boolean isUse) {
        this.fishton.setUseAllDoneButton(isUse);
        return this;
    }

    public FishBunCreator exceptGif(boolean isExcept) {
        this.fishton.setExceptGif(isExcept);
        return this;
    }

    public FishBunCreator setMenuDoneText(String text) {
        this.fishton.setStrDoneMenu(text);
        return this;
    }

    public FishBunCreator setMenuAllDoneText(String text) {
        this.fishton.setStrAllDoneMenu(text);
        return this;
    }

    public FishBunCreator setMenuTextColor(int color) {
        this.fishton.setColorTextMenu(color);
        return this;
    }

    public FishBunCreator setIsUseDetailView(boolean isUse) {
        this.fishton.setUseDetailView(isUse);
        return this;
    }

    public FishBunCreator setIsShowCount(boolean isShow) {
        this.fishton.setShowCount(isShow);
        return this;
    }

    public FishBunCreator setSelectCircleStrokeColor(int strokeColor) {
        this.fishton.setColorSelectCircleStroke(strokeColor);
        return this;
    }

    public FishBunCreator isStartInAllView(boolean isStartInAllView) {
        this.fishton.setStartInAllView(isStartInAllView);
        return this;
    }

    public void startAlbum() {
        Intent intent;
        Activity context = this.fishBun.getContext();
        if (context != null) {
            Fishton $this$with = this.fishton;
            $this$with.setDefaultMessage(context);
            $this$with.setMenuTextColor();
            $this$with.setDefaultDimen(context);
            if (this.fishton.isStartInAllView()) {
                intent = new Intent(context, PickerActivity.class);
                Intent $this$apply = intent;
                $this$apply.putExtra(Define.BUNDLE_NAME.ALBUM.name(), new Album(0, this.fishton.getTitleAlbumAllView(), (String) null, 0));
                $this$apply.putExtra(Define.BUNDLE_NAME.POSITION.name(), 0);
            } else {
                intent = new Intent(context, AlbumActivity.class);
            }
            context.startActivityForResult(intent, this.requestCode);
            return;
        }
        throw new NullPointerException("Activity or Fragment Null");
    }
}
