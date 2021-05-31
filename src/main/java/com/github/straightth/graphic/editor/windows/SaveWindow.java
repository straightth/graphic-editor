package com.github.straightth.graphic.editor.windows;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import static com.github.straightth.graphic.editor.file.Saver.save;


public class SaveWindow {
    private SaveWindow() {
        throw new IllegalStateException("Utility class");
    }

    public static void show() {
        Stage stage = new Stage();
        stage.setScene(new Scene(new Group()));

        save(getFileChooser().showSaveDialog(stage));
    }

    static FileChooser getFileChooser() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter(
                "Image Files", "*.jpg", "*.png"
        );
        fileChooser.getExtensionFilters().add(extensionFilter);
        return fileChooser;
    }
}
