package com.barabieres.application;

import com.barabieres.game.Game;
import com.barabieres.input.Input;
import com.barabieres.output.Output;
import com.barabieres.output.console.ConsoleInput;
import com.barabieres.output.console.ConsoleOutput;

public class Application {
    private static final int EXIT_SUCCESS = 0;
    private static final int EXIT_FAILURE = 1;

    public static void main(String[] args) {
        runProgram();
    }

    public static int runProgram() {
        Output consoleOutput = new ConsoleOutput();
        Input consoleInput = new ConsoleInput();
        Game game = new Game(consoleOutput, consoleInput);
        game.playGame();
        return EXIT_SUCCESS;
    }
}
