package com.github.straightth.graphic.editor.view.toolbar.buttons;

import com.github.straightth.graphic.editor.control.Controller;
import com.github.straightth.graphic.editor.control.tool.Size;
import javafx.scene.control.ToggleButton;

public class SizeToggleButton extends ToggleButton {
    private final int size;

    public SizeToggleButton(Size size) {
        super(size.toString());
        this.size = size.getSize();
        setOnAction(actionEvent -> Controller.setSizeOfSelectedTool(this.size));
    }

    public int getSize() {
        return size;
    }
}
