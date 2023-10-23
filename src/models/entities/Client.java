package models.entities;
import java.util.Date;

public class Client {
    private String cpf;
    private String name;
    private Date  birthDate;

    public Client(String cpf, String name, Date birthDate){
        this.cpf = cpf;
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getCpf(){
        return cpf;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Date getBirthDate(){
        return birthDate;
    }

    public void setBirthDate(Date birthDate){
        this.birthDate = birthDate;
    }
}
