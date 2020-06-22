package logic;

import javax.swing.*;

public class Field extends JButton {

	//TODO Small Straight &  LargeStraight fehlen noch @author prett
	
	private int points;
	private FieldType fieldType;

	// creates empty field button of given type
	public Field(FieldType fieldType) {
		this.fieldType = fieldType;
		// field is empty
		this.points = -1;
	}

	public void resetPoints() {
		this.points = -1;
	}

	public int getPoints() {
		return this.points;
	}

	// calculates points depending on given dices & field type and updates button
	// text
	public void updatePoints(Dice[] dices) {

		// field was zero before or is now being set to zero
		if (points >= 0) {
			this.points = 0;
			this.setText(toString());
			return;
		}
		// otherwise calculate points
		switch (this.fieldType) {
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
			this.points = calculatePointsOfAKind(dices, 3);
			break;
		case FourOfOneKind:
			this.points = calculatePointsOfAKind(dices, 4);
			break;
		case Kniffel:
			this.points = calculatePointsOfAKind(dices, 5);
			break;
		case FullHouse:
			this.points = calculatePointsForFullHouse(dices);
			break;
		case SmallStraight:
			this.points = calculatePointsForStraight(dices, 4);
			break;
		case LargeStraight:
			this.points = calculatePointsForStraight(dices, 5);
			break;
		default:
			this.points = calculatePointsForChance(dices);
		}

		// update button text
		this.setText(toString());
	}

	public String toString() {
		return this.points + "";
	}

	/**
	 * calculates and returns points for Aces, Twos, Threes, Fours, Fives and Sixes
	 * 
	 * @param dices
	 * @param n     , number of dice value regarding to field type
	 * @return sum of dice with appropriate field type
	 */
	private int calculatePointsForFirstBlock(Dice[] dices, int n) {
		int result = 0;
		for (int i = 0; i < dices.length; i++) {
			if (dices[i].getValue() == n)
				result += n;
		}
		return result;
	}

	/**
	 * Uses one dice to compare its value with other four dice values
	 * 
	 * @param dices
	 * @param nInARow , number of numbers in a row
	 * @return points for ThreeOfAKind(sum of all dice), FourOfAKind (sum of all
	 *         dice) and Kniffel(50)
	 */

	private int calculatePointsOfAKind(Dice[] dices, int nInARow) {
		int counter = 1, sum = 0, i = 0;
		boolean foundNumbersInARow = false;

		while (!foundNumbersInARow && i < dices.length) {

			for (int j = i + 1; j <= dices.length - 1; j++) {
				if (dices[i].getValue() == dices[j].getValue()) {
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
				for (i = 0; i < dices.length; i++) {
					sum += dices[i].getValue();
				}
				return sum;
			}
		} else {
			// condition failed
			return 0;
		}

	}

	// calculates and returns points for FullHouse
	/*
	 * private int calculatePointsForFullHouse(Dice[] dices) { boolean found3OfAKind
	 * = false; int counter3 = 0; int num3 = 1; while (!found3OfAKind && num3 <= 6)
	 * { for (int i = 0; i < dices.length; i++) { if (dices[i].getValue() == num3)
	 * counter3++; } if (counter3 == 3) found3OfAKind = true; } boolean
	 * found4OfAKind = false; int counter4 = 0; int num4 = 1; while (!found4OfAKind
	 * && num4 <= 6) { for (int i = 0; i < dices.length; i++) { if
	 * (dices[i].getValue() == num4) counter4++; } if (counter4 == 3) found4OfAKind
	 * = true; } if (found3OfAKind == true && found4OfAKind == true && num3 != num4)
	 * return 25; else return 0; }
	 */

	/**
	 * Uses one dice to compare its value with other four dice values
	 * 
	 * @param dices
	 * @return 25 points if three of one number and two of another number exist in a
	 *         row
	 */

	private int calculatePointsForFullHouse(Dice[] dices) {
		boolean foundThreeOfARow = false;
		boolean foundTwoOfARow = false;
		int indexOfDiceValueInThreeRow = 0;

		int counter = 1, i = 0;

		// first check if there are three of one number in a row
		while (!foundThreeOfARow && i < dices.length) {

			for (int j = i + 1; j <= dices.length - 1; j++) {
				if (dices[i].getValue() == dices[j].getValue()) {
					counter++;
				}
				if (counter == 3) {
					// save index of dice because its value appears three times
					indexOfDiceValueInThreeRow = i;
					foundThreeOfARow = true;
				}
			}
			counter = 1;
			i++;
		}

		// checks if there are two of another number in a row
		if (foundThreeOfARow) {

			i = 0;
			counter = 1;
			while (!foundTwoOfARow && i < dices.length) {

				for (int j = i + 1; j <= dices.length - 1
						&& dices[i].getValue() != dices[indexOfDiceValueInThreeRow].getValue(); j++) {
					if (dices[i].getValue() == dices[j].getValue()) {
						counter++;
					}

					if (counter == 2) {
						foundTwoOfARow = true;
					}
				}
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
	 * 
	 * @param dices
	 * @param nInARow
	 * @return
	 */
	
	private int calculatePointsForStraight(Dice[] dices, int nInARow) {
		int [] v1 = {1,2,3,4};
		int [] v2 = {2,3,4,5};
		int [] v3 = {3,4,5,6};
		int counter = 1, i = 0;
		boolean conditionSucceed = false;
		
		while(!conditionSucceed && i < dices.length)
			
		for(int j = 0; j < v1.length; j++) {
			if(dices[i].getValue() == v1[j]) {
				counter++;
			}
			
			if(counter == nInARow) {
				conditionSucceed = true;
			}
		}
		counter = 1;
		i++;
		
		
		
		}
		
	}

	// calculates and returns points for SmalLStraight and LargeStraight
/*	private int calculatePointsForStraight(Dice[] dices, int nInARow) {
		int points = (nInARow - 1) * 10;
		int start = 1;
		boolean straight = false;
		while (!straight || start == 7 - nInARow) {
			for (int i = 0; i < dices.length; i++) {
				if (dices[i].getValue() == start)
					start++;
			}
			if (start >= nInARow)
				straight = true;
		}
		if (!straight)
			return 0;
		else
			return points;
	}

	// calculates and returns points for Chance
	private int calculatePointsForChance(Dice[] dices) {
		int result = 0;
		for (int i = 0; i < dices.length; i++) {
			result += dices[i].getValue();
		}
		return result;
	}
}
*/
