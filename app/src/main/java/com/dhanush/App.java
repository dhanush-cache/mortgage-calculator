package com.dhanush;

import java.text.NumberFormat;
import java.util.Scanner;

public class App {
    static final byte MONTHS_IN_YEAR = 12;
    static final byte PERCENT = 100;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int principal = (int) readNumber("Principal", 1000, 1_000_000);
        float annualInterestRate = (float) readNumber("Annual Interest Rate", 1, 30);
        byte years = (byte) readNumber("Period(Years)", 1, 30);

        double mortgage = calculateMortgage(principal, annualInterestRate, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }

    public static double calculateMortgage(int principal, float annualInterestRate, byte years) {
        float monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal * monthlyInterestRate
                * Math.pow(1 + monthlyInterestRate, numberOfPayments)
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        return mortgage;
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
