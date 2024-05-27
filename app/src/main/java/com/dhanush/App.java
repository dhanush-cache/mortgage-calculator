package com.dhanush;

import java.text.NumberFormat;

public class App {
    static NumberFormat currency = NumberFormat.getCurrencyInstance();

    public static void main(String[] args) {
        console();
    }

    private static void console() {
        int principal = (int) Console.readNumber("Principal", 1000, 1_000_000);
        float annualInterestRate = (float) Console.readNumber("Annual Interest Rate", 1, 30);
        byte years = (byte) Console.readNumber("Period(Years)", 1, 30);

        MortgageCalculator calculator = new MortgageCalculator(principal, annualInterestRate, years);
        MortgageReport report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }
}
