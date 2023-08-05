package football.entities.supplement;

public abstract class BaseSupplement implements Supplement{
    //BaseSupplement is a base class of any type of supplement, and it should not be able to be instantiated - abstract
    private int energy;
    private double price;


    public BaseSupplement(int energy, double price) {
        this.energy = energy;
        this.price = price;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
