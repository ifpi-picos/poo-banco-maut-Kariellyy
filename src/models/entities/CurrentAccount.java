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
            System.out.println("Transferência realizada com sucesso!");
        }
    }

    @Override
    public void transfer(double value, Account destinationAccount){
        if (transferQuantity > 2 ){
            this.balance -= value * 0.1;
            System.out.println("Tranfêrencia realizada com sucesso, com taxa de 10% no\nvalor por passar do limite de transações.");
        }else{
            this.balance -= value;
            destinationAccount.deposit(value);
            System.out.println("Tranferência realizada com sucesso");
        }
        transferQuantity++;
    }
}
