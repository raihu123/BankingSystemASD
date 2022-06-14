package framework.fintech.observers;

import framework.core.Observer.Observer;
import framework.fintech.models.AccountEntry;
import framework.fintech.strategy.TransactionStrategy;


public class AccountEntryObserver implements Observer<AccountEntry> {

    @Override
    public void update(AccountEntry o)
    {
        o.getAccount().getCustomer().getAlerts().forEach((alter) -> {
            if ((alter instanceof TransactionStrategy)) {
                alter.checkForAlert(o);
            }
        });
    }


}
