package io.opencensus.internal;

import java.util.List;
import javax.annotation.Nullable;

public final class Utils {
    private Utils() {
    }

    public static void checkArgument(boolean isValid, @Nullable Object errorMessage) {
        if (!isValid) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
    }

    public static void checkArgument(boolean expression, String errorMessageTemplate, @Nullable Object... errorMessageArgs) {
        if (!expression) {
            throw new IllegalArgumentException(format(errorMessageTemplate, errorMessageArgs));
        }
    }

    public static void checkState(boolean isValid, @Nullable Object errorMessage) {
        if (!isValid) {
            throw new IllegalStateException(String.valueOf(errorMessage));
        }
    }

    public static void checkIndex(int index, int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Negative size: " + size);
        } else if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: size=" + size + ", index=" + index);
        }
    }

    public static <T> T checkNotNull(T arg, @Nullable Object errorMessage) {
        if (arg != null) {
            return arg;
        }
        throw new NullPointerException(String.valueOf(errorMessage));
    }

    public static <T> void checkListElementNotNull(List<T> list, @Nullable Object errorMessage) {
        for (T element : list) {
            if (element == null) {
                throw new NullPointerException(String.valueOf(errorMessage));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <K, V> void checkMapElementNotNull(java.util.Map<K, V> r3, @javax.annotation.Nullable java.lang.Object r4) {
        /*
            java.util.Set r0 = r3.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x002b
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            if (r2 == 0) goto L_0x0021
            java.lang.Object r2 = r1.getValue()
            if (r2 == 0) goto L_0x0021
            goto L_0x0008
        L_0x0021:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r2 = java.lang.String.valueOf(r4)
            r0.<init>(r2)
            throw r0
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.opencensus.internal.Utils.checkMapElementNotNull(java.util.Map, java.lang.Object):void");
    }

    public static boolean equalsObjects(@Nullable Object x, @Nullable Object y) {
        if (x == null) {
            return y == null;
        }
        return x.equals(y);
    }

    private static String format(String template, @Nullable Object... args) {
        int placeholderStart;
        if (args == null) {
            return template;
        }
        StringBuilder builder = new StringBuilder(template.length() + (args.length * 16));
        int templateStart = 0;
        int i = 0;
        while (i < args.length && (placeholderStart = template.indexOf("%s", templateStart)) != -1) {
            builder.append(template, templateStart, placeholderStart);
            builder.append(args[i]);
            templateStart = placeholderStart + 2;
            i++;
        }
        builder.append(template, templateStart, template.length());
        if (i < args.length) {
            builder.append(" [");
            int i2 = i + 1;
            builder.append(args[i]);
            while (true) {
                int i3 = i2;
                if (i3 >= args.length) {
                    break;
                }
                builder.append(", ");
                i2 = i3 + 1;
                builder.append(args[i3]);
            }
            builder.append(']');
        }
        return builder.toString();
    }
}
