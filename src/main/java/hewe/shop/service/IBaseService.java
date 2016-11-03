package hewe.shop.service;

import java.util.List;

public interface IBaseService<MODEL, KEY> {
	public void save(MODEL model);

	public Integer getRecordNum();

	public List<MODEL> queryAll();

	public MODEL get(KEY key);

	public void update(MODEL model);
}
