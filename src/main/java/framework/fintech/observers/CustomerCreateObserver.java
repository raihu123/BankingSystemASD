package framework.fintech.observers;

import framework.core.Notification.Email.EmailMessage;
import framework.core.Notification.Email.EmailNotification;
import framework.core.Observer.Observer;
import framework.fintech.models.Customer;

public class CustomerCreateObserver implements Observer<Customer> {

    @Override
    public void update(Customer o) {
        EmailMessage message = new EmailMessage(o.getEmail(),"Account Created","Account Created for: "+o.getName());
        (new EmailNotification(message)).send();
    }
}
