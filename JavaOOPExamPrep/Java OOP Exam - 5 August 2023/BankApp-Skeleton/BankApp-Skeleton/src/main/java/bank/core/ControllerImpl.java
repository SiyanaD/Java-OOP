package bank.core;

import bank.common.ConstantMessages;
import bank.common.ExceptionMessages;
import bank.entities.bank.Bank;
import bank.entities.bank.BranchBank;
import bank.entities.bank.CentralBank;
import bank.entities.client.Adult;
import bank.entities.client.Client;
import bank.entities.client.Student;
import bank.entities.loan.Loan;
import bank.entities.loan.MortgageLoan;
import bank.entities.loan.StudentLoan;
import bank.repositories.LoanRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller{
private LoanRepository loans;
private Collection<Bank> banks;
    public ControllerImpl() {
        this.loans=new LoanRepository();
        this.banks=new ArrayList<>();


    }

    //Creates and adds a Bank to the banks’ collection. Valid types are: "CentralBank" and "BranchBank".
    //If the Bank type is invalid, you have to throw a IllegalArgumentException with the following message:
    //•	"Invalid bank type."
    //If the Bank is added successfully, the method should return the following String:
    //•	"{bankType} is successfully added."
    @Override
    public String addBank(String type, String name) {
        Bank bank;
        if (type.equals("CentralBank")){
            bank=new CentralBank(name);
          banks.add(bank);
        } else if (type.equals("BranchBank")) {
            bank=new BranchBank(name);
            banks.add(bank);
            
        }
        else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_BANK_TYPE);
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE,type);
    }

    @Override
    public String addLoan(String type) {
        //Creates a loan of the given type and adds it to the LoanRepository.
        // Valid types are: "StudentLoan" and "MortgageLoan". If the loan type is invalid, throw an IllegalArgumentException with a message:
        //•	"Invalid loan type."
        //The method should return the following string if the operation is successful:
        //•	"{loanType} is successfully added."
        Loan loan;
        if (type.equals("StudentLoan")){
            loan=new StudentLoan();
            loans.addLoan(loan);
        } else if (type.equals("MortgageLoan")) {
            loan=new MortgageLoan();
            loans.addLoan(loan);
            
        }
        else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_LOAN_TYPE);

        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE,type);
    }

    @Override
    public String returnedLoan(String bankName, String loanType) {
        //Adds the returned Loan to the Bank with the given name. You have to remove the Loan from the LoanRepository if the insert is successful.
        //It is important to note that the bank referenced by the bankName parameter will always exist in the BankRepository.
        // Therefore, you can assume that the specified bank is valid and present.
        //If there is no such loan, you have to throw an IllegalArgumentException with the following message:
        //•	"Loan of type {loanType} is missing."
        //If no exceptions are thrown, return the String:
        //•	"{loanType} successfully added to {bankName}."
        Loan loan = this.loans.findFirst(loanType);
        if (loan==null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_LOAN_FOUND,loanType));
        }
        else {
            Bank bank = getBankByName(bankName);
            bank.addLoan(loan);
            this.loans.removeLoan(loan);
        }


        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK,loanType,bankName);
    }

    private Bank getBankByName(String bankName) {
        return this.banks.stream().filter(b->b.getName().equals(bankName)).findFirst().get();
    }

    @Override
    public String addClient(String bankName, String clientType, String clientName, String clientID, double income) {
        //Creates and adds the desired Client to the Bank with the given name.
        //Valid Client types are: "Student" and "Adult".
        //Note: The method must first check whether the client type is valid.
        //If the Client type is invalid, you have to throw an IllegalArgumentException with the following message:
        //•	"Invalid client type."
        //If the clientTypeName is not "Adult" for the CentralBank or "Student" for the BranchBank,
        // the client type is considered unsuitable for the Bank.
        //If no errors are thrown, return one of the following strings:
        //•	"Unsuitable bank." - if the given Client cannot be a user of the Bank.
        //For reference: check their description from Task 1.
        //•	"{clientType} successfully added to {bankName}." - if the Client is added successfully in the Bank.
        Client client;
        if (clientType.equals("Student")){
            client=new Student(clientName,clientID,income);

        }
        else if (clientType.equals("Adult")) {
            client=new Adult(clientName,clientID,income);

        }
        else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_CLIENT_TYPE);
        }

        Bank bank = getBankByName(bankName);
        if (clientType.startsWith("Adult")&&bank.getClass().getSimpleName().startsWith("Central")){
            bank.addClient(client);
        } else if (clientType.startsWith("Stud")&&bank.getClass().getSimpleName().startsWith("Branch")) {
            bank.addClient(client);
        }
        else {
            return ConstantMessages.UNSUITABLE_BANK;
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK,clientType,bankName);
    }

    @Override
    public String finalCalculation(String bankName) {
        //Calculates all funds (income from Client and amount from Loan)
        // that have passed through the Bank with the given name.
        // It is calculated from the sum of all Client and Loan prices in the Bank.
        //Return a string in the following format:
        //•	"The funds of bank {bankName} is {funds}."
        //o	The funds should be formatted to the 2nd decimal place!
        Bank bank = getBankByName(bankName);
        double priceIncomeClients = bank.getClients().stream().mapToDouble(Client::getIncome).sum();
        double priceAmountLoan = bank.getLoans().stream().mapToDouble(Loan::getAmount).sum();
        double priceAll = priceIncomeClients+priceAmountLoan;
        return String.format(ConstantMessages.FUNDS_BANK,bankName,priceAll);
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Bank bank : this.banks) {
            stringBuilder.append(bank.getStatistics()).append(System.lineSeparator());

        }
        return stringBuilder.toString().trim();
    }
}
