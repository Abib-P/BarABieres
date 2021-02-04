package com.barabieres.output;

import com.barabieres.input.Input;
import com.barabieres.inventory.Stock;
import com.barabieres.user.User;

import java.util.List;

public interface Output {
    void startMenu(String userName);

    void rules(Double Cash, int Turns);

    actionChoices choicesMenu(Input input);

    String askUserName(Input input);

    void initialSituation(double value, int size);

    void showMoneyGained(double gainOfTheDay);

    void startTurn(int turn);

    void showBeerInventory(List<Stock> stocks);

    void buyBeer(List<Stock> stocks, Input input, User user);
}
