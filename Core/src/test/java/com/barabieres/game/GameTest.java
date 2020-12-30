package com.barabieres.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    Game game = new Game(2000);

    @Test
    public void should_increase_tresorery() {
        game.increaseTresorery(10);

        assertEquals(game.getTresorery(), 2010);
    }


    @Test
    public void should_decrease_tresorery() {
        game.decreaseTresorery(10);

        assertEquals(game.getTresorery(), 1990);
    }

}