package spaceStation.models.astronauts;

import spaceStation.common.ExceptionMessages;
import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;

public abstract class BaseAstronaut implements Astronaut {
    //BaseAstronaut is a base class or any type of astronaut and it should not be able to be instantiated.- public abstract class
    private String name;
    private double oxygen;
    private Bag bag;//o	A field of type Backpack.


    //Constructor
    //A BaseAstronaut should take the following values upon initialization:
    //String name, double oxygen
    public BaseAstronaut(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.bag=new Backpack();//o	A field of type Backpack - вместо Bag слегаме Backpack когато го създадем
    }


    @Override
    public String getName() {
        return name;
    }

    //o	If the name is null or whitespace, throw a NullPointerException with a message: "Astronaut name cannot be null or empty."
    //o	All names are unique
    public void setName(String name) {
        if ((name==null || name.equals(""))){
            throw new NullPointerException(ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public double getOxygen() {
        return oxygen;
    }

    @Override
    public boolean canBreath() {
        return false;
    }


    //o	The oxygen of аn astronaut.
    //o	If the oxygen is below 0, throw an IllegalArgumentException with a message:
    // "Cannot create Astronaut with negative oxygen!"
    public void setOxygen(double oxygen) {
        if (oxygen<0){
            throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }

        this.oxygen = oxygen;
    }

    @Override
    public Bag getBag() {
        return bag;
    }


    //The breath() method decreases astronauts' oxygen.
    // Keep in mind that some types of Astronaut can implement the method differently.
    //•	The method decreases the astronauts' oxygen by 10 units.
    @Override
    public void breath() {
        this.setOxygen(this.getOxygen()-10);

    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }
}
