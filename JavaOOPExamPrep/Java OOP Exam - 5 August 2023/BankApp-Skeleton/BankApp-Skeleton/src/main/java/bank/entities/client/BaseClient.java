package bank.entities.client;

import bank.common.ExceptionMessages;

public abstract class BaseClient implements Client {
    private String name;
    private String ID;
    private int interest;
    private double income;

    public BaseClient(String name, String ID, int interest, double income) {
        this.setName(name);
        this.setID(ID);
        this.interest = interest;
        this.setIncome(income);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        //o	If the name is null or whitespace, throw a IllegalArgumentException with a message:
        //"Client name cannot be null or empty."
        if ((name==null || name.equals(""))){
            throw new IllegalArgumentException(ExceptionMessages.CLIENT_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        //o	If the ID is null or whitespace, throw a IllegalArgumentException with a message:
        //"Client’s ID cannot be null or empty."
        if ((ID==null || ID.equals(""))){
            throw new IllegalArgumentException(ExceptionMessages.CLIENT_ID_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.ID = ID;
    }

    @Override
    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    @Override
    public double getIncome() {
        return income;
    }

    //The increase() method increases the Client’s interest.
    // Keep in mind that some Client can implement the method differently.
    @Override
    public abstract void increase();



    public void setIncome(double income) {
        //o	If the income is below or equal to 0, throw an IllegalArgumentException with the message:
        // "Client income cannot be below or equal to 0."
        if (income<=0){
            throw new IllegalArgumentException(ExceptionMessages.CLIENT_INCOME_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
        }
        this.income = income;
    }
}
