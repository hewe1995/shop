package hewe.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_imagefile")
public class ImageFile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer i_id;
	@Column(nullable = false)
	private String i_name;
	@Column(nullable = false)
	private String i_path;

	public Integer getI_id() {
		return i_id;
	}

	public String getI_name() {
		return i_name;
	}

	public String getI_path() {
		return i_path;
	}

	public void setI_id(Integer i_id) {
		this.i_id = i_id;
	}

	public void setI_name(String i_name) {
		this.i_name = i_name;
	}

	public void setI_path(String i_path) {
		this.i_path = i_path;
	}
}
