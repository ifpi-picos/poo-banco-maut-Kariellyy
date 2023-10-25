
import br.edu.ifpi.poo.models.Account;
import br.edu.ifpi.poo.models.Address;
import br.edu.ifpi.poo.models.Client;
import br.edu.ifpi.poo.models.CurrentAccount;
import br.edu.ifpi.poo.models.SavingsAccount;
import br.edu.ifpi.poo.models.Transaction;
import br.edu.ifpi.poo.notification.EmailNotification;
import br.edu.ifpi.poo.notification.Notification;
import br.edu.ifpi.poo.notification.SMSNotification;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.List;
import java.util.Date;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static List<Account> accounts = new ArrayList<>();
    private static List<Client> clients = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        // Contas para teste
        accounts.add(new CurrentAccount(1, new Client("12345678910", "João", new Date(), new Address(1, "Centro", "Teresina", "PI")), new EmailNotification()));
        accounts.add(new SavingsAccount(1, new Client("12345678911", "Maria", new Date(), new Address(1, "Centro", "Teresina", "PI")), new SMSNotification()));
        while (true) {
            clearScreen();
            System.out.println("-------------------- B A N C O  M A U T -----------------");
            System.out.println("|                  1 - Criar Conta Corrente             |");
            System.out.println("|                  2 - Criar Conta Poupança             |");
            System.out.println("|                  3 - Entrar na Conta                  |");
            System.out.println("|                  0 - Sair                             |");
            System.out.println("---------------------------------------------------------");

            System.out.print("Digite a opção desejada: ");
            int option = input.nextInt();

            switch (option) {
                case 0:
                    System.out.println("Obrigado por utlizar o nosso Banco Maut!");
                    System.exit(0);
                    break;
                case 1:
                    clearScreen();
                    createCurrentAccount();
                    break;
                case 2:
                    clearScreen();
                    createSavingsAccount();
                    break;
                case 3:
                    clearScreen();
                    System.out.print("Digite o número da conta: ");
                    String accountNumber = input.next();

                    System.out.print("Digite o número da agência: ");
                    int agency = input.nextInt();

                    enterAccount(accountNumber, agency);
                    break;
            }

        }
    }

    private static void createCurrentAccount() {
        clearScreen();
        System.out.println("=============== Conta Corrente ===============");
        Notification notification = null;

        System.out.print("Digite seu CPF: ");
        String cpf = input.next();

        System.out.print("Digite o número da agência: ");
        int agency = input.nextInt();

        Client client = null;

        for (Client c : clients) {
            if (c.getCpf().equals(cpf)) {
                client = c;
                break;
            }
        }

        if (client == null) {
            System.out.print("Digite o seu nome: ");
            String name = input.next();

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date date = null;

            while (true) {
                try {
                    System.out.print("Digite sua data de nascimento: ");
                    date = format.parse(input.next());
                    break;
                } catch (Exception e) {
                    System.out.println("Data inválida!");
                }
            }

            System.out.println("");
            System.out.println("============ Logradouro ==============");

            System.out.print("Digite o nome da sua rua: ");
            String publicPlace = input.next();

            System.out.print("Digite seu número: ");
            int number = input.nextInt();

            System.out.print("Digite seu bairro: ");
            String neighborhood = input.next();

            System.out.print("Digite o nome da sua cidade: ");
            String city = input.next();

            System.out.print("Digite a uf: ");
            String uf = input.next();
            System.out.println("======================================");

            Address address = new Address( publicPlace, number, neighborhood, city, uf);
            client = new Client(cpf, name, date, address);
            clients.add(client);
        }

        System.out.println("Deseja receber as notificações por email ou sms?");
        System.out.println("[1] - Email");
        System.out.println("[2] - SMS");
        int notificationOption = input.nextInt();

        if (notificationOption == 1) {
            notification = new EmailNotification();
        } else if (notificationOption == 2) {
            notification = new SMSNotification();
        }
        CurrentAccount currentAccount = new CurrentAccount(agency, client, notification);
        accounts.add(currentAccount);
        System.out.println("==================================================");

        System.out.println("Número da conta: " + currentAccount.getAccountNumber());
        System.out.println("Agência: " + currentAccount.getAgency());
        System.out.println("Nome do cliente: " + client.getName());
        System.out.println("CPF do cliente: " + client.getCpf());

        System.out.println("Conta criada com sucesso!");
        wait(input);
    }

    private static void createSavingsAccount() {
        clearScreen();
        System.out.println("==================== Conta Poupança ====================");
        
        System.out.print("Digite seu CPF: ");
        String cpf = input.next();

        System.out.print("Digite o número da agência: ");
        int agency = input.nextInt();

        Client client = null;

        for (Client c : clients) {
            if (c.getCpf().equals(cpf)) {
                client = c;
                break;
            }
        }

        if (client == null) {
            System.out.print("Digite o seu nome: ");
            String name = input.next();

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date date = null;

            while (true) {
                try {
                    System.out.print("Digite sua data de nascimento: ");
                    date = format.parse(input.next());
                    break;
                } catch (Exception e) {
                    System.out.println("Data inválida!");
                }

                System.out.println("========================================================");
            }

            System.out.println("");
            System.out.println("============ Logradouro ==============");

            System.out.print("Digite o nome da sua rua: ");
            String publicPlace = input.next();

            System.out.print("Digite seu número: ");
            int number = input.nextInt();

            System.out.print("Digite seu bairro: ");
            String neighborhood = input.next();

            System.out.print("Digite o nome da sua cidade: ");
            String city = input.next();

            System.out.print("Digite a uf: ");
            String uf = input.next();
            System.out.println("======================================");

            Address address = new Address(publicPlace, number, neighborhood, city, uf);
            client = new Client(cpf, name, date, address);
            clients.add(client);
        }

        System.out.println("Deseja receber notificações por email ou sms?");
        System.out.println("[1] - Email");
        System.out.println("[2] - SMS");
        int notificationOption = input.nextInt();

        Notification notification = null;
        if (notificationOption == 1) {
            notification = new EmailNotification();
        } else if (notificationOption == 2) {
            notification = new SMSNotification();
        }
        SavingsAccount savingsAccount = new SavingsAccount(agency, client, notification);
        accounts.add(savingsAccount);
        System.out.println("==================================================");

        clearScreen();
        System.out.println("========== Informações da Conta ==========");
        System.out.println("Número da conta: " + savingsAccount.getAccountNumber());
        System.out.println("Agência: " + savingsAccount.getAgency());
        System.out.println("Nome do cliente: " + client.getName());
        System.out.println("CPF do cliente: " + client.getCpf());

        System.out.println("Conta criada com sucesso!");
        System.out.println("==========================================");

        wait(input);

    }

    private static void enterAccount(String accountNumber, int agency) {
        Account accountLoggedIn = null;

        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber) && account.getAgency() == agency) {
                accountLoggedIn = account;
                break;
            }
        }

        if (accountLoggedIn == null) {
            System.out.println("Conta não encontrada!");
            return;
        }

        while (true) {
            clearScreen();
            System.out.println("===========================================================");
            System.out.println("Bem vindo " + accountLoggedIn.getclient().getName() + "!" + " Seu saldo é: R$ "
                    + accountLoggedIn.getBalance());
            if (accountLoggedIn instanceof CurrentAccount) {
                System.out.println("===========================================================");
                System.out.println("Cheque Especial Utilizado: R$ " + ((CurrentAccount) accountLoggedIn).getOverdraft());
            }
            System.out.println("===========================================================");
            System.out.println("|                    1 - Depositar                        |");
            System.out.println("|                    2 - Sacar                            |");
            System.out.println("|                    3 - Transferir                       |");
            System.out.println("|                    4 - Extrato                          |");
            System.out.println("|                    0 - Sair                             |");
            System.out.println("===========================================================");

            System.out.print("Digite a opção desejada: ");
            int newOption = input.nextInt();
            System.out.println("");

            switch (newOption) {
                case 0:
                    System.out.println("Obrigado por utilizar o Banco Maut!");
                    return;
                case 1:
                    clearScreen();
                    System.out.print("Digite o valor a ser depositado: R$ ");
                    double value = input.nextDouble();
                    clearScreen();
                    System.out.println("===========================================================");
                    accountLoggedIn.deposit(value, true, true);
                    System.out.println("Depósito efetuado com sucesso!");
                    System.out.println("===========================================================");
                    wait(input);
                    break;
                case 2:
                    clearScreen();
                    System.out.print("Digite o valor a ser sacado: R$ ");
                    double valueWithdraw = input.nextDouble();
                    clearScreen();
                    System.out.println("===========================================================");
                    accountLoggedIn.withdraw(valueWithdraw, true, true);
                    System.out.println("Saque efetuado com sucesso!");
                    System.out.println("===========================================================");
                    wait(input);
                    break;
                case 3:
                    clearScreen();
                    System.out.print("Número da conta destino: ");
                    String destinationAccountNumber = input.next();

                    System.out.print("Valor que deseja transferir: R$: ");
                    double valueTransaction = input.nextDouble();
                    
                    // recupera o objeto da conta destino
                    Account destinationAccount = null;
                    for (Account account : accounts) {
                        if (account.getAccountNumber().equals(destinationAccountNumber)) {
                            destinationAccount = account;
                            break;
                        }
                    }

                    // chamando o método transferir da conta logada
                    clearScreen();
                    System.out.println("===========================================================");
                    accountLoggedIn.transfer(valueTransaction, destinationAccount);
                    System.out.println("===========================================================");
                    wait(input);
                    break;

                case 4:
                    clearScreen();
                    System.out.println("=============== Extrato ===============");
                    for (Transaction t : accountLoggedIn.getTransactions()) {
                        System.out.println(t);
                        System.out.println("======================================");
                    }
                    wait(input);
                    break;
            }
        }
    }
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static void wait(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Pressione enter para continuar...");
        scanner.nextLine();
    }
}
