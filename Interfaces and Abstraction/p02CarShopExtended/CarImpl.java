package p02CarShopExtended;

public class CarImpl implements Car {

    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;

    public CarImpl(String model, String color, Integer horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
    }
    @Override
    public String getModel() {
        return null;
    }

    @Override
    public String getColor() {
        return null;
    }

    @Override
    public Integer getHorsePower() {
        return null;
    }

    @Override
    public String countryProduced() {
        return null;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires\n",
                this.model,this.countryProduced, Car.TIRES);
    }
}
