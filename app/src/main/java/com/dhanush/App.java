package com.dhanush;

import java.text.NumberFormat;

public class App {
    static NumberFormat currency = NumberFormat.getCurrencyInstance();

    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Principal", 1000, 1_000_000);
        float annualInterestRate = (float) Console.readNumber("Annual Interest Rate", 1, 30);
        byte years = (byte) Console.readNumber("Period(Years)", 1, 30);

        printMortgage(principal, annualInterestRate, years);

        printPaymentSchedule(principal, annualInterestRate, years);
    }

    private static void printMortgage(int principal, float annualInterestRate, byte years) {
        MortgageCalculator calculator = new MortgageCalculator(principal, annualInterestRate, years);
        double mortgage = calculator.calculateMortgage();
        System.out.println("\nMORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + currency.format(mortgage));
    }

    private static void printPaymentSchedule(int principal, float annualInterestRate, byte years) {
        MortgageCalculator calculator = new MortgageCalculator(principal, annualInterestRate, years);
        System.out.println("\nPAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= calculator.getNumberOfPayments(); month++) {
            double balance = calculator.calculateBalance(month);
            System.out.println(currency.format(balance));
        }
    }
}
