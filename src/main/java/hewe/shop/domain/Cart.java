package hewe.shop.domain;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_cart")
public class Cart {
	@Id
	@GeneratedValue
	private Integer c_id;
	private Float c_price;
	private Integer c_quantity;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private Map<String, ItemCart> c_items = new HashMap<String, ItemCart>();

	@OneToOne
	@JoinColumn(nullable = false, unique = true)
	private Customer c_customer;

	public Cart() {
		this.c_price = (float) 0;
		this.c_quantity = 0;
	}

	public Integer getC_id() {
		return c_id;
	}

	public Float getC_price() {
		return c_price;
	}

	public Integer getC_quantity() {
		return c_quantity;
	}

	public Customer getC_customer() {
		return c_customer;
	}

	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}

	public void setC_price(Float c_price) {
		this.c_price += c_price;
	}

	public void setC_quantity(Integer c_quantity) {
		this.c_quantity += c_quantity;
	}

	public void setC_customer(Customer c_customer) {
		this.c_customer = c_customer;
	}

	public Map<String, ItemCart> getC_items() {
		return c_items;
	}

	public void setC_items(Map<String, ItemCart> c_items) {
		this.c_items = c_items;
	}
}
