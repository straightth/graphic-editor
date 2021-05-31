package com.github.straightth.graphic.editor.view.menubar.menus.tool;

import com.github.straightth.graphic.editor.view.menubar.buttons.ColorRadioMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class SetToolColorMenu extends Menu {
    public static final ArrayList<ColorRadioMenuItem> toolColorRadioMenuItems = new ArrayList<>();

    public SetToolColorMenu() {
        super("Set color");

        ColorRadioMenuItem black = new ColorRadioMenuItem("Black", Color.BLACK);
        toolColorRadioMenuItems.add(black);

        ColorRadioMenuItem red = new ColorRadioMenuItem("Red", Color.RED);
        toolColorRadioMenuItems.add(red);

        ColorRadioMenuItem green = new ColorRadioMenuItem("Green", Color.GREEN);
        toolColorRadioMenuItems.add(green);

        ColorRadioMenuItem blue = new ColorRadioMenuItem("Blue", Color.BLUE);
        toolColorRadioMenuItems.add(blue);

        getItems().addAll(toolColorRadioMenuItems);

        ToggleGroup toggleGroup = new ToggleGroup();
        toggleGroup.getToggles().addAll(toolColorRadioMenuItems);

        black.setSelected(true);
    }
}
