package cn.lmtoo.core.security.domain.event;

import org.springframework.context.ApplicationEvent;

import cn.lmtoo.core.security.domain.UserAccount;

/**
 * 用户账户事件<br>
 * 模块：应用程序事件，继承自spring的事件对象<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月17日 Copyright 2014 XXX有限公司.
 */
public class UserAccountEvent extends ApplicationEvent {
	private UserAccount userAccount;

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public UserAccountEvent(Object source) {
		super(source);
	}

	public UserAccountEvent(Object source, UserAccount userAccount) {
		super(source);
		this.userAccount = userAccount;
	}
}