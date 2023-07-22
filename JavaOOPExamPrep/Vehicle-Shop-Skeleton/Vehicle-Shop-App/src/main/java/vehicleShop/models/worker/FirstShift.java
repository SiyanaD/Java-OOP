package vehicleShop.models.worker;

public class FirstShift extends BaseWorker {

    //Initial strength units: 100.
private static final int STRENGTH=100;

    //The constructor should take the following values upon initialization:
    //(String name)
    public FirstShift(String name) {
        super(name, STRENGTH);
    }
}
