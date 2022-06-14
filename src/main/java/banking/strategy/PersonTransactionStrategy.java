package banking.strategy;

import framework.core.notification.Email.EmailMessage;
import framework.core.notification.Email.EmailNotification;
import framework.fintech.models.AccountEntry;
import framework.fintech.strategy.TransactionStrategy;

public class PersonTransactionStrategy implements TransactionStrategy {
    @Override
    public void checkForAlert(AccountEntry accountEntry) {
        if(Math.abs(accountEntry.getAmount()) > 500  ){
        	
            EmailMessage message = new EmailMessage(
            		accountEntry.getAccount().getCustomer().getEmail(), //to
            		"Account Transaction", //subject
            		"Personal Account >> Deposit Transaction: " 
            + accountEntry.getAccount().getId() + ", amount: " + accountEntry.getAmount());
            (new EmailNotification(message)).send();
        }
    }
}
