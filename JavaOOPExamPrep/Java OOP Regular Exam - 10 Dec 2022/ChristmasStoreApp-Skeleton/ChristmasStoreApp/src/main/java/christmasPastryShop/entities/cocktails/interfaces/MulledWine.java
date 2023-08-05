package christmasPastryShop.entities.cocktails.interfaces;

public class MulledWine extends BaseCocktail{
//The MulledWine has а constant value for mulledWinePrice – 3.50.
    private static final double MULLEDWINEPRICE = 3.50;
    public MulledWine(String name, int size, String brand) {
        super(name, size, MULLEDWINEPRICE, brand);
    }
}
