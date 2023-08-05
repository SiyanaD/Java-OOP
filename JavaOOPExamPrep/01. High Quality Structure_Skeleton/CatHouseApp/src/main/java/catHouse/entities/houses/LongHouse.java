package catHouse.entities.houses;

public class LongHouse extends BaseHouse{
       //Has 30 capacity.
       // The constructor should take the following values upon initialization:
       //(String name)
    private static final int CAPACITY=30;

    public LongHouse(String name) {
        super(name, CAPACITY);
    }
}
