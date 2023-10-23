package models.entities;

public class CurrentAccount extends Account {
    private double overdraft; //Cheque especial
    private int transferQuantity = 0;

    public CurrentAccount(int agency, int accountNumber, double balance){
        super(agency, accountNumber, balance);
    }

    public double getOverdraft(){
        return overdraft;
    }

    public void overdraft(double balance, double value){
        if (balance < 0){
            balance -= value;
            System.out.println("Transferencia realizada com sucesso!");
        }
    }

    @Override
    public void transfer(double value, Account destinationAccount){
        if (transferQuantity > 2 ){
            this.balance -= value * 0.1;
        }else{
            this.balance -= value;
            destinationAccount.deposit(value);
        }
        transferQuantity++;
    }
}
