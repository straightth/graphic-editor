package com.github.straightth.graphic.editor.view.menubar.menus.tool;

import com.github.straightth.graphic.editor.control.tool.Tool;
import com.github.straightth.graphic.editor.view.menubar.buttons.ToolRadioMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;

public class SetToolMenu extends Menu {
    public static final ArrayList<ToolRadioMenuItem> toolRadioMenuItems = new ArrayList<>();

    public SetToolMenu() {
        super("Set tool");

        ToolRadioMenuItem pencil = new ToolRadioMenuItem(Tool.PENCIL);
        toolRadioMenuItems.add(pencil);

        ToolRadioMenuItem line = new ToolRadioMenuItem(Tool.LINE);
        toolRadioMenuItems.add(line);

        ToolRadioMenuItem rectangle = new ToolRadioMenuItem(Tool.RECTANGLE);
        toolRadioMenuItems.add(rectangle);

        ToolRadioMenuItem eraser = new ToolRadioMenuItem(Tool.ERASER);
        toolRadioMenuItems.add(eraser);

        ToolRadioMenuItem text = new ToolRadioMenuItem(Tool.TEXT);
        toolRadioMenuItems.add(text);

        ToolRadioMenuItem select = new ToolRadioMenuItem(Tool.SELECT);
        toolRadioMenuItems.add(select);

        ToolRadioMenuItem freeFormSelect = new ToolRadioMenuItem(Tool.FREE_FORM_SELECT);
        toolRadioMenuItems.add(freeFormSelect);

        getItems().addAll(toolRadioMenuItems);

        ToggleGroup toggleGroup = new ToggleGroup();
        toggleGroup.getToggles().addAll(toolRadioMenuItems);

        pencil.setSelected(true);
    }
}
