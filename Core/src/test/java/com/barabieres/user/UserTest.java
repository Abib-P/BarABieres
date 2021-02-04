package com.barabieres.user;

import com.barabieres.bar.BarSizes;
import com.barabieres.inventory.InventorySizes;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    void should_create_user_with_name() {
        String name = "ELU";
        User user = new User(name, InventorySizes.small, BarSizes.small);

        assertThat(user.getName()).isEqualTo(name);
    }
}