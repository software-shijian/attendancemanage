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

import com.attendance.manage.model.RoleAuthority;
import com.attendance.manage.service.RoleAuthorityService;
import com.attendance.manage.service.RoleService;

@Scope("prototype")
@Controller
@RequestMapping("/setting/roleAuthority")
public class AuthorityController {

	@Autowired
	private RoleAuthorityService roleAuthorityServiceImpl;
	@Autowired
	private RoleService roleServiceImpl;

	@RequestMapping(method = RequestMethod.GET)
	public String getRoleAuthority(Long id, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<RoleAuthority> roleAuthoritys = new ArrayList<RoleAuthority>();
		if (id == null) {
			roleAuthoritys = roleAuthorityServiceImpl.selectAll();
		} else {
			roleAuthoritys.add(roleAuthorityServiceImpl.selectByPrimaryKey(id));
			return "/setting/roleAuthority";
		}
		model.addAttribute("rows", roleAuthoritys);
		model.addAttribute("roles", roleServiceImpl.selectAll());
		return "/setting/roleAuthority";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	public String editRoleAuthority(RoleAuthority roleAuthority, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (roleAuthority == null || roleAuthority.getId() == null) {
			model.addAttribute("result", 0);
		}
		roleAuthorityServiceImpl.updateByPrimaryKey(roleAuthority);
		return "";

	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public String deleteRoleAuthority(Long id, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (id == null) {
			model.addAttribute("result", 0);
		}
		roleAuthorityServiceImpl.deleteByPrimaryKey(id);
		return "";

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addRoleAuthority(RoleAuthority roleAuthority, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (roleAuthority == null) {
			model.addAttribute("result", 0);
		}
		roleAuthorityServiceImpl.insert(roleAuthority);
		return "";

	}

}