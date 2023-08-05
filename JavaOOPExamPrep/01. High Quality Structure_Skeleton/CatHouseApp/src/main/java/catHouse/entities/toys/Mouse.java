package catHouse.entities.toys;

public class Mouse extends BaseToy{
    //The mouse has a softness of 5 and a price of 15.
    //Note: The Constructor should take no values upon initialization.
    private static final int SOFTNESS = 5;
    private static final double PRICE = 15;


    public Mouse() {
        super(SOFTNESS, PRICE);
    }
}
