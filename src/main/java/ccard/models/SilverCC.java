package ccard.models;

import ccard.strategy.SilverCCInterestStrategy;
import framework.fintech.models.Customer;

public class SilverCC extends CreditCard {
    public SilverCC(String id, Customer customer) {
        super(id, customer);
        interestStrategy = new SilverCCInterestStrategy();
    }
}
