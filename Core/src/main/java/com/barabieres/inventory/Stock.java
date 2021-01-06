package com.barabieres.inventory;

import com.barabieres.Item.Beer;

public class Stock {

    private final Beer beer;
    private int quantity;

    public Stock(Beer beer) {
        this.beer = beer;
        this.quantity = 0;
    }

    public Stock(Beer beer, int quantity) {
        this.beer = beer;
        this.quantity = quantity;
    }

    public Beer getBeer() {
        return beer;
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

    //diminue la quantité du nombre passé en paramètre
    public void decreaseQuantity(int quantity) {
        this.setQuantity(this.quantity - quantity);
    }
}
