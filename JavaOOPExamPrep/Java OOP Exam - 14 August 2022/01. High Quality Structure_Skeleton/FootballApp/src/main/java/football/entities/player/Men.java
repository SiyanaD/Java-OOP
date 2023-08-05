package football.entities.player;

public class Men extends BasePlayer{

    //Has initial kilograms of 85.50.
    //I can only play on NaturalGrass!
    private static final double KG=85.50;


    //The constructor should take the following values upon initialization:
    //(String name, String nationality, int strength)
    public Men(String name, String nationality, int strength) {
        super(name, nationality, KG, strength);
    }

    //•	The method increases the player's strength by 145
    @Override
    public void stimulation() {
        this.setStrength(this.getStrength()+145);

    }
}
