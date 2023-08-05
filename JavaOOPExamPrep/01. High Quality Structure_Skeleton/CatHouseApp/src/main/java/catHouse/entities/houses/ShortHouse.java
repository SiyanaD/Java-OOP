package catHouse.entities.houses;

public class ShortHouse extends BaseHouse{

    //Has 15 capacity.
    //The constructor should take the following values upon initialization:
    //(String name)
    private static final int CAPACITY = 15;

    public ShortHouse(String name) {
        super(name, CAPACITY);
    }



}
