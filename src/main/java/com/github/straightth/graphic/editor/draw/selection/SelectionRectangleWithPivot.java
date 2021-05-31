package com.github.straightth.graphic.editor.draw.selection;

import com.github.straightth.graphic.editor.draw.shapes.RectangleWithPivot;
import com.github.straightth.graphic.editor.utils.Coordinate;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import static com.github.straightth.graphic.editor.GraphicEditor.*;

public class SelectionRectangleWithPivot extends RectangleWithPivot {
    private boolean resizeable = true;

    public SelectionRectangleWithPivot() {
        super();
        setStrokeWidth(1.5d);
        setStroke(Color.BLACK);
        getStrokeDashArray().addAll(5d, 5d);
        setCursor(Cursor.MOVE);
        moveEventHandlersInitialization();
    }

    private void moveEventHandlersInitialization() {
        Coordinate lastMouseLocation = new Coordinate(0, 0);

        this.addEventHandler(MouseEvent.MOUSE_ENTERED, (final MouseEvent mouseEvent) -> resizeable = false);

        this.addEventHandler(MouseEvent.MOUSE_EXITED, (final MouseEvent mouseEvent) -> resizeable = true);

        this.addEventHandler(MouseEvent.MOUSE_PRESSED, (
                final MouseEvent mouseEvent) -> {
            if (!resizeable) {
                lastMouseLocation.x = mouseEvent.getSceneX();
                lastMouseLocation.y = mouseEvent.getSceneY();
            }
        });

        this.addEventHandler(MouseEvent.MOUSE_DRAGGED, (
                final MouseEvent mouseEvent) -> {
            if (!resizeable) {
                double deltaX = (mouseEvent.getSceneX() - lastMouseLocation.x) / getCanvasLayout().getScale();
                double deltaY = (mouseEvent.getSceneY() - lastMouseLocation.y) / getCanvasLayout().getScale();
                if (getX() + deltaX > 0 && getX() + deltaX < getCanvasLayout().getWidth()) {
                    setX(getX() + deltaX);
                    lastMouseLocation.x = mouseEvent.getSceneX();
                }
                if (getY() + deltaY > 0 && getY() + deltaY < getCanvasLayout().getHeight()) {
                    setY(getY() + deltaY);
                    lastMouseLocation.y = mouseEvent.getSceneY();
                }
            }
        });
    }

    public boolean isResizeable() {
        return resizeable;
    }
}
