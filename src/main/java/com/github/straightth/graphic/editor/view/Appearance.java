package com.github.straightth.graphic.editor.view;

import com.github.straightth.graphic.editor.GraphicEditor;
import com.github.straightth.graphic.editor.draw.events.MyKeyEvent;
import com.github.straightth.graphic.editor.view.menubar.MyMenuBar;
import com.github.straightth.graphic.editor.view.toolbar.MyToolBar;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class Appearance extends Group {
    private static final int WIDTH = 1280;

    private static final int HEIGHT = 720;

    private static final Color BACKGROUND = Color.WHITESMOKE;

    public Appearance() {
        MyMenuBar menuBar = new MyMenuBar();

        MyToolBar toolBar = new MyToolBar();

        HBox hBox = new HBox(toolBar);

        getChildren().addAll(new VBox(menuBar,hBox));
        applyCss();
        layout();

        GraphicEditor.getCanvasLayout().setCanvasSize(WIDTH - toolBar.getWidth(), HEIGHT - menuBar.getHeight());

        ScrollPane scrollPane = new ScrollPane(GraphicEditor.getCanvasLayout());
        scrollPane.setMaxWidth(WIDTH - toolBar.getWidth() - 135);
        scrollPane.setMaxHeight(HEIGHT - menuBar.getHeight() - 25);

        hBox.getChildren().add(scrollPane);

        eventHandlersInitialization();
    }

    private void eventHandlersInitialization() {
        addEventHandler(KeyEvent.KEY_PRESSED,
                (final KeyEvent keyEvent) -> {
            GraphicEditor.getCanvasLayout().fireEvent(new MyKeyEvent(MyKeyEvent.KEY_PRESSED,
                    keyEvent.getCode(), keyEvent.isControlDown()));
        });
    }

    public static int getWidth() {
        return WIDTH;
    }

    public static int getHeight() {
        return HEIGHT;
    }

    public static Color getBackground() {
        return BACKGROUND;
    }
}
