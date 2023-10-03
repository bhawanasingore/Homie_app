package io.flutter.plugin.common;

import io.flutter.plugin.common.StandardMessageCodec;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class StandardMethodCodec implements MethodCodec {
    public static final StandardMethodCodec INSTANCE = new StandardMethodCodec(StandardMessageCodec.INSTANCE);
    private final StandardMessageCodec messageCodec;

    public StandardMethodCodec(StandardMessageCodec messageCodec2) {
        this.messageCodec = messageCodec2;
    }

    public ByteBuffer encodeMethodCall(MethodCall methodCall) {
        StandardMessageCodec.ExposedByteArrayOutputStream stream = new StandardMessageCodec.ExposedByteArrayOutputStream();
        this.messageCodec.writeValue(stream, methodCall.method);
        this.messageCodec.writeValue(stream, methodCall.arguments);
        ByteBuffer buffer = ByteBuffer.allocateDirect(stream.size());
        buffer.put(stream.buffer(), 0, stream.size());
        return buffer;
    }

    public MethodCall decodeMethodCall(ByteBuffer methodCall) {
        methodCall.order(ByteOrder.nativeOrder());
        Object method = this.messageCodec.readValue(methodCall);
        Object arguments = this.messageCodec.readValue(methodCall);
        if ((method instanceof String) && !methodCall.hasRemaining()) {
            return new MethodCall((String) method, arguments);
        }
        throw new IllegalArgumentException("Method call corrupted");
    }

    public ByteBuffer encodeSuccessEnvelope(Object result) {
        StandardMessageCodec.ExposedByteArrayOutputStream stream = new StandardMessageCodec.ExposedByteArrayOutputStream();
        stream.write(0);
        this.messageCodec.writeValue(stream, result);
        ByteBuffer buffer = ByteBuffer.allocateDirect(stream.size());
        buffer.put(stream.buffer(), 0, stream.size());
        return buffer;
    }

    public ByteBuffer encodeErrorEnvelope(String errorCode, String errorMessage, Object errorDetails) {
        StandardMessageCodec.ExposedByteArrayOutputStream stream = new StandardMessageCodec.ExposedByteArrayOutputStream();
        stream.write(1);
        this.messageCodec.writeValue(stream, errorCode);
        this.messageCodec.writeValue(stream, errorMessage);
        if (errorDetails instanceof Throwable) {
            this.messageCodec.writeValue(stream, getStackTrace((Throwable) errorDetails));
        } else {
            this.messageCodec.writeValue(stream, errorDetails);
        }
        ByteBuffer buffer = ByteBuffer.allocateDirect(stream.size());
        buffer.put(stream.buffer(), 0, stream.size());
        return buffer;
    }

    public ByteBuffer encodeErrorEnvelopeWithStacktrace(String errorCode, String errorMessage, Object errorDetails, String errorStacktrace) {
        StandardMessageCodec.ExposedByteArrayOutputStream stream = new StandardMessageCodec.ExposedByteArrayOutputStream();
        stream.write(1);
        this.messageCodec.writeValue(stream, errorCode);
        this.messageCodec.writeValue(stream, errorMessage);
        if (errorDetails instanceof Throwable) {
            this.messageCodec.writeValue(stream, getStackTrace((Throwable) errorDetails));
        } else {
            this.messageCodec.writeValue(stream, errorDetails);
        }
        this.messageCodec.writeValue(stream, errorStacktrace);
        ByteBuffer buffer = ByteBuffer.allocateDirect(stream.size());
        buffer.put(stream.buffer(), 0, stream.size());
        return buffer;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        if (r0 == 1) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object decodeEnvelope(java.nio.ByteBuffer r8) {
        /*
            r7 = this;
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            r8.order(r0)
            byte r0 = r8.get()
            if (r0 == 0) goto L_0x0011
            r1 = 1
            if (r0 != r1) goto L_0x004c
            goto L_0x001e
        L_0x0011:
            io.flutter.plugin.common.StandardMessageCodec r1 = r7.messageCodec
            java.lang.Object r1 = r1.readValue(r8)
            boolean r2 = r8.hasRemaining()
            if (r2 != 0) goto L_0x001e
            return r1
        L_0x001e:
            io.flutter.plugin.common.StandardMessageCodec r1 = r7.messageCodec
            java.lang.Object r1 = r1.readValue(r8)
            io.flutter.plugin.common.StandardMessageCodec r2 = r7.messageCodec
            java.lang.Object r2 = r2.readValue(r8)
            io.flutter.plugin.common.StandardMessageCodec r3 = r7.messageCodec
            java.lang.Object r3 = r3.readValue(r8)
            boolean r4 = r1 instanceof java.lang.String
            if (r4 == 0) goto L_0x004c
            if (r2 == 0) goto L_0x003a
            boolean r4 = r2 instanceof java.lang.String
            if (r4 == 0) goto L_0x004c
        L_0x003a:
            boolean r4 = r8.hasRemaining()
            if (r4 != 0) goto L_0x004c
            io.flutter.plugin.common.FlutterException r4 = new io.flutter.plugin.common.FlutterException
            r5 = r1
            java.lang.String r5 = (java.lang.String) r5
            r6 = r2
            java.lang.String r6 = (java.lang.String) r6
            r4.<init>(r5, r6, r3)
            throw r4
        L_0x004c:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Envelope corrupted"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.common.StandardMethodCodec.decodeEnvelope(java.nio.ByteBuffer):java.lang.Object");
    }

    private static String getStackTrace(Throwable t) {
        Writer result = new StringWriter();
        t.printStackTrace(new PrintWriter(result));
        return result.toString();
    }
}
