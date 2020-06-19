package logic;

public class TestMain {

    public static void main(String[] args) {
        int n = 1;
        Field f = new Field(FieldType.SmallStraight);
        Dice[] dices = new Dice[5];
        while(n <= 3) {
            System.out.println("\n** " + n + ". Wurf: **");
            for (int i = 0; i < dices.length; i++) {
                dices[i] = new Dice();
                System.out.print((i + 1) + ": [" + dices[i].getValue() + "]  ");
            }
            dices[4].roll();
            dices[1].roll();
            n++;
        }
        System.out.println("\nEintragen als kleine Straße - Punktzahl: "+ f.returnPoints(dices));
    }
}
