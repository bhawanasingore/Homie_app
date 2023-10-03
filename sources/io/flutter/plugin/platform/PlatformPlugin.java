package io.flutter.plugin.platform;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.view.Window;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import java.util.List;

public class PlatformPlugin {
    public static final int DEFAULT_SYSTEM_UI = 1280;
    private final Activity activity;
    private PlatformChannel.SystemChromeStyle currentTheme;
    private int mEnabledOverlays = DEFAULT_SYSTEM_UI;
    final PlatformChannel.PlatformMessageHandler mPlatformMessageHandler;
    private final PlatformChannel platformChannel;

    public PlatformPlugin(Activity activity2, PlatformChannel platformChannel2) {
        AnonymousClass1 r0 = new PlatformChannel.PlatformMessageHandler() {
            public void playSystemSound(PlatformChannel.SoundType soundType) {
                PlatformPlugin.this.playSystemSound(soundType);
            }

            public void vibrateHapticFeedback(PlatformChannel.HapticFeedbackType feedbackType) {
                PlatformPlugin.this.vibrateHapticFeedback(feedbackType);
            }

            public void setPreferredOrientations(int androidOrientation) {
                PlatformPlugin.this.setSystemChromePreferredOrientations(androidOrientation);
            }

            public void setApplicationSwitcherDescription(PlatformChannel.AppSwitcherDescription description) {
                PlatformPlugin.this.setSystemChromeApplicationSwitcherDescription(description);
            }

            public void showSystemOverlays(List<PlatformChannel.SystemUiOverlay> overlays) {
                PlatformPlugin.this.setSystemChromeEnabledSystemUIOverlays(overlays);
            }

            public void restoreSystemUiOverlays() {
                PlatformPlugin.this.restoreSystemChromeSystemUIOverlays();
            }

            public void setSystemUiOverlayStyle(PlatformChannel.SystemChromeStyle systemUiOverlayStyle) {
                PlatformPlugin.this.setSystemChromeSystemUIOverlayStyle(systemUiOverlayStyle);
            }

            public void popSystemNavigator() {
                PlatformPlugin.this.popSystemNavigator();
            }

            public CharSequence getClipboardData(PlatformChannel.ClipboardContentFormat format) {
                return PlatformPlugin.this.getClipboardData(format);
            }

            public void setClipboardData(String text) {
                PlatformPlugin.this.setClipboardData(text);
            }

            public boolean clipboardHasStrings() {
                CharSequence data = PlatformPlugin.this.getClipboardData(PlatformChannel.ClipboardContentFormat.PLAIN_TEXT);
                return data != null && data.length() > 0;
            }
        };
        this.mPlatformMessageHandler = r0;
        this.activity = activity2;
        this.platformChannel = platformChannel2;
        platformChannel2.setPlatformMessageHandler(r0);
    }

    public void destroy() {
        this.platformChannel.setPlatformMessageHandler((PlatformChannel.PlatformMessageHandler) null);
    }

    /* access modifiers changed from: private */
    public void playSystemSound(PlatformChannel.SoundType soundType) {
        if (soundType == PlatformChannel.SoundType.CLICK) {
            this.activity.getWindow().getDecorView().playSoundEffect(0);
        }
    }

    /* access modifiers changed from: package-private */
    public void vibrateHapticFeedback(PlatformChannel.HapticFeedbackType feedbackType) {
        View view = this.activity.getWindow().getDecorView();
        int i = AnonymousClass2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType[feedbackType.ordinal()];
        if (i == 1) {
            view.performHapticFeedback(0);
        } else if (i == 2) {
            view.performHapticFeedback(1);
        } else if (i == 3) {
            view.performHapticFeedback(3);
        } else if (i != 4) {
            if (i == 5 && Build.VERSION.SDK_INT >= 21) {
                view.performHapticFeedback(4);
            }
        } else if (Build.VERSION.SDK_INT >= 23) {
            view.performHapticFeedback(6);
        }
    }

    /* access modifiers changed from: private */
    public void setSystemChromePreferredOrientations(int androidOrientation) {
        this.activity.setRequestedOrientation(androidOrientation);
    }

    /* access modifiers changed from: private */
    public void setSystemChromeApplicationSwitcherDescription(PlatformChannel.AppSwitcherDescription description) {
        if (Build.VERSION.SDK_INT >= 21) {
            if (Build.VERSION.SDK_INT < 28 && Build.VERSION.SDK_INT > 21) {
                this.activity.setTaskDescription(new ActivityManager.TaskDescription(description.label, (Bitmap) null, description.color));
            }
            if (Build.VERSION.SDK_INT >= 28) {
                this.activity.setTaskDescription(new ActivityManager.TaskDescription(description.label, 0, description.color));
            }
        }
    }

