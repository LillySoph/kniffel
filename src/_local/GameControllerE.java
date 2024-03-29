package _local;

import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameControllerE implements ActionListener {

	private GameE game;

	/**
	 * Game Controller is the connection between game and ActionListener,  roll and
	 * field button(s) are registered as ActionListener and pass information to the
	 * action event if they are clicked
	 * 
	 * @param game
	 */
	public GameControllerE(GameE game) {
		this.game = game;

		// register rollButton as ActionListener
		this.game.getRollButton().addActionListener(this);

		// initialize field array buttons with all fields from game
		FieldE fields[] = game.getFieldButtons();
		
		// register all fields as ActionListener
		for (int i = 0; i < fields.length; i++) {
			fields[i].addActionListener(this);
		}

		// register game as WindowListener
		game.addWindowListener(
				// window adapter implements all methods from windowListener Interfaces
				new WindowAdapter() {
					// send messages to client just in case if client would like to exit the game
					@Override
					public void windowClosing(WindowEvent e) {
						// Creating array of data type Object, adding the options
						Object[] options = { "Ja, beenden", "Nein, weiterspielen" };

						if (game.isStillRunning()) {
							// show warning and note which option was clicked
							int dialogButton = JOptionPane.showOptionDialog(game,
									"Das Spiel läuft noch. Möchten Sie sicher beenden?", "Warnung",
									JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

							if (dialogButton == JOptionPane.YES_OPTION) {
								// yes option was clicked
								System.exit(0);
							} else {
								// no option was clicked
								// close JOption Pane window and continue the game
								game.setDefaultCloseOperation(game.DO_NOTHING_ON_CLOSE);
							}
						} else {
							// game is over close window
							System.exit(0);
						}
					}
				});

	}

	/**
	 * Action Event object knows all information from the ActionListeners
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// rollButton was clicked
		if (e.getSource() == this.game.getRollButton()) {
				// roll all dice
				this.game.rollAllDice();
			
			// field was clicked
		} else if (e.getSource() instanceof FieldE) {
			this.game.enterPoints((FieldE) e.getSource());
		}
	
	}

}
