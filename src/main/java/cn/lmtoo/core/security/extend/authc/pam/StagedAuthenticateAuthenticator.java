/** 
 * Copyright (C), 2014
 * All right reserved.
 */
package cn.lmtoo.core.security.extend.authc.pam;

import java.util.Collection;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationListener;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;

/**
 * 模块：分步骤验证的验证器<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月11日<br>
 *          Copyright 2014 XXX有限公司.
 */
public class StagedAuthenticateAuthenticator extends ModularRealmAuthenticator {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.shiro.authc.AbstractAuthenticator#setAuthenticationListeners
	 * (java.util.Collection)
	 */
	@Override
	public void setAuthenticationListeners(Collection<AuthenticationListener> listeners) {
		super.setAuthenticationListeners(listeners);
		setDefaultListeners(getAuthenticationListeners());
	}

	/**
	 * 设置默认的监听器
	 * 
	 * @param listeners
	 */
	private void setDefaultListeners(Collection<AuthenticationListener> listeners) {
	}

	@Override
	protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken) throws AuthenticationException {

		notifyBefore(authenticationToken);
		// 验证之前？
		AuthenticationInfo authenticationInfo = super.doAuthenticate(authenticationToken);
		// 验证之后
		notifyAfter(authenticationToken, authenticationInfo);
		return authenticationInfo;
	}

	private void notifyBefore(AuthenticationToken authenticationToken) {
		Collection<AuthenticationListener> listeners = getAuthenticationListeners();
		for (AuthenticationListener listener : listeners) {
			if (listener instanceof AuthenticationStageListener) {
				((AuthenticationStageListener) listener).onBefore(authenticationToken);
			}
		}
	}

	private void notifyAfter(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
		Collection<AuthenticationListener> listeners = getAuthenticationListeners();
		for (AuthenticationListener listener : listeners) {
			if (listener instanceof AuthenticationStageListener) {
				((AuthenticationStageListener) listener).onAfter(authenticationToken, authenticationInfo);
			}
		}
	}
}
