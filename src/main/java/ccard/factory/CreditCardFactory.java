package ccard.factory;

import ccard.enums.CreditCardType;
import ccard.models.CreditCard;
import framework.fintech.models.Customer;

public abstract class CreditCardFactory {
    public abstract CreditCard createCredCard(CreditCardType cardType, String id, Customer customer);
}
