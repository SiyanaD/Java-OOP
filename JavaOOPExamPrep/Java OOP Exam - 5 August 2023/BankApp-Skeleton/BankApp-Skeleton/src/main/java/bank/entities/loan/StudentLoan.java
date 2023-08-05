package bank.entities.loan;

public class StudentLoan extends BaseLoan{

    //The student loan has an interest rate of 1 and an amount of 10 000

    private static final int INTERESTRATE = 1;
    private static final double AMOUNT = 10000;
    public StudentLoan() {
        super(INTERESTRATE, AMOUNT);
    }
}
