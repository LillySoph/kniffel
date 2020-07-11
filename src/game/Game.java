package game;

import javax.swing.*;
import javax.swing.border.LineBorder;

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
	private JButton rollButton;
	private int rollCounter = 3, roundCounter = 1;
	private JTextField rollTextField, roundTextField, noteForPlayer;
	private Dice dice1 = new Dice();
	private Dice dice2 = new Dice();
	private Dice dice3 = new Dice();
	private Dice dice4 = new Dice();
	private Dice dice5 = new Dice();

	public Game() {
		super("Willkommen zu Kniffel! ");

		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/diceicon.png")));

		// setup grid layout
		this.setLayout(new GridLayout(1, 2));

		// init and add score card
		this.scoreCard = new ScoreCard(fields);
		this.add(scoreCard);

		// init right panel
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(4, 1));

		// add counter panel
		JPanel counterPanel = new JPanel();
		counterPanel.setLayout(new FlowLayout());
		this.rollTextField = new JTextField();
		this.rollTextField.setEditable(false);
		this.rollTextField.setPreferredSize(new Dimension(200, 40));
		this.rollTextField.setHorizontalAlignment(SwingConstants.CENTER);
		this.rollTextField.setFont(new Font("SansSerif", Font.PLAIN, 16));
		this.rollTextField.setBorder(null);

		this.roundTextField = new JTextField();
		this.roundTextField.setEditable(false);
		this.roundTextField.setPreferredSize(new Dimension(200, 40));
		this.roundTextField.setHorizontalAlignment(SwingConstants.CENTER);
		this.roundTextField.setFont(new Font("SansSerif", Font.PLAIN, 16));
		this.roundTextField.setBorder(null);

		counterPanel.add(rollTextField);
		counterPanel.add(roundTextField);

		rightPanel.add(counterPanel);

		// add roll panel
		JPanel rollPanel = new JPanel();
		rollPanel.setLayout(new FlowLayout());
		this.rollButton = new JButton("Würfeln");
		this.rollButton.setFont(new Font("SansSerif", Font.BOLD, 28));
		this.rollButton.setBackground(Color.PINK);
		this.rollButton.setPreferredSize(new Dimension(140, 50));
		this.rollButton.setBorder(new LineBorder(Color.BLACK, 3, true));
		this.rollButton.setFocusPainted(false);

		rollPanel.add(this.rollButton);

		rightPanel.add(rollPanel);

		// add dice panel
		JPanel dicePanel = new JPanel();
		dicePanel.setLayout(new FlowLayout());
		Dice[] dice = getDiceButtons();
		for (Dice d : dice) {
			dicePanel.add(d);
		}
		rightPanel.add(dicePanel);

		// add note panel
		JPanel notePanel = new JPanel();
		notePanel.setLayout(new FlowLayout());
		this.noteForPlayer = new JTextField("Würfel auswählen bedeutet Würfel behalten.");
		this.noteForPlayer.setFont(new Font("SansSerif", Font.ITALIC, 16));
		this.noteForPlayer.setEditable(false);
		this.noteForPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		this.noteForPlayer.setAlignmentY(Component.TOP_ALIGNMENT);
		this.noteForPlayer.setBorder(null);

		notePanel.add(this.noteForPlayer);
		rightPanel.add(notePanel);

		rightPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, false));
		this.add(rightPanel);
		this.updateGUI();
		this.deactivateFieldButtons();

		this.isStillRunning = true;

		this.setSize(900, 600);
		this.setLocationRelativeTo(null);

	}

	/**
	 * Roll all dice that are not "kept" by player and increments roll counter.
	 */
	public void rollAllDice() {
		Dice[] dice = this.getDiceButtons();
		for (Dice d : dice) {
			// roll if dice is not kept or is reset
			if (!(d.isSelected()) || d.isReset())
				d.roll();
		}
		// increment roll counter
		this.incrementRollCounter();
		// activate field buttons so that player can choose something
		this.activateFieldButtons();
		this.updateGUI();
	}

	/**
	 * Return roll button.
	 *
	 * @return roll button
	 */
	public JButton getRollButton() {
		return this.rollButton;
	}

	/**
	 * Return dice buttons.
	 *
	 * @return dice buttons
	 */
	public Dice[] getDiceButtons() {
		return new Dice[] { this.dice1, this.dice2,this.dice3, this.dice4, this.dice5 };
	}

	/**
	 *
	 * Return field buttons
	 * 
	 * @return field buttons.
	 */
	public Field[] getFieldButtons() {
		return this.fields;
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
		this.incrementRoundCounters();
		this.rollCounter = 3;
		if (this.isStillRunning()) {
			this.scoreCard.calculateScoreSums();
			this.updateGUI();
			this.resetDiceButtons();
			this.deactivateFieldButtons();
			this.activateRollButton();
		} else {
			this.gameIsOver();
		}
	}

	/**
	 * Deactivate and resets all buttons and display score.
	 */
	private void gameIsOver() {
		this.scoreCard.calculateScoreSums();
		this.deactivateRollButton();
		this.deactivateAllDiceButton();
		this.rollButton.setText("Das Spiel ist vorbei!");
		this.rollButton.setPreferredSize(new Dimension(300, 50));
		this.roundTextField.setVisible(false);
		this.rollTextField.setVisible(false);
		int score = this.scoreCard.getSumOverall();
		if (score == 375)
			this.noteForPlayer.setText("Wow, Sie haben mit " + score + " Punkten die volle Punktzahl erreicht!");
		else if (score > 50)
			this.noteForPlayer.setText("Glückwunsch, Ihre Gesamt-Punktzahl beträgt " + score + "!");
		else
			this.noteForPlayer.setText("Sie haben " + score + " Punkte erreicht.");
		this.resetDiceButtons();
		this.deactivateFieldButtons();
	}

	/**
	 * Update text fields and counters in gui.
	 */
	private void updateGUI() {
		if (this.rollCounter == 0) {
			this.rollTextField.setText("Bitte wählen Sie eine Option");
		} else {
			this.rollTextField.setText("Noch " + this.rollCounter + " mal Würfeln");
		}
		this.roundTextField.setText("Runde " + this.roundCounter + " von 13");
	}

	/**
	 * Reset dice buttons for a new round.
	 */
	private void resetDiceButtons() {
		Dice[] dice = this.getDiceButtons();
		for (Dice d : dice) {
			d.reset();
		}
	}

	/**
	 * Disable all dice buttons after the end of game.
	 */
	private void deactivateAllDiceButton() {
		Dice[] dice = { this.dice1, this.dice2, this.dice3, this.dice4, this.dice5 };
		for (Dice d : dice) {
			d.setEnabled(false);
		}
	}

	/**
	 * Disable field buttons.
	 */
	private void deactivateFieldButtons() {
		for (Field f : fields) {
			f.setEnabled(false);
		}
	}

	/**
	 * Activate field buttons, if they are not supposed to stay deactivated.
	 */
	private void activateFieldButtons() {
		for (Field f : this.fields) {
			if (!f.isDisabled())
				f.setEnabled(true);
		}
	}

	/**
	 * Increment roll counters.
	 */
	private void incrementRollCounter() {
		if (this.rollCounter == 1) {
			this.rollCounter--;
			this.deactivateRollButton();
		} else {
			this.rollCounter--;
		}
	}

	/**
	 * Increment round counters.
	 * If this was the last round the game is over.
	 */
	private void incrementRoundCounters() {
		if (this.roundCounter < 13) {
			this.roundCounter++;
			this.rollCounter = 3;
		} else {
			this.isStillRunning = false;
		}

	}

	/**
	 * Disable roll button.
	 */
	private void deactivateRollButton() {
		this.rollButton.setEnabled(false);
	}

	/**
	 * Enable roll button.
	 */
	private void activateRollButton() {
		this.rollButton.setEnabled(true);
	}

	/**
	 * Return whether the game is still running.
	 *
	 * @return true, if game is still running, otherwise false
	 */
	public boolean isStillRunning() {
		return this.isStillRunning;
	}

}
