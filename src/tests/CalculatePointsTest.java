package tests;

import logic.Dice;
import logic.Field;
import logic.FieldType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatePointsTest {


    Dice[] dices = new Dice[5];

    public void setDicesValue(int[] values) {
        for (int i = 0; i < dices.length; i++) {
            dices[i] = new Dice(values[i]);
        }
    }

    // Aces, Twos, Threes, Fours, Fives, Sixes

    @Test
    public void testAces() {
        Field f = new Field(FieldType.Aces);
        int[] v1 = {1, 1, 1, 1, 1};
        setDicesValue(v1);
        f.updatePoints(dices);
        assertEquals(5, f.getPoints());

        int[] v2 = {1, 1, 1, 1, 3};
        setDicesValue(v2);
        f.updatePoints(dices);
        assertEquals(4, f.getPoints());

        int[] v3 = {1, 1, 5, 1, 3};
        setDicesValue(v1);
        f.updatePoints(dices);
        assertEquals(3, f.getPoints());

        int[] v4 = {6, 1, 5, 1, 3};
        setDicesValue(v1);
        f.updatePoints(dices);
        assertEquals(2, f.getPoints());

        int[] v5 = {6, 4, 5, 1, 3};
        setDicesValue(v1);
        f.updatePoints(dices);
        assertEquals(1, f.getPoints());

        int[] v6 = {6, 4, 5, 2, 3};
        setDicesValue(v1);
        f.updatePoints(dices);
        assertEquals(0, f.getPoints());

    }

    @Test
    public void testTwos() {
        Field f = new Field(FieldType.Twos);
        int[] v1 = {2, 2, 2, 2, 2};
        setDicesValue(v1);
        f.updatePoints(dices);
        assertEquals(10, f.getPoints());

        int[] v2 = {1, 2, 2, 2, 3};
        setDicesValue(v2);
        f.updatePoints(dices);
        assertEquals(8, f.getPoints());

        int[] v3 = {2, 2, 5, 2, 3};
        setDicesValue(v3);
        f.updatePoints(dices);
        assertEquals(6, f.getPoints());

        int[] v4 = {6, 2, 5, 2, 3};
        setDicesValue(v4);
        f.updatePoints(dices);
        assertEquals(4, f.getPoints());

        int[] v5 = {6, 4, 5, 2, 3};
        setDicesValue(v5);
        f.updatePoints(dices);
        assertEquals(2, f.getPoints());

        int[] v6 = {6, 4, 5, 1, 3};
        setDicesValue(v6);
        f.updatePoints(dices);
        assertEquals(0, f.getPoints());
    }

    @Test
    public void testThrees() {
        Field f = new Field(FieldType.Threes);
        int[] v1 = {3, 3, 3, 3, 3};
        setDicesValue(v1);
        f.updatePoints(dices);
        assertEquals(15, f.getPoints());

        int[] v2 = {1, 3, 3, 3, 2};
        setDicesValue(v2);
        f.updatePoints(dices);
        assertEquals(12, f.getPoints());

        int[] v3 = {3, 3, 5, 3, 2};
        setDicesValue(v3);
        f.updatePoints(dices);
        assertEquals(9, f.getPoints());

        int[] v4 = {6, 3, 5, 3, 2};
        setDicesValue(v4);
        f.updatePoints(dices);
        assertEquals(6, f.getPoints());

        int[] v5 = {6, 4, 5, 3, 2};
        setDicesValue(v5);
        f.updatePoints(dices);
        assertEquals(3, f.getPoints());

        int[] v6 = {6, 4, 5, 1, 2};
        setDicesValue(v6);
        f.updatePoints(dices);
        assertEquals(0, f.getPoints());
    }

    // ThreeOfOneKind, FourOfOneKind, Kniffel

    @Test
    public void testThreeOfOneKind() {
        Field f = new Field(FieldType.ThreeOfOneKind);
        int[] v1 = {1, 2, 3, 4, 5};
        setDicesValue(v1);
        f.updatePoints(dices);
        assertEquals(0, f.getPoints());
    }


    // FullHouse

    // SmallStraight, LargeStraight

    // Chance


}
