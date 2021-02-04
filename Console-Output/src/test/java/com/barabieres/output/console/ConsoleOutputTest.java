package com.barabieres.output.console;

import com.barabieres.bar.BarSizes;
import com.barabieres.game.Game;
import com.barabieres.input.Input;
import com.barabieres.inventory.InventorySizes;
import com.barabieres.inventory.Stock;
import com.barabieres.item.Beer;
import com.barabieres.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleOutputTest {

    @BeforeEach
    void setup() {

    }

    @Test
    public void should_display_rules() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // After this all System.out.println() statements will come to outContent stream.

        String expectedOutput = """
                This is a beer selling management game.\r
                You need to have 50000.0 euros before the 50th turn to win the game.\r
                The faster you are, the better your final score will be. Good luck !\r
                """;

        ConsoleOutput consoleOutput = new ConsoleOutput();
        consoleOutput.rules(50000.0, 50);
        // Do the actual assertion.
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void should_display_start_menu() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedOutput = """
                Welcome Théo to BaràBieres !\r         
                """;

        ConsoleOutput consoleOutput = new ConsoleOutput();
        consoleOutput.startMenu("Théo");
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void should_display_action_menu() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String expectedOutput = """
                Select your action :\r
                1: Buy beers\r
                2: Show Inventory\r
                3: Start Selling\r
                4: Give up\r
                """;

        ConsoleOutput consoleOutput = new ConsoleOutput();
        Input input = new ConsoleInput() {
            @Override
            public String getString() {
                return "Someone";
            }

            @Override
            public int getNumberBetween(int a, int b) {
                return 3;
            }
        };
        consoleOutput.choicesMenu(input);

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void should_display_buyable_beers_menu() {
        Game game = new Game(300.0, 25, new User("Théo", InventorySizes.small, BarSizes.small));
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