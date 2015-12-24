package com.attendance.manage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.attendance.manage.model.Role;
import com.attendance.manage.service.CheckInfoService;
import com.attendance.manage.service.RoleService;

@Scope("prototype")
@Controller
@RequestMapping("/setting")
public class SystemConfigController {
	@Autowired
	private CheckInfoService checkInfoServiceImpl;
	@Autowired
	private RoleService roleServiceImpl;

	/**
	 * 测试方法,HelloWord
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/role", method = RequestMethod.GET)
	public String getProducts(Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Role> roles = roleServiceImpl.selectAll();
		model.addAttribute("total", roles.size());
		model.addAttribute("rows", roles);
		return "/setting/role";

	}

}