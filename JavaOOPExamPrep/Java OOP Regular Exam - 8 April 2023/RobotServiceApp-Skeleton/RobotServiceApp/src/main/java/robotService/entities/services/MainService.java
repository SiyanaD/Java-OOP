package robotService.entities.services;

public class MainService extends BaseService{
    //Has 30 capacity.
    //The constructor should take the following values upon initialization:
    //(String name)
    private static final int CAPACITY=30;

    public MainService(String name) {
        super(name, CAPACITY);
    }
}
