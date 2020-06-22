package logic;

import javax.swing.*;

public class ScoreField extends JTextField {

    private int value;

    ScoreField() {
        setValue(0);
    }

    public void setValue(int value) {
        this.value = value;
        this.setText(toString());
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        return "" + value;
    }
}
