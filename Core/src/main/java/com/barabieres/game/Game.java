package com.barabieres.game;

public class Game {

    private double tresorery;
    private int score;
    private final int winAt;
    private final int gameOverAt;
    private double gainOfTheDay;
    private int turn;

    public Game(double tresorery, int winAt, int gameOverAt) {
        this.tresorery = tresorery;
        this.winAt = winAt;
        this.score = 0;
        this.gameOverAt = gameOverAt;
        this.turn = 0;
        this.gainOfTheDay = 0;
    }

    public double getTresorery() {
        return tresorery;
    }

    //augmente la trésorerie du nombre rentré en paramètre
    public void increaseTresorery(double nbAdd) {
        this.setTresorery(this.getTresorery() + nbAdd);
    }

    //diminue la trésorerie du nombre rentré en paramètre
    public void decreaseTresorery(double nbDel) {
        this.setTresorery(this.getTresorery() - nbDel);
    }

    public void setTresorery(double tresorery) {
        this.tresorery = tresorery;
    }

    public int getScore() {
        return score;
    }

    /**
     * Score max 10 000
     * A chaque tour qui passe le score perd son score max divisé par son nombre de tour max (décroissance proportionnelle)
     */
    public void setScore() {
        this.score = 10000 - (10000 / gameOverAt) * turn;
    }

    public int getWinAt() {
        return this.winAt;
    }

    public int getGameOverAt() {
        return gameOverAt;
    }

    public int getTurn() {
        return turn;
    }

    public void nextTurn() {
        this.turn += 1;
    }

    public double getGainOfTheDay() {
        return this.gainOfTheDay;
    }

    public void setGainOfTheDay(double gainOfTheDay) {
        this.gainOfTheDay = gainOfTheDay;
    }

    /**
     * augmente le gain du jour avec le gain passé en paramètre
     *
     * @param gain
     */
    public void increaseGainOfTheDay(double gain) {
        this.setGainOfTheDay(this.getGainOfTheDay() + gain);
    }

    /**
     * met le gain du jour (de la veille car lancé en début de tour suivant) dans la trésorerie et repasse
     * les gains du jour à 0
     */
    public void putGainOfTheDayOnTresorery() {
        this.tresorery += gainOfTheDay;
        this.gainOfTheDay = 0;
    }
}
