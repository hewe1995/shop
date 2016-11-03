package hewe.shop.dao;

import java.util.List;

import hewe.shop.domain.Product;

public interface IProductDao extends IBaseDao<Product, Integer> {
	public List<Product> queryAll(String name, int page, int size);

	public void delete(String ids);

	public Integer queryRecordNum(String name);
	
	//根据热点类别,查询 4个
	public List<Product> queryByCid(int cid);
}
