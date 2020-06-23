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
				new WindowAdapter(){
					@Override
					public void windowClosing(WindowEvent e) {
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
    }
}
