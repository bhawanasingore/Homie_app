package io.flutter.view;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.net.Uri;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate;
import io.flutter.util.Predicate;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AccessibilityBridge extends AccessibilityNodeProvider {
    private static final int ACTION_SHOW_ON_SCREEN = 16908342;
    private static int FIRST_RESOURCE_ID = 267386881;
    private static final int MIN_ENGINE_GENERATED_NODE_ID = 65536;
    private static final int ROOT_NODE_ID = 0;
    private static final float SCROLL_EXTENT_FOR_INFINITY = 100000.0f;
    private static final float SCROLL_POSITION_CAP_FOR_INFINITY = 70000.0f;
    private static final String TAG = "AccessibilityBridge";
    /* access modifiers changed from: private */
    public final AccessibilityChannel accessibilityChannel;
    /* access modifiers changed from: private */
    public int accessibilityFeatureFlags;
    private SemanticsNode accessibilityFocusedSemanticsNode;
    /* access modifiers changed from: private */
    public final AccessibilityManager accessibilityManager;
    /* access modifiers changed from: private */
    public final AccessibilityChannel.AccessibilityMessageHandler accessibilityMessageHandler;
    private final AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener;
    private final AccessibilityViewEmbedder accessibilityViewEmbedder;
    private final ContentObserver animationScaleObserver;
    /* access modifiers changed from: private */
    public final ContentResolver contentResolver;
    private final Map<Integer, CustomAccessibilityAction> customAccessibilityActions;
    private Integer embeddedAccessibilityFocusedNodeId;
    private Integer embeddedInputFocusedNodeId;
    private final List<Integer> flutterNavigationStack;
    private final Map<Integer, SemanticsNode> flutterSemanticsTree;
    private SemanticsNode hoveredObject;
    private SemanticsNode inputFocusedSemanticsNode;
    /* access modifiers changed from: private */
    public boolean isReleased;
    private SemanticsNode lastInputFocusedSemanticsNode;
    private Integer lastLeftFrameInset;
    /* access modifiers changed from: private */
    public OnAccessibilityChangeListener onAccessibilityChangeListener;
    private final PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate;
    private int previousRouteId;
    /* access modifiers changed from: private */
    public final View rootAccessibilityView;
    private final AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener;

    public interface OnAccessibilityChangeListener {
        void onAccessibilityChanged(boolean z, boolean z2);
    }

    public AccessibilityBridge(View rootAccessibilityView2, AccessibilityChannel accessibilityChannel2, AccessibilityManager accessibilityManager2, ContentResolver contentResolver2, PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate2) {
        this(rootAccessibilityView2, accessibilityChannel2, accessibilityManager2, contentResolver2, new AccessibilityViewEmbedder(rootAccessibilityView2, 65536), platformViewsAccessibilityDelegate2);
    }

    public AccessibilityBridge(View rootAccessibilityView2, AccessibilityChannel accessibilityChannel2, final AccessibilityManager accessibilityManager2, ContentResolver contentResolver2, AccessibilityViewEmbedder accessibilityViewEmbedder2, PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate2) {
        this.flutterSemanticsTree = new HashMap();
        this.customAccessibilityActions = new HashMap();
        this.accessibilityFeatureFlags = 0;
        this.flutterNavigationStack = new ArrayList();
        this.previousRouteId = 0;
        this.lastLeftFrameInset = 0;
        this.isReleased = false;
        this.accessibilityMessageHandler = new AccessibilityChannel.AccessibilityMessageHandler() {
            public void announce(String message) {
                AccessibilityBridge.this.rootAccessibilityView.announceForAccessibility(message);
            }

            public void onTap(int nodeId) {
                AccessibilityBridge.this.sendAccessibilityEvent(nodeId, 1);
            }

            public void onLongPress(int nodeId) {
                AccessibilityBridge.this.sendAccessibilityEvent(nodeId, 2);
            }

            public void onTooltip(String message) {
                AccessibilityEvent e = AccessibilityBridge.this.obtainAccessibilityEvent(0, 32);
                e.getText().add(message);
                AccessibilityBridge.this.sendAccessibilityEvent(e);
            }

            public void updateCustomAccessibilityActions(ByteBuffer buffer, String[] strings) {
                buffer.order(ByteOrder.LITTLE_ENDIAN);
                AccessibilityBridge.this.updateCustomAccessibilityActions(buffer, strings);
            }

            public void updateSemantics(ByteBuffer buffer, String[] strings) {
                buffer.order(ByteOrder.LITTLE_ENDIAN);
                AccessibilityBridge.this.updateSemantics(buffer, strings);
            }
        };
        this.accessibilityStateChangeListener = new AccessibilityManager.AccessibilityStateChangeListener() {
            public void onAccessibilityStateChanged(boolean accessibilityEnabled) {
                if (!AccessibilityBridge.this.isReleased) {
                    if (accessibilityEnabled) {
                        AccessibilityBridge.this.accessibilityChannel.setAccessibilityMessageHandler(AccessibilityBridge.this.accessibilityMessageHandler);
                        AccessibilityBridge.this.accessibilityChannel.onAndroidAccessibilityEnabled();
                    } else {
                        AccessibilityBridge.this.accessibilityChannel.setAccessibilityMessageHandler((AccessibilityChannel.AccessibilityMessageHandler) null);
                        AccessibilityBridge.this.accessibilityChannel.onAndroidAccessibilityDisabled();
                    }
                    if (AccessibilityBridge.this.onAccessibilityChangeListener != null) {
                        AccessibilityBridge.this.onAccessibilityChangeListener.onAccessibilityChanged(accessibilityEnabled, AccessibilityBridge.this.accessibilityManager.isTouchExplorationEnabled());
                    }
                }
            }
        };
        this.animationScaleObserver = new ContentObserver(new Handler()) {
            public void onChange(boolean selfChange) {
                onChange(selfChange, (Uri) null);
            }

            public void onChange(boolean selfChange, Uri uri) {
                String value;
                if (!AccessibilityBridge.this.isReleased) {
                    if (Build.VERSION.SDK_INT < 17) {
                        value = null;
                    } else {
                        value = Settings.Global.getString(AccessibilityBridge.this.contentResolver, "transition_animation_scale");
                    }
                    if (value != null && value.equals("0")) {
                        AccessibilityBridge accessibilityBridge = AccessibilityBridge.this;
                        int unused = accessibilityBridge.accessibilityFeatureFlags = accessibilityBridge.accessibilityFeatureFlags | AccessibilityFeature.DISABLE_ANIMATIONS.value;
                    } else {
                        AccessibilityBridge accessibilityBridge2 = AccessibilityBridge.this;
                        int unused2 = accessibilityBridge2.accessibilityFeatureFlags = accessibilityBridge2.accessibilityFeatureFlags & (~AccessibilityFeature.DISABLE_ANIMATIONS.value);
                    }
                    AccessibilityBridge.this.sendLatestAccessibilityFlagsToFlutter();
                }
            }
        };
        this.rootAccessibilityView = rootAccessibilityView2;
        this.accessibilityChannel = accessibilityChannel2;
        this.accessibilityManager = accessibilityManager2;
        this.contentResolver = contentResolver2;
        this.accessibilityViewEmbedder = accessibilityViewEmbedder2;
        this.platformViewsAccessibilityDelegate = platformViewsAccessibilityDelegate2;
        this.accessibilityStateChangeListener.onAccessibilityStateChanged(accessibilityManager2.isEnabled());
        this.accessibilityManager.addAccessibilityStateChangeListener(this.accessibilityStateChangeListener);
        if (Build.VERSION.SDK_INT >= 19) {
            AnonymousClass4 r1 = new AccessibilityManager.TouchExplorationStateChangeListener() {
                public void onTouchExplorationStateChanged(boolean isTouchExplorationEnabled) {
                    if (!AccessibilityBridge.this.isReleased) {
                        if (isTouchExplorationEnabled) {
                            AccessibilityBridge accessibilityBridge = AccessibilityBridge.this;
                            int unused = accessibilityBridge.accessibilityFeatureFlags = accessibilityBridge.accessibilityFeatureFlags | AccessibilityFeature.ACCESSIBLE_NAVIGATION.value;
                        } else {
                            AccessibilityBridge.this.onTouchExplorationExit();
                            AccessibilityBridge accessibilityBridge2 = AccessibilityBridge.this;
                            int unused2 = accessibilityBridge2.accessibilityFeatureFlags = accessibilityBridge2.accessibilityFeatureFlags & (~AccessibilityFeature.ACCESSIBLE_NAVIGATION.value);
                        }
                        AccessibilityBridge.this.sendLatestAccessibilityFlagsToFlutter();
                        if (AccessibilityBridge.this.onAccessibilityChangeListener != null) {
                            AccessibilityBridge.this.onAccessibilityChangeListener.onAccessibilityChanged(accessibilityManager2.isEnabled(), isTouchExplorationEnabled);
                        }
                    }
                }
            };
            this.touchExplorationStateChangeListener = r1;
            r1.onTouchExplorationStateChanged(accessibilityManager2.isTouchExplorationEnabled());
            this.accessibilityManager.addTouchExplorationStateChangeListener(this.touchExplorationStateChangeListener);
        } else {
            this.touchExplorationStateChangeListener = null;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.animationScaleObserver.onChange(false);
            this.contentResolver.registerContentObserver(Settings.Global.getUriFor("transition_animation_scale"), false, this.animationScaleObserver);
        }
        if (platformViewsAccessibilityDelegate2 != null) {
            platformViewsAccessibilityDelegate2.attachAccessibilityBridge(this);
        }
    }

    public void release() {
        this.isReleased = true;
        PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate2 = this.platformViewsAccessibilityDelegate;
        if (platformViewsAccessibilityDelegate2 != null) {
            platformViewsAccessibilityDelegate2.detachAccessibiltyBridge();
        }
        setOnAccessibilityChangeListener((OnAccessibilityChangeListener) null);
        this.accessibilityManager.removeAccessibilityStateChangeListener(this.accessibilityStateChangeListener);
        if (Build.VERSION.SDK_INT >= 19) {
            this.accessibilityManager.removeTouchExplorationStateChangeListener(this.touchExplorationStateChangeListener);
        }
        this.contentResolver.unregisterContentObserver(this.animationScaleObserver);
        this.accessibilityChannel.setAccessibilityMessageHandler((AccessibilityChannel.AccessibilityMessageHandler) null);
    }

    public boolean isAccessibilityEnabled() {
        return this.accessibilityManager.isEnabled();
    }

    public boolean isTouchExplorationEnabled() {
        return this.accessibilityManager.isTouchExplorationEnabled();
    }

    public void setOnAccessibilityChangeListener(OnAccessibilityChangeListener listener) {
        this.onAccessibilityChangeListener = listener;
    }

    /* access modifiers changed from: private */
    public void sendLatestAccessibilityFlagsToFlutter() {
        this.accessibilityChannel.setAccessibilityFeatures(this.accessibilityFeatureFlags);
    }

    private boolean shouldSetCollectionInfo(SemanticsNode semanticsNode) {
        return semanticsNode.scrollChildren > 0 && (SemanticsNode.nullableHasAncestor(this.accessibilityFocusedSemanticsNode, 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: RETURN  
              (wrap: boolean : ?: TERNARYnull = (((wrap: int : 0x0000: INVOKE  (r0v0 int) = 
              (r3v0 'semanticsNode' io.flutter.view.AccessibilityBridge$SemanticsNode)
             io.flutter.view.AccessibilityBridge.SemanticsNode.access$1300(io.flutter.view.AccessibilityBridge$SemanticsNode):int type: STATIC) > (0 int) && ((wrap: boolean : 0x000d: INVOKE  (r0v3 boolean) = 
              (wrap: io.flutter.view.AccessibilityBridge$SemanticsNode : 0x0006: IGET  (r0v2 io.flutter.view.AccessibilityBridge$SemanticsNode) = (r2v0 'this' io.flutter.view.AccessibilityBridge A[THIS]) io.flutter.view.AccessibilityBridge.accessibilityFocusedSemanticsNode io.flutter.view.AccessibilityBridge$SemanticsNode)
              (wrap: io.flutter.view.-$$Lambda$AccessibilityBridge$JBDpWWlF54eN0gel8Jn1hY7yOmE : 0x000a: CONSTRUCTOR  (r1v0 io.flutter.view.-$$Lambda$AccessibilityBridge$JBDpWWlF54eN0gel8Jn1hY7yOmE) = 
              (r3v0 'semanticsNode' io.flutter.view.AccessibilityBridge$SemanticsNode)
             call: io.flutter.view.-$$Lambda$AccessibilityBridge$JBDpWWlF54eN0gel8Jn1hY7yOmE.<init>(io.flutter.view.AccessibilityBridge$SemanticsNode):void type: CONSTRUCTOR)
             io.flutter.view.AccessibilityBridge.SemanticsNode.access$1400(io.flutter.view.AccessibilityBridge$SemanticsNode, io.flutter.util.Predicate):boolean type: STATIC) == true || (wrap: boolean : 0x0017: INVOKE  (r0v6 boolean) = 
              (wrap: io.flutter.view.AccessibilityBridge$SemanticsNode : 0x0013: IGET  (r0v5 io.flutter.view.AccessibilityBridge$SemanticsNode) = (r2v0 'this' io.flutter.view.AccessibilityBridge A[THIS]) io.flutter.view.AccessibilityBridge.accessibilityFocusedSemanticsNode io.flutter.view.AccessibilityBridge$SemanticsNode)
              (wrap: io.flutter.view.-$$Lambda$AccessibilityBridge$_xgAbWhyKyeHrMGUVUYzbSFEeBY : 0x0015: SGET  (r1v1 io.flutter.view.-$$Lambda$AccessibilityBridge$_xgAbWhyKyeHrMGUVUYzbSFEeBY) =  io.flutter.view.-$$Lambda$AccessibilityBridge$_xgAbWhyKyeHrMGUVUYzbSFEeBY.INSTANCE io.flutter.view.-$$Lambda$AccessibilityBridge$_xgAbWhyKyeHrMGUVUYzbSFEeBY)
             io.flutter.view.AccessibilityBridge.SemanticsNode.access$1400(io.flutter.view.AccessibilityBridge$SemanticsNode, io.flutter.util.Predicate):boolean type: STATIC) == false))) ? true : false)
             in method: io.flutter.view.AccessibilityBridge.shouldSetCollectionInfo(io.flutter.view.AccessibilityBridge$SemanticsNode):boolean, dex: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: TERNARYnull = (((wrap: int : 0x0000: INVOKE  (r0v0 int) = 
              (r3v0 'semanticsNode' io.flutter.view.AccessibilityBridge$SemanticsNode)
             io.flutter.view.AccessibilityBridge.SemanticsNode.access$1300(io.flutter.view.AccessibilityBridge$SemanticsNode):int type: STATIC) > (0 int) && ((wrap: boolean : 0x000d: INVOKE  (r0v3 boolean) = 
              (wrap: io.flutter.view.AccessibilityBridge$SemanticsNode : 0x0006: IGET  (r0v2 io.flutter.view.AccessibilityBridge$SemanticsNode) = (r2v0 'this' io.flutter.view.AccessibilityBridge A[THIS]) io.flutter.view.AccessibilityBridge.accessibilityFocusedSemanticsNode io.flutter.view.AccessibilityBridge$SemanticsNode)
              (wrap: io.flutter.view.-$$Lambda$AccessibilityBridge$JBDpWWlF54eN0gel8Jn1hY7yOmE : 0x000a: CONSTRUCTOR  (r1v0 io.flutter.view.-$$Lambda$AccessibilityBridge$JBDpWWlF54eN0gel8Jn1hY7yOmE) = 
              (r3v0 'semanticsNode' io.flutter.view.AccessibilityBridge$SemanticsNode)
             call: io.flutter.view.-$$Lambda$AccessibilityBridge$JBDpWWlF54eN0gel8Jn1hY7yOmE.<init>(io.flutter.view.AccessibilityBridge$SemanticsNode):void type: CONSTRUCTOR)
             io.flutter.view.AccessibilityBridge.SemanticsNode.access$1400(io.flutter.view.AccessibilityBridge$SemanticsNode, io.flutter.util.Predicate):boolean type: STATIC) == true || (wrap: boolean : 0x0017: INVOKE  (r0v6 boolean) = 
              (wrap: io.flutter.view.AccessibilityBridge$SemanticsNode : 0x0013: IGET  (r0v5 io.flutter.view.AccessibilityBridge$SemanticsNode) = (r2v0 'this' io.flutter.view.AccessibilityBridge A[THIS]) io.flutter.view.AccessibilityBridge.accessibilityFocusedSemanticsNode io.flutter.view.AccessibilityBridge$SemanticsNode)
              (wrap: io.flutter.view.-$$Lambda$AccessibilityBridge$_xgAbWhyKyeHrMGUVUYzbSFEeBY : 0x0015: SGET  (r1v1 io.flutter.view.-$$Lambda$AccessibilityBridge$_xgAbWhyKyeHrMGUVUYzbSFEeBY) =  io.flutter.view.-$$Lambda$AccessibilityBridge$_xgAbWhyKyeHrMGUVUYzbSFEeBY.INSTANCE io.flutter.view.-$$Lambda$AccessibilityBridge$_xgAbWhyKyeHrMGUVUYzbSFEeBY)
             io.flutter.view.AccessibilityBridge.SemanticsNode.access$1400(io.flutter.view.AccessibilityBridge$SemanticsNode, io.flutter.util.Predicate):boolean type: STATIC) == false))) ? true : false in method: io.flutter.view.AccessibilityBridge.shouldSetCollectionInfo(io.flutter.view.AccessibilityBridge$SemanticsNode):boolean, dex: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:314)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
            	... 29 more
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000d: INVOKE  (r0v3 boolean) = 
              (wrap: io.flutter.view.AccessibilityBridge$SemanticsNode : 0x0006: IGET  (r0v2 io.flutter.view.AccessibilityBridge$SemanticsNode) = (r2v0 'this' io.flutter.view.AccessibilityBridge A[THIS]) io.flutter.view.AccessibilityBridge.accessibilityFocusedSemanticsNode io.flutter.view.AccessibilityBridge$SemanticsNode)
              (wrap: io.flutter.view.-$$Lambda$AccessibilityBridge$JBDpWWlF54eN0gel8Jn1hY7yOmE : 0x000a: CONSTRUCTOR  (r1v0 io.flutter.view.-$$Lambda$AccessibilityBridge$JBDpWWlF54eN0gel8Jn1hY7yOmE) = 
              (r3v0 'semanticsNode' io.flutter.view.AccessibilityBridge$SemanticsNode)
             call: io.flutter.view.-$$Lambda$AccessibilityBridge$JBDpWWlF54eN0gel8Jn1hY7yOmE.<init>(io.flutter.view.AccessibilityBridge$SemanticsNode):void type: CONSTRUCTOR)
             io.flutter.view.AccessibilityBridge.SemanticsNode.access$1400(io.flutter.view.AccessibilityBridge$SemanticsNode, io.flutter.util.Predicate):boolean type: STATIC in method: io.flutter.view.AccessibilityBridge.shouldSetCollectionInfo(io.flutter.view.AccessibilityBridge$SemanticsNode):boolean, dex: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.ConditionGen.wrap(ConditionGen.java:95)
            	at jadx.core.codegen.ConditionGen.addCompare(ConditionGen.java:117)
            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:57)
            	at jadx.core.codegen.ConditionGen.wrap(ConditionGen.java:84)
            	at jadx.core.codegen.ConditionGen.addAndOr(ConditionGen.java:151)
            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:70)
            	at jadx.core.codegen.ConditionGen.wrap(ConditionGen.java:84)
            	at jadx.core.codegen.ConditionGen.addAndOr(ConditionGen.java:151)
            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:70)
            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:46)
            	at jadx.core.codegen.InsnGen.makeTernary(InsnGen.java:948)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:476)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	... 33 more
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: ONE_ARG  
              (wrap: boolean : 0x0000: INVOKE  (r0v0 boolean) = 
              (wrap: io.flutter.view.AccessibilityBridge$SemanticsNode : 0x0006: IGET  (r0v2 io.flutter.view.AccessibilityBridge$SemanticsNode) = (r2v0 'this' io.flutter.view.AccessibilityBridge A[THIS]) io.flutter.view.AccessibilityBridge.accessibilityFocusedSemanticsNode io.flutter.view.AccessibilityBridge$SemanticsNode)
              (wrap: io.flutter.view.-$$Lambda$AccessibilityBridge$JBDpWWlF54eN0gel8Jn1hY7yOmE : 0x000a: CONSTRUCTOR  (r1v0 io.flutter.view.-$$Lambda$AccessibilityBridge$JBDpWWlF54eN0gel8Jn1hY7yOmE) = 
              (r3v0 'semanticsNode' io.flutter.view.AccessibilityBridge$SemanticsNode)
             call: io.flutter.view.-$$Lambda$AccessibilityBridge$JBDpWWlF54eN0gel8Jn1hY7yOmE.<init>(io.flutter.view.AccessibilityBridge$SemanticsNode):void type: CONSTRUCTOR)
             io.flutter.view.AccessibilityBridge.SemanticsNode.nullableHasAncestor(io.flutter.view.AccessibilityBridge$SemanticsNode, io.flutter.util.Predicate):boolean type: STATIC)
             in method: io.flutter.view.AccessibilityBridge.shouldSetCollectionInfo(io.flutter.view.AccessibilityBridge$SemanticsNode):boolean, dex: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
            	at jadx.core.codegen.InsnGen.inlineMethod(InsnGen.java:924)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:684)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	... 48 more
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0000: INVOKE  (r0v0 boolean) = 
              (wrap: io.flutter.view.AccessibilityBridge$SemanticsNode : 0x0006: IGET  (r0v2 io.flutter.view.AccessibilityBridge$SemanticsNode) = (r2v0 'this' io.flutter.view.AccessibilityBridge A[THIS]) io.flutter.view.AccessibilityBridge.accessibilityFocusedSemanticsNode io.flutter.view.AccessibilityBridge$SemanticsNode)
              (wrap: io.flutter.view.-$$Lambda$AccessibilityBridge$JBDpWWlF54eN0gel8Jn1hY7yOmE : 0x000a: CONSTRUCTOR  (r1v0 io.flutter.view.-$$Lambda$AccessibilityBridge$JBDpWWlF54eN0gel8Jn1hY7yOmE) = 
              (r3v0 'semanticsNode' io.flutter.view.AccessibilityBridge$SemanticsNode)
             call: io.flutter.view.-$$Lambda$AccessibilityBridge$JBDpWWlF54eN0gel8Jn1hY7yOmE.<init>(io.flutter.view.AccessibilityBridge$SemanticsNode):void type: CONSTRUCTOR)
             io.flutter.view.AccessibilityBridge.SemanticsNode.nullableHasAncestor(io.flutter.view.AccessibilityBridge$SemanticsNode, io.flutter.util.Predicate):boolean type: STATIC in method: io.flutter.view.AccessibilityBridge.shouldSetCollectionInfo(io.flutter.view.AccessibilityBridge$SemanticsNode):boolean, dex: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:98)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:480)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	... 52 more
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000a: CONSTRUCTOR  (r1v0 io.flutter.view.-$$Lambda$AccessibilityBridge$JBDpWWlF54eN0gel8Jn1hY7yOmE) = 
              (r3v0 'semanticsNode' io.flutter.view.AccessibilityBridge$SemanticsNode)
             call: io.flutter.view.-$$Lambda$AccessibilityBridge$JBDpWWlF54eN0gel8Jn1hY7yOmE.<init>(io.flutter.view.AccessibilityBridge$SemanticsNode):void type: CONSTRUCTOR in method: io.flutter.view.AccessibilityBridge.shouldSetCollectionInfo(io.flutter.view.AccessibilityBridge$SemanticsNode):boolean, dex: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	... 57 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: io.flutter.view.-$$Lambda$AccessibilityBridge$JBDpWWlF54eN0gel8Jn1hY7yOmE, state: NOT_LOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:260)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:606)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	... 63 more
            */
        /*
            this = this;
            int r0 = r3.scrollChildren
            if (r0 <= 0) goto L_0x001f
            io.flutter.view.AccessibilityBridge$SemanticsNode r0 = r2.accessibilityFocusedSemanticsNode
            io.flutter.view.-$$Lambda$AccessibilityBridge$JBDpWWlF54eN0gel8Jn1hY7yOmE r1 = new io.flutter.view.-$$Lambda$AccessibilityBridge$JBDpWWlF54eN0gel8Jn1hY7yOmE
            r1.<init>(r3)
            boolean r0 = io.flutter.view.AccessibilityBridge.SemanticsNode.nullableHasAncestor(r0, r1)
            if (r0 != 0) goto L_0x001d
            io.flutter.view.AccessibilityBridge$SemanticsNode r0 = r2.accessibilityFocusedSemanticsNode
            io.flutter.view.-$$Lambda$AccessibilityBridge$_xgAbWhyKyeHrMGUVUYzbSFEeBY r1 = io.flutter.view.$$Lambda$AccessibilityBridge$_xgAbWhyKyeHrMGUVUYzbSFEeBY.INSTANCE
            boolean r0 = io.flutter.view.AccessibilityBridge.SemanticsNode.nullableHasAncestor(r0, r1)
            if (r0 != 0) goto L_0x001f
        L_0x001d:
            r0 = 1
            goto L_0x0020
        L_0x001f:
            r0 = 0
        L_0x0020:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.AccessibilityBridge.shouldSetCollectionInfo(io.flutter.view.AccessibilityBridge$SemanticsNode):boolean");
    }

    static /* synthetic */ boolean lambda$shouldSetCollectionInfo$0(SemanticsNode semanticsNode, SemanticsNode o) {
        return o == semanticsNode;
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int virtualViewId) {
        SemanticsNode semanticsNode;
        if (virtualViewId >= 65536) {
            return this.accessibilityViewEmbedder.createAccessibilityNodeInfo(virtualViewId);
        }
        boolean z = false;
        if (virtualViewId == -1) {
            AccessibilityNodeInfo result = AccessibilityNodeInfo.obtain(this.rootAccessibilityView);
            this.rootAccessibilityView.onInitializeAccessibilityNodeInfo(result);
            if (this.flutterSemanticsTree.containsKey(0)) {
                result.addChild(this.rootAccessibilityView, 0);
            }
            return result;
        }
        SemanticsNode semanticsNode2 = this.flutterSemanticsTree.get(Integer.valueOf(virtualViewId));
        if (semanticsNode2 == null) {
            return null;
        }
        if (semanticsNode2.platformViewId != -1) {
            return this.accessibilityViewEmbedder.getRootNode(this.platformViewsAccessibilityDelegate.getPlatformViewById(Integer.valueOf(semanticsNode2.platformViewId)), semanticsNode2.id, semanticsNode2.getGlobalRect());
        }
        AccessibilityNodeInfo result2 = AccessibilityNodeInfo.obtain(this.rootAccessibilityView, virtualViewId);
        if (Build.VERSION.SDK_INT >= 18) {
            result2.setViewIdResourceName("");
        }
        result2.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
        result2.setClassName("android.view.View");
        result2.setSource(this.rootAccessibilityView, virtualViewId);
        result2.setFocusable(semanticsNode2.isFocusable());
        SemanticsNode semanticsNode3 = this.inputFocusedSemanticsNode;
        if (semanticsNode3 != null) {
            result2.setFocused(semanticsNode3.id == virtualViewId);
        }
        SemanticsNode semanticsNode4 = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode4 != null) {
            result2.setAccessibilityFocused(semanticsNode4.id == virtualViewId);
        }
        if (semanticsNode2.hasFlag(Flag.IS_TEXT_FIELD)) {
            result2.setPassword(semanticsNode2.hasFlag(Flag.IS_OBSCURED));
            if (!semanticsNode2.hasFlag(Flag.IS_READ_ONLY)) {
                result2.setClassName("android.widget.EditText");
            }
            if (Build.VERSION.SDK_INT >= 18) {
                result2.setEditable(!semanticsNode2.hasFlag(Flag.IS_READ_ONLY));
                if (!(semanticsNode2.textSelectionBase == -1 || semanticsNode2.textSelectionExtent == -1)) {
                    result2.setTextSelection(semanticsNode2.textSelectionBase, semanticsNode2.textSelectionExtent);
                }
                if (Build.VERSION.SDK_INT > 18 && (semanticsNode = this.accessibilityFocusedSemanticsNode) != null && semanticsNode.id == virtualViewId) {
                    result2.setLiveRegion(1);
                }
            }
            int granularities = 0;
            if (semanticsNode2.hasAction(Action.MOVE_CURSOR_FORWARD_BY_CHARACTER)) {
                result2.addAction(256);
                granularities = 0 | 1;
            }
            if (semanticsNode2.hasAction(Action.MOVE_CURSOR_BACKWARD_BY_CHARACTER)) {
                result2.addAction(512);
                granularities |= 1;
            }
            if (semanticsNode2.hasAction(Action.MOVE_CURSOR_FORWARD_BY_WORD)) {
                result2.addAction(256);
                granularities |= 2;
            }
            if (semanticsNode2.hasAction(Action.MOVE_CURSOR_BACKWARD_BY_WORD)) {
                result2.addAction(512);
                granularities |= 2;
            }
            result2.setMovementGranularities(granularities);
            if (Build.VERSION.SDK_INT >= 21 && semanticsNode2.maxValueLength >= 0) {
                int length = semanticsNode2.value == null ? 0 : semanticsNode2.value.length();
                int access$2500 = (length - semanticsNode2.currentValueLength) + semanticsNode2.maxValueLength;
                result2.setMaxTextLength((length - semanticsNode2.currentValueLength) + semanticsNode2.maxValueLength);
            }
        }
        if (Build.VERSION.SDK_INT > 18) {
            if (semanticsNode2.hasAction(Action.SET_SELECTION)) {
                result2.addAction(131072);
            }
            if (semanticsNode2.hasAction(Action.COPY)) {
                result2.addAction(16384);
            }
            if (semanticsNode2.hasAction(Action.CUT)) {
                result2.addAction(65536);
            }
            if (semanticsNode2.hasAction(Action.PASTE)) {
                result2.addAction(32768);
            }
        }
        if (semanticsNode2.hasFlag(Flag.IS_BUTTON) || semanticsNode2.hasFlag(Flag.IS_LINK)) {
            result2.setClassName("android.widget.Button");
        }
        if (semanticsNode2.hasFlag(Flag.IS_IMAGE)) {
            result2.setClassName("android.widget.ImageView");
        }
        if (Build.VERSION.SDK_INT > 18 && semanticsNode2.hasAction(Action.DISMISS)) {
            result2.setDismissable(true);
            result2.addAction(1048576);
        }
        if (semanticsNode2.parent != null) {
            if (semanticsNode2.id <= 0) {
                Log.e(TAG, "Semantics node id is not > ROOT_NODE_ID.");
            }
            result2.setParent(this.rootAccessibilityView, semanticsNode2.parent.id);
        } else {
            if (semanticsNode2.id != 0) {
                Log.e(TAG, "Semantics node id does not equal ROOT_NODE_ID.");
            }
            result2.setParent(this.rootAccessibilityView);
        }
        Rect bounds = semanticsNode2.getGlobalRect();
        if (semanticsNode2.parent != null) {
            Rect parentBounds = semanticsNode2.parent.getGlobalRect();
            Rect boundsInParent = new Rect(bounds);
            boundsInParent.offset(-parentBounds.left, -parentBounds.top);
            result2.setBoundsInParent(boundsInParent);
        } else {
            result2.setBoundsInParent(bounds);
        }
        result2.setBoundsInScreen(bounds);
        result2.setVisibleToUser(true);
        result2.setEnabled(!semanticsNode2.hasFlag(Flag.HAS_ENABLED_STATE) || semanticsNode2.hasFlag(Flag.IS_ENABLED));
        if (semanticsNode2.hasAction(Action.TAP)) {
            if (Build.VERSION.SDK_INT < 21 || semanticsNode2.onTapOverride == null) {
                result2.addAction(16);
                result2.setClickable(true);
            } else {
                result2.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, semanticsNode2.onTapOverride.hint));
                result2.setClickable(true);
            }
        }
        if (semanticsNode2.hasAction(Action.LONG_PRESS)) {
            if (Build.VERSION.SDK_INT < 21 || semanticsNode2.onLongPressOverride == null) {
                result2.addAction(32);
                result2.setLongClickable(true);
            } else {
                result2.addAction(new AccessibilityNodeInfo.AccessibilityAction(32, semanticsNode2.onLongPressOverride.hint));
                result2.setLongClickable(true);
            }
        }
        if (semanticsNode2.hasAction(Action.SCROLL_LEFT) || semanticsNode2.hasAction(Action.SCROLL_UP) || semanticsNode2.hasAction(Action.SCROLL_RIGHT) || semanticsNode2.hasAction(Action.SCROLL_DOWN)) {
            result2.setScrollable(true);
            if (semanticsNode2.hasFlag(Flag.HAS_IMPLICIT_SCROLLING)) {
                if (semanticsNode2.hasAction(Action.SCROLL_LEFT) || semanticsNode2.hasAction(Action.SCROLL_RIGHT)) {
                    if (Build.VERSION.SDK_INT <= 19 || !shouldSetCollectionInfo(semanticsNode2)) {
                        result2.setClassName("android.widget.HorizontalScrollView");
                    } else {
                        result2.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(0, semanticsNode2.scrollChildren, false));
                    }
                } else if (Build.VERSION.SDK_INT <= 18 || !shouldSetCollectionInfo(semanticsNode2)) {
                    result2.setClassName("android.widget.ScrollView");
                } else {
                    result2.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(semanticsNode2.scrollChildren, 0, false));
                }
            }
            if (semanticsNode2.hasAction(Action.SCROLL_LEFT) || semanticsNode2.hasAction(Action.SCROLL_UP)) {
                result2.addAction(4096);
            }
            if (semanticsNode2.hasAction(Action.SCROLL_RIGHT) || semanticsNode2.hasAction(Action.SCROLL_DOWN)) {
                result2.addAction(8192);
            }
        }
        if (semanticsNode2.hasAction(Action.INCREASE) || semanticsNode2.hasAction(Action.DECREASE)) {
            result2.setClassName("android.widget.SeekBar");
            if (semanticsNode2.hasAction(Action.INCREASE)) {
                result2.addAction(4096);
            }
            if (semanticsNode2.hasAction(Action.DECREASE)) {
                result2.addAction(8192);
            }
        }
        if (semanticsNode2.hasFlag(Flag.IS_LIVE_REGION) && Build.VERSION.SDK_INT > 18) {
            result2.setLiveRegion(1);
        }
        if (semanticsNode2.hasFlag(Flag.IS_TEXT_FIELD)) {
            result2.setText(semanticsNode2.getValueLabelHint());
        } else if (!semanticsNode2.hasFlag(Flag.SCOPES_ROUTE)) {
            result2.setContentDescription(semanticsNode2.getValueLabelHint());
        }
        boolean hasCheckedState = semanticsNode2.hasFlag(Flag.HAS_CHECKED_STATE);
        boolean hasToggledState = semanticsNode2.hasFlag(Flag.HAS_TOGGLED_STATE);
        if (hasCheckedState && hasToggledState) {
            Log.e(TAG, "Expected semanticsNode to have checked state and toggled state.");
        }
        if (hasCheckedState || hasToggledState) {
            z = true;
        }
        result2.setCheckable(z);
        if (hasCheckedState) {
            result2.setChecked(semanticsNode2.hasFlag(Flag.IS_CHECKED));
            if (semanticsNode2.hasFlag(Flag.IS_IN_MUTUALLY_EXCLUSIVE_GROUP)) {
                result2.setClassName("android.widget.RadioButton");
            } else {
                result2.setClassName("android.widget.CheckBox");
            }
        } else if (hasToggledState) {
            result2.setChecked(semanticsNode2.hasFlag(Flag.IS_TOGGLED));
            result2.setClassName("android.widget.Switch");
        }
        result2.setSelected(semanticsNode2.hasFlag(Flag.IS_SELECTED));
        if (Build.VERSION.SDK_INT >= 28) {
            result2.setHeading(semanticsNode2.hasFlag(Flag.IS_HEADER));
        }
        SemanticsNode semanticsNode5 = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode5 == null || semanticsNode5.id != virtualViewId) {
            result2.addAction(64);
        } else {
            result2.addAction(128);
        }
        if (Build.VERSION.SDK_INT >= 21 && semanticsNode2.customAccessibilityActions != null) {
            for (CustomAccessibilityAction action : semanticsNode2.customAccessibilityActions) {
                result2.addAction(new AccessibilityNodeInfo.AccessibilityAction(action.resourceId, action.label));
            }
        }
        for (SemanticsNode child : semanticsNode2.childrenInTraversalOrder) {
            if (!child.hasFlag(Flag.IS_HIDDEN)) {
                result2.addChild(this.rootAccessibilityView, child.id);
            }
        }
        return result2;
    }

    public boolean performAction(int virtualViewId, int accessibilityAction, Bundle arguments) {
        if (virtualViewId >= 65536) {
            boolean didPerform = this.accessibilityViewEmbedder.performAction(virtualViewId, accessibilityAction, arguments);
            if (didPerform && accessibilityAction == 128) {
                this.embeddedAccessibilityFocusedNodeId = null;
            }
            return didPerform;
        }
        SemanticsNode semanticsNode = this.flutterSemanticsTree.get(Integer.valueOf(virtualViewId));
        boolean hasSelection = false;
        if (semanticsNode == null) {
            return false;
        }
        switch (accessibilityAction) {
            case 16:
                this.accessibilityChannel.dispatchSemanticsAction(virtualViewId, Action.TAP);
                return true;
            case 32:
                this.accessibilityChannel.dispatchSemanticsAction(virtualViewId, Action.LONG_PRESS);
                return true;
            case 64:
                this.accessibilityChannel.dispatchSemanticsAction(virtualViewId, Action.DID_GAIN_ACCESSIBILITY_FOCUS);
                sendAccessibilityEvent(virtualViewId, 32768);
                if (this.accessibilityFocusedSemanticsNode == null) {
                    this.rootAccessibilityView.invalidate();
                }
                this.accessibilityFocusedSemanticsNode = semanticsNode;
                if (semanticsNode.hasAction(Action.INCREASE) || semanticsNode.hasAction(Action.DECREASE)) {
                    sendAccessibilityEvent(virtualViewId, 4);
                }
                return true;
            case 128:
                this.accessibilityChannel.dispatchSemanticsAction(virtualViewId, Action.DID_LOSE_ACCESSIBILITY_FOCUS);
                sendAccessibilityEvent(virtualViewId, 65536);
                this.accessibilityFocusedSemanticsNode = null;
                this.embeddedAccessibilityFocusedNodeId = null;
                return true;
            case 256:
                if (Build.VERSION.SDK_INT < 18) {
                    return false;
                }
                return performCursorMoveAction(semanticsNode, virtualViewId, arguments, true);
            case 512:
                if (Build.VERSION.SDK_INT < 18) {
                    return false;
                }
                return performCursorMoveAction(semanticsNode, virtualViewId, arguments, false);
            case 4096:
                if (semanticsNode.hasAction(Action.SCROLL_UP)) {
                    this.accessibilityChannel.dispatchSemanticsAction(virtualViewId, Action.SCROLL_UP);
                } else if (semanticsNode.hasAction(Action.SCROLL_LEFT)) {
                    this.accessibilityChannel.dispatchSemanticsAction(virtualViewId, Action.SCROLL_LEFT);
                } else if (!semanticsNode.hasAction(Action.INCREASE)) {
                    return false;
                } else {
                    String unused = semanticsNode.value = semanticsNode.increasedValue;
                    sendAccessibilityEvent(virtualViewId, 4);
                    this.accessibilityChannel.dispatchSemanticsAction(virtualViewId, Action.INCREASE);
                }
                return true;
            case 8192:
                if (semanticsNode.hasAction(Action.SCROLL_DOWN)) {
                    this.accessibilityChannel.dispatchSemanticsAction(virtualViewId, Action.SCROLL_DOWN);
                } else if (semanticsNode.hasAction(Action.SCROLL_RIGHT)) {
                    this.accessibilityChannel.dispatchSemanticsAction(virtualViewId, Action.SCROLL_RIGHT);
                } else if (!semanticsNode.hasAction(Action.DECREASE)) {
                    return false;
                } else {
                    String unused2 = semanticsNode.value = semanticsNode.decreasedValue;
                    sendAccessibilityEvent(virtualViewId, 4);
                    this.accessibilityChannel.dispatchSemanticsAction(virtualViewId, Action.DECREASE);
                }
                return true;
            case 16384:
                this.accessibilityChannel.dispatchSemanticsAction(virtualViewId, Action.COPY);
                return true;
            case 32768:
                this.accessibilityChannel.dispatchSemanticsAction(virtualViewId, Action.PASTE);
                return true;
            case 65536:
                this.accessibilityChannel.dispatchSemanticsAction(virtualViewId, Action.CUT);
                return true;
            case 131072:
                if (Build.VERSION.SDK_INT < 18) {
                    return false;
                }
                Map<String, Integer> selection = new HashMap<>();
                if (arguments != null && arguments.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_START_INT) && arguments.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_END_INT)) {
                    hasSelection = true;
                }
                if (hasSelection) {
                    selection.put("base", Integer.valueOf(arguments.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_START_INT)));
                    selection.put("extent", Integer.valueOf(arguments.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_END_INT)));
                } else {
                    selection.put("base", Integer.valueOf(semanticsNode.textSelectionExtent));
                    selection.put("extent", Integer.valueOf(semanticsNode.textSelectionExtent));
                }
                this.accessibilityChannel.dispatchSemanticsAction(virtualViewId, Action.SET_SELECTION, selection);
                return true;
            case 1048576:
                this.accessibilityChannel.dispatchSemanticsAction(virtualViewId, Action.DISMISS);
                return true;
            case ACTION_SHOW_ON_SCREEN /*16908342*/:
                this.accessibilityChannel.dispatchSemanticsAction(virtualViewId, Action.SHOW_ON_SCREEN);
                return true;
            default:
                CustomAccessibilityAction contextAction = this.customAccessibilityActions.get(Integer.valueOf(accessibilityAction - FIRST_RESOURCE_ID));
                if (contextAction == null) {
                    return false;
                }
                this.accessibilityChannel.dispatchSemanticsAction(virtualViewId, Action.CUSTOM_ACTION, Integer.valueOf(contextAction.id));
                return true;
        }
    }

    private boolean performCursorMoveAction(SemanticsNode semanticsNode, int virtualViewId, Bundle arguments, boolean forward) {
        int granularity = arguments.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT);
        boolean extendSelection = arguments.getBoolean(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN);
        if (granularity != 1) {
            if (granularity != 2) {
                return false;
            }
            if (forward && semanticsNode.hasAction(Action.MOVE_CURSOR_FORWARD_BY_WORD)) {
                this.accessibilityChannel.dispatchSemanticsAction(virtualViewId, Action.MOVE_CURSOR_FORWARD_BY_WORD, Boolean.valueOf(extendSelection));
                return true;
            } else if (forward || !semanticsNode.hasAction(Action.MOVE_CURSOR_BACKWARD_BY_WORD)) {
                return false;
            } else {
                this.accessibilityChannel.dispatchSemanticsAction(virtualViewId, Action.MOVE_CURSOR_BACKWARD_BY_WORD, Boolean.valueOf(extendSelection));
                return true;
            }
        } else if (forward && semanticsNode.hasAction(Action.MOVE_CURSOR_FORWARD_BY_CHARACTER)) {
            this.accessibilityChannel.dispatchSemanticsAction(virtualViewId, Action.MOVE_CURSOR_FORWARD_BY_CHARACTER, Boolean.valueOf(extendSelection));
            return true;
        } else if (forward || !semanticsNode.hasAction(Action.MOVE_CURSOR_BACKWARD_BY_CHARACTER)) {
            return false;
        } else {
            this.accessibilityChannel.dispatchSemanticsAction(virtualViewId, Action.MOVE_CURSOR_BACKWARD_BY_CHARACTER, Boolean.valueOf(extendSelection));
            return true;
        }
    }

    public AccessibilityNodeInfo findFocus(int focus) {
        if (focus == 1) {
            SemanticsNode semanticsNode = this.inputFocusedSemanticsNode;
            if (semanticsNode != null) {
                return createAccessibilityNodeInfo(semanticsNode.id);
            }
            Integer num = this.embeddedInputFocusedNodeId;
            if (num != null) {
                return createAccessibilityNodeInfo(num.intValue());
            }
        } else if (focus != 2) {
            return null;
        }
        SemanticsNode semanticsNode2 = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode2 != null) {
            return createAccessibilityNodeInfo(semanticsNode2.id);
        }
        Integer num2 = this.embeddedAccessibilityFocusedNodeId;
        if (num2 != null) {
            return createAccessibilityNodeInfo(num2.intValue());
        }
        return null;
    }

    private SemanticsNode getRootSemanticsNode() {
        if (!this.flutterSemanticsTree.containsKey(0)) {
            Log.e(TAG, "Attempted to getRootSemanticsNode without a root semantics node.");
        }
        return this.flutterSemanticsTree.get(0);
    }

    /* access modifiers changed from: private */
    public SemanticsNode getOrCreateSemanticsNode(int id) {
        SemanticsNode semanticsNode = this.flutterSemanticsTree.get(Integer.valueOf(id));
        if (semanticsNode != null) {
            return semanticsNode;
        }
        SemanticsNode semanticsNode2 = new SemanticsNode(this);
        int unused = semanticsNode2.id = id;
        this.flutterSemanticsTree.put(Integer.valueOf(id), semanticsNode2);
        return semanticsNode2;
    }

    /* access modifiers changed from: private */
    public CustomAccessibilityAction getOrCreateAccessibilityAction(int id) {
        CustomAccessibilityAction action = this.customAccessibilityActions.get(Integer.valueOf(id));
        if (action != null) {
            return action;
        }
        CustomAccessibilityAction action2 = new CustomAccessibilityAction();
        int unused = action2.id = id;
        int unused2 = action2.resourceId = FIRST_RESOURCE_ID + id;
        this.customAccessibilityActions.put(Integer.valueOf(id), action2);
        return action2;
    }

    public boolean onAccessibilityHoverEvent(MotionEvent event) {
        if (!this.accessibilityManager.isTouchExplorationEnabled() || this.flutterSemanticsTree.isEmpty()) {
            return false;
        }
        SemanticsNode semanticsNodeUnderCursor = getRootSemanticsNode().hitTest(new float[]{event.getX(), event.getY(), 0.0f, 1.0f});
        if (semanticsNodeUnderCursor != null && semanticsNodeUnderCursor.platformViewId != -1) {
            return this.accessibilityViewEmbedder.onAccessibilityHoverEvent(semanticsNodeUnderCursor.id, event);
        }
        if (event.getAction() == 9 || event.getAction() == 7) {
            handleTouchExploration(event.getX(), event.getY());
        } else if (event.getAction() == 10) {
            onTouchExplorationExit();
        } else {
            Log.d("flutter", "unexpected accessibility hover event: " + event);
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void onTouchExplorationExit() {
        SemanticsNode semanticsNode = this.hoveredObject;
        if (semanticsNode != null) {
            sendAccessibilityEvent(semanticsNode.id, 256);
            this.hoveredObject = null;
        }
    }

    private void handleTouchExploration(float x, float y) {
        SemanticsNode semanticsNodeUnderCursor;
        if (!this.flutterSemanticsTree.isEmpty() && (semanticsNodeUnderCursor = getRootSemanticsNode().hitTest(new float[]{x, y, 0.0f, 1.0f})) != this.hoveredObject) {
            if (semanticsNodeUnderCursor != null) {
                sendAccessibilityEvent(semanticsNodeUnderCursor.id, 128);
            }
            SemanticsNode semanticsNode = this.hoveredObject;
            if (semanticsNode != null) {
                sendAccessibilityEvent(semanticsNode.id, 256);
            }
            this.hoveredObject = semanticsNodeUnderCursor;
        }
    }

    /* access modifiers changed from: package-private */
    public void updateCustomAccessibilityActions(ByteBuffer buffer, String[] strings) {
        while (buffer.hasRemaining()) {
            CustomAccessibilityAction action = getOrCreateAccessibilityAction(buffer.getInt());
            int unused = action.overrideId = buffer.getInt();
            int stringIndex = buffer.getInt();
            String str = null;
            String unused2 = action.label = stringIndex == -1 ? null : strings[stringIndex];
            int stringIndex2 = buffer.getInt();
            if (stringIndex2 != -1) {
                str = strings[stringIndex2];
            }
            String unused3 = action.hint = str;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: io.flutter.view.AccessibilityBridge$SemanticsNode} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateSemantics(java.nio.ByteBuffer r19, java.lang.String[] r20) {
        /*
            r18 = this;
            r0 = r18
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
        L_0x0007:
            boolean r2 = r19.hasRemaining()
            if (r2 == 0) goto L_0x0039
            int r2 = r19.getInt()
            io.flutter.view.AccessibilityBridge$SemanticsNode r3 = r0.getOrCreateSemanticsNode(r2)
            r4 = r19
            r5 = r20
            r3.updateWith(r4, r5)
            io.flutter.view.AccessibilityBridge$Flag r6 = io.flutter.view.AccessibilityBridge.Flag.IS_HIDDEN
            boolean r6 = r3.hasFlag(r6)
            if (r6 == 0) goto L_0x0025
            goto L_0x0007
        L_0x0025:
            io.flutter.view.AccessibilityBridge$Flag r6 = io.flutter.view.AccessibilityBridge.Flag.IS_FOCUSED
            boolean r6 = r3.hasFlag(r6)
            if (r6 == 0) goto L_0x002f
            r0.inputFocusedSemanticsNode = r3
        L_0x002f:
            boolean r6 = r3.hadPreviousConfig
            if (r6 == 0) goto L_0x0038
            r1.add(r3)
        L_0x0038:
            goto L_0x0007
        L_0x0039:
            r4 = r19
            r5 = r20
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            io.flutter.view.AccessibilityBridge$SemanticsNode r3 = r18.getRootSemanticsNode()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r7 = 0
            r8 = 1
            if (r3 == 0) goto L_0x0093
            r9 = 16
            float[] r9 = new float[r9]
            android.opengl.Matrix.setIdentityM(r9, r7)
            int r10 = android.os.Build.VERSION.SDK_INT
            r11 = 23
            if (r10 < r11) goto L_0x008d
            android.view.View r10 = r0.rootAccessibilityView
            android.view.WindowInsets r10 = r10.getRootWindowInsets()
            if (r10 == 0) goto L_0x008d
            java.lang.Integer r11 = r0.lastLeftFrameInset
            int r12 = r10.getSystemWindowInsetLeft()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x007a
            boolean unused = r3.globalGeometryDirty = r8
            boolean unused = r3.inverseTransformDirty = r8
        L_0x007a:
            int r11 = r10.getSystemWindowInsetLeft()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r0.lastLeftFrameInset = r11
            int r11 = r11.intValue()
            float r11 = (float) r11
            r12 = 0
            android.opengl.Matrix.translateM(r9, r7, r11, r12, r12)
        L_0x008d:
            r3.updateRecursively(r9, r2, r7)
            r3.collectRoutes(r6)
        L_0x0093:
            r9 = 0
            java.util.Iterator r10 = r6.iterator()
        L_0x0098:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x00b6
            java.lang.Object r11 = r10.next()
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = (io.flutter.view.AccessibilityBridge.SemanticsNode) r11
            java.util.List<java.lang.Integer> r12 = r0.flutterNavigationStack
            int r13 = r11.id
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            boolean r12 = r12.contains(r13)
            if (r12 != 0) goto L_0x00b5
            r9 = r11
        L_0x00b5:
            goto L_0x0098
        L_0x00b6:
            if (r9 != 0) goto L_0x00ca
            int r10 = r6.size()
            if (r10 <= 0) goto L_0x00ca
            int r10 = r6.size()
            int r10 = r10 - r8
            java.lang.Object r10 = r6.get(r10)
            r9 = r10
            io.flutter.view.AccessibilityBridge$SemanticsNode r9 = (io.flutter.view.AccessibilityBridge.SemanticsNode) r9
        L_0x00ca:
            if (r9 == 0) goto L_0x00dd
            int r10 = r9.id
            int r11 = r0.previousRouteId
            if (r10 == r11) goto L_0x00dd
            int r10 = r9.id
            r0.previousRouteId = r10
            r0.sendWindowChangeEvent(r9)
        L_0x00dd:
            java.util.List<java.lang.Integer> r10 = r0.flutterNavigationStack
            r10.clear()
            java.util.Iterator r10 = r6.iterator()
        L_0x00e6:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0100
            java.lang.Object r11 = r10.next()
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = (io.flutter.view.AccessibilityBridge.SemanticsNode) r11
            java.util.List<java.lang.Integer> r12 = r0.flutterNavigationStack
            int r13 = r11.id
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r12.add(r13)
            goto L_0x00e6
        L_0x0100:
            java.util.Map<java.lang.Integer, io.flutter.view.AccessibilityBridge$SemanticsNode> r10 = r0.flutterSemanticsTree
            java.util.Set r10 = r10.entrySet()
            java.util.Iterator r10 = r10.iterator()
        L_0x010a:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0129
            java.lang.Object r11 = r10.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            java.lang.Object r12 = r11.getValue()
            io.flutter.view.AccessibilityBridge$SemanticsNode r12 = (io.flutter.view.AccessibilityBridge.SemanticsNode) r12
            boolean r13 = r2.contains(r12)
            if (r13 != 0) goto L_0x0128
            r0.willRemoveSemanticsNode(r12)
            r10.remove()
        L_0x0128:
            goto L_0x010a
        L_0x0129:
            r0.sendWindowContentChangeEvent(r7)
            java.util.Iterator r7 = r1.iterator()
        L_0x0130:
            boolean r11 = r7.hasNext()
            if (r11 == 0) goto L_0x0356
            java.lang.Object r11 = r7.next()
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = (io.flutter.view.AccessibilityBridge.SemanticsNode) r11
            boolean r12 = r11.didScroll()
            if (r12 == 0) goto L_0x0236
            int r12 = r11.id
            r13 = 4096(0x1000, float:5.74E-42)
            android.view.accessibility.AccessibilityEvent r12 = r0.obtainAccessibilityEvent(r12, r13)
            float r13 = r11.scrollPosition
            float r14 = r11.scrollExtentMax
            float r15 = r11.scrollExtentMax
            boolean r15 = java.lang.Float.isInfinite(r15)
            if (r15 == 0) goto L_0x016c
            r14 = 1203982336(0x47c35000, float:100000.0)
            r15 = 1200142336(0x4788b800, float:70000.0)
            int r15 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r15 <= 0) goto L_0x016c
            r13 = 1200142336(0x4788b800, float:70000.0)
        L_0x016c:
            float r15 = r11.scrollExtentMin
            boolean r15 = java.lang.Float.isInfinite(r15)
            if (r15 == 0) goto L_0x0186
            r15 = 1203982336(0x47c35000, float:100000.0)
            float r14 = r14 + r15
            r16 = -947341312(0xffffffffc788b800, float:-70000.0)
            int r16 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r16 >= 0) goto L_0x0184
            r13 = -947341312(0xffffffffc788b800, float:-70000.0)
        L_0x0184:
            float r13 = r13 + r15
            goto L_0x0190
        L_0x0186:
            float r15 = r11.scrollExtentMin
            float r14 = r14 - r15
            float r15 = r11.scrollExtentMin
            float r13 = r13 - r15
        L_0x0190:
            io.flutter.view.AccessibilityBridge$Action r15 = io.flutter.view.AccessibilityBridge.Action.SCROLL_UP
            boolean r15 = r11.hadAction(r15)
            if (r15 != 0) goto L_0x01ba
            io.flutter.view.AccessibilityBridge$Action r15 = io.flutter.view.AccessibilityBridge.Action.SCROLL_DOWN
            boolean r15 = r11.hadAction(r15)
            if (r15 == 0) goto L_0x01a1
            goto L_0x01ba
        L_0x01a1:
            io.flutter.view.AccessibilityBridge$Action r15 = io.flutter.view.AccessibilityBridge.Action.SCROLL_LEFT
            boolean r15 = r11.hadAction(r15)
            if (r15 != 0) goto L_0x01b1
            io.flutter.view.AccessibilityBridge$Action r15 = io.flutter.view.AccessibilityBridge.Action.SCROLL_RIGHT
            boolean r15 = r11.hadAction(r15)
            if (r15 == 0) goto L_0x01c2
        L_0x01b1:
            int r15 = (int) r13
            r12.setScrollX(r15)
            int r15 = (int) r14
            r12.setMaxScrollX(r15)
            goto L_0x01c2
        L_0x01ba:
            int r15 = (int) r13
            r12.setScrollY(r15)
            int r15 = (int) r14
            r12.setMaxScrollY(r15)
        L_0x01c2:
            int r15 = r11.scrollChildren
            if (r15 <= 0) goto L_0x022d
            int r15 = r11.scrollChildren
            r12.setItemCount(r15)
            int r15 = r11.scrollIndex
            r12.setFromIndex(r15)
            r15 = 0
            java.util.List r16 = r11.childrenInHitTestOrder
            java.util.Iterator r16 = r16.iterator()
        L_0x01df:
            boolean r17 = r16.hasNext()
            if (r17 == 0) goto L_0x01fd
            java.lang.Object r17 = r16.next()
            r8 = r17
            io.flutter.view.AccessibilityBridge$SemanticsNode r8 = (io.flutter.view.AccessibilityBridge.SemanticsNode) r8
            r17 = r1
            io.flutter.view.AccessibilityBridge$Flag r1 = io.flutter.view.AccessibilityBridge.Flag.IS_HIDDEN
            boolean r1 = r8.hasFlag(r1)
            if (r1 != 0) goto L_0x01f9
            int r15 = r15 + 1
        L_0x01f9:
            r1 = r17
            r8 = 1
            goto L_0x01df
        L_0x01fd:
            r17 = r1
            int r1 = r11.scrollIndex
            int r1 = r1 + r15
            int r8 = r11.scrollChildren
            r16 = r2
            java.lang.String r2 = "AccessibilityBridge"
            if (r1 <= r8) goto L_0x0213
            java.lang.String r1 = "Scroll index is out of bounds."
            android.util.Log.e(r2, r1)
        L_0x0213:
            java.util.List r1 = r11.childrenInHitTestOrder
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0222
            java.lang.String r1 = "Had scrollChildren but no childrenInHitTestOrder"
            android.util.Log.e(r2, r1)
        L_0x0222:
            int r1 = r11.scrollIndex
            int r1 = r1 + r15
            r2 = 1
            int r1 = r1 - r2
            r12.setToIndex(r1)
            goto L_0x0232
        L_0x022d:
            r17 = r1
            r16 = r2
            r2 = r8
        L_0x0232:
            r0.sendAccessibilityEvent(r12)
            goto L_0x023b
        L_0x0236:
            r17 = r1
            r16 = r2
            r2 = r8
        L_0x023b:
            io.flutter.view.AccessibilityBridge$Flag r1 = io.flutter.view.AccessibilityBridge.Flag.IS_LIVE_REGION
            boolean r1 = r11.hasFlag(r1)
            if (r1 == 0) goto L_0x0250
            boolean r1 = r11.didChangeLabel()
            if (r1 == 0) goto L_0x0250
            int r1 = r11.id
            r0.sendWindowContentChangeEvent(r1)
        L_0x0250:
            io.flutter.view.AccessibilityBridge$SemanticsNode r1 = r0.accessibilityFocusedSemanticsNode
            if (r1 == 0) goto L_0x0286
            int r1 = r1.id
            int r8 = r11.id
            if (r1 != r8) goto L_0x0286
            io.flutter.view.AccessibilityBridge$Flag r1 = io.flutter.view.AccessibilityBridge.Flag.IS_SELECTED
            boolean r1 = r11.hadFlag(r1)
            if (r1 != 0) goto L_0x0286
            io.flutter.view.AccessibilityBridge$Flag r1 = io.flutter.view.AccessibilityBridge.Flag.IS_SELECTED
            boolean r1 = r11.hasFlag(r1)
            if (r1 == 0) goto L_0x0286
            int r1 = r11.id
            r8 = 4
            android.view.accessibility.AccessibilityEvent r1 = r0.obtainAccessibilityEvent(r1, r8)
            java.util.List r8 = r1.getText()
            java.lang.String r12 = r11.label
            r8.add(r12)
            r0.sendAccessibilityEvent(r1)
        L_0x0286:
            io.flutter.view.AccessibilityBridge$SemanticsNode r1 = r0.inputFocusedSemanticsNode
            if (r1 == 0) goto L_0x02b7
            int r1 = r1.id
            int r8 = r11.id
            if (r1 != r8) goto L_0x02b7
            io.flutter.view.AccessibilityBridge$SemanticsNode r1 = r0.lastInputFocusedSemanticsNode
            if (r1 == 0) goto L_0x02a4
            int r1 = r1.id
            io.flutter.view.AccessibilityBridge$SemanticsNode r8 = r0.inputFocusedSemanticsNode
            int r8 = r8.id
            if (r1 == r8) goto L_0x02b7
        L_0x02a4:
            io.flutter.view.AccessibilityBridge$SemanticsNode r1 = r0.inputFocusedSemanticsNode
            r0.lastInputFocusedSemanticsNode = r1
            int r1 = r11.id
            r8 = 8
            android.view.accessibility.AccessibilityEvent r1 = r0.obtainAccessibilityEvent(r1, r8)
            r0.sendAccessibilityEvent(r1)
            goto L_0x02be
        L_0x02b7:
            io.flutter.view.AccessibilityBridge$SemanticsNode r1 = r0.inputFocusedSemanticsNode
            if (r1 != 0) goto L_0x02be
            r1 = 0
            r0.lastInputFocusedSemanticsNode = r1
        L_0x02be:
            io.flutter.view.AccessibilityBridge$SemanticsNode r1 = r0.inputFocusedSemanticsNode
            if (r1 == 0) goto L_0x034f
            int r1 = r1.id
            int r8 = r11.id
            if (r1 != r8) goto L_0x034f
            io.flutter.view.AccessibilityBridge$Flag r1 = io.flutter.view.AccessibilityBridge.Flag.IS_TEXT_FIELD
            boolean r1 = r11.hadFlag(r1)
            if (r1 == 0) goto L_0x034f
            io.flutter.view.AccessibilityBridge$Flag r1 = io.flutter.view.AccessibilityBridge.Flag.IS_TEXT_FIELD
            boolean r1 = r11.hasFlag(r1)
            if (r1 == 0) goto L_0x034f
            io.flutter.view.AccessibilityBridge$SemanticsNode r1 = r0.accessibilityFocusedSemanticsNode
            if (r1 == 0) goto L_0x02ec
            int r1 = r1.id
            io.flutter.view.AccessibilityBridge$SemanticsNode r8 = r0.inputFocusedSemanticsNode
            int r8 = r8.id
            if (r1 != r8) goto L_0x034f
        L_0x02ec:
            java.lang.String r1 = r11.previousValue
            java.lang.String r8 = ""
            if (r1 == 0) goto L_0x02f9
            java.lang.String r1 = r11.previousValue
            goto L_0x02fa
        L_0x02f9:
            r1 = r8
        L_0x02fa:
            java.lang.String r12 = r11.value
            if (r12 == 0) goto L_0x0304
            java.lang.String r8 = r11.value
        L_0x0304:
            int r12 = r11.id
            android.view.accessibility.AccessibilityEvent r12 = r0.createTextChangedEvent(r12, r1, r8)
            if (r12 == 0) goto L_0x0311
            r0.sendAccessibilityEvent(r12)
        L_0x0311:
            int r13 = r11.previousTextSelectionBase
            int r14 = r11.textSelectionBase
            if (r13 != r14) goto L_0x0325
            int r13 = r11.previousTextSelectionExtent
            int r14 = r11.textSelectionExtent
            if (r13 == r14) goto L_0x034f
        L_0x0325:
            int r13 = r11.id
            r14 = 8192(0x2000, float:1.14794E-41)
            android.view.accessibility.AccessibilityEvent r13 = r0.obtainAccessibilityEvent(r13, r14)
            java.util.List r14 = r13.getText()
            r14.add(r8)
            int r14 = r11.textSelectionBase
            r13.setFromIndex(r14)
            int r14 = r11.textSelectionExtent
            r13.setToIndex(r14)
            int r14 = r8.length()
            r13.setItemCount(r14)
            r0.sendAccessibilityEvent(r13)
        L_0x034f:
            r8 = r2
            r2 = r16
            r1 = r17
            goto L_0x0130
        L_0x0356:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.AccessibilityBridge.updateSemantics(java.nio.ByteBuffer, java.lang.String[]):void");
    }

    private AccessibilityEvent createTextChangedEvent(int id, String oldValue, String newValue) {
        AccessibilityEvent e = obtainAccessibilityEvent(id, 16);
        e.setBeforeText(oldValue);
        e.getText().add(newValue);
        int i = 0;
        while (i < oldValue.length() && i < newValue.length() && oldValue.charAt(i) == newValue.charAt(i)) {
            i++;
        }
        if (i >= oldValue.length() && i >= newValue.length()) {
            return null;
        }
        int firstDifference = i;
        e.setFromIndex(firstDifference);
        int oldIndex = oldValue.length() - 1;
        int newIndex = newValue.length() - 1;
        while (oldIndex >= firstDifference && newIndex >= firstDifference && oldValue.charAt(oldIndex) == newValue.charAt(newIndex)) {
            oldIndex--;
            newIndex--;
        }
        e.setRemovedCount((oldIndex - firstDifference) + 1);
        e.setAddedCount((newIndex - firstDifference) + 1);
        return e;
    }

    /* access modifiers changed from: private */
    public void sendAccessibilityEvent(int viewId, int eventType) {
        if (this.accessibilityManager.isEnabled()) {
            sendAccessibilityEvent(obtainAccessibilityEvent(viewId, eventType));
        }
    }

    /* access modifiers changed from: private */
    public void sendAccessibilityEvent(AccessibilityEvent event) {
        if (this.accessibilityManager.isEnabled()) {
            this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(this.rootAccessibilityView, event);
        }
    }

    private void sendWindowChangeEvent(SemanticsNode route) {
        AccessibilityEvent event = obtainAccessibilityEvent(route.id, 32);
        String routeName = route.getRouteName();
        if (routeName == null) {
            routeName = " ";
        }
        event.getText().add(routeName);
        sendAccessibilityEvent(event);
    }

    private void sendWindowContentChangeEvent(int virtualViewId) {
        AccessibilityEvent event = obtainAccessibilityEvent(virtualViewId, 2048);
        if (Build.VERSION.SDK_INT >= 19) {
            event.setContentChangeTypes(1);
        }
        sendAccessibilityEvent(event);
    }

    /* access modifiers changed from: private */
    public AccessibilityEvent obtainAccessibilityEvent(int virtualViewId, int eventType) {
        AccessibilityEvent event = AccessibilityEvent.obtain(eventType);
        event.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
        event.setSource(this.rootAccessibilityView, virtualViewId);
        return event;
    }

    private void willRemoveSemanticsNode(SemanticsNode semanticsNodeToBeRemoved) {
        Integer num;
        if (!this.flutterSemanticsTree.containsKey(Integer.valueOf(semanticsNodeToBeRemoved.id))) {
            Log.e(TAG, "Attempted to remove a node that is not in the tree.");
        }
        if (this.flutterSemanticsTree.get(Integer.valueOf(semanticsNodeToBeRemoved.id)) != semanticsNodeToBeRemoved) {
            Log.e(TAG, "Flutter semantics tree failed to get expected node when searching by id.");
        }
        SemanticsNode unused = semanticsNodeToBeRemoved.parent = null;
        if (!(semanticsNodeToBeRemoved.platformViewId == -1 || (num = this.embeddedAccessibilityFocusedNodeId) == null || this.accessibilityViewEmbedder.platformViewOfNode(num.intValue()) != this.platformViewsAccessibilityDelegate.getPlatformViewById(Integer.valueOf(semanticsNodeToBeRemoved.platformViewId)))) {
            sendAccessibilityEvent(this.embeddedAccessibilityFocusedNodeId.intValue(), 65536);
            this.embeddedAccessibilityFocusedNodeId = null;
        }
        SemanticsNode semanticsNode = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode == semanticsNodeToBeRemoved) {
            sendAccessibilityEvent(semanticsNode.id, 65536);
            this.accessibilityFocusedSemanticsNode = null;
        }
        if (this.inputFocusedSemanticsNode == semanticsNodeToBeRemoved) {
            this.inputFocusedSemanticsNode = null;
        }
        if (this.hoveredObject == semanticsNodeToBeRemoved) {
            this.hoveredObject = null;
        }
    }

    public void reset() {
        this.flutterSemanticsTree.clear();
        SemanticsNode semanticsNode = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode != null) {
            sendAccessibilityEvent(semanticsNode.id, 65536);
        }
        this.accessibilityFocusedSemanticsNode = null;
        this.hoveredObject = null;
        sendWindowContentChangeEvent(0);
    }

    public enum Action {
        TAP(1),
        LONG_PRESS(2),
        SCROLL_LEFT(4),
        SCROLL_RIGHT(8),
        SCROLL_UP(16),
        SCROLL_DOWN(32),
        INCREASE(64),
        DECREASE(128),
        SHOW_ON_SCREEN(256),
        MOVE_CURSOR_FORWARD_BY_CHARACTER(512),
        MOVE_CURSOR_BACKWARD_BY_CHARACTER(1024),
        SET_SELECTION(2048),
        COPY(4096),
        CUT(8192),
        PASTE(16384),
        DID_GAIN_ACCESSIBILITY_FOCUS(32768),
        DID_LOSE_ACCESSIBILITY_FOCUS(65536),
        CUSTOM_ACTION(131072),
        DISMISS(262144),
        MOVE_CURSOR_FORWARD_BY_WORD(524288),
        MOVE_CURSOR_BACKWARD_BY_WORD(1048576);
        
        public final int value;

        private Action(int value2) {
            this.value = value2;
        }
    }

    enum Flag {
        HAS_CHECKED_STATE(1),
        IS_CHECKED(2),
        IS_SELECTED(4),
        IS_BUTTON(8),
        IS_TEXT_FIELD(16),
        IS_FOCUSED(32),
        HAS_ENABLED_STATE(64),
        IS_ENABLED(128),
        IS_IN_MUTUALLY_EXCLUSIVE_GROUP(256),
        IS_HEADER(512),
        IS_OBSCURED(1024),
        SCOPES_ROUTE(2048),
        NAMES_ROUTE(4096),
        IS_HIDDEN(8192),
        IS_IMAGE(16384),
        IS_LIVE_REGION(32768),
        HAS_TOGGLED_STATE(65536),
        IS_TOGGLED(131072),
        HAS_IMPLICIT_SCROLLING(262144),
        IS_READ_ONLY(1048576),
        IS_FOCUSABLE(2097152),
        IS_LINK(4194304);
        
        final int value;

        private Flag(int value2) {
            this.value = value2;
        }
    }

    private enum AccessibilityFeature {
        ACCESSIBLE_NAVIGATION(1),
        INVERT_COLORS(2),
        DISABLE_ANIMATIONS(4);
        
        final int value;

        private AccessibilityFeature(int value2) {
            this.value = value2;
        }
    }

    private enum TextDirection {
        UNKNOWN,
        LTR,
        RTL;

        public static TextDirection fromInt(int value) {
            if (value == 1) {
                return RTL;
            }
            if (value != 2) {
                return UNKNOWN;
            }
            return LTR;
        }
    }

    private static class CustomAccessibilityAction {
        /* access modifiers changed from: private */
        public String hint;
        /* access modifiers changed from: private */
        public int id = -1;
        /* access modifiers changed from: private */
        public String label;
        /* access modifiers changed from: private */
        public int overrideId = -1;
        /* access modifiers changed from: private */
        public int resourceId = -1;

        CustomAccessibilityAction() {
        }
    }

    private static class SemanticsNode {
        final AccessibilityBridge accessibilityBridge;
        private int actions;
        private float bottom;
        /* access modifiers changed from: private */
        public List<SemanticsNode> childrenInHitTestOrder = new ArrayList();
        /* access modifiers changed from: private */
        public List<SemanticsNode> childrenInTraversalOrder = new ArrayList();
        /* access modifiers changed from: private */
        public int currentValueLength;
        /* access modifiers changed from: private */
        public List<CustomAccessibilityAction> customAccessibilityActions;
        /* access modifiers changed from: private */
        public String decreasedValue;
        private int flags;
        /* access modifiers changed from: private */
        public boolean globalGeometryDirty = true;
        private Rect globalRect;
        private float[] globalTransform;
        /* access modifiers changed from: private */
        public boolean hadPreviousConfig = false;
        private String hint;
        /* access modifiers changed from: private */
        public int id = -1;
        /* access modifiers changed from: private */
        public String increasedValue;
        private float[] inverseTransform;
        /* access modifiers changed from: private */
        public boolean inverseTransformDirty = true;
        /* access modifiers changed from: private */
        public String label;
        private float left;
        /* access modifiers changed from: private */
        public int maxValueLength;
        /* access modifiers changed from: private */
        public CustomAccessibilityAction onLongPressOverride;
        /* access modifiers changed from: private */
        public CustomAccessibilityAction onTapOverride;
        /* access modifiers changed from: private */
        public SemanticsNode parent;
        /* access modifiers changed from: private */
        public int platformViewId;
        private int previousActions;
        private int previousFlags;
        private String previousLabel;
        private float previousScrollExtentMax;
        private float previousScrollExtentMin;
        private float previousScrollPosition;
        /* access modifiers changed from: private */
        public int previousTextSelectionBase;
        /* access modifiers changed from: private */
        public int previousTextSelectionExtent;
        /* access modifiers changed from: private */
        public String previousValue;
        private float right;
        /* access modifiers changed from: private */
        public int scrollChildren;
        /* access modifiers changed from: private */
        public float scrollExtentMax;
        /* access modifiers changed from: private */
        public float scrollExtentMin;
        /* access modifiers changed from: private */
        public int scrollIndex;
        /* access modifiers changed from: private */
        public float scrollPosition;
        private TextDirection textDirection;
        /* access modifiers changed from: private */
        public int textSelectionBase;
        /* access modifiers changed from: private */
        public int textSelectionExtent;
        private float top;
        private float[] transform;
        /* access modifiers changed from: private */
        public String value;

        /* access modifiers changed from: private */
        public static boolean nullableHasAncestor(SemanticsNode target, Predicate<SemanticsNode> tester) {
            return (target == null || target.getAncestor(tester) == null) ? false : true;
        }

        SemanticsNode(AccessibilityBridge accessibilityBridge2) {
            this.accessibilityBridge = accessibilityBridge2;
        }

        private SemanticsNode getAncestor(Predicate<SemanticsNode> tester) {
            for (SemanticsNode nextAncestor = this.parent; nextAncestor != null; nextAncestor = nextAncestor.parent) {
                if (tester.test(nextAncestor)) {
                    return nextAncestor;
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        public boolean hasAction(Action action) {
            return (this.actions & action.value) != 0;
        }

        /* access modifiers changed from: private */
        public boolean hadAction(Action action) {
            return (this.previousActions & action.value) != 0;
        }

        /* access modifiers changed from: private */
        public boolean hasFlag(Flag flag) {
            return (this.flags & flag.value) != 0;
        }

        /* access modifiers changed from: private */
        public boolean hadFlag(Flag flag) {
            if (!this.hadPreviousConfig) {
                Log.e(AccessibilityBridge.TAG, "Attempted to check hadFlag but had no previous config.");
            }
            return (this.previousFlags & flag.value) != 0;
        }

        /* access modifiers changed from: private */
        public boolean didScroll() {
            return !Float.isNaN(this.scrollPosition) && !Float.isNaN(this.previousScrollPosition) && this.previousScrollPosition != this.scrollPosition;
        }

        /* access modifiers changed from: private */
        public boolean didChangeLabel() {
            String str;
            if (this.label == null && this.previousLabel == null) {
                return false;
            }
            String str2 = this.label;
            if (str2 == null || (str = this.previousLabel) == null || !str2.equals(str)) {
                return true;
            }
            return false;
        }

        private void log(String indent, boolean recursive) {
            Log.i(AccessibilityBridge.TAG, indent + "SemanticsNode id=" + this.id + " label=" + this.label + " actions=" + this.actions + " flags=" + this.flags + "\n" + indent + "  +-- textDirection=" + this.textDirection + "\n" + indent + "  +-- rect.ltrb=(" + this.left + ", " + this.top + ", " + this.right + ", " + this.bottom + ")\n" + indent + "  +-- transform=" + Arrays.toString(this.transform) + "\n");
            if (recursive) {
                String childIndent = indent + "  ";
                for (SemanticsNode child : this.childrenInTraversalOrder) {
                    child.log(childIndent, recursive);
                }
            }
        }

        /* access modifiers changed from: private */
        public void updateWith(ByteBuffer buffer, String[] strings) {
            this.hadPreviousConfig = true;
            this.previousValue = this.value;
            this.previousLabel = this.label;
            this.previousFlags = this.flags;
            this.previousActions = this.actions;
            this.previousTextSelectionBase = this.textSelectionBase;
            this.previousTextSelectionExtent = this.textSelectionExtent;
            this.previousScrollPosition = this.scrollPosition;
            this.previousScrollExtentMax = this.scrollExtentMax;
            this.previousScrollExtentMin = this.scrollExtentMin;
            this.flags = buffer.getInt();
            this.actions = buffer.getInt();
            this.maxValueLength = buffer.getInt();
            this.currentValueLength = buffer.getInt();
            this.textSelectionBase = buffer.getInt();
            this.textSelectionExtent = buffer.getInt();
            this.platformViewId = buffer.getInt();
            this.scrollChildren = buffer.getInt();
            this.scrollIndex = buffer.getInt();
            this.scrollPosition = buffer.getFloat();
            this.scrollExtentMax = buffer.getFloat();
            this.scrollExtentMin = buffer.getFloat();
            int stringIndex = buffer.getInt();
            this.label = stringIndex == -1 ? null : strings[stringIndex];
            int stringIndex2 = buffer.getInt();
            this.value = stringIndex2 == -1 ? null : strings[stringIndex2];
            int stringIndex3 = buffer.getInt();
            this.increasedValue = stringIndex3 == -1 ? null : strings[stringIndex3];
            int stringIndex4 = buffer.getInt();
            this.decreasedValue = stringIndex4 == -1 ? null : strings[stringIndex4];
            int stringIndex5 = buffer.getInt();
            this.hint = stringIndex5 == -1 ? null : strings[stringIndex5];
            this.textDirection = TextDirection.fromInt(buffer.getInt());
            this.left = buffer.getFloat();
            this.top = buffer.getFloat();
            this.right = buffer.getFloat();
            this.bottom = buffer.getFloat();
            if (this.transform == null) {
                this.transform = new float[16];
            }
            for (int i = 0; i < 16; i++) {
                this.transform[i] = buffer.getFloat();
            }
            this.inverseTransformDirty = true;
            this.globalGeometryDirty = true;
            int childCount = buffer.getInt();
            this.childrenInTraversalOrder.clear();
            this.childrenInHitTestOrder.clear();
            for (int i2 = 0; i2 < childCount; i2++) {
                SemanticsNode child = this.accessibilityBridge.getOrCreateSemanticsNode(buffer.getInt());
                child.parent = this;
                this.childrenInTraversalOrder.add(child);
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                SemanticsNode child2 = this.accessibilityBridge.getOrCreateSemanticsNode(buffer.getInt());
                child2.parent = this;
                this.childrenInHitTestOrder.add(child2);
            }
            int actionCount = buffer.getInt();
            if (actionCount == 0) {
                this.customAccessibilityActions = null;
                return;
            }
            List<CustomAccessibilityAction> list = this.customAccessibilityActions;
            if (list == null) {
                this.customAccessibilityActions = new ArrayList(actionCount);
            } else {
                list.clear();
            }
            for (int i4 = 0; i4 < actionCount; i4++) {
                CustomAccessibilityAction action = this.accessibilityBridge.getOrCreateAccessibilityAction(buffer.getInt());
                if (action.overrideId == Action.TAP.value) {
                    this.onTapOverride = action;
                } else if (action.overrideId == Action.LONG_PRESS.value) {
                    this.onLongPressOverride = action;
                } else {
                    if (action.overrideId != -1) {
                        Log.e(AccessibilityBridge.TAG, "Expected action.overrideId to be -1.");
                    }
                    this.customAccessibilityActions.add(action);
                }
                this.customAccessibilityActions.add(action);
            }
        }

        private void ensureInverseTransform() {
            if (this.inverseTransformDirty) {
                this.inverseTransformDirty = false;
                if (this.inverseTransform == null) {
                    this.inverseTransform = new float[16];
                }
                if (!Matrix.invertM(this.inverseTransform, 0, this.transform, 0)) {
                    Arrays.fill(this.inverseTransform, 0.0f);
                }
            }
        }

        /* access modifiers changed from: private */
        public Rect getGlobalRect() {
            if (this.globalGeometryDirty) {
                Log.e(AccessibilityBridge.TAG, "Attempted to getGlobalRect with a dirty geometry.");
            }
            return this.globalRect;
        }

        /* access modifiers changed from: private */
        public SemanticsNode hitTest(float[] point) {
            float w = point[3];
            float x = point[0] / w;
            float y = point[1] / w;
            if (x < this.left || x >= this.right || y < this.top || y >= this.bottom) {
                return null;
            }
            float[] transformedPoint = new float[4];
            for (SemanticsNode child : this.childrenInHitTestOrder) {
                if (!child.hasFlag(Flag.IS_HIDDEN)) {
                    child.ensureInverseTransform();
                    Matrix.multiplyMV(transformedPoint, 0, child.inverseTransform, 0, point, 0);
                    SemanticsNode result = child.hitTest(transformedPoint);
                    if (result != null) {
                        return result;
                    }
                }
            }
            return this;
        }

        /* access modifiers changed from: private */
        public boolean isFocusable() {
            String str;
            String str2;
            String str3;
            if (hasFlag(Flag.SCOPES_ROUTE)) {
                return false;
            }
            if (hasFlag(Flag.IS_FOCUSABLE)) {
                return true;
            }
            if ((this.actions & (~(Action.SCROLL_RIGHT.value | Action.SCROLL_LEFT.value | Action.SCROLL_UP.value | Action.SCROLL_DOWN.value))) == 0 && this.flags == 0 && (((str = this.label) == null || str.isEmpty()) && (((str2 = this.value) == null || str2.isEmpty()) && ((str3 = this.hint) == null || str3.isEmpty())))) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: private */
        public void collectRoutes(List<SemanticsNode> edges) {
            if (hasFlag(Flag.SCOPES_ROUTE)) {
                edges.add(this);
            }
            for (SemanticsNode child : this.childrenInTraversalOrder) {
                child.collectRoutes(edges);
            }
        }

        /* access modifiers changed from: private */
        public String getRouteName() {
            String str;
            if (hasFlag(Flag.NAMES_ROUTE) && (str = this.label) != null && !str.isEmpty()) {
                return this.label;
            }
            for (SemanticsNode child : this.childrenInTraversalOrder) {
                String newName = child.getRouteName();
                if (newName != null && !newName.isEmpty()) {
                    return newName;
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        public void updateRecursively(float[] ancestorTransform, Set<SemanticsNode> visitedObjects, boolean forceUpdate) {
            boolean forceUpdate2;
            Set<SemanticsNode> set = visitedObjects;
            set.add(this);
            if (this.globalGeometryDirty) {
                forceUpdate2 = true;
            } else {
                forceUpdate2 = forceUpdate;
            }
            if (forceUpdate2) {
                if (this.globalTransform == null) {
                    this.globalTransform = new float[16];
                }
                Matrix.multiplyMM(this.globalTransform, 0, ancestorTransform, 0, this.transform, 0);
                float[] sample = new float[4];
                sample[2] = 0.0f;
                sample[3] = 1.0f;
                float[] point1 = new float[4];
                float[] point2 = new float[4];
                float[] point3 = new float[4];
                float[] point4 = new float[4];
                sample[0] = this.left;
                sample[1] = this.top;
                transformPoint(point1, this.globalTransform, sample);
                sample[0] = this.right;
                sample[1] = this.top;
                transformPoint(point2, this.globalTransform, sample);
                sample[0] = this.right;
                sample[1] = this.bottom;
                transformPoint(point3, this.globalTransform, sample);
                sample[0] = this.left;
                sample[1] = this.bottom;
                transformPoint(point4, this.globalTransform, sample);
                if (this.globalRect == null) {
                    this.globalRect = new Rect();
                }
                this.globalRect.set(Math.round(min(point1[0], point2[0], point3[0], point4[0])), Math.round(min(point1[1], point2[1], point3[1], point4[1])), Math.round(max(point1[0], point2[0], point3[0], point4[0])), Math.round(max(point1[1], point2[1], point3[1], point4[1])));
                this.globalGeometryDirty = false;
            }
            if (this.globalTransform == null) {
                Log.e(AccessibilityBridge.TAG, "Expected globalTransform to not be null.");
            }
            if (this.globalRect == null) {
                Log.e(AccessibilityBridge.TAG, "Expected globalRect to not be null.");
            }
            for (SemanticsNode child : this.childrenInTraversalOrder) {
                child.updateRecursively(this.globalTransform, set, forceUpdate2);
            }
        }

        private void transformPoint(float[] result, float[] transform2, float[] point) {
            Matrix.multiplyMV(result, 0, transform2, 0, point, 0);
            float w = result[3];
            result[0] = result[0] / w;
            result[1] = result[1] / w;
            result[2] = result[2] / w;
            result[3] = 0.0f;
        }

        private float min(float a, float b, float c, float d) {
            return Math.min(a, Math.min(b, Math.min(c, d)));
        }

        private float max(float a, float b, float c, float d) {
            return Math.max(a, Math.max(b, Math.max(c, d)));
        }

        /* access modifiers changed from: private */
        public String getValueLabelHint() {
            StringBuilder sb = new StringBuilder();
            for (String word : new String[]{this.value, this.label, this.hint}) {
                if (word != null && word.length() > 0) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    sb.append(word);
                }
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
            return null;
        }
    }

    public boolean externalViewRequestSendAccessibilityEvent(View embeddedView, View eventOrigin, AccessibilityEvent event) {
        Integer virtualNodeId;
        if (!this.accessibilityViewEmbedder.requestSendAccessibilityEvent(embeddedView, eventOrigin, event) || (virtualNodeId = this.accessibilityViewEmbedder.getRecordFlutterId(embeddedView, event)) == null) {
            return false;
        }
        int eventType = event.getEventType();
        if (eventType == 8) {
            this.embeddedInputFocusedNodeId = virtualNodeId;
            this.inputFocusedSemanticsNode = null;
            return true;
        } else if (eventType == 128) {
            this.hoveredObject = null;
            return true;
        } else if (eventType == 32768) {
            this.embeddedAccessibilityFocusedNodeId = virtualNodeId;
            this.accessibilityFocusedSemanticsNode = null;
            return true;
        } else if (eventType != 65536) {
            return true;
        } else {
            this.embeddedInputFocusedNodeId = null;
            this.embeddedAccessibilityFocusedNodeId = null;
            return true;
        }
    }
}
