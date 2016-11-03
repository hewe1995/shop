package hewe.shop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_shopcartitem")
public class ShopCartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iid;
	private Integer iquantity;
	private Float iprice;
	private Float isumPrice;

	@ManyToOne
	private Product iproduct;

	public ShopCartItem() {
	}

	public ShopCartItem(Product product, int quantity) {
		this.iquantity = quantity;
		this.iproduct = product;

		this.iprice = product.getP_price();
		this.isumPrice = this.iquantity * this.iprice;
	}

	public void setIquantity(Integer quantity) {
		this.iquantity = quantity;
		this.isumPrice = this.iquantity * this.iprice;
	}

	public ShopCartItem(Product product) {
		this.iquantity = 1;
		this.iproduct = product;

		this.iprice = product.getP_price();
		this.isumPrice = this.iquantity * this.iprice;
	}

	public Integer getIid() {
		return iid;
	}

	public void setIid(Integer id) {
		this.iid = id;
	}

	public Integer getIquantity() {
		return iquantity;
	}

	public Product getIproduct() {
		return iproduct;
	}

	public Float getIprice() {
		return iprice;
	}

	public Float getIsumPrice() {
		return isumPrice;
	}

}
