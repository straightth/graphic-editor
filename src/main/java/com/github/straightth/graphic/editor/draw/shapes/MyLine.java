package com.github.straightth.graphic.editor.draw.shapes;

import com.github.straightth.graphic.editor.utils.Coordinate;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;

public class MyLine extends Line {
    public MyLine() {
        super();
    }

    public void setStart(MouseEvent mouseEvent) {
        setStartX(mouseEvent.getX());
        setStartY(mouseEvent.getY());
    }

    public void setEnd(MouseEvent mouseEvent) {
        setEndX(mouseEvent.getX());
        setEndY(mouseEvent.getY());
    }

    public Coordinate getStart() {
        return new Coordinate(getStartX(), getStartY());
    }

    public Coordinate getEnd() {
        return new Coordinate(getEndX(), getEndY());
    }
}
