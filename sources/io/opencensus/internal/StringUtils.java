package io.opencensus.internal;

public final class StringUtils {
    public static boolean isPrintableString(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!isPrintableChar(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPrintableChar(char ch) {
        return ch >= ' ' && ch <= '~';
    }

    private StringUtils() {
    }
}
