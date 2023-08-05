package football.entities.supplement;

public class Powdered extends BaseSupplement{
//It has 120 energy, and its price is 15.

    private static final int ENERGY=120;
    private static final double PRICE=15;

    //Constructors should take no values upon initialization.
    public Powdered() {
        super(ENERGY, PRICE);
    }
}
