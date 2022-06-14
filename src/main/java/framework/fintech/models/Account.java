package framework.fintech.models;


import framework.core.Storage.Storable;
import framework.fintech.enums.AccountType;
import framework.fintech.strategy.InterestStrategy;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public  class Account implements Storable<String> {
	
    private String id;
    private InterestStrategy interestStrategy;
    private Customer customer;
    private AccountType accountType;
    private Double balance = 0.0;
    private List<AccountEntry> entryList;

    public Account(String id, Customer customer, AccountType accountType) {
        this.id = id;
        this.customer = customer;
        this.accountType = accountType;
        entryList = new ArrayList<AccountEntry>();
    }

    @Override
    public String getStorageKey() {
        return this.id;
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
    
}
