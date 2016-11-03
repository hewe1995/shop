package hewe.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hewe.shop.dao.IAccountDao;
import hewe.shop.domain.Account;
import hewe.shop.service.IAccountService;

@Service("accountService")
public class AccountService extends BaseService<Account, String> implements IAccountService {

	@Autowired
	private IAccountDao aDao;

}
