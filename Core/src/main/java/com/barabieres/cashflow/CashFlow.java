package com.barabieres.cashflow;

import java.util.Random;

// ICH 30/12/20 Classe permettant de gérer la trésorerie
// J'ai décidé de créer cette classe pour faciliter le changement de gestion de trésorerie si on a d'autres idées
public class CashFlow {

    private double value;

    public CashFlow(double value) {
        this.value = value;
    }

    public CashFlow(double rangeMin, double rangeMax) {
        Random randomStartValue = new Random();
        this.value = rangeMin + (rangeMax - rangeMin) * randomStartValue.nextDouble();
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    /**
     * augmente la trésorerie du nombre passé en paramètre
     *
     * @param quantity
     */
    public void increaseCashFlow(double quantity) {
        this.value += quantity;
    }

    /**
     * diminue la trésorerie du nombre passé en paramètre
     *
     * @param quantity
     */
    public void decreaseCashFlow(double quantity) {
        this.value -= quantity;
        if(this.value < 0) {
            value = 0;
        }
    }
}