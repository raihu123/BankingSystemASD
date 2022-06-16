package framework.fintech.dao;

import framework.core.DAO;
import framework.core.Storage.*;
import framework.core.Storage.Storage;
import framework.fintech.models.Customer;

public class CustomerDAO extends DAO<Customer,String> {
    @Override
    public Storage<Customer, String> createStorageFactory() {
        return StorageFactory.getMemoryStorage();
    }
}
