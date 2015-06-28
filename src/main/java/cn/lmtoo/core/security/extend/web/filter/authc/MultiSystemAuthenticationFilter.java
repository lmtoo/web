package cn.lmtoo.core.security.extend.web.filter.authc;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
 * 模块：多系统登录页面验证控制filter，未登录成功跳转到相应系统的登录页面<br>
 * 描述：
 * 
 * @author Administrator
 * @version 1.0 2014-6-9<br>
 * 
 */
public class MultiSystemAuthenticationFilter extends FormAuthenticationFilter {
	private AuthenticationSettingHolder settingHolder;

	/**
	 * @param settingHolder
	 *            the settingHolder to set
	 */
	public void setSettingHolder(AuthenticationSettingHolder settingHolder) {
		this.settingHolder = settingHolder;
	}

	/*
	 * 登录成功跳转页面
	 * 
	 * @see
	 * org.apache.shiro.web.filter.authc.AuthenticationFilter#issueSuccessRedirect
	 * (javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	@Override
	protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
		settingHolder.issueSuccessRedirect(request, response, getSuccessUrl());
	}

	/*
	 * 在登录页面将系统cookie写入
	 * 
	 * @see
	 * org.apache.shiro.web.filter.AccessControlFilter#isLoginRequest(javax.
	 * servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	@Override
	protected boolean isLoginRequest(ServletRequest request, ServletResponse response) {
		return settingHolder.isLoginRequest(request, response, getLoginUrl());
	}

	/*
	 * 跳转到系统对应的登录页面
	 * 
	 * @see
	 * org.apache.shiro.web.filter.AccessControlFilter#redirectToLogin(javax
	 * .servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	@Override
	protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
		settingHolder.redirectToLogin(request, response, getLoginUrl());
	}
}