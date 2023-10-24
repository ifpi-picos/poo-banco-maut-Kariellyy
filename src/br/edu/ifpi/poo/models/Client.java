package br.edu.ifpi.poo.models;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Client {
    private String cpf;
    private String name;
    private Date  birthDate;
    private Address address;
    List<Account> accounts = new ArrayList<>();

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
}
