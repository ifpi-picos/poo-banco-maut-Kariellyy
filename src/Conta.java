
public class Conta {
    private String agencia;
    private int numeroConta;
    private double saldo;
    private Usuario usuario;
    private static int contador;

    public Conta(String agencia, double saldo, Usuario usuario) {
        this.agencia = agencia;
        this.numeroConta = contador++;
        this.saldo = 0;
        this.usuario = usuario;

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void transferir(Conta destino, double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            destino.depositar(valor);
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Saldo insuficiente");
        }
    }


}
