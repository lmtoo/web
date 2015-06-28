/** 
 * Copyright (C), 2014
 * All right reserved.
 */
package cn.lmtoo.core.security.extend.session.mgt.eis;

import java.io.Serializable;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;

import cn.lmtoo.core.tools.IdGenerator;

/**
 * 模块：Id生成器到SessionId生成器的适配<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月11日<br>
 *          Copyright 2014 XXX有限公司.
 */
public class SessionIdGeneratorAdapter implements SessionIdGenerator {
	private IdGenerator idGenerator;

	public SessionIdGeneratorAdapter() {
	}

	public SessionIdGeneratorAdapter(IdGenerator idGenerator) {
		this.idGenerator = idGenerator;
	}

	public IdGenerator getIdGenerator() {
		return idGenerator;
	}

	public void setIdGenerator(IdGenerator idGenerator) {
		this.idGenerator = idGenerator;
	}

	@Override
	public Serializable generateId(Session session) {
		return idGenerator.generateId(session);
	}
}