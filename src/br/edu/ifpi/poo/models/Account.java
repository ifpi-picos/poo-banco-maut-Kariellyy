package br.edu.ifpi.poo.models;

public abstract class Account {
    private final int agency; // "Private" só pode ser acessado/manipulado dentro desta classe;
    private final String accountNumber; // "Final" indica que ele é uma constante;
    protected double balance; // "Protected" indica que ele é visível nesta classes e nas classes filhas;
    private Client client;

    private static int numberOfAccounts = 1;

    public Account(int agency, Client client){
        this.agency = agency;
        this.accountNumber = generateAccountNumber();
        this.balance = 0;
        this.client = client;
    }

    private String generateAccountNumber(){
        String accountNumber = String.format("%04d", numberOfAccounts);
        numberOfAccounts++;

        return accountNumber;
    }

    public Client getclient(){
        return client;
    }

    public int getAgency(){
        return agency;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    public abstract void deposit(double value);
    
    public abstract void withdraw(double value);

    public abstract void transfer(double value, Account destinationAccount);
}
