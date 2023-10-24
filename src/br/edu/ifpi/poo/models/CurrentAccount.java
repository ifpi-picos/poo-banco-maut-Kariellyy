package br.edu.ifpi.poo.models;

public class CurrentAccount extends Account {
    private double overdraft; //Cheque especial
    private int transferQuantity = 0;

    public CurrentAccount(int agency, double balance, Client client){
        super(agency, client);
    }

    public double getOverdraft(){
        return overdraft;
    }

    public void overdraft(double balance, double value){
        if (balance < 0){
            balance -= value;
            System.out.println("Transferência realizada com sucesso!");
        }
    }
    @Override
    public void withdraw(double value){
        if (balance <= 0){
            super.balance -= value;
        }
    }

    @Override
    public void deposit(double value){
        super.balance += value;
        System.out.println("Depósito realizado com sucesso!");

    }

    @Override
    public void transfer(double value, Account destinationAccount){
        if (transferQuantity > 2 ){
            withdraw(value);
            super.balance -= (value * 0.1) + value;
            System.out.println("Tranfêrencia realizada com sucesso, com taxa de 10% no\nvalor por passar do limite de transações.");
        }else{
            super.balance -= value;
            withdraw(value);
            destinationAccount.deposit(value);
            System.out.println("Tranferência realizada com sucesso");
        }
        transferQuantity++;
    }
}
