package cn.lmtoo.core.domain;

import java.io.Serializable;

public class BaseEntity<T extends Serializable> implements Entity<T> {
	private T id;

	@Override
	public T getId() {
		return id;
	}

	@Override
	public void setId(T id) {
		this.id = id;
	}
}