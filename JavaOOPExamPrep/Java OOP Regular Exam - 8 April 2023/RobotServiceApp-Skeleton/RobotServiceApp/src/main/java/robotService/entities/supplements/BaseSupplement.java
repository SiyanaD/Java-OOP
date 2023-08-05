package robotService.entities.supplements;

public abstract class BaseSupplement implements Supplement{
    //BaseSupplement is a base class of any type of supplement and it should not be able to be instantiated - abstract
    private int hardness;
    private double price;


    //Constructor
    //A BaseSupplement should take the following values upon initialization:
    //(int hardness, double price)
    public BaseSupplement(int hardness, double price) {
        this.hardness = hardness;
        this.price = price;
    }

    @Override
    public int getHardness() {
        return hardness;
    }

    public void setHardness(int hardness) {
        this.hardness = hardness;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
