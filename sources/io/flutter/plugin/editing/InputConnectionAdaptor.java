package io.flutter.plugin.editing;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputMethodManager;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;

class InputConnectionAdaptor extends BaseInputConnection {
    private FlutterTextUtils flutterTextUtils;
    private final boolean isSamsung;
    private int mBatchCount;
    private final int mClient;
    private final Editable mEditable;
    private final EditorInfo mEditorInfo;
    private final View mFlutterView;
    private InputMethodManager mImm;
    private TextEditingValue mLastSentTextEditngValue;
    private final Layout mLayout;
    private boolean mRepeatCheckNeeded;
    private final TextInputChannel textInputChannel;

    private class TextEditingValue {
        public int composingEnd;
        public int composingStart;
        public int selectionEnd;
        public int selectionStart;
        public String text;

        public TextEditingValue(Editable editable) {
            this.selectionStart = Selection.getSelectionStart(editable);
            this.selectionEnd = Selection.getSelectionEnd(editable);
            this.composingStart = BaseInputConnection.getComposingSpanStart(editable);
            this.composingEnd = BaseInputConnection.getComposingSpanEnd(editable);
            this.text = editable.toString();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof TextEditingValue)) {
                return false;
            }
            TextEditingValue value = (TextEditingValue) o;
            if (this.selectionStart == value.selectionStart && this.selectionEnd == value.selectionEnd && this.composingStart == value.composingStart && this.composingEnd == value.composingEnd && this.text.equals(value.text)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((((((1 * 31) + this.selectionStart) * 31) + this.selectionEnd) * 31) + this.composingStart) * 31) + this.composingEnd) * 31) + this.text.hashCode();
        }
    }

    public InputConnectionAdaptor(View view, int client, TextInputChannel textInputChannel2, Editable editable, EditorInfo editorInfo, FlutterJNI flutterJNI) {
        super(view, true);
        this.mRepeatCheckNeeded = false;
        this.mFlutterView = view;
        this.mClient = client;
        this.textInputChannel = textInputChannel2;
        this.mEditable = editable;
        this.mEditorInfo = editorInfo;
        this.mBatchCount = 0;
        this.flutterTextUtils = new FlutterTextUtils(flutterJNI);
        this.mLayout = new DynamicLayout(this.mEditable, new TextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.mImm = (InputMethodManager) view.getContext().getSystemService("input_method");
        this.isSamsung = isSamsung();
    }

    public InputConnectionAdaptor(View view, int client, TextInputChannel textInputChannel2, Editable editable, EditorInfo editorInfo) {
        this(view, client, textInputChannel2, editable, editorInfo, new FlutterJNI());
    }

    private void updateEditingState() {
        if (this.mBatchCount <= 0) {
            TextEditingValue currentValue = new TextEditingValue(this.mEditable);
            if (!this.mRepeatCheckNeeded || !currentValue.equals(this.mLastSentTextEditngValue)) {
                this.mImm.updateSelection(this.mFlutterView, currentValue.selectionStart, currentValue.selectionEnd, currentValue.composingStart, currentValue.composingEnd);
                this.textInputChannel.updateEditingState(this.mClient, currentValue.text, currentValue.selectionStart, currentValue.selectionEnd, currentValue.composingStart, currentValue.composingEnd);
                this.mRepeatCheckNeeded = true;
                this.mLastSentTextEditngValue = currentValue;
            }
        }
    }

    public void markDirty() {
        this.mRepeatCheckNeeded = false;
    }

    public Editable getEditable() {
        return this.mEditable;
    }

    public boolean beginBatchEdit() {
        this.mBatchCount++;
        return super.beginBatchEdit();
    }

    public boolean endBatchEdit() {
        boolean result = super.endBatchEdit();
        this.mBatchCount--;
        updateEditingState();
        return result;
    }

    public boolean commitText(CharSequence text, int newCursorPosition) {
        boolean result = super.commitText(text, newCursorPosition);
        markDirty();
        return result;
    }

    public boolean deleteSurroundingText(int beforeLength, int afterLength) {
        if (Selection.getSelectionStart(this.mEditable) == -1) {
            return true;
        }
        boolean result = super.deleteSurroundingText(beforeLength, afterLength);
        markDirty();
        return result;
    }

    public boolean deleteSurroundingTextInCodePoints(int beforeLength, int afterLength) {
        boolean result = super.deleteSurroundingTextInCodePoints(beforeLength, afterLength);
        markDirty();
        return result;
    }

    public boolean setComposingRegion(int start, int end) {
        boolean result = super.setComposingRegion(start, end);
        markDirty();
        return result;
    }

    public boolean setComposingText(CharSequence text, int newCursorPosition) {
        boolean result;
        if (text.length() == 0) {
            result = super.commitText(text, newCursorPosition);
        } else {
            result = super.setComposingText(text, newCursorPosition);
        }
        markDirty();
        return result;
    }

    public boolean finishComposingText() {
        boolean result = super.finishComposingText();
        if (this.isSamsung && Build.VERSION.SDK_INT >= 21) {
            CursorAnchorInfo.Builder builder = new CursorAnchorInfo.Builder();
            builder.setComposingText(-1, "");
            this.mImm.updateCursorAnchorInfo(this.mFlutterView, builder.build());
        }
        markDirty();
        return result;
    }

    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        ExtractedText extractedText = new ExtractedText();
        extractedText.selectionStart = Selection.getSelectionStart(this.mEditable);
        extractedText.selectionEnd = Selection.getSelectionEnd(this.mEditable);
        extractedText.text = this.mEditable.toString();
        return extractedText;
    }

    public boolean clearMetaKeyStates(int states) {
        boolean result = super.clearMetaKeyStates(states);
        markDirty();
        return result;
    }

    private boolean isSamsung() {
        if (this.mImm.getCurrentInputMethodSubtype() == null || Build.VERSION.SDK_INT < 21 || !Build.MANUFACTURER.equals("samsung")) {
            return false;
        }
        return Settings.Secure.getString(this.mFlutterView.getContext().getContentResolver(), "default_input_method").contains("Samsung");
    }

    public boolean setSelection(int start, int end) {
        boolean result = super.setSelection(start, end);
        markDirty();
        updateEditingState();
        return result;
    }

    private static int clampIndexToEditable(int index, Editable editable) {
        int clamped = Math.max(0, Math.min(editable.length(), index));
        if (clamped != index) {
            Log.d("flutter", "Text selection index was clamped (" + index + "->" + clamped + ") to remain in bounds. This may not be your fault, as some keyboards may select outside of bounds.");
        }
        return clamped;
    }

    public boolean sendKeyEvent(KeyEvent event) {
        markDirty();
        if (event.getAction() == 0) {
            if (event.getKeyCode() == 67) {
                int selStart = clampIndexToEditable(Selection.getSelectionStart(this.mEditable), this.mEditable);
                int selEnd = clampIndexToEditable(Selection.getSelectionEnd(this.mEditable), this.mEditable);
                if (selStart == selEnd && selStart > 0) {
                    selStart = this.flutterTextUtils.getOffsetBefore(this.mEditable, selStart);
                }
                if (selEnd <= selStart) {
                    return false;
                }
                Selection.setSelection(this.mEditable, selStart);
                this.mEditable.delete(selStart, selEnd);
                updateEditingState();
                return true;
            } else if (event.getKeyCode() == 21) {
                int selStart2 = Selection.getSelectionStart(this.mEditable);
                int selEnd2 = Selection.getSelectionEnd(this.mEditable);
                if (selStart2 != selEnd2 || event.isShiftPressed()) {
                    setSelection(selStart2, Math.max(this.flutterTextUtils.getOffsetBefore(this.mEditable, selEnd2), 0));
                } else {
                    int newSel = Math.max(this.flutterTextUtils.getOffsetBefore(this.mEditable, selStart2), 0);
                    setSelection(newSel, newSel);
                }
                return true;
            } else if (event.getKeyCode() == 22) {
                int selStart3 = Selection.getSelectionStart(this.mEditable);
                int selEnd3 = Selection.getSelectionEnd(this.mEditable);
                if (selStart3 != selEnd3 || event.isShiftPressed()) {
                    setSelection(selStart3, Math.min(this.flutterTextUtils.getOffsetAfter(this.mEditable, selEnd3), this.mEditable.length()));
                } else {
                    int newSel2 = Math.min(this.flutterTextUtils.getOffsetAfter(this.mEditable, selStart3), this.mEditable.length());
                    setSelection(newSel2, newSel2);
                }
                return true;
            } else if (event.getKeyCode() == 19) {
                if (Selection.getSelectionStart(this.mEditable) != Selection.getSelectionEnd(this.mEditable) || event.isShiftPressed()) {
                    Selection.extendUp(this.mEditable, this.mLayout);
                    setSelection(Selection.getSelectionStart(this.mEditable), Selection.getSelectionEnd(this.mEditable));
                } else {
                    Selection.moveUp(this.mEditable, this.mLayout);
                    int newSelStart = Selection.getSelectionStart(this.mEditable);
                    setSelection(newSelStart, newSelStart);
                }
                return true;
            } else if (event.getKeyCode() == 20) {
                if (Selection.getSelectionStart(this.mEditable) != Selection.getSelectionEnd(this.mEditable) || event.isShiftPressed()) {
                    Selection.extendDown(this.mEditable, this.mLayout);
                    setSelection(Selection.getSelectionStart(this.mEditable), Selection.getSelectionEnd(this.mEditable));
                } else {
                    Selection.moveDown(this.mEditable, this.mLayout);
                    int newSelStart2 = Selection.getSelectionStart(this.mEditable);
                    setSelection(newSelStart2, newSelStart2);
                }
                return true;
            } else if ((event.getKeyCode() == 66 || event.getKeyCode() == 160) && (131072 & this.mEditorInfo.inputType) == 0) {
                performEditorAction(this.mEditorInfo.imeOptions & 255);
                return true;
            } else {
                int character = event.getUnicodeChar();
                if (character == 0) {
                    return false;
                }
                int selStart4 = Math.max(0, Selection.getSelectionStart(this.mEditable));
                int selEnd4 = Math.max(0, Selection.getSelectionEnd(this.mEditable));
                int selMin = Math.min(selStart4, selEnd4);
                int selMax = Math.max(selStart4, selEnd4);
                if (selMin != selMax) {
                    this.mEditable.delete(selMin, selMax);
                }
                this.mEditable.insert(selMin, String.valueOf((char) character));
                setSelection(selMin + 1, selMin + 1);
                return true;
            }
        } else if (event.getAction() != 1 || (event.getKeyCode() != 59 && event.getKeyCode() != 60)) {
            return false;
        } else {
            int selEnd5 = Selection.getSelectionEnd(this.mEditable);
            setSelection(selEnd5, selEnd5);
            return true;
        }
    }

    public boolean performContextMenuAction(int id) {
        markDirty();
        if (id == 16908319) {
            setSelection(0, this.mEditable.length());
            return true;
        } else if (id == 16908320) {
            int selStart = Selection.getSelectionStart(this.mEditable);
            int selEnd = Selection.getSelectionEnd(this.mEditable);
            if (selStart != selEnd) {
                int selMin = Math.min(selStart, selEnd);
                int selMax = Math.max(selStart, selEnd);
                ((ClipboardManager) this.mFlutterView.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", this.mEditable.subSequence(selMin, selMax)));
                this.mEditable.delete(selMin, selMax);
                setSelection(selMin, selMin);
            }
            return true;
        } else if (id == 16908321) {
            int selStart2 = Selection.getSelectionStart(this.mEditable);
            int selEnd2 = Selection.getSelectionEnd(this.mEditable);
            if (selStart2 != selEnd2) {
                ((ClipboardManager) this.mFlutterView.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", this.mEditable.subSequence(Math.min(selStart2, selEnd2), Math.max(selStart2, selEnd2))));
            }
            return true;
        } else if (id != 16908322) {
            return false;
        } else {
            ClipData clip = ((ClipboardManager) this.mFlutterView.getContext().getSystemService("clipboard")).getPrimaryClip();
            if (clip != null) {
                CharSequence textToPaste = clip.getItemAt(0).coerceToText(this.mFlutterView.getContext());
                int selStart3 = Math.max(0, Selection.getSelectionStart(this.mEditable));
                int selEnd3 = Math.max(0, Selection.getSelectionEnd(this.mEditable));
                int selMin2 = Math.min(selStart3, selEnd3);
                int selMax2 = Math.max(selStart3, selEnd3);
                if (selMin2 != selMax2) {
                    this.mEditable.delete(selMin2, selMax2);
                }
                this.mEditable.insert(selMin2, textToPaste);
                int newSelStart = textToPaste.length() + selMin2;
                setSelection(newSelStart, newSelStart);
            }
            return true;
        }
    }

    public boolean performPrivateCommand(String action, Bundle data) {
        this.textInputChannel.performPrivateCommand(this.mClient, action, data);
        return true;
    }

    public boolean performEditorAction(int actionCode) {
        markDirty();
        if (actionCode == 0) {
            this.textInputChannel.unspecifiedAction(this.mClient);
        } else if (actionCode == 1) {
            this.textInputChannel.newline(this.mClient);
        } else if (actionCode == 2) {
            this.textInputChannel.go(this.mClient);
        } else if (actionCode == 3) {
            this.textInputChannel.search(this.mClient);
        } else if (actionCode == 4) {
            this.textInputChannel.send(this.mClient);
        } else if (actionCode == 5) {
            this.textInputChannel.next(this.mClient);
        } else if (actionCode != 7) {
            this.textInputChannel.done(this.mClient);
        } else {
            this.textInputChannel.previous(this.mClient);
        }
        return true;
    }
}
