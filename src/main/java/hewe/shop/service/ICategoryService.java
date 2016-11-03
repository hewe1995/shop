package hewe.shop.service;

import java.util.List;

import hewe.shop.domain.Category;
import hewe.shop.util.model.Page;

public interface ICategoryService extends IBaseService<Category, Integer> {
	public Page<Category> getAllCategory(String type, int page, int size);

	public void deleteCategoryByIds(String ids);
	
	public List<Category> queryByHot(boolean hot);
	
}
