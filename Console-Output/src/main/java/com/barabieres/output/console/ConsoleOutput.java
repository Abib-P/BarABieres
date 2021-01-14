package com.barabieres.output.console;

import com.barabieres.output.Output;
import com.barabieres.output.actionChoices;
import com.barabieres.output.startChoices;

public class ConsoleOutput implements Output {
    int index = 0;
    String Newligne=System.getProperty("line.separator");
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
}
