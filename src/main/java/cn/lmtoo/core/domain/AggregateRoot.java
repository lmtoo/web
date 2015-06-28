package cn.lmtoo.core.domain;

import java.io.Serializable;

/**
 * 聚合通常为一个实体类型 模块：<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年7月16日 Copyright 2014 XXX有限公司.
 */
public interface AggregateRoot<T extends Serializable> extends Entity<T> {
}