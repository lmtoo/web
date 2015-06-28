package cn.lmtoo.core.security.domain;

import java.util.Set;

import cn.lmtoo.core.domain.BaseEntity;

import com.google.common.collect.Sets;

/**
 * 组织<br>
 * 模块：<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月18日 Copyright 2014 XXX有限公司.
 */
public class Organization extends BaseEntity<Long> {
	private static final long serialVersionUID = 1L;
	private Organization parent;
	private Set<Organization> children = Sets.newHashSet();

	private String name;
	/**
	 * 是否为管理组织
	 */
	private boolean admin;

	public boolean isRoot() {
		return parent == null;
	}

	public boolean isLeaf() {
		return children == null || children.isEmpty();
	}

	public void addChild(Organization child) {
		children.add(child);
	}

	public void removeChild(Organization child) {
		children.remove(child);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Organization getParent() {
		return parent;
	}

	public void setParent(Organization parent) {
		this.parent = parent;
	}

	public Set<Organization> getChildren() {
		return children;
	}

	public void setChildren(Set<Organization> children) {
		this.children = children;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}