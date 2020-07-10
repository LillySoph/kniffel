package game;

import javax.swing.*;
import java.awt.*;

public class ScoreCard extends JPanel {

    private static final int ROWS = 17;
    private static final int COLUMNS = 2;

    private Field[] fields;
    private int bonus = 0;
    private int sumUpper = 0;
    private int sumLower = 0;
    private int sumOverall = 0;
    private JTextField bonusTextField = new JTextField(), sumUpperTextField = new JTextField(),
            sumLowerTextField = new JTextField(), sumOverallTextField = new JTextField();

    public ScoreCard(Field fields[]) {
        super(new GridLayout(ROWS, COLUMNS));
        this.fields = fields;

        // initialize field buttons
        int i = 0;
        for (FieldType ft : FieldType.values()) {
            this.fields[i] = new Field(ft);
            this.fields[i].setHorizontalAlignment(SwingConstants.CENTER);
            i++;
        }

        bonusTextField.setHorizontalAlignment(SwingConstants.CENTER);
        sumUpperTextField.setHorizontalAlignment(SwingConstants.CENTER);
        sumLowerTextField.setHorizontalAlignment(SwingConstants.CENTER);
        sumOverallTextField.setHorizontalAlignment(SwingConstants.CENTER);

        JTextField[] firstColumn = {new JTextField(" Einser"), new JTextField(" Zweier"), new JTextField(" Dreier"), new JTextField(" Vierer"), new JTextField(" Fünfer"), new JTextField(" Sechser"), new JTextField(" Bonus"), new JTextField(" Gesamt Oben"), new JTextField(" Dreierpasch"), new JTextField(" Viererpasch"), new JTextField(" Full-House"), new JTextField(" Kleine Straße"), new JTextField(" Große Straße"), new JTextField(" Kniffel"), new JTextField(" Chance"), new JTextField(" Gesamt Unten"), new JTextField(" Gesamt")};
        JComponent[] secondColumn = new JComponent[]{fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], bonusTextField, sumUpperTextField, fields[6], fields[7], fields[8], fields[9], fields[10], fields[11], fields[12], sumLowerTextField, sumOverallTextField};
        updateTextFields();

        // add text fields and buttons to layout
        for(i = 0; i < ROWS; i++) {
            firstColumn[i].setFont(new Font("SansSerif", Font.PLAIN, 18));
            secondColumn[i].setFont(new Font("SansSerif", Font.PLAIN, 18));
            firstColumn[i].setEditable(false);
            this.add(firstColumn[i]);
            this.add(secondColumn[i]);
        }
    }

    /**
     * Update upper, lower and overall score sum.
     */
    public void calculateScoreSums() {
        // reset old sum
        sumUpper = 0;
        sumLower = 0;
        // calculate new sum and bonus
        for(int i = 0; i < 6; i++) {
            this.sumUpper += fields[i].getPoints();
        }
        if(this.sumUpper >= 63) {
            bonus = 35;
            sumUpper += bonus;
        }
        for(int i = 6; i < 13; i++) {
            this.sumLower += fields[i].getPoints();
        }
        this.sumOverall = this.sumLower + this.sumUpper;
        // update text fields
        updateTextFields();
    }

    /**
     * update text fields of upper, lower and overall score sum.
     */
    private void updateTextFields() {
        bonusTextField.setText("" + bonus);
        sumUpperTextField.setText("" + sumUpper);
        sumLowerTextField.setText("" + sumLower);
        sumOverallTextField.setText("" + sumOverall);
    }

}