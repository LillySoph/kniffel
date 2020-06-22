package logic;

import javax.swing.*;

public class Dice extends JToggleButton {

    private int value;

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

    // "roll" dice, generate number between 1 and 6, and updates button text
    public void roll() {
        this.value = (int) (Math.random() * 6) + 1;
        this.setSelected(false);
        this.setText(toString());
    }

    // return value of dice as string for textfield
    public String toString() { return "" + value; }

}
