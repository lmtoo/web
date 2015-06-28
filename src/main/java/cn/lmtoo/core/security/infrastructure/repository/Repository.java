package cn.lmtoo.core.security.infrastructure.repository;

import java.io.Serializable;
import java.util.Collection;

/**
 * 面向集合的仓储接口<br>
 * 模块：<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年7月15日 Copyright 2014 XXX有限公司.
 */
public interface Repository<T> {
	boolean add(T target);

	boolean add(Serializable id, T target);

	boolean addAll(Collection<T> targets);

	boolean contains(T target);

	boolean containsAll(Collection<T> targets);

	T get(Serializable id);

	boolean isEmpty();

	boolean remove(T t);

	boolean remove(Serializable id);

	boolean removeAll(Collection<T> targets);

	T set(Serializable id, T target);

	/**
	 * 仓储已存储数据大小
	 * 
	 * @return
	 */
	int size();

	/**
	 * 清空仓储
	 */
	void clear();
}