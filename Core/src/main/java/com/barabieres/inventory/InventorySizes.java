package com.barabieres.inventory;

public enum InventorySizes {
    small(10),
    average(20),
    big(30),
    ;

    private final int size;

    InventorySizes(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
