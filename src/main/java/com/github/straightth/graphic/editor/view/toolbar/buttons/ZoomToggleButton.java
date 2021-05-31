package com.github.straightth.graphic.editor.view.toolbar.buttons;

import com.github.straightth.graphic.editor.control.Controller;
import javafx.scene.control.ToggleButton;

public class ZoomToggleButton extends ToggleButton {
    private final int scale;

    public ZoomToggleButton(String text, int scale) {
        super(text);
        this.scale = scale;
        setOnAction(actionEvent -> Controller.setCanvasScale(scale));
    }

    public int getScale() {
        return scale;
    }
}
