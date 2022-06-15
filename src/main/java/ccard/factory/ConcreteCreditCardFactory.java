package ccard.factory;

import ccard.enums.CreditCardType;
import ccard.models.BronzeCC;
import ccard.models.CreditCard;
import ccard.models.GoldCC;
import ccard.models.SilverCC;
import framework.fintech.factory.AccountFactory;
import framework.fintech.models.Account;
import framework.fintech.models.Customer;

public class ConcreteCreditCardFactory implements AccountFactory <CreditCardType> {

    @Override
    public Account createAccount(CreditCardType cardType, String accountNumber, Customer customer) {
        CreditCard creditCard = null;

        if (cardType == CreditCardType.BRONZE) {
            creditCard = new BronzeCC(accountNumber, customer);
        } else if (cardType == CreditCardType.GOLD) {
            creditCard = new GoldCC(accountNumber, customer);
        } else if (cardType == CreditCardType.SILVER) {
            creditCard = new SilverCC(accountNumber, customer);
        }
        // ?? REVIEW
        ///creditCard.setInterestStrategy(MinPaymentStrategyFactory.getMinPaymentStrategy(cardType));
        //creditCard.setMinPaymentStrategy(MinPaymentStrategyFactory.getMinPaymentStrategy(cardType));
        return creditCard;
    }
}
