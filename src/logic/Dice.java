package logic;

import javax.swing.*;

public class Dice extends JButton {

    private int value;

    public Dice() {
        roll();
    }

    // get value for testing
    public Dice(int value) { this.value = value; }

    //
    public int getValue() {
        return this.value;
    }

    public void roll() {
        this.value = (int) (Math.random() * 6) + 1;
    }

    public String toString() { return "" + value; }

}
