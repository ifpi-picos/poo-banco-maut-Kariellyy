package br.edu.ifpi.poo.models;

public class Address {
    private String publicPlace; // logradouro;
    private int number;
    private String neighborhood; // bairro;
    private String city;
    private String uf;

    public Address(String publicPlace, int number, String neighborhood, String city, String uf){
        this.publicPlace = publicPlace;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.uf = uf;
    }

    public Address(int number2, String neighborhood2, String city2, String uf2) {
    }

    public String getPublicPlace(){
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace){
        this.publicPlace = publicPlace;
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public String getNeighborhood(){
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood){
        this.neighborhood = neighborhood;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getUf(){
        return uf;
    }

    public void setUf(String uf){
        this.uf = uf;
    }

}
