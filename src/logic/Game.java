package logic;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

	public static void main(String[] args) {

		Game g = new Game();
		new GameController(g);
		g.setVisible(true);

	}

	private boolean isStillRunning;
	private ScoreCard scoreCard;
	private Field[] fields = new Field[13];
	private JButton rollButton = new JButton("Würfeln");
	private int rollCounter = 1, roundCounter = 1;
	private JTextField rollTextField, roundTextField, noteToKeepDice;
	private Dice dice1 = new Dice();
	private Dice dice2 = new Dice();
	private Dice dice3 = new Dice();
	private Dice dice4 = new Dice();
	private Dice dice5 = new Dice();

	Game() {
		super("Willkommen zu Kniffel! ");
		this.setLayout(new FlowLayout());

		// set game to active
		isStillRunning = true;

		// initialize field buttons
		int i = 0;
		for(FieldType ft : FieldType.values()) {
			fields[i] = new Field(ft);
			i++;
		}

		// add score card to frame
		scoreCard = new ScoreCard(fields);
		this.add(scoreCard);

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
		resetDiceButtons();

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
		if(isStillRunning) {
			Dice[] dice = {dice1, dice2, dice3, dice4, dice5};
			for (Dice d : dice) {
				if (!(d.isSelected()) || d.getText() == "?")
					d.roll();
			}
			incrementRollCounter();
			updateRollAndRoundCounterTextFields();
		}
	}

	// returns roll button
	public JButton getRollButton() {
		return this.rollButton;
	}

	public Dice[] getDiceButtons() {
		return new Dice[]{dice1, dice2, dice3, dice4, dice5};
	}

	public Field[] getFieldButtons() {
		return fields;
	}

	// enters points into field and updates text fields
	public void enterPoints(Field field) {
		if(isStillRunning) {
			field.calculateAndStorePoints(new Dice[]{dice1, dice2, dice3, dice4, dice5});
			scoreCard.updateScore();
			incrementRoundCounters();
			updateRollAndRoundCounterTextFields();
			resetDiceButtons();
		}
	}

	private void resetDiceButtons() {
		Dice []dice = {dice1, dice2, dice3, dice4, dice5};
		for(Dice d : dice) {
			d.setSelected(false);
			d.setText("?");
		}
	}

	private void incrementRollCounter() {
		if (rollCounter < 3) {
			rollCounter++;
		} else {
			rollCounter = 1;
			incrementRoundCounters();
		}
	}

	// increment or reset roll and round counters
	private void incrementRoundCounters() {
		if (roundCounter < 13) {
			roundCounter++;
		} else {
			roundCounter = 1;
			noteToKeepDice.setText("Das Spiel ist vorbei");
			isStillRunning = false;
		}
		rollCounter = 0;
	}

	private void updateRollAndRoundCounterTextFields() {
		if (!isStillRunning) {
			rollTextField.setText("");
			roundTextField.setText("");
		} else {
			rollTextField.setText("Wurf " + rollCounter + " von 3");
			roundTextField.setText(roundCounter + ". Runde");
		}

	}

	public boolean isStillRunning() {
		return this.isStillRunning;
	}

}
