package framework.fintech.strategy;

import framework.fintech.models.Account;

public interface AlertStrategy<O> {
    void checkForAlert(O o);
}
