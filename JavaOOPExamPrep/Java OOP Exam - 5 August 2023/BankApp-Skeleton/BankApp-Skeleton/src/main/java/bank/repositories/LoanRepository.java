package bank.repositories;

import bank.entities.loan.Loan;

import java.util.ArrayList;
import java.util.Collection;

public class LoanRepository implements Repository{
    private Collection<Loan> loans;

    public LoanRepository() {
        this.loans = new ArrayList<>();
    }

    //•	Adds a loan to the collection
    @Override
    public void addLoan(Loan loan) {
        this.loans.add(loan);

    }

    //•	Removes a loan from the collection. Returns true if the deletion was successful, otherwise - false
    @Override
    public boolean removeLoan(Loan loan) {
        return this.loans.remove(loan);
    }

    //•	Returns the first loan of the given type, if there is any. Otherwise, returns null
    @Override
    public Loan findFirst(String type) {
        return this.loans.stream().filter(t->t.getClass().getSimpleName().equals(type)).findFirst().orElse(null);
    }
}
