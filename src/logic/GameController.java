package logic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements ActionListener {

    private Game game;
    
    /**
     * Konstruktor
     * @author prett
     */
    public GameController() {
    	
    	/**
    	 * "Würfeln" als ActionListener eingetragen
    	 * @author prett
    	 */
    	game.getRollButton().addActionListener(this);
    	
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	// button clicked was roll button
    	if(e.getSource() == game.getRollButton()) {
    		game.rollDices();
    	}
    	// button clicked was dice button
    	else if(e.getSource() instanceof Dice) {
    		((Dice) e.getSource()).changeKeepDice();
		}
		// button clicked was field button
		else if(e.getSource() instanceof Field) {
			game.updateScore(e.getSource());
		}

    }

	
}
