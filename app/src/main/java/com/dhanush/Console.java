package com.dhanush;

import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static double readNumber(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextDouble();
    }

    public static double readNumber(String prompt, int min, int max) {
        double value;
        while (true) {
            System.out.print(prompt + ": ");
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                return value;
            System.out.println("Please enter a value between " + min + " and " + max + ".");
        }
    }
}
