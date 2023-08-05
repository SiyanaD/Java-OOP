package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut{

    //Has 70 initial units of oxygen.
    //The method breath() decreases the astronauts' oxygen by 5 units.
    //The constructor should take the following values upon initialization:
    //String name
    private static final double OXYGEN=70;

    public Biologist(String name) {
        super(name, OXYGEN);
    }

    //The method breath() decreases the astronauts' oxygen by 5 units.
    @Override
    public void breath() {
        this.setOxygen(this.getOxygen()-5);

    }


}
