package framework.fintech.models;

import framework.core.Storage.Storable;
import framework.fintech.enums.CustomerType;
import framework.fintech.strategy.BalanceAlertStrategy;
import framework.fintech.strategy.TransactionStrategy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Data
public abstract  class Customer implements Storable<String> {

    private String id;
    private String name;
    private String email;
    private String street;
    private String city;
    private String state;
    private String zip;
    private CustomerType customerType;
    private BalanceAlertStrategy balanceAlertStrategy;
    private TransactionStrategy transactionStrategy;

	@Override
    public String getStorageKey() {
        return this.id;
    }

}
