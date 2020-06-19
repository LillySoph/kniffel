package logic;

import javax.swing.*;

public class Field extends JButton {

    private int points;
    private FieldType fieldType;

    // creates empty field button of given type
    public Field(FieldType fieldType) {
        this.fieldType = fieldType;
        // field is empty
        this.points = -1;
    }

    public int getPoints() { return this.points; }

    // calculates points depending on given dices & field type and updates button text
    public void updatePoints(Dice[] dices) {

        // field was zero before or is no being set to zero
        if(points >= 0) {
            this.points = 0;
            this.setText(toString());
            return;
        }
        // otherwise calculate points
        switch(this.fieldType) {
            case Aces:
                this.points = calculatePointsForFirstBlock(dices, 1);
                break;
            case Twos:
                this.points = calculatePointsForFirstBlock(dices, 2);
                break;
            case Threes:
                this.points = calculatePointsForFirstBlock(dices, 3);
                break;
            case Fours:
                this.points = calculatePointsForFirstBlock(dices, 4);
                break;
            case Fives:
                this.points = calculatePointsForFirstBlock(dices, 5);
                break;
            case Sixes:
                this.points = calculatePointsForFirstBlock(dices, 6);
                break;
            case ThreeOfOneKind:
                this.points = calculatePointsforNOfAKind(dices, 3);
                break;
            case FourOfOneKind:
                this.points = calculatePointsforNOfAKind(dices, 4);
                break;
            case Kniffel:
                this.points = calculatePointsforNOfAKind(dices, 5);
                break;
            case FullHouse:
                this.points = calculatePointsforFullHouse(dices);
                break;
            case SmallStraight:
                this.points = calculatePointsforStraight(dices, 4);
                break;
            case LargeStraight:
                this.points = calculatePointsforStraight(dices, 5);
                break;
            default:
                this.points = calculatePointsforChance(dices);
        }

        // update button text
        this.setText(toString());
    }

    public String toString() { return this.points + "";}

    // calculates and returns points for Aces, Twos, Threes, Fours, Fives and Sixes
    private int calculatePointsForFirstBlock(Dice[] dices, int n) {
        int result = 0;
        for(int i=0; i<dices.length; i++) {
            if(dices[i].getValue() == n)
                result += n;
        }
        return result;
    }

    // calculates and returns points for ThreeOfAKind, FourOfAKind and Kniffel
    private int calculatePointsforNOfAKind(Dice[] dices, int n) {
        int counter = 0;
        int sum = 0;
        for(int i=0; i<dices.length; i++) {
            if(dices[i].getValue() == n)
                counter++;
            sum += dices[i].getValue();
        }
        if(counter < n)
            return 0;
        else if(this.fieldType == FieldType.Kniffel)
            return 50;
        else
            return sum;
    }

    // calculates and returns points for FullHouse
    private int calculatePointsforFullHouse(Dice[] dices) {
        boolean found3OfAKind = false;
        int counter3 = 0;
        int num3 = 1;
        while(!found3OfAKind && num3 <= 6) {
            for (int i = 0; i < dices.length; i++) {
                if (dices[i].getValue() == num3)
                    counter3++;
            }
            if(counter3 == 3)
                found3OfAKind = true;
        }
        boolean found4OfAKind = false;
        int counter4 = 0;
        int num4 = 1;
        while(!found4OfAKind && num4 <= 6) {
            for (int i = 0; i < dices.length; i++) {
                if (dices[i].getValue() == num4)
                    counter4++;
            }
            if (counter4 == 3)
                found4OfAKind = true;
        }
        if(found3OfAKind == true && found4OfAKind == true && num3 != num4)
            return 25;
        else
            return 0;
    }

    // calculates and returns points for SmalLStraight and LargeStraight
    private int calculatePointsforStraight(Dice[] dices, int nInARow) {
        int points = (nInARow - 1) * 10;
        int start = 1;
        boolean straight = false;
        while(!straight || start == 7 - nInARow) {
            for (int i = 0; i < dices.length; i++) {
                if (dices[i].getValue() == start)
                    start++;
            }
            if (start >= nInARow)
                straight = true;
        }
        if(!straight)
            return 0;
        else
            return points;
    }

    // calculates and returns points for Chance
    private int calculatePointsforChance(Dice[] dices) {
        int result = 0;
        for(int i=0; i<dices.length; i++) {
            result += dices[i].getValue();
        }
        return result;
    }
}
