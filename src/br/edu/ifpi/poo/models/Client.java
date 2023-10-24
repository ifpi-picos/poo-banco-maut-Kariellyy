package br.edu.ifpi.poo.models;
import java.util.Date;

public class Client {
    private String cpf;
    private String name;
    private Date  birthDate;
    private Address address;

    public Client(String cpf, String name, Date birthDate, Address address){
        this.cpf = cpf;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
    }
    

    public Address getAddress(){
        return address;
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


    public Account getCurrentAccount() {
        return null;
    }
}
