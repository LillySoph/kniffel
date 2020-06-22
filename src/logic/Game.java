package logic;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

	public static void main(String[] args) {

		Game g = new Game();
		new GameController(g);
		g.setVisible(true);

	}

	private boolean isStillRunning, roundIsOver;
	private ScoreCard scoreCard;
	private Field[] fields = new Field[13];
	private JButton rollButton = new JButton("Würfeln");
	private int rollCounter = 3, roundCounter = 1;
	private JTextField rollTextField, roundTextField, noteForPlayer;
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
		roundIsOver = false;

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
		rollTextField = new JTextField();
		counterPanel.setLayout(new FlowLayout());
		counterPanel.add(rollTextField);
		updateCounterTextFields();

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
		noteForPlayer = new JTextField("Würfel anklicken bedeutet Würfel behalten.");
		notePanel.setLayout(new FlowLayout());
		notePanel.add(noteForPlayer);

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

	// rolls all dice that are not "kept" by player and increments roll counter
	public void rollDice() {
		if(isStillRunning) {
			Dice[] dice = {dice1, dice2, dice3, dice4, dice5};
			for (Dice d : dice) {
				if (!(d.isSelected()) || d.getText().equals("?"))
					d.roll();
			}
			System.out.println("Würfel-Zähler: " + rollCounter);
			updateRolLCounter();
			updateCounterTextFields();
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
			updateRoundCounters();
			updateCounterTextFields();
			resetDiceButtons();
			roundIsOver = true;
		}
	}

	private void resetDiceButtons() {
		Dice []dice = {dice1, dice2, dice3, dice4, dice5};
		for(Dice d : dice) {
			d.setSelected(false);
			d.setText("?");
		}
	}

	private void updateRolLCounter() {
		if (rollCounter > 0) {
			rollCounter--;
		} else {
			rollCounter = 3;
		}
	}

	// increment or reset roll and round counters
	private void updateRoundCounters() {
		if(!roundIsOver) {
			System.out.println("Runde ist noch nicht vorbei");
		} else if (roundIsOver && roundCounter < 13) {
			roundCounter++;
		} else {
			roundCounter = 1;
			noteForPlayer.setText("Das Spiel ist vorbei");
			isStillRunning = false;
		}
		rollCounter = 3;
	}

	private void updateCounterTextFields() {
		if (isStillRunning) {
			if(rollCounter == 0)
				rollTextField.setText("Würfeln, um Runde " + (roundCounter+1) + " zu starten");
			else if (rollCounter == 1)
				rollTextField.setText("Bitte wählen Sie eine Option");
			else
				rollTextField.setText("Noch " + rollCounter + " mal Würfeln (Runde " + roundCounter + ")");
		}

	}

	public boolean isStillRunning() {
		return this.isStillRunning;
	}

}
