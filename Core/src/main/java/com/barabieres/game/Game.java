package com.barabieres.game;

import com.barabieres.cashflow.CashFlow;

public class Game {
    private CashFlow goalAmount;

    public Game() {
        this.goalAmount = new CashFlow(0.00);
    }
    public Game(CashFlow goalAmount) {
        this.goalAmount = goalAmount;
    }
    public CashFlow getGoalAmount() {
        return goalAmount;
    }
    public void setGoalAmount(CashFlow goalAmount) {
        this.goalAmount = goalAmount;
    }

}
