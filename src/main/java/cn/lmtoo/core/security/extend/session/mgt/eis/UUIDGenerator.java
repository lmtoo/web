package cn.lmtoo.core.security.extend.session.mgt.eis;

import java.io.Serializable;
import java.util.UUID;

import cn.lmtoo.core.tools.IdGenerator;

public class UUIDGenerator implements IdGenerator {

	@Override
	public Serializable generateId(Object target) {
		return UUID.randomUUID().toString();
	}

}
