package com.barabieres.user;

import com.barabieres.bar.Bar;
import com.barabieres.bar.BarSizes;
import com.barabieres.cashflow.CashFlow;
import com.barabieres.input.Input;
import com.barabieres.inventory.Inventory;
import com.barabieres.inventory.InventorySizes;
import com.barabieres.output.Output;

import java.util.Random;

public class User {

    private final String name;
    private Inventory inventory;
    private final Bar bar;

    public User(String name, InventorySizes sizeofInventory, BarSizes sizeofBar) {
        this.name = name;
        this.inventory = new Inventory(sizeofInventory);
        this.bar = new Bar(sizeofBar);
    }

    public User(Output output, Input input) {
        this.name = output.askUserName(input);
        this.inventory = new Inventory(InventorySizes.small);
        this.bar = new Bar(BarSizes.small);
    }

    private Double generateInitialMoney(Double rangeMin, Double rangeMax) {
        Random randomStartValue = new Random();
        return rangeMin + (rangeMax - rangeMin) * randomStartValue.nextDouble();
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

    public void setGainOfTheDay() {
        // Ajoute le cashflow à jour
        double updatedAmount = this.inventory.getCashFlow().getValue() + this.bar.getGainOfTheDay();
        CashFlow updatedCashFlow = new CashFlow(updatedAmount);
        this.inventory.setCashFlow(updatedCashFlow);
        // met le gainOfTheDay A 0 car cette méthode est activée à la fin du tour
        this.bar.setGainOfTheDay(0.00);
    }
}
