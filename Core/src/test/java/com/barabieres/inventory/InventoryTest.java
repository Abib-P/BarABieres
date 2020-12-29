package com.barabieres.inventory;
import com.barabieres.user.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InventoryTest {
    @Test
    void should_create_inventory_empty() {

        Inventory inventory = new Inventory();

        assertThat(inventory).isNotNull();
    }
}