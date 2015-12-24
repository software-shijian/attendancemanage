package com.attendance.manage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.attendance.manage.service.CheckInfoService;
import com.attendance.manage.service.LeaveRequestService;

@Scope("prototype")
@Controller
@RequestMapping("/nomal/leavareq")
public class LeaveRequestController {
	@Autowired
	private CheckInfoService checkInfoServiceImpl;
	@Autowired
	private LeaveRequestService leaveRequestServiceImpl;

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
	
	/**
	 * 跳转到新建申请页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/forwordApply", method = RequestMethod.GET)
	public String forwordApply(Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "/apply/newApply";

	}
	
	/**
	 * 跳转到我的申请页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/forwordMyApply", method = RequestMethod.GET)
	public String forwordMyApply(Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "/apply/myApply";

	}
	/**
	 * 跳转到我的审批页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/forwordMyApprove", method = RequestMethod.GET)
	public String forwordMyApprove(Model model, HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws Exception {
		//获取ID
		model.addAttribute("approveList", leaveRequestServiceImpl.selectApproveByID(1));
		return "/apply/myApprove";

	}
	

	

}