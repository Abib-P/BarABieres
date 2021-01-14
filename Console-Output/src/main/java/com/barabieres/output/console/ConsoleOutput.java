package com.barabieres.output.console;

import com.barabieres.inventory.Inventory;
import com.barabieres.inventory.Stock;
import com.barabieres.output.Output;
import com.barabieres.output.actionChoices;
import com.barabieres.output.startChoices;

public class ConsoleOutput implements Output {
    int index = 0;
    String newLine=System.getProperty("line.separator");
    public void startMenu() {
        // Affiche le debut
        String introduction = "Welcome to BaràBieres ! Enter a number :";
        System.out.println(introduction);
        // Affiche la liste des choix possibles
        for (startChoices choice : startChoices.values()){
            index += 1;
            System.out.println(index + ": " + choice);
        }
    }

    public void rules(int winAtCash, int winAtTurns) {
        String introduction = "This is a beer selling management game.\n " +
                "You need to have " + winAtCash + " euros at " + winAtTurns
                + "To win the game.\n The faster you are, the better your final score will be";

        System.out.println(introduction);
    }

    public void choicesMenu() {
        // Affiche le debut
        String introduction = "Select your action :";
        System.out.println(introduction);
        // Affiche la liste des choix possibles
        for (actionChoices choice : actionChoices.values()){
            index += 1;
            System.out.println(index + ": " + choice);
        }
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

    /**
     * @param inventory
     */
    public void stockOfBeersMenu(Inventory inventory) {
        // Affiche le début
        String tresorery = "Tresorery : " + inventory.getCashFlow().getValue() + "\n";
        System.out.println(tresorery);
        // Affiche la liste des bières possibles
        for(Stock stock : inventory.getStocks()) {
            System.out.println(stock.getBeer().getName() + " : " + stock.getQuantity());
        }
    }
}
