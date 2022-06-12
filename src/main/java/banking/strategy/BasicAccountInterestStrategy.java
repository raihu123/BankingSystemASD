package banking.strategy;

import common.strategy.InterestStrategy;

public class BasicAccountInterestStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        return 0.15 * balance;
    }
}
