package hewe.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hewe.shop.dao.ICustomerDao;
import hewe.shop.domain.Customer;
import hewe.shop.service.ICustomerService;

@Service("customerService")
public class CustomerService extends BaseService<Customer, Integer> implements ICustomerService {

	@Autowired
	private ICustomerDao cDao;

	public Customer findCustomer(String loginname, String password) {

		Customer customer = cDao.find(loginname, password);

		return customer;
	}

}
