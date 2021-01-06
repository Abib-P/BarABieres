package com.barabieres.user;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {


    @Test
    void should_create_user_with_name() {
        String name = "ELU";
        User user = new User(name, 100);

        assertThat(user.getName()).isEqualTo(name);
    }
  /*  @Test
    void should_create_user_with_name_and_inventory() {
        String name = "ELU";
        Inventory inventory = new inventory();
        User user = new User(name,stock);

        assertThat(user.getName()).isEqualTo(name);
    }*/
}