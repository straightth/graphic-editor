package com.github.straightth.graphic.editor.file;

import com.github.straightth.graphic.editor.GraphicEditor;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

public class Saver {
    private Saver() {
        throw new IllegalStateException("Utility class");
    }

    public static void save(File file) {
        SnapshotParameters snapshotParameters = new SnapshotParameters();
        snapshotParameters.setViewport(new Rectangle2D(0, 0,
                GraphicEditor.getCanvasLayout().getWidth(), GraphicEditor.getCanvasLayout().getHeight()));
        WritableImage writableImage = GraphicEditor.getCanvasLayout().snapshot(snapshotParameters, null);
        RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
        if (file != null) {
            try {
                ImageIO.write(renderedImage, "png", file);
            } catch (NullPointerException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
