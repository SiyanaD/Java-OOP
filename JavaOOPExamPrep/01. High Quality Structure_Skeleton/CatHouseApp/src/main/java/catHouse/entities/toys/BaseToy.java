package catHouse.entities.toys;

public abstract class BaseToy implements Toy {
    //•	softness - int
    //•	price - double
    private int softness;
    private double price;


    public BaseToy(int softness, double price) {
        this.softness = softness;
        this.price = price;
    }

    @Override
    public int getSoftness() {
        return this.softness;
    }

    public void setSoftness(int softness) {
        this.softness = softness;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
