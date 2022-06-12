package banking.strategy;

import common.models.AccountEntry;
import common.strategy.TransactionStrategy;
import framework.Components.Notification.Email.EmailMessage;
import framework.Components.Notification.Email.EmailNotification;

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
