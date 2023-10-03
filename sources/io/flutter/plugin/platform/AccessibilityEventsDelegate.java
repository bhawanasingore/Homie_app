package io.flutter.plugin.platform;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import io.flutter.view.AccessibilityBridge;

class AccessibilityEventsDelegate {
    private AccessibilityBridge accessibilityBridge;

    AccessibilityEventsDelegate() {
    }

    public boolean requestSendAccessibilityEvent(View embeddedView, View eventOrigin, AccessibilityEvent event) {
        AccessibilityBridge accessibilityBridge2 = this.accessibilityBridge;
        if (accessibilityBridge2 == null) {
            return false;
        }
        return accessibilityBridge2.externalViewRequestSendAccessibilityEvent(embeddedView, eventOrigin, event);
    }

    /* access modifiers changed from: package-private */
    public void setAccessibilityBridge(AccessibilityBridge accessibilityBridge2) {
        this.accessibilityBridge = accessibilityBridge2;
    }
}
