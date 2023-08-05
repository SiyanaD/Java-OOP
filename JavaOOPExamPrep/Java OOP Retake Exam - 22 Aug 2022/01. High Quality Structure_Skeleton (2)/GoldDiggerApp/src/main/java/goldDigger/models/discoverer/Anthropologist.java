package goldDigger.models.discoverer;

public class Anthropologist extends BaseDiscoverer{
    //Has 40 initial units of energy.
    private static final double ENERGY=40;
    //The constructor should take the following values upon an initialization:
    //String name
    public Anthropologist(String name) {
        super(name, ENERGY);
    }
}
