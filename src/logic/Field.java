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

    // calculates and returns points depending on given dices & field type
    public int returnPoints(Dice[] dices) {
        int result;
        // field is or is being set to zero
        if(points >= 0)
            return 0;
        // calculate points
        if(this.fieldType == FieldType.ThreeOfOneKind || this.fieldType == FieldType.FourOfOneKind || this.fieldType == FieldType.Kniffel)
            result = returnPointsforNOfAKind(dices);
        else if(this.fieldType == FieldType.FullHouse)
            result = returnPointsforFullHouse(dices);
        else if(this.fieldType == FieldType.SmallStraight || this.fieldType == FieldType.LargeStraight)
            result = returnPointsforStraight(dices);
        else if(this.fieldType == FieldType.Chance)
            result = returnPointsforChance(dices);
        else
            result = returnPointsForFirstBlock(dices);
        // return calculated points
        return result;
    }

    // calculates and returns points for Aces, Twos, Threes, Fours, Fives and Sixes
    private int returnPointsForFirstBlock(Dice[] dices) {
        int n = 0;
        switch(this.fieldType) {
            case Aces:
                n = 1;
            case Twos:
                n = 2;
            case Threes:
                n = 3;
            case Fours:
                n = 4;
            case Fives:
                n = 5;
            case Sixes:
                n = 6;
        }
        int result = 0;
        for(int i=0; i<dices.length; i++) {
            if(dices[i].getValue() == n)
                result += n;
        }
        return result;
    }

    // calculates and returns points for ThreOfAKind, FourOfAKind and Kniffel
    private int returnPointsforNOfAKind(Dice[] dices) {
        int n = 0;
        switch(this.fieldType) {
            case ThreeOfOneKind:
                n = 1;
            case FourOfOneKind:
                n = 2;
            case Kniffel:
                n = 5;
        }
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
    private int returnPointsforFullHouse(Dice[] dices) {
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
    private int returnPointsforStraight(Dice[] dices) {
        int nInARow, points;
        if(this.fieldType == FieldType.SmallStraight) {
            nInARow = 4;
            points = 30;
        } else {
            nInARow = 5;
            points = 40;
        }
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
    private int returnPointsforChance(Dice[] dices) {
        int result = 0;
        for(int i=0; i<dices.length; i++) {
            result += dices[i].getValue();
        }
        return result;
    }
}
