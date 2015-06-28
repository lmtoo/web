package cn.lmtoo.ui.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * 模块：<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月27日<br>
 *          Copyright 2014 XXX有限公司.
 */
@RestController
@RequestMapping("rest")
public class TestRestController {

	@RequestMapping("string")
	public String string() {
		return "string-ddd";
	}
}
