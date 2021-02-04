package com.barabieres.customer;

import com.barabieres.inventory.Stock;
import com.barabieres.item.Beer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class CustomerTest {
    Customer customer;

    @Test
    void should_not_buy_beer_when_customer_dont_has_enough_money() {
        customer = new Customer(2, 2, 2);
        List<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock(new Beer("Beer 1", 8, 2), 20));

        customer.chooseBeersToBuy(stocks);

        assertThat(customer.getMoneyToSpend()).isCloseTo(2, offset(0.2));
    }

    @Test
    void should_buy_beer_with_abv_of_2_when_customer_like_is_1_with_acceptance_of_2() {
        customer = new Customer(4, 1, 2);
        List<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock(new Beer("Beer 1", 4, 2), 3));

        customer.chooseBeersToBuy(stocks);

        assertThat(customer.getMoneyToSpend()).isCloseTo(0, offset(1.));
        assertThat(stocks.get(0).getQuantity()).isEqualTo(2);
    }
}