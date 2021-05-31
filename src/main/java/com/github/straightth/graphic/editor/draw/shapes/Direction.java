package com.github.straightth.graphic.editor.draw.shapes;

import com.github.straightth.graphic.editor.utils.Coordinate;

public enum Direction {
    SOUTHEAST,
    NORTHEAST,
    SOUTHWEST,
    NORTHWEST;


    public static Direction getDirection(Coordinate from, Coordinate to) {
        if (from.x < to.x && from.y < to.y) return SOUTHEAST;
        else if (from.x < to.x) return NORTHEAST;
        else if (from.y < to.y) return SOUTHWEST;
        else return NORTHWEST;
    }
}
