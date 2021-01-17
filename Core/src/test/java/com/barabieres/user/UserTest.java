package com.barabieres.user;

import com.barabieres.inventory.Sizes;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    void should_create_user_with_name() {
        String name = "ELU";
        User user = new User(name, Sizes.small,Sizes.small);

        assertThat(user.getName()).isEqualTo(name);
    }
}