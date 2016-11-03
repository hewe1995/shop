package hewe.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hewe.shop.dao.ICategoryDao;
import hewe.shop.domain.Category;
import hewe.shop.service.ICategoryService;
import hewe.shop.util.model.Page;

@Service("categoryService")
public class CategoryService extends BaseService<Category, Integer> implements ICategoryService {

	@Autowired
	private ICategoryDao categoryDao;

	public Page<Category> getAllCategory(String type, int page, int size) {

		Integer num = categoryDao.queryRecordNum(type);

		List<Category> list = categoryDao.queryAll(type, page, size);
		Page<Category> pagemodel = new Page<Category>();
		pagemodel.setTotal(num);
		pagemodel.setRows(list);
		return pagemodel;
	}

	public void deleteCategoryByIds(String ids) {
		categoryDao.delete(ids);

	}

	public List<Category> queryByHot(boolean hot) {
		List<Category> list = categoryDao.queryByHot(hot);
		return list;
	}

}
