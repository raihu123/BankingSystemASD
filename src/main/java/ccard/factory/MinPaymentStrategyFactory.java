package ccard.factory;

import ccard.enums.CreditCardType;
import ccard.strategy.BronzeCCMinPaymentStrategy;
import ccard.strategy.GoldCCMinPaymentStrategy;
import ccard.strategy.NoCCMinPaymentStrategy;
import ccard.strategy.SilverCCMinPaymentStrategy;
import framework.fintech.strategy.InterestStrategy;

public class MinPaymentStrategyFactory {
    private static GoldCCMinPaymentStrategy goldCCMinPaymentStrategy;
    private static SilverCCMinPaymentStrategy silverCCMinPaymentStrategy;
    private static BronzeCCMinPaymentStrategy bronzeCCMinPaymentStrategy;
    private static final NoCCMinPaymentStrategy noCCMinPaymentStrategy = new NoCCMinPaymentStrategy();

    public static InterestStrategy getMinPaymentStrategy(CreditCardType cardType) {

        if (cardType == CreditCardType.BRONZE) {
            if(bronzeCCMinPaymentStrategy == null)
                bronzeCCMinPaymentStrategy = new BronzeCCMinPaymentStrategy();

        } else if (cardType == CreditCardType.GOLD) {
            if(goldCCMinPaymentStrategy == null)
                goldCCMinPaymentStrategy = new GoldCCMinPaymentStrategy();
            return goldCCMinPaymentStrategy;
        } else if (cardType == CreditCardType.SILVER) {
            if(silverCCMinPaymentStrategy == null)
                silverCCMinPaymentStrategy = new SilverCCMinPaymentStrategy();
            return silverCCMinPaymentStrategy;
        }

        return noCCMinPaymentStrategy;

    }
}
