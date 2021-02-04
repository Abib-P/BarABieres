package com.barabieres.output.console;

import com.barabieres.input.Input;

import java.util.Scanner;

public class ConsoleInput implements Input {
    Scanner scanner = new Scanner(System.in);

    @Override
    public String getString() {
        return scanner.nextLine();
    }

    @Override
    public int getNumberBetween(int lowerBound, int upperBound) {
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int val = scanner.nextInt();
                if (val >= lowerBound && val <= upperBound) {
                    return val;
                }
            } else {
                scanner.next();
            }
        }
        return -1;
    }
}
