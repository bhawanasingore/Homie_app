package com.sangcomz.fishbun.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\u0006\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/sangcomz/fishbun/util/SingleMediaScanner;", "Landroid/media/MediaScannerConnection$MediaScannerConnectionClient;", "context", "Landroid/content/Context;", "file", "Ljava/io/File;", "onScanCompleted", "Lkotlin/Function0;", "", "(Landroid/content/Context;Ljava/io/File;Lkotlin/jvm/functions/Function0;)V", "mediaScannerConnection", "Landroid/media/MediaScannerConnection;", "onMediaScannerConnected", "path", "", "uri", "Landroid/net/Uri;", "FishBun_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: SingleMediaScanner.kt */
public final class SingleMediaScanner implements MediaScannerConnection.MediaScannerConnectionClient {
    private final File file;
    private final MediaScannerConnection mediaScannerConnection;
    private final Function0<Unit> onScanCompleted;

    public SingleMediaScanner(Context context, File file2) {
        this(context, file2, (Function0) null, 4, (DefaultConstructorMarker) null);
    }

    public SingleMediaScanner(Context context, File file2, Function0<Unit> onScanCompleted2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(file2, "file");
        this.file = file2;
        this.onScanCompleted = onScanCompleted2;
        MediaScannerConnection mediaScannerConnection2 = new MediaScannerConnection(context, this);
        this.mediaScannerConnection = mediaScannerConnection2;
        mediaScannerConnection2.connect();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SingleMediaScanner(Context context, File file2, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, file2, (i & 4) != 0 ? null : function0);
    }

    public void onMediaScannerConnected() {
        this.mediaScannerConnection.scanFile(this.file.getAbsolutePath(), (String) null);
    }

    public void onScanCompleted(String path, Uri uri) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Function0<Unit> function0 = this.onScanCompleted;
        if (function0 != null) {
            Unit invoke = function0.invoke();
        }
        this.mediaScannerConnection.disconnect();
    }
}
