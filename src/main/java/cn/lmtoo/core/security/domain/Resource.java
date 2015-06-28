package cn.lmtoo.core.security.domain;

import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import cn.lmtoo.core.domain.BaseEntity;
import cn.lmtoo.core.tools.Strings;

import com.google.common.collect.Sets;

/**
 * 可操作资源<br>
 * 模块：<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月18日 Copyright 2014 XXX有限公司.
 */
public abstract class Resource extends BaseEntity<Long> {
	public static final String ACTION_DIVIDER_TOKEN = ",";
	/**
	 * 资源名称
	 */
	private String name;

	/**
	 * 该资源所有可执行的操作
	 */
	private Set<String> actions = Sets.newHashSet();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getActions() {
		return actions;
	}

	public void addActions(Set<String> actions) {
		this.actions.addAll(actions);
	}

	public void addAction(String action) {
		this.actions.add(action);
	}

	public void setActions(Set<String> actions) {
		this.actions.clear();
		this.actions = actions;
	}

	public void setActionStr(String actionStr) {
		if (StringUtils.isNotBlank(actionStr)) {
			this.actions = Strings.splitToSet(actionStr, ACTION_DIVIDER_TOKEN);
		}
	}

	public String getActionStr() {
		if (CollectionUtils.isNotEmpty(getActions())) {
			return StringUtils.join(getActions(), ACTION_DIVIDER_TOKEN);
		}
		return null;
	}
}