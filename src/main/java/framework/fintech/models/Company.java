package framework.fintech.models;

import banking.strategy.CompanyBalanceAlertStrategy;
import banking.strategy.CompanyTransactionStrategy;
import framework.fintech.enums.CustomerType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Company extends Customer {
    private int numberOfEmployees = 0;

    public Company(String id,String name, String street, String city, String state, String zip, String email,int numberOfEmployees){
        super(id,name,email,street,city,state,zip, CustomerType.COMPANY);
//        super.getAlerts().add(new CompanyBalanceAlertStrategy());
//        super.getAlerts().add(new CompanyTransactionStrategy());
        this.numberOfEmployees = numberOfEmployees;
    }
}
