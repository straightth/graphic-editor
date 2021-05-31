package com.github.straightth.graphic.editor.draw.buffer;

import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BufferedImage extends ImageView {
    private Image image;

    public BufferedImage() {
        super();

        setFocusTraversable(true);
    }

    public void snapshot(Canvas canvas, double x, double y, double width, double height) {
        SnapshotParameters snapshotParameters = new SnapshotParameters();
        snapshotParameters.setViewport(new Rectangle2D(x, y, width, height));

        image = canvas.snapshot(snapshotParameters, null);

        setImage(image);
    }

    public boolean isEmpty() {
        return image == null;
    }
}
