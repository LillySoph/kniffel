package tests;


import org.junit.Test;

import game.DiceE;
import game.FieldE;
import game.FieldType;

import static org.junit.Assert.assertEquals;

public class CalculatePointsTestE {

	private DiceE[] dices = new DiceE[5];
	private FieldE f;

	public void setDicesValue(int[] values) {
		for (int i = 0; i < dices.length; i++) {
			dices[i] = new DiceE(values[i]);
		}
	}

	@Test
	public void testAces() {
		f = new FieldE(FieldType.Aces);

		int[] v1 = { 1, 1, 1, 1, 1 };
		setDicesValue(v1);
		f.calculateAndStorePoints(dices);
		assertEquals(5, f.getPoints());

		f.resetPoints();

		int[] v2 = { 1, 1, 1, 1, 3 };
		setDicesValue(v2);
		f.calculateAndStorePoints(dices);
		assertEquals(4, f.getPoints());

		f.resetPoints();

		int[] v3 = { 1, 1, 5, 1, 3 };
		setDicesValue(v3);
		f.calculateAndStorePoints(dices);
		assertEquals(3, f.getPoints());

		f.resetPoints();

		int[] v4 = { 6, 1, 5, 1, 3 };
		setDicesValue(v4);
		f.calculateAndStorePoints(dices);
		assertEquals(2, f.getPoints());

		f.resetPoints();

		int[] v5 = { 6, 4, 5, 1, 3 };
		setDicesValue(v5);
		f.calculateAndStorePoints(dices);
		assertEquals(1, f.getPoints());

		f.resetPoints();

		int[] v6 = { 6, 4, 5, 2, 3 };
		setDicesValue(v6);
		f.calculateAndStorePoints(dices);
		assertEquals(0, f.getPoints());

	}

	@Test
	public void testTwos() {
		f = new FieldE(FieldType.Twos);

		int[] v1 = { 2, 2, 2, 2, 2 };
		setDicesValue(v1);
		f.calculateAndStorePoints(dices);
		assertEquals(10, f.getPoints());

		f.resetPoints();

		int[] v2 = { 1, 2, 2, 2, 2 };
		setDicesValue(v2);
		f.calculateAndStorePoints(dices);
		assertEquals(8, f.getPoints());

		f.resetPoints();

		int[] v3 = { 2, 2, 5, 2, 3 };
		setDicesValue(v3);
		f.calculateAndStorePoints(dices);
		assertEquals(6, f.getPoints());

		f.resetPoints();

		int[] v4 = { 6, 2, 5, 2, 3 };
		setDicesValue(v4);
		f.calculateAndStorePoints(dices);
		assertEquals(4, f.getPoints());

		f.resetPoints();

		int[] v5 = { 6, 4, 5, 2, 3 };
		setDicesValue(v5);
		f.calculateAndStorePoints(dices);
		assertEquals(2, f.getPoints());

		f.resetPoints();

		int[] v6 = { 6, 4, 5, 1, 3 };
		setDicesValue(v6);
		f.calculateAndStorePoints(dices);
		assertEquals(0, f.getPoints());
	}

	@Test
	public void testThrees() {
		f = new FieldE(FieldType.Threes);

		int[] v1 = { 3, 3, 3, 3, 3 };
		setDicesValue(v1);
		f.calculateAndStorePoints(dices);
		assertEquals(15, f.getPoints());

		f.resetPoints();

		int[] v2 = { 1, 3, 3, 3, 3 };
		setDicesValue(v2);
		f.calculateAndStorePoints(dices);
		assertEquals(12, f.getPoints());

		f.resetPoints();

		int[] v3 = { 3, 3, 5, 3, 2 };
		setDicesValue(v3);
		f.calculateAndStorePoints(dices);
		assertEquals(9, f.getPoints());

		f.resetPoints();

		int[] v4 = { 6, 3, 5, 3, 2 };
		setDicesValue(v4);
		f.calculateAndStorePoints(dices);
		assertEquals(6, f.getPoints());

		f.resetPoints();

		int[] v5 = { 6, 4, 5, 3, 2 };
		setDicesValue(v5);
		f.calculateAndStorePoints(dices);
		assertEquals(3, f.getPoints());

		f.resetPoints();

		int[] v6 = { 6, 4, 5, 1, 2 };
		setDicesValue(v6);
		f.calculateAndStorePoints(dices);
		assertEquals(0, f.getPoints());
	}

