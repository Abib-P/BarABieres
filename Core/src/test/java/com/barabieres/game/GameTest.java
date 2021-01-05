package com.barabieres.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {


    Game game = new Game(2000, 300, 25);

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
        game.setScore();

        assertEquals(game.getScore(), 10000);
    }

    //score au bout de 5 tours
    @Test
    public void should_set_score_with_turn() {
        for(int i = 0 ; i < 5 ; i += 1) {
            game.nextTurn();
        }
        game.setScore();

        assertEquals(game.getScore(), 8000);
    }

    @Test
    public void should_get_win_at() {
        assertEquals(game.getWinAt(), 300);
    }

    @Test
    public void should_get_game_over_at() {
        assertEquals(game.getGameOverAt(), 25);
    }

    @Test
    public void should_get_turn() {
        for(int i = 0 ; i < 15 ; i += 1) {
            game.nextTurn();
        }
        assertEquals(game.getTurn(), 15);
    }

    @Test
    public void should_get_and_set_gain_of_the_day() {
        game.increaseGainOfTheDay(150.26);

        assertEquals(game.getGainOfTheDay(), 150.26);
    }

    @Test
    public void should_increase_gain_of_the_day() {
        game.increaseGainOfTheDay(150.26);
        game.decreaseTresorery(1000);
        game.putGainOfTheDayOnTresorery();

        assertEquals(game.getTresorery(), 1150.26);
    }
}