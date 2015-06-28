package cn.lmtoo.core.domain;

import java.util.EventObject;

/**
 * 领域事件基类
 * 模块：<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年7月16日
 * Copyright 2014 XXX有限公司.
 */
public abstract class DomainEvent extends EventObject implements Entity<Long> {
	private Long id;

	private final long timestamp;

	public final long getTimestamp() {
		return this.timestamp;
	}

	public DomainEvent(Object source) {
		super(source);
		this.timestamp = System.currentTimeMillis();
	}

	public DomainEvent(Long id, Object source) {
		this(source);
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
}