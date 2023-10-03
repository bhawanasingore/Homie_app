package io.flutter.plugin.editing;

import io.flutter.embedding.engine.FlutterJNI;

class FlutterTextUtils {
    public static final int CANCEL_TAG = 917631;
    public static final int CARRIAGE_RETURN = 13;
    public static final int COMBINING_ENCLOSING_KEYCAP = 8419;
    public static final int LINE_FEED = 10;
    public static final int ZERO_WIDTH_JOINER = 8205;
    private final FlutterJNI flutterJNI;

    public FlutterTextUtils(FlutterJNI flutterJNI2) {
        this.flutterJNI = flutterJNI2;
    }

    public boolean isEmoji(int codePoint) {
        return this.flutterJNI.nativeFlutterTextUtilsIsEmoji(codePoint);
    }

    public boolean isEmojiModifier(int codePoint) {
        return this.flutterJNI.nativeFlutterTextUtilsIsEmojiModifier(codePoint);
    }

    public boolean isEmojiModifierBase(int codePoint) {
        return this.flutterJNI.nativeFlutterTextUtilsIsEmojiModifierBase(codePoint);
    }

    public boolean isVariationSelector(int codePoint) {
        return this.flutterJNI.nativeFlutterTextUtilsIsVariationSelector(codePoint);
    }

    public boolean isRegionalIndicatorSymbol(int codePoint) {
        return this.flutterJNI.nativeFlutterTextUtilsIsRegionalIndicator(codePoint);
    }

    public boolean isTagSpecChar(int codePoint) {
        return 917536 <= codePoint && codePoint <= 917630;
    }

