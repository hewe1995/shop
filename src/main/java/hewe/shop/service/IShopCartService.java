package hewe.shop.service;

import hewe.shop.domain.ShopCart;

public interface IShopCartService extends IBaseService<ShopCart, Integer> {
	public ShopCart getCart(String user_key);

	public ShopCart getCart(int cid);
}
