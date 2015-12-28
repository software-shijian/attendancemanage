package com.attendance.manage.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.attendance.manage.model.Stuff;
import com.attendance.manage.model.StuffRole;
import com.attendance.manage.service.RoleService;
import com.attendance.manage.service.StuffRoleService;
import com.attendance.manage.service.StuffService;

@Scope("prototype")
@Controller
@RequestMapping("/setting/stuffRole")
public class StuffRoleController {

	@Autowired
	private StuffRoleService stuffRoleServiceImpl;
	@Autowired
	private RoleService roleServiceImpl;
	@Autowired
	private StuffService stuffServiceImpl;

	@RequestMapping(method = RequestMethod.GET)
	public String getStuffRole(Long id, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<StuffRole> stuffRoles = new ArrayList<StuffRole>();
		List<Stuff> stuffs;
		if (id == null) {
			stuffRoles = stuffRoleServiceImpl.selectAll();
			stuffs = stuffServiceImpl.selectSortedAll();
		} else {
			stuffRoles.add(stuffRoleServiceImpl.selectByPrimaryKey(id));
			return "/setting/stuffRole";
		}

		model.addAttribute("rows", stuffRoles);
		model.addAttribute("stuffs", stuffs);
		model.addAttribute("roles", roleServiceImpl.selectAll());
		return "/setting/stuffRole";
	}

	@RequestMapping(value = "/put", method = RequestMethod.PUT)
	public String editStuffRole(StuffRole stuffRole, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (stuffRole == null || stuffRole.getStuffId() == null
				|| stuffRole.getRole() == null) {

		} else {
			List<StuffRole> list = stuffRoleServiceImpl.selectAll();
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				StuffRole stuffRole2 = (StuffRole) iterator.next();
				if (stuffRole2.getId() == stuffRole.getId()
						&& stuffRole2.getRole() == stuffRole.getRole()) {
					model.addAttribute("result", 0);
					return "";
				}
			}
		}
		StuffRole stuffRole2 = stuffRoleServiceImpl
				.selectByPrimaryKey(stuffRole.getId());
		stuffRole.setCreateDate(stuffRole2.getCreateDate());
		stuffRole.setModifyDate(new Date());
		stuffRoleServiceImpl.updateByPrimaryKey(stuffRole);
		stuffRoleServiceImpl.updateByPrimaryKey(stuffRole);
		model.addAttribute("result", 1);
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
		model.addAttribute("result", 1);
		return "";

	}

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String addStuffRole(StuffRole stuffRole, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (stuffRole == null || stuffRole.getStuffId() == null
				|| stuffRole.getRole() == null) {

		} else {
			List<StuffRole> list = stuffRoleServiceImpl.selectAll();
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				StuffRole stuffRole2 = (StuffRole) iterator.next();
				if (stuffRole2.getId() == stuffRole.getId()
						&& stuffRole2.getRole() == stuffRole.getRole()) {
					model.addAttribute("result", 0);
					return "";
				}
			}
		}
		stuffRole.setCreateDate(new Date());
		stuffRole.setModifyDate(new Date());
		stuffRoleServiceImpl.insert(stuffRole);
		model.addAttribute("result", 1);
		return "";

	}

}