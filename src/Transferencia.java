public class Transferencia {
    private Conta contaOrigem;
    private Conta contaDestino;
    private double valor;

    public Transferencia(Conta contaOrigem, Conta contaDestino, double valor) {
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
    }

    public Transferencia(double valorTransferencia, Usuario usuario, Usuario u) {
    }

    public Transferencia(double valorTransferencia, String cpfDestinatario, String dataNascimentoDestinatario) {
    }

    public Conta getContaOrigem() {
        return this.contaOrigem;
    }

    public Conta getContaDestino() {
        return this.contaDestino;
    }

    public double getValor() {
        return this.valor;
    }

    public Usuario getRemetente() {
        return null;
    }

    public Usuario getDestinatario() {
        return null;
    }

    
}
