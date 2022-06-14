package framework.fintech.models;

import banking.strategy.PersonBalanceAlertStrategy;
import banking.strategy.PersonTransactionStrategy;
import framework.fintech.enums.CustomerType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Person extends Customer {
    private final LocalDate dob;

    public Person(String id,String name, String street, String city, String state, String zip, String email,LocalDate dob){
        super(id,name,email,street,city,state,zip, CustomerType.PERSON);
        super.getAlerts().add(new PersonBalanceAlertStrategy());
        super.getAlerts().add(new PersonTransactionStrategy());
        this.dob=dob;
    }
}
