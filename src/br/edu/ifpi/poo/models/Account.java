package br.edu.ifpi.poo.models;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.poo.notification.Notification;


public abstract class Account {
    private final int agency; // "Private" só pode ser acessado/manipulado dentro desta classe;
    private final String accountNumber; // "Final" indica que ele é uma constante;
    protected double balance; // "Protected" indica que ele é visível nesta classes e nas classes filhas;
    private Client client;
    private Notification notification;
    protected List<Transaction> transactions = new ArrayList<>();

    private static int numberOfAccounts = 1;

    public Account(int agency, Client client, Notification notification){
        this.agency = agency;
        this.accountNumber = generateAccountNumber();
        this.client = client;
        this.notification = notification;
    }

    private String generateAccountNumber(){
        String accountNumber = String.format("%04d", numberOfAccounts);
        numberOfAccounts++;

        return accountNumber;
    }

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
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

    public Notification getNotification(){
        return notification;
    }

    public void setNotification(Notification notification){
        this.notification = notification;
        
    }

    public abstract void deposit(double value);
    
    public abstract void withdraw(double value);

    public abstract void transfer(double value, Account destinationAccount);
}