	@Test
	public void testFours() {
		f = new FieldE(FieldType.Fours);

		int[] v1 = { 4, 4, 4, 4, 4 };
		setDicesValue(v1);
		f.calculateAndStorePoints(dices);
		assertEquals(20, f.getPoints());

		f.resetPoints();

		int[] v2 = { 4, 4, 4, 5, 4 };
		setDicesValue(v2);
		f.calculateAndStorePoints(dices);
		assertEquals(16, f.getPoints());

		f.resetPoints();

		int[] v3 = { 1, 4, 4, 5, 4 };
		setDicesValue(v3);
		f.calculateAndStorePoints(dices);
		assertEquals(12, f.getPoints());

		f.resetPoints();

		int[] v4 = { 1, 2, 4, 6, 4 };
		setDicesValue(v4);
		f.calculateAndStorePoints(dices);
		assertEquals(8, f.getPoints());

		f.resetPoints();

		int[] v5 = { 2, 3, 4, 5, 6 };
		setDicesValue(v5);
		f.calculateAndStorePoints(dices);
		assertEquals(4, f.getPoints());

		f.resetPoints();

		int[] v6 = { 1, 3, 2, 5, 6 };
		setDicesValue(v6);
		f.calculateAndStorePoints(dices);
		assertEquals(0, f.getPoints());

	}

	@Test
	public void testOfFives() {
		f = new FieldE(FieldType.Fives);

		int[] v1 = { 5, 5, 5, 5, 5 };
		setDicesValue(v1);
		f.calculateAndStorePoints(dices);
		assertEquals(25, f.getPoints());

		f.resetPoints();

		int[] v2 = { 1, 5, 5, 5, 5 };
		setDicesValue(v2);
		f.calculateAndStorePoints(dices);
		assertEquals(20, f.getPoints());

		f.resetPoints();

		int[] v3 = { 1, 3, 5, 5, 5 };
		setDicesValue(v3);
		f.calculateAndStorePoints(dices);
		assertEquals(15, f.getPoints());

		f.resetPoints();

		int[] v4 = { 1, 2, 4, 5, 5 };
		setDicesValue(v4);
		f.calculateAndStorePoints(dices);
		assertEquals(10, f.getPoints());

		f.resetPoints();

		int[] v5 = { 2, 6, 1, 3, 5 };
		setDicesValue(v5);
		f.calculateAndStorePoints(dices);
		assertEquals(5, f.getPoints());

		f.resetPoints();

		int[] v6 = { 1, 4, 3, 6, 2 };
		setDicesValue(v6);
		f.calculateAndStorePoints(dices);
		assertEquals(0, f.getPoints());

	}

	@Test
	public void testOfSixes() {
		f = new FieldE(FieldType.Sixes);

		int[] v1 = { 6, 6, 6, 6, 6 };
		setDicesValue(v1);
		f.calculateAndStorePoints(dices);
		assertEquals(30, f.getPoints());

		f.resetPoints();

		int[] v2 = { 1, 6, 6, 6, 6 };
		setDicesValue(v2);
		f.calculateAndStorePoints(dices);
		assertEquals(24, f.getPoints());

		f.resetPoints();

		int[] v3 = { 3, 5, 6, 6, 6 };
		setDicesValue(v3);
		f.calculateAndStorePoints(dices);
		assertEquals(18, f.getPoints());

		f.resetPoints();

		int[] v4 = { 1, 2, 6, 5, 6 };
		setDicesValue(v4);
		f.calculateAndStorePoints(dices);
		assertEquals(12, f.getPoints());

		f.resetPoints();

		int[] v5 = { 1, 2, 4, 6, 5 };
		setDicesValue(v5);
		f.calculateAndStorePoints(dices);
		assertEquals(6, f.getPoints());

		f.resetPoints();

		int[] v6 = { 1, 2, 3, 5, 4 };
		setDicesValue(v6);
		f.calculateAndStorePoints(dices);
		assertEquals(0, f.getPoints());

	}

