package com.github.straightth.graphic.editor.view.toolbar;

import com.github.straightth.graphic.editor.control.tool.Size;
import com.github.straightth.graphic.editor.control.tool.Tool;
import com.github.straightth.graphic.editor.view.toolbar.buttons.ColorToggleButton;
import com.github.straightth.graphic.editor.view.toolbar.buttons.SizeToggleButton;
import com.github.straightth.graphic.editor.view.toolbar.buttons.ToolToggleButton;
import com.github.straightth.graphic.editor.view.toolbar.buttons.ZoomToggleButton;
import javafx.geometry.Orientation;
import javafx.scene.control.ToolBar;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class MyToolBar extends ToolBar {
    private static final ArrayList<ToolToggleButton> toolToggleButtons = new ArrayList<>();

    private static final ArrayList<SizeToggleButton> toolSizeToggleButtons = new ArrayList<>();

    private static final ArrayList<ColorToggleButton> toolColorToggleButtons = new ArrayList<>();

    private static final ArrayList<ZoomToggleButton> canvasZoomToggleButtons = new ArrayList<>();

    public MyToolBar() {
        super();

        setOrientation(Orientation.VERTICAL);

        setToolInitialization();

        setToolSizeInitialization();

        setToolColorInitialization();

        setCanvasZoomInitialization();
    }

    private void setToolInitialization() {
        getItems().add(new Text("Tool:"));

        ToolToggleButton pencil = new ToolToggleButton(Tool.PENCIL);
        toolToggleButtons.add(pencil);

        ToolToggleButton line = new ToolToggleButton(Tool.LINE);
        toolToggleButtons.add(line);

        ToolToggleButton rectangle = new ToolToggleButton(Tool.RECTANGLE);
        toolToggleButtons.add(rectangle);

        ToolToggleButton eraser = new ToolToggleButton(Tool.ERASER);
        toolToggleButtons.add(eraser);

        ToolToggleButton text = new ToolToggleButton(Tool.TEXT);
        toolToggleButtons.add(text);

        ToolToggleButton select = new ToolToggleButton(Tool.SELECT);
        toolToggleButtons.add(select);

        ToolToggleButton freeFormSelect = new ToolToggleButton(Tool.FREE_FORM_SELECT);
        toolToggleButtons.add(freeFormSelect);

        MyToggleGroup toggleGroup = new MyToggleGroup();
        toggleGroup.getToggles().addAll(toolToggleButtons);

        pencil.setSelected(true);

        getItems().addAll(toolToggleButtons);
    }

    private void setToolSizeInitialization() {
        getItems().add(new Text("Size:"));

        SizeToggleButton one = new SizeToggleButton(Size.ONE);
        toolSizeToggleButtons.add(one);

        SizeToggleButton two = new SizeToggleButton(Size.TWO);
        toolSizeToggleButtons.add(two);

        SizeToggleButton five = new SizeToggleButton(Size.FIVE);
        toolSizeToggleButtons.add(five);

        MyToggleGroup toggleGroup = new MyToggleGroup();
        toggleGroup.getToggles().addAll(toolSizeToggleButtons);

        one.setSelected(true);

        getItems().addAll(toolSizeToggleButtons);
    }

    private void setToolColorInitialization() {
        getItems().add(new Text("Color:"));

        ColorToggleButton black = new ColorToggleButton("Black", Color.BLACK);
        toolColorToggleButtons.add(black);

        ColorToggleButton red = new ColorToggleButton("Red", Color.RED);
        toolColorToggleButtons.add(red);

        ColorToggleButton green = new ColorToggleButton("Green", Color.GREEN);
        toolColorToggleButtons.add(green);

        ColorToggleButton blue = new ColorToggleButton("Blue", Color.BLUE);
        toolColorToggleButtons.add(blue);

        MyToggleGroup toggleGroup = new MyToggleGroup();
        toggleGroup.getToggles().addAll(toolColorToggleButtons);

        black.setSelected(true);

        getItems().addAll(toolColorToggleButtons);
    }

    private void setCanvasZoomInitialization() {
        getItems().add(new Text("Canvas zoom:"));

        ZoomToggleButton one = new ZoomToggleButton("1x", 1);
        canvasZoomToggleButtons.add(one);

        ZoomToggleButton two = new ZoomToggleButton("2x", 2);
        canvasZoomToggleButtons.add(two);

        ZoomToggleButton four = new ZoomToggleButton("4x", 4);
        canvasZoomToggleButtons.add(four);

        MyToggleGroup toggleGroup = new MyToggleGroup();
        toggleGroup.getToggles().addAll(canvasZoomToggleButtons);

        one.setSelected(true);

        getItems().addAll(canvasZoomToggleButtons);
    }

    public static void selectTool(Tool tool) {
        setDisableToolSizeToggleButtons(tool == Tool.SELECT || tool == Tool.FREE_FORM_SELECT);
        setDisableToolColorToggleButtons(tool == Tool.ERASER || tool == Tool.SELECT || tool == Tool.FREE_FORM_SELECT);
        for (var button : toolToggleButtons) {
            if (button.getTool().equals(tool)) {
                button.setSelected(true);
                break;
            }
        }
    }

    public static void selectToolSize(int size) {
        for (var button : toolSizeToggleButtons) {
            if (button.getSize() == size) {
                button.setSelected(true);
                break;
            }
        }
    }

    public static void selectToolColor(Color color) {
        for (var button : toolColorToggleButtons) {
            if (button.getColor().equals(color)) {
                button.setSelected(true);
                break;
            }
        }
    }

    public static void selectCanvasZoom(int scale) {
        for (var button : canvasZoomToggleButtons) {
            if (button.getScale() == scale) {
                button.setSelected(true);
                break;
            }
        }
    }

    public static void setDisableToolSizeToggleButtons(boolean disable) {
        for (var button : toolSizeToggleButtons) {
            button.setDisable(disable);
        }
    }

    public static void setDisableToolColorToggleButtons(boolean disable) {
        for (var button : toolColorToggleButtons) {
            button.setDisable(disable);
        }
    }
}
