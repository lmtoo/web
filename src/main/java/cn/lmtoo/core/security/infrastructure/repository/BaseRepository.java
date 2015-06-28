package cn.lmtoo.core.security.infrastructure.repository;

import java.io.Serializable;
import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;

/**
 * 面向集合的仓储基类<br>
 * 模块：<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年7月15日 Copyright 2014 XXX有限公司.
 */
public abstract class BaseRepository<T> implements Repository<T> {
	@Override
	public boolean add(T target) {
		return add(getId(target), target);
	}

	@Override
	public boolean addAll(Collection<T> targets) {
		if (CollectionUtils.isNotEmpty(targets)) {
			for (T t : targets) {
				if (!add(t))
					return false;
			}
		}
		return true;
	}

	@Override
	public boolean contains(T target) {
		return get(getId(target)) != null;
	}

	@Override
	public boolean containsAll(Collection<T> targets) {
		if (CollectionUtils.isNotEmpty(targets)) {
			for (T t : targets) {
				if (!contains(t))
					return false;
			}
		}
		return true;
	}

	@Override
	public boolean remove(T t) {
		return remove(getId(t));
	}

	@Override
	public boolean removeAll(Collection<T> targets) {
		if (CollectionUtils.isNotEmpty(targets)) {
			for (T t : targets) {
				if (!remove(t))
					return false;
			}
		}
		return true;
	}

	@Override
	public T set(Serializable id, T target) {
		T t = get(id);
		add(id, target);
		return t;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public abstract int size();

	@Override
	public abstract void clear();

	@Override
	public abstract boolean add(Serializable id, T target);

	@Override
	public abstract boolean remove(Serializable id);

	@Override
	public abstract T get(Serializable id);

	protected abstract Serializable getId(T target);
}
