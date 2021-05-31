package com.github.straightth.graphic.editor.view.menubar.buttons;

import com.github.straightth.graphic.editor.control.Controller;
import com.github.straightth.graphic.editor.control.tool.Tool;
import javafx.scene.control.RadioMenuItem;

public class ToolRadioMenuItem extends RadioMenuItem {

    private final Tool tool;

    public ToolRadioMenuItem(Tool tool) {
        super(tool.toString());
        this.tool = tool;
        setOnAction(actionEvent -> Controller.selectTool(tool));
    }

    public Tool getTool() {
        return tool;
    }
}
