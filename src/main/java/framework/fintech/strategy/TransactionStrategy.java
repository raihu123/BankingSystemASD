package framework.fintech.strategy;

import framework.fintech.models.AccountEntry;

public interface TransactionStrategy extends AlertStrategy<AccountEntry> {
    void checkForAlert(AccountEntry accountEntry);
}
