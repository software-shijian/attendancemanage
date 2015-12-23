package com.attendance.manage.listener;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig implements ApplicationContextAware {
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		try {
			// 组装realm到securityManager中
			final Realm authenticationRealm = (Realm) applicationContext
					.getBean("authenticationRealm");
			final DefaultWebSecurityManager sm = (DefaultWebSecurityManager) applicationContext
					.getBean("securityManager");
			sm.setRealm(authenticationRealm);
		} catch (Exception e) {
			throw new Error("Critical system error", e);
		}
	}
}