package vehicleShop.models.worker;

public class SecondShift extends BaseWorker {
    //Initial strength units: 70.
    private static final int STRENGTH = 70;

//The method working() decreases the workers' strength by additional 5 units.


    //The constructor should take the following values upon initialization:
     //(String name)
    public SecondShift(String name) {
        super(name, STRENGTH);
    }


}
