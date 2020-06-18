package logic;

import javax.swing.*;

public class Dice extends JButton {

    private int value;

    public Dice() {
        roll();
    }

    public int getValue() {
        return this.value;
    }

    public void roll() {
        this.value = (int) (Math.random() * 6) + 1;
    }

}
