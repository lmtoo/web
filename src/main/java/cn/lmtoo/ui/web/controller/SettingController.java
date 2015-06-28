package cn.lmtoo.ui.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * 
 * 模块：<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月29日<br>
 *          Copyright 2014 XXX有限公司.
 */
@Controller
@RequestMapping("settings")
public class SettingController {
	/**
	 * 设置语言格式，设置过程交由LocaleChangeInterceptor处理
	 * 
	 * @return
	 */
	@RequestMapping("locale")
	public String changeLocale(String returnUrl) {
		return UrlBasedViewResolver.REDIRECT_URL_PREFIX + returnUrl;
	}

	/**
	 * 设置主题格式，设置过程交由ThemeChangeInterceptor处理
	 * 
	 * @param returnUrl
	 * @return
	 */
	@RequestMapping("theme")
	public String changeTheme(String returnUrl) {
		return UrlBasedViewResolver.REDIRECT_URL_PREFIX + returnUrl;
	}
}
