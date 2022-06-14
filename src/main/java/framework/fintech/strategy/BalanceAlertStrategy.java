package framework.fintech.strategy;

import framework.fintech.models.Account;

public interface BalanceAlertStrategy {
    void checkForAlert(Account account);
}
