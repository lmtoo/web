package cn.lmtoo.core.security.domain;

import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.permission.DomainPermission;

import cn.lmtoo.core.tools.Strings;

/**
 * 资源权限<br>
 * 模块：<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月18日 Copyright 2014 XXX有限公司.
 */
public class ResourcePermission extends DomainPermission {
	private Resource resource;

	private Long id;

	private int version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
		setDomain(resource.getName());
	}

	@Override
	public void setTargets(Set<String> targets) {
		super.setTargets(targets);
	}

	@Override
	protected String getDomain(Class<? extends DomainPermission> clazz) {
		return resource == null ? super.getDomain(clazz) : resource.getName();
	}

	@Override
	public void setActions(Set<String> actions) {
		actions.retainAll(resource.getActions());
		super.setActions(actions);
	}

	public void setActionStr(String actionStr) {
		if (StringUtils.isNotBlank(actionStr)) {
			setActions(Strings.splitToSet(actionStr, SUBPART_DIVIDER_TOKEN));
		}
	}

	public void setTargetStr(String targetStr) {
		if (StringUtils.isNotBlank(targetStr)) {
			setActions(Strings.splitToSet(targetStr, SUBPART_DIVIDER_TOKEN));
		}
	}

	public String getActionStr() {
		if (CollectionUtils.isNotEmpty(getActions())) {
			return StringUtils.join(getActions(), SUBPART_DIVIDER_TOKEN);
		}
		return null;
	}

	public String getTargetStr() {
		if (CollectionUtils.isNotEmpty(getTargets())) {
			return StringUtils.join(getTargets(), SUBPART_DIVIDER_TOKEN);
		}
		return null;
	}
}
