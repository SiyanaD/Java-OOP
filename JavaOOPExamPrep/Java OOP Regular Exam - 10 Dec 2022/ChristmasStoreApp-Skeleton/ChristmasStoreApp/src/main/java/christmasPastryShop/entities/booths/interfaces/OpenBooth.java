package christmasPastryShop.entities.booths.interfaces;

public class OpenBooth extends BaseBooth{
    //The OpenBooth has a constant value for pricePerPerson – 2.50.
    private static final double PRICEPERPERSON = 2.50;
    public OpenBooth(int boothNumber, int capacity) {
        super(boothNumber, capacity, PRICEPERPERSON);
    }
}
