package hewe.shop.util.model;

import java.io.Serializable;
import java.util.List;

public class Page<MODEL> implements Serializable {
	private Integer total;
	private List<MODEL> rows;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<MODEL> getRows() {
		return rows;
	}

	public void setRows(List<MODEL> rows) {
		this.rows = rows;
	}
}
