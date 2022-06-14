package framework.fintech.services;


import framework.core.Service;
import framework.fintech.models.Account;
import framework.fintech.models.Customer;

import java.util.Collection;

public interface AccountService extends Service {
    Account createAccount(Account account, Customer customer);
    void deposit(String accountNumber, double amount);
    void withdraw(String accountNumber, double amount);
    Collection<Account> getAllAccounts();
    Account getAccountById(String accountId);
    void setInterest();
}
