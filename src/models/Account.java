package models;

public class Account {
    private int agency;
    private int accountNumber;
    private double balance;

    public Account(int agency, int accountNumber, double balance){
        this.agency = agency;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public int getAgency(){
        return agency;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double value){
        this.balance += value;
    }

    public void bag(double value){
        this.balance -= value;
    }

    public void transfer(double value, Account destinationAccount){
        this.balance -= value;
        destinationAccount.deposit(value);
    }


    
}
