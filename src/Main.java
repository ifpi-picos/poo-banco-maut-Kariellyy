import br.edu.ifpi.poo.models.Account;
import br.edu.ifpi.poo.models.Client;
import br.edu.ifpi.poo.models.Transaction;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
    static Scanner input = new Scanner(System.in);
    List<Account> accounts = new ArrayList<>();
    List<Client> clients = new ArrayList<>();
    List<Transaction> transactions = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        while (true){
            System.out.println("____________________ B A N C O  M A U T ___________________");
            System.out.println("____________________ 1 - Criar Conta Corrente _____________");
            System.out.println("____________________ 2 - Criar Conta Poupança _____________");
            System.out.println("____________________ 3 - Entrar na Conta ___________________________");
            System.out.println("____________________ 0 - Sair _____________________________");

            System.out.println("Digite a opção desejada: ");
            int opcao = input.nextInt();

            switch (opcao){
                case 0:
                    System.out.println("Obrigado por utlizar o nosso Banco Maut!");
                    System.exit(0);
                    break;
                case 1:
                    
            }

        }
 }
}
