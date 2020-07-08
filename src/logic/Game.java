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

		JPanel window = new JPanel(new GridBagLayout());
		GridBagConstraints cWindow = new GridBagConstraints();

		// initialize field buttons
		int i = 0;
		for (FieldType ft : FieldType.values()) {
			this.fields[i] = new Field(ft);
			System.out.println("init; width: " + this.fields[i].getWidth() + "  height: " + this.fields[i].getHeight());
			i++;
		}

		// add score card to frame
		scoreCard = new ScoreCard(this.fields);
		window.add(scoreCard, cWindow);

		// create right panel and panels within right panel
		JPanel rightSidePanel = new JPanel(), counterPanel = new JPanel(), rollPanel = new JPanel(),
		dicePanel = new JPanel(), notePanel = new JPanel();
		rightSidePanel.setLayout(new GridLayout(4, 1));

		// create panel with roll and round counters
		rollTextField = new JTextField();
		counterPanel.setLayout(new FlowLayout());
		counterPanel.add(rollTextField);

		// create panel with roll button
		rollPanel.setLayout(new FlowLayout());
		rollPanel.add(rollButton);

		// create panel with dice buttons
		dicePanel.setLayout(new FlowLayout());
		dicePanel.add(dice1);
		dicePanel.add(dice2);
		dicePanel.add(dice3);
		dicePanel.add(dice4);
		dicePanel.add(dice5);
		resetDiceButtons();

		// create panel with note for player
		noteForPlayer = new JTextField("Würfel anklicken bedeutet Würfel behalten.");
		notePanel.setLayout(new FlowLayout());
		notePanel.add(noteForPlayer);

		// add panels to right panel
		rightSidePanel.add(counterPanel);
		rightSidePanel.add(rollPanel);
		rightSidePanel.add(dicePanel);
		rightSidePanel.add(notePanel);

		// add right panel to frame
		window.add(rightSidePanel, cWindow);

		this.add(window);

		this.updateGUI();
		deactivateFieldButtons();

		this.setLocationRelativeTo(null);
		this.pack();
	}

	/**
	 * Rolls all dice that are not "kept" by player and increments roll counter.
	 */
	public void rollDice() {
		Dice[] dice = getDiceButtons();
		for (Dice d : dice) {
			// roll if dice is not kept or is reset
			if (!(d.isSelected()) || d.isReset())
				d.roll();
			d.setSelected(false);
		}
		System.out.println("roll | dice width: " + dice[0].getWidth() + "   dice height: " + dice[0].getHeight());
		System.out.println("roll | dice x: " + dice[0].getX() + "   dice y: " + dice[0].getY());
		// increment roll counter
		incrementRolLCounter();
		// activate field buttons so that player can choose something
		activateFieldButtons();
		updateGUI();
	}

	/**
	 * Returns roll button.
	 * 
	 * @return
	 */
	public JButton getRollButton() {
		return this.rollButton;
	}

	/**
	 * Returns dice buttons.
	 * 
	 * @return
	 */
	public Dice[] getDiceButtons() {
		return new Dice[] { dice1, dice2, dice3, dice4, dice5 };
	}

	/**
	 * Return field buttons.
	 * 
	 * @return
	 */
	public Field[] getFieldButtons() {
		return fields;
	}

	/**
	 * Enter points and update gui.
	 * 
	 * @param field option chosen by player
	 */
	public void enterPoints(Field field) {
		// calculate points
		field.calculateAndStorePoints(getDiceButtons());
		// increment counters
		incrementRoundCounters();
		resetRollCounter();
		// update graphic user interface
		updateGUI();
		// reset dice buttons for new round
		resetDiceButtons();
		// deactivate field buttons so that player cannot chose anything before having
		// rolled at least once
		deactivateFieldButtons();
		activateRollButton();
		System.out.println("enter points; width: " + field.getWidth() + "  height: " + field.getHeight());
	}

	/**
	 * Update text fields and counters in gui.
	 */
	private void updateGUI() {
		scoreCard.calculateScoreSums();
		if (rollCounter == 0) {
			rollTextField.setText("Bitte wählen Sie eine Option");
		} else {
			rollTextField.setText("Noch " + rollCounter + " mal Würfeln (Runde " + roundCounter + ")");
		}
		System.out.println("score card; width: " + scoreCard.getWidth() + "  height: " + scoreCard.getHeight());
		System.out.println("game; width: " + this.getWidth() + "  height: " + this.getHeight());
	}

	/**
	 * Reset dice buttons for a new round: [ ]
	 */
	private void resetDiceButtons() {
		Dice[] dice = getDiceButtons();
		for (Dice d : dice) {
			d.setSelected(false);
			d.reset();
		}
		System.out.println("reset | dice width: " + dice[0].getWidth() + "   dice height: " + dice[0].getHeight());
		System.out.println("reset | dice x: " + dice[0].getX() + "   dice y: " + dice[0].getY());
	}

	/**
	 * Deactivate field buttons.
	 */
	private void deactivateFieldButtons() {
		for (Field f : fields) {
			f.setEnabled(false);
		}
	}

	/**
	 * Activates field buttons, if they are not supposed to stay deactivated.
	 */
	private void activateFieldButtons() {
		for (Field f : fields) {
			if (!f.isDisabled())
				f.setEnabled(true);
		}
	}

	/**
	 * Reset roll counter.
	 */
	private void resetRollCounter() {
		this.rollCounter = 3;
	}

	/**
	 * Increment roll counters.
	 */
	private void incrementRolLCounter() {
		if (rollCounter == 1) {
			rollCounter--;
			System.out.println("deactivate roll button");
			deactivateRollButton();
		} else {
			rollCounter--;
		}
		System.out.println("incrementRolLCounter()   Würfel-Zähler: " + rollCounter + " von 3");
	}

	/**
	 * Increment round counters.
	 */
	private void incrementRoundCounters() {
		if (roundCounter < 13) {
			roundCounter++;
		} else {
			roundCounter = 1;
			deactivateRollButton();
			noteForPlayer.setText("Das Spiel ist vorbei");
			isStillRunning = false;
		}
		rollCounter = 3;
	}

	/**
	 * Deactivate roll button.
	 */
	private void deactivateRollButton() {
		this.rollButton.setEnabled(false);
	}

	/**
	 * Activate roll button.
	 */
	private void activateRollButton() {
		this.rollButton.setEnabled(true);
	}

	/**
	 * Returns whether the game is still running.
	 * 
	 * @return true, if game is still running, otherwise false
	 */
	public boolean isStillRunning() {
		return this.isStillRunning;
	}

}
