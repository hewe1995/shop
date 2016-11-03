package hewe.shop.dao.impl;

import org.springframework.stereotype.Repository;

import hewe.shop.dao.IShopCartDao;
import hewe.shop.domain.ShopCart;

@Repository("shopCartDao")
public class ShopCartDao extends BaseDao<ShopCart, Integer> implements IShopCartDao {

	public ShopCart get(String user_key) {
		ShopCart cart = null;
		String hql = "from " + getClazz().getSimpleName() + //
				" where userkey=:key";
		try {
			cart = (ShopCart) getSession().createQuery(hql).setParameter("key", user_key).getSingleResult();

		} catch (Exception e) {
			return null;
		}

		return cart;
	}

	public ShopCart getByCustomerId(int cid) {
		ShopCart cart = null;
		String hql = "from " + getClazz().getSimpleName() + " where ccustomer.c_id=:id";
		try {
			cart = (ShopCart) getSession().createQuery(hql).setParameter("id", cid).getSingleResult();

		} catch (Exception e) {
			return null;
		}
		return cart;
	}

}
