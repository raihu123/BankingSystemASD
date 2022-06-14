package bookstore.models;

import framework.core.Storage.Storable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Order implements Storable<String> {
    private String id;
    private List<Product> products;

    public Order(String id, List<Product> products, Customer customer, PaymentMethod paymentMethod) {
        this.id = id;
        this.products = products;
        this.customer = customer;
        this.paymentMethod = paymentMethod;
    }

    private Customer customer;
    private PaymentMethod paymentMethod;
    private double discount = 0.0;

    @Override
    public String getStorageKey() {
        return this.id;
    }

    public double getTotal(){
        double sum = 0;
        for(Product p:products){
            sum+=p.getPrice();
        }
        return sum-discount;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
    
    
    
}
