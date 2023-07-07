package PolymorphismExercises.p01Vehicles;

public class Car extends VehicleImp{


    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        //increased by 0.9 liters for the car
        super.setFuelConsumption(fuelConsumption+0.9);

    }
}
