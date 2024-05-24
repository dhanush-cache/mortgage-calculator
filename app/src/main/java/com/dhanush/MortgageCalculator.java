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
        return principal * getMonthlyInterestRate()
                * Math.pow(1 + getMonthlyInterestRate(), getNumberOfPayments())
                / (Math.pow(1 + getMonthlyInterestRate(), getNumberOfPayments()) - 1);
    }

    public double calculateBalance(short paymentsMade) {
        return principal
                * (Math.pow(1 + getMonthlyInterestRate(), getNumberOfPayments())
                        - Math.pow(1 + getMonthlyInterestRate(), paymentsMade))
                / (Math.pow(1 + getMonthlyInterestRate(), getNumberOfPayments()) - 1);
    }

    public double[] getPaymentSchedule() {
        double[] paymentSchedule = new double[getNumberOfPayments()];
        for (short month = 1; month <= getNumberOfPayments(); month++)
            paymentSchedule[month - 1] = calculateBalance(month);
        return paymentSchedule;
    }

    public int getNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }

    private float getMonthlyInterestRate() {
        return annualInterestRate / PERCENT / MONTHS_IN_YEAR;
    }
}
