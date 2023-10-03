package com.sangcomz.fishbun.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"GIF_PATTERN", "Lkotlin/text/Regex;", "checkGif", "", "path", "", "FishBun_release"}, k = 2, mv = {1, 1, 15})
/* compiled from: RegexUtil.kt */
public final class RegexUtil {
    private static final Regex GIF_PATTERN = new Regex("(.+?).gif$");

    public static final boolean checkGif(String path) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        return GIF_PATTERN.matches(path);
    }
}
