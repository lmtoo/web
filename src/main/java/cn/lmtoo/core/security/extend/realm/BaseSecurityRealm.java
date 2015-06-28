/** 
 * Copyright (C), 2014
 * All right reserved.
 */
package cn.lmtoo.core.security.extend.realm;

import java.util.Collection;
import java.util.Collections;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.lmtoo.core.security.domain.UserAccount;

/**
 * 模块：<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月13日<br>
 *          Copyright 2014 XXX有限公司.
 */
public abstract class BaseSecurityRealm extends AuthorizingRealm implements RolePermissionResolver {
	/**
	 * The default suffix appended to the realm name for caching
	 * AuthorizationInfo instances.
	 */
	private static final String DEFAULT_PERMISSION_IN_ROLE_CACHE_SUFFIX = ".permissionInRoleCache";

	private String permissionInRoleCacheName;

	private boolean permissionInRoleCachingEnabled;

	private Cache<Object, Collection<Permission>> permissionInRoleCache;

	/**
	 * @return the permissionInRoleCache
	 */
	public Cache<Object, Collection<Permission>> getPermissionInRoleCache() {
		return permissionInRoleCache;
	}

	/**
	 * @param permissionInRoleCache
	 *            the permissionInRoleCache to set
	 */
	public void setPermissionInRoleCache(Cache<Object, Collection<Permission>> permissionInRoleCache) {
		this.permissionInRoleCache = permissionInRoleCache;
	}

	/**
	 * @return the permissionInRoleCachingEnabled
	 */
	public boolean isPermissionInRoleCachingEnabled() {
		return isCachingEnabled() && permissionInRoleCachingEnabled;
	}

	/**
	 * @param permissionInRoleCachingEnabled
	 *            the permissionInRoleCachingEnabled to set
	 */
	public void setPermissionInRoleCachingEnabled(boolean permissionInRoleCachingEnabled) {
		this.permissionInRoleCachingEnabled = permissionInRoleCachingEnabled;
		if (permissionInRoleCachingEnabled) {
			setCachingEnabled(permissionInRoleCachingEnabled);
		}
	}

	public BaseSecurityRealm() {
		super();
		this.permissionInRoleCacheName = getClass().getName() + DEFAULT_PERMISSION_IN_ROLE_CACHE_SUFFIX;
		this.permissionInRoleCachingEnabled = true;
		if (getRolePermissionResolver() == null) {
			setRolePermissionResolver(this);
		}
	}

	public void setName(String name) {
		super.setName(name);
		String permissionInRoleCacheName = this.permissionInRoleCacheName;
		if (permissionInRoleCacheName != null && permissionInRoleCacheName.startsWith(getClass().getName())) {
			// get rid of the default class-name based cache name. Create a more
			// meaningful one
			// based on the application-unique Realm name:
			this.permissionInRoleCacheName = name + DEFAULT_PERMISSION_IN_ROLE_CACHE_SUFFIX;
		}
	}

	protected Object getPermissionInRoleCacheKey(String roleName) {
		return roleName;
	}

	/*
	 * 实现rolePermissionResolver接口，将角色名称转换成权限
	 * 
	 * @see org.apache.shiro.authz.permission.RolePermissionResolver#
	 * resolvePermissionsInRole(java.lang.String)
	 */
	@Override
	public Collection<Permission> resolvePermissionsInRole(String roleString) {
		if (roleString == null)
			return Collections.emptyList();

		Collection<Permission> permissions = null;

		Cache<Object, Collection<Permission>> permissionInRoleCache = getPermissionInRoleCache();
		if (permissionInRoleCache != null) {
			Object key = getPermissionInRoleCacheKey(roleString);
			permissions = permissionInRoleCache.get(key);
		}

		if (permissions == null) {
			permissions = findPermissionsByRoleName(roleString);
			Object key = getPermissionInRoleCacheKey(roleString);
			permissionInRoleCache.put(key, permissions);
		}

		return permissions;
	}

	protected abstract Collection<Permission> findPermissionsByRoleName(String roleName);

	/*
	 * 默认用用户名作为key缓存账号
	 * 
	 * @see
	 * org.apache.shiro.realm.AuthenticatingRealm#getAuthenticationCacheKey(
	 * org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected Object getAuthenticationCacheKey(AuthenticationToken token) {
		return super.getAuthenticationCacheKey(token);
	}

	/*
	 * 此处要与以上保持一致，获取用户名来用作key
	 * 
	 * @see
	 * org.apache.shiro.realm.AuthenticatingRealm#getAuthenticationCacheKey(
	 * org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected Object getAuthenticationCacheKey(PrincipalCollection principals) {
		UserAccount account = (UserAccount) getAvailablePrincipal(principals);
		return account.getUsername();
	}

	/*
	 * 此处要与以上保持一致，获取用户名来用作key
	 * 
	 * @see
	 * org.apache.shiro.realm.AuthorizingRealm#getAuthorizationCacheKey(org.
	 * apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected Object getAuthorizationCacheKey(PrincipalCollection principals) {
		return getAuthenticationCacheKey(principals);
	}

	/**
	 * 账号信息更新后要清除缓存
	 * 
	 * @param userAccount
	 */
	protected void afterAccountChanged(UserAccount userAccount) {
		clearCache(userAccount.getPrincipals());
	}

	/*
	 * 获取用户权限信息
	 * 
	 * @see
	 * org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache
	 * .shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Object principal = getAvailablePrincipal(principals);
		if (principal instanceof UserAccount) {
			String username = ((UserAccount) principal).getUsername();
			return findUserAccountByUsername(username);
		}
		return null;
	}

	/*
	 * 获取用户验证信息
	 * 
	 * @see
	 * org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org
	 * .apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		return getUserAccountWithRealmName(username);
	}

	/**
	 * 可以自定义以构造方法的方式创建用户账号，或者以默认构造方法创建用户账号，但必须都要设置好realmName属性<br>
	 * 获取验证信息和获取权限信息都是用该方法，以确保设置好realmName属性
	 * 
	 * @param username
	 * @return
	 */
	private UserAccount getUserAccountWithRealmName(String username) {
		UserAccount userAccount = findUserAccountByUsername(username);
		userAccount.setRealmName(getName());
		return userAccount;
	}

	/**
	 * 根据用户名查找用户，包括角色和权限信息
	 * 
	 * @param username
	 * @return
	 */
	protected abstract UserAccount findUserAccountByUsername(String username);
}