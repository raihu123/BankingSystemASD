package framework.fintech.observers;

import framework.core.notification.Email.EmailMessage;
import framework.core.notification.Email.EmailNotification;
import framework.core.Observer.Observer;
import framework.fintech.models.Customer;

public class CustomerCreateObserver implements Observer<Customer> {

    @Override
    public void update(Customer o) {
        EmailMessage message = new EmailMessage(o.getEmail(),"Account Created","Account Created for: "+o.getName());
        (new EmailNotification(message)).send();
    }
}
