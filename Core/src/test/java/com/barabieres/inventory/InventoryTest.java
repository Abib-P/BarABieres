package com.barabieres.inventory;

import com.barabieres.item.Beer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InventoryTest {

    Inventory inventory;
    Stock stock;

    @BeforeEach
    void setup() {
        inventory = new Inventory(InventorySizes.small);
        stock = new Stock(new Beer("Fruits rouges", 7, 5));
        inventory.addStock(stock);
    }

    @Test
    void should_create_inventory_with_empty_list_items_and_set_cashFlow() {
        assertThat(inventory).isNotNull();
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
        inventory.upgrade(InventorySizes.average);
        assertEquals(20, inventory.getSizeMaxOfInventory());
    }

    @Test
    void should_get_number_of_places_in_the_inventory() {
        inventory.addStock(stock);
        assertEquals(8, inventory.getNumberOfPlacesInTheInventory());
    }

    @Test
    void should_modify_randomly_selling_price_of_all_beers() {
        inventory.modifyRandomlySellingPriceOfAllBeers();
        Assertions.assertTrue(inventory.getStocks().get(0).getBeer().getSellingPrice() >= 7);
        Assertions.assertTrue(inventory.getStocks().get(0).getBeer().getSellingPrice() <=
                stock.getBeer().getSellingPrice() * 1.2);
    }
}