package logic;

public class GameField {

    public int computePoints(FieldType fieldType, int[] dices) {
        switch(fieldType) {
            case Einser:
                return returnPointsforEinser(dices);
            case Zweier:
                return returnPointsforZweier(dices);
            case Dreier:
                return returnPointsforDreier(dices);
            case Vierer:
                return returnPointsforVierer(dices);
            case Fuenfer:
                return returnPointsforFuenfer(dices);
            case Sechser:
                return returnPointsforSechser(dices);
            case Dreierpasch:
                return returnPointsforDreierpasch(dices);
            case Viererpasch:
                return returnePointsforViererpasch(dices);
            case FullHouse:
                return returnPointsforFullHouse(dices);
            case KleineStraße:
                return returnPointsforKleineStraße(dices);
            case GroßeStraße:
                return returnPointsforGroßeStraße(dices);
            case Kniffel:
                return returnPointsforKniffel(dices);
            case Chance:
                return returnPointsforChance(dices);
            default:
                return -1;
        }
    }

    private int returnPointsforEinser(int[] dices) {
        return 0;
    }

    private int returnPointsforZweier(int[] dices) {
        return 0;
    }

    private int returnPointsforDreier(int[] dices) {
        return 0;
    }

    private int returnPointsforVierer(int[] dices) {
        return 0;
    }

    private int returnPointsforFuenfer(int[] dices) {
        return 0;
    }

    private int returnPointsforSechser(int[] dices) {
        return 0;
    }

    private int returnPointsforDreierpasch(int[] dices) {
        return 0;
    }

    private int returnePointsforViererpasch(int[] dices) {
        return 0;
    }

    private int returnPointsforFullHouse(int[] dices) {
        return 0;
    }

    private int returnPointsforKleineStraße(int[] dices) {
        return 0;
    }

    private int returnPointsforGroßeStraße(int[] dices) {
        return 0;
    }

    private int returnPointsforKniffel(int[] dices) {
        return 0;
    }

    private int returnPointsforChance(int[] dices) {
        return 0;
    }

}
