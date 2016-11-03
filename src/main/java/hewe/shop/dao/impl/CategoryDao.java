package hewe.shop.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import hewe.shop.dao.ICategoryDao;
import hewe.shop.domain.Category;

@Repository("categoryDao")
public class CategoryDao extends BaseDao<Category, Integer> implements ICategoryDao {

	private static final Logger log = Logger.getLogger(CategoryDao.class);

	@SuppressWarnings("unchecked")
	public List<Category> queryAll(String type, int page, int size) {

		String hql = "from " + getClazz().getSimpleName() + " c left join fetch c.c_account where c.c_type like :type";

		List<Category> list = getSession().createQuery(hql).setParameter("type", "%" + type + "%")
				.setFirstResult((page - 1) * size).setMaxResults(size).getResultList();
		log.debug("list :" + list);
		return list;
	}

	public void delete(String ids) {
		String hql = "delete from " + getClazz().getSimpleName() + " c where c.c_id in (" + ids + ")";
		getSession().createQuery(hql).executeUpdate();
	}

	public Integer queryRecordNum(String type) {
		String hql = "select count(*) from " + getClazz().getSimpleName() + " c where c.c_type like :type";
		long num = (Long) getSession().createQuery(hql).setParameter("type", "%" + type + "%").getSingleResult();
		log.debug("num :" + num);
		return (int) num;
	}

	@SuppressWarnings("unchecked")
	public List<Category> queryByHot(boolean hot) {

		String hql = "from " + getClazz().getSimpleName() + " c where c.c_hot=:hot"; //
		List<Category> list = getSession().createQuery(hql).setParameter("hot", hot).getResultList();
		return list;
	}

}
