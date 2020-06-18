package logic;

public class GameField {

    public int computePoints(FieldType fieldType, Dice[] dices) {
        int result;
        switch(fieldType) {
            case Einser:
                result = returnPointsforEinser(dices);
            case Zweier:
                result = returnPointsforZweier(dices);
            case Dreier:
                result = returnPointsforDreier(dices);
            case Vierer:
                result = returnPointsforVierer(dices);
            case Fuenfer:
                result = returnPointsforFuenfer(dices);
            case Sechser:
                result = returnPointsforSechser(dices);
            case Dreierpasch:
                result = returnPointsforDreierpasch(dices);
            case Viererpasch:
                result = returnePointsforViererpasch(dices);
            case FullHouse:
                result = returnPointsforFullHouse(dices);
            case KleineStraße:
                result = returnPointsforKleineStraße(dices);
            case GroßeStraße:
                result = returnPointsforGroßeStraße(dices);
            case Kniffel:
                result = returnPointsforKniffel(dices);
            case Chance:
                result = returnPointsforChance(dices);
            default:
                result = 0;
        }

    }

    private int returnPointsforEinser(Dice[] dices) {
        return 0;
    }

    private int returnPointsforZweier(Dice[] dices) {
        return 0;
    }

    private int returnPointsforDreier(Dice[] dices) {
        return 0;
    }

    private int returnPointsforVierer(Dice[] dices) {
        return 0;
    }

    private int returnPointsforFuenfer(Dice[] dices) {
        return 0;
    }

    private int returnPointsforSechser(Dice[] dices) {
        return 0;
    }

    private int returnPointsforDreierpasch(Dice[] dices) {
        return 0;
    }

    private int returnePointsforViererpasch(Dice[] dices) {
        return 0;
    }

    private int returnPointsforFullHouse(Dice[] dices) {
        return 0;
    }

    private int returnPointsforKleineStraße(Dice[] dices) {
        return 0;
    }

    private int returnPointsforGroßeStraße(Dice[] dices) {
        return 0;
    }

    private int returnPointsforKniffel(Dice[] dices) {
        return 0;
    }

    private int returnPointsforChance(Dice[] dices) {
        return 0;
    }

}
