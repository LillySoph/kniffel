package logic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameController implements ActionListener {

    private Game game;

    // Constructor
    public GameController() {
    	
    	/**
    	 * "Würfeln" als ActionListener eingetragen
    	 * @author prett
    	 */
    	game.getRollButton().addActionListener(this);

		game.addWindowListener(
				new WindowAdapter(){
					@Override
					public void windowClosing(WindowEvent e) {
						if(game.isActive())
							JOptionPane.showMessageDialog(game, "Das spiel läuft noch. Wollen Sie sicher beenden?");
						else
							System.exit(0);
					}
				}
		);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	// button clicked was roll button
    	if(e.getSource() == game.getRollButton()) {
    		game.rollDice();
    	}
    	// button clicked was dice button
    	//else if(e.getSource() instanceof Dice) {
		//((Dice) e.getSource()).changeKeepDice();
		//}
		// button clicked was field button
		else if(e.getSource() instanceof Field) {
			game.enterPoints((Field) e.getSource());
		}

    }

	
}
