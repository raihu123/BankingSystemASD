package framework.fintech.controllers;

import ccard.enums.CreditCardType;
import framework.core.Controller;
import framework.fintech.enums.AccountType;
import framework.fintech.models.Account;
import framework.fintech.models.AccountEntry;

import java.time.LocalDate;
import java.util.Collection;


public interface IAccountController extends Controller {
    void deposit(String accountNumber, double amount);

    void withdraw(String accountNumber, double amount);

    Collection<Account> getAllAccounts();

    Account getAccountById(String accountId);

    default double getMinimumPayment(String accountNumber) {
        throw new UnsupportedOperationException();
    }

    default Collection<AccountEntry> getMonthlyBilling(String accountNumber) {
        throw new UnsupportedOperationException();
    }

    default Account createAccount(String cc, String name, String street, String city, String state, String zip, String email, LocalDate dob, AccountType accountType, CreditCardType cardType) {
        throw new UnsupportedOperationException();
    }

    default Account createPersonalAccount(String accountNumber, String name, String street, String city, String state, String zip, String email, LocalDate dob, AccountType accountType) {
        throw new UnsupportedOperationException();
    }

    default Account createCompanyAccount(String accountNumber, String name, String email, String street, String city, String state, String zip, int numberOfEmployees, AccountType accountType) {
        throw new UnsupportedOperationException();
    }
    default void addInterest(){
        throw new UnsupportedOperationException();
    }
}
