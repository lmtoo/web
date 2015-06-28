package cn.lmtoo.core.security.extend.web.filter.authc;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import com.google.common.collect.Maps;

/**
 * 模块：多系统登录配置信息保持器<br>
 * 描述：
 * 
 * @author Administrator
 * @version 1.0 2014-6-9<br>
 * 
 */
public class AuthenticationSettingHolder {
	public static final String DEFAULT_SYSTEM_COOKIE_NAME = "SYSTEM";
	private String cookieName = DEFAULT_SYSTEM_COOKIE_NAME;

	/**
	 * cookie系统名称与跳转登录路径
	 */
	private Map<String, String> loginUrls = Maps.newHashMap();

	private Map<String, String> successUrls = Maps.newHashMap();

	/**
	 * @param cookieName
	 *            the cookieName to set
	 */
	public void setCookieName(String cookieName) {
		this.cookieName = cookieName;
	}

	/**
	 * @param loginUrls
	 *            the loginUrls to set
	 */
	public void setLoginUrls(Map<String, String> loginUrls) {
		this.loginUrls = loginUrls;
	}

	/**
	 * @param successUrls
	 *            the successUrls to set
	 */
	public void setSuccessUrls(Map<String, String> successUrls) {
		this.successUrls = successUrls;
	}

	/*
	 * 登录成功跳转页面
	 * 
	 * @see
	 * org.apache.shiro.web.filter.authc.AuthenticationFilter#issueSuccessRedirect
	 * (javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	protected void issueSuccessRedirect(ServletRequest request, ServletResponse response, String defaultUrl) throws Exception {
		HttpServletRequest httpRequest = WebUtils.toHttp(request);
		String systemKey = getSystemKey(httpRequest);
		String location = successUrls.get(systemKey);
		location = StringUtils.isEmpty(location) ? defaultUrl : location;
		WebUtils.redirectToSavedRequest(request, response, location);
	}

	/*
	 * 在登录页面将系统cookie写入
	 * 
	 * @see
	 * org.apache.shiro.web.filter.AccessControlFilter#isLoginRequest(javax.
	 * servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	protected boolean isLoginRequest(ServletRequest request, ServletResponse response, String defaultUrl) {
		boolean isMatch = isLoginPath(defaultUrl, request);
		String cookieValue = StringUtils.EMPTY;
		for (Map.Entry<String, String> entry : loginUrls.entrySet()) {
			boolean isLoginPath = isLoginPath(entry.getValue(), request);
			if (isLoginPath)
				cookieValue = entry.getKey();
			isMatch = isMatch || isLoginPath;
		}
		if (!isLoginSubmission(request, response)) {
			appendCookie(cookieValue, response);
		}
		return isMatch;
	}

	protected boolean isLoginSubmission(ServletRequest request, ServletResponse response) {
		return (request instanceof HttpServletRequest) && WebUtils.toHttp(request).getMethod().equalsIgnoreCase(AccessControlFilter.POST_METHOD);
	}

	/**
	 * 判断是否为登录页面，严格判断
	 * 
	 * @param path
	 * @param request
	 * @return
	 */
	protected boolean isLoginPath(String path, ServletRequest request) {
		HttpServletRequest httpRequest = WebUtils.toHttp(request);
		String contextPath = WebUtils.getContextPath(httpRequest);
		String requestUri = WebUtils.getPathWithinApplication(httpRequest);
		if (!StringUtils.isEmpty(httpRequest.getQueryString())) {
			requestUri += "?" + httpRequest.getQueryString();
		}

		if (StringUtils.startsWithIgnoreCase(requestUri, contextPath)) {
			// Normal case: URI contains context path.
			String reqPath = requestUri.substring(contextPath.length());
			requestUri = StringUtils.isEmpty(reqPath) ? "/" : reqPath;
		}
		return StringUtils.equals(path, requestUri);
	}

	/**
	 * 将所登录的系统写入cookie
	 * 
	 * @param cookieValue
	 * @param request
	 * @param response
	 */
	protected void appendCookie(String cookieValue, ServletResponse response) {
		HttpServletResponse httpResponse = WebUtils.toHttp(response);
		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookie.setMaxAge(Integer.MAX_VALUE);
		httpResponse.addCookie(cookie);
	}

	/*
	 * 跳转到系统对应的登录页面
	 * 
	 * @see
	 * org.apache.shiro.web.filter.AccessControlFilter#redirectToLogin(javax
	 * .servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	protected void redirectToLogin(ServletRequest request, ServletResponse response, String defaultUrl) throws IOException {
		HttpServletRequest httpRequest = WebUtils.toHttp(request);
		String systemKey = getSystemKey(httpRequest);
		String location = loginUrls.get(systemKey);
		location = StringUtils.isEmpty(location) ? defaultUrl : location;
		WebUtils.issueRedirect(request, response, location);
	}

	protected String getSystemKey(HttpServletRequest request) {
		Cookie cookie = getSystemCookie(request);
		if (cookie == null)
			return StringUtils.EMPTY;
		return cookie.getValue();
	}

	/**
	 * 获取系统cookie
	 * 
	 * @param request
	 * @return
	 */
	protected Cookie getSystemCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null)
			return null;
		Cookie theCookie = null;
		for (Cookie cookie : cookies) {
			if (cookieName.equals(cookie.getName())) {
				theCookie = cookie;
				break;
			}
		}
		return theCookie;
	}
}
