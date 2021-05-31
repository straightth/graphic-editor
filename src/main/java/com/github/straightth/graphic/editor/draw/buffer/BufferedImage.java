package com.github.straightth.graphic.editor.draw.buffer;

import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

public class BufferedImage extends ImageView {
    private WritableImage writableImage;

    public BufferedImage() {
        super();

        setFocusTraversable(true);
    }

    public void snapshot(Canvas canvas, double x, double y, double width, double height) {
        SnapshotParameters snapshotParameters = new SnapshotParameters();
        snapshotParameters.setViewport(new Rectangle2D(x, y, width, height));

        writableImage = canvas.snapshot(snapshotParameters, null);

        setImage(writableImage);
    }

    public WritableImage getWritableImage() {
        return writableImage;
    }

    public boolean isEmpty() {
        return writableImage == null;
    }

    public void clear() {
        writableImage = null;
    }
}
