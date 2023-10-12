import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class App {
    static Scanner input = new Scanner(System.in);
    static List<Conta> contas = new ArrayList<Conta>(); // Lista para armazenar as contas
    static List<Usuario> usuarios = new ArrayList<Usuario>(); // Lista para armazenar os usuários
    static List<Transacao> transferencias = new ArrayList<Transacao>(); // Lista para armazenar as transferências

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

    private static void criarConta() {
        limparTela();
        // Método para criar uma nova conta
        System.out.println("Digite seu nome: ");
        String nome = input.next();

        System.out.println("Digite seu CPF: ");
        String cpf = input.next();

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date data = null;
        
        while (true) {
            try {
                System.out.println("Digite sua data de nascimento: ");
                data = format.parse(input.next());
                break;
            } catch (Exception e) {
                System.out.println("Data inválida!");
            }
        }

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

        Usuario newUsuario = new Usuario(nome, cpf, data, endereco);
        usuarios.add(newUsuario);

        Conta novaConta = new Conta("0001", 0, newUsuario); // Cria uma nova conta com saldo 0
        contas.add(novaConta);

        System.out.println("Conta criada com sucesso!");
    }

    private static void entrarNaConta() {
        limparTela();
        // Método para entrar na conta
        System.out.println("Digite seu CPF: ");
        String cpf = input.next();

        Usuario usuario = null;
        Conta conta = null;

        // Verifica se o usuário existe
        for (Usuario u : usuarios) {
            if (u.getCpf().equals(cpf)) {
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
            if (c.getUsuario().equals(usuario)) {
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
                case 0:
                    limparTela();
                    System.out.println("Obrigado por utilizar o Banco Maut!");
                    System.exit(0); // Encerra o programa
                    break;

                case 1:
                    limparTela();
                    System.out.println("Digite o valor a ser depositado: ");
                    double valor = input.nextDouble();
                    conta.depositar(valor);
                    System.out.println("Depósito efetuado com sucesso!");
                    Transacao deposito = new Transacao(valor, "Depósito");
                    transferencias.add(deposito);
                    break;
                case 2:
                    limparTela();
                    System.out.println("Digite o valor a ser sacado: ");
                    double valorSaque = input.nextDouble();
                    conta.sacar(valorSaque);
                    System.out.println("Saque efetuado com sucesso!");

                    Transacao saque = new Transacao(valorSaque, "Saque");
                    transferencias.add(saque);
                    break;
                case 3:
                    limparTela();
                    System.out.print("Número da Agência Destino: ");
                    String numeroAgenciaDestino = input.next();
                    System.out.print("Número da Conta Destino: ");
                    String numeroContaDestino = input.next();
                    Conta destino = new Conta(numeroAgenciaDestino, Integer.parseInt(numeroContaDestino), null);
                    

                    System.out.print("Valor que deseja transferir: R$ ");
                    double valorTransferencia = input.nextDouble();
                    conta.transferir(destino, valorTransferencia);

                    Transacao transferencia = new Transacao(valorTransferencia, "Transferência");
                    transferencias.add(transferencia);
                    break;

                case 4:
                    limparTela();
                    System.out.println("Extrato: ");
                    for (Transacao t : transferencias) {
                        System.out.println(t);
                    }
                    break;
            }
        }
    }

    private static void limparTela() {
        // Método para limpar a tela
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void separacao(){
        System.out.println("-------------------------------------------------------------");
    }
}
