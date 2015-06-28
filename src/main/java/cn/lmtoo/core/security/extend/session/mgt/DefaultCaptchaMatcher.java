/** 
 * Copyright (C), 2014
 * All right reserved.
 */
package cn.lmtoo.core.security.extend.session.mgt;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.util.StringUtils;

import cn.lmtoo.core.security.extend.authc.CaptchaAuthenticationToken;
import cn.lmtoo.core.security.extend.authc.CaptchaException;
import cn.lmtoo.core.security.extend.authc.captcha.CaptchaService;
import cn.lmtoo.core.security.extend.authc.captcha.DefaultCaptchaService;

/**
 * 模块：<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月13日<br>
 *          Copyright 2014 XXX有限公司.
 */
public class DefaultCaptchaMatcher implements CaptchaMatcher {
	private CaptchaService captchaService = new DefaultCaptchaService();

	private boolean isCaptchaEnable = true;

	public CaptchaService getCaptchaService() {
		return captchaService;
	}

	public void setCaptchaService(CaptchaService captchaService) {
		this.captchaService = captchaService;
	}

	public boolean isCaptchaEnable() {
		return isCaptchaEnable;
	}

	public void setCaptchaEnable(boolean isCaptchaEnable) {
		this.isCaptchaEnable = isCaptchaEnable;
	}

	@Override
	public boolean doCaptchaMatch(AuthenticationToken token) {
		if (token instanceof CaptchaAuthenticationToken && isCaptchaEnable) {
			CaptchaAuthenticationToken captchaAuthenticationToken = (CaptchaAuthenticationToken) token;
			String actual = captchaAuthenticationToken.getCaptcha();
			if (!StringUtils.hasText(actual)) {
				throw new CaptchaException("captcha cannot be null!!!");
			}
			return captchaService.captchaMatch(actual);
		}
		return true;
	}
}
