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

    Game() {
        super("Willkommen zu Kniffel! ");

        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/diceicon.png")));

        // setup grid bag layout
        this.setLayout(new GridLayout(1,2));

        // init and add score card
        this.scoreCard = new ScoreCard(fields);
        this.add(scoreCard);

        // init right panel
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(4,1));

        // add counter panel
        JPanel counterPanel = new JPanel();
        counterPanel.setLayout(new FlowLayout());
        this.rollTextField = new JTextField(); this.rollTextField.setEditable(false);
        this.roundTextField = new JTextField(); this.roundTextField.setEditable(false);
        this.rollTextField.setPreferredSize(new Dimension(200,40));
        this.roundTextField.setPreferredSize(new Dimension(200,40));
        counterPanel.add(rollTextField); counterPanel.add(roundTextField);
        rightPanel.add(counterPanel);
        this.rollTextField.setHorizontalAlignment(SwingConstants.CENTER);
        this.rollTextField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        this.rollTextField.setBorder(null);
        this.roundTextField.setHorizontalAlignment(SwingConstants.CENTER);
        this.roundTextField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        this.roundTextField.setBorder(null);

        // add roll panel
        this.rollButton = new JButton("Würfeln");
        this.rollButton.setFont(new Font("SansSerif", Font.BOLD, 28));
        this.rollButton.setBackground(Color.PINK);
        this.rollButton.setPreferredSize(new Dimension(140,50));
        rollButton.setBorder(new LineBorder(Color.BLACK, 3, true));
        this.rollButton.setFocusPainted(false);
        JPanel rollPanel = new JPanel();
        rollPanel.setLayout(new FlowLayout());
        rollPanel.add(rollButton);
        rightPanel.add(rollPanel);

        // add dice panel
        JPanel dicePanel = new JPanel();
        dicePanel.setLayout(new FlowLayout());
        Dice[] dice = getDiceButtons();
        for(Dice d : dice) {
            dicePanel.add(d);
        }
        rightPanel.add(dicePanel);

        // add note panel
        JPanel notePanel = new JPanel();
        notePanel.setLayout(new FlowLayout());
        this.noteForPlayer = new JTextField("Würfel auswählen bedeutet Würfel behalten.");
        noteForPlayer.setFont(new Font("SansSerif", Font.ITALIC, 16));
        this.noteForPlayer.setEditable(false);
        notePanel.add(noteForPlayer);
        rightPanel.add(notePanel);
        noteForPlayer.setHorizontalAlignment(SwingConstants.CENTER);
        noteForPlayer.setAlignmentY(Component.TOP_ALIGNMENT);
        noteForPlayer.setBorder(null);

        rightPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, false));
        this.add(rightPanel);
        this.updateGUI();
        deactivateFieldButtons();

        this.isStillRunning = true;

        this.setSize(900,600);
        this.setLocationRelativeTo(null);

    }

    /**
     * Rolls all dice that are not "kept" by player and increments roll counter.
     */
    public void rollAllDice() {
        Dice[] dice = getDiceButtons();
        for (Dice d : dice) {
            // roll if dice is not kept or is reset
            if (!(d.isSelected()) || d.isReset())
                d.roll();
        }
        // increment roll counter
        incrementRolLCounter();
        // activate field buttons so that player can choose something
        activateFieldButtons();
        updateGUI();
    }

    /**
     * Returns roll button.
     *
     * @return
     */
    public JButton getRollButton() {
        return this.rollButton;
    }

    /**
     * Returns dice buttons.
     *
     * @return
     */
    public Dice[] getDiceButtons() {
        return new Dice[] { dice1, dice2, dice3, dice4, dice5 };
    }

    /**
     * Return field buttons.
     *
     * @return
     */
    public Field[] getFieldButtons() {
        return fields;
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
        incrementRoundCounters();
        rollCounter = 3;
        if(isStillRunning()) {
            scoreCard.calculateScoreSums();
            updateGUI();
            resetDiceButtons();
            deactivateFieldButtons();
            activateRollButton();
        } else {
            gameIsOver();
        }
    }

    /**
     * Deactivate and resets all buttons and display score.
     */
    private void gameIsOver() {
        scoreCard.calculateScoreSums();
        deactivateRollButton();
        for(Dice dice : getDiceButtons()) {
            dice.setEnabled(false);
        }
        this.rollButton.setText("Das Spiel ist vorbei");
        this.rollButton.setPreferredSize(new Dimension(300,50));
        roundTextField.setText("");
        rollTextField.setText("");
        int score = scoreCard.getSumOverall();
        if(score == 275)
            noteForPlayer.setText("Wow, Sie haben mit " + score + " Punkten die volle Punktzahl erreicht!");
        else if(score > 50)
            noteForPlayer.setText("Glückwunsch, Ihre Gesamt-Punktzahl beträgt " + score + "!");
        else
            noteForPlayer.setText("Sie haben " + score + " Punkte erreicht.");
        resetDiceButtons();
        deactivateFieldButtons();
    }

    /**
     * Update text fields and counters in gui.
     */
    private void updateGUI() {
        if (rollCounter == 0) {
            rollTextField.setText("Bitte wählen Sie eine Option");
        } else {
            rollTextField.setText("Noch " + rollCounter + " mal Würfeln");
        }
        roundTextField.setText("Runde " + roundCounter + " von 13");
    }

    /**
     * Reset dice buttons for a new round: [ ]
     */
    private void resetDiceButtons() {
        Dice[] dice = getDiceButtons();
        for (Dice d : dice) {
            d.reset();
        }
    }

    /**
     * Deactivate field buttons.
     */
    private void deactivateFieldButtons() {
        for (Field f : fields) {
            f.setEnabled(false);
        }
    }

    /**
     * Activates field buttons, if they are not supposed to stay deactivated.
     */
    private void activateFieldButtons() {
        for (Field f : fields) {
            if (!f.isDisabled())
                f.setEnabled(true);
        }
    }

    /**
     * Increment roll counters.
     */
    private void incrementRolLCounter() {
        if (rollCounter == 1) {
            rollCounter--;
            deactivateRollButton();
        } else {
            rollCounter--;
        }
    }

    /**
     * Increment round counters.
     */
    private void incrementRoundCounters() {
        if (roundCounter < 13) {
            this.roundCounter++;
            rollCounter = 3;
        } else {
            this.roundCounter = 1;
            isStillRunning = false;
        }

    }

    /**
     * Deactivate roll button.
     */
    private void deactivateRollButton() {
        this.rollButton.setEnabled(false);
    }

    /**
     * Activate roll button.
     */
    private void activateRollButton() {
        this.rollButton.setEnabled(true);
    }

    /**
     * Returns whether the game is still running.
     *
     * @return true, if game is still running, otherwise false
     */
    public boolean isStillRunning() {
        return this.isStillRunning;
    }

}
