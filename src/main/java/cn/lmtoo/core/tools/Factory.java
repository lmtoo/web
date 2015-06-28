package cn.lmtoo.core.tools;

import cn.lmtoo.core.domain.Entity;

/**
 * 聚合工厂
 * 模块：<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年7月15日
 * Copyright 2014 XXX有限公司.
 */
public interface Factory<T extends Entity> extends IdGenerator{
	/**
	 * 创建一个新的聚合对象
	 * @return
	 */
	T newInstance();
	
	/**
	 * 从其他资源重建对象
	 * @return
	 */
	T rebuild();
}