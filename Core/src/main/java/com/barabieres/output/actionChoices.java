package com.barabieres.output;

public enum actionChoices {
    buy("Buy beers"),
    //sellPrices("Modify selling prices"),
    hard("Show Inventory"),
    display("Start Selling"),
    give_up("Give up");

    private final String name;
    actionChoices(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override public String toString() { return getName(); }
}
