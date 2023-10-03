package io.grpc;

import androidx.core.app.NotificationCompat;
import com.google.common.base.Preconditions;

public final class InternalMethodDescriptor {
    private final InternalKnownTransport transport;

    public InternalMethodDescriptor(InternalKnownTransport transport2) {
        this.transport = (InternalKnownTransport) Preconditions.checkNotNull(transport2, NotificationCompat.CATEGORY_TRANSPORT);
    }

    public Object geRawMethodName(MethodDescriptor<?, ?> md) {
        return md.getRawMethodName(this.transport.ordinal());
    }

    public void setRawMethodName(MethodDescriptor<?, ?> md, Object o) {
        md.setRawMethodName(this.transport.ordinal(), o);
    }
}
