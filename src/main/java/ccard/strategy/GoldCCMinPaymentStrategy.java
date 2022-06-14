package ccard.strategy;

import framework.fintech.strategy.InterestStrategy;

public class GoldCCMinPaymentStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        return ((10/100.0)*balance);
    }
}
