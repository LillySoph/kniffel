package game;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JToggleButton;

public class DiceE extends JToggleButton {
	private int value;

	public DiceE() {
		this.setFont(new Font("SansSerif", Font.PLAIN, 14));
		this.setBackground(Color.pink);
		this.roll();
	}

	// ** Constructor For Testing ** //
	public DiceE(int value) {
		this.value = value;
	}

	// getter for value of dice
	public int getValue() {
		return this.value;
	}

	// "roll" dice, generate number between 1 and 6, and updates button text
	public void roll() {
		this.setSelected(false);
		this.setText(this.toString());
		this.value = (int) (Math.random() * 6) + 1;
	}

	// return value of dice as string for text field
	public String toString() {
		return "" + this.value;
	}

}
