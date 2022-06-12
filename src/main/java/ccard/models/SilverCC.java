package ccard.models;

import ccard.strategy.SilverCCInterestStrategy;

import common.models.Customer;

public class SilverCC extends CreditCard {
    public SilverCC(String id, Customer customer) {
        super(id, customer);
        this.setInterestStrategy(new SilverCCInterestStrategy());
    }
}
