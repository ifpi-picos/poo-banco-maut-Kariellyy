
import br.edu.ifpi.poo.models.Address;
import br.edu.ifpi.poo.models.Client;
import br.edu.ifpi.poo.models.CurrentAccount;
import br.edu.ifpi.poo.models.SavingsAccount;
import br.edu.ifpi.poo.models.Transaction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Date;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static List<CurrentAccount> currentAccounts = new ArrayList<>();
    private static List<SavingsAccount> savingsAccounts = new ArrayList<>();
    private static List<Client> clients = new ArrayList<>();
    private static List<Transaction> transactions = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        while (true){
            System.out.println("____________________ B A N C O  M A U T ___________________");
            System.out.println("                                                           ");
            System.out.println("                     1 - Criar Conta Corrente              ");
            System.out.println("                     2 - Criar Conta Poupança              ");
            System.out.println("                     3 - Entrar na Conta                   ");
            System.out.println("                     0 - Sair                              ");
            System.out.println("___________________________________________________________");

            System.out.println("Digite a opção desejada: ");
            int option = input.nextInt();

            switch (option){
                case 0:
                    System.out.println("Obrigado por utlizar o nosso Banco Maut!");
                    System.exit(0);
                    break;
                case 1:
                    createCurrentAccount();
                    break;
                case 2:
                    createSavingsAccount();
                    break;


            }


        }
    }
    private static void createCurrentAccount(){
        System.out.println("Deseja criar uma conta corrente? ");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        int option = input.nextInt();

        if (option == 1){
            System.out.println("Digite seu CPF: ");
            String cpf = input.next();

            Client client = null;

            for (Client c : clients) {
                if (c.getCpf().equals(cpf)) {
                    client = c;
                    break;
                }
            }

            if (client == null) {
                System.out.println("Digite o seu nome: ");
                String name = input.next();
    
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date date = null;
    
                while (true) {
                    try {
                        System.out.println("Digite sua data de nascimento: ");
                        date = format.parse(input.next());
                        break;
                    } catch (Exception e) {
                        System.out.println("Data inválida!");
                    }
                }
    
                System.out.println("Logradouro: ");
    
                System.out.println("Digite seu número: ");;
                int number = input.nextInt();
    
                System.out.println("Digite seu bairro: ");
                String neighborhood = input.next();
    
                System.out.println("Digite o nome da sua cidade: ");
                String city = input.next();
    
                System.out.println("Digite a uf: ");
                String uf = input.next();
    
                Address address = new Address(number, neighborhood, city, uf);
                client = new Client(cpf, name, date, address);
                clients.add(client);
            }

            CurrentAccount currentAccount = new CurrentAccount(1, 0, client);
            currentAccounts.add(currentAccount);

            System.out.println("Número da conta: " + currentAccount.getAccountNumber());
            System.out.println("Agência: " + currentAccount.getAgency());
            System.out.println("Nome do cliente: " + client.getName());
            System.out.println("CPF do cliente: " + client.getCpf());

            System.out.println("Conta criada com sucesso!");
        } else {
            System.out.println("Obrigado por utlizar o nosso Banco Maut!");
            System.exit(0);
        }        
    }

    private static void createSavingsAccount(){
        System.out.println("Deseja criar uam conta poupança? ");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        int option = input.nextInt();

        if (option == 1){
            System.out.println("Digite seu CPF: ");
            String cpf = input.next();

            Client client = null;

            for (Client c : clients) {
                if (c.getCpf().equals(cpf)) {
                    client = c;
                    break;
                }
            }

            if (client == null) {
                System.out.println("Digite o seu nome: ");
                String name = input.next();
    
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date date = null;
    
                while (true) {
                    try {
                        System.out.println("Digite sua data de nascimento: ");
                        date = format.parse(input.next());
                        break;
                    } catch (Exception e) {
                        System.out.println("Data inválida!");
                    }
                }
    
                System.out.println("Logradouro ");
                System.out.println("Digite seu número: ");;
                int number = input.nextInt();
    
                System.out.println("Digite seu bairro: ");
                String neighborhood = input.next();
    
                System.out.println("Digite o nome da sua cidade: ");
                String city = input.next();
    
                System.out.println("Digite a uf: ");
                String uf = input.next();
    
                Address address = new Address(number, neighborhood, city, uf);
                client = new Client(cpf, name, date, address);
                clients.add(client);
            }

            SavingsAccount savingsAccount = new SavingsAccount(1, 0, 0, client);
            savingsAccounts.add(savingsAccount);

            System.out.println("Número da conta: " + savingsAccount.getAccountNumber());
            System.out.println("Agência: " + savingsAccount.getAgency());
            System.out.println("Nome do cliente: " + client.getName());
            System.out.println("CPF do cliente: " + client.getCpf());

            System.out.println("Conta criada com sucesso!");
        } else {
            System.out.println("Obrigado por utlizar o nosso Banco Maut!");
            System.exit(0);
        }        

    }
}
