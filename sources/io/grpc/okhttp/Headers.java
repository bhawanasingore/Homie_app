package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import io.grpc.InternalMetadata;
import io.grpc.Metadata;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.TransportFrameUtil;
import io.grpc.okhttp.internal.framed.Header;
import java.util.ArrayList;
import java.util.List;
import okio.ByteString;

class Headers {
    public static final Header CONTENT_TYPE_HEADER = new Header(GrpcUtil.CONTENT_TYPE_KEY.name(), GrpcUtil.CONTENT_TYPE_GRPC);
    public static final Header METHOD_GET_HEADER = new Header(Header.TARGET_METHOD, "GET");
    public static final Header METHOD_HEADER = new Header(Header.TARGET_METHOD, GrpcUtil.HTTP_METHOD);
    public static final Header SCHEME_HEADER = new Header(Header.TARGET_SCHEME, "https");
    public static final Header TE_HEADER = new Header("te", GrpcUtil.TE_TRAILERS);

    Headers() {
    }

    public static List<Header> createRequestHeaders(Metadata headers, String defaultPath, String authority, String userAgent, boolean useGet) {
        Preconditions.checkNotNull(headers, "headers");
        Preconditions.checkNotNull(defaultPath, "defaultPath");
        Preconditions.checkNotNull(authority, "authority");
        headers.discardAll(GrpcUtil.CONTENT_TYPE_KEY);
        headers.discardAll(GrpcUtil.TE_HEADER);
        headers.discardAll(GrpcUtil.USER_AGENT_KEY);
        List<Header> okhttpHeaders = new ArrayList<>(InternalMetadata.headerCount(headers) + 7);
        okhttpHeaders.add(SCHEME_HEADER);
        if (useGet) {
            okhttpHeaders.add(METHOD_GET_HEADER);
        } else {
            okhttpHeaders.add(METHOD_HEADER);
        }
        okhttpHeaders.add(new Header(Header.TARGET_AUTHORITY, authority));
        okhttpHeaders.add(new Header(Header.TARGET_PATH, defaultPath));
        okhttpHeaders.add(new Header(GrpcUtil.USER_AGENT_KEY.name(), userAgent));
        okhttpHeaders.add(CONTENT_TYPE_HEADER);
        okhttpHeaders.add(TE_HEADER);
        byte[][] serializedHeaders = TransportFrameUtil.toHttp2Headers(headers);
        for (int i = 0; i < serializedHeaders.length; i += 2) {
            ByteString key = ByteString.of(serializedHeaders[i]);
            if (isApplicationHeader(key.utf8())) {
                okhttpHeaders.add(new Header(key, ByteString.of(serializedHeaders[i + 1])));
            }
        }
        return okhttpHeaders;
    }

    private static boolean isApplicationHeader(String key) {
        return !key.startsWith(":") && !GrpcUtil.CONTENT_TYPE_KEY.name().equalsIgnoreCase(key) && !GrpcUtil.USER_AGENT_KEY.name().equalsIgnoreCase(key);
    }
}
