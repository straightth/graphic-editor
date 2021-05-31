package com.github.straightth.graphic.editor.file;
import com.github.straightth.graphic.editor.GraphicEditor;
import javafx.scene.image.Image;

import java.io.*;

public class Loader {
    private Loader() {
        throw new IllegalStateException("Utility class");
    }

    public static void load(File file) {
        if (file != null) {
            GraphicEditor.getCanvasLayout().drawImage(new Image(file.toURI().toString()));
        }
    }
}
