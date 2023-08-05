package goldDigger.models.discoverer;

import goldDigger.common.ExceptionMessages;
import goldDigger.models.museum.BaseMuseum;
import goldDigger.models.museum.Museum;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseDiscoverer implements Discoverer{
    //BaseDiscoverer is a base class or any type of discoverer and should not be instantiated - abstract
    private String name;
    private double energy;


    //o	A Museum field type. - BaseMuseum създаваме в Museum
   private Museum museum;

    public BaseDiscoverer(String name, double energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.museum=new BaseMuseum();

    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        //o	If the value of the name is either null or empty (containing only whitespaces),
        // throw a NullPointerException with the following message: "Discoverer name cannot be null or empty."
        //o	The values of the names are unique.
        if (name==null || name.equals("")){
            throw new NullPointerException(ExceptionMessages.DISCOVERER_NAME_NULL_OR_EMPTY);
        }


        this.name = name;
    }

    @Override
    public double getEnergy() {
        return energy;
    }


    public void setEnergy(double energy) {
        //o	If the energy is a negative number, throw an IllegalArgumentException with
        // the following message: "Cannot create Discoverer with negative energy."
        if (energy<0){
            throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    @Override
    public Museum getMuseum() {
        return museum;
    }


    public void setMuseum(Museum museum) {
        this.museum = museum;
    }


    @Override
    public void dig() {
        //The dig() method decreases the discoverer's energy. Keep in mind that some Discoverer types can implement the method differently.
        //•	The method decreases the discoverer's energy by 15 units.
        //•	The energy value should not drop below zero.
        //•	Set the value to be zero if the energy value goes below zero.
        if (this.energy<0){
            this.energy=0;
        }
        //•	The method decreases the discoverer's energy by 15 units.
        this.setEnergy(this.getEnergy()-15);

    }
    @Override
    public boolean canDig() {
        //The canDig() method returns boolean. Tell us if the energy is more than zero.
        return energy>0;
    }

}
