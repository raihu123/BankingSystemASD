package framework.fintech.repositories;

import framework.core.DAO;
import framework.core.EntityRepository;
import framework.fintech.dao.CustomerDAO;
import framework.fintech.models.Customer;

public class CustomerRepository extends EntityRepository<Customer,String> {

    @Override
    public DAO<Customer, String> getDao() {
        return new CustomerDAO();
    }
//???????????? check thisd
//    public Map<RepositoryEvents, Set<Observer>> actionListeners(){
//        Map observers =  new HashMap<RepositoryEvents, Set<Observer>>();
//        observers.put(RepositoryEvents.POST_SAVE,new CustomerCreateObserver());
//        return observers;
//    }
}
