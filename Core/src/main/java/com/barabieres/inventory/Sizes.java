package com.barabieres.inventory;

public enum Sizes {

    small(10),
    average(20),
    big(30),
    ;

private int size;

    Sizes(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
