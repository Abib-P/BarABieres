package com.barabieres.bar;

import com.barabieres.inventory.Sizes;
import com.barabieres.inventory.Stock;

import java.util.Arrays;
import java.util.List;

public class Bar {

    private int currentSize;
    private List<Stock> stocks;
    private boolean bonusIsActivate;
    private boolean malusIsActivate;
    private double gainOfTheDay;

    public Bar(Sizes size) {
        this.currentSize = 0;
        this.stocks = initStocks(size);
        this.gainOfTheDay = 0;
        this.bonusIsActivate = false;
        this.bonusIsActivate = false;
    }


    public int getSize() {
        return this.currentSize;
    }

    public void setSize(int size) {
        this.currentSize = size;
    }

    public double getGainOfTheDay() {
        return this.gainOfTheDay;
    }

    public void setGainOfTheDay(double gainOfTheDay) {
        this.gainOfTheDay = gainOfTheDay;
    }

    public boolean getBonusIsActivate() {
        return this.bonusIsActivate;
    }

    public boolean getMalusIsActivate() {
        return this.malusIsActivate;
    }

    public List<Stock> initStocks(Sizes size) {
        List<Stock> fixedStock = Arrays.asList(new Stock[size.getSize()]);
        return fixedStock;
    }
    /**
     * augmente la taille du bar de la taille passée en paramètre
     *
     * @param size
     */
    public void upgrade(Sizes size) {

        int indexOfStock = 0;
        List<Stock> upgradedStock = Arrays.asList(new Stock[size.getSize()]);
        for (Stock stock : stocks) {
            upgradedStock.set(indexOfStock, stock);
            indexOfStock += 1;
        }
        this.stocks = upgradedStock;
    }

      //  this.setSize(this.getSize() + nbAdd);


    /**
     * augmente le gain du jour avec le gain passé en paramètre
     *
     * @param gain
     */
    public void increaseGainOfTheDay(double gain) {
        this.setGainOfTheDay(this.getGainOfTheDay() + gain);
    }

    /**
     * génère deux entiers entre 0 et 100 de façon aléatoire, s'ils sont égaux,
     * un bonus qui divise les prix de vente par deux est activé sur un tour
     */
    public void generateBonus() {
        int a = (int) Math.round(Math.random() * 100);
        int b = (int) Math.round(Math.random() * 100);
        this.bonusIsActivate = a == b;
    }

    /**
     * génère deux entiers entre 0 et 100 de façon aléatoire, s'ils sont égaux,
     * un malus qui divise les prix de vente par deux est activé sur un tour
     */
    public void generateMalus() {
        int a = (int) Math.round(Math.random() * 100);
        int b = (int) Math.round(Math.random() * 100);
        this.malusIsActivate = a == b;
    }

    /**
     * génère le nombre de clients du jour entre la taille du bar - 20% et la taille du bar + 20%
     * @return
     */
    public int generateRandomlyNbOfClientsForTheDay() {
        return (int) ((this.getMaxSize() * 0.8) + Math.round(Math.random() * (this.getMaxSize() * 0.4)));
    }
    public int getMaxSize(){
        return this.stocks.size();
    }

}
