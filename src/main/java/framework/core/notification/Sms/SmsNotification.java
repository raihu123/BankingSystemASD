package framework.core.notification.Sms;

import framework.core.notification.Notification;

public class SmsNotification implements Notification {
    private final SmsMessage message;
    public SmsNotification(SmsMessage message) {
        this.message = message;
    }

    @Override
    public void send() {
        System.out.println("Send Sending to "+message.getTo() +" Message: "+message.getBody());
    }
}
