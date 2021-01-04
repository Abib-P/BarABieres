package com.barabieres.game;

public class Game {

    private double tresorery;
    private final int winAt;

    public Game(double tresorery, int winAt) {
        this.tresorery = tresorery;
        this.winAt = winAt;
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

    public int getWinAt() {
        return this.winAt;
    }
}
