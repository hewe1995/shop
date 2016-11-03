package hewe.shop.dao;

import hewe.shop.domain.Cart;

public interface ICartDao extends IBaseDao<Cart, Integer> {
	public Cart getCart(Integer cid);
}
