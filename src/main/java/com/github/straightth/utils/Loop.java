package com.github.straightth.utils;

import java.util.Iterator;

public class Loop {
    private Loop() {
        throw new IllegalStateException("Utility class");
    }

    public static Iterable<Integer> range(int fromInclusive, int toExclusive) {
        return () -> new Iterator<>() {
            int cursor = fromInclusive;
            public boolean hasNext() { return cursor < toExclusive; }
            public Integer next() { return cursor++; }
        };
    }
}
