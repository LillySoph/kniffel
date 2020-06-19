package logic;

import javax.swing.*;

public class Game extends JFrame {
	/** 
	 * vorher stand newDice [4]
	 * @author prett
	 *
	 * Weitere Attribute hinzugefügt
	 * 	 * - lilly
	 */
	private Dice dice1 = new Dice();
	private Dice dice2 = new Dice();
	private Dice dice3 = new Dice();
	private Dice dice4 = new Dice();
	private Dice dice5 = new Dice();
    private Field[] fields;
	private JButton rollButton;
	private JTextField[] table;
	private JTextField noteToKeepDice;
	private int rollCounter = 1;
	private int roundCounter = 1;
	private JTextField rollTextField;
	private JTextField roundTextField;

	Game() {
		// initialise field buttons
		int i = 0;
		for(FieldType ft : FieldType.values()) {
			fields[i] = new Field(ft);
			i++;
		}
		// initialise text fields
		noteToKeepDice = new JTextField("Einen Würfel anklicken bedeutet diesen Würfel zurücklegen vor dem nächsten Würfeln.");
	}

	// returns roll button
    public JButton getRollButton() {
		return this.rollButton;
	}

	// rolls all dices that are not "kept" by player
	public void rollDices() {
		if(!dice1.isKept())
			dice1.roll();
		if(!dice2.isKept())
			dice2.roll();
		if(!dice3.isKept())
			dice3.roll();
		if(!dice4.isKept())
			dice4.roll();
		if(!dice5.isKept())
			dice5.roll();
	}

	private void updateCounters() {
		// increment or reset roll and round counters
		if(rollCounter < 3) {
			rollCounter++;
		} else {
			rollCounter = 1;
			if(roundCounter < 13) {
				roundCounter++;
			} else {
				roundCounter = 1;
				gameActive = false;
			}
		}
	}

	public void updateScore() {
		updateCounters();
		if(gameActive) {

		}
	}

}
