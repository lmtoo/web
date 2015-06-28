/** 
 * Copyright (C), 2014
 * All right reserved.
 */
package cn.lmtoo.core.security.extend.session.mgt;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * 模块：验证码管理器<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月13日<br>
 *          Copyright 2014 XXX有限公司.
 */
public interface CaptchaMatcher {
	/**
	 * 验证码是否匹配
	 * 
	 * @return
	 */
	boolean doCaptchaMatch(AuthenticationToken token);
}
