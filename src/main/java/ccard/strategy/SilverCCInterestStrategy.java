package ccard.strategy;

import framework.fintech.strategy.InterestStrategy;

public class SilverCCInterestStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        return ((8/100.0)*balance);
    }
}
