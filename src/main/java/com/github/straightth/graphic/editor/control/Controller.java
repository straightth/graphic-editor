package com.github.straightth.graphic.editor.control;

import com.github.straightth.graphic.editor.GraphicEditor;
import com.github.straightth.graphic.editor.view.menubar.MyMenuBar;
import com.github.straightth.graphic.editor.control.tool.Tool;
import com.github.straightth.graphic.editor.view.toolbar.MyToolBar;
import javafx.scene.paint.Color;

public class Controller {
    private static Tool tool = Tool.PENCIL;

    private Controller() {
        throw new IllegalStateException("Controller");
    }

    public static void selectTool(Tool tool) {
        Controller.tool = tool;
        MyToolBar.selectTool(tool);
        MyMenuBar.selectToolMenuItem(tool);
        GraphicEditor.getCanvasLayout().resetTools();
        setSizeOfSelectedTool(tool.getSize());
        setColorOfSelectedTool(tool.getColor());
        GraphicEditor.getCanvasLayout().setCursor(tool.getCursor());
    }

    public static void setSizeOfSelectedTool(int size) {
        tool.setSize(size);
        MyToolBar.selectToolSize(size);
        MyMenuBar.selectToolSizeMenuItem(size);
    }

    public static void setColorOfSelectedTool(Color color) {
        tool.setColor(color);
        MyToolBar.selectToolColor(color);
        MyMenuBar.selectToolColorMenuItem(color);
    }

    public static void setCanvasScale(int scale) {
        GraphicEditor.getCanvasLayout().zoom(scale);
        MyToolBar.selectCanvasZoom(scale);
        MyMenuBar.selectCanvasZoomRadioMenuItems(scale);
    }

    public static void setDisableToolSizeControls(boolean disable) {
        MyToolBar.setDisableToolSizeToggleButtons(disable);
        MyMenuBar.setDisableToolSizeRadioMenuItems(disable);
    }

    public static void setDisableToolColorControls(boolean disable) {
        MyToolBar.setDisableToolColorToggleButtons(disable);
        MyMenuBar.setDisableToolColorRadioMenuItems(disable);
    }

    public static Tool getTool() {
        return tool;
    }
}
