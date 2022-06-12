package common.dao;

import common.models.AccountEntry;
import framework.DAO;
import framework.Storage.MemoryStorage;
import framework.Storage.Storage;


public class AccountEntryDAO extends DAO<AccountEntry,String> {
    @Override
    public Storage<AccountEntry, String> createStorageFactory() {
        return new MemoryStorage<AccountEntry,String>();
    }
}
