package bookstore.services;

import bookstore.models.Customer;
import bookstore.models.Order;
import bookstore.models.PaymentMethod;
import bookstore.models.Product;
import bookstore.observers.OrderObserver;
import bookstore.repositories.OrderRepository;
import framework.core.Service;

import java.util.List;
import java.util.UUID;

public class OrderService implements Service {
    OrderRepository orderRepository;

    public OrderService(){
        orderRepository = new OrderRepository();
        orderRepository.addObserver(new OrderObserver());
    }

    public Order createOrder(Customer customer, List<Product> productList, PaymentMethod paymentMethod){

        Order order= new Order(UUID.randomUUID().toString(),productList,customer,paymentMethod);
        orderRepository.save(order);
        return order;
    }
}
