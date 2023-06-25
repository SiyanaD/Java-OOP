package WorkingWithAbstractionLab.P04HotelReservation;

public class PriceCalculator {

    //price per day, number of
    //days, the season, and a discount type.

    private double pricePerDay;
    private int numberOfDays;
    Season season;
    Discount discount;

    public PriceCalculator(double pricePerDay, int numberOfDays, Season season, Discount discount) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discount = discount;}
   public double calculate() {
        return this.pricePerDay*
                this.numberOfDays*
                this.season.getValue() *
                this.discount.getValue();

    }

}
