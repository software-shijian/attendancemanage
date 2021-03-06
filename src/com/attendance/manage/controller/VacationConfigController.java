package com.attendance.manage.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.attendance.manage.model.VacationInfo;
import com.attendance.manage.service.VacationInfoService;

@Scope("prototype")
@Controller
@RequestMapping("/setting/vacationInfo")
public class VacationConfigController {

	@Autowired
	private VacationInfoService vacationInfoServiceImpl;

	@RequestMapping(method = RequestMethod.GET)
	public String getVacationInfo(Long id, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<VacationInfo> vacationInfos = new ArrayList<VacationInfo>();
		if (id == null) {
			vacationInfos = vacationInfoServiceImpl.selectAll();
		} else {
			vacationInfos.add(vacationInfoServiceImpl.selectByPrimaryKey(id));
		}
		model.addAttribute("rows", vacationInfos);
		return "/setting/vacationInfo";
	}

	@RequestMapping(value = "/put", method = RequestMethod.PUT)
	public String editVacationInfo(VacationInfo vacationInfo, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (vacationInfo == null || vacationInfo.getId() == null) {
			model.addAttribute("result", 0);
		} else {
			VacationInfo vacationInfo2 = vacationInfoServiceImpl
					.selectByPrimaryKey(vacationInfo.getId());
			vacationInfo.setCreateDate(vacationInfo2.getCreateDate());
			vacationInfo.setModifyDate(new Date());
			vacationInfoServiceImpl.updateByPrimaryKey(vacationInfo);
			model.addAttribute("result", 1);
		}

		return "";

	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public String deleteVacationInfo(Long id, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (id == null) {
			model.addAttribute("result", 0);
		} else {
			vacationInfoServiceImpl.deleteByPrimaryKey(id);
			model.addAttribute("result", 1);
		}

		return "";

	}

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String addVacationInfo(VacationInfo vacationInfo, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (vacationInfo == null) {
			model.addAttribute("result", 0);
		} else {
			vacationInfo.setCreateDate(new Date());
			vacationInfo.setModifyDate(new Date());
			vacationInfoServiceImpl.insert(vacationInfo);
			model.addAttribute("result", 1);
		}

		return "";

	}

}