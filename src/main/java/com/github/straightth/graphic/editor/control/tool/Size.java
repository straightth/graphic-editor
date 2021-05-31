package com.github.straightth.graphic.editor.control.tool;

public enum Size {
    ONE(1),
    TWO(2),
    FIVE(5);

    private final int size;

    Size(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return Integer.toString(size);
    }
}
