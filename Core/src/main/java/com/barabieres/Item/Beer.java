package com.barabieres.Item;

public class Beer extends Item{

    private double sellingPrice;

    public Beer(String name, double value) {
        super(name, value);
        this.sellingPrice = value;
    }

    public double getSellingPrice() {
        return this.sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}
