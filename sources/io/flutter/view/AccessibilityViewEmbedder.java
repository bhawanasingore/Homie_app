package io.flutter.view;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.accessibility.AccessibilityRecord;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

class AccessibilityViewEmbedder {
    private static final String TAG = "AccessibilityBridge";
    private final Map<View, Rect> embeddedViewToDisplayBounds;
    private final SparseArray<ViewAndId> flutterIdToOrigin = new SparseArray<>();
    private int nextFlutterId;
    private final Map<ViewAndId, Integer> originToFlutterId;
    private final ReflectionAccessors reflectionAccessors = new ReflectionAccessors();
    private final View rootAccessibilityView;

    AccessibilityViewEmbedder(View rootAccessibiiltyView, int firstVirtualNodeId) {
        this.rootAccessibilityView = rootAccessibiiltyView;
        this.nextFlutterId = firstVirtualNodeId;
        this.originToFlutterId = new HashMap();
        this.embeddedViewToDisplayBounds = new HashMap();
    }

    public AccessibilityNodeInfo getRootNode(View embeddedView, int flutterId, Rect displayBounds) {
        AccessibilityNodeInfo originNode = embeddedView.createAccessibilityNodeInfo();
        Long originPackedId = this.reflectionAccessors.getSourceNodeId(originNode);
        if (originPackedId == null) {
            return null;
        }
        this.embeddedViewToDisplayBounds.put(embeddedView, displayBounds);
        cacheVirtualIdMappings(embeddedView, ReflectionAccessors.getVirtualNodeId(originPackedId.longValue()), flutterId);
        return convertToFlutterNode(originNode, flutterId, embeddedView);
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int flutterId) {
        AccessibilityNodeInfo originNode;
        ViewAndId origin = this.flutterIdToOrigin.get(flutterId);
        if (origin == null || !this.embeddedViewToDisplayBounds.containsKey(origin.view) || origin.view.getAccessibilityNodeProvider() == null || (originNode = origin.view.getAccessibilityNodeProvider().createAccessibilityNodeInfo(origin.id)) == null) {
            return null;
        }
        return convertToFlutterNode(originNode, flutterId, origin.view);
    }

    private AccessibilityNodeInfo convertToFlutterNode(AccessibilityNodeInfo originNode, int flutterId, View embeddedView) {
        AccessibilityNodeInfo result = AccessibilityNodeInfo.obtain(this.rootAccessibilityView, flutterId);
        result.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
        result.setSource(this.rootAccessibilityView, flutterId);
        result.setClassName(originNode.getClassName());
        copyAccessibilityFields(originNode, result);
        setFlutterNodesTranslateBounds(originNode, this.embeddedViewToDisplayBounds.get(embeddedView), result);
        addChildrenToFlutterNode(originNode, embeddedView, result);
        setFlutterNodeParent(originNode, embeddedView, result);
        return result;
    }

    private void setFlutterNodeParent(AccessibilityNodeInfo originNode, View embeddedView, AccessibilityNodeInfo result) {
        Long parentOriginPackedId = this.reflectionAccessors.getParentNodeId(originNode);
        if (parentOriginPackedId != null) {
            Integer parentFlutterId = this.originToFlutterId.get(new ViewAndId(embeddedView, ReflectionAccessors.getVirtualNodeId(parentOriginPackedId.longValue())));
            if (parentFlutterId != null) {
                result.setParent(this.rootAccessibilityView, parentFlutterId.intValue());
            }
        }
    }

