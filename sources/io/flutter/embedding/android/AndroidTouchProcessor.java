package io.flutter.embedding.android;

import android.graphics.Matrix;
import android.os.Build;
import android.view.MotionEvent;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class AndroidTouchProcessor {
    private static final int BYTES_PER_FIELD = 8;
    private static final Matrix IDENTITY_TRANSFORM = new Matrix();
    private static final int POINTER_DATA_FIELD_COUNT = 29;
    private static final int POINTER_DATA_FLAG_BATCHED = 1;
    private static final int _POINTER_BUTTON_PRIMARY = 1;
    private final MotionEventTracker motionEventTracker = MotionEventTracker.getInstance();
    private final FlutterRenderer renderer;
    private final boolean trackMotionEvents;

    private @interface PointerChange {
        public static final int ADD = 1;
        public static final int CANCEL = 0;
        public static final int DOWN = 4;
        public static final int HOVER = 3;
        public static final int MOVE = 5;
        public static final int REMOVE = 2;
        public static final int UP = 6;
    }

    private @interface PointerDeviceKind {
        public static final int INVERTED_STYLUS = 3;
        public static final int MOUSE = 1;
        public static final int STYLUS = 2;
        public static final int TOUCH = 0;
        public static final int UNKNOWN = 4;
    }

    private @interface PointerSignalKind {
        public static final int NONE = 0;
        public static final int SCROLL = 1;
        public static final int UNKNOWN = 2;
    }

    public AndroidTouchProcessor(FlutterRenderer renderer2, boolean trackMotionEvents2) {
        this.renderer = renderer2;
        this.trackMotionEvents = trackMotionEvents2;
    }

    public boolean onTouchEvent(MotionEvent event) {
        return onTouchEvent(event, IDENTITY_TRANSFORM);
    }

    public boolean onTouchEvent(MotionEvent event, Matrix transformMatrix) {
        int pointerCount = event.getPointerCount();
        ByteBuffer packet = ByteBuffer.allocateDirect(pointerCount * 29 * 8);
        packet.order(ByteOrder.LITTLE_ENDIAN);
        int maskedAction = event.getActionMasked();
        int pointerChange = getPointerChangeForAction(event.getActionMasked());
        boolean z = false;
        boolean updateForSinglePointer = maskedAction == 0 || maskedAction == 5;
        if (!updateForSinglePointer && (maskedAction == 1 || maskedAction == 6)) {
            z = true;
        }
        boolean updateForMultiplePointers = z;
        if (updateForSinglePointer) {
            addPointerForIndex(event, event.getActionIndex(), pointerChange, 0, transformMatrix, packet);
        } else if (updateForMultiplePointers) {
            for (int p = 0; p < pointerCount; p++) {
                if (p != event.getActionIndex() && event.getToolType(p) == 1) {
                    addPointerForIndex(event, p, 5, 1, transformMatrix, packet);
                }
            }
            addPointerForIndex(event, event.getActionIndex(), pointerChange, 0, transformMatrix, packet);
        } else {
            for (int p2 = 0; p2 < pointerCount; p2++) {
                addPointerForIndex(event, p2, pointerChange, 0, transformMatrix, packet);
            }
        }
        if (packet.position() % 232 == 0) {
            this.renderer.dispatchPointerDataPacket(packet, packet.position());
            return true;
        }
        throw new AssertionError("Packet position is not on field boundary");
    }

    public boolean onGenericMotionEvent(MotionEvent event) {
        boolean isPointerEvent = Build.VERSION.SDK_INT >= 18 && event.isFromSource(2);
        boolean isMovementEvent = event.getActionMasked() == 7 || event.getActionMasked() == 8;
        if (!isPointerEvent || !isMovementEvent) {
            return false;
        }
        int pointerChange = getPointerChangeForAction(event.getActionMasked());
        ByteBuffer packet = ByteBuffer.allocateDirect(event.getPointerCount() * 29 * 8);
        packet.order(ByteOrder.LITTLE_ENDIAN);
        addPointerForIndex(event, event.getActionIndex(), pointerChange, 0, IDENTITY_TRANSFORM, packet);
        if (packet.position() % 232 == 0) {
            this.renderer.dispatchPointerDataPacket(packet, packet.position());
            return true;
        }
        throw new AssertionError("Packet position is not on field boundary.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0174  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void addPointerForIndex(android.view.MotionEvent r23, int r24, int r25, int r26, android.graphics.Matrix r27, java.nio.ByteBuffer r28) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r25
            r4 = r28
            r5 = -1
            if (r3 != r5) goto L_0x000e
            return
        L_0x000e:
            r5 = 0
            boolean r7 = r0.trackMotionEvents
            if (r7 == 0) goto L_0x001e
            io.flutter.embedding.android.MotionEventTracker r7 = r0.motionEventTracker
            io.flutter.embedding.android.MotionEventTracker$MotionEventId r7 = r7.track(r1)
            long r5 = r7.getId()
        L_0x001e:
            int r7 = r23.getToolType(r24)
            int r7 = r0.getPointerDeviceTypeForToolType(r7)
            int r8 = r23.getActionMasked()
            r9 = 8
            r10 = 0
            r11 = 1
            if (r8 != r9) goto L_0x0033
            r8 = r11
            goto L_0x0034
        L_0x0033:
            r8 = r10
        L_0x0034:
            long r12 = r23.getEventTime()
            r14 = 1000(0x3e8, double:4.94E-321)
            long r12 = r12 * r14
            r4.putLong(r5)
            r4.putLong(r12)
            long r14 = (long) r3
            r4.putLong(r14)
            long r14 = (long) r7
            r4.putLong(r14)
            long r14 = (long) r8
            r4.putLong(r14)
            int r14 = r23.getPointerId(r24)
            long r14 = (long) r14
            r4.putLong(r14)
            r14 = 0
            r4.putLong(r14)
            r9 = 2
            float[] r14 = new float[r9]
            float r15 = r23.getX(r24)
            r14[r10] = r15
            float r15 = r23.getY(r24)
            r14[r11] = r15
            r15 = r27
            r15.mapPoints(r14)
            r10 = r14[r10]
            double r9 = (double) r10
            r4.putDouble(r9)
            r9 = r14[r11]
            double r9 = (double) r9
            r4.putDouble(r9)
            r9 = 0
            r4.putDouble(r9)
            r4.putDouble(r9)
            r9 = 4
            if (r7 != r11) goto L_0x00a4
            int r10 = r23.getButtonState()
            r10 = r10 & 31
            r18 = r12
            long r11 = (long) r10
            r16 = 0
            int r10 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r10 != 0) goto L_0x00b5
            int r10 = r23.getSource()
            r13 = 8194(0x2002, float:1.1482E-41)
            if (r10 != r13) goto L_0x00b5
            if (r3 == r9) goto L_0x00a1
            r9 = 5
            if (r3 != r9) goto L_0x00b5
        L_0x00a1:
            r11 = 1
            goto L_0x00b5
        L_0x00a4:
            r18 = r12
            r10 = 2
            if (r7 != r10) goto L_0x00b3
            int r10 = r23.getButtonState()
            int r9 = r10 >> 4
            r9 = r9 & 15
            long r11 = (long) r9
            goto L_0x00b5
        L_0x00b3:
            r11 = 0
        L_0x00b5:
            r4.putLong(r11)
            r9 = 0
            r4.putLong(r9)
            r4.putLong(r9)
            float r9 = r23.getPressure(r24)
            double r9 = (double) r9
            r4.putDouble(r9)
            r9 = 0
            r16 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            android.view.InputDevice r13 = r23.getDevice()
            if (r13 == 0) goto L_0x00ee
            android.view.InputDevice r13 = r23.getDevice()
            r0 = 2
            android.view.InputDevice$MotionRange r13 = r13.getMotionRange(r0)
            if (r13 == 0) goto L_0x00eb
            float r0 = r13.getMin()
            double r9 = (double) r0
            float r0 = r13.getMax()
            r20 = r5
            double r5 = (double) r0
            goto L_0x00f2
        L_0x00eb:
            r20 = r5
            goto L_0x00f0
        L_0x00ee:
            r20 = r5
        L_0x00f0:
            r5 = r16
        L_0x00f2:
            r4.putDouble(r9)
            r4.putDouble(r5)
            r0 = 2
            if (r7 != r0) goto L_0x010d
            r0 = 24
            float r0 = r1.getAxisValue(r0, r2)
            r16 = r5
            double r5 = (double) r0
            r4.putDouble(r5)
            r5 = 0
            r4.putDouble(r5)
            goto L_0x0117
        L_0x010d:
            r16 = r5
            r5 = 0
            r4.putDouble(r5)
            r4.putDouble(r5)
        L_0x0117:
            float r0 = r23.getSize(r24)
            double r5 = (double) r0
            r4.putDouble(r5)
            float r0 = r23.getToolMajor(r24)
            double r5 = (double) r0
            r4.putDouble(r5)
            float r0 = r23.getToolMinor(r24)
            double r5 = (double) r0
            r4.putDouble(r5)
            r5 = 0
            r4.putDouble(r5)
            r4.putDouble(r5)
            r0 = 8
            float r0 = r1.getAxisValue(r0, r2)
            double r5 = (double) r0
            r4.putDouble(r5)
            r0 = 2
            if (r7 != r0) goto L_0x014f
            r0 = 25
            float r0 = r1.getAxisValue(r0, r2)
            double r5 = (double) r0
            r4.putDouble(r5)
            goto L_0x0154
        L_0x014f:
            r5 = 0
            r4.putDouble(r5)
        L_0x0154:
            r0 = r26
            long r5 = (long) r0
            r4.putLong(r5)
            r5 = 1
            if (r8 != r5) goto L_0x0174
            r5 = 10
            float r5 = r1.getAxisValue(r5)
            float r5 = -r5
            double r5 = (double) r5
            r4.putDouble(r5)
            r5 = 9
            float r5 = r1.getAxisValue(r5)
            float r5 = -r5
            double r5 = (double) r5
            r4.putDouble(r5)
            goto L_0x017c
        L_0x0174:
            r5 = 0
            r4.putDouble(r5)
            r4.putDouble(r5)
        L_0x017c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.AndroidTouchProcessor.addPointerForIndex(android.view.MotionEvent, int, int, int, android.graphics.Matrix, java.nio.ByteBuffer):void");
    }

    private int getPointerChangeForAction(int maskedAction) {
        if (maskedAction == 0) {
            return 4;
        }
        if (maskedAction == 1) {
            return 6;
        }
        if (maskedAction == 5) {
            return 4;
        }
        if (maskedAction == 6) {
            return 6;
        }
        if (maskedAction == 2) {
            return 5;
        }
        if (maskedAction == 7) {
            return 3;
        }
        if (maskedAction == 3) {
            return 0;
        }
        if (maskedAction == 8) {
            return 3;
        }
        return -1;
    }

    private int getPointerDeviceTypeForToolType(int toolType) {
        if (toolType == 1) {
            return 0;
        }
        if (toolType == 2) {
            return 2;
        }
        if (toolType != 3) {
            return toolType != 4 ? 4 : 3;
        }
        return 1;
    }
}
