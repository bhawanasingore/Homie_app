package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.grpc.internal.SerializingExecutor;
import io.grpc.okhttp.ExceptionHandlingFrameWriter;
import java.io.IOException;
import java.net.Socket;
import javax.annotation.Nullable;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

final class AsyncSink implements Sink {
    /* access modifiers changed from: private */
    public final Buffer buffer = new Buffer();
    private boolean closed = false;
    /* access modifiers changed from: private */
    public boolean flushEnqueued = false;
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    private final SerializingExecutor serializingExecutor;
    /* access modifiers changed from: private */
    @Nullable
    public Sink sink;
    /* access modifiers changed from: private */
    @Nullable
    public Socket socket;
    /* access modifiers changed from: private */
    public final ExceptionHandlingFrameWriter.TransportExceptionHandler transportExceptionHandler;
    /* access modifiers changed from: private */
    public boolean writeEnqueued = false;

    private AsyncSink(SerializingExecutor executor, ExceptionHandlingFrameWriter.TransportExceptionHandler exceptionHandler) {
        this.serializingExecutor = (SerializingExecutor) Preconditions.checkNotNull(executor, "executor");
        this.transportExceptionHandler = (ExceptionHandlingFrameWriter.TransportExceptionHandler) Preconditions.checkNotNull(exceptionHandler, "exceptionHandler");
    }

    static AsyncSink sink(SerializingExecutor executor, ExceptionHandlingFrameWriter.TransportExceptionHandler exceptionHandler) {
        return new AsyncSink(executor, exceptionHandler);
    }

    /* access modifiers changed from: package-private */
    public void becomeConnected(Sink sink2, Socket socket2) {
        Preconditions.checkState(this.sink == null, "AsyncSink's becomeConnected should only be called once.");
        this.sink = (Sink) Preconditions.checkNotNull(sink2, "sink");
        this.socket = (Socket) Preconditions.checkNotNull(socket2, "socket");
    }

    public void write(Buffer source, long byteCount) throws IOException {
        Preconditions.checkNotNull(source, FirebaseAnalytics.Param.SOURCE);
        if (!this.closed) {
            synchronized (this.lock) {
                this.buffer.write(source, byteCount);
                if (!this.writeEnqueued && !this.flushEnqueued) {
                    if (this.buffer.completeSegmentByteCount() > 0) {
                        this.writeEnqueued = true;
                        this.serializingExecutor.execute(new WriteRunnable() {
                            public void doRun() throws IOException {
                                Buffer buf = new Buffer();
                                synchronized (AsyncSink.this.lock) {
                                    buf.write(AsyncSink.this.buffer, AsyncSink.this.buffer.completeSegmentByteCount());
                                    boolean unused = AsyncSink.this.writeEnqueued = false;
                                }
                                AsyncSink.this.sink.write(buf, buf.size());
                            }
                        });
                        return;
                    }
                }
                return;
            }
        }
        throw new IOException("closed");
    }

    public void flush() throws IOException {
        if (!this.closed) {
            synchronized (this.lock) {
                if (!this.flushEnqueued) {
                    this.flushEnqueued = true;
                    this.serializingExecutor.execute(new WriteRunnable() {
                        public void doRun() throws IOException {
                            Buffer buf = new Buffer();
                            synchronized (AsyncSink.this.lock) {
                                buf.write(AsyncSink.this.buffer, AsyncSink.this.buffer.size());
                                boolean unused = AsyncSink.this.flushEnqueued = false;
                            }
                            AsyncSink.this.sink.write(buf, buf.size());
                            AsyncSink.this.sink.flush();
                        }
                    });
                    return;
                }
                return;
            }
        }
        throw new IOException("closed");
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }

    public void close() {
        if (!this.closed) {
            this.closed = true;
            this.serializingExecutor.execute(new Runnable() {
                public void run() {
                    AsyncSink.this.buffer.close();
                    try {
                        if (AsyncSink.this.sink != null) {
                            AsyncSink.this.sink.close();
                        }
                    } catch (IOException e) {
                        AsyncSink.this.transportExceptionHandler.onException(e);
                    }
                    try {
                        if (AsyncSink.this.socket != null) {
                            AsyncSink.this.socket.close();
                        }
                    } catch (IOException e2) {
                        AsyncSink.this.transportExceptionHandler.onException(e2);
                    }
                }
            });
        }
    }

    private abstract class WriteRunnable implements Runnable {
        public abstract void doRun() throws IOException;

        private WriteRunnable() {
        }

        public final void run() {
            try {
                if (AsyncSink.this.sink != null) {
                    doRun();
                    return;
                }
                throw new IOException("Unable to perform write due to unavailable sink.");
            } catch (Exception e) {
                AsyncSink.this.transportExceptionHandler.onException(e);
            }
        }
    }
}
