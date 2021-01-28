package com.barabieres.bar;

public class Bar {

    private BarSizes currentSize;
    private double gainOfTheDay;

    public Bar(BarSizes size) {
        this.currentSize = size;
        gainOfTheDay = 0;
    }


    public BarSizes getSize() {
        return this.currentSize;
    }

    public void setSize(BarSizes size) {
        this.currentSize = size;
    }

    public double getGainOfTheDay() {
        return this.gainOfTheDay;
    }

    /**
     * augmente le gain du jour avec le gain passé en paramètre
     *
     * @param gain
     */
    public void increaseGainOfTheDay(double gain) {
        this.setGainOfTheDay(this.getGainOfTheDay() + gain);
    }

    public void setGainOfTheDay(double gainOfTheDay) {
        this.gainOfTheDay = gainOfTheDay;
    }

    /**
     * augmente la taille du bar
     */
    public boolean upgrade() {
        if (getSize() == BarSizes.small) {
            setSize(BarSizes.average);
            return true;
        } else if (getSize() == BarSizes.average) {
            setSize(BarSizes.big);
            return true;
        }
        return false;
    }

    /**
     * génère le nombre de clients du jour entre la taille du bar - 20% et la taille du bar + 20%
     *
     * @return
     */
    public int generateRandomlyNbOfClientsForTheDay() {
        return (int) ((this.getSize().getSize() * 0.8) + Math.round(Math.random() * (this.getSize().getSize() * 0.4)));
    }

}
