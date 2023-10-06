public class Transferencia {
    private Conta contaDestino;
    private double valor;

    public Transferencia(Conta contaDestino, double valor) {
        this.contaDestino = contaDestino;
        this.valor = valor;
    }

    public Conta getContaDestino() {
        return this.contaDestino;
    }

    public double getValor() {
        return this.valor;
    }

}