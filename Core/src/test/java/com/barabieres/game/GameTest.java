package com.barabieres.game;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    Game game = new Game(2000, 300);

    @Test
    public void should_get_tresorery() {

        assertEquals(game.getTresorery(), 2000);
    }

    @Test
    public void should_set_tresorery() {
        game.setTresorery(1000);

        assertEquals(game.getTresorery(), 1000);
    }

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

    @Test
    public void should_get_score() {
        assertEquals(game.getScore(), 0);
    }

    @Test
    public void should_set_score() {
        game.setScore(100);

        assertEquals(game.getScore(), 100);
    }

    @Test
    public void should_increase_score() {
        game.inscreaseScore(150);

        assertEquals(game.getScore(), 150);
    }

    @Test
    public void should_get_win_at() {
        assertEquals(game.getWinAt(), 300);
    }

}