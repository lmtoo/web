package cn.lmtoo.ui.web.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 
 * 模块：控制器基类<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月31日<br>
 *          Copyright 2014 XXX有限公司.
 */
public class BaseController {
	@ExceptionHandler(IOException.class)
	public ResponseEntity<String> handleIOException(IOException ex) {
		// prepare responseEntity
		return null;
	}
}
