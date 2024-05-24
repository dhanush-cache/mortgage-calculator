package com.dhanush;

public class MortgageCalculator {
    static final byte MONTHS_IN_YEAR = 12;
    static final byte PERCENT = 100;

    private int principal;
    private float annualInterestRate;
    private byte years;

    public MortgageCalculator(int principal, float annualInterestRate, byte years) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.years = years;
    }

    public double calculateMortgage() {
        float monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal * monthlyInterestRate
                * Math.pow(1 + monthlyInterestRate, numberOfPayments)
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        return mortgage;
    }

    public double calculateBalance(short paymentsMade) {
        float monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double balance = principal
                * (Math.pow(1 + monthlyInterestRate, numberOfPayments)
                        - Math.pow(1 + monthlyInterestRate, paymentsMade))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        return balance;
    }
}
