package PolymorphismExercises.p02VehiclesExtension;

public class Car extends VehicleImp {


    public Car(double fuelQuantity, double fuelConsumption,double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        //increased by 0.9 liters for the car
        super.setFuelConsumption(fuelConsumption+0.9);

    }
}
