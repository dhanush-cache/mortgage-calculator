package com.dhanush;

import java.text.NumberFormat;
import java.util.Scanner;

public class App {
    static final byte MONTHS_IN_YEAR = 12;
    static final byte PERCENT = 100;

    public static void main(String[] args) {
        int principal;
        float annualInterestRate;
        byte years;

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Principal: ");
                principal = scanner.nextInt();
                if (principal >= 1000 && principal <= 1_000_000)
                    break;
                System.out.println("Please enter a value between 1000 and 1,000,000.");
            }

            while (true) {
                System.out.print("Annual Interest Rate: ");
                annualInterestRate = scanner.nextFloat();
                if (annualInterestRate >= 1 && annualInterestRate <= 30)
                    break;
                System.out.println("Please enter a value between 1 and 30.");
            }

            while (true) {
                System.out.print("Period(Years): ");
                years = scanner.nextByte();
                if (years >= 1 && years <= 30)
                    break;
                System.out.println("Please enter a value between 1 and 30.");
            }
        }

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
}
