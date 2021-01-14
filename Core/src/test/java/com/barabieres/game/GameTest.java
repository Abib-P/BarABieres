package com.barabieres.game;

import com.barabieres.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game;

    @BeforeEach
    void setup() {
        game = new Game(300, 25, new User("Théo", 100));
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
    public void should_get_user() {
        assertEquals("Théo", game.getUser().getName());
    }

    @Test
    public void should_success_buy_beer() {
        game.getUser().getInventory().increaseStock(0, 20);
        assertTrue(game.buyBeer(0, 10));
    }

    @Test
    public void should_success_buy_beer_but_not_all_quantity() {
        game.getUser().getInventory().increaseStock(0, 90);
        assertTrue(game.buyBeer(0, 20));
    }

    @Test
    public void should_not_success_buy_beer_because_dont_have_space() {
        game.getUser().getInventory().increaseStock(0, 100);
        assertFalse(game.buyBeer(0, 10));
    }

    @Test
    public void should_not_success_buy_beer_because_dont_have_tresorery() {
        game.getUser().getInventory().increaseStock(0, 10);
        game.getUser().getInventory().getCashFlow().decreaseCashFlow(2000);
        assertFalse(game.buyBeer(0, 10));
    }
}