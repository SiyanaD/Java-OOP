package football.entities.field;

public class NaturalGrass extends BaseField{
    //Has 250 capacity
    private static final int CAPACITY=250;

    //The constructor should take the following values upon initialization:
    //String name
    public NaturalGrass(String name) {
        super(name, CAPACITY);
    }
}
