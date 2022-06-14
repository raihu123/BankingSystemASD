package framework.fintech.strategy;

import framework.fintech.models.Account;

public interface BalanceAlertStrategy extends AlertStrategy<Account> {
    void checkForAlert(Account account);
}
