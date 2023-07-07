package PolymorphismExercises.p02VehiclesExtension;

public class Bus extends VehicleImp{

    private static final boolean DEFAULT_IS_EMPTY=true;

    private boolean isEmpty;



    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {

        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {

        //. If the bus is driving with people, the airconditioner is turned on
        // and its fuel consumption per kilometer is increased by 1.4 liters
        if (!this.isEmpty){
        super.setFuelConsumption(fuelConsumption+1.4);
        }
    }
}
