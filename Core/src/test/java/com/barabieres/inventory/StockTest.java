package com.barabieres.inventory;

import com.barabieres.item.Beer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StockTest {

    @Test
    void should_update_quantity_of_a_stock() {
        Beer beer = new Beer("beer n 1", 1500, 67);
        Stock stock = new Stock(beer, 0);
        stock.setQuantity(120);
        assertThat(stock.getQuantity()).isEqualTo(120);
    }

    @Test
    void should_increase_quantity_of_a_stock() {
        Beer beer = new Beer("beer n 1", 1500, 67);
        Stock stock = new Stock(beer, 120);
        stock.increaseQuantity(120);
        assertThat(stock.getQuantity()).isEqualTo(240);
    }

    @Test
    void should_decrease_quantity_of_a_stock() {
        Beer beer = new Beer("beer n 1", 1500, 67);
        Stock stock = new Stock(beer, 240);
        stock.decreaseQuantity(120);
        assertThat(stock.getQuantity()).isEqualTo(120);
    }
}