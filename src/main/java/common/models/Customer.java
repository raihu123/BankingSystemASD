package common.models;

import common.enums.CustomerType;
import common.strategy.BalanceAlertStrategy;
import common.strategy.TransactionStrategy;
import framework.Storage.Storable;
import lombok.AllArgsConstructor;
import lombok.Data;


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
    
    
//
//    public Customer(String id, String name, String email, String street, String city, String state, String zip,
//			CustomerType customerType, BalanceAlertStrategy balanceAlertStrategy,
//			TransactionStrategy transactionStrategy) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.email = email;
//		this.street = street;
//		this.city = city;
//		this.state = state;
//		this.zip = zip;
//		this.customerType = customerType;
//		this.balanceAlertStrategy = balanceAlertStrategy;
//		this.transactionStrategy = transactionStrategy;
//	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getStreet() {
		return street;
	}



	public void setStreet(String street) {
		this.street = street;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getZip() {
		return zip;
	}



	public void setZip(String zip) {
		this.zip = zip;
	}



	public CustomerType getCustomerType() {
		return customerType;
	}



	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}



	public BalanceAlertStrategy getBalanceAlertStrategy() {
		return balanceAlertStrategy;
	}



	public void setBalanceAlertStrategy(BalanceAlertStrategy balanceAlertStrategy) {
		this.balanceAlertStrategy = balanceAlertStrategy;
	}



	public TransactionStrategy getTransactionStrategy() {
		return transactionStrategy;
	}



	public void setTransactionStrategy(TransactionStrategy transactionStrategy) {
		this.transactionStrategy = transactionStrategy;
	}



	@Override
    public String getStorageKey() {
        return this.id;
    }

}
