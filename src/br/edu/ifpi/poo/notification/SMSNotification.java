package br.edu.ifpi.poo.notification;

public class SMSNotification implements Notification {
    @Override
    public void sendNotification(String type, double value){
        System.out.println("Enviando notificação por SMS, " + type + "| Valor: " + value);
    }
}
