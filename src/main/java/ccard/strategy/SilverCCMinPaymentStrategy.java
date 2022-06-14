package ccard.strategy;

import framework.fintech.strategy.InterestStrategy;

public class SilverCCMinPaymentStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        return ((12/100.0)*balance);
    }
}
