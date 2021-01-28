package com.barabieres.output;

import com.barabieres.input.Input;

public interface Output {
    void startMenu(String userName);

    void rules(Double Cash, int Turns);

    void choicesMenu();

    String askUserName(Input input);

    void initialSituation(Double money, int size);
}
