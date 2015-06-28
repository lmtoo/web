package cn.lmtoo.core.domain;

import java.io.Serializable;

/**
 * 实体类基类，包括了版本信息<br>
 * 模块：<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月17日 Copyright 2014 XXX有限公司.
 */
public interface Entity<T extends Serializable> extends Serializable {
	 T getId();

	 void setId(T id);
}