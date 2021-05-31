package com.github.straightth.graphic.editor.view.menubar.menus.canvas;

import com.github.straightth.graphic.editor.view.menubar.buttons.ZoomRadioMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;

public class SetCanvasZoomMenu extends Menu {
    public static final ArrayList<ZoomRadioMenuItem> canvasZoomRadioMenuItems = new ArrayList<>();


    public SetCanvasZoomMenu() {
        super("Set zoom");

        ZoomRadioMenuItem one = new ZoomRadioMenuItem("1x", 1);
        canvasZoomRadioMenuItems.add(one);

        ZoomRadioMenuItem two = new ZoomRadioMenuItem("2x", 2);
        canvasZoomRadioMenuItems.add(two);

        ZoomRadioMenuItem four = new ZoomRadioMenuItem("4x", 4);
        canvasZoomRadioMenuItems.add(four);

        getItems().addAll(canvasZoomRadioMenuItems);

        ToggleGroup toggleGroup = new ToggleGroup();
        toggleGroup.getToggles().addAll(canvasZoomRadioMenuItems);

        one.setSelected(true);
    }
}
