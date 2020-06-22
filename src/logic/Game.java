package logic;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

	public static void main(String[] args) {

		new Game().setVisible(true);

	}

	private boolean gameActive;
	private Field fields[] = new Field[13];
	private JButton rollButton = new JButton("Würfeln");
	private int rollCounter = 1, roundCounter = 1;
	private JTextField rollTextField, roundTextField, noteToKeepDice;
	private Dice dice1 = new Dice(), dice2 = new Dice(), dice3 = new Dice(), dice4 = new Dice(), dice5 = new Dice();

	Game() {
		super("Willkommen zu Kniffel! ");
		this.setLayout(new FlowLayout());

		// set game to active
		gameActive = true;

		// add score card to frame
		this.add(new ScoreCard(fields));

		// create right panel and panels within right panel
		JPanel rightSidePanel = new JPanel(), counterPanel = new JPanel(), rollPanel = new JPanel(), dicePanel = new JPanel(), notePanel = new JPanel();
		rightSidePanel.setLayout(new GridLayout(4, 1));

		// create panel with roll and round counters
		rollTextField = new JTextField("Wurf " + rollCounter + " von 3");
		roundTextField = new JTextField(roundCounter + ". Runde");
		counterPanel.setLayout(new FlowLayout());
		counterPanel.add(rollTextField);
		counterPanel.add(roundTextField);

		// create panel with roll button
		rollPanel.setLayout(new FlowLayout());
		rollPanel.add(rollButton);

		// create panel with dice
		dicePanel.setLayout(new FlowLayout());
		dicePanel.add(dice1);
		dicePanel.add(dice2);
		dicePanel.add(dice3);
		dicePanel.add(dice4);
		dicePanel.add(dice5);

		// create panel with note
		noteToKeepDice = new JTextField("Würfel anklicken bedeutet Würfel behalten.");
		notePanel.setLayout(new FlowLayout());
		notePanel.add(noteToKeepDice);

		// add panels to right panel
		rightSidePanel.add(counterPanel);
		rightSidePanel.add(rollPanel);
		rightSidePanel.add(dicePanel);
		rightSidePanel.add(notePanel);

		// add right panel to frame
		this.add(rightSidePanel);

		this.setLocationRelativeTo(null);
		this.pack();
	}

	// rolls all dices that are not "kept" by player
	public void rollDice() {
		if (!(dice1.isSelected()))
			dice1.roll();
		if (!(dice2.isSelected()))
			dice2.roll();
		if (!(dice3.isSelected()))
			dice3.roll();
		if (!(dice4.isSelected()))
			dice4.roll();
		if (!(dice5.isSelected()))
			dice5.roll();
	}

	// returns roll button
	public JButton getRollButton() {
		return this.rollButton;
	}

	// enters points into field and updates text fields
	public void enterPoints(Field f) {
		f.updatePoints(new Dice[]{dice1, dice2, dice3, dice4, dice5});
	}

	// increment or reset roll and round counters
	private void incrementCounters() {
		if (rollCounter < 3) {
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
		if (!gameActive) {
			rollTextField.setText("");
			roundTextField.setText("");
		} else {
			rollTextField.setText("Wurf " + rollCounter + " von 3");
			roundTextField.setText(roundCounter + ". Runde");
		}

	/* player clicked on field, update score of that field
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
	}*/

	}
}