    public boolean isKeycapBase(int codePoint) {
        return (48 <= codePoint && codePoint <= 57) || codePoint == 35 || codePoint == 42;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r2 = java.lang.Character.codePointBefore(r8, r9);
        r3 = java.lang.Character.charCount(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getOffsetBefore(java.lang.CharSequence r8, int r9) {
        /*
            r7 = this;
            r0 = 0
            r1 = 1
            if (r9 > r1) goto L_0x0005
            return r0
        L_0x0005:
            int r2 = java.lang.Character.codePointBefore(r8, r9)
            int r3 = java.lang.Character.charCount(r2)
            int r4 = r9 - r3
            if (r4 != 0) goto L_0x0012
            return r0
        L_0x0012:
            r0 = 10
            if (r2 != r0) goto L_0x0023
            int r0 = java.lang.Character.codePointBefore(r8, r4)
            r1 = 13
            if (r0 != r1) goto L_0x0020
            int r3 = r3 + 1
        L_0x0020:
            int r1 = r9 - r3
            return r1
        L_0x0023:
            boolean r0 = r7.isRegionalIndicatorSymbol(r2)
            if (r0 == 0) goto L_0x0050
            int r0 = java.lang.Character.codePointBefore(r8, r4)
            int r1 = java.lang.Character.charCount(r0)
            int r4 = r4 - r1
            r1 = 1
        L_0x0033:
            if (r4 <= 0) goto L_0x0047
            boolean r2 = r7.isRegionalIndicatorSymbol(r0)
            if (r2 == 0) goto L_0x0047
            int r0 = java.lang.Character.codePointBefore(r8, r4)
            int r2 = java.lang.Character.charCount(r0)
            int r4 = r4 - r2
            int r1 = r1 + 1
            goto L_0x0033
        L_0x0047:
            int r2 = r1 % 2
            if (r2 != 0) goto L_0x004d
            int r3 = r3 + 2
        L_0x004d:
            int r2 = r9 - r3
            return r2
        L_0x0050:
            r0 = 8419(0x20e3, float:1.1798E-41)
            if (r2 != r0) goto L_0x008a
            int r0 = java.lang.Character.codePointBefore(r8, r4)
            int r1 = java.lang.Character.charCount(r0)
            int r4 = r4 - r1
            if (r4 <= 0) goto L_0x007a
            boolean r1 = r7.isVariationSelector(r0)
            if (r1 == 0) goto L_0x007a
            int r1 = java.lang.Character.codePointBefore(r8, r4)
            boolean r2 = r7.isKeycapBase(r1)
            if (r2 == 0) goto L_0x0086
            int r2 = java.lang.Character.charCount(r0)
            int r5 = java.lang.Character.charCount(r1)
            int r2 = r2 + r5
            int r3 = r3 + r2
            goto L_0x0086
        L_0x007a:
            boolean r1 = r7.isKeycapBase(r0)
            if (r1 == 0) goto L_0x0086
            int r1 = java.lang.Character.charCount(r0)
            int r3 = r3 + r1
            goto L_0x0087
        L_0x0086:
        L_0x0087:
            int r1 = r9 - r3
            return r1
        L_0x008a:
            r0 = 917631(0xe007f, float:1.285875E-39)
            if (r2 != r0) goto L_0x00be
            int r0 = java.lang.Character.codePointBefore(r8, r4)
            int r2 = java.lang.Character.charCount(r0)
            int r4 = r4 - r2
            r2 = r0
        L_0x0099:
            if (r4 <= 0) goto L_0x00b0
            boolean r0 = r7.isTagSpecChar(r2)
            if (r0 == 0) goto L_0x00b0
            int r0 = java.lang.Character.charCount(r2)
            int r3 = r3 + r0
            int r2 = java.lang.Character.codePointBefore(r8, r4)
            int r0 = java.lang.Character.charCount(r2)
            int r4 = r4 - r0
            goto L_0x0099
        L_0x00b0:
            boolean r0 = r7.isEmoji(r2)
            if (r0 != 0) goto L_0x00b9
            int r0 = r9 + -2
            return r0
        L_0x00b9:
            int r0 = java.lang.Character.charCount(r2)
            int r3 = r3 + r0
        L_0x00be:
            boolean r0 = r7.isVariationSelector(r2)
            if (r0 == 0) goto L_0x00d7
            int r2 = java.lang.Character.codePointBefore(r8, r4)
            boolean r0 = r7.isEmoji(r2)
            if (r0 != 0) goto L_0x00d1
            int r0 = r9 - r3
            return r0
        L_0x00d1:
            int r0 = java.lang.Character.charCount(r2)
            int r3 = r3 + r0
            int r4 = r4 - r3
        L_0x00d7:
            boolean r0 = r7.isEmoji(r2)
            if (r0 == 0) goto L_0x0160
            r0 = 0
            r5 = 0
        L_0x00df:
            if (r0 == 0) goto L_0x00e9
            int r6 = java.lang.Character.charCount(r2)
            int r6 = r6 + r5
            int r6 = r6 + r1
            int r3 = r3 + r6
            r0 = 0
        L_0x00e9:
            r5 = 0
            boolean r6 = r7.isEmojiModifier(r2)
            if (r6 == 0) goto L_0x0127
            int r1 = java.lang.Character.codePointBefore(r8, r4)
            int r2 = java.lang.Character.charCount(r1)
            int r4 = r4 - r2
            if (r4 <= 0) goto L_0x0119
            boolean r2 = r7.isVariationSelector(r1)
            if (r2 == 0) goto L_0x0119
            int r1 = java.lang.Character.codePointBefore(r8, r4)
            boolean r2 = r7.isEmoji(r1)
            if (r2 != 0) goto L_0x010e
            int r2 = r9 - r3
            return r2
        L_0x010e:
            int r5 = java.lang.Character.charCount(r1)
            int r2 = java.lang.Character.charCount(r1)
            int r4 = r4 - r2
            r2 = r1
            goto L_0x011a
        L_0x0119:
            r2 = r1
        L_0x011a:
            boolean r1 = r7.isEmojiModifierBase(r2)
            if (r1 == 0) goto L_0x0160
            int r1 = java.lang.Character.charCount(r2)
            int r1 = r1 + r5
            int r3 = r3 + r1
            goto L_0x0160
        L_0x0127:
            if (r4 <= 0) goto L_0x0155
            int r2 = java.lang.Character.codePointBefore(r8, r4)
            int r6 = java.lang.Character.charCount(r2)
            int r4 = r4 - r6
            r6 = 8205(0x200d, float:1.1498E-41)
            if (r2 != r6) goto L_0x0155
            r0 = 1
            int r2 = java.lang.Character.codePointBefore(r8, r4)
            int r6 = java.lang.Character.charCount(r2)
            int r4 = r4 - r6
            if (r4 <= 0) goto L_0x0155
            boolean r6 = r7.isVariationSelector(r2)
            if (r6 == 0) goto L_0x0155
            int r2 = java.lang.Character.codePointBefore(r8, r4)
            int r5 = java.lang.Character.charCount(r2)
            int r6 = java.lang.Character.charCount(r2)
            int r4 = r4 - r6
        L_0x0155:
            if (r4 != 0) goto L_0x0158
            goto L_0x0160
        L_0x0158:
            if (r0 == 0) goto L_0x0160
            boolean r6 = r7.isEmoji(r2)
            if (r6 != 0) goto L_0x00df
        L_0x0160:
            int r0 = r9 - r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.editing.FlutterTextUtils.getOffsetBefore(java.lang.CharSequence, int):int");
    }

    public int getOffsetAfter(CharSequence text, int offset) {
        int len = text.length();
        if (offset >= len - 1) {
            return len;
        }
        int codePoint = Character.codePointAt(text, offset);
        int nextCharCount = Character.charCount(codePoint);
        int nextOffset = offset + nextCharCount;
        if (nextOffset == 0) {
            return 0;
        }
        if (codePoint == 10) {
            if (Character.codePointAt(text, nextOffset) == 13) {
                nextCharCount++;
            }
            return offset + nextCharCount;
        } else if (!isRegionalIndicatorSymbol(codePoint)) {
            if (isKeycapBase(codePoint)) {
                nextCharCount += Character.charCount(codePoint);
            }
            if (codePoint == 8419) {
                int codePoint2 = Character.codePointBefore(text, nextOffset);
                int nextOffset2 = nextOffset + Character.charCount(codePoint2);
                if (nextOffset2 < len && isVariationSelector(codePoint2)) {
                    int tmpCodePoint = Character.codePointAt(text, nextOffset2);
                    if (isKeycapBase(tmpCodePoint)) {
                        nextCharCount += Character.charCount(codePoint2) + Character.charCount(tmpCodePoint);
                    }
                } else if (isKeycapBase(codePoint2) != 0) {
                    nextCharCount += Character.charCount(codePoint2);
                }
                return offset + nextCharCount;
            }
            if (isEmoji(codePoint)) {
                boolean isZwj = false;
                int lastSeenVariantSelectorCharCount = 0;
                while (true) {
                    if (isZwj) {
                        nextCharCount += Character.charCount(codePoint) + lastSeenVariantSelectorCharCount + 1;
                        isZwj = false;
                    }
                    lastSeenVariantSelectorCharCount = 0;
                    if (isEmojiModifier(codePoint)) {
                        break;
                    }
                    if (nextOffset < len) {
                        codePoint = Character.codePointAt(text, nextOffset);
                        nextOffset += Character.charCount(codePoint);
                        if (codePoint == 8419) {
                            int codePoint3 = Character.codePointBefore(text, nextOffset);
                            int nextOffset3 = nextOffset + Character.charCount(codePoint3);
                            if (nextOffset3 < len && isVariationSelector(codePoint3)) {
                                int tmpCodePoint2 = Character.codePointAt(text, nextOffset3);
                                if (isKeycapBase(tmpCodePoint2)) {
                                    nextCharCount += Character.charCount(codePoint3) + Character.charCount(tmpCodePoint2);
                                }
                            } else if (isKeycapBase(codePoint3) != 0) {
                                nextCharCount += Character.charCount(codePoint3);
                            }
                            return offset + nextCharCount;
                        } else if (isEmojiModifier(codePoint)) {
                            nextCharCount += Character.charCount(codePoint) + 0;
                            break;
                        } else if (isVariationSelector(codePoint)) {
                            nextCharCount += Character.charCount(codePoint) + 0;
                            break;
                        } else if (codePoint == 8205) {
                            isZwj = true;
                            codePoint = Character.codePointAt(text, nextOffset);
                            nextOffset += Character.charCount(codePoint);
                            if (nextOffset < len && isVariationSelector(codePoint)) {
                                codePoint = Character.codePointAt(text, nextOffset);
                                lastSeenVariantSelectorCharCount = Character.charCount(codePoint);
                                nextOffset += Character.charCount(codePoint);
                            }
                        }
                    }
                    if (nextOffset < len) {
                        if (isZwj) {
                            if (!isEmoji(codePoint)) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            return offset + nextCharCount;
        } else if (nextOffset >= len - 1 || !isRegionalIndicatorSymbol(Character.codePointAt(text, nextOffset))) {
            return offset + nextCharCount;
        } else {
            int regionalIndicatorSymbolCount = 0;
            int regionOffset = offset;
            while (regionOffset > 0 && isRegionalIndicatorSymbol(Character.codePointBefore(text, offset))) {
                regionOffset -= Character.charCount(Character.codePointBefore(text, offset));
                regionalIndicatorSymbolCount++;
            }
            if (regionalIndicatorSymbolCount % 2 == 0) {
                nextCharCount += 2;
            }
            return offset + nextCharCount;
        }
    }
}