    private void addChildrenToFlutterNode(AccessibilityNodeInfo originNode, View embeddedView, AccessibilityNodeInfo resultNode) {
        int childFlutterId;
        for (int i = 0; i < originNode.getChildCount(); i++) {
            Long originPackedId = this.reflectionAccessors.getChildId(originNode, i);
            if (originPackedId != null) {
                int originId = ReflectionAccessors.getVirtualNodeId(originPackedId.longValue());
                ViewAndId origin = new ViewAndId(embeddedView, originId);
                if (this.originToFlutterId.containsKey(origin)) {
                    childFlutterId = this.originToFlutterId.get(origin).intValue();
                } else {
                    childFlutterId = this.nextFlutterId;
                    this.nextFlutterId = childFlutterId + 1;
                    cacheVirtualIdMappings(embeddedView, originId, childFlutterId);
                }
                resultNode.addChild(this.rootAccessibilityView, childFlutterId);
            }
        }
    }

    private void cacheVirtualIdMappings(View embeddedView, int originId, int flutterId) {
        ViewAndId origin = new ViewAndId(embeddedView, originId);
        this.originToFlutterId.put(origin, Integer.valueOf(flutterId));
        this.flutterIdToOrigin.put(flutterId, origin);
    }

    private void setFlutterNodesTranslateBounds(AccessibilityNodeInfo originNode, Rect displayBounds, AccessibilityNodeInfo resultNode) {
        Rect boundsInParent = new Rect();
        originNode.getBoundsInParent(boundsInParent);
        resultNode.setBoundsInParent(boundsInParent);
        Rect boundsInScreen = new Rect();
        originNode.getBoundsInScreen(boundsInScreen);
        boundsInScreen.offset(displayBounds.left, displayBounds.top);
        resultNode.setBoundsInScreen(boundsInScreen);
    }

    private void copyAccessibilityFields(AccessibilityNodeInfo input, AccessibilityNodeInfo output) {
        output.setAccessibilityFocused(input.isAccessibilityFocused());
        output.setCheckable(input.isCheckable());
        output.setChecked(input.isChecked());
        output.setContentDescription(input.getContentDescription());
        output.setEnabled(input.isEnabled());
        output.setClickable(input.isClickable());
        output.setFocusable(input.isFocusable());
        output.setFocused(input.isFocused());
        output.setLongClickable(input.isLongClickable());
        output.setMovementGranularities(input.getMovementGranularities());
        output.setPassword(input.isPassword());
        output.setScrollable(input.isScrollable());
        output.setSelected(input.isSelected());
        output.setText(input.getText());
        output.setVisibleToUser(input.isVisibleToUser());
        if (Build.VERSION.SDK_INT >= 18) {
            output.setEditable(input.isEditable());
        }
        if (Build.VERSION.SDK_INT >= 19) {
            output.setCanOpenPopup(input.canOpenPopup());
            output.setCollectionInfo(input.getCollectionInfo());
            output.setCollectionItemInfo(input.getCollectionItemInfo());
            output.setContentInvalid(input.isContentInvalid());
            output.setDismissable(input.isDismissable());
            output.setInputType(input.getInputType());
            output.setLiveRegion(input.getLiveRegion());
            output.setMultiLine(input.isMultiLine());
            output.setRangeInfo(input.getRangeInfo());
        }
        if (Build.VERSION.SDK_INT >= 21) {
            output.setError(input.getError());
            output.setMaxTextLength(input.getMaxTextLength());
        }
        if (Build.VERSION.SDK_INT >= 23) {
            output.setContextClickable(input.isContextClickable());
        }
        if (Build.VERSION.SDK_INT >= 24) {
            output.setDrawingOrder(input.getDrawingOrder());
            output.setImportantForAccessibility(input.isImportantForAccessibility());
        }
        if (Build.VERSION.SDK_INT >= 26) {
            output.setAvailableExtraData(input.getAvailableExtraData());
            output.setHintText(input.getHintText());
            output.setShowingHintText(input.isShowingHintText());
        }
    }

