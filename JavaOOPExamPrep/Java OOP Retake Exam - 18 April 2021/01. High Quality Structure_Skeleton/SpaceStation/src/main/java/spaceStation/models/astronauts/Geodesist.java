package spaceStation.models.astronauts;

public class Geodesist extends BaseAstronaut{

    //Has 50 initial units of oxygen.
    //The constructor should take the following values upon initialization:
    //String name
    private static final double OXYGEN=50;


    public Geodesist(String name) {

        super(name, OXYGEN);
    }
}
