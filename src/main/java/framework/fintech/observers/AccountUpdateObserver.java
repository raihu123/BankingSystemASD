package framework.fintech.observers;

import framework.core.Observer.Observer;
import framework.fintech.models.Account;
import framework.fintech.strategy.BalanceAlertStrategy;
import framework.fintech.strategy.TransactionStrategy;


public class AccountUpdateObserver implements Observer<Account> {
    @Override
    public void update(Account o) {
        o.getCustomer().getAlerts().forEach((alter) -> {
            if (alter instanceof BalanceAlertStrategy) {
                alter.checkForAlert(o);
            }
        });
    }
}
