package br.edu.ifpi.poo.models;

public class SavingsAccount extends Account {
    private double perfomance; // Rendimento

    public SavingsAccount(int agency, int accountNumber, double balance, Client client){
        super(agency, accountNumber, balance, client);
    }

    public double getPerfomance(){
        return perfomance;
    }

    @Override
    public void deposit(double value){
        this.balance += (value * 0.1) + value;
    }

    @Override
    public void transfer(double value, Account destinatiAccount){
        if (balance < 0)
        this.balance -= (value * 0.5) + value;
        destinatiAccount.deposit(value);


    }
}
