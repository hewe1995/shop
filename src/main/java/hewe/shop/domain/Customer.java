package hewe.shop.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer c_id;
	private String c_loginame;
	private String c_password;
	private String c_email;
	private String c_phone;
	private String c_name;
	private String c_sex;

	public Integer getC_id() {
		return c_id;
	}

	public String getC_loginame() {
		return c_loginame;
	}

	public String getC_password() {
		return c_password;
	}

	public String getC_email() {
		return c_email;
	}

	public String getC_phone() {
		return c_phone;
	}

	public String getC_name() {
		return c_name;
	}

	public String getC_sex() {
		return c_sex;
	}

	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}

	public void setC_loginame(String c_loginame) {
		this.c_loginame = c_loginame;
	}

	public void setC_password(String c_password) {
		this.c_password = c_password;
	}

	public void setC_email(String c_email) {
		this.c_email = c_email;
	}

	public void setC_phone(String c_phone) {
		this.c_phone = c_phone;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public void setC_sex(String c_sex) {
		this.c_sex = c_sex;
	}

}
