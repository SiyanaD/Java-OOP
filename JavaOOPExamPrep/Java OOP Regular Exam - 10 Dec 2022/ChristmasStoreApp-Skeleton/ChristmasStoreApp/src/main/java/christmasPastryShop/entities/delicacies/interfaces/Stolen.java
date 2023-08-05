package christmasPastryShop.entities.delicacies.interfaces;

public class Stolen extends BaseDelicacy{

    //The Stolen has a constant value for InitialStolenPortion – 250.
private static final double INITIALSTOLENPORTION = 250;
    public Stolen(String name, double price) {
        super(name, INITIALSTOLENPORTION, price);
    }
}
