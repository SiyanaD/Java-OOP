package WorkingWithAbstractionExercise.P3CardsWithPower;

public enum SuitPowers {

  CLUBS (0), DIAMONDS (13), HEARTS (26), SPADES (39);
    private int powers;

    SuitPowers(int powers) {
        this.powers = powers;
    }

    public int getPowers() {
        return powers;
    }
}
