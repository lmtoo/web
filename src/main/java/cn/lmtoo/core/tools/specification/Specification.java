package cn.lmtoo.core.tools.specification;

/**
 * 规格对象，用来评估对象是否满足该规格<br>
 * 模块：<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年7月18日 Copyright 2014 XXX有限公司.
 */
public interface Specification<T> {

	/**
	 * 该对象是否满足该规格
	 * 
	 * @param target
	 * @return true则该对象满足该规格，false则该对象不满足该规格
	 */
	boolean isSatisfiedBy(T target);
}