package com.barabieres.game;

import com.barabieres.customer.Customer;
import com.barabieres.input.Input;
import com.barabieres.output.Output;
import com.barabieres.user.User;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private int score;
    private final Double moneyNeededToWin;
    private final int maxNumberOfTurn;
    private int turn;
    private User user;
    private boolean bonusIsActivate;
    private boolean malusIsActivate;
    private Output output;
    private Input input;

    public Game(Double moneyNeededToWin, int maxNumberOfTurn, User user) {
        this.moneyNeededToWin = moneyNeededToWin;
        this.score = 0;
        this.maxNumberOfTurn = maxNumberOfTurn;
        this.turn = 0;
        this.user = user;
        this.bonusIsActivate = false;
        this.malusIsActivate = false;
    }

    public Game(Output output, Input input) {
        this.moneyNeededToWin = 50000.0;
        this.maxNumberOfTurn = 50;
        this.score = 0;
        this.turn = 0;
        this.bonusIsActivate = false;
        this.malusIsActivate = false;
        user = new User(output, input);
        this.output = output;
        this.input = input;
    }

    public int getScore() {
        return score;
    }

    /**
     * Score max 10 000
     * A chaque tour qui pasrse le score perd son scoe max divisé par son nombre de tour max (décroissance proportionnelle)
     */
    public void setScore() {
        this.score = 10000 - (10000 / maxNumberOfTurn) * turn;
    }

    public Double getMoneyNeededToWin() {
        return this.moneyNeededToWin;
    }

    public int getMaxNumberOfTurn() {
        return maxNumberOfTurn;
    }

    public int getTurn() {
        return turn;
    }

    public void nextTurn() {
        this.turn += 1;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean getBonusIsActivate() {
        return this.bonusIsActivate;
    }

    public boolean getMalusIsActivate() {
        return this.malusIsActivate;
    }

    /**
     * met le gain du jour (de la veille car lancé en début de tour suivant) dans la trésorerie et repasse
     * les gains du jour à 0
     */
    public void putGainOfTheDayOnTresorery() {
        //     this.user.getInventory().getCashFlow().setValue(this.user.getInventory().getCashFlow().getValue() + this.bar.getGainOfTheDay());
        //  this.bar.setGainOfTheDay(0);
        this.user.setGainOfTheDay();
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

    /**
     * vérifie qu'il reste assez de place dans l'inventaire pour la quantité passée en paramètre
     *
     * @param quantity
     * @return
     */
    public boolean stillHaveEnoughtSpaceInTheInventory(int quantity) {
        return this.user.getInventory().getNumberOfPlacesInTheInventory() - quantity >= 0;
    }

    /**
     * vérifie qu'il reste assez de trésorerie pour acheter la quantité passée en paramètre
     * de la bière passée en paramètre
     *
     * @param indexOfBeer
     * @param quantity
     * @return
     */
    public boolean stillHaveEnoughtCashflowInTheInventory(int indexOfBeer, int quantity) {
        return this.user.getInventory().getCashFlow().getValue() - quantity * this.getUser().
                getInventory().getStocks().get(indexOfBeer).getBeer().getSellingPrice() >= 0;
    }

    /**
     * vérifie que l'inventaire n'est pas plein
     *
     * @return
     */
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

    /**
     * vérifie qu'il reste assez de stock pour la bière passée en paramètre pour la quantité souhaitée
     *
     * @param indexOfBeer
     * @param quantity
     * @return
     */
    public boolean stillHaveEnoughtStockForThisBeer(int indexOfBeer, int quantity) {
        return user.getInventory().getStockOf(indexOfBeer) - quantity >= 0;
    }

    /**
     * vérifie que le stock de la bière passée en paramètre n'est pas vide
     *
     * @param indexOfBeer
     * @return
     */
    public boolean stillHaveStockForThisBeer(int indexOfBeer) {
        return user.getInventory().getStockOf(indexOfBeer) > 0;
    }

    /**
     * retourne la quantité maximale achetable de la bière passée en paramètre selon la quantité souhaitée
     *
     * @param indexOfBeer
     * @param quantity
     * @return
     */
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

    /**
     * vérifie si la partie est gagnée
     *
     * @return
     */
    public boolean isWinned() {
        boolean isWinned = true;
        if (this.user.getInventory().getCashFlow().getValue() < this.moneyNeededToWin) {
            isWinned = false;
        }
        return isWinned;
    }

    /**
     * vérifie si la partie est perdue à cause du nombre de tours joués
     *
     * @return
     */
    public boolean isGameOver() {
        boolean isGameOver = true;
        if (this.turn < this.maxNumberOfTurn) {
            isGameOver = false;
        }
        return isGameOver;
    }

    /**
     * génère deux entiers entre 0 et 100 de façon aléatoire, s'ils sont égaux,
     * un bonus qui divise les prix de vente par deux est activé sur un tour
     */
    public void generateBonus() {
        int a = (int) Math.round(Math.random() * 100);
        int b = (int) Math.round(Math.random() * 100);
        this.bonusIsActivate = a == b;
    }

    /**
     * génère deux entiers entre 0 et 100 de façon aléatoire, s'ils sont égaux,
     * un malus qui divise les prix de vente par deux est activé sur un tour
     */
    public void generateMalus() {
        int a = (int) Math.round(Math.random() * 100);
        int b = (int) Math.round(Math.random() * 100);
        this.malusIsActivate = a == b;
    }

    public void playGame() {
        output.startMenu(user.getName());
        output.rules(moneyNeededToWin, maxNumberOfTurn);
        output.initialSituation(user.getInventory().getCashFlow().getValue(), user.getBar().getSize().getSize());
        while (!isGameOver() && !isWinned()) {
            playTurn();
        }
    }

    private void playTurn() {
        generateBonus();
        generateMalus();
        //générer les clients (le nombre de client est défini par la taille du resto)
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < getUser().getBar().getSize().getSize(); i++) {
            customers.add(new Customer());
        }
        //faire acheter les bieres au clients (avec bonus ou malus)
        customers.forEach(customer -> customer.chooseBeersToBuy(user.getInventory().getStocks())); //TODO wtf???
        //faire acheter les bieres et les upgrades au joueur

    }
}
