package hewe.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hewe.shop.dao.ICartDao;
import hewe.shop.domain.Cart;
import hewe.shop.domain.Customer;
import hewe.shop.domain.ItemCart;
import hewe.shop.service.ICartService;

@Service("cartService")
@Transactional
public class CartService extends BaseService<Cart, Integer> implements ICartService {

	@Autowired
	private ICartDao cartDao;

	public void addItem(Cart target, ItemCart item) {
		target.setC_price(item.getI_sumprice());
		target.setC_quantity(item.getI_quantity());

		target.getC_items().put(item.getI_product().getP_id().toString(), item);

		this.update(target);
	}

	public void removeItem(Cart target, String proId) {
		ItemCart item = target.getC_items().get(proId);
		target.setC_price(-item.getI_sumprice());
		target.setC_quantity(-item.getI_quantity());
		target.getC_items().remove(proId);
		this.update(target);
	}

	public Cart getCart(Integer cid) {
		Cart cart = cartDao.getCart(cid);
		if (cart == null) {
			cart = new Cart();
			cart.setC_price((float) 0);
			cart.setC_quantity(0);
			Customer customer = new Customer();
			customer.setC_id(cid);
			cart.setC_customer(customer);
			cartDao.save(cart);
		}
		return cart;
	}

	public void changeItem(Cart target, String proId, int quantity) {
		ItemCart item = target.getC_items().get(proId);
		if (item != null) {
			float price = item.getI_price();
			item.setI_quantity(quantity);
			target.setC_price(price * quantity);
			target.setC_quantity(quantity);
			this.update(target);
		}
	}

}
