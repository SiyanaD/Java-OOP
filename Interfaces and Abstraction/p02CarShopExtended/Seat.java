package p02CarShopExtended;

public class Seat extends CarImpl implements Sellable {

    Double price;
    public Seat(String model, String color, Integer horsePower, String countryProduced,double price) {
        super(model, color, horsePower, countryProduced);
        this.price=price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
