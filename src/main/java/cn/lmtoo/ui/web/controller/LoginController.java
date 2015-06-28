package cn.lmtoo.ui.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 系统登录<br>
 * 模块：<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月20日<br>
 *          Copyright 2014 XXX有限公司.
 */
@Controller
@RequestMapping("login")
public class LoginController {
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index() {
		return "login";
	}
}
