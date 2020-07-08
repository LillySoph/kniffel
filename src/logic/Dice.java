package logic;

import javax.swing.*;
import java.awt.*;

public class Dice extends JToggleButton {

    private int value;
    private boolean isReset;

    // creates new dice and resets it
    public Dice() {
        this.reset();
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
        this.isReset = false;
        this.value = (int) (Math.random() * 6) + 1;
//        this.setSelected(false);
        setDiceIcon("/d" + toString() + ".png");
    }

    public void reset() {
        this.isReset = true;
        setDiceIcon("/d.png");
    }

    private void setDiceIcon(String resource) {
        this.setSize(55,55);
        this.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(resource)).getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH)));
    }

    public boolean isReset() { return this.isReset; }

    // return value of dice as string for text field
    public String toString() { return "" + this.value; }

}