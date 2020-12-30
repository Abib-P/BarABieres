package com.barabieres.inventory;

import com.barabieres.Item.Item;
import com.barabieres.cashflow.CashFlow;
import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private CashFlow cashFlow;
    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
        this.cashFlow = new CashFlow(100.00,1000.00);
    }

    public Inventory(List<Item> items) {
        this.items = items;
    }

    public CashFlow getCashFlow() {
        return cashFlow;
    }

    public void setCashFlow(CashFlow cashFlow) {
        this.cashFlow = cashFlow;
    }


    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public List<Item> getItems() {
        return this.items;
    }
}
