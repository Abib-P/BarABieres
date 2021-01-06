package com.barabieres.game;

import com.barabieres.user.User;

public class Game {

    private double tresorery;
    private int score;
    private final int winAt;
    private final int gameOverAt;
    private double gainOfTheDay;
    private int turn;
    private User user;

    public Game(double tresorery, int winAt, int gameOverAt, User user) {
        this.tresorery = tresorery;
        this.winAt = winAt;
        this.score = 0;
        this.gameOverAt = gameOverAt;
        this.turn = 0;
        this.gainOfTheDay = 0;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Vérifie qu'il reste assez de place dans l'inventaire et assez d'argent pour acheter des bières
     * puis augmente l'inventaire et diminue la trésorerie avec le prix d'achat de base des bières
     * (pas le prix de vente qui peut bouger)
     *
     * @param indexOfBeer
     * @param quantity
     * @return
     */
    public boolean buyBeer(int indexOfBeer, int quantity) {
        boolean saleWentWell = true;
        //vérification que la taille de l'inventaire et la trésorerie sont suffisantes
        if (this.stillHaveEnoughtSpaceInTheInventory(quantity) &&
                stillHaveEnoughtCashflowInTheInventory(indexOfBeer, quantity)) {
            //augmentation de la quantité en stock
            this.user.getInventory().increaseStock(indexOfBeer, quantity);
            //diminution de la trésorerie avec le prix d'achat de la bière
            this.user.getInventory().getCashFlow().decreaseCashFlow(quantity * this.getUser().
                    getInventory().getStocks().get(indexOfBeer).getBeer().getValue());
        }
        // sinon s'il reste un peu de place et de trésorerie on en achète le plus possible
        else if (stillHaveSpaceInTheInventory() &&
                stillHaveCashflowInTheInventory(indexOfBeer)) {
            int possibleQuantity = getMaxQuantityBuyable(indexOfBeer, quantity);
            //on achète plus de bière possibles avec le stock et la trésorerie
            this.user.getInventory().increaseStock(indexOfBeer, possibleQuantity);
            //on diminue la trésorerie du nombre de bières qu'on a pu acheter
            this.user.getInventory().getCashFlow().decreaseCashFlow(possibleQuantity * this.getUser().
                    getInventory().getStocks().get(indexOfBeer).getBeer().getSellingPrice());
        } else {
            saleWentWell = false;
        }
        return saleWentWell;
    }

    /**
     * vérifie qu'il reste assez de stock pour vendre la bière demandée
     * s'il n'y a pas assez pour la quantité demandée, on vend le maximum possible par rapport à ce qu'il
     * reste en stock
     *
     * @param indexOfBeer
     * @param quantity
     * @return
     */
    public boolean sellBeer(int indexOfBeer, int quantity) {
        boolean couldSellAtLeast1 = true;
        //vérification que la quantité en stock est suffisante
        if (stillHaveEnoughtStockForThisBeer(indexOfBeer, quantity)) {
            //on décroit la quantité de bières vendues
            this.user.getInventory().decreaseStock(indexOfBeer, quantity);
            //on augmente la trésorerie
            this.user.getInventory().getCashFlow().increaseCashFlow(quantity * this.getUser().
                    getInventory().getStocks().get(indexOfBeer).getBeer().getSellingPrice());
        }
        // s'il n'y a pas de stock on en vend le plus possible
        else if (stillHaveStockForThisBeer(indexOfBeer)) {
            int remainingQuantity = this.user.getInventory().getStockOf(indexOfBeer);
            //on vend tout le reste du stock de la bière
            this.user.getInventory().decreaseStock(indexOfBeer, remainingQuantity);
            //on augmente la trésorerie du nombre de bières qu'on a pu vendre
            this.user.getInventory().getCashFlow().increaseCashFlow(remainingQuantity * this.getUser().
                    getInventory().getStocks().get(indexOfBeer).getBeer().getSellingPrice());
        } else {
            couldSellAtLeast1 = false;
        }
        return couldSellAtLeast1;
    }

    public boolean stillHaveEnoughtSpaceInTheInventory(int quantity) {
        return this.user.getInventory().getNumberOfPlacesInTheInventory() - quantity >= 0;
    }

    public boolean stillHaveEnoughtCashflowInTheInventory(int indexOfBeer, int quantity) {
        return this.user.getInventory().getCashFlow().getValue() - quantity * this.getUser().
                getInventory().getStocks().get(indexOfBeer).getBeer().getSellingPrice() >= 0;
    }

    public boolean stillHaveSpaceInTheInventory() {
        return this.user.getInventory().getNumberOfPlacesInTheInventory() > 0;
    }

    /**
     * retourne true que s'il reste assez d'argent pour payer au moins une bière
     *
     * @param indexOfBeer
     * @return
     */
    public boolean stillHaveCashflowInTheInventory(int indexOfBeer) {
        return this.user.getInventory().getCashFlow().getValue() - this.getUser().
                getInventory().getStocks().get(indexOfBeer).getBeer().getSellingPrice() > 0;
    }

    public boolean stillHaveEnoughtStockForThisBeer(int indexOfBeer, int quantity) {
        return user.getInventory().getStockOf(indexOfBeer) - quantity >= 0;
    }

    public boolean stillHaveStockForThisBeer(int indexOfBeer) {
        return user.getInventory().getStockOf(indexOfBeer) > 0;
    }

    public int getMaxQuantityBuyable(int indexOfBeer, int quantity) {
        int maxQuantityBuyable = 0;
        double tresorery = this.user.getInventory().getCashFlow().getValue();
        int nbPlaces = this.user.getInventory().getNumberOfPlacesInTheInventory();
        // tant qu'il reste de la place en inventaire et assez d'argent pour acheter une
        // bière et que la quantité souhaitée n'est pas atteinte
        while (tresorery > this.user.getInventory().getStocks().get(indexOfBeer).getBeer().getValue() &&
                nbPlaces > 0 && maxQuantityBuyable < quantity) {
            maxQuantityBuyable += 1;
            nbPlaces -= 1;
        }
        return maxQuantityBuyable;
    }
}
