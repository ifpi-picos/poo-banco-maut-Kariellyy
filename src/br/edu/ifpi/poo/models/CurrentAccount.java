package br.edu.ifpi.poo.models;

import br.edu.ifpi.poo.notification.Notification;

public class CurrentAccount extends Account {
    private double overdraft; // Cheque especial
    private int transferQuantity = 0;

    public CurrentAccount(int agency, Client client, Notification notification) {
        super(agency, client, notification);
    }

    public double getOverdraft() {
        return overdraft;
    }

    @Override
    public void withdraw(double value, boolean notification, boolean createTransection) {
        if (super.balance < value) {
            double difference = super.balance - value;
            super.balance = 0;
            overdraft -= difference;
        } else {
            super.balance -= value;
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
    public void deposit(double value, boolean notification, boolean createTransection) {
        if (value > 0) {
            if (overdraft > 0) {
                // Se houver um valor positivo no cheque especial, parte do depósito é usada
                // para reduzir a dívida no cheque especial, e o restante é adicionado ao saldo
                if (value >= overdraft) {
                    // O depósito cobre totalmente o cheque especial
                    value -= overdraft;
                    overdraft = 0;
                    super.balance += value;
                } else {
                    // O depósito cobre parcialmente o cheque especial
                    overdraft -= value;
                }
            } else {
                // Se o cheque especial estiver zerado ou negativo, todo o valor do depósito
                //é adicionado ao saldo
                super.balance += value;
            }
            if (notification){
                super.getNotification().sendNotification("Depósito", value);
            }

            if (createTransection){
                Transaction transaction = new Transaction(value, "Depósito");
                super.addTransaction(transaction);
            }

        }
    }

    @Override
    public void transfer(double value, Account destinationAccount) {
        if (transferQuantity < 2) { // transferência sem taxa;
            withdraw(value, false, false);
            destinationAccount.deposit(value, false, true);
            transferQuantity++;
        } else {
            double transferValue = (value * 0.1) + value;
            withdraw(transferValue, false, false);
            destinationAccount.deposit(value, false, true);
        }

        super.getNotification().sendNotification("Transferência", value);

        Transaction transaction = new Transaction(value, "Transferência");
        super.addTransaction(transaction);
    }

    public void transfer(String destinationAccountNumber, int destinationAgencyNumber, Object object) {
    }
}
