package hewe.shop.service;

import hewe.shop.domain.Customer;

public interface ICustomerService extends IBaseService<Customer, Integer> {
	public Customer findCustomer(String loginname, String password);
}
