package framework.fintech.observers;

import framework.core.Observer.Observer;
import framework.fintech.models.AccountEntry;


public class AccountEntryObserver implements Observer<AccountEntry> {

    @Override
    public void update(AccountEntry o)
    {
        if(o.getAccount().getCustomer().getTransactionStrategy() !=null){
            o.getAccount().getCustomer().getTransactionStrategy().checkForAlert(o);
        }
    }


}
