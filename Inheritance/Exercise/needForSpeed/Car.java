package needForSpeed;

public class Car extends Vehicle{

    //Some of the classes have different default fuel consumption:
    //Car – DEFAULT_FUEL_CONSUMPTION = 3
    private static final double DEFAULT_FUEL_CONSUMPTION =3;
    public Car(double fuel, int horsePower) {
        super(fuel, horsePower);
        //Car – DEFAULT_FUEL_CONSUMPTION = 3-сменяме стойността на полето FuelConsumption спрямо Car която е 3 по условие
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
