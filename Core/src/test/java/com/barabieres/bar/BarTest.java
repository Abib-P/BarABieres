package com.barabieres.bar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BarTest {

    Bar bar;

    @BeforeEach
    void setup() {
        bar = new Bar(BarSizes.small);
    }

    @Test
    public void should_increase_size() {
        bar.upgrade();

        assertEquals(bar.getSize().getSize(), 150);
    }

    @Test
    void should_generate_randomly_nb_of_clients_for_the_day() {
        int numberOfClient = bar.generateRandomlyNbOfClientsForTheDay();
        assertTrue(numberOfClient >= 55);
        assertTrue(numberOfClient <= 95);
    }

    @Test
    void should_increase_gain_of_the_day_when_money_is_gained() {
        bar.increaseGainOfTheDay(2000);
        assertThat(bar.getGainOfTheDay()).isCloseTo(2000, offset(20.));
    }

    @Test
    void should_increase_gain_of_the_day_when_gain_of_the_day_is_set() {
        bar.setGainOfTheDay(2000);
        bar.increaseGainOfTheDay(2000);
        assertThat(bar.getGainOfTheDay()).isCloseTo(4000, offset(20.));
    }
}
