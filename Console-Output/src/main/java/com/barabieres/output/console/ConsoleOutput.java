package com.barabieres.output.console;

import com.barabieres.input.Input;
import com.barabieres.inventory.Inventory;
import com.barabieres.inventory.Stock;
import com.barabieres.output.Output;
import com.barabieres.output.actionChoices;

public class ConsoleOutput implements Output {
    int index = 0;

    @Override
    public void startMenu(String userName) {
        // Affiche le debut
        System.out.println("Welcome " + userName + " to BaràBieres !");
        // Affiche la liste des choix possibles
        //FIXME implémenter difficulter
        /*
        for (startChoices choice : startChoices.values()){
            index += 1;
            System.out.println(index + ": " + choice);
        }*/
    }

    @Override
    public void rules(Double moneyNeededToWin, int maximumNumberOfTurn) {
        System.out.println("This is a beer selling management game.");
        System.out.println("You need to have " + moneyNeededToWin + " euros before the " + maximumNumberOfTurn + "th turn to win the game.");
        System.out.println("The faster you are, the better your final score will be. Good luck !");
    }

    @Override
    public void choicesMenu() {
        // Affiche le debut
        String introduction = "Select your action :";
        System.out.println(introduction);
        // Affiche la liste des choix possibles
        for (actionChoices choice : actionChoices.values()) {
            index += 1;
            System.out.println(index + ": " + choice);
        }
    }

    @Override
    public String askUserName(Input input) {
        System.out.println("Enter your name:");
        String userName = input.getString();
        while (userName.equals("")) {
            System.out.println("Please enter a valid name:");
            userName = input.getString();
        }
        return userName;
    }

    @Override
    public void initialSituation(Double money, int size) {

    }

    /**
     * @param inventory récupère l'inventaire qui contient toutes les bières qui achetables dans la partie
     */
    public void buyablesBeersMenu(Inventory inventory) {
        // Affiche le début
        String introduction = "Select the beer you want to buy :";
        System.out.println(introduction);
        int i = 1;
        // Affiche la liste des bières possibles
        for(Stock stock : inventory.getStocks()) {
            System.out.println(i + ": " + stock.getBeer().getName() + ", " + stock.getBeer().getValue());
            i += 1;
        }
        System.out.println(i + ": Not to buy anything");
    }
}
