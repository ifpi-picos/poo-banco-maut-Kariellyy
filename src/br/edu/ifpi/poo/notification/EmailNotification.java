package br.edu.ifpi.poo.notification;

public class EmailNotification implements Notification {
    @Override
    public void sendNotification(String type, double value){
        System.out.println("Enviando notificação por Email...");
        System.out.println("Tipo: " + type);
        System.out.println("Valor: " + value);
    }
    
}
