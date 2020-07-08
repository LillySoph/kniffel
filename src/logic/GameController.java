package logic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameController implements ActionListener {

    private Game game;

    public GameController(Game game) {
		this.game = game;

		// get buttons from game and initialize action listeners
		game.getRollButton().addActionListener(this);
		Dice dice[] = game.getDiceButtons();
		Field fields[] = game.getFieldButtons();
		for(int i = 0; i < dice.length; i++) {
			dice[i].addActionListener(this);
		}
		for(int i = 0; i < fields.length; i++) {
			fields[i].addActionListener(this);
		}

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
									"Das Spiel läuft noch. Möchten Sie sicher beenden?", "Spiel läuft noch!",
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

    @Override
    public void actionPerformed(ActionEvent e) {
    	Object source = e.getSource();
    	// button clicked was field
		if(source instanceof Field) {
			this.game.enterPoints((Field) e.getSource());
			System.out.println("Enter points! ");
		}
    	// button clicked was dice
    	else if(source instanceof Dice) {
			System.out.println("Keep dice (or not)! ");
		}
		// button clicked was roll button
		else if(source instanceof JButton) {
			this.game.rollDice();
			System.out.println("Roll dice! ");
		}
		System.out.println("    | dice width: " + game.getDiceButtons()[0].getWidth() + "   dice height: " + game.getDiceButtons()[0].getHeight());
		System.out.println("    | dice x: " + game.getDiceButtons()[0].getX() + "   dice y: " + game.getDiceButtons()[0].getY());
    }
}
