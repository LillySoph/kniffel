package game;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class DiceL extends JToggleButton {

    private int value;
    private boolean isReset;
    private static final LineBorder STANDARD_BORDER = new LineBorder(Color.LIGHT_GRAY, 3, true);
    private static final LineBorder SELECTED_BORDER = new LineBorder(Color.PINK, 3, true);
    private static final int DICE_SCALE = 75;

    /**
     * Create new empty dice
     */
    public DiceL() {
        this.reset();
        this.setBorder(STANDARD_BORDER);
        this.setPreferredSize(new Dimension(DICE_SCALE,DICE_SCALE));
        // define look of selected / unselected state of dice
        addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (getModel().isSelected()) {
                    setBorder(SELECTED_BORDER);
                } else {
                    setBorder(STANDARD_BORDER);
                }
            }
        });
    }

    /**
     * Creates dice with given value, for testing
     * @param value
     */
    public DiceL(int value) {
        this.value = value; }

    /**
     * Getter for value of dice
     * @return
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Generate number between 1 and 6 and updates dice icon
     */
    public void roll() {
        this.isReset = false;
        this.value = (int) (Math.random() * 6) + 1;
        setDiceIcon("/resources/d" + value + ".png");
    }

    /**
     * Sets empty dice as icon
     */
    public void reset() {
        this.isReset = true;
        setDiceIcon("/resources/d.png");
    }

    /**
     * Helper method to set icon of dice
     * @param resource path of icon file
     */
    private void setDiceIcon(String resource) {
        this.setSelected(false);
        this.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(resource)).getImage().getScaledInstance(DICE_SCALE,DICE_SCALE,Image.SCALE_SMOOTH)));
    }

    /**
     * Returns whether the dice is reset
     * @return
     */
    public boolean isReset() { return this.isReset; }

    /**
     * Returns value of dice as string
     * @return
     */
    public String toString() { return "" + this.value; }

}