    public boolean requestSendAccessibilityEvent(View embeddedView, View eventOrigin, AccessibilityEvent event) {
        View view = embeddedView;
        AccessibilityEvent translatedEvent = AccessibilityEvent.obtain(event);
        Long originPackedId = this.reflectionAccessors.getRecordSourceNodeId(event);
        if (originPackedId == null) {
            return false;
        }
        int originVirtualId = ReflectionAccessors.getVirtualNodeId(originPackedId.longValue());
        Integer flutterId = this.originToFlutterId.get(new ViewAndId(view, originVirtualId));
        if (flutterId == null) {
            int i = this.nextFlutterId;
            this.nextFlutterId = i + 1;
            flutterId = Integer.valueOf(i);
            cacheVirtualIdMappings(view, originVirtualId, flutterId.intValue());
        }
        translatedEvent.setSource(this.rootAccessibilityView, flutterId.intValue());
        translatedEvent.setClassName(event.getClassName());
        translatedEvent.setPackageName(event.getPackageName());
        for (int i2 = 0; i2 < translatedEvent.getRecordCount(); i2++) {
            AccessibilityRecord record = translatedEvent.getRecord(i2);
            Long recordOriginPackedId = this.reflectionAccessors.getRecordSourceNodeId(record);
            if (recordOriginPackedId == null) {
                return false;
            }
            ViewAndId originViewAndId = new ViewAndId(view, ReflectionAccessors.getVirtualNodeId(recordOriginPackedId.longValue()));
            if (!this.originToFlutterId.containsKey(originViewAndId)) {
                return false;
            }
            record.setSource(this.rootAccessibilityView, this.originToFlutterId.get(originViewAndId).intValue());
        }
        return this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(eventOrigin, translatedEvent);
    }

    public boolean performAction(int flutterId, int accessibilityAction, Bundle arguments) {
        AccessibilityNodeProvider provider;
        ViewAndId origin = this.flutterIdToOrigin.get(flutterId);
        if (origin == null || (provider = origin.view.getAccessibilityNodeProvider()) == null) {
            return false;
        }
        return provider.performAction(origin.id, accessibilityAction, arguments);
    }

    public Integer getRecordFlutterId(View embeddedView, AccessibilityRecord record) {
        Long originPackedId = this.reflectionAccessors.getRecordSourceNodeId(record);
        if (originPackedId == null) {
            return null;
        }
        return this.originToFlutterId.get(new ViewAndId(embeddedView, ReflectionAccessors.getVirtualNodeId(originPackedId.longValue())));
    }

    public boolean onAccessibilityHoverEvent(int rootFlutterId, MotionEvent event) {
        MotionEvent motionEvent = event;
        ViewAndId origin = this.flutterIdToOrigin.get(rootFlutterId);
        if (origin == null) {
            return false;
        }
        Rect displayBounds = this.embeddedViewToDisplayBounds.get(origin.view);
        int pointerCount = event.getPointerCount();
        MotionEvent.PointerProperties[] pointerProperties = new MotionEvent.PointerProperties[pointerCount];
        MotionEvent.PointerCoords[] pointerCoords = new MotionEvent.PointerCoords[pointerCount];
        for (int i = 0; i < event.getPointerCount(); i++) {
            pointerProperties[i] = new MotionEvent.PointerProperties();
            motionEvent.getPointerProperties(i, pointerProperties[i]);
            MotionEvent.PointerCoords originCoords = new MotionEvent.PointerCoords();
            motionEvent.getPointerCoords(i, originCoords);
            pointerCoords[i] = new MotionEvent.PointerCoords(originCoords);
            pointerCoords[i].x -= (float) displayBounds.left;
            pointerCoords[i].y -= (float) displayBounds.top;
        }
        MotionEvent.PointerCoords[] pointerCoordsArr = pointerCoords;
        MotionEvent.PointerProperties[] pointerPropertiesArr = pointerProperties;
        return origin.view.dispatchGenericMotionEvent(MotionEvent.obtain(event.getDownTime(), event.getEventTime(), event.getAction(), event.getPointerCount(), pointerProperties, pointerCoords, event.getMetaState(), event.getButtonState(), event.getXPrecision(), event.getYPrecision(), event.getDeviceId(), event.getEdgeFlags(), event.getSource(), event.getFlags()));
    }

