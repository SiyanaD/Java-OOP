package needForSpeed;

public class Vehicle {
   private static final double DEFAULT_FUEL_CONSUMPTION =1.25;

private double fuelConsumption;
private double fuel;//налични литри гориво
    private int horsePower;

    //A public constructor which accepts (fuel, horsePower)
    public Vehicle(double fuel, int horsePower) {
        this.fuel = fuel;
        this.horsePower = horsePower;
        //set the default fuel consumption on the field
        //fuelConsumption
        this.fuelConsumption=DEFAULT_FUEL_CONSUMPTION;

    }


    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
    public void drive (double kilometers){
        //The drive method should have the functionality to reduce the fuel based on the traveled
        //kilometers and fuel consumption. Keep in mind that you can drive the vehicle only if you have
        //enough fuel to finish the driving.
        //1. колко гориво ще изгорим ако минем километрите
        double fuelConsumed = kilometers*getFuelConsumption();
        //2. проверка дали горивото което имаме ще стигне
        if (this.getFuel()>=fuelConsumed){
            double leftFuel = this.getFuel()-fuelConsumed;
            this.setFuel(leftFuel);//променяме горивото
        }
    }
}
