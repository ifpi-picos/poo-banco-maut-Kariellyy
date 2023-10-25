package br.edu.ifpi.poo.models;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private String type;
    private Date date;
    private double value;

    public Transaction(double value, String type){
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
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Transação: " + this.getType() + "\nData: " + format.format(date) + "\nValor: " + this.getValue();
    }
}
