package com.github.straightth.graphic.editor.view.menubar.menus;

import com.github.straightth.graphic.editor.view.menubar.menus.tool.SetToolColorMenu;
import com.github.straightth.graphic.editor.view.menubar.menus.tool.SetToolMenu;
import com.github.straightth.graphic.editor.view.menubar.menus.tool.SetToolSizeMenu;
import javafx.scene.control.Menu;

public class ToolMenu extends Menu {
    public ToolMenu() {
        super("Tool");

        SetToolMenu setTool = new SetToolMenu();

        SetToolSizeMenu setToolSize = new SetToolSizeMenu();

        SetToolColorMenu setToolColor = new SetToolColorMenu();

        getItems().addAll(setTool, setToolSize, setToolColor);
    }
}
