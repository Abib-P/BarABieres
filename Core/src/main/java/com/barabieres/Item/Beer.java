package com.barabieres.Item;

public class Beer extends Item{

    private double sellingPrice;
    private final double alcoholByVolume;

    public Beer(String name, double value, double alcoholByVolume) {
        super(name, value);
        this.sellingPrice = value;
        this.alcoholByVolume = alcoholByVolume;
    }

    public double getSellingPrice() {
        return this.sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getAlcoholByVolume() {
        return this.alcoholByVolume;
    }
}
