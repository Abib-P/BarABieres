package com.barabieres.bar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BarTest {

    Bar bar;

    @BeforeEach
    void setup() {
        bar = new Bar(100);
    }

    @Test
    public void should_get_and_set_gain_of_the_day() {
        bar.increaseGainOfTheDay(150.26);

        assertEquals(bar.getGainOfTheDay(), 150.26);
    }

    @Test
    public void should_get_bonus_is_activate() {
        assertFalse(bar.getBonusIsActivate());
    }

    @Test
    public void should_get_malus_is_activate() {
        assertFalse(bar.getMalusIsActivate());
    }

    @Test
    public void should_increase_gain_of_the_day() {
        bar.increaseGainOfTheDay(150);

        assertEquals(bar.getGainOfTheDay(), 150);
    }

    @Test
    public void should_increase_size() {
        bar.increaseSize(20);

        assertEquals(bar.getSize(), 120);
    }

    @Test
    void should_generate_randomly_nb_of_clients_for_the_day() {
        Assertions.assertTrue(bar.generateRandomlyNbOfClientsForTheDay() >= 80);
        Assertions.assertTrue(bar.generateRandomlyNbOfClientsForTheDay() <= 120);
    }

}
