package logic;


import javax.swing.*;
import java.awt.*;

public class ScoreCard extends JPanel {

    private static final int ROWS = 17;
    private static final int COLUMNS = 2;

    private Field fields[];
    private JTextField bonus = new ScoreField(), sumUpper = new ScoreField(), sumLower = new ScoreField(), sumOverall = new ScoreField();

    ScoreCard(Field fields[]) {
        super(new GridLayout(ROWS, COLUMNS));
        this.fields = fields;

        // initialize field buttons
        int i = 0;
        for(FieldType ft : FieldType.values()) {
            fields[i] = new Field(ft);
            i++;
        }

        JComponent firstColumn[] = {new JTextField("Einser"), new JTextField("Zweier"), new JTextField("Dreier"), new JTextField("Vierer"), new JTextField("Fünfer"), new JTextField("Sechser"), new JTextField("Bonus"), new JTextField("Gesamt Oben"), new JTextField("Dreierpasch"), new JTextField("Viererpasch"), new JTextField("Full-House"), new JTextField("Kleine Straße"), new JTextField("Große Straße"), new JTextField("Kniffel"), new JTextField("Chance"), new JTextField("Gesamt Unten"), new JTextField("Gesamt")};
        JComponent secondColumn[] = {fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], bonus, sumUpper, fields[6], fields[7], fields[8], fields[9], fields[10], fields[11], fields[12], sumLower, sumOverall};
        //JComponent thirdColumn[];

        // add text fields and buttons to layout
        for(i = 0; i < ROWS; i++) {
            this.add(firstColumn[i]);
            this.add(secondColumn[i]);
        }
    }

    public void updateScore() {

    }

}
