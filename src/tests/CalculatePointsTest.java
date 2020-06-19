package tests;

import logic.Dice;
import logic.Field;
import logic.FieldType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatePointsTest {

    // Aces, Twos, Threes, Fours, Fives, Sixes
    Dice[] dices = new Dice[5];

    public void setDicesValue(int[] values) {
        for(int i = 0; i < dices.length; i++) {
            dices[i] = new Dice(values[i]);
        }
    }

    @Test
    public void testAces() {
        Field f = new Field(FieldType.Aces);
        int [] v1 = {1, 1, 1, 1, 1};
        setDicesValue(v1);
        assertEquals(5, f.returnPoints(dices));

        int [] v2 = {1, 1, 1, 1, 3};
        setDicesValue(v2);
        assertEquals(4, f.returnPoints(dices));

        int [] v3 = {1, 1, 5, 1, 3};
        setDicesValue(v1);
        assertEquals(3, f.returnPoints(dices));

        int [] v4 = {6, 1, 5, 1, 3};
        setDicesValue(v1);
        assertEquals(2, f.returnPoints(dices));

        int [] v5 = {6, 4, 5, 1, 3};
        setDicesValue(v1);
        assertEquals(1, f.returnPoints(dices));

        int [] v6 = {6, 4, 5, 2, 3};
        setDicesValue(v1);
        assertEquals(0, f.returnPoints(dices));
    }

    @Test
    public void testTwos() {
        Field f = new Field(FieldType.Twos);
        int [] v1 = {2, 2, 2, 2, 2};
        setDicesValue(v1);
        assertEquals(10, f.returnPoints(dices));

        int [] v2 = {1, 2, 2, 2, 3};
        setDicesValue(v2);
        assertEquals(8, f.returnPoints(dices));

        int [] v3 = {2, 2, 5, 2, 3};
        setDicesValue(v1);
        assertEquals(6, f.returnPoints(dices));

        int [] v4 = {6, 2, 5, 2, 3};
        setDicesValue(v1);
        assertEquals(4, f.returnPoints(dices));

        int [] v5 = {6, 4, 5, 2, 3};
        setDicesValue(v1);
        assertEquals(2, f.returnPoints(dices));

        int [] v6 = {6, 4, 5, 1, 3};
        setDicesValue(v1);
        assertEquals(0, f.returnPoints(dices));
    }

    @Test
    public void testThrees() {
        Field f = new Field(FieldType.Threes);
        int [] v1 = {3, 3, 3, 3, 3};
        setDicesValue(v1);
        assertEquals(10, f.returnPoints(dices));

        int [] v2 = {1, 3, 3, 3, 2};
        setDicesValue(v2);
        assertEquals(8, f.returnPoints(dices));

        int [] v3 = {3, 3, 5, 3, 2};
        setDicesValue(v1);
        assertEquals(6, f.returnPoints(dices));

        int [] v4 = {6, 3, 5, 3, 2};
        setDicesValue(v1);
        assertEquals(4, f.returnPoints(dices));

        int [] v5 = {6, 4, 5, 3, 2};
        setDicesValue(v1);
        assertEquals(2, f.returnPoints(dices));

        int [] v6 = {6, 4, 5, 1, 2};
        setDicesValue(v1);
        assertEquals(0, f.returnPoints(dices));
    }

    // ThreeOfOneKind, FourOfOneKind, FullHouse, SmallStraight, LargeStraight, Kniffel, Chance


}
