package bookstore.dao;

import bookstore.models.Order;
import framework.core.DAO;
import framework.core.Storage.*;
import framework.core.Storage.Storage;

public class OrderDao extends DAO<Order, String> {
    @Override
    public Storage<Order, String> createStorageFactory() {
        return new MemoryStorage<Order,String>();
    }
}
