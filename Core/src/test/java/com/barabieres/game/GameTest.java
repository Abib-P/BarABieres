package com.barabieres.game;
import com.barabieres.cashflow.CashFlow;
import com.barabieres.inventory.Inventory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
class GameTest {

    @Test
    void should_create_game_empty() {

        Game game = new Game();

        assertThat(game).isNotNull();
    }
    @Test
    void should_create_game_with_goal_amount() {
        CashFlow cashFlow = new CashFlow(50.00);
        Game game = new Game(cashFlow);

        assertThat(game.getGoalAmount().getValue()).isEqualTo(50.00);
    }
}