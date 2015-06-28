/** 
 * Copyright (C), 2014
 * All right reserved.
 */  
package cn.lmtoo.core.security.extend.authc.pam;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 模块：<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月11日<br>
 * Copyright 2014 XXX有限公司.
 */
public class AuthenticationListenerAdapter implements
		AuthenticationStageListener {

	/* (non-Javadoc)
	 * @see org.apache.shiro.authc.AuthenticationListener#onSuccess(org.apache.shiro.authc.AuthenticationToken, org.apache.shiro.authc.AuthenticationInfo)
	 */
	@Override
	public void onSuccess(AuthenticationToken token, AuthenticationInfo info) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.apache.shiro.authc.AuthenticationListener#onFailure(org.apache.shiro.authc.AuthenticationToken, org.apache.shiro.authc.AuthenticationException)
	 */
	@Override
	public void onFailure(AuthenticationToken token, AuthenticationException ae) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.apache.shiro.authc.AuthenticationListener#onLogout(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	public void onLogout(PrincipalCollection principals) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see cn.ddd.core.security.tools.AuthenticationStageListener#onBefore(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	public void onBefore(AuthenticationToken authenticationToken) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see cn.ddd.core.security.tools.AuthenticationStageListener#onAfter(org.apache.shiro.authc.AuthenticationToken, org.apache.shiro.authc.AuthenticationInfo)
	 */
	@Override
	public void onAfter(AuthenticationToken authenticationToken,
			AuthenticationInfo authenticationInfo) {
		// TODO Auto-generated method stub

	}

}
