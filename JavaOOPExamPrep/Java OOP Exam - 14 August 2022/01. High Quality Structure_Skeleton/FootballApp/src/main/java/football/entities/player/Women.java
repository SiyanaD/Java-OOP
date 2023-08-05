package football.entities.player;

public class Women extends BasePlayer{

    //Has initial kilograms of 60.00.
    //I can only play on ArtificialTurf!

    private static final double KG=60.00;



    //The constructor should take the following values upon initialization:
    //(String name, String nationality, int strength)
    public Women(String name, String nationality, int strength) {
        super(name, nationality, KG, strength);
    }

    //•	The method increases the player's strength by 115.
    @Override
    public void stimulation() {

        this.setStrength(this.getStrength()+115);
    }
}
