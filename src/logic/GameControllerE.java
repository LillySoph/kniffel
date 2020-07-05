package logic;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameControllerE implements ActionListener {

	private GameE game;
	
	public GameControllerE(GameE game) {
		this.game = game;
		
		//register rollButton as ActionListener
		this.game.getRollButton().addActionListener(this);
		
		//initialize dice array with all dice from game
		Dice dice[] = game.getDiceButtons();
		
		//initialize field array with all fields from game
		 Field fields[] = game.getFieldButtons();
		
		//register all dice as ActionListener
		for(int i = 0; i < dice.length; i++) {
			dice[i].addActionListener(this);
		}
		
		//register all fields as ActionListener
		for(int i = 0; i < fields.length; i++) {
			fields[i].addActionListener(this);
		}
		
		//register game as WindowListener
		game.addWindowListener(
		//window adapter implements all methods from windowListener Interfaces
				new WindowAdapter(){
					//send messages to client just in case if client would like to exit the game 
					@Override
					public void windowClosing(WindowEvent e) {
						// Creating array of data type Object, adding the options	
						Object[] options = {"Nein, weiterspielen", "Ja, beenden"};
						if(game.isStillRunning()) {
							JOptionPane.showOptionDialog(game, "Das Spiel läuft noch. Möchten Sie sicher beenden?", "Warnung", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
									null, options, options[0]);
						} else {
							
							System.exit(0);
						}
					}
				}
		);
		
		
	}
	/**
	 * Action Event object knows all information from the ActionListeners
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	
		//rollButton was clicked
		if(e.getSource() == this.game.getRollButton()) {
			//roll all dice
			this.game.rollAllDice();
			
			//field was clicked
		}else if(e.getSource() instanceof Field) {
			this.game.enterPoints((Field)e.getSource());
			System.out.println("Enter Points");
		}
	}

}
