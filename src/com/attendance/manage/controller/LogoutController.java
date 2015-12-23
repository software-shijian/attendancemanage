/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.attendance.manage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.attendance.manage.model.Stuff;
import com.attendance.manage.util.WebUtils;

/**
 * Controller - 会员注销
 * 
 * @author SHOP++ Team
 * @version 3.0
 */
@Scope("prototype")
@Controller
@RequestMapping("/logout")
public class LogoutController {

	/**
	 * 注销
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String index(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		SecurityUtils.getSubject().logout();
		// session.removeAttribute("username");
		WebUtils.removeCookie(request, response, Stuff.USERNAME_COOKIE_NAME);
		return "redirect:/";
	}

}