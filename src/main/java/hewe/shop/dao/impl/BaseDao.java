package hewe.shop.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import hewe.shop.dao.IBaseDao;

@Repository("baseDao")
@Lazy(true)
public class BaseDao<MODEL, KEY extends Serializable> implements IBaseDao<MODEL, KEY> {

	private static final Logger log = Logger.getLogger(BaseDao.class);

	private Class clazz;

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public BaseDao() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class) type.getActualTypeArguments()[0];
		System.out.println(clazz);
	}

	@Resource
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(MODEL model) {
		getSession().save(model);
	}

	public MODEL find(KEY key) {
		MODEL M = (MODEL) getSession().get(clazz, key);

		return M;
	}

	public Integer queryRecordNum() {
		String hql = "select count(*) from " + clazz.getSimpleName();
		long num = (Long) getSession().createQuery(hql).getSingleResult();
		int intNum = (int) num;
		return (Integer) intNum;
	}

	public List<MODEL> queryAll() {
		String hql = "from " + getClazz().getSimpleName();
		List<MODEL> list = getSession().createQuery(hql).getResultList();
		return list;
	}

	public void update(MODEL model) {
		getSession().update(model);
	}

}
