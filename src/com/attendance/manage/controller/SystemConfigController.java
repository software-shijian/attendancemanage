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

import com.attendance.manage.model.SystemConfig;
import com.attendance.manage.service.SystemConfigService;

@Scope("prototype")
@Controller
@RequestMapping("/setting/systemConfig")
public class SystemConfigController {

	@Autowired
	private SystemConfigService systemConfigServiceImpl;

	@RequestMapping(method = RequestMethod.GET)
	public String getSystemConfig(String key, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<SystemConfig> systemConfigs = new ArrayList<SystemConfig>();
		if (key == null || key.equals("")) {
			systemConfigs = systemConfigServiceImpl.selectAll();
		} else {
			systemConfigs.add(systemConfigServiceImpl.selectByKey(key));
		}
		model.addAttribute("rows", systemConfigs);
		return "/setting/systemConfig";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	public String editSystemConfig(String key, SystemConfig systemConfig,
			Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (key == null) {
			model.addAttribute("result", 0);
		}
		systemConfigServiceImpl.updateByKey(systemConfig);
		return "";

	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public String deleteSystemConfig(String key, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (key == null) {
			model.addAttribute("result", 0);
		}
		systemConfigServiceImpl.deleteByKey(key);
		return "";

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addSystemConfig(SystemConfig systemConfig, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (systemConfig == null) {
			model.addAttribute("result", 0);
		}
		systemConfigServiceImpl.insert(systemConfig);
		return "";

	}

}