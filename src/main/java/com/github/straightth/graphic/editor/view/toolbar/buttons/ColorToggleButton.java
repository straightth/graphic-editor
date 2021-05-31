package com.github.straightth.graphic.editor.view.toolbar.buttons;

import com.github.straightth.graphic.editor.control.Controller;
import javafx.scene.control.ToggleButton;
import javafx.scene.paint.Color;

public class ColorToggleButton extends ToggleButton {
    private final Color color;

    public ColorToggleButton(String text, Color color) {
        super(text);
        this.color = color;
        setOnAction(actionEvent -> Controller.setColorOfSelectedTool(color));
    }

    public Color getColor() {
        return color;
    }
}