	@Test
	public void testThreeOfOneKind() {
		f = new FieldE(FieldType.ThreeOfOneKind);

		int[] v1 = { 1, 1, 1, 4, 5 };
		setDicesValue(v1);
		f.calculateAndStorePoints(dices);
		assertEquals(12, f.getPoints());

		f.resetPoints();

		int[] v2 = { 2, 2, 2, 1, 5 };
		setDicesValue(v2);
		f.calculateAndStorePoints(dices);
		assertEquals(12, f.getPoints());

		f.resetPoints();

		int[] v3 = { 3, 3, 3, 6, 2 };
		setDicesValue(v3);
		f.calculateAndStorePoints(dices);
		assertEquals(17, f.getPoints());

		f.resetPoints();

		int[] v4 = { 1, 4, 4, 4, 5 };
		setDicesValue(v4);
		f.calculateAndStorePoints(dices);
		assertEquals(18, f.getPoints());

		f.resetPoints();

		int[] v5 = { 1, 5, 2, 5, 5 };
		setDicesValue(v5);
		f.calculateAndStorePoints(dices);
		assertEquals(18, f.getPoints());

		f.resetPoints();

		int[] v6 = { 6, 1, 6, 3, 6 };
		setDicesValue(v6);
		f.calculateAndStorePoints(dices);
		assertEquals(22, f.getPoints());

		f.resetPoints();

		int[] v7 = { 1, 1, 1, 1, 5 };
		setDicesValue(v7);
		f.calculateAndStorePoints(dices);
		assertEquals(9, f.getPoints());

		f.resetPoints();

		int[] v8 = { 1, 1, 1, 1, 1 };
		setDicesValue(v8);
		f.calculateAndStorePoints(dices);
		assertEquals(5, f.getPoints());

		f.resetPoints();

		int[] v9 = { 1, 1, 3, 4, 5 };
		setDicesValue(v9);
		f.calculateAndStorePoints(dices);
		assertEquals(0, f.getPoints());

		f.resetPoints();

		int[] v10 = { 1, 2, 3, 4, 5 };
		setDicesValue(v10);
		f.calculateAndStorePoints(dices);
		assertEquals(0, f.getPoints());

	}

	@Test
	public void testFourOfOneKind() {
		f = new FieldE(FieldType.FourOfOneKind);

		int[] v1 = { 1, 1, 1, 1, 5 };
		setDicesValue(v1);
		f.calculateAndStorePoints(dices);
		assertEquals(9, f.getPoints());

		f.resetPoints();

		int[] v2 = { 2, 2, 2, 2, 1 };
		setDicesValue(v2);
		f.calculateAndStorePoints(dices);
		assertEquals(9, f.getPoints());

		f.resetPoints();

		int[] v3 = { 3, 3, 3, 3, 2 };
		setDicesValue(v3);
		f.calculateAndStorePoints(dices);
		assertEquals(14, f.getPoints());

		f.resetPoints();

		int[] v4 = { 4, 4, 4, 4, 5 };
		setDicesValue(v4);
		f.calculateAndStorePoints(dices);
		assertEquals(21, f.getPoints());

		f.resetPoints();

		int[] v5 = { 1, 5, 5, 5, 5 };
		setDicesValue(v5);
		f.calculateAndStorePoints(dices);
		assertEquals(21, f.getPoints());

		f.resetPoints();

		int[] v6 = { 6, 6, 6, 6, 2 };
		setDicesValue(v6);
		f.calculateAndStorePoints(dices);
		assertEquals(26, f.getPoints());

		f.resetPoints();

		int[] v7 = { 1, 1, 1, 4, 5 };
		setDicesValue(v7);
		f.calculateAndStorePoints(dices);
		assertEquals(0, f.getPoints());

		f.resetPoints();

		int[] v8 = { 1, 1, 3, 4, 5 };
		setDicesValue(v8);
		f.calculateAndStorePoints(dices);
		assertEquals(0, f.getPoints());

		f.resetPoints();

		int[] v9 = { 1, 2, 3, 4, 5 };
		setDicesValue(v9);
		f.calculateAndStorePoints(dices);
		assertEquals(0, f.getPoints());

	}

	@Test
	public void testFullHouse() {
		f = new FieldE(FieldType.FullHouse);

		int[] v1 = { 1, 1, 1, 2, 2 };
		setDicesValue(v1);
		f.calculateAndStorePoints(dices);
		assertEquals(25, f.getPoints());

		f.resetPoints();

		int[] v2 = { 2, 2, 3, 3, 3 };
		setDicesValue(v2);
		f.calculateAndStorePoints(dices);
		assertEquals(25, f.getPoints());

		f.resetPoints();

		int[] v3 = { 1, 1, 2, 3, 3 };
		setDicesValue(v3);
		f.calculateAndStorePoints(dices);
		assertEquals(0, f.getPoints());

		f.resetPoints();

		int[] v4 = { 1, 1, 1, 2, 3 };
		setDicesValue(v4);
		f.calculateAndStorePoints(dices);
		assertEquals(0, f.getPoints());

		f.resetPoints();

		int[] v5 = { 1, 1, 1, 1, 3 };
		setDicesValue(v5);
		f.calculateAndStorePoints(dices);
		assertEquals(0, f.getPoints());

		f.resetPoints();

		int[] v6 = { 1, 1, 1, 1, 1 };
		setDicesValue(v6);
		f.calculateAndStorePoints(dices);
		assertEquals(0, f.getPoints());

	}

