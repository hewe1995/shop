package hewe.shop.dao.impl;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import hewe.shop.dao.ICustomerDao;
import hewe.shop.domain.Customer;

@Repository("customerDao")
public class CustomerDao extends BaseDao<Customer, Integer> implements ICustomerDao {

	public Customer find(String loginname, String password) {
		Customer customer = null;
		String hql = "from " + getClazz().getSimpleName() + " where c_loginame=:loginname and c_password=:password";
		try {
			customer = (Customer) getSession().createQuery(hql).setParameter("loginname", loginname)
					.setParameter("password", password).getSingleResult();
		} catch (NoResultException noResult) {
			return null;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return customer;
	}

}
