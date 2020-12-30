package com.barabieres.inventory;
import com.barabieres.cashflow.CashFlow;
import com.barabieres.user.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InventoryTest {
    @Test
    void should_create_inventory_with_empty_list_items_and_set_cashFlow() {

        Inventory inventory = new Inventory();

        assertThat(inventory).isNotNull();
        assertThat(inventory.getCashFlow().getValue()).isNotNull();
        assertThat(inventory.getItems()).isNotNull();
    }
}