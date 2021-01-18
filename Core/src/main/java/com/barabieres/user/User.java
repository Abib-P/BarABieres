package com.barabieres.user;

import com.barabieres.bar.Bar;
import com.barabieres.cashflow.CashFlow;
import com.barabieres.inventory.Inventory;
import com.barabieres.inventory.Sizes;

public class User {
  
    private final String name;
    private Inventory inventory;
    private Bar bar;

    public User(String name, Sizes sizeofInventory,Sizes sizeofBar) {
        this.name = name;
        this.inventory = new Inventory(sizeofInventory);
        this.bar = new Bar(Sizes.small);
    }

    public String getName() {
        return name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Bar getBar() {
        return bar;
    }
    public void setGainOfTheDay(){
        // Ajoute le cashflow à jour
        double updatedAmount = this.inventory.getCashFlow().getValue() + this.bar.getGainOfTheDay();
        CashFlow updatedCashFlow = new CashFlow(updatedAmount);
        this.inventory.setCashFlow(updatedCashFlow);
        // met le gainOfTheDay A 0 car cette méthode est activée à la fin du tour
        this.bar.setGainOfTheDay(0.00);
    }
}
