package christmasPastryShop.entities.cocktails.interfaces;

public class Hibernation extends BaseCocktail{
    //The Hibernation has а constant value for hibernationPrice – 4.50
    private static final double HIBERNATIONPRICE = 4.50;
    public Hibernation(String name, int size, String brand) {
        super(name, size, HIBERNATIONPRICE, brand);
    }
}
