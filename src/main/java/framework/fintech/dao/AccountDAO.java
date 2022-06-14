package framework.fintech.dao;

import framework.core.DAO;
import framework.core.Storage.*;
import framework.core.Storage.Storage;
import framework.fintech.models.Account;

public class AccountDAO extends DAO<Account,String> {
    @Override
    public Storage<Account, String> createStorageFactory() {
        return new MemoryStorage<Account,String>();
    }
}
