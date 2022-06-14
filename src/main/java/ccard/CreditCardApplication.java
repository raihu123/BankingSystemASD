package ccard;


import ccard.controllers.CreditAccountController;
import ccard.enums.CreditCardType;
import framework.fintech.enums.AccountType;
import framework.fintech.models.Account;
import framework.fintech.models.AccountEntry;

import java.time.LocalDate;
import java.util.Collection;

public class CreditCardApplication {

    public static void main(String[] args) {
        CreditAccountController creditAccountController = new CreditAccountController();
        LocalDate dob = LocalDate.now();
        Account creditAccount = creditAccountController.createAccount("xxxssnxx","Salim", "street", "City", "IA", "52556", "salim96tr@gmail.com", dob, AccountType.CREDIT, CreditCardType.GOLD);

        creditAccountController.deposit(creditAccount.getId(), 100);
        creditAccountController.deposit(creditAccount.getId(), 500);
        creditAccountController.withdraw(creditAccount.getId(), 1000);
        creditAccount = creditAccountController.getAccountById(creditAccount.getId());
        
        System.out.println("\nCredit Account \n");

        double currentBalance = creditAccount.getBalance();
        System.out.println("Current Balance: " + currentBalance);
        System.out.println("Minimum Payment " + creditAccountController.getMinimumPayment(creditAccount.getId()));
        
        Collection<AccountEntry> accountEntries = creditAccountController.getMonthlyBilling(creditAccount.getId());
        
        for (AccountEntry entry : accountEntries) {
            System.out.println( entry.getAmount());
        }
    }

}
