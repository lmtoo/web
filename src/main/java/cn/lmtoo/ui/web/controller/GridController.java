package cn.lmtoo.ui.web.controller;

import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;

/**
 * 
 * 模块：<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月21日<br>
 *          Copyright 2014 XXX有限公司.
 */
@Controller
@RequestMapping("snippet")
public class GridController {
	@Autowired
	private LocaleResolver localeResolver;

	@RequestMapping("grid")
	public String grid(Locale locale, Map<String, Object> model) {
		System.out.println(locale);
		model.put("locale", locale);
		return "snippets/grid";
	}

	@RequestMapping("nav")
	public String nav() {
		return "snippets/nav";
	}

	@RequestMapping("panel")
	public String panel() {
		return "snippets/panel";
	}
}
