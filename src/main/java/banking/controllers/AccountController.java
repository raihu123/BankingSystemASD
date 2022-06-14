package banking.controllers;

import banking.services.AccountServiceImpl;
import framework.fintech.enums.AccountType;
import framework.fintech.models.Account;
import framework.fintech.models.Company;
import framework.fintech.models.Customer;
import framework.fintech.models.Person;
import framework.fintech.services.AccountService;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;
@Getter
@Setter
public class AccountController implements IAccountController {
    AccountService accountService;

    public AccountController(){
        accountService = AccountServiceImpl.getInstance();
    }

    public Account createPersonalAccount(String accountNumber, String name, String street, String city, String state, String zip, String email, LocalDate dob, AccountType accountType){
       UUID uuid = UUID.randomUUID();
       Customer person = new Person(uuid.toString(),name,street,city,state,zip,email,dob);
       Account account = new Account(accountNumber,person,accountType);
       return accountService.createAccount(account,person);
    }

    public Account createCompanyAccount(String accountNumber,String name, String email, String street, String city, String state, String zip, int numberOfEmployees, AccountType accountType){
        UUID uuid = UUID.randomUUID();
        Customer company = new Company(uuid.toString(),name,street,city,state,zip,email,numberOfEmployees);
        Account account = new Account(accountNumber,company,accountType);
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
