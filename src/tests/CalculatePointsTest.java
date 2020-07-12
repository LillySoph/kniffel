package tests;

import game.Dice;
import game.Field;
import game.FieldType;
import game.ScoreCard;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatePointsTest {

	private Dice[] dice = new Dice[5];
	private ScoreCard scoreCard = new ScoreCard(getAlLFields());
	private Field aces = new Field(FieldType.Aces),
			twos = new Field(FieldType.Twos),
			threes = new Field(FieldType.Threes),
			fours = new Field(FieldType.Fours),
			fives = new Field(FieldType.Fives),
			sixes = new Field(FieldType.Sixes),
			threeOfOneKind = new Field(FieldType.ThreeOfOneKind),
			fourOfOneKind = new Field(FieldType.FourOfOneKind),
			fullHouse = new Field(FieldType.FullHouse),
			smallStraight = new Field(FieldType.SmallStraight),
			largeStraight = new Field(FieldType.LargeStraight),
			kniffel = new Field(FieldType.Kniffel),
			chance = new Field(FieldType.Chance);

	public void setDicesValue(int[] values) {
		for (int i = 0; i < dice.length; i++) {
			dice[i] = new Dice(values[i]);
		}
	}

	public Field[] getAlLFields() {
		return new Field[]{aces, twos, threes, fours, fives, sixes, threeOfOneKind, fourOfOneKind, fullHouse, smallStraight, largeStraight, kniffel, chance};
	}

	/**
	 * Testing field score
	 */

	@Test
	public void testAces() {
		setDicesValue(new int[]{ 1, 1, 1, 1, 1 });
		aces.calculateAndStorePoints(dice);
		assertEquals(5, aces.getPoints());

		aces.resetPoints();

		setDicesValue(new int[]{ 1, 1, 1, 1, 3 });
		aces.calculateAndStorePoints(dice);
		assertEquals(4, aces.getPoints());

		aces.resetPoints();

		setDicesValue(new int[]{ 1, 1, 5, 1, 3 });
		aces.calculateAndStorePoints(dice);
		assertEquals(3, aces.getPoints());

		aces.resetPoints();

		setDicesValue(new int[]{ 6, 1, 5, 1, 3 });
		aces.calculateAndStorePoints(dice);
		assertEquals(2, aces.getPoints());

		aces.resetPoints();

		setDicesValue(new int[]{ 6, 4, 5, 1, 3 });
		aces.calculateAndStorePoints(dice);
		assertEquals(1, aces.getPoints());

		aces.resetPoints();

		setDicesValue(new int[]{ 6, 4, 5, 2, 3 });
		aces.calculateAndStorePoints(dice);
		assertEquals(0, aces.getPoints());

	}

	@Test
	public void testTwos() {
		setDicesValue(new int[]{ 2, 2, 2, 2, 2 });
		twos.calculateAndStorePoints(dice);
		assertEquals(10, twos.getPoints());

		twos.resetPoints();

		setDicesValue(new int[]{ 1, 2, 2, 2, 2 });
		twos.calculateAndStorePoints(dice);
		assertEquals(8, twos.getPoints());

		twos.resetPoints();

		setDicesValue(new int[]{ 2, 2, 5, 2, 3 });
		twos.calculateAndStorePoints(dice);
		assertEquals(6, twos.getPoints());

		twos.resetPoints();

		setDicesValue(new int[]{ 6, 2, 5, 2, 3 });
		twos.calculateAndStorePoints(dice);
		assertEquals(4, twos.getPoints());

		twos.resetPoints();

		setDicesValue(new int[]{ 6, 4, 5, 2, 3 });
		twos.calculateAndStorePoints(dice);
		assertEquals(2, twos.getPoints());

		twos.resetPoints();

		setDicesValue(new int[]{ 6, 4, 5, 1, 3 });
		twos.calculateAndStorePoints(dice);
		assertEquals(0, twos.getPoints());
	}

	@Test
	public void testThrees() {
		setDicesValue(new int[]{ 3, 3, 3, 3, 3 });
		threes.calculateAndStorePoints(dice);
		assertEquals(15, threes.getPoints());

		threes.resetPoints();

		setDicesValue(new int[]{ 1, 3, 3, 3, 3 });
		threes.calculateAndStorePoints(dice);
		assertEquals(12, threes.getPoints());

		threes.resetPoints();

		setDicesValue(new int[]{ 3, 3, 5, 3, 2 });
		threes.calculateAndStorePoints(dice);
		assertEquals(9, threes.getPoints());

		threes.resetPoints();

		setDicesValue(new int[]{ 6, 3, 5, 3, 2 });
		threes.calculateAndStorePoints(dice);
		assertEquals(6, threes.getPoints());

		threes.resetPoints();

		setDicesValue(new int[]{ 6, 4, 5, 3, 2 });
		threes.calculateAndStorePoints(dice);
		assertEquals(3, threes.getPoints());

		threes.resetPoints();

		setDicesValue(new int[]{ 6, 4, 5, 1, 2 });
		threes.calculateAndStorePoints(dice);
		assertEquals(0, threes.getPoints());
	}

	@Test
	public void testFours() {
		setDicesValue(new int[]{ 4, 4, 4, 4, 4 });
		fours.calculateAndStorePoints(dice);
		assertEquals(20, fours.getPoints());

		fours.resetPoints();

		setDicesValue(new int[]{ 4, 4, 4, 5, 4 });
		fours.calculateAndStorePoints(dice);
		assertEquals(16, fours.getPoints());

		fours.resetPoints();

		setDicesValue(new int[]{ 1, 4, 4, 5, 4 });
		fours.calculateAndStorePoints(dice);
		assertEquals(12, fours.getPoints());

		fours.resetPoints();

		setDicesValue(new int[]{ 1, 2, 4, 6, 4 });
		fours.calculateAndStorePoints(dice);
		assertEquals(8, fours.getPoints());

		fours.resetPoints();

		setDicesValue(new int[]{ 2, 3, 4, 5, 6 });
		fours.calculateAndStorePoints(dice);
		assertEquals(4, fours.getPoints());

		fours.resetPoints();

		setDicesValue(new int[]{ 1, 3, 2, 5, 6 });
		fours.calculateAndStorePoints(dice);
		assertEquals(0, fours.getPoints());

	}

	@Test
	public void testOfFives() {
		setDicesValue(new int[]{ 5, 5, 5, 5, 5 });
		fives.calculateAndStorePoints(dice);
		assertEquals(25, fives.getPoints());

		fives.resetPoints();

		setDicesValue(new int[]{ 1, 5, 5, 5, 5 });
		fives.calculateAndStorePoints(dice);
		assertEquals(20, fives.getPoints());

		fives.resetPoints();

		setDicesValue(new int[]{ 1, 3, 5, 5, 5 });
		fives.calculateAndStorePoints(dice);
		assertEquals(15, fives.getPoints());

		fives.resetPoints();

		setDicesValue(new int[]{ 1, 2, 4, 5, 5 });
		fives.calculateAndStorePoints(dice);
		assertEquals(10, fives.getPoints());

		fives.resetPoints();

		setDicesValue(new int[]{ 2, 6, 1, 3, 5 });
		fives.calculateAndStorePoints(dice);
		assertEquals(5, fives.getPoints());

		fives.resetPoints();

		setDicesValue(new int[]{ 1, 4, 3, 6, 2 });
		fives.calculateAndStorePoints(dice);
		assertEquals(0, fives.getPoints());

	}

	@Test
	public void testOfSixes() {
		setDicesValue(new int[]{ 6, 6, 6, 6, 6 });
		sixes.calculateAndStorePoints(dice);
		assertEquals(30, sixes.getPoints());

		sixes.resetPoints();

		setDicesValue(new int[]{ 1, 6, 6, 6, 6 });
		sixes.calculateAndStorePoints(dice);
		assertEquals(24, sixes.getPoints());

		sixes.resetPoints();

		setDicesValue(new int[]{ 3, 5, 6, 6, 6 });
		sixes.calculateAndStorePoints(dice);
		assertEquals(18, sixes.getPoints());

		sixes.resetPoints();

		setDicesValue(new int[]{ 1, 2, 6, 5, 6 });
		sixes.calculateAndStorePoints(dice);
		assertEquals(12, sixes.getPoints());

		sixes.resetPoints();

		setDicesValue(new int[]{ 1, 2, 4, 6, 5 });
		sixes.calculateAndStorePoints(dice);
		assertEquals(6, sixes.getPoints());

		sixes.resetPoints();

		setDicesValue(new int[]{ 1, 2, 3, 5, 4 });
		sixes.calculateAndStorePoints(dice);
		assertEquals(0, sixes.getPoints());

	}

	@Test
	public void testThreeOfOneKind() {
		setDicesValue(new int[]{ 1, 1, 1, 4, 5 });
		threeOfOneKind.calculateAndStorePoints(dice);
		assertEquals(12, threeOfOneKind.getPoints());

		threeOfOneKind.resetPoints();

		setDicesValue(new int[]{ 2, 2, 2, 1, 5 });
		threeOfOneKind.calculateAndStorePoints(dice);
		assertEquals(12, threeOfOneKind.getPoints());

		threeOfOneKind.resetPoints();

		setDicesValue(new int[]{ 3, 3, 3, 6, 2 });
		threeOfOneKind.calculateAndStorePoints(dice);
		assertEquals(17, threeOfOneKind.getPoints());

		threeOfOneKind.resetPoints();

		setDicesValue(new int[]{ 1, 4, 4, 4, 5 });
		threeOfOneKind.calculateAndStorePoints(dice);
		assertEquals(18, threeOfOneKind.getPoints());

		threeOfOneKind.resetPoints();

		setDicesValue(new int[]{ 1, 5, 2, 5, 5 });
		threeOfOneKind.calculateAndStorePoints(dice);
		assertEquals(18, threeOfOneKind.getPoints());

		threeOfOneKind.resetPoints();

		setDicesValue(new int[]{ 6, 1, 6, 3, 6 });
		threeOfOneKind.calculateAndStorePoints(dice);
		assertEquals(22, threeOfOneKind.getPoints());

		threeOfOneKind.resetPoints();

		setDicesValue(new int[]{ 1, 1, 1, 1, 5 });
		threeOfOneKind.calculateAndStorePoints(dice);
		assertEquals(9, threeOfOneKind.getPoints());

		threeOfOneKind.resetPoints();

		setDicesValue(new int[]{ 1, 1, 1, 1, 1 });
		threeOfOneKind.calculateAndStorePoints(dice);
		assertEquals(5, threeOfOneKind.getPoints());

		threeOfOneKind.resetPoints();

		setDicesValue(new int[]{ 1, 1, 3, 4, 5 });
		threeOfOneKind.calculateAndStorePoints(dice);
		assertEquals(0, threeOfOneKind.getPoints());

		threeOfOneKind.resetPoints();

		setDicesValue(new int[]{ 1, 2, 3, 4, 5 });
		threeOfOneKind.calculateAndStorePoints(dice);
		assertEquals(0, threeOfOneKind.getPoints());

	}

	@Test
	public void testFourOfOneKind() {
		setDicesValue(new int[]{ 1, 1, 1, 1, 5 });
		fourOfOneKind.calculateAndStorePoints(dice);
		assertEquals(9, fourOfOneKind.getPoints());

		fourOfOneKind.resetPoints();

		setDicesValue(new int[]{ 2, 2, 2, 2, 1 });
		fourOfOneKind.calculateAndStorePoints(dice);
		assertEquals(9, fourOfOneKind.getPoints());

		fourOfOneKind.resetPoints();

		setDicesValue(new int[]{ 3, 3, 3, 3, 2 });
		fourOfOneKind.calculateAndStorePoints(dice);
		assertEquals(14, fourOfOneKind.getPoints());

		fourOfOneKind.resetPoints();

		setDicesValue(new int[]{ 4, 4, 4, 4, 5 });
		fourOfOneKind.calculateAndStorePoints(dice);
		assertEquals(21, fourOfOneKind.getPoints());

		fourOfOneKind.resetPoints();

		setDicesValue(new int[]{ 1, 5, 5, 5, 5 });
		fourOfOneKind.calculateAndStorePoints(dice);
		assertEquals(21, fourOfOneKind.getPoints());

		fourOfOneKind.resetPoints();

		setDicesValue(new int[]{ 6, 6, 6, 6, 2 });
		fourOfOneKind.calculateAndStorePoints(dice);
		assertEquals(26, fourOfOneKind.getPoints());

		fourOfOneKind.resetPoints();

		setDicesValue(new int[]{ 1, 1, 1, 4, 5 });
		fourOfOneKind.calculateAndStorePoints(dice);
		assertEquals(0, fourOfOneKind.getPoints());

		fourOfOneKind.resetPoints();

		setDicesValue(new int[]{ 1, 1, 3, 4, 5 });
		fourOfOneKind.calculateAndStorePoints(dice);
		assertEquals(0, fourOfOneKind.getPoints());

		fourOfOneKind.resetPoints();

		setDicesValue(new int[]{ 1, 2, 3, 4, 5 });
		fourOfOneKind.calculateAndStorePoints(dice);
		assertEquals(0, fourOfOneKind.getPoints());

	}

	@Test
	public void testFullHouse() {
		setDicesValue(new int[]{ 1, 1, 1, 2, 2 });
		fullHouse.calculateAndStorePoints(dice);
		assertEquals(25, fullHouse.getPoints());

		fullHouse.resetPoints();

		setDicesValue(new int[]{ 2, 2, 3, 3, 3 });
		fullHouse.calculateAndStorePoints(dice);
		assertEquals(25, fullHouse.getPoints());

		fullHouse.resetPoints();

		setDicesValue(new int[]{ 1, 1, 2, 3, 3 });
		fullHouse.calculateAndStorePoints(dice);
		assertEquals(0, fullHouse.getPoints());

		fullHouse.resetPoints();

		setDicesValue(new int[]{ 1, 1, 1, 2, 3 });
		fullHouse.calculateAndStorePoints(dice);
		assertEquals(0, fullHouse.getPoints());

		fullHouse.resetPoints();

		setDicesValue(new int[]{ 1, 1, 1, 1, 3 });
		fullHouse.calculateAndStorePoints(dice);
		assertEquals(0, fullHouse.getPoints());

		fullHouse.resetPoints();

		setDicesValue(new int[]{ 1, 1, 1, 1, 1 });
		fullHouse.calculateAndStorePoints(dice);
		assertEquals(0, fullHouse.getPoints());

	}

	@Test
	public void testSmallStraight() {
		setDicesValue(new int[]{ 1, 2, 3, 4, 1 });
		smallStraight.calculateAndStorePoints(dice);
		assertEquals(30, smallStraight.getPoints());

		smallStraight.resetPoints();

		setDicesValue(new int[]{ 2, 3, 4, 5, 1 });
		smallStraight.calculateAndStorePoints(dice);
		assertEquals(30, smallStraight.getPoints());

		smallStraight.resetPoints();

		setDicesValue(new int[]{ 3, 4, 5, 6, 2 });
		smallStraight.calculateAndStorePoints(dice);
		assertEquals(30, smallStraight.getPoints());

		smallStraight.resetPoints();

		setDicesValue(new int[]{ 3, 2, 4, 4, 1 });
		smallStraight.calculateAndStorePoints(dice);
		assertEquals(30, smallStraight.getPoints());

		smallStraight.resetPoints();

		setDicesValue(new int[]{ 5, 6, 3, 4, 1 });
		smallStraight.calculateAndStorePoints(dice);
		assertEquals(30, smallStraight.getPoints());

		smallStraight.resetPoints();

		setDicesValue(new int[]{ 3, 2, 3, 4, 5 });
		smallStraight.calculateAndStorePoints(dice);
		assertEquals(30, smallStraight.getPoints());

		smallStraight.resetPoints();

		setDicesValue(new int[]{ 1, 1, 3, 4, 1 });
		smallStraight.calculateAndStorePoints(dice);
		assertEquals(0, smallStraight.getPoints());

		smallStraight.resetPoints();

		setDicesValue(new int[]{ 1, 1, 1, 4, 1 });
		smallStraight.calculateAndStorePoints(dice);
		assertEquals(0, smallStraight.getPoints());

		smallStraight.resetPoints();

		setDicesValue(new int[]{ 1, 2, 3, 5, 6 });
		smallStraight.calculateAndStorePoints(dice);
		assertEquals(0, smallStraight.getPoints());

		smallStraight.resetPoints();

		setDicesValue(new int[]{ 1, 4, 4, 2, 2 });
		smallStraight.calculateAndStorePoints(dice);
		assertEquals(0, smallStraight.getPoints());
		
	}

	@Test
	public void testLargeStraight() {
		setDicesValue(new int[]{ 1, 2, 3, 4, 5 });
		largeStraight.calculateAndStorePoints(dice);
		assertEquals(40, largeStraight.getPoints());

		largeStraight.resetPoints();
		
		setDicesValue(new int[]{ 2, 3, 4, 5, 6 });
		largeStraight.calculateAndStorePoints(dice);
		assertEquals(40, largeStraight.getPoints());

		largeStraight.resetPoints();
		
		setDicesValue(new int[]{ 1, 4, 2, 3, 5 });
		largeStraight.calculateAndStorePoints(dice);
		assertEquals(40, largeStraight.getPoints());

		largeStraight.resetPoints();
		
		setDicesValue(new int[]{ 3, 4, 2, 5, 6 });
		largeStraight.calculateAndStorePoints(dice);
		assertEquals(40, largeStraight.getPoints());

		largeStraight.resetPoints();
		
		setDicesValue(new int[]{2, 3, 4, 1, 5 });
		largeStraight.calculateAndStorePoints(dice);
		assertEquals(40, largeStraight.getPoints());

		largeStraight.resetPoints();
		
		setDicesValue(new int[]{ 1, 2, 3, 1, 1 });
		largeStraight.calculateAndStorePoints(dice);
		assertEquals(0, largeStraight.getPoints());

		largeStraight.resetPoints();
		
		setDicesValue(new int[]{ 1, 2, 4, 2, 1 });
		largeStraight.calculateAndStorePoints(dice);
		assertEquals(0, largeStraight.getPoints());

		largeStraight.resetPoints();
		
		setDicesValue(new int[]{ 2, 3, 4, 3, 3 });
		largeStraight.calculateAndStorePoints(dice);
		assertEquals(0, largeStraight.getPoints());

		largeStraight.resetPoints();
		
		setDicesValue(new int[]{ 2, 3, 2, 2, 2 });
		largeStraight.calculateAndStorePoints(dice);
		assertEquals(0, largeStraight.getPoints());

		largeStraight.resetPoints();
		
		setDicesValue(new int[]{ 1, 6, 1, 6, 1 });
		largeStraight.calculateAndStorePoints(dice);
		assertEquals(0, largeStraight.getPoints());

		largeStraight.resetPoints();

		setDicesValue(new int[]{ 1, 1, 1, 1, 1 });
		largeStraight.calculateAndStorePoints(dice);
		assertEquals(0, largeStraight.getPoints());

	}

	@Test
	public void testKniffel() {
		setDicesValue(new int[]{ 1, 1, 1, 1, 1 });
		kniffel.calculateAndStorePoints(dice);
		assertEquals(50, kniffel.getPoints());

		kniffel.resetPoints();

		setDicesValue(new int[]{ 2, 2, 2, 2, 2 });
		kniffel.calculateAndStorePoints(dice);
		assertEquals(50, kniffel.getPoints());

		kniffel.resetPoints();

		setDicesValue(new int[]{ 3, 3, 3, 3, 3 });
		kniffel.calculateAndStorePoints(dice);
		assertEquals(50, kniffel.getPoints());

		kniffel.resetPoints();

		setDicesValue(new int[]{ 4, 4, 4, 4, 4 });
		kniffel.calculateAndStorePoints(dice);
		assertEquals(50, kniffel.getPoints());

		kniffel.resetPoints();

		setDicesValue(new int[]{ 5, 5, 5, 5, 5 });
		kniffel.calculateAndStorePoints(dice);
		assertEquals(50, kniffel.getPoints());

		kniffel.resetPoints();

		setDicesValue(new int[]{ 6, 6, 6, 6, 6 });
		kniffel.calculateAndStorePoints(dice);
		assertEquals(50, kniffel.getPoints());

		kniffel.resetPoints();

		setDicesValue(new int[]{ 1, 1, 1, 1, 4 });
		kniffel.calculateAndStorePoints(dice);
		assertEquals(0, kniffel.getPoints());

		kniffel.resetPoints();

		setDicesValue(new int[]{ 1, 1, 1, 2, 4 });
		kniffel.calculateAndStorePoints(dice);
		assertEquals(0, kniffel.getPoints());

		kniffel.resetPoints();

		setDicesValue(new int[]{ 1, 1, 3, 2, 4 });
		kniffel.calculateAndStorePoints(dice);
		assertEquals(0, kniffel.getPoints());

		kniffel.resetPoints();

		setDicesValue(new int[]{ 1, 5, 3, 2, 4 });
		kniffel.calculateAndStorePoints(dice);
		assertEquals(0, kniffel.getPoints());

		kniffel.resetPoints();

		setDicesValue(new int[]{ 1, 2, 3, 5, 6 });
		kniffel.calculateAndStorePoints(dice);
		assertEquals(0, kniffel.getPoints());

	}

	@Test
	public void testChance() {
		setDicesValue(new int[]{ 1, 2, 3, 4, 1 });
		chance.calculateAndStorePoints(dice);
		assertEquals(11, chance.getPoints());

		chance.resetPoints();

		setDicesValue(new int[]{ 1, 2, 3, 4, 6 });
		chance.calculateAndStorePoints(dice);
		assertEquals(16, chance.getPoints());

		chance.resetPoints();

		setDicesValue(new int[]{ 5, 6, 3, 4, 1 });
		chance.calculateAndStorePoints(dice);
		assertEquals(19, chance.getPoints());

		chance.resetPoints();

		setDicesValue(new int[]{ 1, 2, 3, 4, 5 });
		chance.calculateAndStorePoints(dice);
		assertEquals(15, chance.getPoints());

		chance.resetPoints();

		setDicesValue(new int[]{ 6, 6, 5, 5, 5 });
		chance.calculateAndStorePoints(dice);
		assertEquals(27, chance.getPoints());

		chance.resetPoints();

		setDicesValue(new int[]{ 1, 2, 3, 3, 3 });
		chance.calculateAndStorePoints(dice);
		assertEquals(12, chance.getPoints());

		chance.resetPoints();

		setDicesValue(new int[]{ 1, 2, 2, 4, 1 });
		chance.calculateAndStorePoints(dice);
		assertEquals(10, chance.getPoints());

	}

	/**
	 *  Testing sum and bonus score
	 */

	@Test
	public void testNoPoints() {
		scoreCard.testCalculateScoreSums(new int[]{0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0});
		assertEquals(0, scoreCard.getBonus());
		assertEquals(0, scoreCard.getSumUpper());
		assertEquals(0, scoreCard.getSumLower());
		assertEquals(0, scoreCard.getSumOverall());
	}

	@Test
	public void testLowerNoBonus() {
		scoreCard.testCalculateScoreSums(new int[]{0, 0, 0, 0, 0, 0,
				5, 5, 25, 0, 0, 0, 15});
		assertEquals(0, scoreCard.getBonus());
		assertEquals(0, scoreCard.getSumUpper());
		assertEquals(50, scoreCard.getSumLower());
		assertEquals(50, scoreCard.getSumOverall());
	}

	@Test
	public void testUpperAndLowerNoBonus() {
		scoreCard.testCalculateScoreSums(new int[]{1, 8, 3, 20, 0, 30,
				5, 5, 25, 0, 0, 0, 15});
		assertEquals(0, scoreCard.getBonus());
		assertEquals(62, scoreCard.getSumUpper());
		assertEquals(50, scoreCard.getSumLower());
		assertEquals(112, scoreCard.getSumOverall());
	}

	@Test
	public void testUpperAndLowerWithBonus() {
		scoreCard.testCalculateScoreSums(new int[]{1, 10, 3, 20, 0, 30,
				5, 5, 25, 0, 0, 0, 15});
		assertEquals(35, scoreCard.getBonus());
		assertEquals(99, scoreCard.getSumUpper());
		assertEquals(50, scoreCard.getSumLower());
		assertEquals(149, scoreCard.getSumOverall());
	}

	@Test
	public void testUpperNoBonus() {
		scoreCard.testCalculateScoreSums(new int[]{2, 10, 0, 20, 0, 30,
				0, 0, 0, 0, 0, 0, 0});
		assertEquals(0, scoreCard.getBonus());
		assertEquals(62, scoreCard.getSumUpper());
		assertEquals(0, scoreCard.getSumLower());
		assertEquals(62, scoreCard.getSumOverall());
	}

	@Test
	public void testUpperWithBonus() {
		scoreCard.testCalculateScoreSums(new int[]{1, 10, 3, 20, 0, 30,
				0, 0, 0, 0, 0, 0, 0});
		assertEquals(35, scoreCard.getBonus());
		assertEquals(99, scoreCard.getSumUpper());
		assertEquals(0, scoreCard.getSumLower());
		assertEquals(99, scoreCard.getSumOverall());
	}

	/**
	 *  Tests that dice has only six sides (nothing higher than 6 or lower than 1 can be rolled)
	 */

	@Test
	public void testDice() {
		dice[0] = new Dice();
		int value;
		for(int i = 0; i < 1000; i++) {
			dice[0].roll();
			value = dice[0].getValue();
			if(value > 6 || value < 1) {
				assertEquals(true, false);
			} else {
				assertEquals(true, true);
			}
		}
	}

}
