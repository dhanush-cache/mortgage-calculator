package com.dhanush;

public class ConstrainedTextField extends javax.swing.JTextField {
    private int MIN;
    private int MAX;

    public ConstrainedTextField(int min, int max) {
        MIN = min;
        MAX = max;
    }

    public int getMIN() {
        return MIN;
    }

    public int getMAX() {
        return MAX;
    }

    public boolean isInRange() {
        try {
            var value = Double.parseDouble(getText());
            return (value >= MIN && value <= MAX);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public double getValue() {
        if (isInRange())
            return Double.parseDouble(getText());
        return -1;
    }

}
