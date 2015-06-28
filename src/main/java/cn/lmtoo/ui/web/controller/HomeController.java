package cn.lmtoo.ui.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 模块：主页<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月20日<br>
 *          Copyright 2014 XXX有限公司.
 */
@Controller
@RequestMapping("home")
public class HomeController {
	@RequestMapping("index")
	public String index() {
		return "home";
	}
}
