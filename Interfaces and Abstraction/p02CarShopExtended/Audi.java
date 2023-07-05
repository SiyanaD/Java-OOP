package p02CarShopExtended;

public class Audi extends CarImpl implements Rentable{
    private Integer minRentDay;
    private Double pricePerDay;

    public Audi(String model, String color, Integer horsePower,
                String countryProduced, int minRentDay,double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDay=minRentDay;
        this.pricePerDay = pricePerDay;

    }

    @Override
    public Integer getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }
}
