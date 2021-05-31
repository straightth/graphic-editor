package com.github.straightth.graphic.editor.draw;

import com.github.straightth.graphic.editor.utils.Coordinate;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Drawer {
    private Drawer() {
        throw new IllegalStateException("Utility class");
    }

    public static void drawPixel(GraphicsContext graphicsContext, Coordinate coordinate, double size, Color color) {
        drawLine(graphicsContext, coordinate, coordinate, size, color);
    }

    public static void drawLine(GraphicsContext graphicsContext,
                                Coordinate firstCoordinate, Coordinate secondCoordinate, double size, Color color) {
        graphicsContext.setStroke(color);
        graphicsContext.setLineWidth(size);
        graphicsContext.strokeLine(firstCoordinate.x, firstCoordinate.y, secondCoordinate.x, secondCoordinate.y);
    }

    public static void drawRectangle(GraphicsContext graphicsContext,
                                     Coordinate coordinate, double width, double height, double size, Color color) {
        graphicsContext.setFill(Color.TRANSPARENT);
        graphicsContext.setStroke(color);
        graphicsContext.setLineWidth(size + 0.5);
        graphicsContext.strokeRect(coordinate.x, coordinate.y, width, height);
    }

    public static void drawText(GraphicsContext graphicsContext,
                                String text, Coordinate coordinate, double fontSize, Color color) {
        graphicsContext.setFont(new Font(graphicsContext.getFont().getName(), fontSize));
        graphicsContext.setFill(color);
        graphicsContext.fillText(text, coordinate.x, coordinate.y + graphicsContext.getFont().getSize());
    }

    public static void drawImage(GraphicsContext graphicsContext, Image image, double x, double y) {
        graphicsContext.drawImage(image, x, y);
    }
}
