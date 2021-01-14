package com.barabieres.output.console;

import com.barabieres.Item.Beer;
import com.barabieres.game.Game;
import com.barabieres.inventory.Inventory;
import com.barabieres.inventory.Stock;
import com.barabieres.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleOutputTest {

    @Test
    public void should_display_rules() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // After this all System.out.println() statements will come to outContent stream.

        String expectedOutput = """
                This is a beer selling management game.
                 You need to have 50000 euros at 50To win the game.
                 The faster you are, the better your final score will be\r
                """;

        ConsoleOutput consoleOutput = new ConsoleOutput();
        consoleOutput.rules(50000, 50);
        // Do the actual assertion.
        assertEquals(expectedOutput, outContent.toString());
    }
    
    @Test
    public void should_display_start_menu() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // After this all System.out.println() statements will come to outContent stream.

        //Now you have to validate the output. Let's say items had 1 element.
        // With name as FirstElement and number as 1.
        String expectedOutput = """
                Welcome to BaràBieres ! Enter a number :\r
                1: Easy mode\r
                2: Normal mode\r
                3: Hard mode\r
                4: Display Rules\r
                """;

        ConsoleOutput consoleOutput = new ConsoleOutput();
        consoleOutput.startMenu();
        // Do the actual assertion.
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void should_display_action_menu() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // After this all System.out.println() statements will come to outContent stream.

        //Now you have to validate the output. Let's say items had 1 element.
        // With name as FirstElement and number as 1.
        String expectedOutput = """
                Select your action :\r
                1: Buy beers\r
                2: Modify selling prices\r
                3: Show Inventory\r
                4: Start Selling\r
                5: Give up\r
                """;

        ConsoleOutput consoleOutput = new ConsoleOutput();
        consoleOutput.choicesMenu();
        // Do the actual assertion.
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void should_display_buyable_beers_menu() {
        Game game = new Game(2000, 300, 25, new User("Théo", 100));
        ArrayList<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock(new Beer("Fruits rouges", 7, 5)));
        stocks.add(new Stock(new Beer("Blonde", 5, 4)));
        stocks.add(new Stock(new Beer("Brune", 6, 4.5)));
        game.getUser().getInventory().setStocks(stocks);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String expectedOutput = """
                Select the beer you want to buy :\r
                1: Fruits rouges, 7.0\r
                2: Blonde, 5.0\r
                3: Brune, 6.0\r
                4: Not to buy anything\r
                """;

        ConsoleOutput consoleOutput = new ConsoleOutput();
        consoleOutput.buyablesBeersMenu(game.getUser().getInventory());
        // Do the actual assertion.
        assertEquals(expectedOutput, outContent.toString());
    }
}