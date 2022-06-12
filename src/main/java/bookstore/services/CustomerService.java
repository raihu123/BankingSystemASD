package bookstore.services;

import bookstore.models.Customer;
import bookstore.repositories.CustomerRepository;

import java.util.UUID;

public class CustomerService {
    CustomerRepository customerRepository;

    public CustomerService(){
        customerRepository = new CustomerRepository();
    }

    public Customer createCustomer(String name){
        Customer customer= new Customer(UUID.randomUUID().toString(),name);
        customerRepository.save(customer);
        return customer;
    }
    public void updateCustomer(Customer customer){
        customerRepository.update(customer);
    }

	public CustomerRepository getCustomerRepository() {
		return customerRepository;
	}

	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

    
}
