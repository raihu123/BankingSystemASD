package framework.fintech.dao;

import framework.core.DAO;
import framework.core.Storage.*;
import framework.core.Storage.Storage;
import framework.fintech.models.Account;
import framework.fintech.models.AccountEntry;


public class AccountEntryDAO extends DAO<AccountEntry,String> {
    @Override
    public Storage<AccountEntry, String> createStorageFactory() {
        return StorageFactory.getMemoryStorage();
    }
}
