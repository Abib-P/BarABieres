package com.barabieres.inventory;

import com.barabieres.Item.Beer;
import com.barabieres.cashflow.CashFlow;
import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private CashFlow cashFlow;
    private List<Stock> stocks;
    private int sizeMaxOfInventory;

    public Inventory(int sizeMaxOfInventory) {
        this.stocks = this.setStocks();
        this.cashFlow = new CashFlow(100.00,1000.00);
        this.sizeMaxOfInventory = sizeMaxOfInventory;
    }

    public Inventory(List<Stock> stocks) {
        this.stocks = stocks;
    }

    /**
     * fonction permettant d'initialiser les stocks à 0 pour chaque type de bière
     *
     * @return
     */
    public ArrayList<Stock> setStocks() {
        ArrayList<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock(new Beer("Fruits rouges", 7, 5)));
        return stocks;
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
        this.stocks.add(stock);
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
            this.stocks.get(indexOfBeer).setQuantity(this.stocks.get(indexOfBeer).getQuantity() - quantity);
        }
    }

    /**
     * augmente le stock de la bière passée en paramètre
     * on augmente la quantité passée en paramètre à la quantité actuellement en stock
     * @param indexOfBeer
     * @param quantity
     */
    public void increaseStock(int indexOfBeer, int quantity) {
        if (indexOfBeer < this.stocks.size()) {
            this.stocks.get(indexOfBeer).setQuantity(this.stocks.get(indexOfBeer).getQuantity() + quantity);
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
        return this.sizeMaxOfInventory;
    }

    public void setSizeMaxOfInventory(int sizeMaxOfInventory) {
        this.sizeMaxOfInventory = sizeMaxOfInventory;
    }

    public void upgradeSizeOfInventory(int sizeAdded) {
        this.sizeMaxOfInventory = this.sizeMaxOfInventory + sizeAdded;
    }

    public int getNumberOfPlacesInTheInventory() {
        int nbPlaces = sizeMaxOfInventory;
        for(Stock stock : this.stocks) {
            nbPlaces -= stock.getQuantity();
        }
        return nbPlaces;
    }

    /**
     * Change le prix de vente de toutes les bières de l'inventaire
     */
    public void modifyRandomlySellingPriceOfAllBeers() {
        for(Stock stock : this.stocks) {
            stock.getBeer().setSellingPrice(stock.getBeer().generateSellingPrice());
        }
    }
}
