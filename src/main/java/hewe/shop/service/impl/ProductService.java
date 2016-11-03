package hewe.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hewe.shop.dao.IProductDao;
import hewe.shop.domain.Product;
import hewe.shop.service.IProductService;
import hewe.shop.util.model.Page;

@Service("productService")
public class ProductService extends BaseService<Product, Integer> implements IProductService {

	@Autowired
	private IProductDao pDao;

	public Page<Product> getAllProduct(String name, int page, int size) {
		Integer num = pDao.queryRecordNum(name);

		Page<Product> pageModel = new Page<Product>();

		List<Product> list = pDao.queryAll(name, page, size);
		pageModel.setTotal(num);
		pageModel.setRows(list);

		return pageModel;
	}

	public void deleteProductByIds(String ids) {
		pDao.delete(ids);

	}

	public List<Product> queryByCid(int cid) {
		List<Product> list = pDao.queryByCid(cid);
		return list;
	}

}
