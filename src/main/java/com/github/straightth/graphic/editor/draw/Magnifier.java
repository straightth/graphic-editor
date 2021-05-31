package com.github.straightth.graphic.editor.draw;

import javafx.scene.transform.Scale;

public class Magnifier {
    private Magnifier() {
        throw new IllegalStateException("Utility class");
    }

    static void scale(CanvasLayout canvasLayout, int scale) {
        if (scale != canvasLayout.getScale()) {
            canvasLayout.getTransforms().clear();
            canvasLayout.getTransforms().add(new Scale(scale, scale, canvasLayout.getScaleX(), canvasLayout.getScaleY()));
            canvasLayout.setPrefSize(canvasLayout.getWidth() / canvasLayout.getScale() * scale,
                    canvasLayout.getHeight() / canvasLayout.getScale() * scale);
            canvasLayout.setScale(scale);
        }
    }
}
