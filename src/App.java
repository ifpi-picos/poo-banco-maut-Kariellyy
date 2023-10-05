import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class App {
    static Scanner input = new Scanner(System.in);
    static List<Conta> contas = new ArrayList<Conta>(); // Lista para armazenar as contas
    static List<Usuario> usuarios = new ArrayList<Usuario>(); // Lista para armazenar os usuários
    static List<Transferencia> transferencias = new ArrayList<Transferencia>(); // Lista para armazenar as transferências

    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("-------------------- B A N C O   M A U T --------------------");
            System.out.println("                     1- Criar conta                          ");
            System.out.println("                     2- Entrar na conta                      ");
            System.out.println("                     0- Sair                                 ");
            System.out.println("-------------------------------------------------------------");

            System.out.println("Digite a opção desejada: ");
            int opcao = input.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Obrigado por utilizar o Banco Maut!");
                    System.exit(0); // Encerra o programa
                    break;
                case 1:
                    criarConta();
                    break;
                case 2:
                    entrarNaConta();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    static void criarConta() {
        // Método para criar uma nova conta
        System.out.println("Digite seu nome: ");
        String nome = input.next();

        System.out.println("Digite seu CPF: ");
        String cpf = input.next();

        System.out.println("Digite sua data de nascimento: ");
        String dataNascimento = input.next();

        System.out.println("Digite sua rua: ");
        String rua = input.next();

        System.out.println("Digite seu número: ");
        int numero = input.nextInt();

        System.out.println("Digite seu complemento: ");
        String complemento = input.next();

        System.out.println("Digite seu bairro: ");
        String bairro = input.next();

        System.out.println("Digite sua cidade: ");
        String cidade = input.next();

        Endereco endereco = new Endereco(rua, numero, complemento, bairro, cidade);

        Usuario newUsuario = new Usuario(nome, cpf, dataNascimento, endereco);
        usuarios.add(newUsuario);

        Conta novaConta = new Conta("0001", 1, 0, newUsuario.getId()); // Cria uma nova conta com saldo 0 (zero
        contas.add(novaConta);

        System.out.println("Conta criada com sucesso!");
    }

    
    static void entrarNaConta() {
        // Método para entrar na conta
        System.out.println("Digite seu CPF: ");
        String cpf = input.next();

        System.out.println("Digite sua data de nascimento: ");
        String dataNascimento = input.next();

        Usuario usuario = null;
        Conta conta = null;

        // Verifica se o usuário existe
        for (Usuario u : usuarios) {
            if (u.getCpf().equals(cpf) && u.getDataNascimento().equals(dataNascimento)) {
                usuario = u;
                break;
            }
        }

        if (usuario == null) {
            System.out.println("Usuário não encontrado!");
            return;
        }

        // Encontra a conta associada ao usuário
        for (Conta c : contas) {
            if (c.getidUsuario() == usuario.getId()) {
                conta = c;
                break;
            }
        }

        if (conta == null) {
            System.out.println("Conta não encontrada!");
            return;
        }

        while (true) {
            System.out.println("Bem-Vindo(a) " + usuario.getNome() + ", Seu saldo é de: " + conta.getSaldo());
            System.out.println("-------------------------------------------------------------");
            System.out.println("                     1- Depositar                            ");
            System.out.println("                     2- Sacar                                ");
            System.out.println("                     3- Transferir                           ");
            System.out.println("                     4- Extrato                              ");
            System.out.println("                     0- Sair                                 ");

            System.out.println("Digite a opção desejada: ");
            int newOpcao = input.nextInt();

            switch (newOpcao) {
                case 1:
                    System.out.println("Digite o valor a ser depositado: ");
                    double valor = input.nextDouble();
                    conta.depositar(valor);
                    System.out.println("Depósito efetuado com sucesso!");
                    break;
                case 2:
                    System.out.println("Digite o valor a ser sacado: ");
                    double valorSaque = input.nextDouble();
                    conta.sacar(valorSaque);
                    System.out.println("Saque efetuado com sucesso!");
                    break;
            }
        }
    }
}
