package bookstore.models;

import framework.core.Storage.Storable;

import java.util.ArrayList;
import java.util.List;


public class Customer implements Storable<String> {
    private String id;
    private String name;
    private List<Order> orders;

    public Customer(String id,String name){
        this.id = id;
        this.name = name;
        orders = new ArrayList<Order>();
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    @Override
    public String getStorageKey() {
        return this.id;
    }

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

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
    
    
}
