package io.flutter.plugin.platform;

import android.app.AlertDialog;
import android.app.Presentation;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

class SingleViewPresentation extends Presentation {
    private final AccessibilityEventsDelegate accessibilityEventsDelegate;
    private FrameLayout container;
    private Object createParams;
    private final View.OnFocusChangeListener focusChangeListener;
    private final Context outerContext;
    private AccessibilityDelegatingFrameLayout rootView;
    private boolean startFocused = false;
    private PresentationState state;
    private final PlatformViewFactory viewFactory;
    private int viewId;

    static class PresentationState {
        /* access modifiers changed from: private */
        public FakeWindowViewGroup fakeWindowViewGroup;
        /* access modifiers changed from: private */
        public PlatformView platformView;
        /* access modifiers changed from: private */
        public WindowManagerHandler windowManagerHandler;

        PresentationState() {
        }
    }

    public SingleViewPresentation(Context outerContext2, Display display, PlatformViewFactory viewFactory2, AccessibilityEventsDelegate accessibilityEventsDelegate2, int viewId2, Object createParams2, View.OnFocusChangeListener focusChangeListener2) {
        super(new ImmContext(outerContext2), display);
        this.viewFactory = viewFactory2;
        this.accessibilityEventsDelegate = accessibilityEventsDelegate2;
        this.viewId = viewId2;
        this.createParams = createParams2;
        this.focusChangeListener = focusChangeListener2;
        this.outerContext = outerContext2;
        this.state = new PresentationState();
        getWindow().setFlags(8, 8);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().setType(2030);
        }
    }

    public SingleViewPresentation(Context outerContext2, Display display, AccessibilityEventsDelegate accessibilityEventsDelegate2, PresentationState state2, View.OnFocusChangeListener focusChangeListener2, boolean startFocused2) {
        super(new ImmContext(outerContext2), display);
        this.accessibilityEventsDelegate = accessibilityEventsDelegate2;
        this.viewFactory = null;
        this.state = state2;
        this.focusChangeListener = focusChangeListener2;
        this.outerContext = outerContext2;
        getWindow().setFlags(8, 8);
        this.startFocused = startFocused2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (this.state.fakeWindowViewGroup == null) {
            FakeWindowViewGroup unused = this.state.fakeWindowViewGroup = new FakeWindowViewGroup(getContext());
        }
        if (this.state.windowManagerHandler == null) {
            PresentationState presentationState = this.state;
            WindowManagerHandler unused2 = presentationState.windowManagerHandler = new WindowManagerHandler((WindowManager) getContext().getSystemService("window"), presentationState.fakeWindowViewGroup);
        }
        this.container = new FrameLayout(getContext());
        Context context = new PresentationContext(getContext(), this.state.windowManagerHandler, this.outerContext);
        if (this.state.platformView == null) {
            PlatformView unused3 = this.state.platformView = this.viewFactory.create(context, this.viewId, this.createParams);
        }
        View embeddedView = this.state.platformView.getView();
        this.container.addView(embeddedView);
        AccessibilityDelegatingFrameLayout accessibilityDelegatingFrameLayout = new AccessibilityDelegatingFrameLayout(getContext(), this.accessibilityEventsDelegate, embeddedView);
        this.rootView = accessibilityDelegatingFrameLayout;
        accessibilityDelegatingFrameLayout.addView(this.container);
        this.rootView.addView(this.state.fakeWindowViewGroup);
        embeddedView.setOnFocusChangeListener(this.focusChangeListener);
        this.rootView.setFocusableInTouchMode(true);
        if (this.startFocused) {
            embeddedView.requestFocus();
        } else {
            this.rootView.requestFocus();
        }
        setContentView(this.rootView);
    }

    public PresentationState detachState() {
        this.container.removeAllViews();
        this.rootView.removeAllViews();
        return this.state;
    }

    public PlatformView getView() {
        if (this.state.platformView == null) {
            return null;
        }
        return this.state.platformView;
    }

    static class FakeWindowViewGroup extends ViewGroup {
        private final Rect childRect = new Rect();
        private final Rect viewBounds = new Rect();

        public FakeWindowViewGroup(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean changed, int l, int t, int r, int b) {
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                WindowManager.LayoutParams params = (WindowManager.LayoutParams) child.getLayoutParams();
                this.viewBounds.set(l, t, r, b);
                Gravity.apply(params.gravity, child.getMeasuredWidth(), child.getMeasuredHeight(), this.viewBounds, params.x, params.y, this.childRect);
                child.layout(this.childRect.left, this.childRect.top, this.childRect.right, this.childRect.bottom);
            }
            int i2 = l;
            int i3 = t;
            int i4 = r;
            int i5 = b;
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).measure(atMost(widthMeasureSpec), atMost(heightMeasureSpec));
            }
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }

        private static int atMost(int measureSpec) {
            return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(measureSpec), Integer.MIN_VALUE);
        }
    }

    private static class ImmContext extends ContextWrapper {
        private final InputMethodManager inputMethodManager;

        ImmContext(Context base) {
            this(base, (InputMethodManager) null);
        }

        private ImmContext(Context base, InputMethodManager inputMethodManager2) {
            super(base);
            InputMethodManager inputMethodManager3;
            if (inputMethodManager2 != null) {
                inputMethodManager3 = inputMethodManager2;
            } else {
                inputMethodManager3 = (InputMethodManager) base.getSystemService("input_method");
            }
            this.inputMethodManager = inputMethodManager3;
        }

        public Object getSystemService(String name) {
            if ("input_method".equals(name)) {
                return this.inputMethodManager;
            }
            return super.getSystemService(name);
        }

        public Context createDisplayContext(Display display) {
            return new ImmContext(super.createDisplayContext(display), this.inputMethodManager);
        }
    }

    private static class PresentationContext extends ContextWrapper {
        private final Context flutterAppWindowContext;
        private WindowManager windowManager;
        private final WindowManagerHandler windowManagerHandler;

        PresentationContext(Context base, WindowManagerHandler windowManagerHandler2, Context flutterAppWindowContext2) {
            super(base);
            this.windowManagerHandler = windowManagerHandler2;
            this.flutterAppWindowContext = flutterAppWindowContext2;
        }

        public Object getSystemService(String name) {
            if (!"window".equals(name)) {
                return super.getSystemService(name);
            }
            if (isCalledFromAlertDialog()) {
                return this.flutterAppWindowContext.getSystemService(name);
            }
            return getWindowManager();
        }

        private WindowManager getWindowManager() {
            if (this.windowManager == null) {
                this.windowManager = this.windowManagerHandler.getWindowManager();
            }
            return this.windowManager;
        }

        private boolean isCalledFromAlertDialog() {
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            int i = 0;
            while (i < stackTraceElements.length && i < 11) {
                if (stackTraceElements[i].getClassName().equals(AlertDialog.class.getCanonicalName()) && stackTraceElements[i].getMethodName().equals("<init>")) {
                    return true;
                }
                i++;
            }
            return false;
        }
    }

    static class WindowManagerHandler implements InvocationHandler {
        private static final String TAG = "PlatformViewsController";
        private final WindowManager delegate;
        FakeWindowViewGroup fakeWindowRootView;

        WindowManagerHandler(WindowManager delegate2, FakeWindowViewGroup fakeWindowViewGroup) {
            this.delegate = delegate2;
            this.fakeWindowRootView = fakeWindowViewGroup;
        }

        public WindowManager getWindowManager() {
            return (WindowManager) Proxy.newProxyInstance(WindowManager.class.getClassLoader(), new Class[]{WindowManager.class}, this);
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object invoke(java.lang.Object r6, java.lang.reflect.Method r7, java.lang.Object[] r8) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.String r0 = r7.getName()
                int r1 = r0.hashCode()
                r2 = 3
                r3 = 2
                r4 = 1
                switch(r1) {
                    case -1148522778: goto L_0x002d;
                    case 542766184: goto L_0x0023;
                    case 931413976: goto L_0x0019;
                    case 1098630473: goto L_0x000f;
                    default: goto L_0x000e;
                }
            L_0x000e:
                goto L_0x0037
            L_0x000f:
                java.lang.String r1 = "removeView"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x000e
                r0 = r4
                goto L_0x0038
            L_0x0019:
                java.lang.String r1 = "updateViewLayout"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x000e
                r0 = r2
                goto L_0x0038
            L_0x0023:
                java.lang.String r1 = "removeViewImmediate"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x000e
                r0 = r3
                goto L_0x0038
            L_0x002d:
                java.lang.String r1 = "addView"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x000e
                r0 = 0
                goto L_0x0038
            L_0x0037:
                r0 = -1
            L_0x0038:
                r1 = 0
                if (r0 == 0) goto L_0x005a
                if (r0 == r4) goto L_0x0056
                if (r0 == r3) goto L_0x0052
                if (r0 == r2) goto L_0x004e
                android.view.WindowManager r0 = r5.delegate     // Catch:{ InvocationTargetException -> 0x0048 }
                java.lang.Object r0 = r7.invoke(r0, r8)     // Catch:{ InvocationTargetException -> 0x0048 }
                return r0
            L_0x0048:
                r0 = move-exception
                java.lang.Throwable r1 = r0.getCause()
                throw r1
            L_0x004e:
                r5.updateViewLayout(r8)
                return r1
            L_0x0052:
                r5.removeViewImmediate(r8)
                return r1
            L_0x0056:
                r5.removeView(r8)
                return r1
            L_0x005a:
                r5.addView(r8)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.platform.SingleViewPresentation.WindowManagerHandler.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
        }

        private void addView(Object[] args) {
            FakeWindowViewGroup fakeWindowViewGroup = this.fakeWindowRootView;
            if (fakeWindowViewGroup == null) {
                Log.w(TAG, "Embedded view called addView while detached from presentation");
            } else {
                fakeWindowViewGroup.addView(args[0], args[1]);
            }
        }

        private void removeView(Object[] args) {
            FakeWindowViewGroup fakeWindowViewGroup = this.fakeWindowRootView;
            if (fakeWindowViewGroup == null) {
                Log.w(TAG, "Embedded view called removeView while detached from presentation");
            } else {
                fakeWindowViewGroup.removeView(args[0]);
            }
        }

        private void removeViewImmediate(Object[] args) {
            if (this.fakeWindowRootView == null) {
                Log.w(TAG, "Embedded view called removeViewImmediate while detached from presentation");
                return;
            }
            View view = args[0];
            view.clearAnimation();
            this.fakeWindowRootView.removeView(view);
        }

        private void updateViewLayout(Object[] args) {
            FakeWindowViewGroup fakeWindowViewGroup = this.fakeWindowRootView;
            if (fakeWindowViewGroup == null) {
                Log.w(TAG, "Embedded view called updateViewLayout while detached from presentation");
            } else {
                fakeWindowViewGroup.updateViewLayout(args[0], args[1]);
            }
        }
    }

    private static class AccessibilityDelegatingFrameLayout extends FrameLayout {
        private final AccessibilityEventsDelegate accessibilityEventsDelegate;
        private final View embeddedView;

        public AccessibilityDelegatingFrameLayout(Context context, AccessibilityEventsDelegate accessibilityEventsDelegate2, View embeddedView2) {
            super(context);
            this.accessibilityEventsDelegate = accessibilityEventsDelegate2;
            this.embeddedView = embeddedView2;
        }

        public boolean requestSendAccessibilityEvent(View child, AccessibilityEvent event) {
            return this.accessibilityEventsDelegate.requestSendAccessibilityEvent(this.embeddedView, child, event);
        }
    }
}
