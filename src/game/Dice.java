package game;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Dice extends JToggleButton {

    private int value;
    private boolean isReset;
    private static final LineBorder standardBorder = new LineBorder(Color.LIGHT_GRAY, 3, true);
    private static final LineBorder selectedBorder = new LineBorder(Color.PINK, 3, true);
    private static final int DICE_SCALE = 75;

    // creates new dice and resets it for new round
    public Dice() {
        this.reset();
        this.setBorder(standardBorder);
        this.setPreferredSize(new Dimension(DICE_SCALE,DICE_SCALE));
        //
        addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (getModel().isSelected()) {
                    setBorder(selectedBorder);
                } else {
                    setBorder(standardBorder);
                }
            }
        });
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
        setDiceIcon("/resources/d" + value + ".png");
    }

    public void reset() {
        this.isReset = true;
        setDiceIcon("/resources/d.png");
    }

    private void setDiceIcon(String resource) {
        this.setSelected(false);
        this.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(resource)).getImage().getScaledInstance(DICE_SCALE,DICE_SCALE,Image.SCALE_SMOOTH)));
    }

    public boolean isReset() { return this.isReset; }

    // return value of dice as string for text field
    public String toString() { return "" + this.value; }

}