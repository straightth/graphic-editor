package com.github.straightth.graphic.editor.control.tool;

import javafx.scene.Cursor;
import javafx.scene.paint.Color;

public enum Tool {
    PENCIL("Pencil"),
    LINE("Line"),
    RECTANGLE("Rectangle", Cursor.CROSSHAIR),
    ERASER("Eraser") {
        @Override
        public Color getColor() {
            return Color.WHITE;
        }
    },
    TEXT("Text", Cursor.CROSSHAIR),
    SELECT("Select", Cursor.CROSSHAIR),
    FREE_FORM_SELECT("Free-form select");

    private final String text;

    private int size = 1;

    private Color color = Color.BLACK;

    private Cursor cursor = Cursor.DEFAULT;

    Tool(String text) {
        this.text = text;
    }

    @SuppressWarnings("SameParameterValue")
    Tool(String text, Cursor cursor) {
        this(text);
        this.cursor = cursor;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Cursor getCursor() {
        return cursor;
    }

    @Override
    public String toString() {
        return text;
    }
}
