package hewe.shop.service;

import java.util.List;

import hewe.shop.domain.Product;
import hewe.shop.util.model.Page;

public interface IProductService extends IBaseService<Product, Integer> {
	public Page<Product> getAllProduct(String name, int page, int size);
	
	public void deleteProductByIds(String ids);
	public List<Product> queryByCid(int cid);
}
