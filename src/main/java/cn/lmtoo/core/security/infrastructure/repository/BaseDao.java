package cn.lmtoo.core.security.infrastructure.repository;

import cn.lmtoo.core.domain.Entity;

/**
 * 
 * 模块：所有数据访问接口的基类<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月21日<br>
 *          Copyright 2014 XXX有限公司.
 */
public interface BaseDao<T extends Entity> {
	void persist(T entity);

	void update(T entity);

	void delete(T entity);
}
