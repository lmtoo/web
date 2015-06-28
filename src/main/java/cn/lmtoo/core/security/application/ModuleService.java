package cn.lmtoo.core.security.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lmtoo.core.security.domain.Module;
import cn.lmtoo.core.security.infrastructure.repository.ModuleDao;

/**
 * 
 * 模块：<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月21日<br>
 *          Copyright 2014 XXX有限公司.
 */
@Service
public class ModuleService {
	@Autowired
	private ModuleDao moduleDao;

	public void addNewModule(Module module) {
		moduleDao.persist(module);
	}
}