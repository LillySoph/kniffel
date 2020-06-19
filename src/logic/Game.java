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
	private JButton scoreSumUpperTextField = new JButton(), scoreSumLowerTextField = new JButton(), scoreSumTextField = new JButton(), bonusTextField = new JButton();
	private int scoreSumUpper = 0, scoreSumLower = 0, scoreSum = 0, bonus = 0;
	private JTextField[] table;
	private JTextField noteToKeepDice;
	private int rollCounter = 1, roundCounter = 1;
	private JTextField rollTextField, roundTextField;
	private boolean gameActive;

	Game() {
		gameActive = true;
		// initialise field buttons
		int i = 0;
		for(FieldType ft : FieldType.values()) {
			fields[i] = new Field(ft);
			i++;
		}
		// initialise text fields
		noteToKeepDice = new JTextField("Einen Würfel anklicken bedeutet diesen Würfel zurücklegen vor dem nächsten Würfeln.");
		updateAllTextFields();
	}

	public boolean gameIsActive() { return gameActive;}

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

	// increment or reset roll and round counters
	private void incrementCounters() {
		if(rollCounter < 3) {
			rollCounter++;
		} else {
			rollCounter = 1;
			if (roundCounter < 13) {
				roundCounter++;
			} else {
				roundCounter = 1;
				gameActive = false;
			}
		}
	}

	private void updateAllTextFields() {
		if(!gameActive) {
			rollTextField.setText("");
			roundTextField.setText("");
			scoreSumUpperTextField.setText("");
			scoreSumLowerTextField.setText("");
			scoreSumTextField.setText("");
		} else {
			rollTextField.setText("Wurf " + rollCounter + " von 3");
			roundTextField.setText(roundCounter + ". Runde");
			scoreSumUpperTextField.setText(scoreSumUpper + "");
			scoreSumLowerTextField.setText(scoreSumLower + "");
			scoreSumTextField.setText(scoreSum + "");
			bonusTextField.setText(bonus + "");
		}
	}

	// player clicked on field, update score of that field
	public void updateScore(Field field) {
		incrementCounters();
		field.updatePoints(new Dice[]{dice1, dice2, dice3, dice4, dice5});
		for(int i = 0; i < fields.length; i++) {
			if(i < 6)
				scoreSumUpper += fields[i].getPoints();
			else
				scoreSumLower += fields[i].getPoints();
		}
		if(scoreSumUpper >= 63) {
			bonus = 35;
			scoreSum += bonus;
		}
		scoreSum = scoreSumUpper + scoreSumLower;
	}

}
