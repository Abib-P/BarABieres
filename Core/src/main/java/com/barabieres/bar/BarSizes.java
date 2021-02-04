package com.barabieres.bar;

public enum BarSizes {
    small(75),
    average(150),
    big(300),
    ;

    private final int size;

    BarSizes(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
