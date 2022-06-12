package common.observers;

import common.models.AccountEntry;
import framework.Observer.Observer;


public class AccountEntryObserver implements Observer<AccountEntry> {

    @Override
    public void update(AccountEntry o)
    {
        if(o.getAccount().getCustomer().getTransactionStrategy() !=null){
            o.getAccount().getCustomer().getTransactionStrategy().checkForAlert(o);
        }
    }


}
