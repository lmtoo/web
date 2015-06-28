/** 
 * Copyright (C), 2014
 * All right reserved.
 */
package cn.lmtoo.core.security.extend.authc;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 模块：<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月11日<br>
 *          Copyright 2014 XXX有限公司.
 */
public class CaptchaUsernamePasswordToken extends UsernamePasswordToken implements CaptchaAuthenticationToken {
	private String captcha;

	public CaptchaUsernamePasswordToken() {
	}

	public CaptchaUsernamePasswordToken(final String username, final String password, final boolean rememberMe, final String host, final String captcha) {
		super(username, password, rememberMe, host);
		this.captcha = captcha;
	}

	@Override
	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
}