    public View platformViewOfNode(int flutterId) {
        ViewAndId viewAndId = this.flutterIdToOrigin.get(flutterId);
        if (viewAndId == null) {
            return null;
        }
        return viewAndId.view;
    }

    private static class ViewAndId {
        final int id;
        final View view;

        private ViewAndId(View view2, int id2) {
            this.view = view2;
            this.id = id2;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof ViewAndId)) {
                return false;
            }
            ViewAndId viewAndId = (ViewAndId) o;
            if (this.id != viewAndId.id || !this.view.equals(viewAndId.view)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((1 * 31) + this.view.hashCode()) * 31) + this.id;
        }
    }

    private static class ReflectionAccessors {
        private final Field childNodeIdsField;
        private final Method getChildId;
        private final Method getParentNodeId;
        private final Method getRecordSourceNodeId;
        private final Method getSourceNodeId;
        private final Method longArrayGetIndex;

        private ReflectionAccessors() {
            Method getSourceNodeId2 = null;
            Method getParentNodeId2 = null;
            Method getRecordSourceNodeId2 = null;
            Method getChildId2 = null;
            Field childNodeIdsField2 = null;
            Method longArrayGetIndex2 = null;
            try {
                getSourceNodeId2 = AccessibilityNodeInfo.class.getMethod("getSourceNodeId", new Class[0]);
            } catch (NoSuchMethodException e) {
                Log.w(AccessibilityViewEmbedder.TAG, "can't invoke AccessibilityNodeInfo#getSourceNodeId with reflection");
            }
            try {
                getRecordSourceNodeId2 = AccessibilityRecord.class.getMethod("getSourceNodeId", new Class[0]);
            } catch (NoSuchMethodException e2) {
                Log.w(AccessibilityViewEmbedder.TAG, "can't invoke AccessibiiltyRecord#getSourceNodeId with reflection");
            }
            if (Build.VERSION.SDK_INT <= 26) {
                try {
                    getParentNodeId2 = AccessibilityNodeInfo.class.getMethod("getParentNodeId", new Class[0]);
                } catch (NoSuchMethodException e3) {
                    Log.w(AccessibilityViewEmbedder.TAG, "can't invoke getParentNodeId with reflection");
                }
                try {
                    getChildId2 = AccessibilityNodeInfo.class.getMethod("getChildId", new Class[]{Integer.TYPE});
                } catch (NoSuchMethodException e4) {
                    Log.w(AccessibilityViewEmbedder.TAG, "can't invoke getChildId with reflection");
                }
            } else {
                try {
                    childNodeIdsField2 = AccessibilityNodeInfo.class.getDeclaredField("mChildNodeIds");
                    childNodeIdsField2.setAccessible(true);
                    longArrayGetIndex2 = Class.forName("android.util.LongArray").getMethod("get", new Class[]{Integer.TYPE});
                } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException | NullPointerException e5) {
                    Log.w(AccessibilityViewEmbedder.TAG, "can't access childNodeIdsField with reflection");
                    childNodeIdsField2 = null;
                }
            }
            this.getSourceNodeId = getSourceNodeId2;
            this.getParentNodeId = getParentNodeId2;
            this.getRecordSourceNodeId = getRecordSourceNodeId2;
            this.getChildId = getChildId2;
            this.childNodeIdsField = childNodeIdsField2;
            this.longArrayGetIndex = longArrayGetIndex2;
        }

        /* access modifiers changed from: private */
        public static int getVirtualNodeId(long nodeId) {
            return (int) (nodeId >> 32);
        }

        /* access modifiers changed from: private */
        public Long getSourceNodeId(AccessibilityNodeInfo node) {
            Method method = this.getSourceNodeId;
            if (method == null) {
                return null;
            }
            try {
                return (Long) method.invoke(node, new Object[0]);
            } catch (IllegalAccessException e) {
                Log.w(AccessibilityViewEmbedder.TAG, e);
                return null;
            } catch (InvocationTargetException e2) {
                Log.w(AccessibilityViewEmbedder.TAG, e2);
                return null;
            }
        }

        /* access modifiers changed from: private */
        public Long getChildId(AccessibilityNodeInfo node, int child) {
            if (this.getChildId == null && (this.childNodeIdsField == null || this.longArrayGetIndex == null)) {
                return null;
            }
            Method method = this.getChildId;
            if (method != null) {
                try {
                    return (Long) method.invoke(node, new Object[]{Integer.valueOf(child)});
                } catch (IllegalAccessException e) {
                    Log.w(AccessibilityViewEmbedder.TAG, e);
                    return null;
                } catch (InvocationTargetException e2) {
                    Log.w(AccessibilityViewEmbedder.TAG, e2);
                    return null;
                }
            } else {
                try {
                    return Long.valueOf(((Long) this.longArrayGetIndex.invoke(this.childNodeIdsField.get(node), new Object[]{Integer.valueOf(child)})).longValue());
                } catch (IllegalAccessException e3) {
                    Log.w(AccessibilityViewEmbedder.TAG, e3);
                    return null;
                } catch (ArrayIndexOutOfBoundsException | InvocationTargetException e4) {
                    Log.w(AccessibilityViewEmbedder.TAG, e4);
                    return null;
                }
            }
        }

        /* access modifiers changed from: private */
        public Long getParentNodeId(AccessibilityNodeInfo node) {
            Method method = this.getParentNodeId;
            if (method != null) {
                try {
                    return Long.valueOf(((Long) method.invoke(node, new Object[0])).longValue());
                } catch (IllegalAccessException e) {
                    Log.w(AccessibilityViewEmbedder.TAG, e);
                } catch (InvocationTargetException e2) {
                    Log.w(AccessibilityViewEmbedder.TAG, e2);
                }
            }
            return yoinkParentIdFromParcel(node);
        }

        private static Long yoinkParentIdFromParcel(AccessibilityNodeInfo node) {
            if (Build.VERSION.SDK_INT < 26) {
                Log.w(AccessibilityViewEmbedder.TAG, "Unexpected Android version. Unable to find the parent ID.");
                return null;
            }
            AccessibilityNodeInfo copy = AccessibilityNodeInfo.obtain(node);
            Parcel parcel = Parcel.obtain();
            parcel.setDataPosition(0);
            copy.writeToParcel(parcel, 0);
            Long parentNodeId = null;
            parcel.setDataPosition(0);
            long nonDefaultFields = parcel.readLong();
            int fieldIndex = 0 + 1;
            if (isBitSet(nonDefaultFields, 0) != 0) {
                parcel.readInt();
            }
            int fieldIndex2 = fieldIndex + 1;
            if (isBitSet(nonDefaultFields, fieldIndex) != 0) {
                parcel.readLong();
            }
            int fieldIndex3 = fieldIndex2 + 1;
            if (isBitSet(nonDefaultFields, fieldIndex2) != 0) {
                parcel.readInt();
            }
            int i = fieldIndex3 + 1;
            if (isBitSet(nonDefaultFields, fieldIndex3) != 0) {
                parentNodeId = Long.valueOf(parcel.readLong());
            }
            parcel.recycle();
            return parentNodeId;
        }

        private static boolean isBitSet(long flags, int bitIndex) {
            return ((1 << bitIndex) & flags) != 0;
        }

        /* access modifiers changed from: private */
        public Long getRecordSourceNodeId(AccessibilityRecord node) {
            Method method = this.getRecordSourceNodeId;
            if (method == null) {
                return null;
            }
            try {
                return (Long) method.invoke(node, new Object[0]);
            } catch (IllegalAccessException e) {
                Log.w(AccessibilityViewEmbedder.TAG, e);
                return null;
            } catch (InvocationTargetException e2) {
                Log.w(AccessibilityViewEmbedder.TAG, e2);
                return null;
            }
        }
    }
}
