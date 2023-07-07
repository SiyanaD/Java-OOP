package PolymorphismExercises.p02VehiclesExtension;

import java.text.DecimalFormat;

public abstract class VehicleImp implements Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;



    //Now
    //every vehicle has tank capacity
    private  double tankCapacity;

    public VehicleImp(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.setTankCapacity(tankCapacity);
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
        //If fuel quantity becomes less than 0 print
        //on the console "Fuel must be a positive number")
        if (liters<=0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        double newFuelQuantity = this.fuelQuantity+liters;

        //If you try to put more fuel in the tank than
        //the available space, print on the console "Cannot fit fuel in tank"
if (newFuelQuantity>this.tankCapacity){
    throw new IllegalArgumentException("Cannot fit fuel in tank");
}

        this.fuelQuantity+=liters;

    }
    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
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
