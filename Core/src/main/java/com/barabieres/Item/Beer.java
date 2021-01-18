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

    /**
     * génère un prix de vente aléatoire entre la valeur de base de la bière et sa valeur de base + 20%
     * @return
     */
    public double generateSellingPrice() {
        return this.getValue() + (Math.random() * (this.getValue() * 0.2));
    }

    public void setRandomSellingPrice(){
        this.setSellingPrice(this.generateSellingPrice());
    }
}
