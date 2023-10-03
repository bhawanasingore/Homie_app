package io.opencensus.trace;

import io.opencensus.internal.Utils;
import java.util.Arrays;

final class BigendianEncoding {
    private static final String ALPHABET = "0123456789abcdef";
    private static final int ASCII_CHARACTERS = 128;
    static final int BYTE_BASE16 = 2;
    private static final byte[] DECODING = buildDecodingArray();
    private static final char[] ENCODING = buildEncodingArray();
    static final int LONG_BASE16 = 16;
    static final int LONG_BYTES = 8;

    private static char[] buildEncodingArray() {
        char[] encoding = new char[512];
        for (int i = 0; i < 256; i++) {
            encoding[i] = ALPHABET.charAt(i >>> 4);
            encoding[i | 256] = ALPHABET.charAt(i & 15);
        }
        return encoding;
    }

    private static byte[] buildDecodingArray() {
        byte[] decoding = new byte[128];
        Arrays.fill(decoding, (byte) -1);
        for (int i = 0; i < ALPHABET.length(); i++) {
            decoding[ALPHABET.charAt(i)] = (byte) i;
        }
        return decoding;
    }

    static long longFromByteArray(byte[] bytes, int offset) {
        Utils.checkArgument(bytes.length >= offset + 8, "array too small");
        return ((((long) bytes[offset]) & 255) << 56) | ((((long) bytes[offset + 1]) & 255) << 48) | ((((long) bytes[offset + 2]) & 255) << 40) | ((((long) bytes[offset + 3]) & 255) << 32) | ((((long) bytes[offset + 4]) & 255) << 24) | ((((long) bytes[offset + 5]) & 255) << 16) | ((((long) bytes[offset + 6]) & 255) << 8) | (255 & ((long) bytes[offset + 7]));
    }

    static void longToByteArray(long value, byte[] dest, int destOffset) {
        Utils.checkArgument(dest.length >= destOffset + 8, "array too small");
        dest[destOffset + 7] = (byte) ((int) (value & 255));
        dest[destOffset + 6] = (byte) ((int) ((value >> 8) & 255));
        dest[destOffset + 5] = (byte) ((int) ((value >> 16) & 255));
        dest[destOffset + 4] = (byte) ((int) ((value >> 24) & 255));
        dest[destOffset + 3] = (byte) ((int) ((value >> 32) & 255));
        dest[destOffset + 2] = (byte) ((int) ((value >> 40) & 255));
        dest[destOffset + 1] = (byte) ((int) ((value >> 48) & 255));
        dest[destOffset] = (byte) ((int) ((value >> 56) & 255));
    }

    static long longFromBase16String(CharSequence chars, int offset) {
        Utils.checkArgument(chars.length() >= offset + 16, "chars too small");
        return ((((long) decodeByte(chars.charAt(offset), chars.charAt(offset + 1))) & 255) << 56) | ((((long) decodeByte(chars.charAt(offset + 2), chars.charAt(offset + 3))) & 255) << 48) | ((((long) decodeByte(chars.charAt(offset + 4), chars.charAt(offset + 5))) & 255) << 40) | ((((long) decodeByte(chars.charAt(offset + 6), chars.charAt(offset + 7))) & 255) << 32) | ((((long) decodeByte(chars.charAt(offset + 8), chars.charAt(offset + 9))) & 255) << 24) | ((((long) decodeByte(chars.charAt(offset + 10), chars.charAt(offset + 11))) & 255) << 16) | ((((long) decodeByte(chars.charAt(offset + 12), chars.charAt(offset + 13))) & 255) << 8) | (255 & ((long) decodeByte(chars.charAt(offset + 14), chars.charAt(offset + 15))));
    }

    static void longToBase16String(long value, char[] dest, int destOffset) {
        byteToBase16((byte) ((int) ((value >> 56) & 255)), dest, destOffset);
        byteToBase16((byte) ((int) ((value >> 48) & 255)), dest, destOffset + 2);
        byteToBase16((byte) ((int) ((value >> 40) & 255)), dest, destOffset + 4);
        byteToBase16((byte) ((int) ((value >> 32) & 255)), dest, destOffset + 6);
        byteToBase16((byte) ((int) ((value >> 24) & 255)), dest, destOffset + 8);
        byteToBase16((byte) ((int) ((value >> 16) & 255)), dest, destOffset + 10);
        byteToBase16((byte) ((int) ((value >> 8) & 255)), dest, destOffset + 12);
        byteToBase16((byte) ((int) (value & 255)), dest, destOffset + 14);
    }

    static void byteToBase16String(byte value, char[] dest, int destOffset) {
        byteToBase16(value, dest, destOffset);
    }

    static byte byteFromBase16String(CharSequence chars, int offset) {
        Utils.checkArgument(chars.length() >= offset + 2, "chars too small");
        return decodeByte(chars.charAt(offset), chars.charAt(offset + 1));
    }

    private static byte decodeByte(char hi, char lo) {
        boolean z = true;
        Utils.checkArgument(lo < 128 && DECODING[lo] != -1, "invalid character " + lo);
        if (hi >= 128 || DECODING[hi] == -1) {
            z = false;
        }
        Utils.checkArgument(z, "invalid character " + hi);
        byte[] bArr = DECODING;
        return (byte) (bArr[lo] | (bArr[hi] << 4));
    }

    private static void byteToBase16(byte value, char[] dest, int destOffset) {
        int b = value & 255;
        char[] cArr = ENCODING;
        dest[destOffset] = cArr[b];
        dest[destOffset + 1] = cArr[b | 256];
    }

    private BigendianEncoding() {
    }
}
