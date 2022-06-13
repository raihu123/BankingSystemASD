package banking.strategy;

import framework.core.Notification.Email.EmailMessage;
import framework.core.Notification.Email.EmailNotification;
import framework.fintech.models.Account;
import framework.fintech.strategy.BalanceAlertStrategy;

public class CompanyBalanceAlertStrategy implements BalanceAlertStrategy {

    @Override
    public void checkForAlert(Account account) {
        if(account.getBalance() < 0){
            EmailMessage message = new EmailMessage(account.getCustomer().getEmail(),
            		"Account Balance","Company Account >> Balance issued on account#: " + account.getId() + ", balance: " + account.getBalance());
            (new EmailNotification(message)).send();
        }
    }
}
