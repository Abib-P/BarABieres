package com.barabieres.inventory;

import com.barabieres.Item.Beer;
import com.barabieres.cashflow.CashFlow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inventory {

    private CashFlow cashFlow;
    private List<Stock> stocks;
    private int currentSize; // nombre de lignes de stock dans la liste de stock

    public Inventory(Sizes size) {
        this.stocks = this.initStocks(size);
        this.cashFlow = new CashFlow(100.00, 1000.00);
    }

    public Inventory(List<Stock> stocks) {
        this.stocks = stocks;
    }

    /**
     * fonction permettant d'initialiser les stocks à 0 pour chaque type de bière
     *
     * @return
     */
    public List<Stock> initStocks(Sizes size) {
        List<Stock> fixedStock = Arrays.asList(new Stock[size.getSize()]);
        return fixedStock;
    }

    public CashFlow getCashFlow() {
        return cashFlow;
    }

    public void setCashFlow(CashFlow cashFlow) {
        this.cashFlow = cashFlow;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public void addStock(Stock stock) {
        if (currentSize != stocks.size()) {
            this.stocks.set(currentSize, stock);
            currentSize += 1;
        }
    }

    public List<Stock> getStocks() {
        return this.stocks;
    }

    /**
     * décroit le stock de la bière passée en paramètre
     * on soustrait la quantité passée en paramètre de la quantité actuellement en stock
     *
     * @param indexOfBeer
     * @param quantity
     */
    public void decreaseStock(int indexOfBeer, int quantity) {
        if (indexOfBeer < this.stocks.size()) {
            this.stocks.get(indexOfBeer).decreaseQuantity(quantity);
        }
    }

    /**
     * augmente le stock de la bière passée en paramètre
     * on augmente la quantité passée en paramètre à la quantité actuellement en stock
     *
     * @param indexOfBeer
     * @param quantity
     */
    public void increaseStock(int indexOfBeer, int quantity) {
        if (indexOfBeer < this.stocks.size()) {
            this.stocks.get(indexOfBeer).increaseQuantity(quantity);
        }
    }

    /**
     * retourne la quantité en stock de la bière passée en paramètre
     *
     * @param indexOfBeer
     * @return
     */
    public int getStockOf(int indexOfBeer) {
        return stocks.get(indexOfBeer).getQuantity();
    }

    public int getSizeMaxOfInventory() {
        return this.stocks.size();
    }

    public void upgrade(Sizes size) {
        int indexOfStock = 0;
        List<Stock> upgradedStock = Arrays.asList(new Stock[size.getSize()]);
        for (Stock stock : stocks) {
            upgradedStock.set(indexOfStock, stock);
            indexOfStock += 1;
        }
        this.stocks = upgradedStock;
    }

    public int getNumberOfPlacesInTheInventory() {
  /*      int nbPlaces = stocks.size();
        for (Stock stock : this.stocks) {
            nbPlaces -= stock.getQuantity();
        }*/
        return stocks.size()-currentSize;
    }

    /**
     * Change le prix de vente de toutes les bières de l'inventaire
     */
    public void modifyRandomlySellingPriceOfAllBeers() {
        for (Stock stock : this.stocks) {
            if (stock != null)
            stock.getBeer().setRandomSellingPrice();
        }
    }
}
