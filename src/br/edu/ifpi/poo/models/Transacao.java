package br.edu.ifpi.poo.models;
import java.util.Date;

public class Transacao {
    private String type;
    private Date date;
    private double value;

    public Transacao(String type, Date date, double value){
        this.type = type;
        this.date = new Date();
        this.value = value;
    }

    public String getType(){
        return type;
    }

    public Date getDate(){
        return date;
    }

    public double getValue(){
        return value;
    }

    @Override
    public String toString(){
        return "Transação: " + this.getType() + "\nData: " + this.getDate() + "\nValor: " + this.getValue();
    }


    
}
