package com.barabieres.bar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BarTest {

    Bar bar;

    @BeforeEach
    void setup() {
        bar = new Bar(50);
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
        bar.increaseSize(50);

        assertEquals(bar.getSize(), 100);
    }

}
