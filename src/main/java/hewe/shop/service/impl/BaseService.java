package hewe.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hewe.shop.dao.IBaseDao;
import hewe.shop.service.IBaseService;

@Service("baseService")
@Lazy(true)
@Transactional
public class BaseService<MODEL, KEY> implements IBaseService<MODEL, KEY> {

	@Autowired
	private IBaseDao<MODEL, KEY> dao;

	public void save(MODEL model) {
		dao.save(model);
		System.out.println("tttttttttt-----" + dao);
	}

	public Integer getRecordNum() {
		Integer num = dao.queryRecordNum();
		return num;
	}

	public List<MODEL> queryAll() {
		List<MODEL> list = dao.queryAll();
		return list;
	}

	public MODEL get(KEY key) {
		MODEL m = dao.find(key);
		return m;
	}

	public void update(MODEL model) {
		dao.update(model);

	}

}
