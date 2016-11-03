package hewe.shop.dao;

import hewe.shop.domain.Customer;

public interface ICustomerDao extends IBaseDao<Customer, Integer> {
	public Customer find(String loginname, String password);
}
