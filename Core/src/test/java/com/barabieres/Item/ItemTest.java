package com.barabieres.Item;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemTest {

    @Test
    void should_create_item_with_name_and_value() {
        String name = "PunkàChien";
        Double value = 8.6;
        Item huitsix = new Item(name,value);

        assertThat(huitsix.getName()).isEqualTo(name);
        assertThat(huitsix.getValue()).isEqualTo(value);
    }
}
