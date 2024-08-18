package io.grpc;

public final class InternalDecompressorRegistry {
    private InternalDecompressorRegistry() {
    }

    public static byte[] getRawAdvertisedMessageEncodings(DecompressorRegistry reg) {
        return reg.getRawAdvertisedMessageEncodings();
    }
}
