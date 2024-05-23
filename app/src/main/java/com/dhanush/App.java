package com.dhanush;

import java.text.NumberFormat;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal;
        float monthlyInterestRate;
        int numberOfPayments;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();

            System.out.print("Annual Interest Rate: ");
            float annualInterestRate = scanner.nextFloat();
            monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;

            System.out.print("Period(Years): ");
            byte years = scanner.nextByte();
            numberOfPayments = years * MONTHS_IN_YEAR;
        }

        double mortgage = principal * monthlyInterestRate
                * Math.pow(1 + monthlyInterestRate, numberOfPayments)
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}
