package io.flutter.embedding.android;

import android.util.Log;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.plugin.editing.TextInputPlugin;
import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class AndroidKeyProcessor {
    private static final String TAG = "AndroidKeyProcessor";
    private static long eventIdSerial = 0;
    private int combiningCharacter;
    private EventResponder eventResponder;
    private final KeyEventChannel keyEventChannel;
    private final TextInputPlugin textInputPlugin;

    public AndroidKeyProcessor(View view, KeyEventChannel keyEventChannel2, TextInputPlugin textInputPlugin2) {
        this.keyEventChannel = keyEventChannel2;
        this.textInputPlugin = textInputPlugin2;
        EventResponder eventResponder2 = new EventResponder(view);
        this.eventResponder = eventResponder2;
        this.keyEventChannel.setEventResponseHandler(eventResponder2);
    }

    public void destroy() {
        this.keyEventChannel.setEventResponseHandler((KeyEventChannel.EventResponseHandler) null);
    }

    public boolean onKeyUp(KeyEvent keyEvent) {
        if (this.eventResponder.dispatchingKeyEvent) {
            return false;
        }
        Character complexCharacter = applyCombiningCharacterToBaseCharacter(keyEvent.getUnicodeChar());
        long j = eventIdSerial;
        eventIdSerial = 1 + j;
        KeyEventChannel.FlutterKeyEvent flutterEvent = new KeyEventChannel.FlutterKeyEvent(keyEvent, complexCharacter, j);
        this.keyEventChannel.keyUp(flutterEvent);
        this.eventResponder.addEvent(flutterEvent.eventId, keyEvent);
        return true;
    }

    public boolean onKeyDown(KeyEvent keyEvent) {
        if (this.eventResponder.dispatchingKeyEvent) {
            return false;
        }
        if (this.textInputPlugin.getLastInputConnection() != null && this.textInputPlugin.getInputMethodManager().isAcceptingText() && this.textInputPlugin.getLastInputConnection().sendKeyEvent(keyEvent)) {
            return true;
        }
        Character complexCharacter = applyCombiningCharacterToBaseCharacter(keyEvent.getUnicodeChar());
        long j = eventIdSerial;
        eventIdSerial = 1 + j;
        KeyEventChannel.FlutterKeyEvent flutterEvent = new KeyEventChannel.FlutterKeyEvent(keyEvent, complexCharacter, j);
        this.keyEventChannel.keyDown(flutterEvent);
        this.eventResponder.addEvent(flutterEvent.eventId, keyEvent);
        return true;
    }

    private Character applyCombiningCharacterToBaseCharacter(int newCharacterCodePoint) {
        if (newCharacterCodePoint == 0) {
            return null;
        }
        char complexCharacter = (char) newCharacterCodePoint;
        if ((Integer.MIN_VALUE & newCharacterCodePoint) != 0) {
            int plainCodePoint = Integer.MAX_VALUE & newCharacterCodePoint;
            int i = this.combiningCharacter;
            if (i != 0) {
                this.combiningCharacter = KeyCharacterMap.getDeadChar(i, plainCodePoint);
            } else {
                this.combiningCharacter = plainCodePoint;
            }
        } else {
            int i2 = this.combiningCharacter;
            if (i2 != 0) {
                int combinedChar = KeyCharacterMap.getDeadChar(i2, newCharacterCodePoint);
                if (combinedChar > 0) {
                    complexCharacter = (char) combinedChar;
                }
                this.combiningCharacter = 0;
            }
        }
        return Character.valueOf(complexCharacter);
    }

    private static class EventResponder implements KeyEventChannel.EventResponseHandler {
        private static final long MAX_PENDING_EVENTS = 1000;
        boolean dispatchingKeyEvent = false;
        final Deque<Map.Entry<Long, KeyEvent>> pendingEvents = new ArrayDeque();
        private final View view;

        public EventResponder(View view2) {
            this.view = view2;
        }

        private KeyEvent removePendingEvent(long id) {
            if (((Long) this.pendingEvents.getFirst().getKey()).longValue() == id) {
                return (KeyEvent) this.pendingEvents.removeFirst().getValue();
            }
            throw new AssertionError("Event response received out of order. Should have seen event " + this.pendingEvents.getFirst().getKey() + " first. Instead, received " + id);
        }

        public void onKeyEventHandled(long id) {
            removePendingEvent(id);
        }

        public void onKeyEventNotHandled(long id) {
            dispatchKeyEvent(removePendingEvent(id));
        }

        public void addEvent(long id, KeyEvent event) {
            if (this.pendingEvents.size() <= 0 || ((Long) this.pendingEvents.getFirst().getKey()).longValue() < id) {
                this.pendingEvents.addLast(new AbstractMap.SimpleImmutableEntry(Long.valueOf(id), event));
                if (((long) this.pendingEvents.size()) > 1000) {
                    Log.e(AndroidKeyProcessor.TAG, "There are " + this.pendingEvents.size() + " keyboard events that have not yet received a response. Are responses being sent?");
                    return;
                }
                return;
            }
            throw new AssertionError("New events must have ids greater than the most recent pending event. New id " + id + " is less than or equal to the last event id of " + this.pendingEvents.getFirst().getKey());
        }

        public void dispatchKeyEvent(KeyEvent event) {
            View view2 = this.view;
            if (view2 != null) {
                this.dispatchingKeyEvent = true;
                view2.getRootView().dispatchKeyEvent(event);
                this.dispatchingKeyEvent = false;
            }
        }
    }
}
