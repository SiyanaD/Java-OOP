package football.entities.supplement;

public class Liquid extends BaseSupplement{
    //It has 90 energy, and its price is 25.

    private static final int ENERGY=90;
    private static final double PRICE=25;

    //Constructors should take no values upon initialization
    public Liquid() {
        super(ENERGY, PRICE);
    }
}
