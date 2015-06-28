package cn.lmtoo.core.security.domain;

import java.util.Set;

import com.google.common.collect.Sets;

/**
 * tree模型<br>
 * 模块：<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月18日 Copyright 2014 XXX有限公司.
 */
public class Module extends Resource {
	private Module parent;
	private String title;
	private String link;
	private Set<Module> children = Sets.newHashSet();

	public boolean isRoot() {
		return parent == null;
	}

	public boolean isLeaf() {
		return children == null || children.isEmpty();
	}

	public void addChild(Module child) {
		children.add(child);
	}

	public void removeChild(Module child) {
		children.remove(child);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Module getParent() {
		return parent;
	}

	public void setParent(Module parent) {
		this.parent = parent;
	}

	public Set<Module> getChildren() {
		return children;
	}

	public void accept(ModuleVisitor visitor) {
		visitor.visit(this);
	}
}