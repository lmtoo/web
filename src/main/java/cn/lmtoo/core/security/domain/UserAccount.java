/** 
 * Copyright (C), 2014
 * All right reserved.
 */
package cn.lmtoo.core.security.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;
import org.apache.shiro.authc.Account;
import org.apache.shiro.authc.SaltedAuthenticationInfo;
import org.apache.shiro.authc.SimpleAccount;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.StringUtils;

import cn.lmtoo.core.domain.BaseEntity;

/**
 * 模块：自定义的账号类，可以返回用户的任何信息，包括授权信息和角色信息，此类实现了Account，可以从Subject.
 * getPrincipal方法获取此对象<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月13日<br>
 *          Copyright 2014 XXX有限公司.
 */
public class UserAccount extends BaseEntity<Long> implements Account, SaltedAuthenticationInfo {
	private transient PrincipalCollection principalCollection;
	private String username;
	private String password;
	// HashedCredentialsMatcher会用到这个属性
	private String salt;

	private Organization organization;

	private Set<Role> roles;

	/**
	 * Indicates this account is locked. This isn't honored by all
	 * <tt>Realms</tt> but is honored by
	 * {@link org.apache.shiro.realm.SimpleAccountRealm}.
	 */
	private boolean locked;

	/**
	 * Indicates credentials on this account are expired. This isn't honored by
	 * all <tt>Realms</tt> but is honored by
	 * {@link org.apache.shiro.realm.SimpleAccountRealm}.
	 */
	private boolean credentialsExpired;

	public void setRealmName(String realmName) {
		this.principalCollection = new SimplePrincipalCollection(this, realmName);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.shiro.authc.AuthenticationInfo#getPrincipals()
	 */
	@Override
	public PrincipalCollection getPrincipals() {
		return principalCollection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.shiro.authc.AuthenticationInfo#getCredentials()
	 */
	@Override
	public Object getCredentials() {
		return password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.shiro.authz.AuthorizationInfo#getRoles()
	 */
	@Override
	public Collection<String> getRoles() {
		if (roles == null)
			return Collections.emptySet();
		return CollectionUtils.collect(roles, new Transformer() {
			@Override
			public Object transform(Object role) {
				return ((Role) role).getName();
			}
		});
	}

	@Override
	public Collection<String> getStringPermissions() {
		return Collections.emptySet();
	}

	@Override
	public Collection<Permission> getObjectPermissions() {
		return Collections.emptySet();
	}

	protected Organization getOrganization() {
		return organization;
	}

	protected void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public boolean isCredentialsExpired() {
		return credentialsExpired;
	}

	public void setCredentialsExpired(boolean credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}

	/**
	 * Returns <code>true</code> if the specified object is also a
	 * {@link SimpleAccount SimpleAccount} and its {@link #getPrincipals()
	 * principals} are equal to this object's <code>principals</code>,
	 * <code>false</code> otherwise.
	 *
	 * @param o
	 *            the object to test for equality.
	 * @return <code>true</code> if the specified object is also a
	 *         {@link SimpleAccount SimpleAccount} and its
	 *         {@link #getPrincipals() principals} are equal to this object's
	 *         <code>principals</code>, <code>false</code> otherwise.
	 */
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o instanceof UserAccount) {
			UserAccount sa = (UserAccount) o;
			// principal should be unique across the application, so only check
			// this for equality:
			return (getUsername() != null ? getUsername().equals(sa.getUsername()) : sa.getUsername() == null);
		}
		return false;
	}

	/**
	 * Returns the hashcode of the internal {@link #getPrincipals() principals}
	 * instance.
	 *
	 * @return the hashcode of the internal {@link #getPrincipals() principals}
	 *         instance.
	 */
	public int hashCode() {
		return (getUsername() != null ? getUsername().hashCode() : 0);
	}

	/**
	 * Returns {@link #getPrincipals() principals}.toString() if they are not
	 * null, otherwise prints out the string &quot;empty&quot;
	 *
	 * @return the String representation of this Account object.
	 */
	public String toString() {
		return getUsername() != null ? getUsername() : "empty";
	}

	@Override
	public ByteSource getCredentialsSalt() {
		return StringUtils.hasLength(this.salt) ? ByteSource.Util.bytes(this.salt) : null;
	}
}