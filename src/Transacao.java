
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transacao {
    private Date data;
    private double valor;
    private String tipo;

    public Transacao(double valor, String tipo) {
        this.data = new Date();
        this.valor = valor;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Transacao [data=" + format.format(data) + ", tipo=" + tipo + ", valor=" + valor + "]";
    }

}