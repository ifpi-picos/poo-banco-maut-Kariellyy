package br.edu.ifpi.poo.models;

public class SavingsAccount extends Account {
    private double perfomance; // Rendimento

    public SavingsAccount(int agency, int accountNumber, double balance, Client client){
        super(agency, accountNumber, client);
    }

    public double getPerfomance(){
        return perfomance;
    }

    @Override
    public void deposit(double value){
        super.balance += value;
        this.perfomance += value * 0.1;
    }

    @Override
    public void transfer(double value, Account destinatiAccount){
        if (balance < 0)
        super.balance -= (value * 0.5) + value;
        destinatiAccount.deposit(value);
    }
}
