package com.barabieres.inventory;

public enum InventorySizes {
    small(100),
    average(200),
    big(300),
    ;

    private final int size;

    InventorySizes(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
