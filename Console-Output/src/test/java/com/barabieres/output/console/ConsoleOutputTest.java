package com.barabieres.output.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
class ConsoleOutputTest {
@Test
    public void should_display_rules(){
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    // After this all System.out.println() statements will come to outContent stream.

    String expectedOutput  = "This is a beer selling management game.\n " +
    "You need to have " + 50000 + " euros at " + 50
            + "To win the game.\n The faster you are, the better your final score will be\r\n";

    ConsoleOutput consoleOutput = new ConsoleOutput();
    consoleOutput.rules(50000,50);
    // Do the actual assertion.
    assertEquals(expectedOutput, outContent.toString());
}


    @Test
    public void should_display_start_menu(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // After this all System.out.println() statements will come to outContent stream.

        //Now you have to validate the output. Let's say items had 1 element.
        // With name as FirstElement and number as 1.
        String expectedOutput  = "Welcome to BaràBieres ! Enter a number :\r\n" +
                "1: Easy mode\r\n" +
                "2: Normal mode\r\n" +
                "3: Hard mode\r\n" +
                "4: Display Rules\r\n";

        ConsoleOutput consoleOutput = new ConsoleOutput();
        consoleOutput.startMenu();
        // Do the actual assertion.
        assertEquals(expectedOutput, outContent.toString());
    }
    @Test
    public void should_display_action_menu(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // After this all System.out.println() statements will come to outContent stream.

        //Now you have to validate the output. Let's say items had 1 element.
        // With name as FirstElement and number as 1.
        String expectedOutput  = "Select your action :\r\n" +
                "1: Buy beers\r\n" +
                "2: Modify selling prices\r\n" +
                "3: Show Inventory\r\n" +
                "4: Start Selling\r\n" +
                "5: Give up\r\n";

        ConsoleOutput consoleOutput = new ConsoleOutput();
        consoleOutput.choicesMenu();
        // Do the actual assertion.
        assertEquals(expectedOutput, outContent.toString());
    }


}