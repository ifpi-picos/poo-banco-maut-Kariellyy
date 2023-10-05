public class Conta {
    private String agencia; 
    private int numeroConta;
    private double saldo;
    private int idUsuario;
    

    public Conta(String agencia, int numeroConta, double saldo, int idUsuario) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = 0;
        this.idUsuario = idUsuario;
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

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getidUsuario() {
        return idUsuario;
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
}
