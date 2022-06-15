package framework.fintech.models;

import framework.core.Storage.Storable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
public  class AccountEntry implements Storable<String> {

    private String id;
    private LocalDate date;
    private double amount;
    private String description;
    private String fromAccountNumber;
    private String fromPersonName;
    private Account account;


    public AccountEntry(double amount, String description, String fromAccountNumber, String fromPersonName) {
        super();
        this.id = UUID.randomUUID().toString();
        this.date = LocalDate.now();
        this.amount = amount;
        this.description = description;
        this.fromAccountNumber = fromAccountNumber;
        this.fromPersonName = fromPersonName;
    }

    @Override
    public String getStorageKey() {
        return this.id;
    }


	@Override
    public String toString() {
        return "\n[" +
                ", date=" + date +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", balance=" + account.getBalance() +
                "]\n";
    }
}
