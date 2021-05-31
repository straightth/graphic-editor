package com.github.straightth.graphic.editor.utils;

import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Region;

public class Binder {
    private Binder() {
        throw new IllegalStateException("Utility class");
    }

    public static void bindWidthToScene(Region bindable) {
        bindable.prefWidthProperty().bind(bindable.getScene().widthProperty());
    }

    public static void bindHeightToScene(Region bindable) {
        bindable.prefHeightProperty().bind(bindable.getScene().heightProperty());
    }

    public static void bindWidth(Region bindable, Region propertySource) {
        bindable.prefWidthProperty().bind(propertySource.widthProperty());
    }

    public static void bindHeight(Region bindable, Region propertySource) {
        bindable.prefHeightProperty().bind(propertySource.getScene().heightProperty());
    }

    public static void bindWidth(Region bindable, DoubleProperty property) {
        bindable.prefWidthProperty().bind(property);
    }

    public static void bindHeight(Region bindable, DoubleProperty property) {
        bindable.prefHeightProperty().bind(property);
    }
}
