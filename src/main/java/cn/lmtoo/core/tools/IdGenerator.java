/** 
 * Copyright (C), 2014
 * All right reserved.
 */
package cn.lmtoo.core.tools;

import java.io.Serializable;

/**
 * 模块：id生成器<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月11日<br>
 *          Copyright 2014 XXX有限公司.
 */
public interface IdGenerator {
	/**
	 * 要生成id的对象
	 * 
	 * @param target
	 * @return
	 */
	Serializable generateId(Object target);
}
