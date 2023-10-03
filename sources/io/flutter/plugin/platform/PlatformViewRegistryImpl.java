package io.flutter.plugin.platform;

import java.util.HashMap;
import java.util.Map;

class PlatformViewRegistryImpl implements PlatformViewRegistry {
    private final Map<String, PlatformViewFactory> viewFactories = new HashMap();

    PlatformViewRegistryImpl() {
    }

    public boolean registerViewFactory(String viewTypeId, PlatformViewFactory factory) {
        if (this.viewFactories.containsKey(viewTypeId)) {
            return false;
        }
        this.viewFactories.put(viewTypeId, factory);
        return true;
    }

    /* access modifiers changed from: package-private */
    public PlatformViewFactory getFactory(String viewTypeId) {
        return this.viewFactories.get(viewTypeId);
    }
}
