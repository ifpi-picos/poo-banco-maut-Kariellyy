package models.entities;

public class Account {
    private int agency; // "Private" só pode ser acessado/manipulado dentro desta classe;
    private final int accountNumber; // "Final" indica que ele é uma constante;
    protected double balance; // "Protected" indica que ele é visível nesta classes e nas classes filhas;

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
        if (balance > 0){
            this.balance -= value;
            System.out.println("Saque realizado com sucesso!");
        }else{
            System.out.println("Saldo insuficiente!");
        }
        
    }

    public void transfer(double value, Account destinationAccount){
        if (balance > 0){
            this.balance -= value;
            destinationAccount.deposit(value);
            System.out.println("Transferência realizada com sucesso!");
        }else{
            System.out.println("Saldo insuficiente!");
        }
    }


    
}
