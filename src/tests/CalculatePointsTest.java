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
	private Field aces = new Field(FieldType.Aces), twos = new Field(FieldType.Twos),
			threes = new Field(FieldType.Threes), fours = new Field(FieldType.Fours),
			fives = new Field(FieldType.Fives), sixes = new Field(FieldType.Sixes),
			threeOfOneKind = new Field(FieldType.ThreeOfOneKind), fourOfOneKind = new Field(FieldType.FourOfOneKind),
			fullHouse = new Field(FieldType.FullHouse), smallStraight = new Field(FieldType.SmallStraight),
			largeStraight = new Field(FieldType.LargeStraight), kniffel = new Field(FieldType.Kniffel),
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
		int[] v1 = { 1, 1, 1, 1, 1 };
		setDicesValue(v1);
		aces.calculateAndStorePoints(dice);
		assertEquals(5, aces.getPoints());

		aces.resetPoints();

		int[] v2 = { 1, 1, 1, 1, 3 };
		setDicesValue(v2);
		aces.calculateAndStorePoints(dice);
		assertEquals(4, aces.getPoints());

		aces.resetPoints();

		int[] v3 = { 1, 1, 5, 1, 3 };
		setDicesValue(v3);
		aces.calculateAndStorePoints(dice);
		assertEquals(3, aces.getPoints());

		aces.resetPoints();

		int[] v4 = { 6, 1, 5, 1, 3 };
		setDicesValue(v4);
		aces.calculateAndStorePoints(dice);
		assertEquals(2, aces.getPoints());

		aces.resetPoints();

		int[] v5 = { 6, 4, 5, 1, 3 };
		setDicesValue(v5);
		aces.calculateAndStorePoints(dice);
		assertEquals(1, aces.getPoints());

		aces.resetPoints();

		int[] v6 = { 6, 4, 5, 2, 3 };
		setDicesValue(v6);
		aces.calculateAndStorePoints(dice);
		assertEquals(0, aces.getPoints());

	}

	@Test
	public void testTwos() {
		int[] v1 = { 2, 2, 2, 2, 2 };
		setDicesValue(v1);
		twos.calculateAndStorePoints(dice);
		assertEquals(10, twos.getPoints());

		twos.resetPoints();

		int[] v2 = { 1, 2, 2, 2, 2 };
		setDicesValue(v2);
		twos.calculateAndStorePoints(dice);
		assertEquals(8, twos.getPoints());

		twos.resetPoints();

		int[] v3 = { 2, 2, 5, 2, 3 };
		setDicesValue(v3);
		twos.calculateAndStorePoints(dice);
		assertEquals(6, twos.getPoints());

		twos.resetPoints();

		int[] v4 = { 6, 2, 5, 2, 3 };
		setDicesValue(v4);
		twos.calculateAndStorePoints(dice);
		assertEquals(4, twos.getPoints());

		twos.resetPoints();

		int[] v5 = { 6, 4, 5, 2, 3 };
		setDicesValue(v5);
		twos.calculateAndStorePoints(dice);
		assertEquals(2, twos.getPoints());

		twos.resetPoints();

		int[] v6 = { 6, 4, 5, 1, 3 };
		setDicesValue(v6);
		twos.calculateAndStorePoints(dice);
		assertEquals(0, twos.getPoints());
	}

	@Test
	public void testThrees() {
		int[] v1 = { 3, 3, 3, 3, 3 };
		setDicesValue(v1);
		threes.calculateAndStorePoints(dice);
		assertEquals(15, threes.getPoints());

		threes.resetPoints();

		int[] v2 = { 1, 3, 3, 3, 3 };
		setDicesValue(v2);
		threes.calculateAndStorePoints(dice);
		assertEquals(12, threes.getPoints());

		threes.resetPoints();

		int[] v3 = { 3, 3, 5, 3, 2 };
		setDicesValue(v3);
		threes.calculateAndStorePoints(dice);
		assertEquals(9, threes.getPoints());

		threes.resetPoints();

		int[] v4 = { 6, 3, 5, 3, 2 };
		setDicesValue(v4);
		threes.calculateAndStorePoints(dice);
		assertEquals(6, threes.getPoints());

		threes.resetPoints();

		int[] v5 = { 6, 4, 5, 3, 2 };
		setDicesValue(v5);
		threes.calculateAndStorePoints(dice);
		assertEquals(3, threes.getPoints());

		threes.resetPoints();

		int[] v6 = { 6, 4, 5, 1, 2 };
		setDicesValue(v6);
		threes.calculateAndStorePoints(dice);
		assertEquals(0, threes.getPoints());
	}

	@Test
	public void testFours() {
		int[] v1 = { 4, 4, 4, 4, 4 };
		setDicesValue(v1);
		fours.calculateAndStorePoints(dice);
		assertEquals(20, fours.getPoints());

		fours.resetPoints();

		int[] v2 = { 4, 4, 4, 5, 4 };
		setDicesValue(v2);
		fours.calculateAndStorePoints(dice);
		assertEquals(16, fours.getPoints());

		fours.resetPoints();

		int[] v3 = { 1, 4, 4, 5, 4 };
		setDicesValue(v3);
		fours.calculateAndStorePoints(dice);
		assertEquals(12, fours.getPoints());

		fours.resetPoints();

		int[] v4 = { 1, 2, 4, 6, 4 };
		setDicesValue(v4);
		fours.calculateAndStorePoints(dice);
		assertEquals(8, fours.getPoints());

		fours.resetPoints();

		int[] v5 = { 2, 3, 4, 5, 6 };
		setDicesValue(v5);
		fours.calculateAndStorePoints(dice);
		assertEquals(4, fours.getPoints());

		fours.resetPoints();

		int[] v6 = { 1, 3, 2, 5, 6 };
		setDicesValue(v6);
		fours.calculateAndStorePoints(dice);
		assertEquals(0, fours.getPoints());

	}

	@Test
	public void testOfFives() {
		int[] v1 = { 5, 5, 5, 5, 5 };
		setDicesValue(v1);
		fives.calculateAndStorePoints(dice);
		assertEquals(25, fives.getPoints());

		fives.resetPoints();

		int[] v2 = { 1, 5, 5, 5, 5 };
		setDicesValue(v2);
		fives.calculateAndStorePoints(dice);
		assertEquals(20, fives.getPoints());

		fives.resetPoints();

		int[] v3 = { 1, 3, 5, 5, 5 };
		setDicesValue(v3);
		fives.calculateAndStorePoints(dice);
		assertEquals(15, fives.getPoints());

		fives.resetPoints();

		int[] v4 = { 1, 2, 4, 5, 5 };
		setDicesValue(v4);
		fives.calculateAndStorePoints(dice);
		assertEquals(10, fives.getPoints());

		fives.resetPoints();

		int[] v5 = { 2, 6, 1, 3, 5 };
		setDicesValue(v5);
		fives.calculateAndStorePoints(dice);
		assertEquals(5, fives.getPoints());

		fives.resetPoints();

		int[] v6 = { 1, 4, 3, 6, 2 };
		setDicesValue(v6);
		fives.calculateAndStorePoints(dice);
		assertEquals(0, fives.getPoints());

	}

	@Test
	public void testOfSixes() {
		int[] v1 = { 6, 6, 6, 6, 6 };
		setDicesValue(v1);
		sixes.calculateAndStorePoints(dice);
		assertEquals(30, sixes.getPoints());

		sixes.resetPoints();

		int[] v2 = { 1, 6, 6, 6, 6 };
		setDicesValue(v2);
		sixes.calculateAndStorePoints(dice);
		assertEquals(24, sixes.getPoints());

		sixes.resetPoints();

		int[] v3 = { 3, 5, 6, 6, 6 };
		setDicesValue(v3);
		sixes.calculateAndStorePoints(dice);
		assertEquals(18, sixes.getPoints());

		sixes.resetPoints();

		int[] v4 = { 1, 2, 6, 5, 6 };
		setDicesValue(v4);
		sixes.calculateAndStorePoints(dice);
		assertEquals(12, sixes.getPoints());

		sixes.resetPoints();

		int[] v5 = { 1, 2, 4, 6, 5 };
		setDicesValue(v5);
		sixes.calculateAndStorePoints(dice);
		assertEquals(6, sixes.getPoints());

		sixes.resetPoints();

		int[] v6 = { 1, 2, 3, 5, 4 };
		setDicesValue(v6);
		sixes.calculateAndStorePoints(dice);
		assertEquals(0, sixes.getPoints());

	}

	@Test
	public void testThreeOfOneKind() {
		int[] v1 = { 1, 1, 1, 4, 5 };
		setDicesValue(v1);
		threeOfOneKind.calculateAndStorePoints(dice);
		assertEquals(12, threeOfOneKind.getPoints());

		threeOfOneKind.resetPoints();

		int[] v2 = { 2, 2, 2, 1, 5 };
		setDicesValue(v2);
		threeOfOneKind.calculateAndStorePoints(dice);
		assertEquals(12, threeOfOneKind.getPoints());

		threeOfOneKind.resetPoints();

		int[] v3 = { 3, 3, 3, 6, 2 };
		setDicesValue(v3);
		threeOfOneKind.calculateAndStorePoints(dice);
		assertEquals(17, threeOfOneKind.getPoints());

		threeOfOneKind.resetPoints();

		int[] v4 = { 1, 4, 4, 4, 5 };
		setDicesValue(v4);
		threeOfOneKind.calculateAndStorePoints(dice);
		assertEquals(18, threeOfOneKind.getPoints());

		threeOfOneKind.resetPoints();

		int[] v5 = { 1, 5, 2, 5, 5 };
		setDicesValue(v5);
		threeOfOneKind.calculateAndStorePoints(dice);
		assertEquals(18, threeOfOneKind.getPoints());

		threeOfOneKind.resetPoints();

		int[] v6 = { 6, 1, 6, 3, 6 };
		setDicesValue(v6);
		threeOfOneKind.calculateAndStorePoints(dice);
		assertEquals(22, threeOfOneKind.getPoints());

		threeOfOneKind.resetPoints();

		int[] v7 = { 1, 1, 1, 1, 5 };
		setDicesValue(v7);
		threeOfOneKind.calculateAndStorePoints(dice);
		assertEquals(9, threeOfOneKind.getPoints());

		threeOfOneKind.resetPoints();

		int[] v8 = { 1, 1, 1, 1, 1 };
		setDicesValue(v8);
		threeOfOneKind.calculateAndStorePoints(dice);
		assertEquals(5, threeOfOneKind.getPoints());

		threeOfOneKind.resetPoints();

		int[] v9 = { 1, 1, 3, 4, 5 };
		setDicesValue(v9);
		threeOfOneKind.calculateAndStorePoints(dice);
		assertEquals(0, threeOfOneKind.getPoints());

		threeOfOneKind.resetPoints();

		int[] v10 = { 1, 2, 3, 4, 5 };
		setDicesValue(v10);
		threeOfOneKind.calculateAndStorePoints(dice);
		assertEquals(0, threeOfOneKind.getPoints());

	}

	@Test
	public void testFourOfOneKind() {
		int[] v1 = { 1, 1, 1, 1, 5 };
		setDicesValue(v1);
		fourOfOneKind.calculateAndStorePoints(dice);
		assertEquals(9, fourOfOneKind.getPoints());

		fourOfOneKind.resetPoints();

		int[] v2 = { 2, 2, 2, 2, 1 };
		setDicesValue(v2);
		fourOfOneKind.calculateAndStorePoints(dice);
		assertEquals(9, fourOfOneKind.getPoints());

		fourOfOneKind.resetPoints();

		int[] v3 = { 3, 3, 3, 3, 2 };
		setDicesValue(v3);
		fourOfOneKind.calculateAndStorePoints(dice);
		assertEquals(14, fourOfOneKind.getPoints());

		fourOfOneKind.resetPoints();

		int[] v4 = { 4, 4, 4, 4, 5 };
		setDicesValue(v4);
		fourOfOneKind.calculateAndStorePoints(dice);
		assertEquals(21, fourOfOneKind.getPoints());

		fourOfOneKind.resetPoints();

		int[] v5 = { 1, 5, 5, 5, 5 };
		setDicesValue(v5);
		fourOfOneKind.calculateAndStorePoints(dice);
		assertEquals(21, fourOfOneKind.getPoints());

		fourOfOneKind.resetPoints();

		int[] v6 = { 6, 6, 6, 6, 2 };
		setDicesValue(v6);
		fourOfOneKind.calculateAndStorePoints(dice);
		assertEquals(26, fourOfOneKind.getPoints());

		fourOfOneKind.resetPoints();

		int[] v7 = { 1, 1, 1, 4, 5 };
		setDicesValue(v7);
		fourOfOneKind.calculateAndStorePoints(dice);
		assertEquals(0, fourOfOneKind.getPoints());

		fourOfOneKind.resetPoints();

		int[] v8 = { 1, 1, 3, 4, 5 };
		setDicesValue(v8);
		fourOfOneKind.calculateAndStorePoints(dice);
		assertEquals(0, fourOfOneKind.getPoints());

		fourOfOneKind.resetPoints();

		int[] v9 = { 1, 2, 3, 4, 5 };
		setDicesValue(v9);
		fourOfOneKind.calculateAndStorePoints(dice);
		assertEquals(0, fourOfOneKind.getPoints());

	}

	@Test
	public void testFullHouse() {
		int[] v1 = { 1, 1, 1, 2, 2 };
		setDicesValue(v1);
		fullHouse.calculateAndStorePoints(dice);
		assertEquals(25, fullHouse.getPoints());

		fullHouse.resetPoints();

		int[] v2 = { 2, 2, 3, 3, 3 };
		setDicesValue(v2);
		fullHouse.calculateAndStorePoints(dice);
		assertEquals(25, fullHouse.getPoints());

		fullHouse.resetPoints();

		int[] v3 = { 1, 1, 2, 3, 3 };
		setDicesValue(v3);
		fullHouse.calculateAndStorePoints(dice);
		assertEquals(0, fullHouse.getPoints());

		fullHouse.resetPoints();

		int[] v4 = { 1, 1, 1, 2, 3 };
		setDicesValue(v4);
		fullHouse.calculateAndStorePoints(dice);
		assertEquals(0, fullHouse.getPoints());

		fullHouse.resetPoints();

		int[] v5 = { 1, 1, 1, 1, 3 };
		setDicesValue(v5);
		fullHouse.calculateAndStorePoints(dice);
		assertEquals(0, fullHouse.getPoints());

		fullHouse.resetPoints();

		int[] v6 = { 1, 1, 1, 1, 1 };
		setDicesValue(v6);
		fullHouse.calculateAndStorePoints(dice);
		assertEquals(0, fullHouse.getPoints());

	}

	@Test
	public void testSmallStraight() {
		int[] v1 = { 1, 2, 3, 4, 1 };
		setDicesValue(v1);
		smallStraight.calculateAndStorePoints(dice);
		assertEquals(30, smallStraight.getPoints());

		smallStraight.resetPoints();

		int[] v2 = { 2, 3, 4, 5, 1 };
		setDicesValue(v2);
		smallStraight.calculateAndStorePoints(dice);
		assertEquals(30, smallStraight.getPoints());

		smallStraight.resetPoints();

		int[] v3 = { 3, 4, 5, 6, 2 };
		setDicesValue(v3);
		smallStraight.calculateAndStorePoints(dice);
		assertEquals(30, smallStraight.getPoints());

		smallStraight.resetPoints();

		int[] v4 = { 3, 2, 4, 4, 1 };
		setDicesValue(v4);
		smallStraight.calculateAndStorePoints(dice);
		assertEquals(30, smallStraight.getPoints());

		smallStraight.resetPoints();

		int[] v5 = { 5, 6, 3, 4, 1 };
		setDicesValue(v5);
		smallStraight.calculateAndStorePoints(dice);
		assertEquals(30, smallStraight.getPoints());

		smallStraight.resetPoints();

		int[] v6 = { 3, 2, 3, 4, 5 };
		setDicesValue(v6);
		smallStraight.calculateAndStorePoints(dice);
		assertEquals(30, smallStraight.getPoints());

		smallStraight.resetPoints();

		int[] v7 = { 1, 1, 3, 4, 1 };
		setDicesValue(v7);
		smallStraight.calculateAndStorePoints(dice);
		assertEquals(0, smallStraight.getPoints());

		smallStraight.resetPoints();

		int[] v8 = { 1, 1, 1, 4, 1 };
		setDicesValue(v8);
		smallStraight.calculateAndStorePoints(dice);
		assertEquals(0, smallStraight.getPoints());

		smallStraight.resetPoints();

		int[] v9 = { 1, 2, 3, 5, 6 };
		setDicesValue(v9);
		smallStraight.calculateAndStorePoints(dice);
		assertEquals(0, smallStraight.getPoints());

		smallStraight.resetPoints();

		int[] v10 = { 1, 4, 4, 2, 2 };
		setDicesValue(v10);
		smallStraight.calculateAndStorePoints(dice);
		assertEquals(0, smallStraight.getPoints());
		
	}

	@Test
	public void testLargeStraight() {
		int[] v1 = { 1, 2, 3, 4, 5 };
		setDicesValue(v1);
		largeStraight.calculateAndStorePoints(dice);
		assertEquals(40, largeStraight.getPoints());

		largeStraight.resetPoints();
		
		int[] v2 = { 2, 3, 4, 5, 6 };
		setDicesValue(v2);
		largeStraight.calculateAndStorePoints(dice);
		assertEquals(40, largeStraight.getPoints());

		largeStraight.resetPoints();
		
		int[] v3 = { 1, 4, 2, 3, 5 };
		setDicesValue(v3);
		largeStraight.calculateAndStorePoints(dice);
		assertEquals(40, largeStraight.getPoints());

		largeStraight.resetPoints();
		
		int[] v4 = { 3, 4, 2, 5, 6 };
		setDicesValue(v4);
		largeStraight.calculateAndStorePoints(dice);
		assertEquals(40, largeStraight.getPoints());

		largeStraight.resetPoints();
		
		int[] v5 = {2, 3, 4, 1, 5 };
		setDicesValue(v5);
		largeStraight.calculateAndStorePoints(dice);
		assertEquals(40, largeStraight.getPoints());

		largeStraight.resetPoints();
		
		int[] v6 = { 1, 2, 3, 1, 1 };
		setDicesValue(v6);
		largeStraight.calculateAndStorePoints(dice);
		assertEquals(0, largeStraight.getPoints());

		largeStraight.resetPoints();
		
		int[] v7 = { 1, 2, 4, 2, 1 };
		setDicesValue(v7);
		largeStraight.calculateAndStorePoints(dice);
		assertEquals(0, largeStraight.getPoints());

		largeStraight.resetPoints();
		
		int[] v8 = { 2, 3, 4, 3, 3 };
		setDicesValue(v8);
		largeStraight.calculateAndStorePoints(dice);
		assertEquals(0, largeStraight.getPoints());

		largeStraight.resetPoints();
		
		int[] v9 = { 2, 3, 2, 2, 2 };
		setDicesValue(v9);
		largeStraight.calculateAndStorePoints(dice);
		assertEquals(0, largeStraight.getPoints());

		largeStraight.resetPoints();
		
		int[] v10 = { 1, 6, 1, 6, 1 };
		setDicesValue(v10);
		largeStraight.calculateAndStorePoints(dice);
		assertEquals(0, largeStraight.getPoints());

		largeStraight.resetPoints();

		int[] v11 = { 1, 1, 1, 1, 1 };
		setDicesValue(v11);
		largeStraight.calculateAndStorePoints(dice);
		assertEquals(0, largeStraight.getPoints());

	}

	@Test
	public void testKniffel() {
		int[] v1 = { 1, 1, 1, 1, 1 };
		setDicesValue(v1);
		kniffel.calculateAndStorePoints(dice);
		assertEquals(50, kniffel.getPoints());

		kniffel.resetPoints();

		int[] v2 = { 2, 2, 2, 2, 2 };
		setDicesValue(v2);
		kniffel.calculateAndStorePoints(dice);
		assertEquals(50, kniffel.getPoints());

		kniffel.resetPoints();

		int[] v3 = { 3, 3, 3, 3, 3 };
		setDicesValue(v3);
		kniffel.calculateAndStorePoints(dice);
		assertEquals(50, kniffel.getPoints());

		kniffel.resetPoints();

		int[] v4 = { 4, 4, 4, 4, 4 };
		setDicesValue(v4);
		kniffel.calculateAndStorePoints(dice);
		assertEquals(50, kniffel.getPoints());

		kniffel.resetPoints();

		int[] v5 = { 5, 5, 5, 5, 5 };
		setDicesValue(v5);
		kniffel.calculateAndStorePoints(dice);
		assertEquals(50, kniffel.getPoints());

		kniffel.resetPoints();

		int[] v6 = { 6, 6, 6, 6, 6 };
		setDicesValue(v6);
		kniffel.calculateAndStorePoints(dice);
		assertEquals(50, kniffel.getPoints());

		kniffel.resetPoints();

		int[] v7 = { 1, 1, 1, 1, 4 };
		setDicesValue(v7);
		kniffel.calculateAndStorePoints(dice);
		assertEquals(0, kniffel.getPoints());

		kniffel.resetPoints();

		int[] v8 = { 1, 1, 1, 2, 4 };
		setDicesValue(v8);
		kniffel.calculateAndStorePoints(dice);
		assertEquals(0, kniffel.getPoints());

		kniffel.resetPoints();

		int[] v9 = { 1, 1, 3, 2, 4 };
		setDicesValue(v9);
		kniffel.calculateAndStorePoints(dice);
		assertEquals(0, kniffel.getPoints());

		kniffel.resetPoints();

		int[] v10 = { 1, 5, 3, 2, 4 };
		setDicesValue(v10);
		kniffel.calculateAndStorePoints(dice);
		assertEquals(0, kniffel.getPoints());

		kniffel.resetPoints();

		int[] v11 = { 1, 2, 3, 5, 6 };
		setDicesValue(v11);
		kniffel.calculateAndStorePoints(dice);
		assertEquals(0, kniffel.getPoints());

	}

	@Test
	public void testChance() {
		int[] v1 = { 1, 2, 3, 4, 1 };
		setDicesValue(v1);
		chance.calculateAndStorePoints(dice);
		assertEquals(11, chance.getPoints());

		chance.resetPoints();

		int[] v2 = { 1, 2, 3, 4, 6 };
		setDicesValue(v2);
		chance.calculateAndStorePoints(dice);
		assertEquals(16, chance.getPoints());

		chance.resetPoints();

		int[] v3 = { 5, 6, 3, 4, 1 };
		setDicesValue(v3);
		chance.calculateAndStorePoints(dice);
		assertEquals(19, chance.getPoints());

		chance.resetPoints();

		int[] v4 = { 1, 2, 3, 4, 5 };
		setDicesValue(v4);
		chance.calculateAndStorePoints(dice);
		assertEquals(15, chance.getPoints());

		chance.resetPoints();

		int[] v5 = { 6, 6, 5, 5, 5 };
		setDicesValue(v5);
		chance.calculateAndStorePoints(dice);
		assertEquals(27, chance.getPoints());

		chance.resetPoints();

		int[] v6 = { 1, 2, 3, 3, 3 };
		setDicesValue(v6);
		chance.calculateAndStorePoints(dice);
		assertEquals(12, chance.getPoints());

		chance.resetPoints();

		int[] v7 = { 1, 2, 2, 4, 1 };
		setDicesValue(v7);
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
