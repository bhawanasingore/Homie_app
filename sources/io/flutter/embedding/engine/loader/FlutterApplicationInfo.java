package io.flutter.embedding.engine.loader;

public final class FlutterApplicationInfo {
    private static final String DEFAULT_AOT_SHARED_LIBRARY_NAME = "libapp.so";
    private static final String DEFAULT_FLUTTER_ASSETS_DIR = "flutter_assets";
    private static final String DEFAULT_ISOLATE_SNAPSHOT_DATA = "isolate_snapshot_data";
    private static final String DEFAULT_VM_SNAPSHOT_DATA = "vm_snapshot_data";
    final String aotSharedLibraryName;
    final boolean clearTextPermitted;
    final String domainNetworkPolicy;
    final String flutterAssetsDir;
    final String isolateSnapshotData;
    final String nativeLibraryDir;
    final String vmSnapshotData;

    public FlutterApplicationInfo(String aotSharedLibraryName2, String vmSnapshotData2, String isolateSnapshotData2, String flutterAssetsDir2, String domainNetworkPolicy2, String nativeLibraryDir2, boolean clearTextPermitted2) {
        this.aotSharedLibraryName = aotSharedLibraryName2 == null ? DEFAULT_AOT_SHARED_LIBRARY_NAME : aotSharedLibraryName2;
        this.vmSnapshotData = vmSnapshotData2 == null ? DEFAULT_VM_SNAPSHOT_DATA : vmSnapshotData2;
        this.isolateSnapshotData = isolateSnapshotData2 == null ? DEFAULT_ISOLATE_SNAPSHOT_DATA : isolateSnapshotData2;
        this.flutterAssetsDir = flutterAssetsDir2 == null ? DEFAULT_FLUTTER_ASSETS_DIR : flutterAssetsDir2;
        this.nativeLibraryDir = nativeLibraryDir2;
        this.domainNetworkPolicy = domainNetworkPolicy2 == null ? "" : domainNetworkPolicy2;
        this.clearTextPermitted = clearTextPermitted2;
    }
}
