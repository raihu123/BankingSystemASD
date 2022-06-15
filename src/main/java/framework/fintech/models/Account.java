package framework.fintech.models;


import framework.core.Storage.Storable;
import framework.fintech.enums.AccountType;
import framework.fintech.strategy.InterestStrategy;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class Account implements Storable<String> {

    private String id;
    protected InterestStrategy interestStrategy;
    private Customer customer;
    private Double balance = 0.0;
    private List<AccountEntry> entryList;

    protected AccountType accountType = null;

    public Account(String id, Customer customer) {
        this.id = id;
        this.customer = customer;
        this.entryList = new ArrayList<AccountEntry>();
    }


    public String getStorageKey() {
        return id;
    }

    public void addEntry(AccountEntry accountEntry){
        entryList.add(accountEntry);
    }


    public double getBalance() {
        double balance = 0;
        for (AccountEntry entry : entryList) {
            balance += entry.getAmount();
        }
        return balance;
    }

    //* Strategy pattern here
    public double calculateInterest() {
        return interestStrategy.calculateInterest(getBalance());
    }

    
}
