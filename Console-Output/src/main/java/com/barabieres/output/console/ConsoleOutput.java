package com.barabieres.output.console;

import com.barabieres.input.Input;
import com.barabieres.inventory.Inventory;
import com.barabieres.inventory.Stock;
import com.barabieres.output.Output;
import com.barabieres.output.actionChoices;
import com.barabieres.user.User;

import java.util.List;

public class ConsoleOutput implements Output {
    int index = 0;

    @Override
    public void startMenu(String userName) {
        System.out.println("Welcome " + userName + " to BaràBieres !");
    }

    @Override
    public void rules(Double moneyNeededToWin, int maximumNumberOfTurn) {
        System.out.println("This is a beer selling management game.");
        System.out.println("You need to have " + moneyNeededToWin + " euros before the " + maximumNumberOfTurn + "th turn to win the game.");
        System.out.println("The faster you are, the better your final score will be. Good luck !");
    }

    @Override
    public actionChoices choicesMenu(Input input) {
        // Affiche le debut
        String introduction = "Select your action :";
        System.out.println(introduction);
        // Affiche la liste des choix possibles
        for (actionChoices choice : actionChoices.values()) {
            index += 1;
            System.out.println(index + ": " + choice);
        }
        index = 0;
        int userInput = input.getNumberBetween(1, 4);
        return switch (userInput) {
            case 1 -> actionChoices.buy;
            case 2 -> actionChoices.hard;
            case 3 -> actionChoices.display;
            default -> actionChoices.give_up;
        };
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
    public void initialSituation(double value, int size) {
        System.out.println("You have " + value + " money.");
        System.out.println("Your bar can have around " + size + " clients a day.");
    }

    @Override
    public void showMoneyGained(double gainOfTheDay) {
        System.out.println("Today you won " + gainOfTheDay + " money.");
    }

    @Override
    public void startTurn(int turn) {
        System.out.println("\nStarting turn " + turn);
    }

    @Override
    public void showBeerInventory(List<Stock> stocks) {
        stocks.forEach(stock -> System.out.println("Beer : " + stock.getBeer().getName() + " | selling price : " + stock.getBeer().getSellingPrice() + " | quantity : " + stock.getQuantity()));
    }

    @Override
    public void buyBeer(List<Stock> stocks, Input input, User user) {
        int actualBeer = 1;
        System.out.println("Beers to buy :");
        for (Stock stock : stocks) {
            System.out.println(actualBeer + ": " + stock.getBeer().getName() + " at a price of " + stock.getBeer().getSellingPrice());
            actualBeer++;
        }
        System.out.println(actualBeer + ": Stop buy");
        int playerChoice = input.getNumberBetween(1, actualBeer);
        while (playerChoice != actualBeer) {
            System.out.println("You can buy a maximum of " + (int) (user.getInventory().getCashFlow().getValue() / stocks.get(playerChoice - 1).getBeer().getSellingPrice()) + " " + stocks.get(playerChoice - 1).getBeer().getName());
            System.out.println("How many do you want ?");
            int numberOfBeerBuy = input.getNumberBetween(0, (int) (user.getInventory().getCashFlow().getValue() / stocks.get(playerChoice - 1).getBeer().getSellingPrice()));
            if (numberOfBeerBuy > user.getInventory().getNumberOfPlacesLeftInTheInventory()) {
                System.out.println("You can only buy a maximum of " + user.getInventory().getSizeMaxOfInventory() + " beers.");
                System.out.println("there are already " + user.getInventory().getNumberOfPlacesLeftInTheInventory() + " beers in your inventory.");
            } else {
                user.getInventory().getCashFlow().decreaseCashFlow(numberOfBeerBuy * stocks.get(playerChoice - 1).getBeer().getSellingPrice());
                stocks.get(playerChoice - 1).increaseQuantity(numberOfBeerBuy);
            }
            actualBeer = 1;
            System.out.println("Beers to buy :");
            for (Stock stock : stocks) {
                System.out.println(actualBeer + ": " + stock.getBeer().getName() + " at a price of " + stock.getBeer().getSellingPrice());
                actualBeer++;
            }
            System.out.println(actualBeer + ": Stop buy");
            playerChoice = input.getNumberBetween(1, actualBeer);
        }
    }

    /**
     * @param inventory récupère l'inventaire qui contient toutes les bières qui achetables dans la partie
     */
    public void buyablesBeersMenu(Inventory inventory) {
        String introduction = "Select the beer you want to buy :";
        System.out.println(introduction);
        int i = 1;
        for(Stock stock : inventory.getStocks()) {
            System.out.println(i + ": " + stock.getBeer().getName() + ", " + stock.getBeer().getValue());
            i += 1;
        }
        System.out.println(i + ": Not to buy anything");
    }
}
