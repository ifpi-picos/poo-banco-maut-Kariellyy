import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    public static int contador;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private Endereco endereco;
    private List<Conta> contas = new ArrayList<>();

    public Usuario(String nome, String cpf, Date dataNascimento, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;

    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }
}
