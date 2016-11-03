package hewe.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer c_id;
	@Column(length = 20)
	private String c_type;
	@Column(nullable = false)
	private Boolean c_hot;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Account c_account;

	public Integer getC_id() {
		return c_id;
	}

	public String getC_type() {
		return c_type;
	}

	public Boolean getC_hot() {
		return c_hot;
	}

	public Account getC_account() {
		return c_account;
	}

	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}

	public void setC_type(String c_type) {
		this.c_type = c_type;
	}

	public void setC_hot(Boolean c_hot) {
		this.c_hot = c_hot;
	}

	public void setC_account(Account c_account) {
		this.c_account = c_account;
	}

}
