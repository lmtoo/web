/** 
 * Copyright (C), 2014
 * All right reserved.
 */
package cn.lmtoo.core.security.extend.authc.captcha;

/**
 * 模块：验证码服务类,可以生产验证码，并交验验证码,交由实现类实现<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月13日<br>
 *          Copyright 2014 XXX有限公司.
 */
public interface CaptchaService {
	/**
	 * 随机生成验证码，并将验证码放到关联的session中，返回的字符串可以生成验证码图片，<br>
	 * 是否将图片生成的职责放到此类中待调查
	 * 
	 * @param target
	 * @return
	 */
	String generateCaptcha(Object target);

	/**
	 * 是否匹配已生产过的验证码
	 * 
	 * @param submitted
	 * @return
	 */
	boolean captchaMatch(Object submitted);
}
