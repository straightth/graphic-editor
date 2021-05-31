package com.github.straightth.graphic.editor.view.menubar.menus.tool;

import com.github.straightth.graphic.editor.control.tool.Size;
import com.github.straightth.graphic.editor.view.menubar.buttons.SizeRadioMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;

public class SetToolSizeMenu extends Menu {
    public static final ArrayList<SizeRadioMenuItem> toolSizeRadioMenuItems = new ArrayList<>();

    public SetToolSizeMenu() {
        super("Set size");

        SizeRadioMenuItem one = new SizeRadioMenuItem(Size.ONE);
        toolSizeRadioMenuItems.add(one);

        SizeRadioMenuItem two = new SizeRadioMenuItem(Size.TWO);
        toolSizeRadioMenuItems.add(two);

        SizeRadioMenuItem five = new SizeRadioMenuItem(Size.FIVE);
        toolSizeRadioMenuItems.add(five);

        getItems().addAll(toolSizeRadioMenuItems);

        ToggleGroup toggleGroup = new ToggleGroup();
        toggleGroup.getToggles().addAll(toolSizeRadioMenuItems);

        one.setSelected(true);
    }
}
