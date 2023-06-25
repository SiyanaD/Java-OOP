package WorkingWithAbstractionLab.P04HotelReservation;

public enum Discount {
    None(1),SecondVisit(0.90),VIP(0.80);
    private double value;

    Discount(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
