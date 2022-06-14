package ccard.controllers;

import banking.controllers.IAccountController;
import ccard.enums.CreditCardType;
import ccard.factory.CreditCardFactory;
import ccard.services.CreditCardAccountServiceImpl;
import framework.fintech.enums.AccountType;
import framework.fintech.models.Account;
import framework.fintech.models.AccountEntry;
import framework.fintech.models.Customer;
import framework.fintech.models.Person;

import java.time.LocalDate;
import java.util.Collection;

public class CreditAccountController implements IAccountController {
    CreditCardAccountServiceImpl accountService;

    public CreditAccountController() {
        accountService = new CreditCardAccountServiceImpl();
    }

    public Account createAccount(String ccn, String name, String street, String city, String state, String zip, String email, LocalDate dob, AccountType accountType, CreditCardType cardType) {
//        UUID uuid = UUID.randomUUID();
        Customer person = new Person(ccn, name, street, city, state, zip, email, dob);
//        uuid = UUID.randomUUID();

        Account account = CreditCardFactory.createCredCard(cardType, ccn, person);

        return accountService.createAccount(account, person);
    }


    public void deposit(String accountNumber, double amount) {
        accountService.deposit(accountNumber, amount);
    }


    public void withdraw(String accountNumber, double amount) {
        accountService.withdraw(accountNumber, amount);
    }

    public Collection<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    public Account getAccountById(String accountId) {
        return accountService.getAccountById(accountId);
    }


    public double getMinimumPayment(String accountNumber){
        return accountService.getMinimumPayment(accountNumber);
    }

    public Collection<AccountEntry>  getMonthlyBilling(String accountNumber) {
        return accountService.getMonthlyBilling(accountNumber);
    }

}
