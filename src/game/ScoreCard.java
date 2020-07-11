package game;

import javax.swing.*;
import javax.swing.border.LineBorder;
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

        // initialize field buttons with central alignment
        int i = 0;
        for (FieldType ft : FieldType.values()) {
            this.fields[i] = new Field(ft);
            this.fields[i].setHorizontalAlignment(SwingConstants.CENTER);
            i++;
        }

        // set text alignment for text fields as center
        bonusTextField.setHorizontalAlignment(SwingConstants.CENTER);
        sumUpperTextField.setHorizontalAlignment(SwingConstants.CENTER);
        sumLowerTextField.setHorizontalAlignment(SwingConstants.CENTER);
        sumOverallTextField.setHorizontalAlignment(SwingConstants.CENTER);

        JTextField[] firstColumn = {new JTextField(" Einser"), new JTextField(" Zweier"), new JTextField(" Dreier"), new JTextField(" Vierer"), new JTextField(" Fünfer"), new JTextField(" Sechser"), new JTextField(" Bonus"), new JTextField(" Gesamt Oben"), new JTextField(" Dreierpasch"), new JTextField(" Viererpasch"), new JTextField(" Full-House"), new JTextField(" Kleine Straße"), new JTextField(" Große Straße"), new JTextField(" Kniffel"), new JTextField(" Chance"), new JTextField(" Gesamt Unten"), new JTextField(" Gesamt")};
        JComponent[] secondColumn = new JComponent[]{fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], bonusTextField, sumUpperTextField, fields[6], fields[7], fields[8], fields[9], fields[10], fields[11], fields[12], sumLowerTextField, sumOverallTextField};
        updateTextFields();

        // add text fields and buttons to layout and set its font type and size
        for(i = 0; i < ROWS; i++) {
            firstColumn[i].setFont(new Font("SansSerif", Font.PLAIN, 18));
            firstColumn[i].setBorder(new LineBorder(Color.LIGHT_GRAY, 1, false));

            secondColumn[i].setFont(new Font("SansSerif", Font.PLAIN, 18));
            secondColumn[i].setBorder(new LineBorder(Color.LIGHT_GRAY, 1, false));
            firstColumn[i].setEditable(false);
            this.add(firstColumn[i]);
            this.add(secondColumn[i]);
        }
    }

    /**
     * Calculate upper, lower and overall score sum
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
     * update text fields of upper, lower and overall score sum as well as of bonus
     */
    private void updateTextFields() {
        bonusTextField.setText("" + bonus);
        sumUpperTextField.setText("" + sumUpper);
        sumLowerTextField.setText("" + sumLower);
        sumOverallTextField.setText("" + sumOverall);
    }

    // FOR TESTING //

    /**
     * Helper Method for JUnit tests to test if sum and bonus are calculated correctly
     * @param points
     */
    public void testCalculateScoreSums(int[] points) {
        for(int i = 0; i < fields.length; i++) {
            fields[i].setPoints(points[i]);
        }
        calculateScoreSums();
    }

    /**
     * Get overall sum for JUnit test
     * @return
     */
    public int getSumOverall() {
        return this.sumOverall;
    }

    /**
     * Get sum of first block for JUnit test
     * @return
     */
    public int getSumUpper() {
        return this.sumUpper;
    }

    /**
     * Get sum of second block for JUnit test
     * @return
     */
    public int getSumLower() {
        return this.sumLower;
    }

    /**
     * Get bonus for JUnit test
     * @return
     */
    public int getBonus() {
        return this.bonus;
    }

    /**
     * Get fields for testing
     * @return
     */
    public Field[] getFields() {
        return fields;
    }

    /**
     * set fields for testing
     * @param fields
     */
    public void setFields(Field[] fields) {
        this.fields = fields;
    }
}
