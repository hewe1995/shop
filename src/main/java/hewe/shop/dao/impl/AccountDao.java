package hewe.shop.dao.impl;

import org.springframework.stereotype.Repository;

import hewe.shop.dao.IAccountDao;
import hewe.shop.domain.Account;

@Repository("accountDao")
public class AccountDao extends BaseDao<Account, String> implements IAccountDao {

	

}
