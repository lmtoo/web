/** 
 * Copyright (C), 2014
 * All right reserved.
 */
package cn.lmtoo.core.security.extend.session.mgt;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;

import cn.lmtoo.core.security.extend.authc.CaptchaAuthenticationToken;
import cn.lmtoo.core.security.extend.authc.CaptchaException;

/**
 * 模块：<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月13日<br>
 *          Copyright 2014 XXX有限公司.
 */
public class CaptchaAuthenticator extends ModularRealmAuthenticator {
	private CaptchaMatcher captchaMatcher;

	public CaptchaAuthenticator() {
		this(new DefaultCaptchaMatcher());
	}

	public CaptchaAuthenticator(CaptchaMatcher captchaMatcher) {
		this.captchaMatcher = captchaMatcher;
	}

	public CaptchaMatcher getCaptchaMatcher() {
		return captchaMatcher;
	}

	public void setCaptchaMatcher(CaptchaMatcher captchaMatcher) {
		this.captchaMatcher = captchaMatcher;
	}

	@Override
	protected AuthenticationInfo doAuthenticate(AuthenticationToken token) throws AuthenticationException {
		if (token instanceof CaptchaAuthenticationToken) {
			CaptchaMatcher cm = getCaptchaMatcher();
			if (cm != null) {
				if (!cm.doCaptchaMatch(token)) {
					// not successful - throw an exception to indicate this:
					String msg = "Submitted captcha for token [" + token + "] did not match the expected captcha.";
					throw new CaptchaException(msg);
				}
			} else {
				throw new AuthenticationException("A CaptchaMatcher must be configured in order to verify " + "captcha during authentication.  If you do not wish for captcha to be examined, you " + "can configure an " + AllowAllCaptchaMatcher.class.getName() + " instance.");
			}
		}

		return super.doAuthenticate(token);
	}
}