package goldDigger.models.discoverer;

public class Archaeologist extends BaseDiscoverer{

    //Has 60 initial units of energy.
    private static final double ENERGY=60;
    //The constructor should take the following values upon an initialization:
    //String name
    public Archaeologist(String name) {
        super(name, ENERGY);
    }
}
