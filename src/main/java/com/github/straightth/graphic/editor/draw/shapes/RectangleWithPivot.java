package com.github.straightth.graphic.editor.draw.shapes;

import com.github.straightth.graphic.editor.utils.Coordinate;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectangleWithPivot extends Rectangle {
    private Coordinate pivot;

    public RectangleWithPivot() {
        super();
        setFill(Color.TRANSPARENT);
    }

    public void setPivot(double x, double y) {
        setPivot(new Coordinate(x, y));
    }

    public void setPivot(Coordinate pivot) {
        this.pivot = pivot;
    }

    public Coordinate getPivot() {
        return pivot;
    }

    public void resize(double x, double y, double borderWidth, double borderHeight) {
        resize(new Coordinate(x, y), borderWidth, borderHeight);
    }

    public void resize(Coordinate target, double borderWidth, double borderHeight) {
        resizeByDirection(Direction.getDirection(pivot, target), target, borderWidth, borderHeight);
    }

    private void resizeByDirection(Direction direction, Coordinate target,
                                   double borderWidth, double borderHeight) {
        if (target.x > 0 && target.x < borderWidth) {
            switch (direction) {
                case NORTHWEST, SOUTHWEST -> {
                    setX(target.x);
                    setWidth(pivot.x - target.x);
                }
                case NORTHEAST, SOUTHEAST -> {
                    setX(pivot.x);
                    setWidth(target.x - pivot.x);
                }
            }
        }
        if (target.y > 0 && target.y < borderHeight) {
            switch (direction) {
                case NORTHWEST, NORTHEAST -> {
                    setY(target.y);
                    setHeight(pivot.y - target.y);
                }
                case SOUTHWEST, SOUTHEAST -> {
                    setY(pivot.y);
                    setHeight(target.y - pivot.y);
                }
            }
        }
    }

    public void reset() {
        setVisible(false);
        setX(0);
        setY(0);
        setWidth(0);
        setHeight(0);
    }
}
