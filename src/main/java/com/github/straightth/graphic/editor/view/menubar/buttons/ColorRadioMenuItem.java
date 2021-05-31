package com.github.straightth.graphic.editor.view.menubar.buttons;

import com.github.straightth.graphic.editor.control.Controller;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.paint.Color;

public class ColorRadioMenuItem extends RadioMenuItem {
    private final Color color;

    public ColorRadioMenuItem(String text, Color color) {
        super(text);
        this.color = color;
        setOnAction(actionEvent -> Controller.setColorOfSelectedTool(color));
    }

    public Color getColor() {
        return color;
    }
}