    /* access modifiers changed from: private */
    public void setSystemChromeEnabledSystemUIOverlays(List<PlatformChannel.SystemUiOverlay> overlaysToShow) {
        int enabledOverlays = 1798;
        if (overlaysToShow.size() == 0 && Build.VERSION.SDK_INT >= 19) {
            enabledOverlays = 1798 | 4096;
        }
        for (int i = 0; i < overlaysToShow.size(); i++) {
            int i2 = AnonymousClass2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay[overlaysToShow.get(i).ordinal()];
            if (i2 == 1) {
                enabledOverlays &= -5;
            } else if (i2 == 2) {
                enabledOverlays = enabledOverlays & -513 & -3;
            }
        }
        this.mEnabledOverlays = enabledOverlays;
        updateSystemUiOverlays();
    }

    public void updateSystemUiOverlays() {
        this.activity.getWindow().getDecorView().setSystemUiVisibility(this.mEnabledOverlays);
        PlatformChannel.SystemChromeStyle systemChromeStyle = this.currentTheme;
        if (systemChromeStyle != null) {
            setSystemChromeSystemUIOverlayStyle(systemChromeStyle);
        }
    }

    /* access modifiers changed from: private */
    public void restoreSystemChromeSystemUIOverlays() {
        updateSystemUiOverlays();
    }

    /* access modifiers changed from: private */
    public void setSystemChromeSystemUIOverlayStyle(PlatformChannel.SystemChromeStyle systemChromeStyle) {
        Window window = this.activity.getWindow();
        View view = window.getDecorView();
        int flags = view.getSystemUiVisibility();
        if (Build.VERSION.SDK_INT >= 26) {
            if (systemChromeStyle.systemNavigationBarIconBrightness != null) {
                int i = AnonymousClass2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness[systemChromeStyle.systemNavigationBarIconBrightness.ordinal()];
                if (i == 1) {
                    flags |= 16;
                } else if (i == 2) {
                    flags &= -17;
                }
            }
            if (systemChromeStyle.systemNavigationBarColor != null) {
                window.setNavigationBarColor(systemChromeStyle.systemNavigationBarColor.intValue());
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (systemChromeStyle.statusBarIconBrightness != null) {
                int i2 = AnonymousClass2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness[systemChromeStyle.statusBarIconBrightness.ordinal()];
                if (i2 == 1) {
                    flags |= 8192;
                } else if (i2 == 2) {
                    flags &= -8193;
                }
            }
            if (systemChromeStyle.statusBarColor != null) {
                window.setStatusBarColor(systemChromeStyle.statusBarColor.intValue());
            }
        }
        Integer num = systemChromeStyle.systemNavigationBarDividerColor;
        view.setSystemUiVisibility(flags);
        this.currentTheme = systemChromeStyle;
    }

    /* renamed from: io.flutter.plugin.platform.PlatformPlugin$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay;

        static {
            int[] iArr = new int[PlatformChannel.Brightness.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness = iArr;
            try {
                iArr[PlatformChannel.Brightness.DARK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness[PlatformChannel.Brightness.LIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            int[] iArr2 = new int[PlatformChannel.SystemUiOverlay.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay = iArr2;
            try {
                iArr2[PlatformChannel.SystemUiOverlay.TOP_OVERLAYS.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay[PlatformChannel.SystemUiOverlay.BOTTOM_OVERLAYS.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            int[] iArr3 = new int[PlatformChannel.HapticFeedbackType.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType = iArr3;
            try {
                iArr3[PlatformChannel.HapticFeedbackType.STANDARD.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType[PlatformChannel.HapticFeedbackType.LIGHT_IMPACT.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType[PlatformChannel.HapticFeedbackType.MEDIUM_IMPACT.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType[PlatformChannel.HapticFeedbackType.HEAVY_IMPACT.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType[PlatformChannel.HapticFeedbackType.SELECTION_CLICK.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void popSystemNavigator() {
        this.activity.finish();
    }

    /* access modifiers changed from: private */
    public CharSequence getClipboardData(PlatformChannel.ClipboardContentFormat format) {
        ClipData clip = ((ClipboardManager) this.activity.getSystemService("clipboard")).getPrimaryClip();
        if (clip == null) {
            return null;
        }
        if (format == null || format == PlatformChannel.ClipboardContentFormat.PLAIN_TEXT) {
            return clip.getItemAt(0).coerceToText(this.activity);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void setClipboardData(String text) {
        ((ClipboardManager) this.activity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", text));
    }
}
