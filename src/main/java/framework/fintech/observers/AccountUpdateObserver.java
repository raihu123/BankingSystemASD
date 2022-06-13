package framework.fintech.observers;

import framework.core.Observer.Observer;
import framework.fintech.models.Account;


public class AccountUpdateObserver implements Observer<Account> {
    @Override
    public void update(Account o) {
        if(o.getCustomer().getBalanceAlertStrategy() !=null){
            o.getCustomer().getBalanceAlertStrategy().checkForAlert(o);
        }
    }
}
