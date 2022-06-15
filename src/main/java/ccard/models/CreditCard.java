package ccard.models;

import ccard.strategy.NoCCMinPaymentStrategy;
import framework.fintech.enums.AccountType;
import framework.fintech.models.Account;
import framework.fintech.models.Customer;
import framework.fintech.strategy.InterestStrategy;

public abstract class CreditCard extends Account {

    private InterestStrategy minPaymentStrategy;

    public CreditCard(String id, Customer customer) {
        super(id, customer);
        interestStrategy = new NoCCMinPaymentStrategy();
        accountType = AccountType.CREDIT;
    }
//
//    public InterestStrategy getMinPaymentStrategy() {
//        return minPaymentStrategy;
//    }
//
//    public void setMinPaymentStrategy(InterestStrategy minPaymentStrategy) {
//        this.minPaymentStrategy = minPaymentStrategy;
//    }
}
