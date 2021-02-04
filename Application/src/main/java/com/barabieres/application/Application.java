package com.barabieres.application;

import com.barabieres.game.Game;
import com.barabieres.input.Input;
import com.barabieres.item.BeerRepository;
import com.barabieres.item.JsonBeerRepository;
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
        BeerRepository beerRepository = new JsonBeerRepository("BeerRepositoryJson/src/main/resources/beers.json");
        Game game = new Game(consoleOutput, consoleInput, beerRepository);
        game.playGame();
        return EXIT_SUCCESS;
    }

    public static int runProgram(Game game) {
        Output consoleOutput = new ConsoleOutput();
        Input consoleInput = new ConsoleInput();
        BeerRepository beerRepository = new JsonBeerRepository("BeerRepositoryJson/src/main/resources/beers.json");
        Game gaming = game;
        return EXIT_SUCCESS;
    }
}
