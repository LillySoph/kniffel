package logic;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameController implements ActionListener {

	/**
	 * Ich habe den Button "Würfeln" implementiert
	 * @author prett
	 * 
	 */
	private JButton clickRoll;
	
	
	
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
    	clickRoll.addActionListener(this);
    	
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	
    	/**
    	 * Wenn ich würfeln geklickt habe passiert.....
    	 * @author prett
    	 */
    	if(e.getSource() == this.clickRoll) {
    		
    	}

    }

	
}
