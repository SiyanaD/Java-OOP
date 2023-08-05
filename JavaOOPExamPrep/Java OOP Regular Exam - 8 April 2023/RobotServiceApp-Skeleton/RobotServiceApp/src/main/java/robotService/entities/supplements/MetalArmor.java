package robotService.entities.supplements;

public class MetalArmor extends BaseSupplement{

    //The metal armor has a hardness of 5 and a price of 15.
    //Note: The Constructor should take no values upon initialization.
    private static final int HARDNESS=5;
    private static final double PRICE=15;

    public MetalArmor() {
        super(HARDNESS, PRICE);
    }
}
