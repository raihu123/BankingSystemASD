package framework.fintech.strategy;

import framework.fintech.models.AccountEntry;

public interface TransactionStrategy {
    void checkForAlert(AccountEntry accountEntry);
}
