package bank.entities.client;

public class Adult extends BaseClient{
    //Has initial interest of 4 percent.
    //Can only live in CentralBank!
    //The constructor should take the following values upon initialization:
    //(String name, String ID, double income)
    private static final int INTEREST=4;

    public Adult(String name, String ID, double income) {
        super(name, ID, INTEREST/100, income);
    }

    //•	The method increases the client’s interest by 2 percent.
    @Override
    public void increase() {
        this.setInterest(this.getInterest()+(2/100));

    }
}
