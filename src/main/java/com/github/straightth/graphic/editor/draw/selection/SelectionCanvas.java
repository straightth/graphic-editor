package com.github.straightth.graphic.editor.draw.selection;

import com.github.straightth.graphic.editor.utils.Coordinate;
import javafx.scene.canvas.Canvas;

public class SelectionCanvas extends Canvas {
    Coordinate lowestCoordinate;
    Coordinate highestCoordinate;

    public SelectionCanvas() {
        super();
    }

    public Coordinate getLowestCoordinate() {
        return lowestCoordinate;
    }

    public void setLowestCoordinate(Coordinate coordinate) {
        lowestCoordinate = coordinate;
    }

    public Coordinate getHighestCoordinate() {
        return highestCoordinate;
    }

    public void setHighestCoordinate(Coordinate coordinate) {
        highestCoordinate = coordinate;
    }

    public Coordinate getSelectionPivot() {
        return new Coordinate(highestCoordinate.x - getSelectionWidth() / 2,
                highestCoordinate.y - getSelectionHeight() / 2);
    }

    public double getSelectionWidth() {
        return highestCoordinate.x - lowestCoordinate.x;
    }

    public double getSelectionHeight() {
        return highestCoordinate.y - lowestCoordinate.y;
    }

    public void clear() {
        getGraphicsContext2D().clearRect(0, 0, getWidth(), getHeight());
    }
}
