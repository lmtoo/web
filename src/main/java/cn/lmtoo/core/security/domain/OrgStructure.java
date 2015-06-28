package cn.lmtoo.core.security.domain;

import java.util.Set;

import cn.lmtoo.core.domain.BaseEntity;

/**
 * 组织结构<br>
 * 模块：<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年7月9日 Copyright 2014 XXX有限公司.
 */
public class OrgStructure extends BaseEntity<Long>  {
	private Organization parent;
	private Set<Organization> children;
	private OrgStructureType type;

	protected Organization getParent() {
		return parent;
	}

	protected void setParent(Organization parent) {
		this.parent = parent;
	}

	protected Set<Organization> getChildren() {
		return children;
	}

	protected void setChildren(Set<Organization> children) {
		this.children = children;
	}

	protected OrgStructureType getType() {
		return type;
	}

	protected void setType(OrgStructureType type) {
		this.type = type;
	}
}