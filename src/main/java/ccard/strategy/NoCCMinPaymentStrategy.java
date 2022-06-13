package ccard.strategy;

import framework.fintech.strategy.InterestStrategy;

public class NoCCMinPaymentStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        return (0);
    }
}
