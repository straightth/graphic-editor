package com.github.straightth.graphic.editor.draw.events;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.input.KeyCode;

public class MyKeyEvent extends Event {
    private final KeyCode keyCode;

    private final boolean controlDown;

    public static final EventType<MyKeyEvent> KEY_PRESSED = new EventType<>(
            Event.ANY,
            "KEY_PRESSED"
    );

    public MyKeyEvent(EventType<? extends Event> eventType, KeyCode keyCode, boolean controlDown) {
        super(eventType);

        this.keyCode = keyCode;
        this.controlDown = controlDown;
    }

    public KeyCode getKeyCode() {
        return keyCode;
    }

    public boolean isControlDown() {
        return controlDown;
    }
}
