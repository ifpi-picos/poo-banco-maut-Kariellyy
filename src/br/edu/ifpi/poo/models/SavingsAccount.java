package br.edu.ifpi.poo.models;

import br.edu.ifpi.poo.notification.Notification;

public class SavingsAccount extends Account {
    private double perfomance; // Rendimento

    public SavingsAccount(int agency, Client client, Notification notification){
        super(agency, client, notification);
    }


    public double getPerfomance(){
        return perfomance;
    }

    @Override
    public void withdraw(double value, boolean notification, boolean createTransection){
        if (value > 0 && value <= super.balance){
            double withdrawValue = (value * 0.05) + value;
            super.balance -= withdrawValue;
        }

        if (notification){
            super.getNotification().sendNotification("Saque", value);
        }

        if (createTransection){
            Transaction transaction = new Transaction(value, "Saque");
            super.addTransaction(transaction);
        }
    }

    @Override
    public void deposit(double value, boolean notification, boolean createTransection){
        if (value > 0) {
            double depositValue = (value * 0.1) + value;
            super.balance += depositValue;
        }

        if (notification){
            super.getNotification().sendNotification("Depósito", value);
        }

        if (createTransection){
            Transaction transaction = new Transaction(value, "Depósito");
            super.addTransaction(transaction); 
        }
    }

    @Override
    public void transfer(double value, Account destinationAccount){
        if (value > 0 && value <= super.balance) {
            double transferValue = (value * 0.1) + value;
            withdraw(transferValue, false, false);
            destinationAccount.deposit(value, false, false);
        }
        super.getNotification().sendNotification("Transfêrencia", value);

        Transaction transaction = new Transaction(value, "Transfêrencia");
        super.addTransaction(transaction);
    }
}
