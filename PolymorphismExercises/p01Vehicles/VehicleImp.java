package PolymorphismExercises.p01Vehicles;

import java.text.DecimalFormat;

public abstract class VehicleImp implements Vehicle {
    //r. Car and truck both have fuel quantity,
    // and fuel consumption in liters per km and can be driven given
    //distance and refueled with given liters.
    private double fuelQuantity;
    private double fuelConsumption;

    public VehicleImp(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
       this.setFuelConsumption(fuelConsumption);
    }


    @Override
    public String drive(double distance) {
        double neededFuel = this.fuelConsumption * distance;


        DecimalFormat df = new DecimalFormat("#.##");
        //Or if it is not:
        //"Car/Truck needs refueling"
        String result = String.format("%s needs refueling",this.getClass().getSimpleName());
        //this.getClass().getSimpleName() -> взима Car или Truck



        //After each Drive command print whether the Car/Truck was able to travel a given distance in format if it’s
        //successful. Print the distance with two digits after the decimal separator except for trailing zeros. Use the
        //DecimalFormat class:
        //"Car/Truck travelled {distance} km"
        //проверяваме дали имаме достатъчно място в резервоара
        if (this.fuelQuantity>=neededFuel){
            //todo print message

            result= String.format("%s travelled %s km",
                    this.getClass().getSimpleName(),df.format(distance));

            //намаляме горивото
            this.fuelQuantity-=neededFuel;
        }

        return result;
    }

    @Override
    public void refuel(double liters) {
        this.fuelQuantity+=liters;

    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }


    //Finally, print the remaining fuel for both car and truck rounded 2 digits after the floating point in the format:
    //"Car: {liters}
    //Truck: {liters}"
    @Override
    public String toString() {
        return String.format("%s: %.2f",
                this.getClass().getSimpleName(),this.fuelQuantity);
    }
}
