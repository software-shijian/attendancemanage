package com.attendance.manage.controller;

import java.util.ArrayList;
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
import com.attendance.manage.service.RoleService;

@Scope("prototype")
@Controller
@RequestMapping("/setting/role")
public class RoleController {

	@Autowired
	private RoleService roleServiceImpl;

	@RequestMapping(method = RequestMethod.GET)
	public String getRole(Long id, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Role> roles = new ArrayList<Role>();
		if (id == null) {
			roles = roleServiceImpl.selectAll();
		} else {
			roles.add(roleServiceImpl.selectByPrimaryKey(id));
		}
		model.addAttribute("rows", roles);
		return "/setting/role";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	public String editRole(Role role, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (role == null || role.getId() == null) {
			model.addAttribute("result", 0);
		}
		roleServiceImpl.updateByPrimaryKey(role);
		return "";

	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public String deleteRole(Long id, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (id == null) {
			model.addAttribute("result", 0);
		}
		roleServiceImpl.deleteByPrimaryKey(id);
		return "";

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addRole(Role role, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (role == null) {
			model.addAttribute("result", 0);
		}
		roleServiceImpl.insert(role);
		return "";

	}

}