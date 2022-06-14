package framework.core.notification.Email;

import framework.core.notification.Notification;

public class EmailNotification implements Notification {
    private final EmailMessage message;
    public EmailNotification(EmailMessage message) {
        this.message = message;
    }

    @Override
    public void send() {
        System.out.println("Send Email to "+message.getTo() +" Message: "+message.getBody());
    }
}
