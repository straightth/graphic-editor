package com.github.straightth.graphic.editor.view.menubar.buttons;

import com.github.straightth.graphic.editor.control.Controller;
import javafx.scene.control.RadioMenuItem;

public class ZoomRadioMenuItem extends RadioMenuItem {
    private final int scale;

    public ZoomRadioMenuItem(String text, int scale) {
        super(text);
        this.scale = scale;
        setOnAction(actionEvent -> Controller.setCanvasScale(scale));
    }

    public int getScale() {
        return scale;
    }
}
