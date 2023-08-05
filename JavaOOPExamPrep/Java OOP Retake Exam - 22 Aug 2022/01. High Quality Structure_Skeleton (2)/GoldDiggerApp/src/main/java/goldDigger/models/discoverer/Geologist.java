package goldDigger.models.discoverer;

public class Geologist extends BaseDiscoverer{
    //Has initial 100 units of energy.

    private static final double ENERGY=100;

    //The constructor should take the following values upon an initialization:
    //String name
    public Geologist(String name) {
        super(name, ENERGY);
    }
}
