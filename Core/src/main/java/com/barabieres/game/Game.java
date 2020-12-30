package com.barabieres.game;

public class Game {

    private double tresorery;
    private int score;
    private int winAt;

    public Game(double tresorery, int winAt) {
        this.tresorery = tresorery;
        this.winAt = winAt;
        this.score = 0;
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

    //augmente le score du nombre de points passés en paramètres
    public void inscreaseScore(int nbPointsAdd) {
        this.setScore(this.getScore() + nbPointsAdd);
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getWinAt() {
        return this.winAt;
    }
}
