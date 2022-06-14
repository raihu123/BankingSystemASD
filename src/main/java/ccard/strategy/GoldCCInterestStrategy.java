package ccard.strategy;

import framework.fintech.strategy.InterestStrategy;

public class GoldCCInterestStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        return ((6/100.0)*balance);
    }
}
