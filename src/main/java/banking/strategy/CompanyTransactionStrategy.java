package banking.strategy;

import framework.core.Notification.Email.EmailMessage;
import framework.core.Notification.Email.EmailNotification;
import framework.fintech.models.AccountEntry;
import framework.fintech.strategy.TransactionStrategy;

public class CompanyTransactionStrategy implements TransactionStrategy {
    @Override
    public void checkForAlert(AccountEntry accountEntry) {
        EmailMessage message = new EmailMessage(accountEntry.getAccount().getCustomer().getEmail(),
        		"Company Account Transaction","Company Account >> Deposit on account#: " 
        		+ accountEntry.getAccount().getId() + ", amount: " + accountEntry.getAmount());
        (new EmailNotification(message)).send();
    }
}
