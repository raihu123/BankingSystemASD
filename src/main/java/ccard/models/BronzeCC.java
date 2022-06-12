package ccard.models;

import ccard.strategy.BronzeCCInterestStrategy;
import common.models.Customer;

public class BronzeCC extends CreditCard {
    public BronzeCC(String id, Customer customer) {
        super(id, customer);
        this.setInterestStrategy(new BronzeCCInterestStrategy());
    }
}
