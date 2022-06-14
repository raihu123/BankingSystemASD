package framework.fintech.repositories;

import framework.core.DAO;
import framework.core.EntityRepository;
import framework.fintech.dao.AccountEntryDAO;
import framework.fintech.models.AccountEntry;

public class AccountEntryRepository extends EntityRepository<AccountEntry,String> {

    @Override
    public DAO<AccountEntry, String> getDao() {
        return new AccountEntryDAO();
    }

}
