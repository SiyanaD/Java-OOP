package PolymorphismExercises.p02VehiclesExtension;

public class Truck extends VehicleImp {
    public Truck(double fuelQuantity, double fuelConsumption,double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        //1.6 liters for the truck
        super.setFuelConsumption(fuelConsumption+1.6);
    }



    //Also, the truck has a tiny hole in
    //its tank and when it gets refueled it gets only 95% of the given fuel
    @Override
    public void refuel(double liters) {
        super.refuel(liters*0.95);
    }
}
