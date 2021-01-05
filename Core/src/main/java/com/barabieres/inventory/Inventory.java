package com.barabieres.inventory;

import com.barabieres.Item.Item;
import com.barabieres.cashflow.CashFlow;
import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private CashFlow cashFlow;
    private List<Stock> stocks;

    public Inventory() {
        this.stocks = new ArrayList<>();
        this.cashFlow = new CashFlow(100.00,1000.00);
    }

    public Inventory(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public CashFlow getCashFlow() {
        return cashFlow;
    }

    public void setCashFlow(CashFlow cashFlow) {
        this.cashFlow = cashFlow;
    }


    public void setItems(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public void addItem(Stock stock) {
        this.stocks.add(stock);
    }

    public List<Stock> getItems() {
        return this.stocks;
    }
}
