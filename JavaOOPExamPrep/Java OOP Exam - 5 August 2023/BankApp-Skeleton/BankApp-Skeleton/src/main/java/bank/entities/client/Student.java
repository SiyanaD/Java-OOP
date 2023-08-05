package bank.entities.client;

public class Student extends BaseClient{
    //Has initial interests of 2 percent.
    //Can only live in BranchBank!
    //The constructor should take the following values upon initialization:
    //(String name, String ID, double income)
    private static final int INTEREST=2;

    public Student(String name, String ID, double income) {
        super(name, ID, INTEREST/100, income);
    }

    //•	The method increases the client’s interest by 1 percent
    @Override
    public void increase() {
        this.setInterest(this.getInterest()+(1/100));

    }
}
