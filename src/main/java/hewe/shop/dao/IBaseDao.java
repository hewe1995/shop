package hewe.shop.dao;

import java.util.List;

public interface IBaseDao<MODEL, KEY> {
	public void save(MODEL model);

	public MODEL find(KEY key);

	public Integer queryRecordNum();
	public List<MODEL> queryAll();
	public void update(MODEL model);
}
