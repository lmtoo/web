/** 
 * Copyright (C), 2014
 * All right reserved.
 */
package cn.lmtoo.core.security.extend.session.mgt;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * 模块：允许所有的验证码通过验证，但必须不能为空<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月13日<br>
 *          Copyright 2014 XXX有限公司.
 */
public class AllowAllCaptchaMatcher implements CaptchaMatcher {
	@Override
	public boolean doCaptchaMatch(AuthenticationToken token) {
		return true;
	}
}