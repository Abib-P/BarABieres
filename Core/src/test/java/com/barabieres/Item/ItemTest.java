package com.barabieres.Item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {

    Beer beer;

    @BeforeEach
    void setup() {
        beer = new Beer("Bière blonde", 5.5, 4.5);
    }

    @Test
    void should_create_item_with_name_and_value() {
        String name = "PunkàChien";
        Double value = 8.6;
        Item huitsix = new Item(name, value);

        assertThat(huitsix.getName()).isEqualTo(name);
        assertThat(huitsix.getValue()).isEqualTo(value);
    }

    @Test
    void should_get_selling_price() {
        assertEquals(beer.getSellingPrice(), 5.5);
    }

    @Test
    void should_set_selling_price() {
        beer.setSellingPrice(7);

        assertEquals(beer.getSellingPrice(), 7);
    }

    @Test
    void should_get_alcohol_by_volume() {
        assertEquals(beer.getAlcoholByVolume(), 4.5);
    }
}