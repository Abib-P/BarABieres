package com.barabieres.inventory;
import com.barabieres.Item.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {


    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public Inventory(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public List<Item> getItems() {
        return this.items;
    }
}
