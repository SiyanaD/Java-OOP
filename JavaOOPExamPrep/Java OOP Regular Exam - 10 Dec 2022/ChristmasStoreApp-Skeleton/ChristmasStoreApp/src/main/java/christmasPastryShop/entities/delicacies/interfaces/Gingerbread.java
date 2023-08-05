package christmasPastryShop.entities.delicacies.interfaces;

public class Gingerbread extends BaseDelicacy{
    //The Gingerbread has a constant value for InitialGingerbreadPortion – 200
    private static final double INITIALPORTION =200;

    public Gingerbread(String name, double price) {
        super(name, INITIALPORTION, price);
    }

}
