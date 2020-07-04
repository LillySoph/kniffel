package logic;

import javax.swing.*;
import java.awt.*;

public class GameE extends JFrame {
	
		//TODO methoden nochmal durchgehen eventuell und eigene mitbringen verbessern 
	//TODO enterPoints stehen geblieben
	/**
	 * Game manages all game components like dice, fields, text fields and so on..
	 */
	
	
	/**
	 * Initializes all 5 dice
	 */
	private Dice dice1 = new Dice();
	private Dice dice2 = new Dice();
	private Dice dice3 = new Dice();
	private Dice dice4 = new Dice();
	private Dice dice5 = new Dice();
	
	private JButton rollButton = new JButton("Würfeln");
	private int rollRoundCounter = 3, gameRoundCounter = 1;
	private JTextField rollRound, gameRound, noteForPlayer;
	/**
	 * Initializes 13 fields in an array 
	 */
	private Field[] fields = new Field[13];
	private boolean isStillRunning = (this.gameRoundCounter != 13);
	
	/**
	 * 
	 */
	private ScoreCard scoreCard;
	
	public GameE() {
		super("Willkommen zu Kniffel! ");
		
		
		/*Text soll nicht verändert werden*/
		//t.setEditable(false);
			
		
		this.setSize(550,550);
		
		
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/** 
	 * Rolls all dice unless they are not selected or kept
	 */
	public void rollAllDice() {
		Dice []dice = {dice1, dice2, dice3, dice4, dice5};
		for(Dice d : dice) {
			//dice is not selected
			if(!(d.isSelected() || d.getText().equals("?"))){
				d.roll();
			}
		}
		//increments roll round counter
		this.incrementRollRoundCounter();
		
		this.updateGame();
		
		//activates fields which is not already selected
		this.activateFieldButtons();
		
	}
	
	/**
	 * Updates text fields and counters in game
	 */
	private void updateGame() {
		scoreCard.calculateScoreSums();
		//if all roll rounds is finished start again
		if (this.rollRoundCounter == 0) {
			this.rollRound.setText("Bitte wählen Sie ein Feld");
		} else {
			//updates roll rounds and game rounds
			this.rollRound.setText("Würfe: " + this.rollRoundCounter + "/3" );
			this.gameRound.setText("Runde: " + this.gameRoundCounter + " / 13");
		}
	}

	
	
	/**
	 * Enters points and updates game.
	 * 
	 * @param field option chosen by player
	 */
	public void enterPoints(Field field) {
		// calculate points
		field.calculateAndStorePoints(new Dice[] { dice1, dice2, dice3, dice4, dice5 });
		//increment game rounds
		this.incrementGameRoundCounter();
		// update graphic user interface
		this.updateGame();
		// reset dice buttons for new round
		this.resetDiceButtons();
		// deactivate field buttons so that player cannot chose anything before having
		// rolled at least once
		this.deactivateAllFieldButton();
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
	public Dice[] getDiceButtons() {
		return new Dice[] { dice1, dice2, dice3, dice4, dice5 };
	}

	/**
	 * Returns field buttons.
	 * 
	 */
	public Field[] getFieldButtons() {
		return this.fields;
	}

	/**
	 * Increments game rounds.
	 * The Game has usually 13 rounds.
	 */
	
	private void incrementGameRoundCounter() {
		if(this.gameRoundCounter < 13) {
			//next round
			this.gameRoundCounter++;
		}else {
			//rounds are finished, deactivate all buttons
			this.deactivateRollButton();
			this.deactivateAllFieldButton();
			this.deactivateAllDiceButton();
			this.noteForPlayer.setText("Das Spiel ist vorbei. Auf Wiedersehen! ");
			this.noteForPlayer.setEditable(false);
			this.isStillRunning = false;
			
		}
		this.resetRollRoundCounter();
	}
	
	
	/**
	 * Increments roll round counter
	 */
	
	private void incrementRollRoundCounter() {
		if(this.rollRoundCounter == 1) {
			this.rollRoundCounter--;
			//after 3 rounds roll button is deactivated
		this.deactivateRollButton();
	}else {
		this.rollRoundCounter--;
	}
	}
	
	/**
	 * Resets roll round counter after round is finished
	 */
	
	private void resetRollRoundCounter() {
		this.rollRoundCounter = 3;
	}
	
	
	/**
	 * Resets dice buttons for a new round with content "?"
	 */
	private void resetDiceButtons() {
		Dice []dice = {dice1, dice2, dice3, dice4, dice5};
		for(Dice d : dice) {
			d.setSelected(false);
			d.setText("?");
		}
	}
	
	/**
	 * Activates field buttons unless those which is set on zero or is selected before
	 */
	private void activateFieldButtons() {
		for(Field f: this.fields) {
			//only activate fields which is not set on zero or is  selected before
			if(!(f.isDisabled() || f.isSelected())) {
				f.setEnabled(true);
			}
		}
	}
	
	/**
	 * Deactivates all fields
	 */
	private void deactivateAllFieldButton() {
		for(Field f: this.fields) {
			f.setEnabled(true);
		}
	}
	
	/**
	 * Deactivates all dice
	 */
	private void deactivateAllDiceButton() {
		Dice []dice = {dice1, dice2, dice3, dice4, dice5};
		for(Dice d: dice) {
			d.setEnabled(true);
		}
	}

	/**
	 * Deactivates roll button.
	 */
	private void deactivateRollButton() {
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
	 * @return true, if game is still running without finishing the rounds, otherwise false
	 */
	public boolean isStillRunning() {
		return this.isStillRunning;
	}

	
	public static void main(String[] args) {
		GameE e = new GameE();
		new GameControllerE(e);
		e.setVisible(true);

	}

}
