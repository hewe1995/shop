package hewe.shop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 购物车项
 * 
 * @author HEWE
 *
 */
@Entity
@Table(name = "t_itemCart")
public class ItemCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer i_id;

	private Float i_sumprice;// 总价格
	private Float i_price;// 单价
	private Integer i_quantity;// 总数量
	@ManyToOne
	@JoinColumn(nullable = false)
	private Product i_product;// 产品

	@ManyToOne
	private Cart i_cart;

	public ItemCart(Product product, Integer quantity) {
		// 初始化
		this.i_sumprice = (float) 0;
		this.i_quantity = 0;
		this.i_product = product;
		// 赋值
		this.setI_price(product.getP_price());
		this.setI_quantity(quantity);
	}

	public ItemCart(Product product) {
		// 初始化
		this.i_sumprice = (float) 0;
		this.i_quantity = 0;
		this.i_product = product;
		// 赋值
		this.setI_price(product.getP_price());
		this.setI_quantity(1);
	}

	public ItemCart() {
	}

	public Integer getI_id() {
		return i_id;
	}

	public void setI_id(Integer i_id) {
		this.i_id = i_id;
	}

	public Integer getI_quantity() {
		return i_quantity;
	}

	public void setI_quantity(Integer i_quantity) {
		this.i_quantity += i_quantity;
		if (this.i_quantity <= 0) {
			this.i_sumprice = (float) 0;
			this.i_quantity = 0;
		} else {
			this.i_sumprice = this.i_quantity * this.i_price;
		}

	}

	public Product getI_product() {
		return i_product;
	}

	public void setI_product(Product i_product) {
		this.i_product = i_product;
	}

	public Float getI_price() {
		return i_price;
	}

	public void setI_price(Float i_price) {
		this.i_price = i_price;
	}

	public Float getI_sumprice() {
		return i_sumprice;
	}

	public void setI_sumprice(Float price) {
		this.i_sumprice += price;
	}
}
