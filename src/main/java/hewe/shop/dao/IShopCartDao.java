package hewe.shop.dao;

import hewe.shop.domain.ShopCart;

public interface IShopCartDao extends IBaseDao<ShopCart, Integer> {
	public ShopCart get(String user_key);
	public ShopCart getByCustomerId(int cid);
}
