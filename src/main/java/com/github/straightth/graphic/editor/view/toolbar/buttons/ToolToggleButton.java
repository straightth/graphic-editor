package com.github.straightth.graphic.editor.view.toolbar.buttons;

import com.github.straightth.graphic.editor.control.Controller;
import com.github.straightth.graphic.editor.control.tool.Tool;
import javafx.scene.control.ToggleButton;

public class ToolToggleButton extends ToggleButton {
    private final Tool tool;

    public ToolToggleButton(Tool tool) {
        super(tool.toString());
        this.tool = tool;
        setOnAction(actionEvent -> Controller.selectTool(tool));
    }

    public Tool getTool() {
        return tool;
    }
}
