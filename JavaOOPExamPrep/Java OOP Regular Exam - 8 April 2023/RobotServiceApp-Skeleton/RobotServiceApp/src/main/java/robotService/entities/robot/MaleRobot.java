package robotService.entities.robot;

public class MaleRobot extends BaseRobot{
    //Has initial kilograms of 9.
    //Can only live in MainService!
    //The constructor should take the following values upon initialization:
    //(String name, String kind, double price)

    private static final int KILOGRAMS=9;

    public MaleRobot(String name, String kind, double price) {
        super(name, kind, KILOGRAMS, price);
    }

    //•	The method increases the robot’s kilograms by 3
    @Override
    public void eating() {

        this.setKilograms(this.getKilograms()+3);
    }
}
