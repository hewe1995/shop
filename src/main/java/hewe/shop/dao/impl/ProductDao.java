package hewe.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import hewe.shop.dao.IProductDao;
import hewe.shop.domain.Product;

@Repository("productDao")
public class ProductDao extends BaseDao<Product, Integer> implements IProductDao {

	@SuppressWarnings("unchecked")
	public List<Product> queryAll(String name, int page, int size) {

		String hql = "from " + getClazz().getSimpleName() + " c left join fetch c.p_category where c.p_name like :name order by c.p_date desc";
		List<Product> list = getSession().createQuery(hql).setParameter("name", "%" + name + "%")
				.setFirstResult((page - 1) * size).setMaxResults(size).getResultList();

		return list;
	}

	public Integer queryRecordNum(String name) {

		String hql = "select count(*) from " + getClazz().getSimpleName() + " c where c.p_name like :name";
		long num = (Long) getSession().createQuery(hql).setParameter("name", "%" + name + "%").getSingleResult();

		return (int) num;
	}

	public void delete(String ids) {
		String hql = "delete from " + getClazz().getSimpleName() + " c where c.p_id in (" + ids + ")";
		getSession().createQuery(hql).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Product> queryByCid(int cid) {

		String hql = "from " + getClazz().getSimpleName() + //
				" p where p.p_commend=:commend AND p.p_open=:open AND p.p_category.c_id=:cid order by p.p_date DESC";
		List<Product> list = getSession().createQuery(hql).setParameter("commend", true).setParameter("open", true).//
				setParameter("cid", cid).getResultList();

		return list;
	}
}
