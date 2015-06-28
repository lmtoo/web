package cn.lmtoo.core.security.extend.web.filter.authc;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authc.UserFilter;

/**
 * 模块：多系统用户登录filter，只允许已登录的用户访问，否则跳转到相应系统的登录页面<br>
 * 描述：
 * 
 * @author Administrator
 * @version 1.0 2014-6-9<br>
 * 
 */
public class MultiSystemUserFilter extends UserFilter {
	private AuthenticationSettingHolder settingHolder;

	public void setSettingHolder(AuthenticationSettingHolder settingHolder) {
		this.settingHolder = settingHolder;
	}

	/**
	 * 用户未登录，重定向到登录页面
	 */
	@Override
	protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
		settingHolder.redirectToLogin(request, response, getLoginUrl());
	}
}