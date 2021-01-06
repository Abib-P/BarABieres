package com.barabieres.user;

import com.barabieres.inventory.Inventory;

public class User {
  
    private final String name;
    private Inventory inventory;

    public User(String name, int sizeMaxOfInventory) {
        this.name = name;
        this.inventory = new Inventory(sizeMaxOfInventory);
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
}
