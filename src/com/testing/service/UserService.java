package com.testing.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;

import com.testing.model.PageVO;
import com.testing.model.UserModel;

/**
 * 
 * 
 * @author Administrator
 * 
 */
public class UserService {
	private Log log = LogFactory.getLog(getClass());

	private SqlSessionTemplate sqlSessionTemplate;

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	/**
	 * 新增
	 * 
	 * @param model
	 * @return
	 */
	public boolean addUser(UserModel model) {
		log.info("执行新增addUser,传入的model:" + model);
		try {
			sqlSessionTemplate.insert("user.addUser", model);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 查询分页
	 */
	public UserModel queryPage(UserModel model) {
		log.info("执行查询,传入的model:" + model);
		log.info("执行查询,传入的Page:" + model.getPage());

		int count = sqlSessionTemplate.selectOne("user.queryCount", model);
		model.setCount(count);
		log.info("执行查询,传入的count:" + model.getCount());
		int lastPage = count % model.getPageSize() == 0 ? count
				/ model.getPageSize() : count / model.getPageSize() + 1;
		model.setLastPage(lastPage);
		log.info("执行查询,传入的lastPage:" + model.getLastPage());
		
		int page = model.getPage();
		if (page > lastPage) {
			page = lastPage;
		}
		if (page < 1) {
			page = 1;
		}

		model.setPage(page);
		log.info("执行查询,传入的page:" + model.getPage());
		int start = (model.getPage() - 1) * model.getPageSize();
		int end = model.getPage() * model.getPageSize();
		model.setEnd(end);
		model.setStart(start);
		log.info("执行查询,传入的end:" + model.getEnd());
		log.info("执行查询,传入的start:" + model.getStart());
		List list = sqlSessionTemplate.selectList("user.queryPage", model);
		
		model.setList(list);
		log.info("执行查询,传入的list:" + model.getList());
		return model;
	}
}
