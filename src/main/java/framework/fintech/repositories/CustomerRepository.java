package framework.fintech.repositories;

import framework.core.DAO;
import framework.core.EntityRepository;
import framework.core.Observer.Observer;
import framework.core.RepositoryEvents;
import framework.fintech.dao.CustomerDAO;
import framework.fintech.models.Customer;
import framework.fintech.observers.CustomerCreateObserver;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CustomerRepository extends EntityRepository<Customer,String> {

    @Override
    public DAO<Customer, String> getDao() {
        return new CustomerDAO();
    }

    public Map<RepositoryEvents, Set<Observer>> actionListeners(){
        Map observers =  new HashMap<RepositoryEvents, Set<Observer>>();
        observers.put(RepositoryEvents.POST_SAVE,new CustomerCreateObserver());
        return observers;
    }
}
