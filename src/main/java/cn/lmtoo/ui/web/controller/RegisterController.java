package cn.lmtoo.ui.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.lmtoo.core.security.application.UserService;
import cn.lmtoo.core.security.domain.UserAccount;

/**
 * 用户注册控制器<br>
 * 模块：<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月17日 Copyright 2014 XXX有限公司.
 */
@Controller
@RequestMapping("register")
public class RegisterController {
	@Autowired
	private UserService userService;

	@RequestMapping("index")
	public String toIndex() {
		return "register";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(UserAccount userAccount) {
		userService.register(userAccount);
		return "success";
	}
}