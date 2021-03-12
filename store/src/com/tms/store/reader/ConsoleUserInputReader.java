package com.tms.store.reader;

import java.util.Scanner;

public class ConsoleUserInputReader implements UserInputReader {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String readUserInput() {
        String s;
        do {
            s = scanner.nextLine();
        } while (s == null || s.isBlank());
        return s;
    }
}
