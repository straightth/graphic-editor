package com.github.straightth.graphic.editor.view.menubar.buttons;

import com.github.straightth.graphic.editor.control.Controller;
import com.github.straightth.graphic.editor.control.tool.Size;
import javafx.scene.control.RadioMenuItem;

public class SizeRadioMenuItem extends RadioMenuItem {
    private final int size;

    public SizeRadioMenuItem(Size size) {
        super(size.toString());
        this.size = size.getSize();
        setOnAction(actionEvent -> Controller.setSizeOfSelectedTool(this.size));
    }

    public int getSize() {
        return size;
    }
}
