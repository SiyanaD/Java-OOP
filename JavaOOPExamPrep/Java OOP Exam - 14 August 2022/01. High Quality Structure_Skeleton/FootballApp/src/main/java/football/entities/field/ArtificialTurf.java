package football.entities.field;

public class ArtificialTurf extends BaseField{

    //Has 150 capacity
    private static final int CAPACITY=150;

    //The constructor should take the following values upon initialization:
    //String name
    public ArtificialTurf(String name) {
        super(name, CAPACITY);
    }
}
