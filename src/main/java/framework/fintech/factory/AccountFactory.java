package framework.fintech.factory;

import framework.fintech.models.Account;
import framework.fintech.models.Customer;

public interface AccountFactory<T> {
    Account createAccount(T accountType, String accountNumber, Customer customer);
}
