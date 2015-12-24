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

import com.attendance.manage.model.StuffRole;
import com.attendance.manage.service.RoleService;
import com.attendance.manage.service.StuffRoleService;

@Scope("prototype")
@Controller
@RequestMapping("/setting/stuffRole")
public class StuffRoleController {

	@Autowired
	private StuffRoleService stuffRoleServiceImpl;
	@Autowired
	private RoleService roleServiceImpl;
	@Autowired
	private RoleService stuffServiceImpl;

	@RequestMapping(method = RequestMethod.GET)
	public String getStuffRole(Long id, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<StuffRole> stuffRoles = new ArrayList<StuffRole>();
		if (id == null) {
			stuffRoles = stuffRoleServiceImpl.selectAll();
		} else {
			stuffRoles.add(stuffRoleServiceImpl.selectByPrimaryKey(id));
			return "/setting/stuffRole";
		}

		model.addAttribute("rows", stuffRoles);
		model.addAttribute("stuffs", stuffRoles);
		model.addAttribute("roles", roleServiceImpl.selectAll());
		return "/setting/stuffRole";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	public String editStuffRole(StuffRole stuffRole, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (stuffRole == null || stuffRole.getId() == null) {
			model.addAttribute("result", 0);
		}
		stuffRoleServiceImpl.updateByPrimaryKey(stuffRole);
		return "";

	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public String deleteStuffRole(Long id, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (id == null) {
			model.addAttribute("result", 0);
		}
		stuffRoleServiceImpl.deleteByPrimaryKey(id);
		return "";

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addStuffRole(StuffRole stuffRole, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (stuffRole == null) {
			model.addAttribute("result", 0);
		}
		stuffRoleServiceImpl.insert(stuffRole);
		return "";

	}

}