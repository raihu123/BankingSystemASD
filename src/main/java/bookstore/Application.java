package bookstore;

import bookstore.models.*;
import bookstore.services.CustomerService;
import bookstore.services.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Application {

    public static CustomerService customerService = new CustomerService();
    public static OrderService orderService = new OrderService();

    public static void main(String[] args){

        Product p1 = new Book(UUID.randomUUID().toString(),"Design Patterns",100);
        Product p2 = new AudioBook(UUID.randomUUID().toString(),"Football legands",30);
        List<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        
        Product p3 = new Book(UUID.randomUUID().toString(),"Head First Patterns",80);
        Product p4 = new AudioBook(UUID.randomUUID().toString(),"My Travel to middel east",35);
        List<Product> products2 = new ArrayList<>();
        products2.add(p3);
        products2.add(p4);
        products.add(p4);

        Customer c1 = customerService.createCustomer("Sam");
        Customer c2 = customerService.createCustomer("Nap");

        Order o1 = orderService.createOrder(c1,products,new DebitCard());
        c1.addOrder(o1);
        Order o2 = orderService.createOrder(c1,products2,new CreditCard());
        c1.addOrder(o2);
        Order o3 = orderService.createOrder(c2,products2,new DebitCard());
        c2.addOrder(o3);
        Order o4 = orderService.createOrder(c2,products,new CreditCard());
        c2.addOrder(o4);

        for(Order o:c1.getOrders()){
            System.out.println("Customer order name :" + o.getCustomer().getName() + " Order# "+o.getId()
            +" total: "+o.getTotal() + " "+ o.getPaymentMethod().getClass().getSimpleName());
        }
        
        for(Order o:c2.getOrders()){
            System.out.println("Customer order name :" + o.getCustomer().getName() +" Order# "+o.getId()
            +" total: "+o.getTotal() + " "+ o.getPaymentMethod().getClass().getSimpleName());
        }

    }
}
