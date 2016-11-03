package hewe.shop.dao;

import java.util.List;

import hewe.shop.domain.Category;

public interface ICategoryDao extends IBaseDao<Category, Integer> {
	public List<Category> queryAll(String type, int page, int size);

	public void delete(String ids);

	public Integer queryRecordNum(String type);

	public List<Category> queryByHot(boolean hot);
}
