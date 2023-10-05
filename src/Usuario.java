
public class Usuario {
    public static int contador;
    private int id;
    private String nome;
    private String cpf;
    private String dataNascimento;
    private Endereco endereco;
    

    public Usuario(String nome, String cpf, String dataNascimento, Endereco endereco) {
        this.id = contador++;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
