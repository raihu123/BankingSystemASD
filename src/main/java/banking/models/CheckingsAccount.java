package banking.models;

import banking.strategy.BasicAccountInterestStrategy;
import framework.fintech.enums.AccountType;
import framework.fintech.models.Account;
import framework.fintech.models.Customer;

public class CheckingsAccount extends Account {
    public CheckingsAccount(String id, Customer customer) {
        super(id, customer);
        interestStrategy = new BasicAccountInterestStrategy();
        accountType = AccountType.CHECKING;
    }
}
