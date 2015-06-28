/** 
 * Copyright (C), 2014
 * All right reserved.
 */
package cn.lmtoo.core.security.extend.authc;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 模块：<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月13日<br>
 *          Copyright 2014 XXX有限公司.
 */
public class CaptchaException extends AuthenticationException {

	/**
	 * Creates a new AccountException.
	 */
	public CaptchaException() {
		super();
	}

	/**
	 * Constructs a new AccountException.
	 *
	 * @param message
	 *            the reason for the exception
	 */
	public CaptchaException(String message) {
		super(message);
	}

	/**
	 * Constructs a new AccountException.
	 *
	 * @param cause
	 *            the underlying Throwable that caused this exception to be
	 *            thrown.
	 */
	public CaptchaException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructs a new AccountException.
	 *
	 * @param message
	 *            the reason for the exception
	 * @param cause
	 *            the underlying Throwable that caused this exception to be
	 *            thrown.
	 */
	public CaptchaException(String message, Throwable cause) {
		super(message, cause);
	}
}