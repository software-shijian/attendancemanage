/*
0 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.attendance.manage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.attendance.manage.model.Stuff;
import com.attendance.manage.service.StuffService;
import com.attendance.manage.util.EmailUtils;
import com.attendance.manage.util.WebUtils;

/**
 * Controller - 会员登录
 * 
 * @author SHOP++ Team
 * @version 3.0
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private StuffService stuffService;

	/**
	 * 登录检测
	 */
	// @RequestMapping(value = "/check", method = RequestMethod.GET)
	// public @ResponseBody
	// Boolean check() {
	// return stuffService.isAuthenticated();
	// }
	/**
	 * 登录页面
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(String redirectUrl, HttpServletRequest request,
			Model model, HttpSession session) {
		return "/login/index";
	}

	/**
	 * 登录提交
	 */
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String submit(String username, String password,
			HttpServletRequest request, HttpServletResponse response,
			Model model, HttpSession session) {
		System.out.println("in con");

		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			model.addAttribute("massage", "用户名或密码未输入！");
			return "";
		}
		Stuff stuff;

		stuff = stuffService.findByUsername(username);

		if (stuff == null) {
			model.addAttribute("message", "用户名不存在！");
			return "";
		}

		if (!password.equals(stuff.getPassword())) {

			model.addAttribute("message", "密码错误！");
			return "";
		}
		SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());
		// 登录后存放进shiro token
		UsernamePasswordToken token = new UsernamePasswordToken(
				stuff.getUsername(), stuff.getPassword());
		Subject subject = SecurityUtils.getSubject();
		subject.login(token);
		WebUtils.addCookie(request, response, Stuff.USERNAME_COOKIE_NAME,
				username);
		session.setAttribute("username", username);
		model.addAttribute("massage", "success");
		return "";
	}

	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public String resetPassword(String username, String email,
			HttpServletRequest request, HttpServletResponse response,
			Model model, HttpSession session) {
		System.out.println("in con");

		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(email)) {
			model.addAttribute("massage", "用户名或邮箱未输入！");
			return "";
		}
		Stuff stuff;

		stuff = stuffService.findByUsername(username);

		if (stuff == null) {
			model.addAttribute("message", "用户名不存在！");
			return "";
		}

		if (!email.equals(stuff.getEmail())) {

			model.addAttribute("message", "邮箱错误！");
			return "";
		}
		EmailUtils.sendResetEmail(email);
		model.addAttribute("message", "succsess");
		return "";
	}
}