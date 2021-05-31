package com.github.straightth.graphic.editor.view.menubar;

import com.github.straightth.graphic.editor.control.tool.Tool;
import com.github.straightth.graphic.editor.view.menubar.menus.CanvasMenu;
import com.github.straightth.graphic.editor.view.menubar.menus.ToolMenu;
import com.github.straightth.graphic.editor.windows.AboutWindow;
import com.github.straightth.graphic.editor.windows.HelpWindow;
import com.github.straightth.graphic.editor.windows.LoadWindow;
import com.github.straightth.graphic.editor.windows.SaveWindow;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import static com.github.straightth.graphic.editor.view.menubar.menus.canvas.SetCanvasZoomMenu.canvasZoomRadioMenuItems;
import static com.github.straightth.graphic.editor.view.menubar.menus.tool.SetToolColorMenu.toolColorRadioMenuItems;
import static com.github.straightth.graphic.editor.view.menubar.menus.tool.SetToolMenu.toolRadioMenuItems;
import static com.github.straightth.graphic.editor.view.menubar.menus.tool.SetToolSizeMenu.toolSizeRadioMenuItems;

public class MyMenuBar extends MenuBar {
    public MyMenuBar() {
        super();

        Menu file = new Menu("File");

        MenuItem open = new MenuItem("Open");
        open.setOnAction(actionEvent -> LoadWindow.show());

        MenuItem save = new MenuItem("Save");
        save.setOnAction(actionEvent -> SaveWindow.show());

        file.getItems().addAll(open, save);

        Menu edit = new Menu("Edit");

        ToolMenu tool = new ToolMenu();

        CanvasMenu canvas = new CanvasMenu();

        edit.getItems().addAll(tool, canvas);

        Menu helpMenu = new Menu("Help");

        MenuItem helpMenuItem = new MenuItem("Help");
        helpMenuItem.setOnAction(actionEvent -> HelpWindow.show());

        MenuItem about = new MenuItem("About");
        about.setOnAction(actionEvent -> AboutWindow.show());

        helpMenu.getItems().addAll(helpMenuItem, about);

        getMenus().addAll(file, edit, helpMenu);
    }

    public static void selectToolMenuItem(Tool tool) {
        setDisableToolSizeRadioMenuItems(tool == Tool.SELECT || tool == Tool.FREE_FORM_SELECT);
        setDisableToolColorRadioMenuItems(tool == Tool.ERASER || tool == Tool.SELECT || tool == Tool.FREE_FORM_SELECT);
        for (var menuItem : toolRadioMenuItems) {
            if (menuItem.getTool().equals(tool)) {
                menuItem.setSelected(true);
                break;
            }
        }
    }

    public static void selectToolSizeMenuItem(int size) {
        for (var menuItem : toolSizeRadioMenuItems) {
            if (menuItem.getSize() == size) {
                menuItem.setSelected(true);
                break;
            }
        }
    }

    public static void selectToolColorMenuItem(Color color) {
        for (var menuItem : toolColorRadioMenuItems) {
            if (menuItem.getColor().equals(color)) {
                menuItem.setSelected(true);
                break;
            }
        }
    }

    public static void selectCanvasZoomRadioMenuItems(int scale) {
        for (var menuItem : canvasZoomRadioMenuItems) {
            if (menuItem.getScale() == scale) {
                menuItem.setSelected(true);
                break;
            }
        }
    }

    public static void setDisableToolSizeRadioMenuItems(boolean disable) {
        for (var button : toolSizeRadioMenuItems) {
            button.setDisable(disable);
        }
    }

    public static void setDisableToolColorRadioMenuItems(boolean disable) {
        for (var button : toolColorRadioMenuItems) {
            button.setDisable(disable);
        }
    }
}
