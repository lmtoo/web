/** 
 * Copyright (C), 2014
 * All right reserved.
 */
package cn.lmtoo.core.security.extend.authc.captcha;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.session.Session;

import cn.lmtoo.core.security.extend.session.mgt.CaptchaMatcher;

/**
 * 模块：<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月13日<br>
 *          Copyright 2014 XXX有限公司.
 */
public class DefaultCaptchaService implements CaptchaService {
	public static final String CAPTCHA_SESSION_KEY = CaptchaMatcher.class.getName() + ".RUN_AS_PRINCIPALS_SESSION_KEY";

	public boolean captchaMatch(Object submited) {
		if (submited == null) {
			throw new IllegalArgumentException("the submited captcha cannot be null!!");
		}
		Session session = SecurityUtils.getSubject().getSession(false);
		if (session == null) {
			throw new AuthenticationException("session cannot be null!!!");
		}
		Object expected = session.getAttribute(CAPTCHA_SESSION_KEY).toString();

		return submited.equals(expected);
	}

	@Override
	public String generateCaptcha(Object target) {
		String captcha = "1234";
		// TODO:验证码生成规则

		Session session = SecurityUtils.getSubject().getSession();
		session.setAttribute(CAPTCHA_SESSION_KEY, captcha);
		return captcha;
	}
}