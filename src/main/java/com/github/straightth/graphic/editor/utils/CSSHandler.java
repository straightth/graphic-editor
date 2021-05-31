package com.github.straightth.graphic.editor.utils;

import javafx.scene.paint.Color;

import java.util.Objects;

public class CSSHandler {
    public static String getFontSizeStyle(double fontSize, Object instance) {
        if (fontSize == 16.25) {
            return Objects.requireNonNull(instance.getClass().getResource("size/16.css")).toExternalForm();
        } else if (fontSize == 26) {
            return Objects.requireNonNull(instance.getClass().getResource("size/26.css")).toExternalForm();
        } else {
            return Objects.requireNonNull(instance.getClass().getResource("size/13.css")).toExternalForm();
        }
    }

    public static String getTextColorStyle(Color color, Object instance) {
        if (color.equals(Color.RED)) {
            return Objects.requireNonNull(instance.getClass().getResource("color/red.css")).toExternalForm();
        } else if (color.equals(Color.GREEN)) {
            return Objects.requireNonNull(instance.getClass().getResource("color/green.css")).toExternalForm();
        } else if (color.equals(Color.BLUE)) {
            return Objects.requireNonNull(instance.getClass().getResource("color/blue.css")).toExternalForm();
        } else {
            return Objects.requireNonNull(instance.getClass().getResource("color/black.css")).toExternalForm();
        }
    }
}
