package game;

import javax.swing.*;

public class Field extends JButton {

    private int points;
    private FieldType fieldType;
    private boolean isEmpty;
    private boolean isDisabled;

    /**
     * Creates empty field button of given type
     * @param fieldType
     */
    public Field(FieldType fieldType) {
        this.fieldType = fieldType;
        this.points = 0;
        // no points have been entered
        this.isEmpty = true;
        this.setSize(85,30);
    }

    public void setPoints(int points) {
        this.points = points;
    }

    /**
     *  Resets field to be an empty field, for testing
     */
    public void resetPoints() {
        this.isEmpty = true;
    }

    /**
     * Returns stored points
     * @return
     */
    public int getPoints() {
        return this.points;
    }

    /**
     * Calculates points depending on given dice & field type and updates button and text
     * @param dice
     */
    public void calculateAndStorePoints(Dice[] dice) {

        // field was zero before or is now being set to zero
        if (!(this.isEmpty)) {
            this.points = 0;
        } else {
            // otherwise calculate points depending on field type
            switch (this.fieldType) {
                case Aces:
                    this.points = calculatePointsForFirstBlock(dice, 1);
                    break;
                case Twos:
                    this.points = calculatePointsForFirstBlock(dice, 2);
                    break;
                case Threes:
                    this.points = calculatePointsForFirstBlock(dice, 3);
                    break;
                case Fours:
                    this.points = calculatePointsForFirstBlock(dice, 4);
                    break;
                case Fives:
                    this.points = calculatePointsForFirstBlock(dice, 5);
                    break;
                case Sixes:
                    this.points = calculatePointsForFirstBlock(dice, 6);
                    break;
                case ThreeOfOneKind:
                    this.points = calculatePointsOfAKind(dice, 3);
                    break;
                case FourOfOneKind:
                    this.points = calculatePointsOfAKind(dice, 4);
                    break;
                case Kniffel:
                    this.points = calculatePointsOfAKind(dice, 5);
                    break;
                case FullHouse:
                    this.points = calculatePointsForFullHouse(dice);
                    break;
                case SmallStraight:
                    this.points = calculatePointsForSmallStraight(dice);
                    break;
                case LargeStraight:
                    this.points = calculatePointsForLargeStraight(dice);
                    break;
                default:
                    this.points = calculatePointsForChance(dice);
            }
            //set false for not resetting the field
            this.isEmpty = false;
        }
        // update button text
        this.setText(toString());
        // disable field after it has been zeroed
        if (this.isEmpty || this.points == 0)
            this.isDisabled = true;

    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public String toString() {
        return this.points + "";
    }

    /**
     * Calculates and returns points for Aces, Twos, Threes, Fours, Fives and Sixes
     *
     * @param dice
     * @param n     , number of dice value regarding to field type
     * @return sum of dice with appropriate field type
     */
    private int calculatePointsForFirstBlock(Dice[] dice, int n) {
        int result = 0;
        for (int i = 0; i < dice.length; i++) {
            if (dice[i].getValue() == n)
                result += n;
        }
        return result;
    }

    /**
     * Uses one dice to compare its value with other four dice values
     *
     * @param dice
     * @param nInARow , number of numbers in a row
     * @return points for ThreeOfAKind(sum of all dice), FourOfAKind (sum of all
     *         dice) and Kniffel(50)
     */
    private int calculatePointsOfAKind(Dice[] dice, int nInARow) {
        int counter = 1, result = 0, i = 0;
        boolean foundNumbersInARow = false;

        while (!foundNumbersInARow && i < dice.length) {

            for (int j = i + 1; j <= dice.length - 1; j++) {
                if (dice[i].getValue() == dice[j].getValue()) {
                    counter++;
                }
                if (counter == nInARow) {
                    foundNumbersInARow = true;
                }
            }
            // start with next index of dice
            counter = 1;
            i++;
        }

        // calculates points
        if (foundNumbersInARow) {
            if (this.fieldType == FieldType.Kniffel) {
                return 50;
            } else {
                for (i = 0; i < dice.length; i++) {
                    result += dice[i].getValue();
                }
                return result;
            }
        } else {
            // condition failed
            return 0;
        }

    }

    /**
     * Uses one dice to compare its value with other four dice values
     *
     * @param dice
     * @return 25 points if three of one number and two of another number exist in a
     *         row
     */
    private int calculatePointsForFullHouse(Dice[] dice) {
        boolean foundThreeOfARow = false;
        boolean foundTwoOfARow = false;
        int valueOfThreeNumbersInARow = 0;

        int counter = 1, i = 0;

        // first check if there are three of one number in a row
        while (!foundThreeOfARow && i < dice.length) {

            for (int j = i + 1; j <= dice.length - 1; j++) {
                if (dice[i].getValue() == dice[j].getValue()) {
                    counter++;
                }
                // counter checks if three of one number are in the row
                if (counter == 3) {
                    // save value of dice because it appears three times
                    valueOfThreeNumbersInARow = dice[i].getValue();
                    foundThreeOfARow = true;
                }
            }
            // reset counter and restart
            counter = 1;
            i++;
        }

        // checks if there are two of another number in a row
        if (foundThreeOfARow) {

            i = 0;
            counter = 1;
            while (!foundTwoOfARow && i < dice.length) {

                // dice value in two row should be another number
                for (int j = i + 1; j <= dice.length - 1 && dice[i].getValue() != valueOfThreeNumbersInARow; j++) {
                    if (dice[i].getValue() == dice[j].getValue()) {
                        counter++;
                    }

                    // counter checks if two of another number are in the row
                    if (counter == 2) {
                        foundTwoOfARow = true;
                    }
                }
                // reset counter and restart
                counter = 1;
                i++;
            }

        }

        if (foundTwoOfARow && foundThreeOfARow) {
            return 25;
        } else {
            return 0;
        }

    }

    /**
     * Calculates points for small straight
     *
     * @param dice
     * @return 30 points if condition fulfilled or 0 if not
     */
    private int calculatePointsForSmallStraight(Dice[] dice) {

        boolean isSmallStraight = false;

        boolean isNotASmallStraight = false;

        // counts the frequency of the numbers 3 and 4
        int counterOfThree = 0, counterOfFour = 0;

        // All small straight combinations have numbers like 3 and 4 in common
        // checks if any dice has the number 3 and 4 and
        for (int i = 0; i < dice.length; i++) {
            if (dice[i].getValue() == 3) {
                counterOfThree++;
            }

            if (dice[i].getValue() == 4) {
                counterOfFour++;
            }
        }

        // checks so that 3 and 4 appear more than twice or never
        // only one duplicate of 3 or 4 is possible
        if (counterOfThree >= 2 && counterOfFour >= 2 || counterOfThree > 2 && counterOfFour < 2
                || counterOfThree < 2 && counterOfFour > 2 || counterOfThree == 0 || counterOfFour == 0) {
            isNotASmallStraight = true;
        }

        if (!isNotASmallStraight) {

            // counts frequency rest of the numbers
            int counterOfOne = 0, counterOfTwo = 0, counterOfFive = 0, counterOfSix = 0;

            // checks if dice has other numbers than 3 and 4
            for (int i = 0; i < dice.length && (dice[i].getValue() != 3 || dice[i].getValue() != 4)
                    && (!isSmallStraight); i++) {

                if (dice[i].getValue() == 1) {
                    counterOfOne++;
                }

                if (dice[i].getValue() == 2) {
                    counterOfTwo++;
                }

                if (dice[i].getValue() == 5) {
                    counterOfFive++;
                }

                if (dice[i].getValue() == 6) {
                    counterOfSix++;
                }
            }
            // either 1-2 or 1-1-2 or 1-2-2 is possible
            if (counterOfOne == 1 && counterOfTwo == 1 || counterOfOne == 2 && counterOfTwo == 1
                    || counterOfOne == 1 && counterOfTwo == 2) {
                isSmallStraight = true;
            }
            // either 2-5 or 2-2-5 or 2-5-5
            if (counterOfTwo == 1 && counterOfFive == 1 || counterOfTwo == 2 && counterOfFive == 1
                    || counterOfTwo == 1 && counterOfFive == 2) {
                isSmallStraight = true;
            }
            // either 5-6 or 5-5-6 or 5-6-6
            if (counterOfFive == 1 && counterOfSix == 1 || counterOfFive == 2 && counterOfSix == 1
                    || counterOfFive == 1 && counterOfSix == 2) {
                isSmallStraight = true;
            }

            if (isSmallStraight) {
                return 30;

            }

        }
        // condition failed
        return 0;
    }

    /**
     * Calculates points for large straight
     * @param dice
     * @return 40 if condition is fulfilled or 0 if not
     */
    private int calculatePointsForLargeStraight(Dice[] dice) {

        boolean isLargeStraight = false;
        boolean isNotLargeStraight = false;

        // All small straight combinations have numbers like 2,3,4 and 5 common
        // counts the frequency of the numbers 2, 3, 4 and 5
        int counterOfTwo = 0, counterOfThree = 0, counterOfFour = 0, counterOfFive = 0;

        // checks if any dice has the number 2,3,4 and 5
        for (int i = 0; i < dice.length; i++) {

            if (dice[i].getValue() == 2) {
                counterOfTwo++;
            }
            if (dice[i].getValue() == 3) {
                counterOfThree++;
            }

            if (dice[i].getValue() == 4) {
                counterOfFour++;
            }

            if (dice[i].getValue() == 5) {
                counterOfFive++;
            }
        }

        // checks if none of these combination appear or one number appears often
        if (counterOfTwo != 1 || counterOfThree != 1 || counterOfFour != 1 || counterOfFive != 1) {
            isNotLargeStraight = true;
        }

        if (!isNotLargeStraight) {

            // checks if dice has numbers either 1 or 6
            for (int i = 0; i < dice.length && (dice[i].getValue() != 2 || dice[i].getValue() != 3
                    || dice[i].getValue() != 4 || dice[i].getValue() != 5) && (!isLargeStraight); i++) {

                if (dice[i].getValue() == 1 || dice[i].getValue() == 6) {
                    isLargeStraight = true;
                }
            }

            if (isLargeStraight) {
                return 40;
            }
        }
        return 0;

    }
    
    /**
     * Calculates and returns points for Chance
     *
     * @param dices
     * @return sum of all values of dice
     */
    private int calculatePointsForChance(Dice[] dices) {
        int result = 0;
        for (int i = 0; i < dices.length; i++) {
            result += dices[i].getValue();
        }
        return result;
    }
}
