package hewe.shop.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer p_id;
	@Column(length = 10, nullable = false)
	private String p_name;
	@Column(nullable = false)
	private Float p_price;

	private String p_pic;
	@Column(length = 100)
	private String p_remark;
	@Column(length = 400)
	private String p_xremark;

	@Column(nullable = false)
	private Date p_date;

	private Boolean p_commend;

	private Boolean p_open;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	private Category p_category;

	public Integer getP_id() {
		return p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public Float getP_price() {
		return p_price;
	}

	public String getP_pic() {
		return p_pic;
	}

	public String getP_remark() {
		return p_remark;
	}

	public String getP_xremark() {
		return p_xremark;
	}

	public Date getP_date() {
		return p_date;
	}

	public Boolean getP_commend() {
		return p_commend;
	}

	public Boolean getP_open() {
		return p_open;
	}

	public Category getP_category() {
		return p_category;
	}

	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public void setP_price(Float p_price) {
		this.p_price = p_price;
	}

	public void setP_pic(String p_pic) {
		this.p_pic = p_pic;
	}

	public void setP_remark(String p_remark) {
		this.p_remark = p_remark;
	}

	public void setP_xremark(String p_xremark) {
		this.p_xremark = p_xremark;
	}

	public void setP_date(Date p_date) {
		this.p_date = p_date;
	}

	public void setP_commend(Boolean p_commend) {
		this.p_commend = p_commend;
	}

	public void setP_open(Boolean p_open) {
		this.p_open = p_open;
	}

	public void setP_category(Category p_category) {
		this.p_category = p_category;
	}

	@Override
	public String toString() {
		return "Product [p_id=" + p_id + ", p_name=" + p_name + ", p_price=" + p_price + ", p_pic=" + p_pic
				+ ", p_remark=" + p_remark + ", p_xremark=" + p_xremark + ", p_date=" + p_date + ", p_commend="
				+ p_commend + ", p_open=" + p_open + ", p_category=" + p_category + "]";
	}

}
