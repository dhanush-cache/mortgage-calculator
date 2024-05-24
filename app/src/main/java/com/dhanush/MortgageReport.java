package com.dhanush;

public class MortgageReport {
    MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
    }

    public void printPaymentSchedule() {
        System.out.println("\nPAYMENT SCHEDULE");
        System.out.println("----------------");
        for (double balance : calculator.getPaymentSchedule())
            System.out.println(App.currency.format(balance));
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        System.out.println("\nMORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + App.currency.format(mortgage));
    }
}
