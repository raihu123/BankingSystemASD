package bookstore.observers;

import bookstore.models.Order;
import framework.core.Observer.Observer;

public class OrderObserver implements Observer<Order> {
    @Override
    public void update(Order o) {
        if(o.getCustomer().getOrders().size()>3){
            o.setDiscount(o.getTotal()*10/100);
        }
    }
}
