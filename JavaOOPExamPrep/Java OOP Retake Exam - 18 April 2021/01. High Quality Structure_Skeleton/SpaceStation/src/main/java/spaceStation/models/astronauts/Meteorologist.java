package spaceStation.models.astronauts;

public class Meteorologist extends BaseAstronaut{

    //Has initial 90 units of oxygen.
    //The constructor should take the following values upon initialization:
    //String name
    private static final double OXYGEN=90;
    public Meteorologist(String name) {
        super(name, OXYGEN);
    }
}
