package bank.entities.loan;

public class MortgageLoan extends BaseLoan{
    //The mortgage loan has an interest rate of 3 and an amount of 50 000.
    private static final int INTERESTRATE = 3;
    private static final double AMOUNT = 50000;
    public MortgageLoan() {
        super(INTERESTRATE, AMOUNT);
    }
}
