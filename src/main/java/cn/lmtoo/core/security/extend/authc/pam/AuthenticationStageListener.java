/** 
 * Copyright (C), 2014
 * All right reserved.
 */
package cn.lmtoo.core.security.extend.authc.pam;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationListener;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * 模块：<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月11日<br>
 *          Copyright 2014 XXX有限公司.
 */
public interface AuthenticationStageListener extends AuthenticationListener {
	/**
	 * 在验证之前
	 * 
	 * @param authenticationToken
	 */
	void onBefore(AuthenticationToken authenticationToken);

	/**
	 * 验证之后
	 * 
	 * @param authenticationToken
	 * @param authenticationInfo
	 */
	void onAfter(AuthenticationToken authenticationToken,
			AuthenticationInfo authenticationInfo);
}