	@Test
	public void SmallStraight() {
		f = new FieldE(FieldType.SmallStraight);

		int[] v1 = { 1, 2, 3, 4, 1 };
		setDicesValue(v1);
		f.calculateAndStorePoints(dices);
		assertEquals(30, f.getPoints());

		f.resetPoints();

		int[] v2 = { 2, 3, 4, 5, 1 };
		setDicesValue(v2);
		f.calculateAndStorePoints(dices);
		assertEquals(30, f.getPoints());

		f.resetPoints();

		int[] v3 = { 3, 4, 5, 6, 2 };
		setDicesValue(v3);
		f.calculateAndStorePoints(dices);
		assertEquals(30, f.getPoints());

		f.resetPoints();

		int[] v4 = { 3, 2, 4, 4, 1 };
		setDicesValue(v4);
		f.calculateAndStorePoints(dices);
		assertEquals(30, f.getPoints());

		f.resetPoints();

		int[] v5 = { 5, 6, 3, 4, 1 };
		setDicesValue(v5);
		f.calculateAndStorePoints(dices);
		assertEquals(30, f.getPoints());

		f.resetPoints();

		int[] v6 = { 3, 2, 3, 4, 5 };
		setDicesValue(v6);
		f.calculateAndStorePoints(dices);
		assertEquals(30, f.getPoints());

		f.resetPoints();

		int[] v7 = { 1, 1, 3, 4, 1 };
		setDicesValue(v7);
		f.calculateAndStorePoints(dices);
		assertEquals(0, f.getPoints());

		f.resetPoints();

		int[] v8 = { 1, 1, 1, 4, 1 };
		setDicesValue(v8);
		f.calculateAndStorePoints(dices);
		assertEquals(0, f.getPoints());

		f.resetPoints();

		int[] v9 = { 1, 2, 3, 5, 6 };
		setDicesValue(v9);
		f.calculateAndStorePoints(dices);
		assertEquals(0, f.getPoints());

		f.resetPoints();

		int[] v10 = { 1, 4, 4, 2, 2 };
		setDicesValue(v10);
		f.calculateAndStorePoints(dices);
		assertEquals(0, f.getPoints());
		
	}

	@Test
	public void LargeStraight() {
		f = new FieldE(FieldType.LargeStraight);

		int[] v1 = { 1, 2, 3, 4, 5 };
		setDicesValue(v1);
		f.calculateAndStorePoints(dices);
		assertEquals(40, f.getPoints());

		f.resetPoints();
		
		int[] v2 = { 2, 3, 4, 5, 6 };
		setDicesValue(v2);
		f.calculateAndStorePoints(dices);
		assertEquals(40, f.getPoints());

		f.resetPoints();
		
		int[] v3 = { 1, 4, 2, 3, 5 };
		setDicesValue(v3);
		f.calculateAndStorePoints(dices);
		assertEquals(40, f.getPoints());

		f.resetPoints();
		
		int[] v4 = { 3, 4, 2, 5, 6 };
		setDicesValue(v4);
		f.calculateAndStorePoints(dices);
		assertEquals(40, f.getPoints());

		f.resetPoints();
		
		int[] v5 = {2, 3, 4, 1, 5 };
		setDicesValue(v5);
		f.calculateAndStorePoints(dices);
		assertEquals(40, f.getPoints());
		
		f.resetPoints();
		
		int[] v6 = { 1, 2, 3, 1, 1 };
		setDicesValue(v6);
		f.calculateAndStorePoints(dices);
		assertEquals(0, f.getPoints());

		f.resetPoints();
		
		int[] v7 = { 1, 2, 4, 2, 1 };
		setDicesValue(v7);
		f.calculateAndStorePoints(dices);
		assertEquals(0, f.getPoints());
		
		f.resetPoints();
		
		int[] v8 = { 2, 3, 4, 3, 3 };
		setDicesValue(v8);
		f.calculateAndStorePoints(dices);
		assertEquals(0, f.getPoints());
		
		f.resetPoints();
		
		int[] v9 = { 2, 3, 2, 2, 2 };
		setDicesValue(v9);
		f.calculateAndStorePoints(dices);
		assertEquals(0, f.getPoints());

		f.resetPoints();
		
		int[] v10 = { 1, 6, 1, 6, 1 };
		setDicesValue(v10);
		f.calculateAndStorePoints(dices);
		assertEquals(0, f.getPoints());
		
		f.resetPoints();

		int[] v11 = { 1, 1, 1, 1, 1 };
		setDicesValue(v11);
		f.calculateAndStorePoints(dices);
		assertEquals(0, f.getPoints());

	}

