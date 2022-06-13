package framework.fintech.repositories;

import framework.core.DAO;
import framework.core.EntityRepository;
import framework.fintech.dao.AccountDAO;
import framework.fintech.models.Account;

public class AccountRepository extends EntityRepository<Account,String> {

    @Override
    public DAO<Account, String> getDao() {
        return new AccountDAO();
    }

}
