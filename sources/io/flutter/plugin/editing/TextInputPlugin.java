package io.flutter.plugin.editing;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.Selection;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.platform.PlatformViewsController;
import java.util.HashMap;

public class TextInputPlugin {
    /* access modifiers changed from: private */
    public final AutofillManager afm;
    private TextInputChannel.Configuration configuration;
    private ImeSyncDeferringInsetsCallback imeSyncCallback;
    private InputTarget inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, 0);
    private boolean isInputConnectionLocked;
    private Rect lastClientRect;
    private InputConnection lastInputConnection;
    private SparseArray<TextInputChannel.Configuration> mAutofillConfigurations;
    private Editable mEditable;
    private final InputMethodManager mImm;
    private boolean mRestartInputPending;
    /* access modifiers changed from: private */
    public final View mView;
    private PlatformViewsController platformViewsController;
    private final boolean restartAlwaysRequired;
    private final TextInputChannel textInputChannel;

    private interface MinMax {
        void inspect(double d, double d2);
    }

    public TextInputPlugin(View view, TextInputChannel textInputChannel2, PlatformViewsController platformViewsController2) {
        this.mView = view;
        this.mImm = (InputMethodManager) view.getContext().getSystemService("input_method");
        if (Build.VERSION.SDK_INT >= 26) {
            this.afm = (AutofillManager) view.getContext().getSystemService(AutofillManager.class);
        } else {
            this.afm = null;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            int mask = (this.mView.getWindowSystemUiVisibility() & 2) == 0 ? 0 | WindowInsets.Type.navigationBars() : 0;
            ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = new ImeSyncDeferringInsetsCallback(view, (this.mView.getWindowSystemUiVisibility() & 4) == 0 ? mask | WindowInsets.Type.statusBars() : mask, WindowInsets.Type.ime());
            this.imeSyncCallback = imeSyncDeferringInsetsCallback;
            imeSyncDeferringInsetsCallback.install();
        }
        this.textInputChannel = textInputChannel2;
        textInputChannel2.setTextInputMethodHandler(new TextInputChannel.TextInputMethodHandler() {
            public void show() {
                TextInputPlugin textInputPlugin = TextInputPlugin.this;
                textInputPlugin.showTextInput(textInputPlugin.mView);
            }

            public void hide() {
                TextInputPlugin textInputPlugin = TextInputPlugin.this;
                textInputPlugin.hideTextInput(textInputPlugin.mView);
            }

            public void requestAutofill() {
                TextInputPlugin.this.notifyViewEntered();
            }

            public void finishAutofillContext(boolean shouldSave) {
                if (Build.VERSION.SDK_INT >= 26 && TextInputPlugin.this.afm != null) {
                    if (shouldSave) {
                        TextInputPlugin.this.afm.commit();
                    } else {
                        TextInputPlugin.this.afm.cancel();
                    }
                }
            }

            public void setClient(int textInputClientId, TextInputChannel.Configuration configuration) {
                TextInputPlugin.this.setTextInputClient(textInputClientId, configuration);
            }

            public void setPlatformViewClient(int platformViewId) {
                TextInputPlugin.this.setPlatformViewTextInputClient(platformViewId);
            }

            public void setEditingState(TextInputChannel.TextEditState editingState) {
                TextInputPlugin textInputPlugin = TextInputPlugin.this;
                textInputPlugin.setTextInputEditingState(textInputPlugin.mView, editingState);
            }

            public void setEditableSizeAndTransform(double width, double height, double[] transform) {
                TextInputPlugin.this.saveEditableSizeAndTransform(width, height, transform);
            }

            public void clearClient() {
                TextInputPlugin.this.clearTextInputClient();
            }

            public void sendAppPrivateCommand(String action, Bundle data) {
                TextInputPlugin.this.sendTextInputAppPrivateCommand(action, data);
            }
        });
        textInputChannel2.requestExistingInputState();
        this.platformViewsController = platformViewsController2;
        platformViewsController2.attachTextInputPlugin(this);
        this.restartAlwaysRequired = isRestartAlwaysRequired();
    }

    public InputMethodManager getInputMethodManager() {
        return this.mImm;
    }

    /* access modifiers changed from: package-private */
    public Editable getEditable() {
        return this.mEditable;
    }

    /* access modifiers changed from: package-private */
    public ImeSyncDeferringInsetsCallback getImeSyncCallback() {
        return this.imeSyncCallback;
    }

    public void lockPlatformViewInputConnection() {
        if (this.inputTarget.type == InputTarget.Type.PLATFORM_VIEW) {
            this.isInputConnectionLocked = true;
        }
    }

    public void unlockPlatformViewInputConnection() {
        this.isInputConnectionLocked = false;
    }

    public void destroy() {
        this.platformViewsController.detachTextInputPlugin();
        this.textInputChannel.setTextInputMethodHandler((TextInputChannel.TextInputMethodHandler) null);
        ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = this.imeSyncCallback;
        if (imeSyncDeferringInsetsCallback != null) {
            imeSyncDeferringInsetsCallback.remove();
        }
    }

    private static int inputTypeFromTextInputType(TextInputChannel.InputType type, boolean obscureText, boolean autocorrect, boolean enableSuggestions, TextInputChannel.TextCapitalization textCapitalization) {
        if (type.type == TextInputChannel.TextInputType.DATETIME) {
            return 4;
        }
        if (type.type == TextInputChannel.TextInputType.NUMBER) {
            int textType = 2;
            if (type.isSigned) {
                textType = 2 | 4096;
            }
            if (type.isDecimal) {
                return textType | 8192;
            }
            return textType;
        } else if (type.type == TextInputChannel.TextInputType.PHONE) {
            return 3;
        } else {
            int textType2 = 1;
            if (type.type == TextInputChannel.TextInputType.MULTILINE) {
                textType2 = 1 | 131072;
            } else if (type.type == TextInputChannel.TextInputType.EMAIL_ADDRESS) {
                textType2 = 1 | 32;
            } else if (type.type == TextInputChannel.TextInputType.URL) {
                textType2 = 1 | 16;
            } else if (type.type == TextInputChannel.TextInputType.VISIBLE_PASSWORD) {
                textType2 = 1 | 144;
            } else if (type.type == TextInputChannel.TextInputType.NAME) {
                textType2 = 1 | 96;
            } else if (type.type == TextInputChannel.TextInputType.POSTAL_ADDRESS) {
                textType2 = 1 | 112;
            }
            if (obscureText) {
                textType2 = textType2 | 524288 | 128;
            } else {
                if (autocorrect) {
                    textType2 |= 32768;
                }
                if (!enableSuggestions) {
                    textType2 |= 524288;
                }
            }
            if (textCapitalization == TextInputChannel.TextCapitalization.CHARACTERS) {
                return textType2 | 4096;
            }
            if (textCapitalization == TextInputChannel.TextCapitalization.WORDS) {
                return textType2 | 8192;
            }
            if (textCapitalization == TextInputChannel.TextCapitalization.SENTENCES) {
                return textType2 | 16384;
            }
            return textType2;
        }
    }

    public InputConnection createInputConnection(View view, EditorInfo outAttrs) {
        int enterAction;
        if (this.inputTarget.type == InputTarget.Type.NO_TARGET) {
            this.lastInputConnection = null;
            return null;
        } else if (this.inputTarget.type != InputTarget.Type.PLATFORM_VIEW) {
            outAttrs.inputType = inputTypeFromTextInputType(this.configuration.inputType, this.configuration.obscureText, this.configuration.autocorrect, this.configuration.enableSuggestions, this.configuration.textCapitalization);
            outAttrs.imeOptions = 33554432;
            if (this.configuration.inputAction == null) {
                enterAction = (131072 & outAttrs.inputType) != 0 ? 1 : 6;
            } else {
                enterAction = this.configuration.inputAction.intValue();
            }
            if (this.configuration.actionLabel != null) {
                outAttrs.actionLabel = this.configuration.actionLabel;
                outAttrs.actionId = enterAction;
            }
            outAttrs.imeOptions |= enterAction;
            InputConnectionAdaptor inputConnectionAdaptor = new InputConnectionAdaptor(view, this.inputTarget.id, this.textInputChannel, this.mEditable, outAttrs);
            outAttrs.initialSelStart = Selection.getSelectionStart(this.mEditable);
            outAttrs.initialSelEnd = Selection.getSelectionEnd(this.mEditable);
            this.lastInputConnection = inputConnectionAdaptor;
            return inputConnectionAdaptor;
        } else if (this.isInputConnectionLocked) {
            return this.lastInputConnection;
        } else {
            InputConnection onCreateInputConnection = this.platformViewsController.getPlatformViewById(Integer.valueOf(this.inputTarget.id)).onCreateInputConnection(outAttrs);
            this.lastInputConnection = onCreateInputConnection;
            return onCreateInputConnection;
        }
    }

    public InputConnection getLastInputConnection() {
        return this.lastInputConnection;
    }

    public void clearPlatformViewClient(int platformViewId) {
        if (this.inputTarget.type == InputTarget.Type.PLATFORM_VIEW && this.inputTarget.id == platformViewId) {
            this.inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, 0);
            hideTextInput(this.mView);
            this.mImm.restartInput(this.mView);
            this.mRestartInputPending = false;
        }
    }

    public void sendTextInputAppPrivateCommand(String action, Bundle data) {
        this.mImm.sendAppPrivateCommand(this.mView, action, data);
    }

    /* access modifiers changed from: private */
    public void showTextInput(View view) {
        view.requestFocus();
        this.mImm.showSoftInput(view, 0);
    }

    /* access modifiers changed from: private */
    public void hideTextInput(View view) {
        notifyViewExited();
        this.mImm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }

    /* access modifiers changed from: private */
    public void notifyViewEntered() {
        if (Build.VERSION.SDK_INT >= 26 && this.afm != null && needsAutofill()) {
            String triggerIdentifier = this.configuration.autofill.uniqueIdentifier;
            int[] offset = new int[2];
            this.mView.getLocationOnScreen(offset);
            Rect rect = new Rect(this.lastClientRect);
            rect.offset(offset[0], offset[1]);
            this.afm.notifyViewEntered(this.mView, triggerIdentifier.hashCode(), rect);
        }
    }

    private void notifyViewExited() {
        TextInputChannel.Configuration configuration2;
        if (Build.VERSION.SDK_INT >= 26 && this.afm != null && (configuration2 = this.configuration) != null && configuration2.autofill != null) {
            this.afm.notifyViewExited(this.mView, this.configuration.autofill.uniqueIdentifier.hashCode());
        }
    }

    private void notifyValueChanged(String newValue) {
        if (Build.VERSION.SDK_INT >= 26 && this.afm != null && needsAutofill()) {
            this.afm.notifyValueChanged(this.mView, this.configuration.autofill.uniqueIdentifier.hashCode(), AutofillValue.forText(newValue));
        }
    }

    /* access modifiers changed from: package-private */
    public void setTextInputClient(int client, TextInputChannel.Configuration configuration2) {
        this.inputTarget = new InputTarget(InputTarget.Type.FRAMEWORK_CLIENT, client);
        updateAutofillConfigurationIfNeeded(configuration2);
        this.mEditable = Editable.Factory.getInstance().newEditable("");
        this.mRestartInputPending = true;
        unlockPlatformViewInputConnection();
        this.lastClientRect = null;
    }

    /* access modifiers changed from: private */
    public void setPlatformViewTextInputClient(int platformViewId) {
        this.mView.requestFocus();
        this.inputTarget = new InputTarget(InputTarget.Type.PLATFORM_VIEW, platformViewId);
        this.mImm.restartInput(this.mView);
        this.mRestartInputPending = false;
    }

    private void applyStateToSelection(TextInputChannel.TextEditState state) {
        int selStart = state.selectionStart;
        int selEnd = state.selectionEnd;
        if (selStart < 0 || selStart > this.mEditable.length() || selEnd < 0 || selEnd > this.mEditable.length()) {
            Selection.removeSelection(this.mEditable);
        } else {
            Selection.setSelection(this.mEditable, selStart, selEnd);
        }
    }

    /* access modifiers changed from: package-private */
    public void setTextInputEditingState(View view, TextInputChannel.TextEditState state) {
        if (!state.text.equals(this.mEditable.toString())) {
            Editable editable = this.mEditable;
            editable.replace(0, editable.length(), state.text);
        }
        notifyValueChanged(this.mEditable.toString());
        applyStateToSelection(state);
        InputConnection connection = getLastInputConnection();
        if (connection != null && (connection instanceof InputConnectionAdaptor)) {
            ((InputConnectionAdaptor) connection).markDirty();
        }
        if (this.restartAlwaysRequired || this.mRestartInputPending) {
            this.mImm.restartInput(view);
            this.mRestartInputPending = false;
            return;
        }
        this.mImm.updateSelection(this.mView, Math.max(Selection.getSelectionStart(this.mEditable), 0), Math.max(Selection.getSelectionEnd(this.mEditable), 0), BaseInputConnection.getComposingSpanStart(this.mEditable), BaseInputConnection.getComposingSpanEnd(this.mEditable));
    }

    /* access modifiers changed from: private */
    public void saveEditableSizeAndTransform(double width, double height, double[] matrix) {
        double d = width;
        double d2 = height;
        final double[] dArr = matrix;
        final double[] minMax = new double[4];
        final boolean isAffine = dArr[3] == 0.0d && dArr[7] == 0.0d && dArr[15] == 1.0d;
        double d3 = dArr[12] / dArr[15];
        minMax[1] = d3;
        minMax[0] = d3;
        double d4 = dArr[13] / dArr[15];
        minMax[3] = d4;
        minMax[2] = d4;
        MinMax finder = new MinMax() {
            public void inspect(double x, double y) {
                double d = 1.0d;
                if (!isAffine) {
                    double[] dArr = dArr;
                    d = 1.0d / (((dArr[3] * x) + (dArr[7] * y)) + dArr[15]);
                }
                double w = d;
                double[] dArr2 = dArr;
                double tx = ((dArr2[0] * x) + (dArr2[4] * y) + dArr2[12]) * w;
                double ty = ((dArr2[1] * x) + (dArr2[5] * y) + dArr2[13]) * w;
                double[] dArr3 = minMax;
                if (tx < dArr3[0]) {
                    dArr3[0] = tx;
                } else if (tx > dArr3[1]) {
                    dArr3[1] = tx;
                }
                double[] dArr4 = minMax;
                if (ty < dArr4[2]) {
                    dArr4[2] = ty;
                } else if (ty > dArr4[3]) {
                    dArr4[3] = ty;
                }
            }
        };
        finder.inspect(d, 0.0d);
        finder.inspect(d, d2);
        finder.inspect(0.0d, d2);
        Float density = Float.valueOf(this.mView.getContext().getResources().getDisplayMetrics().density);
        boolean z = isAffine;
        this.lastClientRect = new Rect((int) (((double) density.floatValue()) * minMax[0]), (int) (minMax[2] * ((double) density.floatValue())), (int) Math.ceil(minMax[1] * ((double) density.floatValue())), (int) Math.ceil(minMax[3] * ((double) density.floatValue())));
    }

    private void updateAutofillConfigurationIfNeeded(TextInputChannel.Configuration configuration2) {
        notifyViewExited();
        this.configuration = configuration2;
        TextInputChannel.Configuration[] configurations = configuration2.fields;
        if (configuration2.autofill == null) {
            this.mAutofillConfigurations = null;
            return;
        }
        SparseArray<TextInputChannel.Configuration> sparseArray = new SparseArray<>();
        this.mAutofillConfigurations = sparseArray;
        if (configurations == null) {
            sparseArray.put(configuration2.autofill.uniqueIdentifier.hashCode(), configuration2);
            return;
        }
        for (TextInputChannel.Configuration config : configurations) {
            TextInputChannel.Configuration.Autofill autofill = config.autofill;
            if (autofill != null) {
                this.mAutofillConfigurations.put(autofill.uniqueIdentifier.hashCode(), config);
            }
        }
    }

    private boolean needsAutofill() {
        return this.mAutofillConfigurations != null;
    }

    public void onProvideAutofillVirtualStructure(ViewStructure structure, int flags) {
        Rect rect;
        ViewStructure viewStructure = structure;
        if (Build.VERSION.SDK_INT >= 26 && needsAutofill()) {
            String triggerIdentifier = this.configuration.autofill.uniqueIdentifier;
            AutofillId parentId = structure.getAutofillId();
            for (int i = 0; i < this.mAutofillConfigurations.size(); i++) {
                int autofillId = this.mAutofillConfigurations.keyAt(i);
                TextInputChannel.Configuration.Autofill autofill = this.mAutofillConfigurations.valueAt(i).autofill;
                if (autofill != null) {
                    viewStructure.addChildCount(1);
                    ViewStructure child = viewStructure.newChild(i);
                    child.setAutofillId(parentId, autofillId);
                    child.setAutofillValue(AutofillValue.forText(autofill.editState.text));
                    child.setAutofillHints(autofill.hints);
                    child.setAutofillType(1);
                    child.setVisibility(0);
                    if (triggerIdentifier.hashCode() != autofillId || (rect = this.lastClientRect) == null) {
                        child.setDimens(0, 0, 0, 0, 1, 1);
                    } else {
                        ViewStructure viewStructure2 = child;
                        child.setDimens(rect.left, this.lastClientRect.top, 0, 0, this.lastClientRect.width(), this.lastClientRect.height());
                    }
                }
            }
        }
    }

    public void autofill(SparseArray<AutofillValue> values) {
        TextInputChannel.Configuration.Autofill currentAutofill;
        if (Build.VERSION.SDK_INT >= 26 && (currentAutofill = this.configuration.autofill) != null) {
            HashMap<String, TextInputChannel.TextEditState> editingValues = new HashMap<>();
            for (int i = 0; i < values.size(); i++) {
                TextInputChannel.Configuration config = this.mAutofillConfigurations.get(values.keyAt(i));
                if (!(config == null || config.autofill == null)) {
                    TextInputChannel.Configuration.Autofill autofill = config.autofill;
                    String value = values.valueAt(i).getTextValue().toString();
                    TextInputChannel.TextEditState newState = new TextInputChannel.TextEditState(value, value.length(), value.length());
                    if (autofill.uniqueIdentifier.equals(currentAutofill.uniqueIdentifier)) {
                        setTextInputEditingState(this.mView, newState);
                    }
                    editingValues.put(autofill.uniqueIdentifier, newState);
                }
            }
            this.textInputChannel.updateEditingStateWithTag(this.inputTarget.id, editingValues);
        }
    }

    private boolean isRestartAlwaysRequired() {
        if (this.mImm.getCurrentInputMethodSubtype() == null || Build.VERSION.SDK_INT < 21 || !Build.MANUFACTURER.equals("samsung")) {
            return false;
        }
        return Settings.Secure.getString(this.mView.getContext().getContentResolver(), "default_input_method").contains("Samsung");
    }

    /* access modifiers changed from: private */
    public void clearTextInputClient() {
        if (this.inputTarget.type != InputTarget.Type.PLATFORM_VIEW) {
            this.inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, 0);
            unlockPlatformViewInputConnection();
            notifyViewExited();
            this.lastClientRect = null;
        }
    }

    private static class InputTarget {
        int id;
        Type type;

        enum Type {
            NO_TARGET,
            FRAMEWORK_CLIENT,
            PLATFORM_VIEW
        }

        public InputTarget(Type type2, int id2) {
            this.type = type2;
            this.id = id2;
        }
    }
}
