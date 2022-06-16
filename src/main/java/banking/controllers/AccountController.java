package banking.controllers;

import banking.factory.ConcreteAccountFactory;
import banking.services.AccountServiceImpl;
import banking.strategy.CompanyBalanceAlertStrategy;
import banking.strategy.CompanyTransactionStrategy;
import banking.strategy.PersonBalanceAlertStrategy;
import banking.strategy.PersonTransactionStrategy;
import framework.fintech.controllers.IAccountController;
import framework.fintech.enums.AccountType;
import framework.fintech.factory.AccountFactory;
import framework.fintech.models.Company;
import framework.fintech.models.Person;
import framework.fintech.services.AccountService;

import framework.fintech.models.Account;
import framework.fintech.models.Customer;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;
public class AccountController implements IAccountController {

    private AccountService accountService;
    private AccountFactory accountFactory;
    public AccountController(){
        accountService = AccountServiceImpl.getInstance();
        accountFactory = new ConcreteAccountFactory();
    }

    public Account createPersonalAccount(String accountNumber, String name, String street,
                                         String city, String state, String zip, String email, LocalDate dob,
                                         AccountType accountType){
        UUID uuid = UUID.randomUUID();
        Customer person = new Person(uuid.toString(),name,street,city,state,zip,email,dob);

        person.getAlerts().add(new PersonBalanceAlertStrategy());
        person.getAlerts().add(new PersonTransactionStrategy());

        Account account = accountFactory.createAccount(accountType, accountNumber, person);

        return accountService.createAccount(account,person);
    }

    public Account createCompanyAccount(String accountNumber,String name, String email, String street,
                                        String city, String state, String zip, int numberOfEmployees,
                                        AccountType accountType){
        UUID uuid = UUID.randomUUID();
        Customer company = new Company(uuid.toString(),name,street,city,state,zip,email,numberOfEmployees);

        //
        company.getAlerts().add(new CompanyBalanceAlertStrategy());
        company.getAlerts().add(new CompanyTransactionStrategy());

        Account account = accountFactory.createAccount(accountType, accountNumber, company);

        return accountService.createAccount(account,company);
    }

    public void deposit(String accountNumber, double amount) {
        accountService.deposit(accountNumber,amount);
    }


    public void withdraw(String accountNumber, double amount) {
        accountService.withdraw(accountNumber,amount);
    }

    public Collection<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    public Account getAccountById(String accountId) {
        return accountService.getAccountById(accountId);
    }

    public void addInterest(){
        accountService.setInterest();
    }



}
