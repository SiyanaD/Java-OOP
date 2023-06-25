package WorkingWithAbstractionExercise.P3CardsWithPower;

public class CardCalculated {

    RankPowers rankPowers;
    SuitPowers suitPowers;

    public CardCalculated( RankPowers rankPowers, SuitPowers suitPowers) {
        this.rankPowers = rankPowers;
        this.suitPowers = suitPowers;
    }
    public int calculate(){
        return this.rankPowers.getValue()+this.suitPowers.getPowers();
    }
}
