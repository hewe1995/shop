package hewe.shop.service;

import hewe.shop.domain.Cart;
import hewe.shop.domain.ItemCart;

public interface ICartService extends IBaseService<Cart, Integer> {
	public void addItem(Cart target, ItemCart item);

	public void removeItem(Cart target, String proId);

	public void changeItem(Cart target, String proId, int quantity);

	public Cart getCart(Integer cid);
}
