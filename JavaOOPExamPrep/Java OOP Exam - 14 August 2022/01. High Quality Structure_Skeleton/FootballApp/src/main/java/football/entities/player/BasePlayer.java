package football.entities.player;

import football.common.ExceptionMessages;

public abstract class BasePlayer implements Player{
    //BasePlayer is a base class of any type of player, and it should not be able to be instantiated - abstract

    private String name;
    private String nationality;
    private double kg;
    private int strength;

    public BasePlayer(String name, String nationality, double kg, int strength) {
        this.setName(name);
        this.setNationality(nationality);
        this.kg = kg;
        this.setStrength(strength);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        //o	If the name is null or whitespace, throw a NullPointerException with a message:
        //"Player name cannot be null or empty."
        //o	All names are unique.
        if ((name==null || name.equals(""))){
            throw new NullPointerException(ExceptionMessages.PLAYER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }


    //The stimulation() method increases the Player's strength.
    // Keep in mind that different type of Player can implement the method differently.
    //правим го абстрактен
    @Override
    public abstract void stimulation();


    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        //o	If the type is null or whitespace, throw a NullPointerException with а message:
        //"Player nationality cannot be null or empty."
        if ((nationality==null || nationality.equals(""))){
            throw new NullPointerException(ExceptionMessages.PLAYER_NATIONALITY_NULL_OR_EMPTY);
        }

        this.nationality = nationality;
    }

    @Override
    public double getKg() {
        return kg;
    }

    public void setKg(double kg) {
        this.kg = kg;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        //o	If the strength is below or equal to 0, throw an IllegalArgumentException with а message:
        // "Players strength cannot be below or equal to 0."
        if (strength<=0){
            throw new IllegalArgumentException(ExceptionMessages.PLAYER_STRENGTH_BELOW_OR_EQUAL_ZERO);
        }
        this.strength = strength;
    }
}
