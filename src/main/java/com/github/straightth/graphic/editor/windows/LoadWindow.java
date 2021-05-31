package com.github.straightth.graphic.editor.windows;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static com.github.straightth.graphic.editor.file.Loader.load;
import static com.github.straightth.graphic.editor.windows.SaveWindow.getFileChooser;


public class LoadWindow {
    private LoadWindow() {
        throw new IllegalStateException("Utility class");
    }

    public static void show() {
        Stage stage = new Stage();
        stage.setScene(new Scene(new Group()));

        load(getFileChooser().showOpenDialog(stage));
    }
}