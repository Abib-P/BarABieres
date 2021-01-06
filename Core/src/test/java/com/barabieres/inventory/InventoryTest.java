package com.barabieres.inventory;
import com.barabieres.Item.Beer;
import com.barabieres.cashflow.CashFlow;
import com.barabieres.user.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class InventoryTest {

    Inventory inventory = new Inventory(100);
    Stock stock = new Stock(new Beer("Blonde", 7, 5));

    @Test
    void should_create_inventory_with_empty_list_items_and_set_cashFlow() {

        Inventory inventory = new Inventory(100);

        assertThat(inventory).isNotNull();
        assertThat(inventory.getCashFlow().getValue()).isNotNull();
        assertThat(inventory.getStocks()).isNotNull();
    }

    @Test
    void should_increase_quantity() {
        stock.increaseQuantity(10);
        assertEquals(10, stock.getQuantity());
    }

    @Test
    void should_decrease_quantity() {
        stock.increaseQuantity(10);
        stock.decreaseQuantity(5);
        assertEquals(5, stock.getQuantity());
    }

    @Test
    void should_increase_stock() {
        inventory.increaseStock(0, 10);
        assertEquals(10, inventory.getStocks().get(0).getQuantity());
    }

    @Test
    void should_decrease_stock() {
        inventory.increaseStock(0, 10);
        inventory.decreaseStock(0, 5);
        assertEquals(5, inventory.getStocks().get(0).getQuantity());
    }

    @Test
    void should_get_stock_of() {
        inventory.increaseStock(0, 90);
        assertEquals(90, inventory.getStockOf(0));
    }

    @Test
    void should_upgrade_size_of_inventory() {
        inventory.upgradeSizeOfInventory(20);
        assertEquals(120, inventory.getSizeMaxOfInventory());
    }

    @Test
    void should_get_number_of_places_in_the_inventory() {
        inventory.increaseStock(0, 90);
        assertEquals(10, inventory.getNumberOfPlacesInTheInventory());
    }
}