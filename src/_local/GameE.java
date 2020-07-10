package _local;

import javax.swing.*;

import game.FieldType;

import java.awt.*;
//Problem LargeStraight SmallStraight funktioniert nicht
public class GameE extends JFrame {

	/**
	 * Game manages all game components like dice, fields, text fields, roll button, throws and game rounds
	 */

	public static void main(String[] args) {
		GameE e = new GameE();
		new GameControllerE(e);
		e.setVisible(true);


	}

	/**
	 * Initializes all 5 dice
	 */
	private DiceE dice1 = new DiceE();
	private DiceE dice2 = new DiceE();
	private DiceE dice3 = new DiceE();
	private DiceE dice4 = new DiceE();
	private DiceE dice5 = new DiceE();

	private JButton rollButton = new JButton("Würfeln");
	private int throwsCounter = 3, gameRoundCounter = 1;
	private JTextField throwsRoundText = new JTextField();
	private JTextField gameRoundText = new JTextField();
	private JTextField noteForPlayer = new JTextField("Würfel anklicken bedeutet Würfel behalten.");
	/**
	 * Initializes 13 fields in an array
	 */
	private FieldE[] fields = new FieldE[13];
	private boolean isStillRunning = (this.gameRoundCounter != 13);
	

	/**
	 * Contains all fields with their scores
	 */
	private ScoreCardE scoreCard;
	
	/**
	 * Constructor of game which order all game component in the frame
	 */

