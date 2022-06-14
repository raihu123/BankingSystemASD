package ccard.strategy;

import framework.fintech.strategy.InterestStrategy;

public class BronzeCCMinPaymentStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        return ((14/100.0)*balance);
    }
}