	@Test
	public void testKniffel() {
		f = new FieldE(FieldType.Kniffel);

		int[] v1 = { 1, 1, 1, 1, 1 };
		setDicesValue(v1);
		f.calculateAndStorePoints(dices);
		assertEquals(50, f.getPoints());

		f.resetPoints();

		int[] v2 = { 2, 2, 2, 2, 2 };
		setDicesValue(v2);
		f.calculateAndStorePoints(dices);
		assertEquals(50, f.getPoints());

		f.resetPoints();

		int[] v3 = { 3, 3, 3, 3, 3 };
		setDicesValue(v3);
		f.calculateAndStorePoints(dices);
		assertEquals(50, f.getPoints());

		f.resetPoints();

		int[] v4 = { 4, 4, 4, 4, 4 };
		setDicesValue(v4);
		f.calculateAndStorePoints(dices);
		assertEquals(50, f.getPoints());

		f.resetPoints();

		int[] v5 = { 5, 5, 5, 5, 5 };
		setDicesValue(v5);
		f.calculateAndStorePoints(dices);
		assertEquals(50, f.getPoints());

		f.resetPoints();

		int[] v6 = { 6, 6, 6, 6, 6 };
		setDicesValue(v6);
		f.calculateAndStorePoints(dices);
		assertEquals(50, f.getPoints());

		f.resetPoints();

		int[] v7 = { 1, 1, 1, 1, 4 };
		setDicesValue(v7);
		f.calculateAndStorePoints(dices);
		assertEquals(0, f.getPoints());

		f.resetPoints();

		int[] v8 = { 1, 1, 1, 2, 4 };
		setDicesValue(v8);
		f.calculateAndStorePoints(dices);
		assertEquals(0, f.getPoints());

		f.resetPoints();

		int[] v9 = { 1, 1, 3, 2, 4 };
		setDicesValue(v9);
		f.calculateAndStorePoints(dices);
		assertEquals(0, f.getPoints());

		f.resetPoints();

		int[] v10 = { 1, 5, 3, 2, 4 };
		setDicesValue(v10);
		f.calculateAndStorePoints(dices);
		assertEquals(0, f.getPoints());

		f.resetPoints();

		int[] v11 = { 1, 2, 3, 5, 6 };
		setDicesValue(v11);
		f.calculateAndStorePoints(dices);
		assertEquals(0, f.getPoints());

	}

	@Test
	public void testChance() {
		f = new FieldE(FieldType.Chance);

		int[] v1 = { 1, 2, 3, 4, 1 };
		setDicesValue(v1);
		f.calculateAndStorePoints(dices);
		assertEquals(11, f.getPoints());

		f.resetPoints();

		int[] v2 = { 1, 2, 3, 4, 6 };
		setDicesValue(v2);
		f.calculateAndStorePoints(dices);
		assertEquals(16, f.getPoints());

		f.resetPoints();

		int[] v3 = { 5, 6, 3, 4, 1 };
		setDicesValue(v3);
		f.calculateAndStorePoints(dices);
		assertEquals(19, f.getPoints());

		f.resetPoints();

		int[] v4 = { 1, 2, 3, 4, 5 };
		setDicesValue(v4);
		f.calculateAndStorePoints(dices);
		assertEquals(15, f.getPoints());

		f.resetPoints();

		int[] v5 = { 6, 6, 5, 5, 5 };
		setDicesValue(v5);
		f.calculateAndStorePoints(dices);
		assertEquals(27, f.getPoints());

		f.resetPoints();

		int[] v6 = { 1, 2, 3, 3, 3 };
		setDicesValue(v6);
		f.calculateAndStorePoints(dices);
		assertEquals(12, f.getPoints());

		f.resetPoints();

		int[] v7 = { 1, 2, 2, 4, 1 };
		setDicesValue(v7);
		f.calculateAndStorePoints(dices);
		assertEquals(10, f.getPoints());

	}

}
