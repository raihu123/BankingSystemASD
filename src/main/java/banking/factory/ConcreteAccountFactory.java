package banking.factory;

import banking.models.CheckingsAccount;
import banking.models.SavingsAccount;
import framework.fintech.enums.AccountType;
import framework.fintech.factory.AccountFactory;
import framework.fintech.models.Account;
import framework.fintech.models.Customer;

public class ConcreteAccountFactory implements AccountFactory<AccountType> {
    @Override
    public Account createAccount(AccountType accountType, String accountNumber, Customer customer) {
        Account account = null;
        if(accountType == AccountType.CHECKING) {
            account = new CheckingsAccount(accountNumber, customer);
        }
        else {
            account = new SavingsAccount(accountNumber, customer);
        }
        return  account;
    }
}