	public GameE() {
		super("Willkommen bei Kniffel! ");

		this.setLayout(new GridLayout(1, 2));
		
		//this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/diceIcon.png")));

		// initializes all field buttons
		int i = 0;
		for (FieldType field : FieldType.values()) {
			this.fields[i] = new FieldE(field);
			i++;
		}

		// adds score card to frame
		this.scoreCard = new ScoreCardE(this.fields);
		this.add(scoreCard);

		// to add all components on the right side
		JPanel rightSidePanel = new JPanel();
		rightSidePanel.setLayout(new GridLayout(4, 1));

		// adds throws and game rounds text fields to the panel
		JPanel throwsAndGameRoundsPanel = new JPanel();

		throwsAndGameRoundsPanel.setLayout(new GridLayout(1, 2));
		
		//editing throws round text 
		this.throwsRoundText.setFont(new Font("SansSerif", Font.PLAIN, 16));
		this.throwsRoundText.setHorizontalAlignment(SwingConstants.CENTER);
		this.throwsRoundText.setBorder(null);
		this.throwsRoundText.setEditable(false);
		
		//editing game round text
		this.gameRoundText.setFont(new Font("SansSerif", Font.PLAIN, 16));
		this.gameRoundText.setHorizontalAlignment(SwingConstants.CENTER);
		this.gameRoundText.setBorder(null);
		this.gameRoundText.setEditable(false);
		
		throwsAndGameRoundsPanel.add(this.throwsRoundText);
		throwsAndGameRoundsPanel.add(this.gameRoundText);


		// add roll button to the panel
		JPanel rollPanel = new JPanel();
		rollPanel.setLayout(new FlowLayout());
		
		this.rollButton.setBackground(Color.pink);
		this.rollButton.setFont(new Font("SansSerif", Font.BOLD, 18));
		rollPanel.add(this.rollButton);
		
		// add each dice to the dice panel
		JPanel dicePanel = new JPanel();
		dicePanel.setLayout(new FlowLayout());
		dicePanel.add(this.dice1);
		dicePanel.add(this.dice2);
		dicePanel.add(this.dice3);
		dicePanel.add(this.dice4);
		dicePanel.add(this.dice5);

		// add all panels to one panel
		rightSidePanel.add(throwsAndGameRoundsPanel);
		rightSidePanel.add(rollPanel);
		rightSidePanel.add(dicePanel);
		
	
		this.noteForPlayer.setFont(new Font("SansSerif", Font.ITALIC, 16));
		this.noteForPlayer.setHorizontalAlignment(SwingConstants.CENTER);

		this.noteForPlayer.setBorder(null);
		this.noteForPlayer.setEditable(false);
		rightSidePanel.add(this.noteForPlayer);

		// add panel to the main frame
		this.add(rightSidePanel);

		this.setSize(800, 500);
		this.updateGame();
		// in the beginning all field buttons should be deactivated
		this.deactivateAllFieldButtons();
		// in the beginning all dice should be reset 
		this.resetDiceButtons();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Rolls all dice unless they are not selected or kept
	 */
	public void rollAllDice() {
	
		DiceE [] dice = { dice1, dice2, dice3, dice4, dice5 };
		for (DiceE d : dice) {
			// checks if dice is not selected
			if (!(d.isSelected()) || d.getText().equals("?"))
				d.roll();
		}
		// decrements throws
		this.decrementThrowsCounter();

		// activates fields which is not already selected by user
		this.activateFieldButtons();

		this.updateGame();

	}

	/**
	 * Updates text fields and counters in game
	 */
	private void updateGame() {
		//calculate scores
		this.scoreCard.calculateScoreSums();
		this.deactivateSelectedFieldButton();
	
		// if player has the last throw, you should choose a field
		if (this.throwsCounter == 0) {
			this.throwsRoundText.setText("Bitte wählen Sie ein Feld");
		} else {
			// updates roll rounds and game rounds
			this.throwsRoundText.setText("Würfe: " + this.throwsCounter + "/3");
			this.gameRoundText.setText("Runde: " + this.gameRoundCounter + "/13");
		}
	}

	/**
	 * Enters points and updates game.
	 * 
	 * @param field option chosen by player
	 */
	public void enterPoints(FieldE field) {
		// calculate points
		field.calculateAndStorePoints(this.getDiceButtons());
		// increment game rounds
		this.incrementGameRoundCounter();
		// reset throws
		this.resetThrowsCounter();
		// update graphic user interface
		this.updateGame();
		// reset dice buttons for new round
		this.resetDiceButtons();
		// deactivate field buttons so that player cannot chose anything before having
		// rolled at least once
		this.deactivateAllFieldButtons();

		this.activateRollButton();
	}

	/**
	 * Returns roll button.
	 * 
	 */
	public JButton getRollButton() {
		return this.rollButton;
	}

	/**
	 * Returns dice buttons in an array.
	 * 
	 */
	public DiceE[] getDiceButtons() {
		return new DiceE[] { dice1, dice2, dice3, dice4, dice5 };
	}

	/**
	 * Returns field buttons.
	 * 
	 */
	public FieldE[] getFieldButtons() {
		return this.fields;
	}
	
	public int getGameRoundCounter() {
		return this.gameRoundCounter;
	}

	/**
	 * Increments game rounds and resets throws The Game has usually 13 rounds.
	 */

	private void incrementGameRoundCounter() {
		if (this.gameRoundCounter < 13) {
			// next round
			this.gameRoundCounter++;
		} else {
			// rounds are finished, deactivate all buttons
			this.gameRoundCounter++;
			this.settingsForEndOfGame();
		}

		this.resetThrowsCounter();
	}

	/**
	 * If game is finished after 13 rounds, deactivate all buttons and message
	 * player that the game is over
	 */
	public void settingsForEndOfGame() {
		this.deactivateAllDiceButton();
		this.noteForPlayer.setText("Das Spiel ist vorbei. Auf Wiedersehen!");
		this.noteForPlayer.setEditable(false);
		this.isStillRunning = false;
	}

	/**
	 * Decrements throws, starting from 3 and ends to 1
	 */

	private void decrementThrowsCounter() {
		if (this.throwsCounter == 1) {
			this.throwsCounter--;
			// after 3 throws is deactivated
			this.deactivateRollButton();
		} else {
			this.throwsCounter--;
		}
	}

	/**
	 * Resets throws to 3 after round is finished
	 */

	private void resetThrowsCounter() {
		this.throwsCounter = 3;
	}

	/**
	 * Resets dice buttons for a new round with content "?"
	 */
	public void resetDiceButtons() {
		DiceE[] dice = { dice1, dice2, dice3, dice4, dice5 };
		for (DiceE d : dice) {
			d.setSelected(false);
			d.setText("?");
		}
	}

	/**
	 * Activates field buttons unless those which is set on zero or is selected
	 * before
	 */
	private void activateFieldButtons() {
		for (FieldE f : this.fields) {
			// only activate fields which is not set on zero or is selected before
			if ((f.isDisabled() || f.isSelected()))
				f.setEnabled(false);

			f.setEnabled(true);
		}
	}

	/**
	 * Deactivates all fields after the end of game
	 */
	private void deactivateAllFieldButtons() {
		for (FieldE f : this.fields) {
			f.setEnabled(false);
		}
	}

	/**
	 * After player selected a field, it will be deactivated so it is not possible
	 * to select it again
	 */
	private void deactivateSelectedFieldButton() {
		for (FieldE f : this.fields) {
			if (f.isSelected() || f.getPoints() > 0 || f.isDisabled()) {
				f.setEnabled(false);
			}
		}
	}

	/**
	 * Deactivates all dice after the end of game
	 */
	private void deactivateAllDiceButton() {
		DiceE[] dice = { dice1, dice2, dice3, dice4, dice5 };
		for (DiceE d : dice) {
			d.setEnabled(false);
		}
	}

	/**
	 * Deactivates roll button.
	 */
	public void deactivateRollButton() {
		this.rollButton.setEnabled(false);
	}

	/**
	 * Activates roll button.
	 */
	private void activateRollButton() {
		this.rollButton.setEnabled(true);
	}

	/**
	 * Returns whether the game is still running.
	 * 
	 * @return true, if game is still running without finishing the rounds,
	 *         otherwise false
	 */
	public boolean isStillRunning() {
		return this.isStillRunning;
	}

}
