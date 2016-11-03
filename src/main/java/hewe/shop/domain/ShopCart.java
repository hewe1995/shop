package hewe.shop.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "t_shopcart")
public class ShopCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;
	private Integer csumQuantity;
	private Float csumPrice;
	@OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
	@Cascade(value = { CascadeType.ALL })
	private Map<Integer, ShopCartItem> citems = new HashMap<Integer, ShopCartItem>();

	private String userkey;

	@OneToOne()
	@Cascade(value = { CascadeType.DETACH })
	private Customer ccustomer;

	public ShopCart() {
		this.csumPrice = 0f;
		this.csumQuantity = 0;
	}

	public void add(Product product) {
		ShopCartItem item = null;
		item = citems.get(product.getP_id());
		if (item != null) {
			item.setIquantity(item.getIquantity() + 1);
		} else {
			item = new ShopCartItem(product);
			citems.put(product.getP_id(), item);
		}
		this.csumPrice += item.getIprice();
		this.csumQuantity += 1;
	}

	public void removeAll(Product product) {
		ShopCartItem item = citems.remove(product.getP_id());
		if (item != null) {
			this.csumPrice -= item.getIsumPrice();
			this.csumQuantity -= item.getIquantity();
		}
	}

	public void removeOne(Product product) {
		ShopCartItem item = citems.get(product.getP_id());
		if (item != null) {
			item.setIquantity(item.getIquantity() - 1);
			this.csumPrice -= item.getIprice();
			this.csumQuantity -= 1;
		}
	}

	public void clear() {
		citems.clear();
		this.csumPrice = 0f;
		this.csumQuantity = 0;
	}

	/*
	 * 合并购物车
	 */
	public void putAll(ShopCart cart) {
		if (cart.equals(this) || cart == this) {
			return;
		}
		if (cart != null && !cart.getCitems().isEmpty()) {
			Map<Integer, ShopCartItem> oldMap = cart.getCitems();
			for (Entry<Integer, ShopCartItem> entry : oldMap.entrySet()) {
				int key = entry.getKey();
				if (this.getCitems().containsKey(key)) {
					ShopCartItem item = this.getCitems().get(key);
					int NowQuantity = item.getIquantity();
					int oldQuantity = entry.getValue().getIquantity();
					float price = item.getIprice();
					item.setIquantity(NowQuantity + oldQuantity);
					this.csumPrice += price * oldQuantity;
					this.csumQuantity += oldQuantity;
				} else {
					ShopCartItem newItem = entry.getValue();
					this.csumPrice += newItem.getIsumPrice();
					this.csumQuantity += newItem.getIquantity();
					this.getCitems().put(newItem.getIproduct().getP_id(), newItem);
				}

			}
		}
	}

	public Integer getCsumQuantity() {

		return csumQuantity;
	}

	public Float getCsumPrice() {
		return csumPrice;
	}

	public Map<Integer, ShopCartItem> getCitems() {
		return citems;
	}

	public void setCitems(Map<Integer, ShopCartItem> items) {
		this.citems = items;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer id) {
		this.cid = id;
	}

	public Customer getCcustomer() {
		return ccustomer;
	}

	public void setCcustomer(Customer customer) {
		this.ccustomer = customer;
	}

	public String getUserkey() {
		return userkey;
	}

	public void setUserkey(String userkey) {
		this.userkey = userkey;
	}
}
