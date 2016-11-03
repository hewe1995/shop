package hewe.shop.dao.impl;

import org.springframework.stereotype.Repository;

import hewe.shop.dao.ICartDao;
import hewe.shop.domain.Cart;

@Repository("cartDao")
public class CartDao extends BaseDao<Cart, Integer> implements ICartDao {

	public Cart getCart(Integer cid) {

		String hql = "from " + getClazz().getSimpleName() + " where c_customer.c_id=:id";

		Cart cart = (Cart) getSession().createQuery(hql).setParameter("id", cid).getSingleResult();

		return cart;
	}

}
