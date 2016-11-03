package hewe.shop.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_account")
public class Account {
	@Id
	private String a_id;
	private String a_login;
	private String a_password;
	private String a_name;

	public String getA_id() {
		return a_id;
	}

	public String getA_login() {
		return a_login;
	}

	public String getA_password() {
		return a_password;
	}

	public String getA_name() {
		return a_name;
	}

	public void setA_id(String a_id) {
		this.a_id = a_id;
	}

	public void setA_login(String a_login) {
		this.a_login = a_login;
	}

	public void setA_password(String a_password) {
		this.a_password = a_password;
	}

	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
}
