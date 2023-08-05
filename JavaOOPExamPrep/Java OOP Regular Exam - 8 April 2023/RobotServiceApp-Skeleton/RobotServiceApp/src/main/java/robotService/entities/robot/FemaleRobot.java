package robotService.entities.robot;

public class FemaleRobot extends BaseRobot{
    //Has initial kilograms of 7.
    //Can only live in SecondaryService!
    //The constructor should take the following values upon initialization:
    //(String name, String kind, double price

    private static final int KILOGRAMS=7;

    public FemaleRobot(String name, String kind, double price) {
        super(name, kind, KILOGRAMS, price);
    }

    //•The method increases the robot’s kilograms by 1.
    @Override
    public void eating() {
     this.setKilograms(this.getKilograms()+1);
    }
}
