/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.attendance.manage.security;

import java.util.Date;
import java.util.List;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.attendance.manage.model.Stuff;
import com.attendance.manage.service.StuffService;

/**
 * 权限认证
 * 
 * @author SHOP++ Team
 * @version 3.0
 */
@Component("authenticationRealm")
public class AuthenticationRealm extends AuthorizingRealm {

	@Autowired
	private StuffService stuffServiceImpl;

	/**
	 * 获取认证信息
	 * 
	 * @param token
	 *            令牌
	 * @return 认证信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			org.apache.shiro.authc.AuthenticationToken token) {
		System.out.println("in aut");
		UsernamePasswordToken authenticationToken = (UsernamePasswordToken) token;
		String username = authenticationToken.getUsername();
		String password = new String(authenticationToken.getPassword());
		if (username != null && password != null) {
			Stuff admin = stuffServiceImpl.findByUsername(username);
			if (admin == null) {
				throw new UnknownAccountException();
			}

			if (!password.equals(admin.getPassword())) {
				int loginFailureCount = admin.getLoginFailureCount() + 1;
				admin.setLoginFailureCount(loginFailureCount);
				stuffServiceImpl.updateByPrimaryKey(admin);
				throw new IncorrectCredentialsException();
			}
			// md5算法
			// if (!DigestUtils.md5Hex(password).equals(admin.getPassword())) {
			// int loginFailureCount = admin.getLoginFailureCount() + 1;
			// admin.setLoginFailureCount(loginFailureCount);
			// adminService.updateByPrimaryKey(admin);
			// throw new IncorrectCredentialsException();
			// }
			admin.setLoginDate(new Date());
			admin.setLoginFailureCount(0);
			stuffServiceImpl.updateByPrimaryKey(admin);
			return new SimpleAuthenticationInfo(username, password, getName());

		}
		throw new UnknownAccountException();
	}

	/**
	 * 获取授权信息
	 * 
	 * @param principals
	 *            principals
	 * @return 授权信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		String username = String.valueOf(principals.getPrimaryPrincipal());
		final Stuff user = stuffServiceImpl.findByUsername(username);
		if (user != null) {
			List<String> authorities = stuffServiceImpl.findAuthorities(user
					.getId());
			if (authorities != null) {
				SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
				authorizationInfo.addStringPermissions(authorities);
				return authorizationInfo;
			}
		}
		return null;
	}

}