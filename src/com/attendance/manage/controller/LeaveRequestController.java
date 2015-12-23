package com.attendance.manage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.attendance.manage.service.CheckInfoService;

@Scope("prototype")
@Controller
@RequestMapping("/nomal/leavareq")
public class LeaveRequestController {
	@Autowired
	private CheckInfoService checkInfoServiceImpl;

	/**
	 * 测试方法,HelloWord
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getProducts(Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		model.addAttribute("name", checkInfoServiceImpl.selectAll().get(0)
				.getCheckTime());
		return "product/list";

	}

}