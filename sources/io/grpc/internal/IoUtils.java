package io.grpc.internal;

import com.google.common.base.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class IoUtils {
    private static final int MAX_BUFFER_LENGTH = 16384;

    public static byte[] toByteArray(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        copy(in, out);
        return out.toByteArray();
    }

    public static long copy(InputStream from, OutputStream to) throws IOException {
        Preconditions.checkNotNull(from);
        Preconditions.checkNotNull(to);
        byte[] buf = new byte[16384];
        long total = 0;
        while (true) {
            int r = from.read(buf);
            if (r == -1) {
                return total;
            }
            to.write(buf, 0, r);
            total += (long) r;
        }
    }
}
