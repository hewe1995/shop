package hewe.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hewe.shop.dao.IShopCartDao;
import hewe.shop.domain.ShopCart;
import hewe.shop.service.IShopCartService;

@Service("shopCartService")
public class ShopCartService extends BaseService<ShopCart, Integer> implements IShopCartService {

	@Autowired
	private IShopCartDao cartDao;

	public ShopCart getCart(String user_key) {
		ShopCart cart = cartDao.get(user_key);

		return cart;
	}

	public ShopCart getCart(int cid) {
		ShopCart cart = cartDao.getByCustomerId(cid);
		return cart;
	}

}
