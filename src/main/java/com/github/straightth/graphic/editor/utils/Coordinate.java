package com.github.straightth.graphic.editor.utils;

public class Coordinate implements Cloneable {
    public double x, y;

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Coordinate clone() {
        try {
            return (Coordinate) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            throw new Error("Something impossible just happened");
        }
    }

    public static void fillInTheBoundaryCoordinates(Coordinate source,
                                                    Coordinate lowestCoordinate, Coordinate highestCoordinate) {
        if (source.x < lowestCoordinate.x) {
            lowestCoordinate.x = source.x;
        }
        if (source.y < lowestCoordinate.y) {
            lowestCoordinate.y = source.y;
        }
        if (source.x > highestCoordinate.x) {
            highestCoordinate.x = source.x;
        }
        if (source.y > highestCoordinate.y) {
            highestCoordinate.y = source.y;
        }
    }
}
