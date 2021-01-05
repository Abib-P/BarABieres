package com.barabieres.inventory;

import com.barabieres.Item.Item;

public class Stock {

    private Item item;
    private int quantity;

    public Stock(Item item) {
        this.item = item;
        this.quantity = 0;
    }

    public Stock(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //augmente la quantité du nombre passé en paramètre
    public void increaseQuantity(int quantity) {
        this.setQuantity(this.quantity + quantity);
    }
}
