/** 
 * Copyright (C), 2014
 * All right reserved.
 */
package cn.lmtoo.ui.web.realm;

import java.util.Collection;

import org.apache.shiro.authz.Permission;
import org.springframework.context.ApplicationListener;

import cn.lmtoo.core.security.domain.UserAccount;
import cn.lmtoo.core.security.domain.event.UserAccountEvent;
import cn.lmtoo.core.security.extend.realm.BaseSecurityRealm;
import cn.lmtoo.core.security.infrastructure.repository.AccountRepository;

/**
 * 模块：<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月9日<br>
 *          Copyright 2014 XXX有限公司.
 */
public class UserAccountRealm extends BaseSecurityRealm implements ApplicationListener<UserAccountEvent> {
	private AccountRepository userAccountDao;

	public void setUserAccountDao(AccountRepository userAccountDao) {
		this.userAccountDao = userAccountDao;
	}

	@Override
	protected Collection<Permission> findPermissionsByRoleName(String roleName) {
		return null;
	}

	@Override
	protected UserAccount findUserAccountByUsername(String username) {
		return userAccountDao.findUserAccountByUsername(username);
	}

	@Override
	public void onApplicationEvent(UserAccountEvent event) {
		clearCache(event.getUserAccount().getPrincipals());
	}
}