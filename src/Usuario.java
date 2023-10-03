public class Usuario {
    public static int contador;
    private int id;
    private String nome;
    private String cpf;
    private String dataNascimento;
    

    public Usuario(int id, String nome, String cpf, String dataNascimento) {
        this.id = contador++;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
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
}
