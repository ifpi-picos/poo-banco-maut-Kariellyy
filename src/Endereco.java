public class Endereco {
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;

    public Endereco(String rua, String numero, String complemento, String bairro, String cidade) {
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = Integer.toString(numero);
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        if(complemento == null) {
            this.complemento = "";
        } else {
            this.complemento = complemento;
        }
    }
    
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        if(bairro == null) {
            this.bairro = "";
        } else {
            this.bairro = bairro;
        }
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        if(cidade == null) {
            this.cidade = "";
        } else {
            this.cidade = cidade;
        }
    }
    
}
