package logic;

import javax.swing.*;

public class Dice extends JButton {

    private int value;
    private boolean keepDice;

    // creates new dice and "rolls" it
    public Dice() {
        roll();
    }

    // ** Constructor For Testing ** //
    public Dice(int value) {
        this.value = value; }

    // getter for value of dice
    public int getValue() {
        return this.value;
    }

    // change keepDice to its contrary
    public void changeKeepDice() {
        this.keepDice = (!keepDice);
    }

    // returns whether the dice should be kept for the next round or rolled
    public boolean isKept() {
        return (this.keepDice == true);
    }

    // player wants to keep the dice for next roll, set keepDice to true
    public void keep() {
        this.keepDice = true;
    }

    // "roll" dice, generate number between 1 and 6, and updates button text
    public void roll() {
        this.value = (int) (Math.random() * 6) + 1;
        keepDice = false;
        this.setText(toString());
    }

    // return value of dice as string for textfield
    public String toString() { return "" + value; }

}
