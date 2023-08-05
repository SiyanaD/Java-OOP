package bank.entities.bank;

import bank.common.ExceptionMessages;
import bank.entities.client.Client;
import bank.entities.loan.Loan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseBank implements Bank{
    private String name;
    private int capacity;
    private Collection<Loan> loans;
    private Collection<Client> clients;

    public BaseBank(String name, int capacity) {

        this.setName(name);
        this.capacity = capacity;
        this.loans=new ArrayList<>();
        this.clients=new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        //o	If the name is null or whitespace, throw an IllegalArgumentException with a message:
        //"Bank name cannot be null or empty."
        if ((name==null || name.equals(""))){
            throw new IllegalArgumentException(ExceptionMessages.BANK_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public Collection<Loan> getLoans() {
        return loans;
    }

    @Override
    public void addClient(Client client) {
        //Adds a Client in the Bank if there is a capacity for it.
        //If there is not enough capacity to add the Client to the Bank,
        // throw an IllegalStateException with the following message:
        //•	"Not enough capacity for this client."
        if (this.getClients().size()>=this.capacity){
            throw new IllegalStateException(ExceptionMessages.NOT_ENOUGH_CAPACITY_FOR_CLIENT);
        }
        this.getClients().add(client);

    }

    //Removes a Client from the Bank. It is important to note that you will always receive clients
    // that have already been created within the application.
    @Override
    public void removeClient(Client client) {
        this.getClients().remove(client);

    }

    //Adds a Loan in the Bank
    @Override
    public void addLoan(Loan loan) {
        this.getLoans().add(loan);

    }

    //Returns the sum of the interest rates of each loan in the Bank
    @Override
    public int sumOfInterestRates() {
        int sum=0;
        for (Loan loan : this.getLoans()) {
            sum+=loan.getInterestRate();

        }
        return sum;
    }

    @Override
    public String getStatistics() {
        //Returns a String with information about the Bank in the format below.
        //"Name: {bankName}, Type: {bankType}
        //Clients: {clientName1}, {clientName2} ... / Clients: none
        //Loans: {loansCount}, Sum of interest rates: {sumOfInterestRates}"
        //Note: I remind you that there are two bank types – CentralBank and BranchBank.

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Name: %s, Type: %s",this.getName(),this.getClass().getSimpleName())).append(System.lineSeparator());
        stringBuilder.append("Clients: ");
        if (this.getClients().isEmpty()){
            stringBuilder.append("none").append(System.lineSeparator());
        }
        else {
            stringBuilder.append(this.getClients().stream().map(Client::getName).collect(Collectors.joining(", ")).trim()).append(System.lineSeparator());
        }
        ////Loans: {loansCount}, Sum of interest rates: {sumOfInterestRates}"
        stringBuilder.append(String.format("Loans: %d, Sum of interest rates: %d",this.getLoans().size(),this.sumOfInterestRates())).append(System.lineSeparator());

        return stringBuilder.toString().trim();
    }

    public void setLoans(Collection<Loan> loans) {
        this.loans = loans;
    }

    @Override
    public Collection<Client> getClients() {
        return clients;
    }

    public void setClients(Collection<Client> clients) {
        this.clients = clients;
    }
}
